package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.client.armor.ArmorRenderers;
import net.linkle.valleycraft.client.trinket.TrinketRenderers;
import net.linkle.valleycraft.entity.client.armor.ClothArmorRenderer;
import net.linkle.valleycraft.init.BlockEntities;
import net.linkle.valleycraft.init.Entities;
import net.linkle.valleycraft.init.Particles;
import net.linkle.valleycraft.network.ClientNetwork;
import net.linkle.valleycraft.util.ModModelPredicateProvider;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static net.linkle.valleycraft.init.Armors.*;

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

        GeoArmorRenderer.registerArmorRenderer(new ClothArmorRenderer(),
                TEST_BOOTS.item,TEST_LEGGINGS.item,
                TEST_CHESTPLATE.item, TEST_HELMET.item);

        ModModelPredicateProvider.registerModModels();
    }
}
