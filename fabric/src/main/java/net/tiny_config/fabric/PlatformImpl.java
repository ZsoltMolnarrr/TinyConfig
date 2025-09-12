package net.tiny_config.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.tiny_config.Platform;

import java.nio.file.Path;

public class PlatformImpl {
    public static Platform.Type getPlatformType() {
        return Platform.Type.FABRIC;
    }

    public static class FabricUtil implements Platform.Util {
        @Override
        public boolean isModLoaded(String modid) {
            return FabricLoader.getInstance().isModLoaded(modid);
        }

        @Override
        public Path getConfigDir() {
            return FabricLoader.getInstance().getConfigDir();
        }
    }
    private static final Platform.Util UTIL = new FabricUtil();
    public static Platform.Util util() {
        return UTIL;
    }
}
