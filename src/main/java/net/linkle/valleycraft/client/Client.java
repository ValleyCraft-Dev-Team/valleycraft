package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.init.ModBlockEntities;
import net.linkle.valleycraft.init.ModEntities;
import net.linkle.valleycraft.init.ModParticles;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Sprites.intialize();
        RenderLayers.intialize();
        ColorProvider.intialize();
        ModParticles.initializeClient();
        ModEntities.initializeClient();
        FluidRenders.intialize();
        ModBlockEntities.initializeClient();
    }
}
