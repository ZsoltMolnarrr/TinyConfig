package net.tiny_config.neoforge;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import net.tiny_config.Platform;

import java.nio.file.Path;

public class PlatformImpl {
    public static Platform.Type getPlatformType() {
        return Platform.Type.NEOFORGE;
    }

    public static class NeoForgeUtil implements Platform.Util {
        @Override
        public boolean isModLoaded(String modid) {
            return ModList.get().isLoaded(modid);
        }

        @Override
        public Path getConfigDir() {
            return FMLPaths.CONFIGDIR.get();
        }
    }
    private static final Platform.Util UTIL = new NeoForgeUtil();
    public static Platform.Util util() {
        return UTIL;
    }
}
