package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.armors.Armors;
import net.linkle.valleycraft.entity.client.armor.ClothArmorRenderer;
import net.linkle.valleycraft.init.ModArmors;
import net.linkle.valleycraft.init.ModBlockEntityType;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.init.ModParticles;
import net.linkle.valleycraft.network.ClientNetwork;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static net.linkle.valleycraft.init.ModArmors.*;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Sprites.intialize();
        RenderLayers.intialize();
        ColorProvider.intialize();
        ModParticles.initializeClient();
        ModEntityType.initializeClient();
        FluidRenders.intialize();
        ModBlockEntityType.initializeClient();
        Armors.intialize();
        ModelLayers.intialize();
        ClientNetwork.initialize();

        GeoArmorRenderer.registerArmorRenderer(new ClothArmorRenderer(),
                TEST_BOOTS.item,TEST_LEGGINGS.item,
                TEST_CHESTPLATE.item, TEST_HELMET.item);
    }
}
