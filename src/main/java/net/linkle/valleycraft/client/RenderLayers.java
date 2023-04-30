package net.linkle.valleycraft.client;

import static net.linkle.valleycraft.Main.LOGGER;
import static net.linkle.valleycraft.init.BlocksModded.*;
import static net.linkle.valleycraft.init.BlocksNatural.*;

import java.util.HashSet;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
class RenderLayers {

    @SuppressWarnings("unused")
    static void initialize() {
        // Only use cullout if the block's texture contains empty pixels (fully transparent).
        var cullout = RenderLayer.getCutout();

        // Only use translucent if the block's texture contains translucent pixels.
        var translucent = RenderLayer.getTranslucent();

        // Example
        // put(Blocks.GLASS, cullout);
        put(MAMON_DOOR, cullout);
        put(MAMON_TRAPDOOR, cullout);
        put(WATTLE_DOOR, cullout);
        put(WATTLE_TRAPDOOR, cullout);
        put(GLASS_DOOR, cullout);
        put(GLASS_TRAPDOOR, cullout);
        put(TINTED_GLASS_DOOR, translucent);
        put(TINTED_GLASS_TRAPDOOR, translucent);
        put(PRIMSTEEL_DOOR, cullout);
        put(PRIMSTEEL_TRAPDOOR, cullout);
        put(SCULK_BLOSSOM, cullout);
        //put(CHAINED_RUSTED_CHEST, cullout);
        put(CRAFTING_MAT, cullout);
        put(WITCH_LADLE, cullout);
        put(FIREGUARD, cullout);
        put(NEST, cullout);
        put(IRON_BRAZIER, cullout);
        put(IRON_SOUL_BRAZIER, cullout);
        put(SPIDER_EGG, cullout);
        put(REDSTONE_LANTERN, cullout);
        put(REDSTONE_LAMPTERN, cullout);
        put(BONFIRE, cullout);
        put(CAMPFIRE_POT, cullout);
        put(SOUL_CAMPFIRE_POT, cullout);

        put(GUIDESTONE_BACK, cullout);
        put(GUIDESTONE_BLANK, cullout);
        put(GUIDESTONE_CAMPSITE, cullout);
        put(GUIDESTONE_DUNGEON, cullout);
        put(GUIDESTONE_FORWARD, cullout);
        put(GUIDESTONE_HERE, cullout);
        put(GUIDESTONE_HOMESTEAD, cullout);
        put(GUIDESTONE_LEFT, cullout);
        put(GUIDESTONE_PORT, cullout);
        put(GUIDESTONE_PORTAL, cullout);
        put(GUIDESTONE_RIGHT, cullout);
        put(GUIDESTONE_SYMBOL_DEATH, cullout);
        put(GUIDESTONE_STABLES, cullout);
        put(GUIDESTONE_SYMBOL_HUNGER, cullout);
        put(GUIDESTONE_SYMBOL_HEART, cullout);
        put(GUIDESTONE_TOOL_AXE, cullout);
        put(GUIDESTONE_TOOL_BOW, cullout);
        put(GUIDESTONE_TOOL_FISHING_ROD, cullout);
        put(GUIDESTONE_TOOL_HOE, cullout);
        put(GUIDESTONE_TOOL_PICKAXE, cullout);
        put(GUIDESTONE_TOOL_SWORD, cullout);
        put(GUIDESTONE_TOOL_SHOVEL, cullout);
        put(GUIDESTONE_TOOL_POTION, cullout);
        put(GUIDESTONE_TOWER, cullout);
        put(GUIDESTONE_TRADE, cullout);
        put(GUIDESTONE_VILLAGE, cullout);
        put(MEMBRANE_BLOCK, translucent);

        put(BLACK_CUSHION, cullout);
        put(BLUE_CUSHION, cullout);
        put(BROWN_CUSHION, cullout);
        put(CYAN_CUSHION, cullout);
        put(GRAY_CUSHION, cullout);
        put(GREEN_CUSHION, cullout);
        put(LIGHT_BLUE_CUSHION, cullout);
        put(LIGHT_GRAY_CUSHION, cullout);
        put(LIME_CUSHION, cullout);
        put(MAGENTA_CUSHION, cullout);
        put(ORANGE_CUSHION, cullout);
        put(PURPLE_CUSHION, cullout);
        put(PINK_CUSHION, cullout);
        put(YELLOW_CUSHION, cullout);
        put(WHITE_CUSHION, cullout);
        put(RED_CUSHION, cullout);

        // Flowers and Potted Flowers
        put(BLACK_DAHLIA, cullout);
        put(POTTED_BLACK_DAHLIA, cullout);
        put(FLUFFY_DANDELION, cullout);
        put(POTTED_FLUFFY_DANDELION, cullout);
        put(FADED_SOUL_ROSE, cullout);
        put(SOUL_ROSE, cullout);
        put(BLUE_SOUL_ROSE, cullout);
        put(POTTED_FADED_SOUL_ROSE, cullout);
        put(HONEYCLUSTER, cullout);
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
        put(MOREL, cullout);
        put(POTTED_MOREL, cullout);
        put(LILY_OF_THE_MOUNTAINS, cullout);

        // Saplings and Potted Saplings
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
        //put(ORANGE_FERN, cullout);
        //put(POTTED_ORANGE_FERN, cullout);
        put(SPROUT, cullout);
        put(POTTED_SPROUT, cullout);
        put(DESERT_SHRUB, cullout);
        put(POTTED_DESERT_SHRUB, cullout);
        put(LUSH_BUSH, cullout);
        put(POTTED_LUSH_BUSH, cullout);

        put(FLOWERING_CACTUS, cullout);
        put(POTTED_FLOWERING_CACTUS, cullout);
        put(JUNGLE_BUSH, cullout);
        put(POTTED_JUNGLE_BUSH, cullout);
        put(PANFLOWERS, cullout);
        put(POTTED_PANFLOWERS, cullout);
        //put(FROSTFERN, cullout);
        put(FIREFERN, cullout);
        put(POTTED_FIREFERN, cullout);
        put(WEEPING_GHOST_WILLOW, cullout);
        put(POTTED_WEEPING_GHOST_WILLOW, cullout);
        //put(FIDDLEHEAD_FERN, cullout);
        //put(POTTED_FIDDLEHEAD_FERN, cullout);
        put(POTTED_ANCIENT_FLOWER, cullout);
        put(ANCIENT_FLOWER_BLOCK, cullout);
        put(STAMINELLA_BERRY_PLANT, cullout);

        //Other Plants without potted versions
        put(THORNY_BUSH, cullout);
        put(STALWART_SHROOM, cullout);
        put(SHORT_GRASS, cullout);
        put(SHIVERCAP, cullout);
        put(WILD_BEET, cullout);
        put(WILD_CARROT, cullout);
        put(WILD_POTATO, cullout);
        put(WILD_WHEAT, cullout);
        put(WILD_PUFF_BALL, cullout);
        put(BUSH, cullout);
        put(LARGE_BUSH, cullout);
        put(BIG_FERN, cullout);
        put(WILD_MINERS_LETTUCE, cullout);
        put(SMALLEST_LILYPADS, cullout);
        put(SMALL_LILYPADS, cullout);
        put(SMALL_LILYPAD, cullout);
        put(YELLOW_FLOWERING_LILYPAD, cullout);
        put(WHITE_FLOWERING_LILYPAD, cullout);
        put(RED_FLOWERING_LILYPAD, cullout);
        put(PURPLE_FLOWERING_LILYPAD, cullout);
        put(PINK_FLOWERING_LILYPAD, cullout);
        put(BLUE_FLOWERING_LILYPAD, cullout);

        put(ROCKS, cullout);
        put(FLINT_ROCKS, cullout);
        put(DIRT_ROCKS, cullout);
        put(DRIPSTONE_ROCKS, cullout);
        put(SHALE_ROCKS, cullout);
        put(DEEPSLATE_ROCKS, cullout);
        put(ERDCOBBLESTONE_ROCKS, cullout);

        put(COAL_ORE_ROCKS, cullout);
        put(RAW_PRIMSTEEL_ORE_ROCKS, cullout);
        put(RAW_COPPER_ORE_ROCKS, cullout);
        put(RAW_IRON_ORE_ROCKS, cullout);
        put(RAW_GOLD_ORE_ROCKS, cullout);

        put(NETHERACK_ROCKS, cullout);
        put(ANTHRACITE_ORE_ROCKS, cullout);
        put(ENDSTONE_ROCKS, cullout);
        put(REDSTONE_CRYSTAL, cullout);
        put(JELLYCAP, translucent);
        put(GNARLED_ROOTS, cullout);

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
        put(ORANGE_SEAGRASS, cullout);
        put(GLOWSQUID_LANTERN, cullout);

        put(BLUE_ANEMONE, cullout);
        put(GREEN_ANEMONE, cullout);
        put(PINK_ANEMONE, cullout);
        put(PURPLE_ANEMONE, cullout);
        put(RED_ANEMONE, cullout);
        put(YELLOW_ANEMONE, cullout);

        put(ROPE_LADDER, cullout);
        //put(NET_BLOCK, cullout);
        put(PRIMSTEEL_GRATE, cullout);
        put(PRIMSTEEL_CHAIN, cullout);
        put(IRON_CHAIN, cullout);
        put(LARGE_PRIMSTEEL_CHAIN, cullout);
        put(LARGE_IRON_CHAIN, cullout);
        put(LARGE_CHAIN, cullout);

        put(IRON_GRATE, cullout);
        put(WATTLE_GRATE, cullout);
        put(TERRARIUM_GLASS, cullout);
        put(TERRARIUM_GLASS_PANE, cullout);
        put(BEVELED_GLASS, cullout);
        put(BEVELED_GLASS_PANE, cullout);
        put(BEVELED_BRIMSTONE_GLASS, translucent);
        put(BEVELED_BRIMSTONE_GLASS_PANE, translucent);
        put(BEVELED_TINTED_GLASS, translucent);
        put(BEVELED_TINTED_GLASS_PANE, translucent);
        put(TINTED_GLASS_PANE, translucent);
        put(WATER_STRAINER, cullout);
        put(GLOW_SPLATTER, cullout);

        put(WATTLE_BARS, cullout);
        put(ARID_VINES, cullout);
        put(ARID_VINES_PLANT, cullout);
        put(MIMIC_FLOWER, cullout);

        // lattices
        put(ACACIA_LATTICE, cullout);
        put(AMBERBLOSSOM_LATTICE, cullout);
        put(APPLE_LATTICE, cullout);
        put(BIRCH_LATTICE, cullout);
        put(CRIMSON_LATTICE, cullout);
        put(CRIMSON_LATTICE, cullout);
        put(DARK_OAK_LATTICE, cullout);
        put(JUNGLE_LATTICE, cullout);
        put(MANGROVE_LATTICE, cullout);
        put(OAK_LATTICE, cullout);
        put(SPRUCE_LATTICE, cullout);
        put(WARPED_LATTICE, cullout);
        put(WATTLE_LATTICE, cullout);
        
        put(BRAZIER, cullout);
        put(SOUL_BRAZIER, cullout);
        
        put(EMPTY_BOTTLE_BLOCK, cullout);
        put(EXP_BOTTLE_BLOCK, translucent);
        put(GLOW_BERRY_BOTTLE_BLOCK, translucent);
        put(HONEY_BOTTLE_BLOCK, translucent);
        put(INK_BOTTLE_BLOCK, cullout);
        put(MILK_BOTTLE_BLOCK, cullout);
        put(WATER_BOTTLE_BLOCK, translucent);
        put(CANDLE_BOTTLE, cullout);

        put(WATTLE_STOOL, cullout);
        put(WATTLE_TABLE, cullout);
        put(WATTLE_TABLE_CLOTHE, cullout);
        put(WATTLE_CHAIR, cullout);
        put(ORNATE_OBSIDIAN_TABLE, cullout);
        put(CLOTHED_ORNATE_OBSIDIAN_TABLE, cullout);

        put(TALL_ALLIUM, cullout);
        put(TALL_CORNFLOWER, cullout);
        put(TALL_DEAD_BUSH, cullout);
        put(TALL_LAVENDER, cullout);
        put(TALL_LIVING_BUSH, cullout);
        put(TALL_OXEYE_DAISY, cullout);
        put(TALL_AZURE_BLUET, cullout);
        put(CATTAILS, cullout);

        put(GRAVE_MARKER, cullout);
        put(SHALE_GRAVESTONE, cullout);
        put(SHALE_GRAVESTONE_SPIRIT, cullout);
        put(SHALE_GRAVESTONE_HEART, cullout);
        put(SHALE_GRAVESTONE_TEXT, cullout);
        put(SHALE_GRAVESTONE_ROSE, cullout);
        put(DEFECTIVE_SPAWNER, cullout);
        put(SWORD_BLOCK, cullout);
        put(SPORE_SPREADER, cullout);

        put(BROWN_CLAY_POT, cullout);
        put(BLUE_CLAY_POT, cullout);
        put(GREEN_CLAY_POT, cullout);
        //put(PURPLE_CLAY_POT, cullout);
        put(ROUNDED_CLAY_POT, cullout);
        put(ROUNDED_BLUE_CLAY_POT, cullout);

        put(SLUDGE_FLUID, translucent);

        put(BROWN_CLUSTER, cullout);
        put(RED_CLUSTER, cullout);
        put(MEADOW_FLOWERS, cullout);
        put(BARNACLE_BLOCK, translucent);
        put(CLAM_BLOCK, cullout);
        put(URCHIN_BLOCK, cullout);
        put(STARFISH_BLOCK, cullout);
        put(TUBE_WORMS_BLOCK, cullout);
        put(RUSHES, cullout);
        //put(OCELOT_STATUE, cullout);
        put(SPIKE_TRAP, cullout);
        put(SPIKE_TRAP_EXTENSION, cullout);
        put(FAN_MOLD, translucent);

        put(HOLLOW_ACACIA_LOG, cullout);
        put(HOLLOW_APPLE_LOG, cullout);
        put(HOLLOW_BIRCH_LOG, cullout);
        put(HOLLOW_DARK_OAK_LOG, cullout);
        put(HOLLOW_JUNGLE_LOG, cullout);
        put(HOLLOW_MAMON_LOG, cullout);
        put(HOLLOW_MANGROVE_LOG, cullout);
        put(HOLLOW_OAK_LOG, cullout);
        put(HOLLOW_SPRUCE_LOG, cullout);
        put(CHEESE, cullout);

        //put(TRANSLATION_CANVAS, cullout);
        put(GLOW_CAP_CLUSTER, cullout);
        put(JUNGLE_CAP_CLUSTER, cullout);
        put(BURNT_OUT_TORCH, cullout);
        put(BURNT_OUT_CANDLE, cullout);
        put(HEADLESS_SKELETAL_REMAINS, cullout);
        put(SKELETAL_REMAINS, cullout);
        put(VILLAGER_SKELETAL_REMAINS, cullout);
        put(PIGLIN_SKELETAL_REMAINS, cullout);
        put(DAERDRI_SKULL, cullout);
        put(HEAD_ZOMBIE_ALEX, cullout);
        put(HEAD_ZOMBIE_EFE, cullout);
        put(HEAD_DROWNED_ALEX, cullout);
        put(HEAD_DROWNED_EFE, cullout);
        put(HEAD_DROWNED_STEVE, cullout);
        put(HEAD_HUSK_STEVE, cullout);
        put(HEAD_HUSK_ALEX, cullout);
        put(HEAD_HUSK_EFE, cullout);
        put(HEAD_ROTTEN_ALEX, cullout);
        put(HEAD_ROTTEN_EFE, cullout);
        put(HEAD_ROTTEN_STEVE, cullout);
        put(ENDERMAN_SKULL, cullout);

        put(COFFIN, translucent);

        put(DEEPSLATE_CHEST, cullout);
        put(DEEPSLATE_CHEST, translucent);

        put(VILLAGER_SKULL, cullout);
        put(PIGLIN_SKULL, cullout);
        put(PICKAXE_BLOCK, cullout);
        put(DEAD_LANTERN, cullout);
        put(STAKE, cullout);
        put(LUMBERJACK_STATION, cullout);
        put(LANTERN_HANGER, cullout);
        put(LOG_PILE, cullout);
        put(KEG, cullout);
        put(SMALL_CACTUS, cullout);
        put(PRIMSTEEL_BARS, cullout);
        put(BLOCK_WATTLE_AND_GLASS, cullout);
        put(BLOCK_WATTLE_AND_GLASS_PLUS, cullout);
        put(BLOCK_WATTLE_AND_GLASS_CROSS, cullout);
        put(BLOCK_WATTLE_AND_GLASS_PANE, cullout);
        put(BLOCK_WATTLE_AND_GLASS_PLUS_PANE, cullout);
        put(BLOCK_WATTLE_AND_GLASS_CROSS_PANE, cullout);
        put(TUMBLEWEED, cullout);
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
        put(WATTLE_LADDER, cullout);
        put(BAMBOO_LADDER, cullout);
        put(BRIMSTONE_CRYSTAL, cullout);
        put(BRIMSTONE_GLASS, translucent);
        put(BRIMSTONE_GLASS_PANE, translucent);
        put(BEACH_GRASS, cullout);
        put(ICEPLANT, cullout);
        put(NAUTILUS_SHELL_BLOCK, cullout);

        put(ICE_ORE, translucent);
        put(DEEPSLATE_ICE_ORE, translucent);

        put(DAUB_CHIMNEY, cullout);
        put(SANDSTONE_BRICK_CHIMNEY, cullout);
        put(RED_SANDSTONE_BRICK_CHIMNEY, cullout);
        put(SCORCHSTONE_BRICK_CHIMNEY, cullout);
        put(SALT_BRICK_CHIMNEY, cullout);
        put(SERPENTINITE_BRICK_CHIMNEY, cullout);
        put(BASALT_BRICK_CHIMNEY, cullout);
        put(ADVENTURINE_BRICK_CHIMNEY, cullout);
        put(PURPUR_BLOCK_CHIMNEY, cullout);
        put(END_STONE_BRICK_CHIMNEY, cullout);
        put(MARBLE_BRICK_CHIMNEY, cullout);
        put(CARMINE_BRICK_CHIMNEY, cullout);

        put(COBBLESTONE_BRICK_CHIMNEY, cullout);
        put(DIORITE_BRICK_CHIMNEY, cullout);
        put(GRANITE_BRICK_CHIMNEY, cullout);
        put(ANDESITE_BRICK_CHIMNEY, cullout);

        put(COBBLESTONE_CHIMNEY, cullout);
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
        put(SHALE_BRICK_CHIMNEY, cullout);
        put(CLOVER, cullout);

        put(COUNTER, cullout);
        put(COUNTER_CORNER, cullout);
        put(COUNTER_DRAWER, cullout);

        put(ARID_VINES_PLANT, cullout);
        put(ARID_VINES, cullout);
        
        put(ACACIA_SEED, cullout);
        put(AMBERBLOSSOM_SEED, cullout);
        put(APPLE_SEED, cullout);
        put(BIRCH_SEED, cullout);
        put(DARK_OAK_SEED, cullout);
        put(JUNGLE_SEED, cullout);
        put(OAK_SEED, cullout);
        put(SPRUCE_SEED, cullout);
        put(WARM_BIRCH_SEED, cullout);
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
