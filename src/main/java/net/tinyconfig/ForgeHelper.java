package net.tinyconfig;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ForgeHelper {
    static Path getConfigDir() {
        return FMLPaths.CONFIGDIR.get();
    }
}
