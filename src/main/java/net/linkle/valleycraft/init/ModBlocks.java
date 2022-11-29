package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.NON_NATURAL_BLOCKS;
import static net.linkle.valleycraft.util.BookStackVoxelShapes.*;

import java.util.function.BiFunction;
import java.util.function.ToIntFunction;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.util.BlockEnum;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.block.*;
import net.minecraft.block.Oxidizable.OxidationLevel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public enum ModBlocks implements ItemEnum, BlockEnum {
    
    // furniture
    WAYPOINT(new WaypointBlock(Block.Settings.copy(Blocks.POLISHED_DEEPSLATE).nonOpaque()), itemSettings()),

    STABLEHAND_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    STABLEHAND_COUNTER(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    KEG(new KegBlock(), itemSettings()),
    MINER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    BEEKEEPER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    LUMBERJACK_STATION(new LumberjackBlock(Block.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()), itemSettings()),
    STOVE(new StoveBlock(Block.Settings.copy(Blocks.SMOKER)), itemSettings()),
    //BONFIRE(new ModCampfireBlock(true, 1, Block.Settings.copy(Blocks.CAMPFIRE)), itemSettings().rarity(Rarity.RARE)),
    LOG_PILE(new LogPile(Block.Settings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()), itemSettings()),
    CRATE(new CrateBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    COUNTER(new CounterBlock(Block.Settings.copy(Blocks.BARREL).nonOpaque()), itemSettings()),
    CABINET(new CabinetBlock(Block.Settings.copy(Blocks.BARREL).nonOpaque()), itemSettings()),
    EMPTY_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    POTION_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    ANTHRO_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    BOOK_STACK_0(new BookStackBlock(BLOCK_SHAPE_0, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_1(new BookStackBlock(BLOCK_SHAPE_1, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_2(new BookStackBlock(BLOCK_SHAPE_2, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_3(new BookStackBlock(BLOCK_SHAPE_3, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_4(new BookStackBlock(BLOCK_SHAPE_4, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_5(new BookStackBlock(BLOCK_SHAPE_5, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_6(new BookStackBlock(BLOCK_SHAPE_6, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_7(new BookStackBlock(BLOCK_SHAPE_7, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),
    BOOK_STACK_8(new BookStackBlock(BLOCK_SHAPE_8, Block.Settings.copy(Blocks.BOOKSHELF).breakInstantly().nonOpaque()), itemSettings()),

    WATTLE_STOOL(new StoolBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_CHAIR(new ChairBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE_CLOTHE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),

    DIRT_ROAD(new Block(Block.Settings.copy(Blocks.COARSE_DIRT)), itemSettings()),

    CANVAS_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CANVAS_CARPET(new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CURTAIN(new CurtainBlock(), itemSettings()),

    //rope and net blocks
    ROPE(new ChainBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),
    ROPE_LADDER(new ModLadderBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),
    BAMBOO_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(1).sounds(BlockSoundGroup.BAMBOO)), itemSettings()),

    NET(new NetBlock(), itemSettings()),
    NET_BLOCK(new GrateBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),

    ROPE_BRIDGE_ANCHOR(new RopeBridgeBlock(Block.Settings.of(Material.CARPET).nonOpaque().sounds(BlockSoundGroup.WOOD).strength(1).noCollision()), itemSettings()),
    ROPE_BRIDGE(new RopeBridgeBlock(Block.Settings.of(Material.CARPET).nonOpaque().sounds(BlockSoundGroup.WOOD).strength(1)), itemSettings()),
    SPIKE_TRAP(new SpikeTrapBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque().strength(0.5f, 1.0f)), itemSettings()),

    // guidestones
    GUIDESTONE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_ARROW(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_HOME(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_INTEREST(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_DANGER(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    //wattle and daub
    BLOCK_DAUB(new Block(Block.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.TUFF)), itemSettings()),
    BLOCK_WATTLE_AND_DAUB(new Block(Block.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.TUFF)), itemSettings()),
    BLOCK_WATTLE_AND_DAUB_CROSS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.TUFF)), itemSettings()),
    BLOCK_WATTLE_AND_DAUB_PLUS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.TUFF)), itemSettings()),

    BLOCK_WATTLE_AND_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()), // block_wattle_and_glass
    BLOCK_WATTLE_AND_GLASS_CROSS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()), // block_wattle_and_glass_cross
    BLOCK_WATTLE_AND_GLASS_PLUS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()), // block_wattle_and_glass_plus
    
    BLOCK_WATTLE_AND_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_CROSS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_PLUS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),

    WATTLE_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR)), itemSettings()),
    WATTLE_TRAPDOOR(new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR)), itemSettings()),
    WATTLE_BARS(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(1).sounds(BlockSoundGroup.WOOD)), itemSettings()),
    WATTLE_GRATE(new GrateBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),

    //lattice
    WATTLE_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    ACACIA_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    AMBERBLOSSOM_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    APPLE_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    BIRCH_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()), itemSettings()),
    DARK_OAK_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()), itemSettings()),
    JUNGLE_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()), itemSettings()),
    MANGROVE_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()), itemSettings()),
    OAK_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    SPRUCE_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()), itemSettings()),

    CRIMSON_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()), itemSettings()),
    WARPED_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.WARPED_NYLIUM).nonOpaque()), itemSettings()),

    //thatch
    THATCH_BLOCK(new PillarBlock(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    WEAVED_THATCH_BLOCK(new Block(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    TIGHTLY_WEAVED_THATCH_BLOCK(new Block(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),

    GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR).hardness(0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque()), itemSettings()),
    TINTED_GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR).hardness(0.3f).sounds(BlockSoundGroup.GLASS)), itemSettings()),

    GLOWSQUID_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 6)), itemSettings()),
    BRIMSTONE_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    DEAD_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->0)), itemSettings()),
    BURNT_OUT_TORCH(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.WOOD)), itemSettings()),
    BURNT_OUT_CANDLE(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CANDLE)).shape(4, 12), itemSettings()),
    ARROW_BLOCK(new ArrowBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BAMBOO).noCollision()), itemSettings()),

    GRAVE_MARKER(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    SHALE_GRAVESTONE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_SPIRIT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_HEART(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_ROSE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_TEXT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),

    GRAVE_MARKER_PET(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings()),
    SHALE_PET_GRAVESTONE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_PET_GRAVESTONE_SPIRIT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_PET_GRAVESTONE_HEART(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_PET_GRAVESTONE_ROSE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_PET_GRAVESTONE_TEXT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    
    // candelabra
    SMALL_CANDELABRA(new OxidizableSmallCandelabraBlock(OxidationLevel.UNAFFECTED), itemSettings()),
    SMALL_CANDELABRA_EXPOSED(new OxidizableSmallCandelabraBlock(OxidationLevel.EXPOSED), itemSettings()),
    SMALL_CANDELABRA_WEATHERED(new OxidizableSmallCandelabraBlock(OxidationLevel.WEATHERED), itemSettings()),
    SMALL_CANDELABRA_OXIDIZED(new OxidizableSmallCandelabraBlock(OxidationLevel.OXIDIZED), itemSettings()),
    MEDIUM_CANDELABRA(new OxidizableMediumCandelabraBlock(OxidationLevel.UNAFFECTED), itemSettings()),
    MEDIUM_CANDELABRA_EXPOSED(new OxidizableMediumCandelabraBlock(OxidationLevel.EXPOSED), itemSettings()),
    MEDIUM_CANDELABRA_WEATHERED(new OxidizableMediumCandelabraBlock(OxidationLevel.WEATHERED), itemSettings()),
    MEDIUM_CANDELABRA_OXIDIZED(new OxidizableMediumCandelabraBlock(OxidationLevel.OXIDIZED), itemSettings()),
    LARGE_CANDELABRA(new OxidizableLargeCandelabraBlock(OxidationLevel.UNAFFECTED), itemSettings()),
    LARGE_CANDELABRA_EXPOSED(new OxidizableLargeCandelabraBlock(OxidationLevel.EXPOSED), itemSettings()),
    LARGE_CANDELABRA_WEATHERED(new OxidizableLargeCandelabraBlock(OxidationLevel.WEATHERED), itemSettings()),
    LARGE_CANDELABRA_OXIDIZED(new OxidizableLargeCandelabraBlock(OxidationLevel.OXIDIZED), itemSettings()),
    WALL_CANDELABRA(new OxidizableWallCandelabraBlock(OxidationLevel.UNAFFECTED), itemSettings()),
    WALL_CANDELABRA_EXPOSED(new OxidizableWallCandelabraBlock(OxidationLevel.EXPOSED), itemSettings()),
    WALL_CANDELABRA_WEATHERED(new OxidizableWallCandelabraBlock(OxidationLevel.WEATHERED), itemSettings()),
    WALL_CANDELABRA_OXIDIZED(new OxidizableWallCandelabraBlock(OxidationLevel.OXIDIZED), itemSettings()),
    WAXED_SMALL_CANDELABRA(new SmallCandelabraBlock(), itemSettings()),
    WAXED_SMALL_CANDELABRA_EXPOSED(new SmallCandelabraBlock(), itemSettings()),
    WAXED_SMALL_CANDELABRA_WEATHERED(new SmallCandelabraBlock(), itemSettings()),
    WAXED_SMALL_CANDELABRA_OXIDIZED(new SmallCandelabraBlock(), itemSettings()),
    WAXED_MEDIUM_CANDELABRA(new MediumCandelabraBlock(), itemSettings()),
    WAXED_MEDIUM_CANDELABRA_EXPOSED(new MediumCandelabraBlock(), itemSettings()),
    WAXED_MEDIUM_CANDELABRA_WEATHERED(new MediumCandelabraBlock(), itemSettings()),
    WAXED_MEDIUM_CANDELABRA_OXIDIZED(new MediumCandelabraBlock(), itemSettings()),
    WAXED_LARGE_CANDELABRA(new LargeCandelabraBlock(), itemSettings()),
    WAXED_LARGE_CANDELABRA_EXPOSED(new LargeCandelabraBlock(), itemSettings()),
    WAXED_LARGE_CANDELABRA_WEATHERED(new LargeCandelabraBlock(), itemSettings()),
    WAXED_LARGE_CANDELABRA_OXIDIZED(new LargeCandelabraBlock(), itemSettings()),
    WAXED_WALL_CANDELABRA(new WallCandelabraBlock(), itemSettings()),
    WAXED_WALL_CANDELABRA_EXPOSED(new WallCandelabraBlock(), itemSettings()),
    WAXED_WALL_CANDELABRA_WEATHERED(new WallCandelabraBlock(), itemSettings()),
    WAXED_WALL_CANDELABRA_OXIDIZED(new WallCandelabraBlock(), itemSettings()),

    SPRINKLER(new SprinklerBlock(), itemSettings()),

    //scarecrows
    SCARECROW(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_GLOWING(new ScarecrowBlock(true), itemSettings()),
    SCARECROW_TARGET(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_HAT(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_HAT_GLOWING(new ScarecrowBlock(true), itemSettings()),
    TARGET_DUMMY(new ScarecrowBlock(false), itemSettings()),

    // redstonery
    TARGET_BLOCK(new ModTargetBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    STAKE(new StakeBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).breakInstantly()), itemSettings()),
    LANTERN_HANGER(new LanternHangerBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).breakInstantly().sounds(BlockSoundGroup.WOOD).nonOpaque()), itemSettings()),

    // glass blocks & windows
    TINTED_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.TINTED_GLASS)), itemSettings()),
    TERRARIUM_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    TERRARIUM_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),
    BRIMSTONE_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS).luminance(s -> 8).resistance(30).hardness(2)), itemSettings()),
    BRIMSTONE_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE).luminance(s -> 8).resistance(30).hardness(2)), itemSettings()),
    BEVELED_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    BEVELED_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),
    BEVELED_BRIMSTONE_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS).luminance(s -> 8).resistance(30).hardness(2)), itemSettings()),
    BEVELED_BRIMSTONE_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE).luminance(s -> 8).resistance(30).hardness(2)), itemSettings()),
    BEVELED_TINTED_GLASS(new TintedGlassBlock(Block.Settings.copy(Blocks.TINTED_GLASS)), itemSettings()),
    BEVELED_TINTED_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.TINTED_GLASS)), itemSettings()),

    // Potted flowers
    POTTED_BLACK_DAHLIA(new PotBlock(ModNaturalBlocks.BLACK_DAHLIA)),
    POTTED_FLUFFY_DANDELION(new PotBlock(ModNaturalBlocks.FLUFFY_DANDELION)),
    POTTED_FADED_SOUL_ROSE(new PotBlock(ModNaturalBlocks.FADED_SOUL_ROSE)),
    POTTED_HONEYCLUSTER(new PotBlock(ModNaturalBlocks.HONEYCLUSTER)),
    POTTED_LAVENDER(new PotBlock(ModNaturalBlocks.LAVENDER)),
    POTTED_ORANGE_BEAUTY(new PotBlock(ModNaturalBlocks.ORANGE_BEAUTY)),
    POTTED_POISON_BLOSSOM(new PotBlock(ModNaturalBlocks.POISON_BLOSSOM)),
    POTTED_PURPLE_TULIP(new PotBlock(ModNaturalBlocks.PURPLE_TULIP)),
    POTTED_YELLOW_TULIP(new PotBlock(ModNaturalBlocks.YELLOW_TULIP)),
    POTTED_LIGHT_BLUE_TULIP(new PotBlock(ModNaturalBlocks.LIGHT_BLUE_TULIP)),
    POTTED_BLACK_TULIP(new PotBlock(ModNaturalBlocks.BLACK_TULIP)),
    POTTED_GODDESS_LILY(new PotBlock(ModNaturalBlocks.GODDESS_LILY)),
    POTTED_RED_LUPINE(new PotBlock(ModNaturalBlocks.RED_LUPINE)),
    POTTED_YELLOW_LUPINE(new PotBlock(ModNaturalBlocks.YELLOW_LUPINE)),
    POTTED_PINK_LUPINE(new PotBlock(ModNaturalBlocks.PINK_LUPINE)),
    POTTED_ORANGE_POPPY(new PotBlock(ModNaturalBlocks.ORANGE_POPPY)),
    POTTED_YELLOW_POPPY(new PotBlock(ModNaturalBlocks.YELLOW_POPPY)),
    POTTED_WHITE_POPPY(new PotBlock(ModNaturalBlocks.WHITE_POPPY)),
    POTTED_SNOWFLOWER(new PotBlock(ModNaturalBlocks.SNOWFLOWER)),

    // Potted mushrooms
    POTTED_GLOW_CAP(new PotBlock(ModNaturalBlocks.GLOW_CAP)),
    POTTED_JUNGLE_CAP(new PotBlock(ModNaturalBlocks.JUNGLE_CAP)),
    POTTED_SOULSPORE(new PotBlock(ModNaturalBlocks.SOULSPORE_SINGLE)),
    POTTED_MOREL(new PotBlock(ModNaturalBlocks.MOREL)),
    POTTED_GOOP_CAP(new PotBlock(ModNaturalBlocks.GOOP_CAP)),

    // Potted saplings
    POTTED_MAMON_SAPLING(new PotBlock(ModNaturalBlocks.MAMON_SAPLING)),
    POTTED_APPLE_SAPLING(new PotBlock(ModNaturalBlocks.APPLE_SAPLING)),
    POTTED_WARM_BIRCH_SAPLING(new PotBlock(ModNaturalBlocks.WARM_BIRCH_SAPLING)),

    // Other potted plants
    POTTED_FOXTAIL_FERN(new PotBlock(ModNaturalBlocks.FOXTAIL_FERN)),
    POTTED_LEATHERLEAF_FERN(new PotBlock(ModNaturalBlocks.LEATHERLEAF_FERN)),
    POTTED_MOSS_SPROUTLET(new PotBlock(ModNaturalBlocks.MOSS_SPROUTLET)),
    POTTED_ORANGE_FERN(new PotBlock(ModNaturalBlocks.ORANGE_FERN)),
    POTTED_SPROUT(new PotBlock(ModNaturalBlocks.SPROUT)),
    POTTED_DESERT_SHRUB(new PotBlock(ModNaturalBlocks.DESERT_SHRUB)),
    POTTED_LUSH_BUSH(new PotBlock(ModNaturalBlocks.LUSH_BUSH)),

    // Potted plants that need custom models (due to not using the cross shape, or their texture being too big for the pot)
    POTTED_FLOWERING_CACTUS(new PotBlock(ModNaturalBlocks.FLOWERING_CACTUS)),
    POTTED_JUNGLE_BUSH(new PotBlock(ModNaturalBlocks.JUNGLE_BUSH)),
    POTTED_PANFLOWERS(new PotBlock(ModNaturalBlocks.PANFLOWERS)),
    POTTED_FROSTFERN(new PotBlock(ModNaturalBlocks.FROSTFERN)),
    POTTED_CLARET_LEAF(new PotBlock(ModNaturalBlocks.CLARET_LEAF)),
    POTTED_WEEPING_GHOST_WILLOW(new PotBlock(ModNaturalBlocks.WEEPING_GHOST_WILLOW)),
    POTTED_BONE_WEED(new PotBlock(ModNaturalBlocks.BONE_WEED)),
    
    // wood types
    // mamon
    MAMON_WOOD(new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings()),
    STRIPPED_MAMON_WOOD(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), itemSettings()),
    STRIPPED_MAMON_LOG(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG)), itemSettings()),
    MAMON_PLANKS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    MAMON_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR)), itemSettings()),
    MAMON_TRAPDOOR(new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR)), itemSettings()),
    MAMON_SLAB(new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB)), itemSettings()),
    MAMON_STAIRS(new StairsBlock(MAMON_PLANKS.getState(), Block.Settings.copy(Blocks.OAK_STAIRS)), itemSettings()),
    MAMON_BUTTON(new WoodenButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON)), itemSettings()),
    MAMON_FENCE(new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE)), itemSettings()),
    MAMON_FENCE_GATE(new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)), itemSettings()),
    MAMON_PRESSURE_PLATE(new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE)), itemSettings()),

    // apple
    APPLE_WOOD(new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings()),
    STRIPPED_APPLE_WOOD(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), itemSettings()),
    STRIPPED_APPLE_LOG(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG)), itemSettings()),
    APPLE_PLANKS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    APPLE_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR)), itemSettings()),
    APPLE_TRAPDOOR(new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR)), itemSettings()),
    APPLE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB)), itemSettings()),
    APPLE_STAIRS(new StairsBlock(APPLE_PLANKS.getState(), Block.Settings.copy(Blocks.OAK_STAIRS)), itemSettings()),
    APPLE_BUTTON(new WoodenButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON)), itemSettings()),
    APPLE_FENCE(new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE)), itemSettings()),
    APPLE_FENCE_GATE(new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)), itemSettings()),
    APPLE_PRESSURE_PLATE(new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE)), itemSettings()),
    
    //ancient wood
    //ANCIENT_WOOD(new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings()),
    //STRIPPED_ANCIENT_WOOD(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), itemSettings()),
    //STRIPPED_ANCIENT_LOG(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG)), itemSettings()),
    //ANCIENT_PLANKS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    //ANCIENT_SLAB(new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB)), itemSettings()),
    //ANCIENT_STAIRS(new StairsBlock(ANCIENT_PLANKS.getState(), Block.Settings.copy(Blocks.OAK_STAIRS)), itemSettings()),
    //ANCIENT_BUTTON(new WoodenButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON)), itemSettings()),
    //ANCIENT_FENCE(new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE)), itemSettings()),
    //ANCIENT_FENCE_GATE(new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE)), itemSettings()),
    //ANCIENT_PRESSURE_PLATE(new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE)), itemSettings()),

    // carved
    GHOST_PUMPKIN_CARVED(new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().allowsSpawning(ModBlocks::always)), itemSettings().equipmentSlot(i-> EquipmentSlot.HEAD)),
    GHOST_JACK_O_LANTERN(new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().luminance(15).allowsSpawning(ModBlocks::always)), itemSettings()),
    
    // bales
    GLOW_KELP_BLOCK(new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TEAL).luminance(s->10)), itemSettings()),
    ORANGE_KELP_BLOCK(new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TERRACOTTA_GRAY)), itemSettings()),
    FIBER_BALE(new HayBlock(Block.Settings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN)), itemSettings()),
    SUGARCANE_BALE(new HayBlock(Block.Settings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN)), itemSettings()),
    ROTTEN_FLESH_BLOCK(new Block(Block.Settings.copy(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.TERRACOTTA_RED)), itemSettings()),
    
    // Separator of raw blocks and bales
    SALT_BLOCK(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    // raw blocks of "_____"
    //RAW_GOLEMITE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    RAW_PRIMSTEEL_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    CHARCOAL_BLOCK(new Block(Block.Settings.copy(Blocks.COAL_BLOCK)), itemSettings()),
    
    // not strictly either
    ANTHRACITE_BLOCK(new Block(Block.Settings.copy(Blocks.COAL_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    AMBER_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    
    // refined blocks of "___"

    PRIMSTEEL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_PLATE(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    PRIMSTEEL_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    PRIMSTEEL_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    PRIMSTEEL_BARS(new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS)), itemSettings()),

    IRON_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_CUT_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    IRON_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    IRON_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),

    //GOLDEN_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    //GOLDEN_GRATE(new GrateBlock(Block.Settings.copy(Blocks.GOLD_BLOCK).nonOpaque()), itemSettings()),
    //GOLDEN_BARS(new PaneBlock(Block.Settings.copy(Blocks.GOLD_BLOCK)), itemSettings()),

    ROSEGOLD_BLOCK(new Block(Block.Settings.copy(Blocks.GOLD_BLOCK).strength(4.1f, 5.0f)), itemSettings()),

    //GOLEMITE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    //GOLEMITE_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    //GOLEMITE_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    //GOLEMITE_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    //GOLEMITE_BARS(new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS)), itemSettings()),
    
    // erdstone
    POLISHED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    MOSSY_ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    //ARID_MOSSY_ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    ERDSTONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.QUARTZ_PILLAR).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings()),
    
    ERDSTONE_TILES(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    PATTERNED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_SPIRIT(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    // adventurine
    POLISHED_ADVENTURINE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(25).resistance(2500f).luminance(s ->5)), itemSettings()),
    
    // adventurine infused erdstone
    //POLISHED_ERDSTONE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    //ERDSTONE_BRICKS_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    //ERDSTONE_PILLAR_POWERED(new PillarBlock(Block.Settings.copy(Blocks.QUARTZ_PILLAR).sounds(BlockSoundGroup.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    //ERDSTONE_TILES_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    //CHISELED_ERDSTONE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    //CHISELED_ERDSTONE_FACE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings().rarity(Rarity.UNCOMMON)),
    //CHISELED_ERDSTONE_BRICK_FACE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings().rarity(Rarity.UNCOMMON)),
    //ERDSTONE_WINDOW_POWERED(new GlassBlock(Block.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.DEEPSLATE).hardness(50).resistance(2500f).nonOpaque().luminance(s ->3)), itemSettings().rarity(Rarity.UNCOMMON)),
    //PATTERNED_ERDSTONE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),

    //shale
    COBBLED_SHALE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    POLISHED_SHALE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_RUNE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    //marble
    POLISHED_MARBLE(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_BRICKS(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_PILLAR(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_CHISELED(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_CHISELED_FACE(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_PATTERNED(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_AIR(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),

    //special tiles
    KITCHEN_TILES(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),

    //shiverstone
    SHIVERSTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    //serpentinite
    SERPENTINITE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_BRICKS(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_WATER(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    // polished stones
    VERDANTINE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    DIABASE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    LIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    GRIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    // Polished stone stairs & slabs
    CARMINE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_SMOOTH_STAIRS(new StairsBlock(CARMINE_SMOOTH.getState(), Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_SLAB(new SlabBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_WALL(new WallBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),

    //ice and snow blocks
    PACKED_SNOW_BRICKS_LARGE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.SNOW)), itemSettings()),
    PACKED_SNOW_BRICKS_SMALL(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.SNOW)), itemSettings()),

    //andesite/diorite/granite
    ANDESITE_BRICKS(new Block(Block.Settings.copy(Blocks.ANDESITE)), itemSettings()),
    DIORITE_BRICKS(new Block(Block.Settings.copy(Blocks.DIORITE)), itemSettings()),
    GRANITE_BRICKS(new Block(Block.Settings.copy(Blocks.GRANITE)), itemSettings()),

    //dripstone bricks
    POLISHED_DRIPSTONE(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    MOSSY_DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_TILES(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    PATTERNED_DRIPSTONE(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    CHISELED_DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_EARTH(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),

    //industrial blocks
    //INDUSTRIAL_BRICKS(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),
    //INDUSTRIAL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),

    //scorchstone
    SCORCHSTONE_TILES(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    MOSSY_SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    //CHISELED_SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_FIRE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    //SCORCHSTONE_TILES_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings().fireproof()),
    //SCORCHSTONE_BRICKS_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings().fireproof()),

    //cobblestone bricks
    POLISHED_COBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    MOSSY_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    //ARID_MOSSY_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    CHISELED_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    //??? other misc stone blocks ig
    STONE_TILES(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    POLISHED_STONE(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    SMOOTH_STONE_TILES(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    //sandstone
    CHISELED_SANDSTONE_BLANK(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    //red sandstone
    CHISELED_RED_SANDSTONE_BLANK(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE))),

    //chimneys aka hell
    //INDUSTRIAL_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SMOOTH_BASALT).nonOpaque()), itemSettings()),
    COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    COBBLESTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    STONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.BRICKS).nonOpaque()), itemSettings()),
    MUD_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.MUD_BRICKS).nonOpaque()), itemSettings()),
    ERDCOBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(ModNaturalBlocks.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    ERDSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(ModNaturalBlocks.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SANDSTONE).nonOpaque()), itemSettings()),
    RED_SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_SANDSTONE).nonOpaque()), itemSettings()),
    CARMINE_COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    ANDESITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.ANDESITE).nonOpaque()), itemSettings()),
    GRANITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.GRANITE).nonOpaque()), itemSettings()),
    DIORITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DIORITE).nonOpaque()), itemSettings()),
    DRIPSTONE_TILE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
    DRIPSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
    SHALE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE).nonOpaque()), itemSettings()),
    DEEPSLATE_TILE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DEEPSLATE).nonOpaque()), itemSettings()),
    DEEPSLATE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DEEPSLATE).nonOpaque()), itemSettings()),
    NETHER_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.NETHER_BRICKS).nonOpaque()), itemSettings()),
    RED_NETHER_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_NETHER_BRICKS).nonOpaque()), itemSettings()),

    // leathers are last
    LEATHER_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    TANNED_LEATHER_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    BLACK_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLACK).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    BLUE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    BROWN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BROWN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    CYAN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.CYAN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    GREEN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    GREY_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    LIGHT_BLUE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    LIGHT_GREY_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    LIME_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIME).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    MAGENTA_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.MAGENTA).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    ORANGE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.ORANGE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    PINK_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PINK).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    PURPLE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    RED_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.RED).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    WHITE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.WHITE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    YELLOW_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),

    //artifact blocks go here
    TRANSLATION_CANVAS(new TranslationCanvasBlock(Block.Settings.copy(Blocks.OAK_PLANKS).breakInstantly().sounds(BlockSoundGroup.CANDLE).nonOpaque()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),

    // clay pots go here (not the baking item one)
    BROWN_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSoundGroup.GLASS).breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    BLUE_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque().breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),

    //cave paintings
    ERDSTONE_CAVE_PAINTING_PORTRAIT(new CavePainting(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2), "portrait"), itemSettings().group(BOOKS)),
    ERDSTONE_CAVE_PAINTING_ZOMBIES(new CavePainting(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2), "zombie"), itemSettings().group(BOOKS)),
    ERDSTONE_CAVE_PAINTING_HOME(new CavePainting(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2), "home"), itemSettings().group(BOOKS)),
    ERDSTONE_CAVE_PAINTING_FAMILY(new CavePainting(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2), "family"), itemSettings().group(BOOKS)),
    
    //cobblestone statues
    OCELOT_STATUE(new AnimalStatueBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque().resistance(2500)), itemSettings().rarity(Rarity.UNCOMMON).maxCount(1).group(BOOKS)),

    //villager and illager blocks go here
    CAMPFIRE_POT(new CampfirePotBlock(Block.Settings.copy(Blocks.CAULDRON).ticksRandomly().luminance(s -> 16).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL(new WagonWheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_PLATFORM(new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_TABLE(new WagonWheelTableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ALLAY_LANTERN(new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->3)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),
    VEX_LANTERN(new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->3)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),
    VEX_QUEEN_LANTERN(new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->6)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),

    //lodged and rusty blocks go here
    SWORD_BLOCK(new SwordBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    PICKAXE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    RUSTED_CHEST(new RustedChestBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),

    //skulls and skeletons go here
    VILLAGER_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    VILLAGER_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    MOBLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    MOBLIN_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PIGLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PIGLIN_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    SKELETAL_MINING_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    DAERDRI_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    GEITLIN_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    SNIFFER_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    //cave paintings go here
    CAVE_PAINTING_FAMILY(new Block(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    CAVE_PAINTING_HOME(new Block(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    CAVE_PAINTING_PORTRAIT(new Block(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    CAVE_PAINTING_ZOMBIES(new Block(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),

    //rare sandstone temple blocks go here
    CHISELED_SANDSTONE_PORTAL_COMING(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_SANDSTONE_PORTAL_LEAVING(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_SANDSTONE_ENDERMAN(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_SANDSTONE_REST(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_SANDSTONE_TEMPLE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),

    CHISELED_RED_SANDSTONE_PIGLIN(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_RED_SANDSTONE_PORTAL_COMING(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    CHISELED_RED_SANDSTONE_PORTAL_LEAVING(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //misc ancient blocks go here
    CHISELED_ERDSTONE_BRICK_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    MOSSY_PATTERNED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    ERDSTONE_WINDOW(new GlassBlock(Block.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.DEEPSLATE).hardness(1).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    ERDSTONE_TARGET_BLOCK(new TargetBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1).luminance(s ->10)), itemSettings().rarity(Rarity.RARE).group(BOOKS)),
    ERDSTONE_DISPENSER(new DispenserBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    ERDSTONE_SPIRIT_LIT(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).luminance(s ->16)), itemSettings().rarity(Rarity.RARE).group(BOOKS)),
    ERDSTONE_LANTERN(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).luminance(s ->10)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),

    //last block on the artifacts tab
    DEFECTIVE_SPAWNER(new DefectiveBlock(Block.Settings.copy(Blocks.SPAWNER)), itemSettings().rarity(Rarity.RARE).group(BOOKS).maxCount(64).fireproof());

    public static void initialize() {
        
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(NON_NATURAL_BLOCKS);
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
    
    /** create light level from lit blockstate */
    private static ToIntFunction<BlockState> lightFromLit(int litLevel) {
        return state -> state.get(Properties.LIT) != false ? litLevel : 0;
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Block block;
    
    @Nullable
    public final Item item;
    
    public final Identifier id;
    
    /** Register the block without the item. */
    ModBlocks(Block block) {
        this.block = block;
        this.item = null;
        Registry.register(Registry.BLOCK, id = id(), block);
    }
    
    /** Register the block without the item. */
    ModBlocks(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    ModBlocks(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
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
    
    @Override
    public Identifier getId() {
        return id;
    }
}
