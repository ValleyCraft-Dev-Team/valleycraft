package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.linkle.valleycraft.client.armor.Armors;
import net.linkle.valleycraft.init.ModBlockEntities;
import net.linkle.valleycraft.init.ModEntities;
import net.linkle.valleycraft.init.ModParticles;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandArmorEntityModel;
import net.minecraft.resource.ResourceType;

import static net.linkle.valleycraft.init.ModEntities.ThrownBoneDartEntityType;

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
        Armors.intialize();

        //sorry idk the correct place to put this but i know it works here
        EntityRendererRegistry.register(ThrownBoneDartEntityType, (context) ->
                new FlyingItemEntityRenderer(context));
    }
}
