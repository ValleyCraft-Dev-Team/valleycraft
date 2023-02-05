package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.client.armor.ArmorRenderers;
import net.linkle.valleycraft.client.trinket.TrinketRenderers;
import net.linkle.valleycraft.entity.client.armor.ClothArmorRenderer;
import net.linkle.valleycraft.init.ModBlockEntityType;
import net.linkle.valleycraft.init.EntityType;
import net.linkle.valleycraft.init.Particles;
import net.linkle.valleycraft.network.ClientNetwork;
import net.linkle.valleycraft.util.ModModelPredicateProvider;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static net.linkle.valleycraft.init.Armors.*;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Sprites.intialize();
        RenderLayers.intialize();
        ColorProvider.intialize();
        Particles.initializeClient();
        EntityType.initializeClient();
        FluidRenders.intialize();
        ModBlockEntityType.initializeClient();
        ArmorRenderers.intialize();
        TrinketRenderers.intialize();
        ClientNetwork.initialize();

        GeoArmorRenderer.registerArmorRenderer(new ClothArmorRenderer(),
                TEST_BOOTS.item,TEST_LEGGINGS.item,
                TEST_CHESTPLATE.item, TEST_HELMET.item);

        ModModelPredicateProvider.registerModModels();
    }
}
