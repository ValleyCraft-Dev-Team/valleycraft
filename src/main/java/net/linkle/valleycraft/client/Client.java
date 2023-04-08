package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.client.armor.ArmorRenderers;
import net.linkle.valleycraft.client.trinket.TrinketRenderers;
import net.linkle.valleycraft.init.BlockEntities;
import net.linkle.valleycraft.init.Entities;
import net.linkle.valleycraft.init.Particles;
import net.linkle.valleycraft.network.ClientNetwork;
import net.linkle.valleycraft.util.ModModelPredicateProvider;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Sprites.initialize();
        RenderLayers.initialize();
        ColorProvider.initialize();
        Particles.initializeClient();
        Entities.initializeClient();
        FluidRenders.initialize();
        BlockEntities.initializeClient();
        ArmorRenderers.initialize();
        TrinketRenderers.initialize();
        ClientNetwork.initialize();

        ModModelPredicateProvider.registerModModels();
    }
}
