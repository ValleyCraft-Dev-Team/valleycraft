package net.linkle.valleycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.linkle.valleycraft.fluid.ModFluids;
import net.linkle.valleycraft.init.ModEnitites;
import net.linkle.valleycraft.init.ModParticles;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RenderLayers.intialize();
        ColorProvider.intialize();
        ModParticles.initializeClient();
        ModEnitites.initializeClient();

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SLUDGE_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 3495213));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SLUDGE_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 3495213));
    }
}
