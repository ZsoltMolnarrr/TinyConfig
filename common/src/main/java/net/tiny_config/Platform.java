package net.tiny_config;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public class Platform {
    public static final boolean Fabric;
    public static final boolean Forge;
    public static final boolean NeoForge;

    static
    {
        Fabric = getPlatformType() == Type.FABRIC;
        Forge  = getPlatformType() == Type.FORGE;
        NeoForge = getPlatformType() == Type.NEOFORGE;
    }

    public enum Type { FABRIC, FORGE, NEOFORGE }

    @ExpectPlatform
    protected static Type getPlatformType() {
        throw new AssertionError();
    }

    public interface Util {
        boolean isModLoaded(String modid);
        Path getConfigDir();
    }

    @ExpectPlatform
    protected static Util util() {
        throw new AssertionError();
    }
}
