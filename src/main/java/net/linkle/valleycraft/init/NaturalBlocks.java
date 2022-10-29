package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.linkle.valleycraft.util.PlantVoxelShapes.*;
import static net.linkle.valleycraft.util.PlantGroundPredicates.*;
import static net.linkle.valleycraft.util.PlantBlockSettings.*;

import java.util.function.BiFunction;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.linkle.valleycraft.block.sapling.CelestialSaplingGen;
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
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum NaturalBlocks implements ItemEnum, BlockEnum {

    BLACK_DAHLIA(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    FLOWERING_CACTUS(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER).ground(ARID_DESERT), itemSettings()),
    SMALL_CACTUS(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER).ground(ARID_DESERT), itemSettings()),
    TUMBLEWEED(new ModPlantBlock(TUMBLEWEED_SHAPE, FLOWER).ground(ARID_DESERT), itemSettings()),
    THORNY_BUSH(new ThornyBushBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER).ground(ARID_DESERT), itemSettings()),
    FLUFFY_DANDELION(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    FOXTAIL_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    JUNGLE_BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    PANFLOWERS(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    
    DRIED_SAPLING(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),

    HONEYCLUSTER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    LAVENDER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    LEATHERLEAF_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    MOSS_SPROUTLET(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    ORANGE_BEAUTY(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    ORANGE_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    POISON_BLOSSOM(new PoisonPlantBlock(FLOWER_SHAPE, OFFSET_FLOWER), itemSettings()),
    PURPLE_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    YELLOW_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    LIGHT_BLUE_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    BLACK_TULIP(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    FROSTFERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    CLARET_LEAF(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
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

    SHORT_GRASS(new ModPlantBlock(SHORT_GRASS_SHAPE, OFFSET_REPLACEABLE), itemSettings()),
    SNOWFLOWER(new ModFlowerBlock(OFFSET_FLOWER), itemSettings()),
    SPROUT(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    WEEPING_GHOST_WILLOW(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
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
    AMETHYSTLES(new MultiCropBlock(MultiCropBlock.settings()).genSize(1, 12/16f)),
    ALOE_VERAS(new BushBlock(Block.Settings.copy(Blocks.SWEET_BERRY_BUSH)).ground(ARID_DESERT).AloeShape()),
    GLOOM_BERRY(new GloomBerryHeadBlock()),
    GLOOM_BERRY_PLANT(new GloomBerryBodyBlock()),

    CAVE_ROOTS(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    BONE_WEED(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    DESERT_SHRUB(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),
    LARGE_BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),
    LUSH_BUSH(new ModPlantBlock(DEFAULT_PLANT_SHAPE, OFFSET_FLOWER), itemSettings()),

    RUSHES(new RushBlock(Block.Settings.copy(Blocks.SUGAR_CANE).nonOpaque().breakInstantly().noCollision()), itemSettings()),

    BIG_FERN(new ModPlantBlock(DEFAULT_PLANT_SHAPE, FLOWER), itemSettings()),
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
    CLAM_BLOCK(new ClamBlock(Block.Settings.copy(Blocks.FIRE_CORAL).sounds(BlockSoundGroup.CORAL).nonOpaque().ticksRandomly().breakInstantly()), itemSettings()),
    URCHIN_BLOCK(new UrchinBlock(Block.Settings.copy(Blocks.SANDSTONE).nonOpaque().sounds(BlockSoundGroup.CORAL)), itemSettings()),

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

    WARM_BIRCH_SAPLING(new SaplingBlock(new WarmBirchSaplingGen(), Block.Settings.copy(Blocks.BIRCH_SAPLING)), itemSettings()),
    WARM_BIRCH_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.BIRCH_LEAVES)), itemSettings()),

    LESSER_DIVINE_OAK_LOG(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),

    CELESTIAL_SAPLING(new SaplingBlock(new CelestialSaplingGen(), Block.Settings.copy(Blocks.OAK_SAPLING)), itemSettings()),
    CELESTIAL_LEAVES(new LeavesBlock(Block.Settings.copy(Blocks.BIRCH_LEAVES).sounds(BlockSoundGroup.NETHER_WART).nonOpaque()), itemSettings()),
    CELESTIAL_LOG(new PillarBlock(Block.Settings.copy(Blocks.CRIMSON_HYPHAE)), itemSettings()),

    //end blocks
    END_GRASS(new ModPlantBlock(DEFAULT_PLANT_SHAPE, Block.Settings.copy(Blocks.GRASS).sounds(BlockSoundGroup.NETHERRACK)).ground(ENDSTONE), itemSettings()),
    END_GRASS_BLOCK(new EndGrassBlock(Block.Settings.copy(Blocks.END_STONE)), itemSettings()),

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
    MARBLE(new Block(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),

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
    FADED_SOUL_ROSE(new FadedSoulRoseBlock(SoulPlantBlock.settings(0)), itemSettings()),
    SOUL_ROSE(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOUL_ROSE(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6)), itemSettings().rarity(Rarity.RARE)),
    SOULSPORE_SINGLE(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).smallShape(), itemSettings().rarity(Rarity.UNCOMMON)),
    SOULSPORE(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).largeShape(), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOULSPORE_SINGLE(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).smallShape(), itemSettings().rarity(Rarity.RARE)),
    BLUE_SOULSPORE(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6).emissiveLighting((blockState, pos, view) -> true).sounds(BlockSoundGroup.SOUL_SAND)).largeShape(), itemSettings().rarity(Rarity.RARE)),
    FADED_CELESTIAL(new SoulPlantBlock(ParticleTypes.SMOKE, SoulPlantBlock.settings(0)), itemSettings()),
    SOUL_CELESTIAL(new SoulPlantBlock(ModParticles.GREEN_EXP_ORB, SoulPlantBlock.settings(3)), itemSettings().rarity(Rarity.UNCOMMON)),
    BLUE_SOUL_CELESTIAL(new SoulPlantBlock(ModParticles.BLUE_EXP_ORB, SoulPlantBlock.settings(6)), itemSettings().rarity(Rarity.RARE));
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
