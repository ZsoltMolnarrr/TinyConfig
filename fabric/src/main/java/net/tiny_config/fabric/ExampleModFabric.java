package net.tiny_config.fabric;

import net.fabricmc.api.ModInitializer;

import net.tiny_config.ExampleMod;

public final class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
    }
}
