package net.tinyconfig;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class FabricHelper {
    static Path getConfigDir() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
