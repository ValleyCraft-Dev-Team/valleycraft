package net.linkle.valleycraft.init;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.*;

import net.fabricmc.fabric.api.registry.*;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.tag.TagKey;

public class Contents {
    public static void initialize() {
        compost();
        flammable();
        fuels();
        strips();
        oxidizables();
    }
    
    private static void oxidizables() {
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA.block, BlocksModded.SMALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA_EXPOSED.block, BlocksModded.SMALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA_WEATHERED.block, BlocksModded.SMALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA.block, BlocksModded.WAXED_SMALL_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_SMALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_SMALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_SMALL_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA.block, BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block, BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block, BlocksModded.MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA.block, BlocksModded.WAXED_MEDIUM_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA.block, BlocksModded.LARGE_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA_EXPOSED.block, BlocksModded.LARGE_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA_WEATHERED.block, BlocksModded.LARGE_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA.block, BlocksModded.WAXED_LARGE_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_LARGE_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_LARGE_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_LARGE_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA.block, BlocksModded.WALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA_EXPOSED.block, BlocksModded.WALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA_WEATHERED.block, BlocksModded.WALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA.block, BlocksModded.WAXED_WALL_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_WALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_WALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_WALL_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.WASTEBIN.block, BlocksModded.WASTEBIN_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.WASTEBIN_EXPOSED.block, BlocksModded.WASTEBIN_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.WASTEBIN_WEATHERED.block, BlocksModded.WASTEBIN_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.WASTEBIN.block, BlocksModded.WAXED_WASTEBIN.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_EXPOSED.block, BlocksModded.WAXED_WASTEBIN_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_WEATHERED.block, BlocksModded.WAXED_WASTEBIN_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_OXIDIZED.block, BlocksModded.WAXED_WASTEBIN_OXIDIZED.block);
    }
    
    private static void strips() {
        
    }

    @SuppressWarnings("unused")
    private static void compost() {
        Float levelUltraLow = 0.1f; // sticks
        Float levelVeryLow = 0.2f; // pie slices, incredibly small plants
        Float levelLow = 0.3f; // leaves, seeds, saplings, grass, doughs
        Float levelMed = 0.5f; // double plant, vines.
        Float levelHigh = 0.65f; // foods, flowers.
        Float levelHigher = 0.75f; // bugs.
        Float levelVeryHigh = 0.85f; // blocks.
        Float levelUltra = 1.0f; // specials.

        putCompost(Items.STICK, levelUltraLow);
        putCompost(Items.BAMBOO, levelUltraLow);

        putCompost(ItemsModded.AMETHYSTLE_SEEDS, levelLow);
        putCompost(ItemsModded.RICE_SEEDS, levelLow);
        putCompost(ItemsModded.PUFF_BALL_SEEDS, levelLow);
        putCompost(ItemsModded.ONION_SEEDS, levelLow);
        putCompost(ItemsModded.FIRE_PEPPER_SEEDS, levelLow);
        putCompost(ItemsModded.CAVE_ROOT_SEEDS, levelLow);
        putCompost(ItemsModded.ANCIENT_FLOWER_SEEDS, levelLow);
        putCompost(ItemsModded.OAK_SEED, levelLow);
        putCompost(ItemsModded.DARK_OAK_SEED, levelLow);
        putCompost(ItemsModded.SPRUCE_SEED, levelLow);
        putCompost(ItemsModded.BIRCH_SEED, levelLow);
        putCompost(ItemsModded.JUNGLE_SEED, levelLow);
        putCompost(ItemsModded.ACACIA_SEED, levelLow);
        putCompost(ItemsModded.APPLE_SEED, levelLow);
        putCompost(ItemsModded.AMBERBLOSSOM_SEED, levelLow);
        putCompost(ItemsModded.WARM_BIRCH_SEED, levelLow);

        putCompost(Armors.DRIPLEAF_HAT, levelHigh);
        putCompost(Armors.FLOWER_CROWN, levelHigh);
        putCompost(Armors.DIERDRA_LAUREL, levelHigh);
        putCompost(Armors.CLAM_BREASTPLATE, levelMed);

        putCompost(FoodIngredients.RAW_WORM, levelHigher);
        putCompost(ItemsModded.SNAIL_SHELL, levelHigher);
        putCompost(ItemsModded.CAVE_SNAIL_SHELL, levelHigher);
        putCompost(ItemsModded.SCULK_SNAIL_SHELL, levelHigher);
        putCompost(BlocksNatural.CLAM_BLOCK, levelHigh);
        putCompost(FoodRegular.COOKED_CLAM, levelHigher);

        putCompost(BlocksNatural.CHOCOLATE_CAKE, levelUltra);
        putCompost(BlocksNatural.CHEESE, levelUltra);
        putCompost(FoodRegular.CHORUS_FRUIT_PIE, levelUltra);
        putCompost(FoodRegular.CHORUS_FRUIT_PIE_SLICE, levelVeryLow);
        putCompost(FoodRegular.CHOCOLATE_PIE, levelUltra);
        putCompost(FoodRegular.CHOCOLATE_PIE_SLICE, levelVeryLow);
        putCompost(FoodRegular.CHOCOLATE_CAKE_SLICE, levelVeryLow);
        putCompost(FoodRegular.CAKE_SLICE, levelVeryLow);
        putCompost(FoodRegular.GLOW_BERRY_PIE, levelUltra);
        putCompost(FoodRegular.GLOW_BERRY_PIE_SLICE, levelVeryLow);
        putCompost(FoodRegular.SWEET_BERRY_PIE, levelUltra);
        putCompost(FoodRegular.SWEET_BERRY_PIE_SLICE, levelVeryLow);
        putCompost(FoodRegular.APPLE_PIE, levelUltra);
        putCompost(FoodRegular.APPLE_PIE_SLICE, levelVeryLow);

        putCompost(FoodRegular.CHOCOLATE_CHUNK_COOKIE, levelVeryHigh);
        putCompost(FoodRegular.PUMPKIN_SPICE_COOKIE, levelVeryHigh);
        putCompost(FoodRegular.VANILLA_PUMPKIN_SPICE_COOKIE, levelVeryHigh);
        putCompost(FoodRegular.CHOCOLATE_PUMPKIN_SPICE_COOKIE, levelVeryHigh);
        putCompost(FoodRegular.SUGAR_COOKIE, levelVeryHigh);

        putCompost(ItemsModded.FLOUR, levelVeryHigh);
        putCompost(ItemsModded.MAIZE_FLOUR, levelVeryHigh);

        putCompost(ItemsModded.SALTPETER, levelHigh);
        putCompost(ItemsModded.DRIED_FIBER, levelMed);
        putCompost(ItemsModded.FIBER, levelLow);

        putCompost(FoodIngredients.STAMINELLA_BERRY, levelVeryHigh);
        putCompost(FoodIngredients.ALOE_VERA, levelHigh);
        putCompost(FoodIngredients.AMETHYSTLE, levelHigh);
        putCompost(FoodIngredients.ENDURA_CARROT, levelVeryHigh);
        putCompost(FoodIngredients.HEARTY_BEETROOT, levelVeryHigh);
        putCompost(FoodIngredients.ONION, levelHigh);
        putCompost(FoodIngredients.FIRE_PEPPER, levelHigh);
        putCompost(FoodIngredients.MAIZE, levelHigh);
        putCompost(FoodIngredients.ANCIENT_FLOWER, levelHigh);
        putCompost(FoodIngredients.CAVE_ROOT, levelHigh);
        putCompost(FoodIngredients.MINERS_LETTUCE, levelHigh);
        putCompost(FoodIngredients.RAW_RICE, levelHigh);
        putCompost(FoodIngredients.PUMPKIN_SLICE, levelLow);
        putCompost(FoodIngredients.RAW_TRIPE, levelLow);
        putCompost(FoodIngredients.RAW_SILVERFISH, levelLow);
        putCompost(FoodIngredients.RAW_ENDERMITE, levelLow);
        putCompost(FoodIngredients.ZOD, levelLow);
        putCompost(BlocksNatural.STALWART_SHROOM, levelVeryHigh);
        putCompost(BlocksNatural.SHIVERCAP, levelVeryHigh);

        putCompost(FoodRegular.BAKED_APPLE, levelVeryHigh);
        putCompost(FoodRegular.BAKED_BEETROOT, levelVeryHigh);
        putCompost(FoodRegular.BAKED_HEARTY_BEETROOT, levelVeryHigh);
        putCompost(FoodRegular.BAKED_CARROT, levelVeryHigh);
        putCompost(FoodRegular.BAKED_ENDURA_CARROT, levelVeryHigh);
        putCompost(FoodRegular.BAKED_FIRE_PEPPER, levelVeryHigh);
        putCompost(FoodRegular.BAKED_PUMPKIN_SLICE, levelVeryHigh);
        putCompost(FoodRegular.BAKED_MELON_SLICE, levelVeryHigh);
        putCompost(FoodRegular.BAKED_ONION, levelVeryHigh);
        putCompost(FoodRegular.BAKED_SWEET_BERRIES, levelVeryHigh);
        putCompost(FoodRegular.BAKED_GLOW_BERRIES, levelVeryHigh);
        putCompost(FoodRegular.BAKED_SEEDS, levelMed);
        putCompost(FoodRegular.COOKED_RICE, levelVeryHigh);
        putCompost(FoodRegular.COOKED_CAVE_ROOT, levelVeryHigh);
        putCompost(FoodRegular.DRIED_GLOW_KELP, levelLow);
        putCompost(FoodRegular.DRIED_ORANGE_KELP, levelLow);
        putCompost(Items.EGG, levelHigh);
        putCompost(FoodRegular.FRIED_EGG, levelVeryHigh);
        putCompost(FoodRegular.CORN_BREAD, levelVeryHigh);
        putCompost(FoodRegular.HARDTACK, levelHigh);

        putCompost(FoodIngredients.HARDTACK_DOUGH, levelLow);
        putCompost(FoodIngredients.BREAD_DOUGH, levelLow);
        putCompost(FoodIngredients.CORN_BREAD_DOUGH, levelLow);
        putCompost(FoodIngredients.COOKIE_DOUGH, levelLow);
        putCompost(FoodIngredients.SUGAR_COOKIE_DOUGH, levelLow);
        putCompost(FoodIngredients.CHOCOLATE_CHUNK_COOKIE_DOUGH, levelLow);
        putCompost(FoodIngredients.PUMPKIN_SPICE_COOKIE_DOUGH, levelLow);
        putCompost(FoodIngredients.PUMPKIN_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.CHOCOLATE_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.APPLE_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.SWEET_BERRY_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.GLOW_BERRY_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.CHORUS_FRUIT_PIE_DOUGH, levelLow);
        putCompost(FoodIngredients.CAKE_DOUGH, levelLow);
        putCompost(FoodIngredients.CHOCOLATE_CAKE_DOUGH, levelLow);
        putCompost(FoodIngredients.VANILLA_FROSTING, levelLow);

        putCompost(BlocksNatural.FADED_SOUL_ROSE, levelHigh);
        putCompost(BlocksNatural.SOUL_ROSE, levelVeryHigh);
        putCompost(BlocksNatural.BLUE_SOUL_ROSE, levelUltra);
        putCompost(BlocksNatural.ARID_VINES, levelMed);
        putCompost(BlocksNatural.ARID_VINES_PLANT, levelMed);
        putCompost(BlocksNatural.WARM_BIRCH_LEAVES, levelLow);
        putCompost(BlocksNatural.WARM_BIRCH_SAPLING, levelLow);
        putCompost(BlocksNatural.APPLE_LEAVES, levelLow);
        putCompost(BlocksNatural.APPLE_SAPLING, levelLow);
        putCompost(BlocksNatural.APPLE_LEAVES_EMPTY, levelLow);
        putCompost(BlocksNatural.MAMON_LEAVES, levelLow);
        putCompost(BlocksNatural.MAMON_SAPLING, levelLow);
        putCompost(BlocksNatural.ALGAE, levelVeryLow);
        putCompost(BlocksNatural.SMALLEST_LILYPADS, levelMed);
        putCompost(BlocksNatural.SMALL_LILYPAD, levelLow);
        putCompost(BlocksNatural.SMALL_LILYPADS, levelMed);
        putCompost(BlocksNatural.GLOW_SEAGRASS, levelLow);
        putCompost(BlocksNatural.ORANGE_SEAGRASS, levelLow);
        putCompost(BlocksNatural.GLOW_KELP, levelLow);
        putCompost(BlocksNatural.ORANGE_KELP, levelLow);
        putCompost(BlocksNatural.ORANGE_KELP_PLANT, levelLow);
        putCompost(BlocksNatural.GLOW_KELP_PLANT, levelLow);
        putCompost(BlocksNatural.ICEPLANT, levelLow);
        putCompost(BlocksNatural.BEACH_GRASS, levelLow);
        putCompost(BlocksNatural.NEST, levelLow);
        putCompost(BlocksNatural.YELLOW_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.WHITE_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.RED_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.PURPLE_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.PINK_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.BLUE_FLOWERING_LILYPAD, levelHigh);
        putCompost(BlocksNatural.RUSHES, levelLow);
        putCompost(BlocksNatural.CATTAILS, levelMed);
        putCompost(BlocksNatural.DESERT_SHRUB, levelLow);
        putCompost(BlocksNatural.BUSH, levelLow);
        putCompost(BlocksNatural.LARGE_BUSH, levelMed);
        putCompost(BlocksNatural.LUSH_BUSH, levelLow);
        putCompost(BlocksNatural.TALL_LIVING_BUSH, levelMed);
        putCompost(BlocksNatural.TALL_DEAD_BUSH, levelMed);
        putCompost(Blocks.DEAD_BUSH, levelLow);
        putCompost(BlocksNatural.MIMIC_FLOWER, levelHigh);
        putCompost(BlocksNatural.WILD_AMETHYSTLE, levelHigh);
        putCompost(BlocksNatural.WILD_BEET, levelHigh);
        putCompost(BlocksNatural.WILD_CARROT, levelHigh);
        putCompost(BlocksNatural.WILD_CAVE_ROOT, levelHigh);
        putCompost(BlocksNatural.WILD_HERBS, levelHigh);
        putCompost(BlocksNatural.WILD_FIRE_PEPPER, levelHigh);
        putCompost(BlocksNatural.WILD_MINERS_LETTUCE, levelHigh);
        putCompost(BlocksNatural.WILD_ONION, levelHigh);
        putCompost(BlocksNatural.WILD_POTATO, levelHigh);
        putCompost(BlocksNatural.WILD_PUFF_BALL, levelHigh);
        putCompost(BlocksNatural.WILD_RICE, levelHigh);
        putCompost(BlocksNatural.WILD_WHEAT, levelHigh);
        putCompost(BlocksNatural.WEEPING_GHOST_WILLOW, levelHigh);
        putCompost(BlocksNatural.MEADOW_FLOWERS, levelHigh);
        putCompost(BlocksNatural.SPROUT, levelMed);
        putCompost(BlocksNatural.MOSS_SPROUTLET, levelLow);
        putCompost(BlocksNatural.SHORT_GRASS, levelLow);
        putCompost(BlocksNatural.SNOWFLOWER, levelHigh);
        putCompost(BlocksNatural.MOREL, levelHigh);
        putCompost(BlocksNatural.JUNGLE_CAP, levelHigh);
        putCompost(BlocksNatural.JUNGLE_CAP_CLUSTER, levelUltra);
        putCompost(BlocksNatural.TALL_LAVENDER, levelHigh);
        putCompost(BlocksNatural.RED_CLUSTER, levelUltra);
        putCompost(BlocksNatural.BROWN_CLUSTER, levelUltra);
        putCompost(BlocksNatural.TALL_ALLIUM, levelHigh);
        putCompost(BlocksNatural.TALL_AZURE_BLUET, levelHigh);
        putCompost(BlocksNatural.SPORE_SPREADER, levelHigh);
        putCompost(BlocksNatural.LAVENDER, levelHigh);
        putCompost(BlocksNatural.GLOW_CAP, levelHigh);
        putCompost(BlocksNatural.GLOW_CAP_CLUSTER, levelUltra);
        putCompost(BlocksNatural.FAN_MOLD, levelMed);
        putCompost(BlocksNatural.WHITE_POPPY, levelHigh);
        putCompost(BlocksNatural.TALL_CORNFLOWER, levelHigh);
        putCompost(BlocksNatural.TALL_OXEYE_DAISY, levelHigh);
        putCompost(BlocksNatural.YELLOW_POPPY, levelHigh);
        putCompost(BlocksNatural.ORANGE_POPPY, levelHigh);
        putCompost(BlocksNatural.LILY_OF_THE_MOUNTAINS, levelHigh);
        putCompost(BlocksNatural.POISON_BLOSSOM, levelHigh);
        putCompost(BlocksNatural.GODDESS_LILY, levelHigh);
        putCompost(BlocksNatural.KNAPWEED, levelHigh);
        putCompost(BlocksNatural.PINK_LUPINE, levelHigh);
        putCompost(BlocksNatural.RED_LUPINE, levelHigh);
        putCompost(BlocksNatural.YELLOW_LUPINE, levelHigh);
        putCompost(BlocksNatural.PURPLE_TULIP, levelHigh);
        putCompost(BlocksNatural.YELLOW_TULIP, levelHigh);
        putCompost(BlocksNatural.LIGHT_BLUE_TULIP, levelHigh);
        putCompost(BlocksNatural.LEATHERLEAF_FERN, levelHigh);
        putCompost(BlocksNatural.BIG_FERN, levelVeryHigh);
        putCompost(BlocksNatural.BLACK_TULIP, levelHigh);
        putCompost(BlocksNatural.ORANGE_BEAUTY, levelHigh);
        putCompost(BlocksNatural.HONEYCLUSTER, levelHigh);
        putCompost(BlocksNatural.CLOVER, levelHigh);
        putCompost(BlocksNatural.BLACK_DAHLIA, levelHigh);
        putCompost(BlocksNatural.PANFLOWERS, levelHigh);
        putCompost(BlocksNatural.JUNGLE_BUSH, levelHigh);
        putCompost(BlocksNatural.FOXTAIL_FERN, levelHigh);
        putCompost(BlocksNatural.FLUFFY_DANDELION, levelHigh);
        putCompost(BlocksNatural.THORNY_BUSH, levelHigh);
        putCompost(BlocksNatural.TUMBLEWEED, levelHigh);
        putCompost(BlocksNatural.SMALL_CACTUS, levelHigh);
        putCompost(BlocksNatural.FLOWERING_CACTUS, levelHigh);

        putCompost(BlocksModded.FIBER_BALE, levelHigh);
        putCompost(BlocksModded.SUGARCANE_BALE, levelVeryHigh);
        putCompost(BlocksModded.GLOW_KELP_BLOCK, levelMed);
        putCompost(BlocksModded.ORANGE_KELP_BLOCK, levelMed);
    }
    
    private static void flammable() {
        
    }
    
    private static void fuels() {
        putFuels(BlocksModded.CHARCOAL_BLOCK, 16000);
        putFuels(BlocksNatural.GLOW_CAP, 800);
        putFuels(BlocksNatural.GLOW_CAP_CLUSTER, 2400);
        putFuels(BlocksNatural.CATTAILS, 100);
        putFuels(ItemsModded.PUFF_BALL, 100);
        putFuels(ItemsModded.CLOTH, 100);
        putFuels(ItemsModded.PLANT_FIBER_CANVAS, 100);
        putFuels(ItemsModded.PLANT_FIBER_STRING, 100);
        putFuels(ItemsModded.FIBER, 100);
        putFuels(ItemsModded.DRIED_FIBER, 100);
        putFuels(ItemsModded.PLANK, 150);
        putFuels(FoodIngredients.FIRE_PEPPER, 50);
        putFuels(ItemsModded.HANDLE, 250);
        putFuels(ItemsModded.REINFORCED_HANDLE, 250);
        putFuels(ItemsModded.STURDY_HANDLE, 250);
        putFuels(ItemsModded.COAL_NUGGET, 400);
        putFuels(ItemsModded.ANTHRACITE, 1600);
        putFuels(BlocksModded.ANTHRACITE_BLOCK, 16000);
        putFuels(ItemsModded.BRIMSTONE_SHARD, 800);
        putFuels(Items.BLAZE_POWDER, 1200);
        putFuels(Items.NETHER_STAR, 32000);
        putFuels(ItemsModded.STRANGE_CATALYST, 32000);
        putFuels(ItemsModded.THERMAL_BLAZE_CORE, 4000);

        putFuels(Tools.KNIFE_WOODEN, 200);
        putFuels(Tools.GREATSWORD_WOODEN, 200);
        putFuels(Tools.TRAVELER_WOODEN, 200);
        putFuels(Tools.DAGGER_WOODEN, 200);
        putFuels(Tools.SCYTHE_WOODEN, 200);
        putFuels(Tools.WOODCUTTER_AXE_WOODEN, 200);
        putFuels(Tools.HATCHET_WOODEN, 200);
        putFuels(Tools.WOODEN_OAR, 200);
        putFuels(Tools.BRANCH, 400);
        putFuels(Tools.DRIFTWOOD_BRANCH, 400);
        putFuels(Tools.WOODEN_STAFF, 300);
        putFuels(Tools.BAMBOO_STAFF, 300);

        putFuels(BlocksNatural.OAK_SEED, 100);
        putFuels(BlocksNatural.BIRCH_SEED, 100);
        putFuels(BlocksNatural.SPRUCE_SEED, 100);
        putFuels(BlocksNatural.ACACIA_SEED, 100);
        putFuels(BlocksNatural.DARK_OAK_SEED, 100);
        putFuels(BlocksNatural.JUNGLE_SEED, 100);
        putFuels(BlocksNatural.APPLE_SEED, 100);
        putFuels(BlocksNatural.AMBERBLOSSOM_SEED, 100);
        putFuels(BlocksNatural.WARM_BIRCH_SEED, 100);
    }
    
    private static void putStrip(BlockConvertible input, BlockConvertible stripped) {
        StrippableBlockRegistry.register(input.asBlock(), stripped.asBlock());
    }
    
    private static void putCompost(ItemConvertible item, Float chance) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }
    
    private static void putFlammable(BlockConvertible block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block.asBlock(), burn, spread);;
    }
    
    private static void putFuels(ItemConvertible item, Integer tick) {
        FuelRegistry.INSTANCE.add(item, tick);
    }
    
    private static void putFuels(TagKey<Item> tag, Integer tick) {
        FuelRegistry.INSTANCE.add(tag, tick);
    }
}
