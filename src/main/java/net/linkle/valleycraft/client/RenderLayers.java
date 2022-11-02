package net.linkle.valleycraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModBlocks.*;
import static net.linkle.valleycraft.init.ModNaturalBlocks.*;

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
        put(WATTLE_DOOR, translucent);
        put(WATTLE_TRAPDOOR, translucent);
        put(GLASS_DOOR, cullout);
        put(TINTED_GLASS_DOOR, translucent);
        put(CELESTIAL_DOOR, cullout);

        // Flowers and Potted Flowers
        put(BLACK_DAHLIA, cullout);
        put(POTTED_BLACK_DAHLIA, cullout);
        put(FLUFFY_DANDELION, cullout);
        put(POTTED_FLUFFY_DANDELION, cullout);
        put(FADED_SOUL_ROSE, cullout);
        put(SOUL_ROSE, cullout);
        put(BLUE_SOUL_ROSE, cullout);
        put(BLUE_SOULSPORE, cullout);
        put(BLUE_SOULSPORE_SINGLE, cullout);
        put(BLUE_SOUL_CELESTIAL, cullout);
        put(SOUL_CELESTIAL, cullout);
        put(FADED_CELESTIAL, cullout);
        put(POTTED_FADED_SOUL_ROSE, cullout);
        put(HONEYCLUSTER, cullout);
        put(END_GRASS, cullout);
        put(CELESTIAL_LEAVES, cullout);
        put(POTTED_HONEYCLUSTER, cullout);
        put(LAVENDER, cullout);
        put(POTTED_LAVENDER, cullout);
        put(ORANGE_BEAUTY, cullout);
        put(POTTED_ORANGE_BEAUTY, cullout);
        put(POISON_BLOSSOM, cullout);
        put(POTTED_POISON_BLOSSOM, cullout);
        put(PURPLE_TULIP, cullout);
        put(POTTED_PURPLE_TULIP, cullout);
        put(YELLOW_TULIP, cullout);
        put(POTTED_YELLOW_TULIP, cullout);
        put(LIGHT_BLUE_TULIP, cullout);
        put(POTTED_LIGHT_BLUE_TULIP, cullout);
        put(BLACK_TULIP, cullout);
        put(POTTED_BLACK_TULIP, cullout);
        put(GODDESS_LILY, cullout);
        put(POTTED_GODDESS_LILY, cullout);
        put(RED_LUPINE, cullout);
        put(POTTED_RED_LUPINE, cullout);
        put(YELLOW_LUPINE, cullout);
        put(POTTED_YELLOW_LUPINE, cullout);
        put(PINK_LUPINE, cullout);
        put(POTTED_PINK_LUPINE, cullout);
        put(ORANGE_POPPY, cullout);
        put(POTTED_ORANGE_POPPY, cullout);
        put(YELLOW_POPPY, cullout);
        put(POTTED_YELLOW_POPPY, cullout);
        put(WHITE_POPPY, cullout);
        put(POTTED_WHITE_POPPY, cullout);
        put(SNOWFLOWER, cullout);
        put(POTTED_SNOWFLOWER, cullout);

        // Fungi and Potted Fungi
        put(GLOW_CAP, cullout);
        put(POTTED_GLOW_CAP, cullout);
        put(JUNGLE_CAP, cullout);
        put(POTTED_JUNGLE_CAP, cullout);
        put(SOULSPORE_SINGLE, cullout);
        put(POTTED_SOULSPORE, cullout);
        put(MOREL, cullout);
        put(POTTED_MOREL, cullout);
        put(GOOP_CAP, cullout);
        put(POTTED_GOOP_CAP, cullout);
        put(GILDED_CAP, cullout);
        put(POTTED_GILDED_CAP, cullout);
        put(IRONSHROOM, cullout);
        put(POTTED_IRONSHROOM, cullout);

        // Saplings and Potted Saplings
        put(DRIED_SAPLING, cullout);
        put(POTTED_DRIED_SAPLING, cullout);
        put(MAMON_SAPLING, cullout);
        put(POTTED_MAMON_SAPLING, cullout);
        put(APPLE_SAPLING, cullout);
        put(POTTED_APPLE_SAPLING, cullout);
        put(WARM_BIRCH_SAPLING, cullout);
        put(POTTED_WARM_BIRCH_SAPLING, cullout);

        // Other Plants with potted versions
        put(FOXTAIL_FERN, cullout);
        put(POTTED_FOXTAIL_FERN, cullout);
        put(LEATHERLEAF_FERN, cullout);
        put(POTTED_LEATHERLEAF_FERN, cullout);
        put(MOSS_SPROUTLET, cullout);
        put(POTTED_MOSS_SPROUTLET, cullout);
        put(ORANGE_FERN, cullout);
        put(POTTED_ORANGE_FERN, cullout);
        put(SPROUT, cullout);
        put(POTTED_SPROUT, cullout);
        put(DESERT_SHRUB, cullout);
        put(POTTED_DESERT_SHRUB, cullout);
        put(LUSH_BUSH, cullout);
        put(POTTED_LUSH_BUSH, cullout);
        put(GHOST_PUMPKIN_STEM, cullout);

        put(FLOWERING_CACTUS, cullout);
        put(POTTED_FLOWERING_CACTUS, cullout);
        put(JUNGLE_BUSH, cullout);
        put(POTTED_JUNGLE_BUSH, cullout);
        put(PANFLOWERS, cullout);
        put(POTTED_PANFLOWERS, cullout);
        put(FROSTFERN, cullout);
        put(POTTED_FROSTFERN, cullout);
        put(CLARET_LEAF, cullout);
        put(POTTED_CLARET_LEAF, cullout);
        put(WEEPING_GHOST_WILLOW, cullout);
        put(POTTED_WEEPING_GHOST_WILLOW, cullout);
        put(BONE_WEED, cullout);
        put(POTTED_BONE_WEED, cullout);

        //Other Plants without potted versions
        put(THORNY_BUSH, cullout);
        // put(ROOTED_WATCHER, cullout);
        // put(WARDING_SHROOM, cullout);
        put(STALWART_SHROOM, cullout);
        put(SHORT_GRASS, cullout);
        put(SHIVERCAP, cullout);
        put(WILD_BEET, cullout);
        put(WILD_CARROT, cullout);
        put(WILD_POTATO, cullout);
        put(WILD_WHEAT, cullout);
        put(WILD_PUFF_BALL, cullout);
        put(CAVE_ROOTS, cullout);
        put(BUSH, cullout);
        put(LARGE_BUSH, cullout);
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
        put(ROCKS, cullout);
        put(APPLE_LEAVES, cullout);
        put(APPLE_LEAVES_EMPTY, cullout);
        put(ALGAE, cullout);
        put(KNAPWEED, cullout);
        put(GLOW_KELP, cullout);
        put(GLOW_KELP_PLANT, cullout);
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
        put(GOLDEN_LADDER, cullout);
        put(ROPE_LADDER, cullout);
        put(NET_BLOCK, cullout);
        put(PRIMSTEEL_GRATE, cullout);
        put(PRIMSTEEL_CHAIN, cullout);
        put(IRON_GRATE, cullout);
        put(GOLDEN_GRATE, cullout);
        put(GOLDEN_BARS, cullout);
        put(TERRARIUM_GLASS, cullout);
        put(TERRARIUM_GLASS_PANE, cullout);
        put(BEVELED_GLASS, cullout);
        put(BEVELED_GLASS_PANE, cullout);
        put(VEX_LANTERN, cullout);
        put(ALLAY_LANTERN, cullout);
        put(WATTLE_BARS, cullout);
        put(BONFIRE, translucent);
        put(ARID_VINES, cullout);
        put(ARID_VINES_PLANT, cullout);

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
        put(SHALE_GRAVESTONE, cullout);
        put(SHALE_GRAVESTONE_SPIRIT, cullout);
        put(SHALE_GRAVESTONE_HEART, cullout);
        put(SHALE_GRAVESTONE_TEXT, cullout);
        put(SHALE_GRAVESTONE_ROSE, cullout);
        put(SHALE_PET_GRAVESTONE, cullout);
        put(SHALE_PET_GRAVESTONE_SPIRIT, cullout);
        put(SHALE_PET_GRAVESTONE_HEART, cullout);
        put(SHALE_PET_GRAVESTONE_TEXT, cullout);
        put(SHALE_PET_GRAVESTONE_ROSE, cullout);
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
        put(WARDING_SHROOM, cullout);
        put(MEADOW_FLOWERS, cullout);
        put(BARNACLE_BLOCK, translucent);
        put(CLAM_BLOCK, cullout);
        put(URCHIN_BLOCK, cullout);
        put(STARFISH_BLOCK, cullout);
        put(TUBE_WORMS_BLOCK, cullout);
        put(RUSHES, cullout);
        put(CELESTIAL_SAPLING, cullout);
        put(OCELOT_STATUE, cullout);

        put(TRANSLATION_CANVAS, cullout);
        put(GLOW_CAP_CLUSTER, cullout);
        put(JUNGLE_CAP_CLUSTER, cullout);
        put(BURNT_OUT_TORCH, cullout);
        put(BURNT_OUT_CANDLE, cullout);
        put(SKELETAL_REMAINS, cullout);
        put(VILLAGER_SKELETAL_REMAINS, cullout);
        put(PIGLIN_SKELETAL_REMAINS, cullout);
        put(DAERDRI_SKULL, cullout);
        put(GEITLIN_SKULL, cullout);
        put(MOBLIN_SKELETAL_REMAINS, cullout);
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
        put(BAMBOO_LADDER, cullout);
        put(BRIMSTONE_CRYSTAL, cullout);
        put(BRIMSTONE_GLASS, translucent);
        put(BRIMSTONE_GLASS_PANE, translucent);
        put(TARGET_DUMMY, cullout);
        put(BEACH_GRASS, cullout);
        put(ICEPLANT, cullout);

        put(ICE_ORE, translucent);
        put(DEEPSLATE_ICE_ORE, translucent);
        put(ICICLE, cullout);
        put(ICICLE_PACKED_ICE, translucent);

        put(COBBLESTONE_BRICK_CHIMNEY, cullout);
        put(COBBLESTONE_CHIMNEY, cullout);
        put(INDUSTRIAL_CHIMNEY, cullout);
        put(STONE_BRICK_CHIMNEY, cullout);
        put(BRICK_CHIMNEY, cullout);
        put(MUD_BRICK_CHIMNEY, cullout);
        put(ERDCOBBLESTONE_CHIMNEY, cullout);
        put(ERDSTONE_BRICK_CHIMNEY, cullout);
        put(SANDSTONE_CHIMNEY, cullout);
        put(RED_SANDSTONE_CHIMNEY, cullout);
        put(CARMINE_COBBLESTONE_CHIMNEY, cullout);
        put(DRIPSTONE_BRICK_CHIMNEY, cullout);
        put(DRIPSTONE_TILE_CHIMNEY, cullout);
        put(DEEPSLATE_TILE_CHIMNEY, cullout);
        put(DEEPSLATE_BRICK_CHIMNEY, cullout);
        put(NETHER_BRICK_CHIMNEY, cullout);
        put(RED_NETHER_BRICK_CHIMNEY, cullout);
        put(COUNTER, cullout);

        put(ARID_VINES_PLANT, cullout);
        put(ARID_VINES, cullout);
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
            LOGGER.warn("{} has registered again for block render layer", id);
        }

        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
