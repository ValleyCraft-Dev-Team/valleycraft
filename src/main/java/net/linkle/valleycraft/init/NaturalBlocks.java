package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.*;

import java.util.function.BiFunction;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.block.sapling.AmberSaplingGen;
import net.linkle.valleycraft.block.sapling.AppleSaplingGen;
import net.linkle.valleycraft.block.sapling.WarmBirchSaplingGen;
import net.linkle.valleycraft.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;

public enum NaturalBlocks implements ItemEnum, BlockEnum {

    BLACK_DAHLIA(new OffsetPlantBlock(flowerShape()), itemSettings()),
    FLOWERING_CACTUS(new OffsetPlantBlock(defaultPlantShape()).ground(BlockPres.ARID_DESERT_PLANTS), itemSettings()),
    SMALL_CACTUS(new ModPlantBlock(defaultPlantShape()).ground(BlockPres.ARID_DESERT_PLANTS), itemSettings()),
    TUMBLEWEED(new ModPlantBlock(tumbleweedShape()).ground(BlockPres.ARID_DESERT_PLANTS), itemSettings()),
    THORNY_BUSH(new OffsetPlantBlock(defaultPlantShape()).ground(BlockPres.ARID_DESERT_PLANTS), itemSettings()),
    FLUFFY_DANDELION(new OffsetPlantBlock(flowerShape()), itemSettings()),
    FOXTAIL_FERN(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    JUNGLE_BUSH(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    PANFLOWERS(new OffsetPlantBlock(flowerShape()), itemSettings()),
    
    DRIED_SAPLING(new ModPlantBlock(defaultPlantShape()), itemSettings()),

    HONEYCLUSTER(new OffsetPlantBlock(flowerShape()), itemSettings()),
    LAVENDER(new OffsetPlantBlock(flowerShape()), itemSettings()),
    LEATHERLEAF_FERN(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    MOSS_SPROUTLET(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    ORANGE_BEAUTY(new OffsetPlantBlock(flowerShape()), itemSettings()),
    ORANGE_FERN(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    POISON_BLOSSOM(new OffsetPlantBlock(flowerShape()), itemSettings()),
    PURPLE_TULIP(new OffsetPlantBlock(flowerShape()), itemSettings()),
    YELLOW_TULIP(new OffsetPlantBlock(flowerShape()), itemSettings()),
    LIGHT_BLUE_TULIP(new OffsetPlantBlock(flowerShape()), itemSettings()),
    BLACK_TULIP(new OffsetPlantBlock(flowerShape()), itemSettings()),
    FROSTFERN(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    CLARET_LEAF(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    GODDESS_LILY(new OffsetPlantBlock(flowerShape()), itemSettings()),
    
    KNAPWEED(new OffsetPlantBlock(flowerShape()).ground(BlockPres.ARID_DESERT_PLANTS), itemSettings()),
    
    RED_LUPINE(new OffsetPlantBlock(flowerShape()), itemSettings()),
    YELLOW_LUPINE(new OffsetPlantBlock(flowerShape()), itemSettings()),
    PINK_LUPINE(new OffsetPlantBlock(flowerShape()), itemSettings()),
    
    ORANGE_POPPY(new OffsetPlantBlock(flowerShape()), itemSettings()),
    YELLOW_POPPY(new OffsetPlantBlock(flowerShape()), itemSettings()),
    WHITE_POPPY(new OffsetPlantBlock(flowerShape()), itemSettings()),

    TALL_LIVING_BUSH(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_DEAD_BUSH(new ModTallPlantBlock().ground(BlockPres.SAND), itemSettings(), TallBlockItem::new),
    TALL_CORNFLOWER(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_OXEYE_DAISY(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_ALLIUM(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_LAVENDER(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),
    TALL_AZURE_BLUET(new ModTallFlowerBlock(), itemSettings(), TallBlockItem::new),

    BEE_NEST_WALL(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    
    RED_CLUSTER(new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM)).large(), itemSettings()),
    BROWN_CLUSTER(new ModMushroomBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM)).large(), itemSettings()),
    GLOW_CAP(new ModMushroomBlock().large(), itemSettings()),
    GLOW_CAP_CLUSTER(new ModMushroomBlock().large(), itemSettings()),
    JUNGLE_CAP(new ModMushroomBlock().large(), itemSettings()),
    JUNGLE_CAP_CLUSTER(new ModMushroomBlock().large(), itemSettings()),

    MOREL(new ModMushroomBlock().large(), itemSettings()),
    SHIVERCAP(new ShivercapBlock().large(), itemSettings().group(INGREDIENTS)),
    STALWART_SHROOM(new StalwartBlock().large(), itemSettings().group(INGREDIENTS)),
    GOOP_CAP(new ModMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 2)).large(), itemSettings()),
    GILDED_CAP(new ModMushroomBlock().large(), itemSettings()),
    IRONSHROOM(new ModMushroomBlock().large(), itemSettings()),
    WARDING_SHROOM(new ModMushroomBlock().large(), itemSettings()),

    SHORT_GRASS(new OffsetPlantBlock(shortGrassShape()), itemSettings()),
    SNOWFLOWER(new OffsetPlantBlock(flowerShape()), itemSettings()),
    SPROUT(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WEEPING_GHOST_WILLOW(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    MEADOW_FLOWERS(new OffsetPlantBlock(shortFlowerShape()), itemSettings()),

    WILD_WHEAT(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_POTATO(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_CARROT(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_BEET(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),

    WILD_MINERS_LETTUCE(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_FIRE_PEPPER(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_RICE(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_AMETHYSTLE(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_CAVE_ROOT(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_ONION(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_HERBS(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WILD_PUFF_BALL(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),

    MAIZE(new MaizeBlock()),
    MAIZE_BOX(new MaizeBoxBlock()),
    RICES(new MultiCropBlock(MultiCropBlock.settings())),
    PUFF_BALL(new MultiCropBlock(MultiCropBlock.settings()).genSize(3, 13/16f)),
    ONIONS(new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 13/16f)),
    MINERS_LETTUCES(new MultiCropBlock(MultiCropBlock.settings()).genSize(0, 12/16f)),
    FIRE_PEPPERS(new MultiCropBlock(MultiCropBlock.settings())),
    CAVE_ROOT_CROP(new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 10/16f)),
    ANCIENT_FLOWERS(new MultiCropBlock(MultiCropBlock.settings()).genSize(2, 12/16f)),
    AMETHYSTLES(new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 12/16f)),
    ALOE_VERAS(new BushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)).ground(BlockPres.ARID_DESERT_PLANTS).AloeShape()),
    GLOOM_BERRY(new GloomBerryHeadBlock()),
    GLOOM_BERRY_PLANT(new GloomBerryBodyBlock()),

    CAVE_ROOTS(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    BONE_WEED(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    DESERT_SHRUB(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    BUSH(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    LARGE_BUSH(new ModPlantBlock(defaultPlantShape()), itemSettings()),
    LUSH_BUSH(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),

    RUSHES(new RushBlock(Block.Settings.copy(Blocks.SUGAR_CANE).nonOpaque().breakInstantly().noCollision()), itemSettings()),

    BIG_FERN(new ModPlantBlock(defaultPlantShape()), itemSettings()),
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

    GLOW_KELP(new GlowKelpBlock(), itemSettings()),
    GLOW_KELP_PLANT(new GlowKelpPlantBlock()),
    ORANGE_KELP(new OrangeKelpBlock(), itemSettings()),
    ORANGE_KELP_PLANT(new OrangeKelpPlantBlock()),
    ORANGE_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS)), itemSettings()),
    GLOW_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS).luminance(s -> 8)), itemSettings()),
    BARNACLE_BLOCK(new BarnacleBlock(), itemSettings()),
    TUBE_WORMS_BLOCK(new SeagrassBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque()), itemSettings()),
    STARFISH_BLOCK(new StarfishBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque().noCollision().breakInstantly()), itemSettings()),
    CLAM_BLOCK_ITEM(new ClamBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque().ticksRandomly().breakInstantly()), itemSettings()),
    URCHIN_BLOCK_ITEM(new UrchinBlock(Block.Settings.copy(Blocks.SANDSTONE).nonOpaque().sounds(BlockSoundGroup.CORAL)), itemSettings()),

    DEEP_SEA_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    ABYSSAL_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    VOLCANIC_STONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VOLCANIC_MAGMA_STONE(new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), itemSettings()),
    VOLCANIC_ASH(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),

    MAMON_LOG(new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),
    ANCIENT_LOG(new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),
    MAMON_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)), itemSettings()),
    MAMON_SAPLING(new SaplingBlock(new AmberSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),

    APPLE_SAPLING(new SaplingBlock(new AppleSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),
    APPLE_LEAVES_EMPTY(new LeavesBlock(Block.Settings.copy(Blocks.OAK_LEAVES)), itemSettings()),
    APPLE_LEAVES(new AppleLeavesBlock(), itemSettings()),
    APPLE_LOG(new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG)), itemSettings()),
    
    WARM_BIRCH_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.BIRCH_LEAVES)), itemSettings()),
    WARM_BIRCH_SAPLING(new SaplingBlock(new WarmBirchSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),

    ARID_VINES(new VineHeadBlock(), itemSettings()),
    ARID_VINES_PLANT(new VineBodyBlock()),
    CAVE_MOSS(new CaveMossBlock(), itemSettings()),
    CRYSTAL_CAVE_MOSS(new CaveMossBlock(), itemSettings()),

    GHOST_PUMPKIN(new GhostPumpkinBlock(), itemSettings()),
    GHOST_PUMPKIN_STEM(new StemBlock((GourdBlock)GHOST_PUMPKIN.asBlock(), ()->ModItems.GHOST_PUMPKIN_SEEDS.item, Block.Settings.copy(Blocks.PUMPKIN_STEM))),
    ATTACHED_GHOST_PUMPKIN_STEM(new AttachedStemBlock((GourdBlock)GHOST_PUMPKIN.asBlock(), ()->ModItems.GHOST_PUMPKIN_SEEDS.item, Block.Settings.copy(Blocks.ATTACHED_PUMPKIN_STEM))),

    SLUDGE_FLUID(new SludgeFluidBlock(ModFluids.SLUDGE_STILL.flowable())),

    DRY_DIRT(new Block(Block.Settings.copy(Blocks.COARSE_DIRT)), itemSettings()),
    SANDY_GRAVEL(new FallingBlock(Block.Settings.copy(Blocks.GRAVEL)), itemSettings()),
    ARID_MOSSY_STONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    MOSSY_STONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_COBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    DIABASE(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    GRIMESTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    LIMESTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    SHIVERSTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VERDANTINE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    PUMICE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),

    METEORITE(new Block(Block.Settings.copy(Blocks.DEEPSLATE)), itemSettings()),

    BONE_JOINT(new Block(Block.Settings.copy(Blocks.BONE_BLOCK)), itemSettings()),
    ROCKS(new RockBlock(), itemSettings().group(ModGroups.VC_ITEMS)),
    FLINT_ROCKS(new RockBlock(), itemSettings().group(ModGroups.FLORA_GROUP)),

    ADVENTURINE(new Block(Block.Settings.copy(Blocks.STONE).hardness(25).luminance(s ->1)), itemSettings()),
    ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2)), itemSettings()),
    ERDCOBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE).hardness(2)), itemSettings()),
    ERDSTONE_AMBER_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2)), itemSettings()),
    ERDSTONE_COAL_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2)), itemSettings()),
    GOLEMITE_ERDSTONE_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2)), itemSettings()),
    ERDSTONE_FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE).hardness(2)), itemSettings()),

    LOOSE_ROCKS(new FallingRockBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.NETHER_BRICKS)), itemSettings()),
    CRACKED_COBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE).hardness(2)), itemSettings()),
    
    AMBER_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE)), itemSettings()),
    FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE)), itemSettings()),
    PRIMSTEEL_ORE(new Block(Block.Settings.copy(Blocks.IRON_ORE)), itemSettings()),
    SALT_ORE(new Block(Block.Settings.copy(Blocks.COAL_ORE)), itemSettings()),

    ICE_ORE(new IceOreBlock(Block.Settings.copy(Blocks.IRON_ORE).sounds(BlockSoundGroup.GLASS).nonOpaque().slipperiness(0.98f)), itemSettings()),
    PACKED_SNOW(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.SNOW)), itemSettings()),
    ICICLE_PACKED_ICE(new IcicleGrowingBlock(Block.Settings.copy(Blocks.PACKED_ICE).nonOpaque().slipperiness(0.98f)), itemSettings()),
    ICICLE(new IcicleBlock(Block.Settings.copy(Blocks.ICE).nonOpaque().slipperiness(0.98f)), itemSettings()),
    STRATIFIED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SCORCHSTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    SCALDING_SCORCHSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.STONE).ticksRandomly().luminance(s ->3)), itemSettings().fireproof()),
    ROUGH_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SCALDING_SANDSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.SANDSTONE).ticksRandomly().luminance(s ->3)), itemSettings()),
    ROUGH_RED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SCALDING_RED_SANDSTONE(new ScaldingBlock(Block.Settings.copy(Blocks.RED_SANDSTONE).ticksRandomly().luminance(s ->3)), itemSettings()),
    SCALDING_DEEPSLATE(new ScaldingBlock(Block.Settings.copy(Blocks.DEEPSLATE).ticksRandomly().luminance(s ->3)), itemSettings()),

    DEEPSLATE_FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), itemSettings()),
    DEEPSLATE_PRIMSTEEL_ORE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), itemSettings()),
    DEEPSLATE_ADVENTURINE_ORE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), itemSettings()),
    DEEPSLATE_ICE_ORE(new IceOreBlock(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE).sounds(BlockSoundGroup.GLASS).nonOpaque().slipperiness(0.98f)), itemSettings()),

    //nether blocks
    NETHER_SALT_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings()),
    NETHER_COAL_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings()),
    NETHER_FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings()),
    NETHER_SAND(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    BRIMSTONE_CRYSTAL(new BrimstoneCrystalClusterBlock(7,3, FabricBlockSettings.copyOf(Blocks.AMETHYST_CLUSTER).nonOpaque().luminance(s -> 8)), itemSettings()),

    //soul blocks
    FADED_SOUL_ROSE(new FadedSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque()), itemSettings()),
    SOUL_ROSE(new RegSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque().luminance(s -> 3)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOUL_ROSE(new BlueSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque().luminance(s -> 6)), itemSettings().rarity(Rarity.RARE)),
    SOULSPORE_SINGLE(new GreenSoulsporeBlockSmall(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)), itemSettings().rarity(Rarity.UNCOMMON)),
    SOULSPORE(new GreenSoulsporeBlockLarge(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOULSPORE_SINGLE(new BlueSoulsporeBlockSmall(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)), itemSettings().rarity(Rarity.RARE)),
    BLUE_SOULSPORE(new BlueSoulsporeBlockLarge(Block.Settings.copy(Blocks.CRIMSON_FUNGUS).nonOpaque().luminance(s -> 6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)), itemSettings().rarity(Rarity.RARE)),
    FADED_CELESTIAL(new FadedSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque()), itemSettings()),
    SOUL_CELESTIAL(new RegSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque().luminance(s -> 3)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOUL_CELESTIAL(new BlueSoulRoseBlock(Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(WitherRoseBlock.OffsetType.NONE).nonOpaque().luminance(s -> 6)), itemSettings().rarity(Rarity.RARE));

    //ROOTED_WATCHER(new ModPlantBlock()),
    //WARDING_SHROOM(new ModPlantBlock()),
    //STICKY_SHROOM(new ModLargerMushroomBlock()),
    //BIG_RED(new ModPlantBlock(Block.Settings.copy(Blocks.RED_MUSHROOM))),
    //BIG_BROWN(new ModPlantBlock(Block.Settings.copy(Blocks.BROWN_MUSHROOM))),
    
    public static void initialize() {
        ((VineHeadBlock)ARID_VINES.block).setPlant(ARID_VINES_PLANT.block);
        ((VineBodyBlock)ARID_VINES_PLANT.block).setStem(ARID_VINES.block);
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(ModGroups.FLORA_GROUP);
    }
    
    // VoxelShapes used by various plant blocks
    
    public static VoxelShape defaultPlantShape() {
        return Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    }

    public static VoxelShape tumbleweedShape() {
        return Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);
    }

    public static VoxelShape shortGrassShape() {
        return Block.createCuboidShape(2, 0, 2, 14, 7, 14);
    }
    
    public static VoxelShape flowerShape() {
        return Block.createCuboidShape(5, 0, 5, 11, 10, 11);
    }

    public static VoxelShape shortFlowerShape() {
        return Block.createCuboidShape(2, 0, 2, 14, 2, 14);
    }
    
    // ### The Enum Class Itself ###
    
    public final Block block;
    
    @Nullable
    public final Item item;
    
    public final Identifier id;
    
    /** Register the block without the item. */
    NaturalBlocks(Block block) {
        this.block = block;
        this.item = null;
        Registry.register(Registry.BLOCK, id = id(), block);
    }
    
    /** Register the block without the item. */
    NaturalBlocks(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    NaturalBlocks(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
        this.block = block;
        this.id = id();
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, item = function.apply(block, settings));
    }
    
    private Identifier id() {
        return Main.makeId(name().toLowerCase());
    }

    @Override
    @Nullable
    public Item asItem() {
        return item;
    }

    @Override
    public Block asBlock() {
        return block;
    }
}
