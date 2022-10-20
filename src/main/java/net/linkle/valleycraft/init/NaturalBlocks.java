package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.Main.makeId;
import static net.linkle.valleycraft.init.ModGroups.*;

import java.util.function.BiFunction;

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
    FADED_SOUL_ROSE(new OffsetPlantBlock(flowerShape()).ground(BlockPres.SOUL_PLANTS), itemSettings()),
    
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
    SOULSPORE_SINGLE(new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 5).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).shape(Block.createCuboidShape(5, 0, 5, 11, 6, 11)), itemSettings().rarity(Rarity.UNCOMMON)),
    SOULSPORE(new ModMushroomBlock(Block.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 5).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).shape(Block.createCuboidShape(4, 0, 4, 12, 9, 12)), itemSettings().rarity(Rarity.RARE)),

    MOREL(new ModMushroomBlock().large(), itemSettings()),
    SHIVERCAP(new ShivercapBlock().large(), itemSettings().group(INGREDIENTS)),
    STALWART_SHROOM(new StalwartBlock().large(), itemSettings().group(INGREDIENTS)),
    GOOP_CAP(new ModMushroomBlock(AbstractBlock.Settings.copy(Blocks.RED_MUSHROOM).nonOpaque().luminance(s -> 2)).large(), itemSettings()),
    GILDED_CAP(new ModMushroomBlock().large(), itemSettings()),
    IRONSHROOM(new ModMushroomBlock().large(), itemSettings()),

    SHORT_GRASS(new OffsetPlantBlock(shortGrassShape()), itemSettings()),
    SNOWFLOWER(new OffsetPlantBlock(flowerShape()), itemSettings()),
    SPROUT(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    WEEPING_GHOST_WILLOW(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),

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

    CAVE_ROOTS(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    BONE_WEED(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    DESERT_SHRUB(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    BUSH(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),
    LARGE_BUSH(new ModPlantBlock(defaultPlantShape()), itemSettings()),
    LUSH_BUSH(new OffsetPlantBlock(defaultPlantShape()), itemSettings()),

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

    GLOOM_BERRY(new GloomBerryHeadBlock()),
    GLOOM_BERRY_PLANT(new GloomBerryBodyBlock()),

    GLOW_KELP(new GlowKelpBlock(), itemSettings()),
    GLOW_KELP_PLANT(new GlowKelpPlantBlock()),
    ORANGE_KELP(new OrangeKelpBlock(), itemSettings()),
    ORANGE_KELP_PLANT(new OrangeKelpPlantBlock()),
    
    ALGAE(new AlgaeBlock(), itemSettings(), PlaceableOnWaterItem::new),
    ORANGE_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS)), itemSettings()),
    GLOW_SEAGRASS(new SeagrassBlock(Block.Settings.copy(Blocks.SEAGRASS).luminance(s -> 8)), itemSettings()),

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
    VOLCANIC_STONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VOLCANIC_MAGMA_STONE(new Block(Block.Settings.copy(Blocks.MAGMA_BLOCK)), itemSettings()),
    VOLCANIC_ASH(new FallingBlock(Block.Settings.copy(Blocks.SAND)), itemSettings()),
    
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
    SCORCHSTONE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    STRATIFIED_SANDSTONE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().fireproof()),

    DEEPSLATE_FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), itemSettings()),
    DEEPSLATE_PRIMSTEEL_ORE(new Block(Block.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)), itemSettings()),
    
    NETHER_SALT_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings()),
    NETHER_COAL_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings()),
    NETHER_FOSSIL_ORE(new Block(Block.Settings.copy(Blocks.NETHER_QUARTZ_ORE)), itemSettings());

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
