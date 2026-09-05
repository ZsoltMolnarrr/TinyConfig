package net.tiny_config.forge;

import net.minecraftforge.fml.common.Mod;

import net.tiny_config.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModForge {
    public ExampleModForge() {
        ExampleMod.init();
    }
}
