package net.tiny_config.neoforge;

import net.neoforged.fml.common.Mod;

import net.tiny_config.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        ExampleMod.init();
    }
}
