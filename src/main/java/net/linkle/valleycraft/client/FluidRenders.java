package net.linkle.valleycraft.client;

import java.util.ArrayList;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.Fluids;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
class FluidRenders {
    
    private static final ArrayList<Identifier> TEXS = new ArrayList<>();
    
    static void initialize() {
        // Register the textures.
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlas, registry) -> TEXS.forEach(registry::register));
        
        var sludge_tex = new SimpleFluidRenderHandler(tex("block/sludge_still"), tex("block/sludge_flowing"), tex("overlay/sludge_overlay"));
        register(Fluids.SLUDGE_STILL, sludge_tex);
        register(Fluids.SLUDGE_FLOWING, sludge_tex);
    }
    
    private static void register(Fluids fluid, FluidRenderHandler renderer) {
        register(fluid.fluid, renderer);
    }
    
    private static void register(Fluid fluid, FluidRenderHandler renderer) {
        FluidRenderHandlerRegistry.INSTANCE.register(fluid, renderer);
    }
    
    private static Identifier tex(String path) {
        var id = Main.makeId(path);
        TEXS.add(id);
        return id;
    }
}
