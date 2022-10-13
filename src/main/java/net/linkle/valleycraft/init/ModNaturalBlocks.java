package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.*;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.block.sapling.AppleSaplingGen;
import net.linkle.valleycraft.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;
import net.minecraft.util.shape.VoxelShape;

public class ModNaturalBlocks {
    // VoxelShapes used by various plant blocks
    public static VoxelShape DEFAULT_PLANT_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static VoxelShape SHORT_GRASS_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 7, 14);
    public static VoxelShape FLOWER_SHAPE = Block.createCuboidShape(5, 0, 5, 11, 10, 11);

    public static final Block DRY_DIRT = new Block(Block.Settings.copy(Blocks.COARSE_DIRT));
    public static final Block SANDY_GRAVEL = new FallingBlock(Block.Settings.copy(Blocks.GRAVEL));
    public static final Block ARID_MOSSY_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block MOSSY_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE_COBBLESTONE = new Block(Block.Settings.copy(Blocks.COBBLESTONE));
    public static final Block DIABASE = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE));
    public static final Block SERPENTINITE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block GRIMESTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block LIMESTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block SHIVERSTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VERDANTINE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VOLCANIC_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VOLCANIC_ASH = new FallingBlock(Block.Settings.copy(Blocks.SAND));
    public static final Block PUMICE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block SALT_ORE = new Block(Block.Settings.copy(Blocks.COAL_ORE));
    public static final Block NETHER_SALT_ORE = new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
    public static final Block NETHER_COAL_ORE = new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
    public static final Block NETHER_FOSSIL_ORE = new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE));
    public static final Block APPLE_LOG = new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG));

    public static final Block BEE_NEST_WALL = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));

    public static final Block GHOST_PUMPKIN = new GhostPumpkinBlock();

    public static final Block BLACK_DAHLIA = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block BLACK_TULIP = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block FLOWERING_CACTUS = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE).ground(BlockPres.SAND);
    public static final Block FLUFFY_DANDELION = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block FOXTAIL_FERN = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);

    public static final Block GILDED_CAP = new ModMushroomBlock().large();
    public static final Block GLOW_CAP = new ModMushroomBlock().large();
    public static final Block GLOW_CAP_CLUSTER = new ModMushroomBlock().large();
    public static final Block GODDESS_LILY = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block HONEYCLUSTER = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block STALWART_SHROOM = new StalwartBlock().large();
    public static final Block SOULSPORE = new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 5).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).shape(Block.createCuboidShape(4, 0, 4, 12, 9, 12));
    public static final Block SOULSPORE_SINGLE = new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 5).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).shape(Block.createCuboidShape(5, 0, 5, 11, 6, 11));
    public static final Block IRONSHROOM = new ModMushroomBlock().large();
    public static final Block JUNGLE_CAP = new ModMushroomBlock().large();
    public static final Block JUNGLE_CAP_CLUSTER = new ModMushroomBlock().large();

    public static final Block LAVENDER = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block LEATHERLEAF_FERN = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block LIGHT_BLUE_TULIP = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block MOSS_SPROUTLET = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block MOREL = new ModMushroomBlock().large();
    public static final Block ORANGE_BEAUTY = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block ORANGE_FERN = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block PINK_LUPINE = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block POISON_BLOSSOM = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block PURPLE_TULIP = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block RED_LUPINE = new OffsetPlantBlock(FLOWER_SHAPE);
	//public static final Block ROOTED_WATCHER = new ModPlantBlock();
    public static final Block SHIVERCAP = new ShivercapBlock().large();
    public static final Block SHORT_GRASS = new OffsetPlantBlock(SHORT_GRASS_SHAPE);
    public static final Block SNOWFLOWER = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block SPROUT = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block THORNY_BUSH = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    //public static final Block WARDING_SHROOM = new ModPlantBlock();
    public static final Block WEEPING_GHOST_WILLOW = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_BEET = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_CARROT = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_MINERS_LETTUCE = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_POTATO = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_WHEAT = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_FIRE_PEPPER = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_ONION = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_CAVE_ROOT = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_RICE = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_HERBS = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);

    public static final Block WILD_AMETHYSTLE = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block WILD_PUFF_BALL = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);

    public static final Block YELLOW_LUPINE = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block YELLOW_TULIP = new OffsetPlantBlock(FLOWER_SHAPE);

    public static final Block PANFLOWERS = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block JUNGLE_BUSH = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block FROSTFERN = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    
    public static final Block TALL_LIVING_BUSH = new ModTallFlowerBlock();
    public static final Block TALL_DEAD_BUSH = new ModTallPlantBlock().ground(BlockPres.SAND);
    public static final Block TALL_CORNFLOWER = new ModTallFlowerBlock();
    public static final Block TALL_OXEYE_DAISY = new ModTallFlowerBlock();
    public static final Block TALL_ALLIUM = new ModTallFlowerBlock();
    public static final Block TALL_LAVENDER = new ModTallFlowerBlock();
    public static final Block TALL_AZURE_BLUET = new ModTallFlowerBlock();
    
    // crops
    public static final Block MAIZE = new MaizeBlock();
    public static final Block MAIZE_BOX = new MaizeBoxBlock();
    public static final Block RICES = new MultiCropBlock(MultiCropBlock.settings());
    public static final Block PUFF_BALL = new MultiCropBlock(MultiCropBlock.settings()).genSize(3, 13/16f);
    public static final Block ONIONS = new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 13/16f);
    public static final Block MINERS_LETTUCES = new MultiCropBlock(MultiCropBlock.settings()).genSize(0, 12/16f);
    public static final Block FIRE_PEPPERS = new MultiCropBlock(MultiCropBlock.settings());
    public static final Block CAVE_ROOT_CROP = new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 10/16f);
    public static final Block ANCIENT_FLOWERS = new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 12/16f);
    public static final Block AMETHYSTLES = new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 12/16f);
    public static final Block ALOE_VERAS = new BushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)).ground(BlockPres.SAND).AloeShape();

    public static final Block BONE_JOINT = new Block(Block.Settings.copy(Blocks.BONE_BLOCK));
    public static final Block ROCKS = new RockBlock();
    public static final Block FLINT_ROCKS = new RockBlock();

    public static final Block CLARET_LEAF = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    //public static final Block STICKY_SHROOM = new ModLargerMushroomBlock();
    public static final Block GOOP_CAP = new ModMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 2)).large();
    public static final Block ORANGE_POPPY = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block YELLOW_POPPY = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block WHITE_POPPY = new OffsetPlantBlock(FLOWER_SHAPE);
    public static final Block CAVE_ROOTS = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block DESERT_SHRUB = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block BUSH = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block LARGE_BUSH = new ModPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block BONE_WEED = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block LIVING_BUSH = new OffsetPlantBlock(DEFAULT_PLANT_SHAPE);

    public static final Block BIG_FERN = new ModPlantBlock(DEFAULT_PLANT_SHAPE);
    public static final Block RED_CLUSTER = new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM)).large();
    public static final Block BROWN_CLUSTER = new ModMushroomBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM)).large();
    //public static final Block BIG_RED = new ModPlantBlock(Block.Settings.copy(Blocks.RED_MUSHROOM));
    //public static final Block BIG_BROWN = new ModPlantBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM));
    public static final Block SMALLEST_LILYPADS = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block SMALL_LILYPADS = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block SMALL_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block YELLOW_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block WHITE_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block RED_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block PURPLE_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block PINK_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block BLUE_FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    public static final Block ALGAE = new AlgaeBlock();
    public static final Block GLOW_KELP = new GlowKelpBlock();
    public static final Block GLOW_KELP_PLANT = new GlowKelpPlantBlock();
    public static final Block ORANGE_KELP = new OrangeKelpBlock();
    public static final Block ORANGE_KELP_PLANT = new OrangeKelpPlantBlock();

    public static final Block GLOOM_BERRY = new GloomBerryHeadBlock();
    public static final Block GLOOM_BERRY_PLANT = new GloomBerryBodyBlock();
    
    public static final Block APPLE_LEAVES_EMPTY = new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES));
    public static final Block APPLE_LEAVES = new AppleLeavesBlock();
    public static final Block APPLE_SAPLING = new SaplingBlock(new AppleSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING));

    public static final Block MAMON_LOG = new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG));

    public static final Block SLUDGE_FLUID = new SludgeFluidBlock(ModFluids.SLUDGE_STILL);
    
    public static final Block ARID_VINES = new VineBlock(Block.Settings.copy(Blocks.POPPY));
    public static final Block CAVE_MOSS = new CaveMossBlock();
    public static final Block CRYSTAL_CAVE_MOSS = new CaveMossBlock();
    public static final Block ERDCOBBLESTONE = new Block(Block.Settings.copy(Blocks.COBBLESTONE).hardness(2));
    public static final Block CRACKED_COBBLESTONE = new Block(Block.Settings.copy(Blocks.COBBLESTONE).hardness(2));
    public static final Block ERDSTONE = new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2));
    public static final Block ADVENTURINE = new Block(Block.Settings.copy(Blocks.STONE).hardness(25).luminance(s ->1));
    public static final Block GOLEMITE_ERDSTONE_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2));
    public static final Block ERDSTONE_AMBER_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2));
    public static final Block ERDSTONE_FOSSIL_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2));

    public static final Block FOSSIL_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE));
    public static final Block AMBER_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE));
    public static final Block ERDSTONE_COAL_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2));

    public static final Block ORANGE_SEAGRASS = new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS));
    public static final Block PRIMSTEEL_ORE = new Block(Block.Settings.copy(Blocks.IRON_ORE));
    public static final Block PRIMSTEEL_DEEPSLATE_ORE = new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE));
    public static final Block SCORCHSTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block DEEPSLATE_FOSSIL_ORE = new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE));
    public static final Block FALLING_ROCKS = new FallingRockBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.NETHER_BRICKS));

    public static void initialize() {
        Reg.registerWithItem("black_dahlia", BLACK_DAHLIA, itemSettings());
        Reg.registerWithItem("flowering_cactus", FLOWERING_CACTUS, itemSettings());
        Reg.registerWithItem("fluffy_dandelion", FLUFFY_DANDELION, itemSettings());
        Reg.registerWithItem("foxtail_fern", FOXTAIL_FERN, itemSettings());
        Reg.registerWithItem("jungle_bush", JUNGLE_BUSH, itemSettings());
        Reg.registerWithItem("panflowers", PANFLOWERS, itemSettings());

        Reg.registerWithItem("honeycluster", HONEYCLUSTER, itemSettings());
        Reg.registerWithItem("lavender", LAVENDER, itemSettings());
        Reg.registerWithItem("leatherleaf_fern", LEATHERLEAF_FERN, itemSettings());
        Reg.registerWithItem("moss_sproutlet", MOSS_SPROUTLET, itemSettings());
        Reg.registerWithItem("orange_beauty", ORANGE_BEAUTY, itemSettings());
        Reg.registerWithItem("orange_fern", ORANGE_FERN, itemSettings());
        Reg.registerWithItem("poison_blossom", POISON_BLOSSOM, itemSettings());
        Reg.registerWithItem("purple_tulip", PURPLE_TULIP, itemSettings());
        Reg.registerWithItem("yellow_tulip", YELLOW_TULIP, itemSettings());
        Reg.registerWithItem("light_blue_tulip", LIGHT_BLUE_TULIP, itemSettings());
        Reg.registerWithItem("black_tulip", BLACK_TULIP, itemSettings());
        Reg.registerWithItem("frostfern", FROSTFERN, itemSettings());
        Reg.registerWithItem("claret_leaf", CLARET_LEAF, itemSettings());
        Reg.registerWithItem("goddess_lily", GODDESS_LILY, itemSettings());

        Reg.registerWithItem("red_lupine", RED_LUPINE, itemSettings());
        Reg.registerWithItem("yellow_lupine", YELLOW_LUPINE, itemSettings());
        Reg.registerWithItem("pink_lupine", PINK_LUPINE, itemSettings());

        Reg.registerWithItem("orange_poppy", ORANGE_POPPY, itemSettings());
        Reg.registerWithItem("yellow_poppy", YELLOW_POPPY, itemSettings());
        Reg.registerWithItem("white_poppy", WHITE_POPPY, itemSettings());
        
        Reg.registerWithItem("tall_azure_bluet", TALL_AZURE_BLUET, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_allium", TALL_ALLIUM, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_cornflower", TALL_CORNFLOWER, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_dead_bush", TALL_DEAD_BUSH, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_lavender", TALL_LAVENDER, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_living_bush", TALL_LIVING_BUSH, itemSettings(), TallBlockItem::new);
        Reg.registerWithItem("tall_oxeye_daisy", TALL_OXEYE_DAISY, itemSettings(), TallBlockItem::new);

        Reg.registerWithItem("bee_nest_wall", BEE_NEST_WALL, itemSettings());

        //mushrooms that can cluster
        Reg.registerWithItem("red_cluster", RED_CLUSTER, itemSettings());
        //Reg.registerWithItem("big_red_mushroom", BIG_RED, itemSettings());
        Reg.registerWithItem("brown_cluster", BROWN_CLUSTER, itemSettings());
        //Reg.registerWithItem("big_brown_mushroom", BIG_BROWN, itemSettings());
        Reg.registerWithItem("glow_cap", GLOW_CAP, itemSettings());
        Reg.registerWithItem("glow_cap_cluster", GLOW_CAP_CLUSTER, itemSettings());
        Reg.registerWithItem("jungle_cap", JUNGLE_CAP, itemSettings());
        Reg.registerWithItem("jungle_cap_cluster", JUNGLE_CAP_CLUSTER, itemSettings());
        Reg.registerWithItem("soulspore_single", SOULSPORE_SINGLE, itemSettings().rarity(Rarity.UNCOMMON));
        Reg.registerWithItem("soulspore", SOULSPORE, itemSettings().rarity(Rarity.RARE));

        //non-clustering mushrooms
        //Reg.registerWithItem("sticky_shroom", STICKY_SHROOM, itemSettings());
        Reg.registerWithItem("morel", MOREL, itemSettings());
        Reg.registerWithItem("shivercap", SHIVERCAP, itemSettings().group(INGREDIENTS));
        Reg.registerWithItem("stalwart_shroom", STALWART_SHROOM, itemSettings().group(INGREDIENTS));
        //Reg.registerWithItem("warding_shroom", WARDING_SHROOM, itemSettings());
        Reg.registerWithItem("goop_cap", GOOP_CAP, itemSettings());
        Reg.registerWithItem("gilded_cap", GILDED_CAP, itemSettings());
        Reg.registerWithItem("ironshroom", IRONSHROOM, itemSettings());
        //Reg.registerWithItem("rooted_watcher", ROOTED_WATCHER, itemSettings());

        Reg.registerWithItem("short_grass", SHORT_GRASS, itemSettings());
        Reg.registerWithItem("snowflower", SNOWFLOWER, itemSettings());
        Reg.registerWithItem("sprout", SPROUT, itemSettings());
        Reg.registerWithItem("thorny_bush", THORNY_BUSH, itemSettings());
        Reg.registerWithItem("weeping_ghost_willow", WEEPING_GHOST_WILLOW, itemSettings());

        Reg.registerWithItem("wild_wheat", WILD_WHEAT, itemSettings());
        Reg.registerWithItem("wild_potato", WILD_POTATO, itemSettings());
        Reg.registerWithItem("wild_carrot", WILD_CARROT, itemSettings());
        Reg.registerWithItem("wild_beet", WILD_BEET, itemSettings());

        Reg.registerWithItem("wild_miners_lettuce", WILD_MINERS_LETTUCE, itemSettings());
        Reg.registerWithItem("wild_fire_pepper", WILD_FIRE_PEPPER, itemSettings());
        Reg.registerWithItem("wild_rice", WILD_RICE, itemSettings());
        Reg.registerWithItem("wild_amethystle", WILD_AMETHYSTLE, itemSettings());
        Reg.registerWithItem("wild_cave_root", WILD_CAVE_ROOT, itemSettings());
        Reg.registerWithItem("wild_onion", WILD_ONION, itemSettings());
        Reg.registerWithItem("wild_herbs", WILD_HERBS, itemSettings());
        Reg.registerWithItem("wild_puff_ball", WILD_PUFF_BALL, itemSettings());

        Reg.register("maize", MAIZE);
        Reg.register("maize_box", MAIZE_BOX);
        Reg.register("rices", RICES);
        Reg.register("puff_ball", PUFF_BALL);
        Reg.register("onions", ONIONS);
        Reg.register("miners_lettuces", MINERS_LETTUCES);
        Reg.register("fire_peppers", FIRE_PEPPERS);
        Reg.register("cave_root_crop", CAVE_ROOT_CROP);
        Reg.register("ancient_flowers", ANCIENT_FLOWERS);
        Reg.register("amethystles", AMETHYSTLES);
        Reg.register("aloe_veras", ALOE_VERAS);

        Reg.registerWithItem("cave_roots", CAVE_ROOTS, itemSettings());
        Reg.registerWithItem("bone_weed", BONE_WEED, itemSettings());
        Reg.registerWithItem("desert_shrub", DESERT_SHRUB, itemSettings());
        Reg.registerWithItem("bush", BUSH, itemSettings());
        Reg.registerWithItem("large_bush", LARGE_BUSH, itemSettings());
        Reg.registerWithItem("lush_bush", LIVING_BUSH, itemSettings());

        Reg.registerWithItem("big_fern", BIG_FERN, itemSettings());
        Reg.registerWithItem("smallest_lilypads", SMALLEST_LILYPADS, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("small_lilypads", SMALL_LILYPADS, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("small_lilypad", SMALL_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("yellow_flowering_lilypad", YELLOW_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("white_flowering_lilypad", WHITE_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("red_flowering_lilypad", RED_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("purple_flowering_lilypad", PURPLE_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("pink_flowering_lilypad", PINK_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);
        Reg.registerWithItem("blue_flowering_lilypad", BLUE_FLOWERING_LILYPAD, itemSettings(), LilyPadItem::new);

        Reg.register("gloom_berry", GLOOM_BERRY);
        Reg.register("gloom_berry_plant", GLOOM_BERRY_PLANT);

        Reg.registerWithItem("glow_kelp", GLOW_KELP, itemSettings());
        Reg.register("glow_kelp_plant", GLOW_KELP_PLANT);
        Reg.registerWithItem("orange_kelp", ORANGE_KELP, itemSettings());
        Reg.register("orange_kelp_plant", ORANGE_KELP_PLANT);

        Reg.register("algae", ALGAE);
        Reg.register("algae", new LilyPadItem(ALGAE, itemSettings()));
        Reg.registerWithItem("orange_seagrass", ORANGE_SEAGRASS, itemSettings());

        //mamon
        Reg.registerWithItem("mamon_log", MAMON_LOG, itemSettings());
        //apple
        Reg.registerWithItem("apple_sapling", APPLE_SAPLING, itemSettings());
        Reg.registerWithItem("apple_leaves_empty", APPLE_LEAVES_EMPTY, itemSettings());
        Reg.registerWithItem("apple_leaves", APPLE_LEAVES, itemSettings());
        Reg.registerWithItem("apple_log", APPLE_LOG, itemSettings());

        Reg.registerWithItem("arid_vines", ARID_VINES, itemSettings());
        Reg.registerWithItem("cave_moss", CAVE_MOSS, itemSettings());
        Reg.registerWithItem("crystal_cave_moss", CRYSTAL_CAVE_MOSS, itemSettings());

        Reg.registerWithItem("ghost_pumpkin", GHOST_PUMPKIN, itemSettings());

        Reg.register("sludge_fluid", SLUDGE_FLUID);

        Reg.registerWithItem("dry_dirt", DRY_DIRT, itemSettings());
        Reg.registerWithItem("sandy_gravel", SANDY_GRAVEL, itemSettings());
        Reg.registerWithItem("arid_mossy_stone", ARID_MOSSY_STONE, itemSettings());
        Reg.registerWithItem("mossy_stone", MOSSY_STONE, itemSettings());
        Reg.registerWithItem("carmine", CARMINE, itemSettings());
        Reg.registerWithItem("carmine_cobblestone", CARMINE_COBBLESTONE, itemSettings());
        Reg.registerWithItem("diabase", DIABASE, itemSettings());
        Reg.registerWithItem("serpentinite", SERPENTINITE, itemSettings());
        Reg.registerWithItem("grimestone", GRIMESTONE, itemSettings());
        Reg.registerWithItem("limestone", LIMESTONE, itemSettings());
        Reg.registerWithItem("shiverstone", SHIVERSTONE, itemSettings());
        Reg.registerWithItem("verdantine", VERDANTINE, itemSettings());
        Reg.registerWithItem("pumice", PUMICE, itemSettings());

        Reg.registerWithItem("volcanic_stone", VOLCANIC_STONE, itemSettings());
        Reg.registerWithItem("volcanic_ash", VOLCANIC_ASH, itemSettings());
        Reg.registerWithItem("rocks", ROCKS, itemSettings().group(ModGroups.VC_ITEMS));
        Reg.registerWithItem("flint_rocks", FLINT_ROCKS, itemSettings().group(FLORA_GROUP));
        Reg.registerWithItem("bone_joint", BONE_JOINT, itemSettings());

        Reg.registerWithItem("adventurine", ADVENTURINE, itemSettings());
        Reg.registerWithItem("erdstone", ERDSTONE, itemSettings());
        Reg.registerWithItem("erdcobblestone", ERDCOBBLESTONE, itemSettings());
        Reg.registerWithItem("erdstone_amber_ore", ERDSTONE_AMBER_ORE, itemSettings());
        Reg.registerWithItem("erdstone_coal_ore", ERDSTONE_COAL_ORE, itemSettings());
        Reg.registerWithItem("golemite_erdstone_ore", GOLEMITE_ERDSTONE_ORE, itemSettings());
        Reg.registerWithItem("erdstone_fossil_ore", ERDSTONE_FOSSIL_ORE, itemSettings());

        Reg.registerWithItem("loose_rocks", FALLING_ROCKS, itemSettings());
        Reg.registerWithItem("cracked_cobblestone", CRACKED_COBBLESTONE, itemSettings());

        Reg.registerWithItem("amber_ore", AMBER_ORE, itemSettings());
        Reg.registerWithItem("fossil_ore", FOSSIL_ORE, itemSettings());
        Reg.registerWithItem("primsteel_ore", PRIMSTEEL_ORE, itemSettings());
        Reg.registerWithItem("salt_ore", SALT_ORE, itemSettings());
        Reg.registerWithItem("scorchstone", SCORCHSTONE, itemSettings().fireproof());

        Reg.registerWithItem("deepslate_fossil_ore", DEEPSLATE_FOSSIL_ORE, itemSettings());
        Reg.registerWithItem("deepslate_primsteel_ore", PRIMSTEEL_DEEPSLATE_ORE, itemSettings());

        Reg.registerWithItem("nether_coal_ore", NETHER_COAL_ORE, itemSettings());
        Reg.registerWithItem("nether_fossil_ore", NETHER_FOSSIL_ORE, itemSettings());
        Reg.registerWithItem("nether_salt_ore", NETHER_SALT_ORE, itemSettings());

    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(ModGroups.FLORA_GROUP);
    }
}
