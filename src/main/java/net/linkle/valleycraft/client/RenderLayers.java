package net.linkle.valleycraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModBlocks.*;
import static net.linkle.valleycraft.init.NaturalBlocks.*;

import java.util.HashSet;

import static net.linkle.valleycraft.Main.LOGGER;

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
        put(MAMON_DOOR, cullout);
        put(MAMON_TRAPDOOR, cullout);
        put(WATTLE_DOOR, cullout);
        put(WATTLE_TRAPDOOR, cullout);
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
        put(MOSS_SPROUTLET, cullout);
        put(ORANGE_BEAUTY, cullout);
        put(ORANGE_FERN, cullout);
        put(PINK_LUPINE, cullout);
        put(POISON_BLOSSOM, cullout);
        put(PURPLE_TULIP, cullout);
        put(RED_LUPINE, cullout);
        // put(ROOTED_WATCHER, cullout);
        put(SHIVERCAP, cullout);
        put(STALWART_SHROOM, cullout);
        put(SHORT_GRASS, cullout);
        put(SNOWFLOWER, cullout);
        put(SPROUT, cullout);
        put(THORNY_BUSH, cullout);
        // put(WARDING_SHROOM, cullout);
        put(WEEPING_GHOST_WILLOW, cullout);
        put(WILD_BEET, cullout);
        put(WILD_CARROT, cullout);
        put(WILD_POTATO, cullout);
        put(WILD_WHEAT, cullout);
        put(YELLOW_LUPINE, cullout);
        put(YELLOW_TULIP, cullout);
        put(YELLOW_POPPY, cullout);
        put(ORANGE_POPPY, cullout);
        put(WHITE_POPPY, cullout);
        put(GOOP_CAP, cullout);
        put(WILD_PUFF_BALL, cullout);
        put(CAVE_ROOTS, cullout);
        put(BONE_WEED, cullout);
        put(DESERT_SHRUB, cullout);
        put(BUSH, cullout);
        put(LARGE_BUSH, cullout);
        put(LUSH_BUSH, cullout);
        put(BIG_FERN, cullout);
        put(WILD_MINERS_LETTUCE, cullout);
        put(GLOOM_BERRY, cullout);
        put(GLOOM_BERRY_PLANT, cullout);
        put(SMALLEST_LILYPADS, cullout);
        put(SMALL_LILYPADS, cullout);
        put(SMALL_LILYPAD, cullout);
        put(YELLOW_FLOWERING_LILYPAD, cullout);
        put(WHITE_FLOWERING_LILYPAD, cullout);
        put(RED_FLOWERING_LILYPAD, cullout);
        put(PURPLE_FLOWERING_LILYPAD, cullout);
        put(PINK_FLOWERING_LILYPAD, cullout);
        put(BLUE_FLOWERING_LILYPAD, cullout);
        // put(STICKY_SHROOM, cullout);
        put(PANFLOWERS, cullout);
        put(JUNGLE_BUSH, cullout);
        put(ROCKS, cullout);
        put(APPLE_LEAVES, cullout);
        put(APPLE_LEAVES_EMPTY, cullout);
        put(APPLE_SAPLING, cullout);
        put(MAMON_SAPLING, cullout);
        put(ALGAE, cullout);
        put(KNAPWEED, cullout);
        put(FROSTFERN, cullout);
        put(CLARET_LEAF, cullout);
        put(GLOW_KELP, cullout);
        put(GLOW_KELP_PLANT, cullout);
        put(GODDESS_LILY, cullout);
        put(MOREL, cullout);
        put(ORANGE_KELP, cullout);
        put(ORANGE_KELP_PLANT, cullout);
        put(WILD_CAVE_ROOT, cullout);
        put(WILD_RICE, cullout);
        put(WILD_FIRE_PEPPER, cullout);
        put(WILD_HERBS, cullout);
        put(WILD_AMETHYSTLE, cullout);
        put(WILD_ONION, cullout);
        put(MAIZE, cullout);
        put(RICES, cullout);
        put(PUFF_BALL, cullout);
        put(ONIONS, cullout);
        put(MINERS_LETTUCES, cullout);
        put(FIRE_PEPPERS, cullout);
        put(CAVE_ROOT_CROP, cullout);
        put(ANCIENT_FLOWERS, cullout);
        put(AMETHYSTLES, cullout);
        put(ALOE_VERAS, cullout);
        put(CAVE_MOSS, cullout);
        put(CRYSTAL_CAVE_MOSS, cullout);
        put(ORANGE_SEAGRASS, cullout);
        put(GLOWSQUID_LANTERN, cullout);
        put(GOLEMITE_BARS, cullout);
        put(GOLEMITE_CHAIN, cullout);
        put(GOLEMITE_GRATE, cullout);
        put(GOLEMITE_LADDER, cullout);
        put(PRIMSTEEL_BARS, cullout);
        put(PRIMSTEEL_LADDER, cullout);
        put(PRIMSTEEL_GRATE, cullout);
        put(IRON_GRATE, cullout);
        put(PRIMSTEEL_CHAIN, cullout);
        put(OPTIC_GLASS, cullout);
        put(VEX_LANTERN, cullout);
        put(ANCIENT_WAGON_WHEEL, cullout);
        put(ANCIENT_WAGON_WHEEL_PLATFORM, cullout);
        put(ANCIENT_WAGON_WHEEL_TABLE, cullout);
        put(WATTLE_STOOL, cullout);
        put(WATTLE_TABLE, cullout);
        put(WATTLE_TABLE_CLOTHE, cullout);
        put(WATTLE_CHAIR, cullout);
        put(ARROW_BLOCK, cullout);

        put(TALL_ALLIUM, cullout);
        put(TALL_CORNFLOWER, cullout);
        put(TALL_DEAD_BUSH, cullout);
        put(TALL_LAVENDER, cullout);
        put(TALL_LIVING_BUSH, cullout);
        put(TALL_OXEYE_DAISY, cullout);
        put(TALL_AZURE_BLUET, cullout);

        put(GUIDESTONE, cullout);
        put(GUIDESTONE_ARROW, cullout);
        put(GUIDESTONE_DANGER, cullout);
        put(GUIDESTONE_HOME, cullout);
        put(GUIDESTONE_INTEREST, cullout);

        put(GRAVE_MARKER, cullout);
        put(GRAVE_MARKER_PET, cullout);
        put(ERD_STONE_GRAVESTONE, cullout);
        put(ERD_STONE_GRAVESTONE_PET, cullout);
        put(DEFECTIVE_SPAWNER, cullout);
        put(SWORD_BLOCK, cullout);
        put(SOULSPORE, cullout);

        put(BROWN_CLAY_POT, cullout);
        put(BLUE_CLAY_POT, cullout);

        put(ERDSTONE_WINDOW, cullout);
        put(ERDSTONE_WINDOW_POWERED, cullout);

        put(SLUDGE_FLUID, translucent);

        // put(BIG_RED, cullout);
        // put(BIG_BROWN, cullout);
        put(BROWN_CLUSTER, cullout);
        put(RED_CLUSTER, cullout);
        put(SOULSPORE_SINGLE, cullout);
        put(GLOW_CAP_CLUSTER, cullout);
        put(JUNGLE_CAP_CLUSTER, cullout);
        put(BURNT_OUT_TORCH, cullout);
        put(BURNT_OUT_CANDLE, cullout);
        put(SKELETAL_REMAINS, cullout);
        put(SKELETAL_MINING_REMAINS, cullout);
        put(PICKAXE_BLOCK, cullout);
        put(DEAD_LANTERN, cullout);
        put(STAKE, cullout);
        put(LUMBERJACK_STATION, cullout);
        put(CAMPFIRE_POT, cullout);
        put(LANTERN_HANGER, cullout);
        put(LOG_PILE, cullout);
        put(KEG, cullout);
        put(SMALL_CACTUS, cullout);
        put(FADED_SOUL_ROSE, cullout);
        put(DRIED_SAPLING, cullout);
        put(WARM_BIRCH_SAPLING, cullout);
        put(PRIMSTEEL_BARS, cullout);
        put(BLOCK_WATTLE_AND_GLASS, translucent);
        put(BLOCK_WATTLE_AND_GLASS_PLUS, translucent);
        put(BLOCK_WATTLE_AND_GLASS_CROSS, translucent);
        put(TUMBLEWEED, cullout);
        put(ROPE, cullout);
        put(NET, cullout);
        put(ROPE_BRIDGE, cullout);
        put(ROPE_BRIDGE_ANCHOR, cullout);
        put(SCARECROW, cullout);
        put(SCARECROW_GLOWING, cullout);
        put(SCARECROW_HAT, cullout);
        put(SCARECROW_HAT_GLOWING, cullout);
        put(SCARECROW_TARGET, cullout);
        put(GLOW_SEAGRASS, cullout);
        put(IRON_LADDER, cullout);
        put(PRIMSTEEL_LADDER, cullout);
        put(GOLEMITE_LADDER, cullout);
        put(BAMBOO_LADDER, cullout);
    }

    /**
     * Used to check for the block registered twice or more for the block render
     * layer and output warning logs if there is one.
     */
    private static final HashSet<Block> BLOCKS = new HashSet<>(1000);

    
    private static void put(BlockConvertible block, RenderLayer layer) {
        put(block.asBlock(), layer);
    }
    
    private static void put(Block block, RenderLayer layer) {

        // To developers, please remove the block that has registered twice or more.
        if (!BLOCKS.add(block)) {
            var id = Registry.BLOCK.getId(block);
            LOGGER.warn("{} has registerd again for block render layer", id);
        }

        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
