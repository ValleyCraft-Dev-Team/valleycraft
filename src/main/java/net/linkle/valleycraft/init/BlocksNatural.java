package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.Groups.*;
import static net.linkle.valleycraft.util.PlantBlockSettings.*;
import static net.linkle.valleycraft.util.PlantGroundPredicates.*;
import static net.linkle.valleycraft.util.PlantVoxelShapes.*;

import java.util.function.BiFunction;

import net.linkle.valleycraft.block.SkullBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.block.sapling.AmberSaplingGen;
import net.linkle.valleycraft.block.sapling.AppleSaplingGen;
import net.linkle.valleycraft.block.sapling.WarmBirchSaplingGen;
import net.linkle.valleycraft.enums.BlockEnum;
import net.linkle.valleycraft.enums.ItemEnum;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum BlocksNatural implements ItemEnum, BlockEnum {
    CHOCOLATE_CAKE(new ModCakeBlock(Block.Settings.copy(Blocks.CAKE)), foodBlockSettings()),
    CHEESE(new ModCakeBlock(Block.Settings.copy(Blocks.CAKE)), foodBlockSettings()),

    BLACK_DAHLIA(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    FLOWERING_CACTUS(new ModCactusBlock(FLOWERING_CACTUS_SHAPE), itemSettings()),
    SMALL_CACTUS(new ModCactusBlock(CACTUS_SHAPE), itemSettings()),
    TUMBLEWEED(new ModPlantBlock(TUMBLEWEED_SHAPE, FLOWER).ground(ARID_DESERT_PLANT), itemSettings()),
    THORNY_BUSH(new ThornyBushBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER).ground(ARID_DESERT_PLANT), itemSettings()),
    FLUFFY_DANDELION(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    FOXTAIL_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    JUNGLE_BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),
    PANFLOWERS(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    CLOVER(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),

    HONEYCLUSTER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    LAVENDER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    MOSS_SPROUTLET(new ModMushroomBlockDaySafe(), itemSettings()),
    ORANGE_BEAUTY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    PURPLE_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    YELLOW_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    LIGHT_BLUE_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    BLACK_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    BIG_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),
    LEATHERLEAF_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    //FIDDLEHEAD_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    //ORANGE_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    //FROSTFERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    FIREFERN(new SparkFernBlock(), itemSettings()),
    LILY_OF_THE_MOUNTAINS(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    POISON_BLOSSOM(new PoisonPlantBlock(FLOWER_SHAPE, OFFSET_FLOWER), itemSettings()),
    //NIGHT_LILY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings().rarity(Rarity.RARE)),
    GODDESS_LILY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),

    KNAPWEED(new ModFlowerBlock(Blocks.OXEYE_DAISY, OFFSET_FLOWER), itemSettings()),
    
    RED_LUPINE(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    YELLOW_LUPINE(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    PINK_LUPINE(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    
    ORANGE_POPPY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    YELLOW_POPPY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    WHITE_POPPY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),

    TALL_LIVING_BUSH(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_DEAD_BUSH(new ModTallPlantBlock().ground(floor -> floor.isIn(BlockTags.DEAD_BUSH_MAY_PLACE_ON)), itemSettings(), TallBlockItem::new),
    TALL_CORNFLOWER(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_OXEYE_DAISY(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_ALLIUM(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_LAVENDER(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_AZURE_BLUET(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),

    //BEE_NEST_WALL(new Block(Block.Settings.copy(Blocks.BEE_NEST)), itemSettings()),

    //mushrooms
    RED_CLUSTER(new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM)).large(), itemSettings()),
    BROWN_CLUSTER(new ModMushroomBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM)).large(), itemSettings()),
    SPORE_SPREADER(new ModSporeSpreaderBlock().large(), itemSettings()),
    GLOW_CAP(new ModGlowingMushroomBlock(), itemSettings()),
    GLOW_CAP_CLUSTER(new ModGlowingMushroomBlock().large(), itemSettings()),
    FAN_MOLD(new FanMoldBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM).ticksRandomly().luminance(s -> 4).nonOpaque().noCollision()), itemSettings()),
    JUNGLE_CAP(new ModMushroomBlockDaySafe(), itemSettings()),
    JUNGLE_CAP_CLUSTER(new ModMushroomBlockDaySafe().large(), itemSettings()),

    MOREL(new ModMushroomBlockDaySafe(), itemSettings()),
    SHIVERCAP(new ShivercapBlock(), itemSettings().group(INGREDIENTS)),
    STALWART_SHROOM(new StalwartBlock(), itemSettings().group(INGREDIENTS)),

    SHORT_GRASS(new GrowablePlantBlock(OFFSET_REPLACEABLE, new Identifier("grass")), itemSettings()),
    SNOWFLOWER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    SPROUT(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WEEPING_GHOST_WILLOW(new WeepingGhostWillowBlock(), itemSettings()),
    MEADOW_FLOWERS(new ModPlantBlock(SHORT_FLOWER_SHAPE, OFFSET_FLOWER), itemSettings()),

    WILD_WHEAT(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_POTATO(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_CARROT(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_BEET(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),

    WILD_MINERS_LETTUCE(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_FIRE_PEPPER(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_RICE(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_AMETHYSTLE(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_CAVE_ROOT(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_ONION(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_HERBS(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WILD_PUFF_BALL(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),

    MAIZE(new MaizeBlock()),
    MAIZE_BOX(new MaizeBoxBlock()),
    RICES(new MultiCropBlock(MultiCropBlock.settings())),
    PUFF_BALL(new MultiCropBlock(MultiCropBlock.settings()).genSize(3, 13/16f)),
    ONIONS(new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 13/16f)),
    MINERS_LETTUCES(new MultiCropBlock(MultiCropBlock.settings()).genSize(0, 12/16f)),
    FIRE_PEPPERS(new MultiCropBlock(MultiCropBlock.settings())),
    CAVE_ROOT_CROP(new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 10/16f)),
    ANCIENT_FLOWERS(new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 12/16f)),
    ANCIENT_FLOWER_BLOCK(new ModGlowingAncientFlowerBlock(OFFSET_FLOWER).ground(DIRT), alisasedItemSettings()),
    STAMINELLA_BERRY_PLANT(new BushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)).ground(DIRT).AloeShape()),
    AMETHYSTLES(new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 12/16f)),
    ALOE_VERAS(new BushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)).ground(ARID_DESERT_CROP).AloeShape()),

    MIMIC_FLOWER(new MimicFlowerBlock(MimicFlowerBlock.settings(0).ticksRandomly()), itemSettings()),
    //CAVE_ROOTS(new HangingPlant(Block.Settings.copy(Blocks.HANGING_ROOTS)), itemSettings()),
    DESERT_SHRUB(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    BUSH(new GrowablePlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER, "large_bush"), itemSettings()),
    LARGE_BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),
    LUSH_BUSH(new GrowablePlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER, "tall_living_bush"), itemSettings()),

    CATTAILS(new CattailsBlock(), itemSettings(), TallBlockItem::new),
    RUSHES(new RushBlock(Block.Settings.copy(Blocks.SUGAR_CANE).nonOpaque().breakInstantly().noCollision()), itemSettings()),

    SMALLEST_LILYPADS(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    SMALL_LILYPADS(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    SMALL_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    YELLOW_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    WHITE_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    RED_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    PURPLE_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    PINK_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),
    BLUE_FLOWERING_LILYPAD(new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD)), itemSettings(), PlaceableOnWaterItem::new),

    ALGAE(new AlgaeBlock(), itemSettings(), PlaceableOnWaterItem::new),

    //beach plants
    NEST(new ModPlantBlock(SHORT_GRASS_SHAPE, FLOWER), itemSettings()),
    BEACH_GRASS(new ModPlantBlock(SHORT_GRASS_SHAPE, OFFSET_REPLACEABLE), itemSettings()),
    ICEPLANT(new ModPlantBlock(SHORT_GRASS_SHAPE, OFFSET_REPLACEABLE), itemSettings()),

    JELLYCAP(new OceanMushroomBlock(), itemSettings()),
    GLOW_KELP(new GlowKelpBlock(), itemSettings()),
    GLOW_KELP_PLANT(new GlowKelpPlantBlock()),
    ORANGE_KELP(new OrangeKelpBlock(), itemSettings()),
    ORANGE_KELP_PLANT(new OrangeKelpPlantBlock()),
    ORANGE_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS)), itemSettings()),
    GLOW_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS).luminance(s -> 8)), itemSettings()),
    BARNACLE_BLOCK(new BarnacleBlock(), itemSettings()),
    TUBE_WORMS_BLOCK(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    STARFISH_BLOCK(new StarfishBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque().noCollision().breakInstantly()), itemSettings()),
    CLAM_BLOCK(new ClamBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque().ticksRandomly().breakInstantly()), itemSettings()),
    URCHIN_BLOCK(new UrchinBlock(Block.Settings.copy(Blocks.SANDSTONE).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    BLUE_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    GREEN_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    PINK_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    PURPLE_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    RED_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    YELLOW_ANEMONE(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),

    SHELL_GRAVEL(new FallingBlock(Block.Settings.copy(Blocks.GRAVEL)), itemSettings()),

    /**saving for 1.1**/
    //DEEP_SEA_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    //ABYSSAL_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    //VOLCANIC_STONE(new Block(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    //VOLCANIC_MAGMA_STONE(new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK).sounds(BlockSoundGroup.TUFF)), itemSettings()),
    //VOLCANIC_ASH(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),

    MAMON_LOG(new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),
    MAMON_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)), itemSettings()),
    MAMON_SAPLING(new SaplingBlock(new AmberSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),

    APPLE_SAPLING(new SaplingBlock(new AppleSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),
    APPLE_LEAVES_EMPTY(new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)), itemSettings()),
    APPLE_LEAVES(new AppleLeavesBlock(), itemSettings()),
    APPLE_LOG(new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),

    WARM_BIRCH_SAPLING(new SaplingBlock(new WarmBirchSaplingGen(), Block.Settings.copy(Blocks.BIRCH_SAPLING)), itemSettings()),
    WARM_BIRCH_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.BIRCH_LEAVES)), itemSettings()),

    LESSER_DIVINE_OAK_LOG(new DivineOakLog(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),

    //hollow logs
    HOLLOW_ACACIA_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.ACACIA_LOG)), itemSettings()),
    HOLLOW_MAMON_LOG(new HollowLogBlock(Block.Settings.copy(MAMON_LOG.block)), itemSettings()),
    HOLLOW_APPLE_LOG(new HollowLogBlock(Block.Settings.copy(APPLE_LOG.block)), itemSettings()),
    HOLLOW_BIRCH_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.BIRCH_LOG)), itemSettings()),
    HOLLOW_DARK_OAK_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.DARK_OAK_LOG)), itemSettings()),
    HOLLOW_JUNGLE_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.JUNGLE_LOG)), itemSettings()),
    HOLLOW_MANGROVE_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.MANGROVE_LOG)), itemSettings()),
    HOLLOW_OAK_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),
    HOLLOW_SPRUCE_LOG(new HollowLogBlock(Block.Settings.copy(Blocks.SPRUCE_LOG)), itemSettings()),

    ARID_VINES(new VineHeadBlock(), itemSettings()),
    ARID_VINES_PLANT(new VineBodyBlock()),
    //CAVE_MOSS(new CaveMossBlock(), itemSettings()),
    //CRYSTAL_CAVE_MOSS(new CaveMossBlock(), itemSettings()),
    //GNARLED_ROOTS(new GlowLichenBlock(Block.Settings.copy(Blocks.GLOW_LICHEN).luminance(s -> 0)), itemSettings()),

    SLUDGE_FLUID(new SludgeFluidBlock(Fluids.SLUDGE_STILL.flowable())),

    SHALE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    CAIRNSTONE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE).resistance(1200).hardness(52f)), itemSettings()),

    //STONE_CAVE_GRASS(new CaveGrassStoneBlock(Blocks.STONE, ModBlockSoundGroup.MOSS_STONE.sound), itemSettings()),
    //SHALE_CAVE_GRASS(new CaveGrassStoneBlock(SHALE.block, ModBlockSoundGroup.MOSS_SHALE.sound), itemSettings()),
    //DEEPSLATE_CAVE_GRASS(new CaveGrassStoneBlock(Blocks.DEEPSLATE, ModBlockSoundGroup.MOSS_DEEPSLATE.sound), itemSettings()),

    DRY_DIRT(new Block(Block.Settings.copy(Blocks.COARSE_DIRT)), itemSettings()),
    IRON_RICH_DIRT(new Block(Block.Settings.copy(Blocks.COARSE_DIRT)), itemSettings()),
    FINE_GRAVEL(new FallingBlock(Block.Settings.copy(Blocks.GRAVEL)), itemSettings()),
    SANDY_GRAVEL(new FallingBlock(Block.Settings.copy(Blocks.GRAVEL)), itemSettings()),
    MOSSY_STONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_COBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    DIABASE(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    GRIMESTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    SHIVERSTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VERDANTINE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    MARBLE(new Block(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    JASPER(new WarmBlock(Block.Settings.copy(Blocks.DIORITE).ticksRandomly().slipperiness(0.6f)), itemSettings()),

    DIRT_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    FLINT_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),

    ERDCOBBLESTONE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    //DRIPSTONE_FLINT_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    SHALE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    DRIPSTONE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    DEEPSLATE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),

    SALT_ORE_ROCKS(new RockBlock(), itemSettings().group(FLORA_GROUP)),
    COAL_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    RAW_PRIMSTEEL_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    RAW_COPPER_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    RAW_IRON_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    RAW_GOLD_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),

    REDSTONE_CRYSTAL(new RedstoneCrystalBlock(), itemSettings().group(Groups.FLORA_GROUP)),

    NETHERACK_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    ANTHRACITE_ORE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),
    ENDSTONE_ROCKS(new RockBlock(), itemSettings().group(Groups.FLORA_GROUP)),

    ADVENTURINE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).hardness(2)), itemSettings()),
    ERDCOBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLED_DEEPSLATE).hardness(2)), itemSettings()),

    LOOSE_ROCKS(new FallingRockBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.NETHER_BRICKS)), itemSettings()),

    //AMBER_ORE(new OreBlock(Block.Settings.copy(Blocks.IRON_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    PRIMSTEEL_ORE(new OreBlock(Block.Settings.copy(Blocks.IRON_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    SALT_ORE(new OreBlock(Block.Settings.copy(Blocks.COAL_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    MIXED_ORE(new OreBlock(Block.Settings.copy(Blocks.COAL_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    SALTPETER_ORE(new OreBlock(Block.Settings.copy(Blocks.COAL_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    ANCIENT_IRON_DEBRIS(new OreBlock(Block.Settings.copy(Blocks.IRON_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),
    ANCIENT_GOLD_DEBRIS(new OreBlock(Block.Settings.copy(Blocks.GOLD_ORE).requiresTool(), UniformIntProvider.create(2, 6)), itemSettings()),

    ICE_ORE(new IceOreBlock(Block.Settings.copy(Blocks.IRON_ORE).sounds(BlockSoundGroup.GLASS).nonOpaque().slipperiness(0.98f), UniformIntProvider.create(2, 6)), itemSettings()),
    PACKED_SNOW(new Block(Block.Settings.copy(Blocks.SNOW_BLOCK).strength(0.3f).sounds(BlockSoundGroup.SNOW)), itemSettings()),

    QUICKSAND(new QuicksandBlock(AbstractBlock.Settings.copy(Blocks.SAND).sounds(BlockSoundGroup.SAND).noCollision().strength(0.5F)), itemSettings()),

    ROUGH_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SCALDING_SANDSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.SANDSTONE).ticksRandomly().luminance(s ->3)), itemSettings()),
    STRATIFIED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    ROUGH_RED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SCALDING_RED_SANDSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.RED_SANDSTONE).ticksRandomly().luminance(s ->3)), itemSettings()),
    STRATIFIED_RED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    SCORCHSTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCALDING_SCORCHSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.STONE).ticksRandomly().luminance(s ->3)), itemSettings().fireproof()),
    SCALDING_DEEPSLATE(new ScaldingBlock(Block.Settings.copy(Blocks.DEEPSLATE).ticksRandomly().luminance(s ->3)), itemSettings()),

    DEEPSLATE_PRIMSTEEL_ORE(new OreBlock(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    DEEPSLATE_ICE_ORE(new IceOreBlock(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.GLASS).nonOpaque().slipperiness(0.98f), UniformIntProvider.create(2, 6)), itemSettings()),
    DEEPSLATE_MIXED_ORE(new OreBlock(Block.Settings.copy(Blocks.DEEPSLATE_COAL_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    DEEPSLATE_SALTPETER_ORE(new OreBlock(Block.Settings.copy(Blocks.DEEPSLATE_COAL_ORE), UniformIntProvider.create(2, 6)), itemSettings()),

    SCULK_BLOSSOM(new SculkBlossomBlock(AbstractBlock.Settings.of(Material.PLANT).breakInstantly().noCollision().sounds(BlockSoundGroup.SPORE_BLOSSOM)), itemSettings()),

    SPIDER_EGG(new SpiderEggBlock(), itemSettings()),
    
    //nether blocks
    NETHER_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    BRIMSTONE_CRYSTAL(new BrimstoneCrystalClusterBlock(7,3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER).nonOpaque().luminance(s -> 8)), itemSettings()),
    NETHER_SALT_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    NETHER_COAL_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    NETHER_NETHERITE_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    //NETHER_PIG_IRON_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    //NETHER_GARNET_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),

    //soul blocks
    //BLIGHTED_SOUL_ROSE(new PoisonPlantBlock(FLOWER_SHAPE, OFFSET_FLOWER), itemSettings()),
    FADED_SOUL_ROSE(new FadedSoulRoseBlock(SoulPlantBlock.settings(0)), itemSettings()),
    SOUL_ROSE(new SoulPlantBlock(Particles.GREEN_EXP_ORB, SoulPlantBlock.settings(3), UniformIntProvider.create(6, 12)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOUL_ROSE(new SoulPlantBlock(Particles.BLUE_EXP_ORB, SoulPlantBlock.settings(6), UniformIntProvider.create(12, 24)), itemSettings().rarity(Rarity.RARE)),
    //FADED_SOULSPORE_SINGLE(new FadedSoulRoseBlock(SoulPlantBlock.settings(0).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).smallShape(), itemSettings()),
    //FADED_SOULSPORE(new FadedSoulRoseBlock(SoulPlantBlock.settings(0).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).largeShape(), itemSettings()),
    //SOULSPORE_SINGLE(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND), UniformIntProvider.create(6, 12)).smallShape(), itemSettings().rarity(Rarity.UNCOMMON)),
    //SOULSPORE(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND), UniformIntProvider.create(12, 24)).largeShape(), itemSettings().rarity(Rarity.UNCOMMON)),
    //BLUE_SOULSPORE_SINGLE(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND), UniformIntProvider.create(12, 24)).smallShape(), itemSettings().rarity(Rarity.RARE)),
    //BLUE_SOULSPORE(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND), UniformIntProvider.create(24, 36)).largeShape(), itemSettings().rarity(Rarity.RARE)),

    FOSSIL_ORE(new OreBlock(Block.Settings.copy(Blocks.IRON_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    DEEPSLATE_FOSSIL_ORE(new OreBlock(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    NETHER_FOSSIL_ORE(new OreBlock(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE), UniformIntProvider.create(2, 6)), itemSettings()),
    //BONE_JOINT(new Block(Block.Settings.copy(Blocks.BONE_BLOCK)), itemSettings()),

    //skulls and skeletons go here
    HEADLESS_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    VILLAGER_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    VILLAGER_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    //MOBLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    //MOBLIN_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PIGLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    PIGLIN_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    ENDERMAN_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    //SKELETAL_REMAINS_SLUMPED(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    //SKELETAL_MINING_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    //SKELETAL_BEST_FRIEND_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    DAERDRI_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.RARE)),
    //SNIFFER_SKULL(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),

    //heads
    HEAD_ZOMBIE_ALEX(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_ZOMBIE_EFE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_DROWNED_ALEX(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_DROWNED_EFE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_DROWNED_STEVE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_HUSK_STEVE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_HUSK_ALEX(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_HUSK_EFE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_ROTTEN_ALEX(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_ROTTEN_EFE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),
    HEAD_ROTTEN_STEVE(new SkullBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.STONE)), itemSettings().rarity(Rarity.UNCOMMON)),

    //cave paintings
    ERDSTONE_CAVE_PAINTING_PORTRAIT(new CavePainting(Block.Settings.copy(Blocks.STONE), "portrait"), itemSettings()),
    ERDSTONE_CAVE_PAINTING_ZOMBIES(new CavePainting(Block.Settings.copy(Blocks.STONE), "zombie"), itemSettings()),
    ERDSTONE_CAVE_PAINTING_HOME(new CavePainting(Block.Settings.copy(Blocks.STONE), "home"), itemSettings()),
    ERDSTONE_CAVE_PAINTING_FAMILY(new CavePainting(Block.Settings.copy(Blocks.STONE), "family"), itemSettings()),

    // Tree Seeds
    //DIVINE_ACORN(new SeedBlock(Blocks.OAK_SAPLING)),
    OAK_SEED(new SeedBlock(Blocks.OAK_SAPLING)),
    BIRCH_SEED(new SeedBlock(Blocks.BIRCH_SAPLING)),
    SPRUCE_SEED(new SeedBlock(Blocks.SPRUCE_SAPLING)),
    ACACIA_SEED(new SeedBlock(Blocks.ACACIA_SAPLING)),
    DARK_OAK_SEED(new SeedBlock(Blocks.DARK_OAK_SAPLING)),
    JUNGLE_SEED(new SeedBlock(Blocks.JUNGLE_SAPLING)),
    APPLE_SEED(new SeedBlock(APPLE_SAPLING.block)),
    AMBERBLOSSOM_SEED(new SeedBlock(MAMON_SAPLING.block)),
    WARM_BIRCH_SEED(new SeedBlock(WARM_BIRCH_SAPLING.block));
    
    public static void initialize() {
        ARID_VINES.to(VineHeadBlock.class).setPlant(ARID_VINES_PLANT);
        ARID_VINES_PLANT.to(VineBodyBlock.class).setStem(ARID_VINES);
    }
    private static FabricItemSettings alisasedItemSettings() { return new FabricItemSettings(); }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(Groups.FLORA_GROUP);
    }

    private static FabricItemSettings foodBlockSettings() {
        return new FabricItemSettings().group(REGULAR_DISHES);
    }

    // ### The Enum Class Itself ###
    
    public final Block block;
    
    @Nullable
    public final Item item;
    
    public final Identifier id;
    
    /** Register the block without the item. */
    BlocksNatural(Block block) {
        this.block = block;
        this.item = null;
        Registry.register(Registry.BLOCK, id = id(), block);
    }
    
    /** Register the block with the item. */
    BlocksNatural(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    BlocksNatural(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
        this.block = block;
        this.id = id();
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, item = function.apply(block, settings));
    }
    
    private Identifier id() {
        return Main.makeId(name().toLowerCase());
    }

    @Override
    public Item asItem() {
        return item == null ? Items.AIR : item;
    }

    @Override
    public Block asBlock() {
        return block;
    }
    
    @Override
    public Identifier getId() {
        return id;
    }
}
