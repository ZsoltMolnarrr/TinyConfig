package net.tinyconfig;

import java.nio.file.Path;

class PlatformHelper {
    static Path getConfigDir() {
        try {
            Class<?> fabricLoader = Class.forName("net.fabricmc.loader.api.FabricLoader");
            return FabricHelper.getConfigDir();
        } catch (ClassNotFoundException e) { }

        try {
            Class<?> forgeLoader = Class.forName("net.minecraftforge.fml.loading.FMLPaths");
            return ForgeHelper.getConfigDir();
        } catch (ClassNotFoundException e) { }

        return Path.of("config");
    }
}
