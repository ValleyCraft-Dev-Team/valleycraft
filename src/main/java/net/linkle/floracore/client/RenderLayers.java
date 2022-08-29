package net.linkle.floracore.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

import static net.linkle.floracore.init.ModBlocks.*;

@Environment(EnvType.CLIENT)
class RenderLayers {

    @SuppressWarnings("unused")
    static void intialize() {
        // Only use cullout if the block's texture contains empty pixels.
        var cullout = RenderLayer.getCutout();

        // Only use translucent if the block's texture contains translucent pixels.
        var translucent = RenderLayer.getTranslucent();

        // Example
        // put(Blocks.GLASS, cullout);
        put(BLACK_DAHLIA, cullout);
        put(BLACK_TULIP, cullout);
        put(FLOWERING_CACTUS, cullout);
        put(FLUFFY_DANDELION, cullout);
        put(FOXTAIL_FERN, cullout);
        put(GILDED_CAP, cullout);
        put(GLOW_CAP, cullout);
        put(HONEYCLUSTER, cullout);
        put(IRONSHROOM, cullout);
        put(JUNGLE_CAP, cullout);
        put(LAVENDER, cullout);
        put(LEATHERLEAF_FERN, cullout);
        put(LIGHT_BLUE_TULIP, cullout);
        put(MINERS_LETTUCE, cullout);
        put(MOSS_SPROUTLET, cullout);
        put(MYRTLES, cullout);
        put(ORANGE_BEAUTY, cullout);
        put(ORANGE_FERN, cullout);
        put(PINK_LUPINE, cullout);
        put(POISON_BLOSSOM, cullout);
        put(PURPLE_LADY_SHROOM, cullout);
        put(PURPLE_TULIP, cullout);
        put(RED_LUPINE, cullout);
        put(ROOTED_WATCHER, cullout);
        put(SHIVERCAP, cullout);
        put(SHORT_GRASS, cullout);
        put(SNOWFLOWER, cullout);
        put(SPROUT, cullout);
        put(SWEET_SHROOM, cullout);
        put(THORNY_BUSH, cullout);
        put(WARDING_SHROOM, cullout);
        put(WEAPING_GHOST_WILLOW, cullout);
        put(WILD_BEET, cullout);
        put(WILD_CARROT, cullout);
        put(WILD_POTATO, cullout);
        put(WILD_WHEAT, cullout);
        put(YELLOW_LUPINE, cullout);
        put(YELLOW_TULIP, cullout);
    }

    private static void put(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}