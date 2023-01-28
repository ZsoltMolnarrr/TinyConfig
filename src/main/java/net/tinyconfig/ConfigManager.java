package net.tinyconfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class ConfigManager<Config> {
    static final Logger LOGGER = LoggerFactory.getLogger("tiny-config");

    public Config value;
    public String configName;
    public String directory;
    public boolean isLoggingEnabled = false;
    public boolean sanitize = false;
    public Function<Config, Boolean> validator;
    public Function<Config, Config> constraint;

    public ConfigManager(String configName, Config defaultConfig) {
        this.configName = configName;
        this.value = defaultConfig;
    }

    public void refresh() {
        var filePath = getConfigFilePath();
        load();
        if (sanitize || !Files.exists(filePath)) {
            save();
        }
    }

    public void load() {
        var filePath = getConfigFilePath();
        try {
            var gson = new Gson();
            if (Files.exists(filePath)) {
                // Read
                Reader reader = Files.newBufferedReader(filePath);
                var newValue = (Config) gson.fromJson(reader, value.getClass());
                // Validate
                boolean isValid = validator == null || validator.apply(newValue);
                if (isValid) {
                    if (constraint != null) {
                        newValue = constraint.apply(newValue);
                    }
                    value = newValue;
                }
                reader.close();
            }
        } catch (Exception e) {
            if (isLoggingEnabled) {
                LOGGER.error("Failed loading " + configName + " config: " + e.getMessage());
            }
        }
    }

    public void save() {
        var config = value;
        var filePath = getConfigFilePath();
        Path configDir = PlatformHelper.getConfigDir();

        try {
            if (directory != null && !directory.isEmpty()) {
                var directoryPath = configDir.resolve(directory);
                Files.createDirectories(directoryPath);
            }
            var prettyGson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(filePath);
            writer.write(prettyGson.toJson(config));
            writer.close();
            if (isLoggingEnabled) {
                var gson = new Gson();
                LOGGER.info(configName + " config written: " + gson.toJson(config));
            }
        } catch (Exception e) {
            if (isLoggingEnabled) {
                LOGGER.error("Failed writing " + configName + " config: " + e.getMessage());
            }
        }
    }

    private Path getConfigFilePath() {
        var configFilePath = configName + ".json";
        if (directory != null && !directory.isEmpty()) {
            configFilePath = directory + "/" + configFilePath;
        }
        Path configDir = PlatformHelper.getConfigDir();
        return configDir.resolve(configFilePath);
    }

    public Builder builder() {
        return new Builder(this);
    }

    public class Builder {
        ConfigManager<Config> manager;
        Builder(ConfigManager<Config> manager) {
            this.manager = manager;
        }

        public Builder enableLogging(boolean enable) {
            manager.isLoggingEnabled = enable;
            return this;
        }

        public Builder setDirectory(String directory) {
            manager.directory = directory;
            return this;
        }

        public Builder sanitize(boolean sanitize) {
            manager.sanitize = sanitize;
            return this;
        }

        public Builder validate(Function<Config, Boolean> validator) {
            manager.validator = validator;
            return this;
        }

        public Builder constrain(Function<Config, Config> constraint) {
            manager.constraint = constraint;
            return this;
        }

        public ConfigManager<Config> build() {
            return manager;
        }
    }
}
