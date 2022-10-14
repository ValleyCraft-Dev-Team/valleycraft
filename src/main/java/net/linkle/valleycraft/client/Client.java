package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.linkle.valleycraft.client.armor.Armors;
import net.linkle.valleycraft.init.ModBlockEntities;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.init.ModParticles;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandArmorEntityModel;
import net.minecraft.resource.ResourceType;

import static net.linkle.valleycraft.init.ModEntityType.THROWN_ROCK;

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
        ModBlockEntities.initializeClient();
        Armors.intialize();
    }
}
