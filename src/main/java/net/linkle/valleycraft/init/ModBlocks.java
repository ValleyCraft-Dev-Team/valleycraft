package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.NON_NATURAL_BLOCKS;

public class ModBlocks {
    public static final Block PRIMSTEEL_PLATE_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block PRIMSTEEL_TILED_PLATE = new Block(Block.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block POLISHED_ERDSTONE = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE).hardness(2));
    public static final Block MOSSY_ERDSTONE_BRICKS = new Block(Block.Settings.copy(Blocks.STONE_BRICKS).hardness(2));
    public static final Block IRON_GRATE = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f).nonOpaque());
    public static final Block PRIMSTEEL_CHAIN = new ChainBlock(Block.Settings.copy(Blocks.CHAIN));
    public static final Block VEX_LANTERN = new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN));
    public static final Block ROSEGOLD_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f));
    public static final Block RAW_PRIMSTEEL_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f));
    public static final Block RAW_GOLEMITE_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f));
    public static final Block ANTHRACITE_BLOCK = new Block(Block.Settings.copy(Blocks.COAL_BLOCK).strength(4.2f, 5.0f));
    public static final Block AMBER_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f));
    public static final Block GOLEMITE_GRATE = new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.2f, 5.0f).nonOpaque());
    public static final Block GOLEMITE_LADDER = new LadderBlock(Block.Settings.of(Material.DECORATION).requiresTool().strength(3.0f).sounds(BlockSoundGroup.METAL).nonOpaque());
    public static final Block ERDSTONE_BRICKS = new Block(Block.Settings.copy(Blocks.STONE_BRICKS).hardness(2));
    public static final Block GLOWSQUID_LANTERN = new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 12));
    public static final Block GOLEMITE_BARS = new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS));
    public static final Block GOLEMITE_BLOCK = new Block(Block.Settings.copy(Blocks.IRON_BLOCK));
    public static final Block GOLEMITE_CHAIN = new ChainBlock(Block.Settings.copy(Blocks.CHAIN));
    public static final Block ARID_MOSSY_ERDSTONE_BRICKS = new Block(Block.Settings.copy(Blocks.STONE_BRICKS).hardness(2));
    public static final Block SPRINKLER = new SprinklerBlock();
    public static final Block CANVAS_BLOCK = new Block(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET));
    public static final Block CANVAS_CARPET = new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.MOSS_CARPET));
    public static final Block CURTAIN = new CurtainBlock();
    public static final Block DEFECTIVE_SPAWNER = new DefectiveBlock(Block.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).strength(5f, 5.0f).nonOpaque());

    public static final Block LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.TERRACOTTA_ORANGE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block BLACK_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLACK).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block BLUE_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block BROWN_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BROWN).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block CYAN_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.CYAN).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block GREEN_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block GREY_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block LIGHT_BLUE_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block LIGHT_GREY_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block LIME_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIME).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block MAGENTA_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.MAGENTA).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block ORANGE_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.ORANGE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block PINK_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PINK).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block PURPLE_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block RED_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.RED).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block WHITE_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.WHITE).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block YELLOW_LEATHER_BLOCK = new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.8f).sounds(BlockSoundGroup.WOOL));
    public static final Block SALT_BLOCK = new Block(Block.Settings.copy(Blocks.SANDSTONE));
    public static final Block STABLEHAND = new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block EMPTY_BOOKSHELF = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block POTION_BOOKSHELF = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block ANTHRO_BOOKSHELF = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));

    public static final Block ANCIENT_WAGON_WHEEL = new WagonWheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block ANCIENT_WAGON_WHEEL_PLATFORM = new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block ANCIENT_WAGON_WHEEL_TABLE = new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block WATTLE_TABLE = new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block WATTLE_TABLE_CLOTHE = new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block WATTLE_STOOL = new StoolBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block WATTLE_CHAIR = new ChairBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    public static final Block STUCK_ARROW_BLOCK = new ArrowBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BAMBOO).noCollision());
    public static final Block SWORD_BLOCK = new SwordBlock(Block.Settings.copy(Blocks.IRON_BLOCK).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN));
    public static final Block GHOST_PUMPKIN_CARVED = new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().allowsSpawning(ModBlocks::always));
    public static final Block GHOST_JACK_O_LANTERN = new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().luminance(15).allowsSpawning(ModBlocks::always));

    public static final Block FIBER_BALE = new HayBlock(Block.Settings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN));
    public static final Block GLOW_KELP_BLOCK = new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TEAL).luminance(s->10));
    public static final Block ORANGE_KELP_BLOCK = new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TERRACOTTA_GRAY));
    public static final Block ROTTEN_FLESH_BLOCK = new Block(Block.Settings.copy(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.TERRACOTTA_RED));
    public static final Block APPLE_WOOD = new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block STRIPPED_APPLE_WOOD = new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD));
    public static final Block STRIPPED_APPLE_LOG = new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG));
    public static final Block APPLE_PLANKS = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block APPLE_DOOR = new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR));
    public static final Block APPLE_TRAPDOOR = new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR));
    public static final Block APPLE_SLAB = new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB));
    public static final Block APPLE_STAIRS = new StairsBlock(APPLE_PLANKS.getDefaultState(), Block.Settings.copy(Blocks.OAK_STAIRS));
    public static final Block APPLE_BUTTON = new WoodenButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON));
    public static final Block APPLE_FENCE = new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE));
    public static final Block APPLE_FENCE_GATE = new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE));
    public static final Block APPLE_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));

    public static final Block MAMON_WOOD = new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block STRIPPED_MAMON_WOOD = new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD));
    public static final Block STRIPPED_MAMON_LOG = new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG));
    public static final Block MAMON_PLANKS = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));
    public static final Block MAMON_DOOR = new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR));
    public static final Block MAMON_TRAPDOOR = new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR));
    public static final Block MAMON_SLAB = new SlabBlock(Block.Settings.copy(Blocks.OAK_SLAB));
    public static final Block MAMON_STAIRS = new StairsBlock(MAMON_PLANKS.getDefaultState(), Block.Settings.copy(Blocks.OAK_STAIRS));
    public static final Block MAMON_BUTTON = new WoodenButtonBlock(Block.Settings.copy(Blocks.OAK_BUTTON));
    public static final Block MAMON_FENCE = new FenceBlock(Block.Settings.copy(Blocks.OAK_FENCE));
    public static final Block MAMON_FENCE_GATE = new FenceGateBlock(Block.Settings.copy(Blocks.OAK_FENCE_GATE));
    public static final Block MAMON_PRESSURE_PLATE = new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    public static final Block PUMICE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block OPTIC_GLASS = new GlassBlock(Block.Settings.copy(Blocks.GLASS));
    public static final Block CHARCOAL_BLOCK = new Block(Block.Settings.copy(Blocks.COAL_BLOCK));
    public static final Block VERDANTINE_SMOOTH = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE));
    public static final Block SHIVERSTONE_SMOOTH = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE));
    public static final Block GRIMESTONE_SMOOTH = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE));
    public static final Block SERPENTINITE_SMOOTH = new Block(Block.Settings.copy(Blocks.SMOOTH_STONE));
    public static final Block DIABASE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block LIMESTONE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));

    public static final Block GUIDESTONE = new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(2).nonOpaque());
    public static final Block GUIDESTONE_ARROW = new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(2).nonOpaque());
    public static final Block GUIDESTONE_HOME = new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(2).nonOpaque());
    public static final Block GUIDESTONE_INTEREST = new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(2).nonOpaque());
    public static final Block GUIDESTONE_DANGER = new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(2).nonOpaque());

    public static final Block CRATE = new CrateBlock(Block.Settings.copy(Blocks.BARREL));

    public static final Block MARKER_GRAVE = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block MARKER_GRAVE_PET = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block ERD_GRAVE = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block ERD_GRAVE_PET = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    //public static final Block SMOOTH_STONE_GRAVE = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    //public static final Block SMOOTH_STONE_GRAVE_PET = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    //public static final Block POLISHED_GRAVE = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));
    //public static final Block POLISHED_GRAVE_PET = new GraveBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque().breakInstantly().sounds(BlockSoundGroup.DEEPSLATE));

    public static void initialize() {
        //furniture
        Reg.registerWithItem("stablehand_station", STABLEHAND, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("empty_bookshelf", EMPTY_BOOKSHELF, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("potion_bookshelf", POTION_BOOKSHELF, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("anthro_bookshelf", ANTHRO_BOOKSHELF, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("crate", CRATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("wattle_stool", WATTLE_STOOL, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("wattle_chair", WATTLE_CHAIR, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("wattle_table", WATTLE_TABLE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("wattle_table_clothe", WATTLE_TABLE_CLOTHE, itemSettings().group(NON_NATURAL_BLOCKS));

        Reg.registerWithItem("ancient_wagon_wheel", ANCIENT_WAGON_WHEEL, itemSettings().group(BOOKS));
        Reg.registerWithItem("ancient_wagon_wheel_platform", ANCIENT_WAGON_WHEEL_PLATFORM, itemSettings().group(BOOKS));
        Reg.registerWithItem("ancient_wagon_wheel_table", ANCIENT_WAGON_WHEEL_TABLE, itemSettings().group(BOOKS));

        Reg.registerWithItem("canvas_block", CANVAS_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("canvas_carpet", CANVAS_CARPET, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("curtain", CURTAIN, itemSettings().group(NON_NATURAL_BLOCKS));

        //guidestones
        Reg.registerWithItem("guidestone", GUIDESTONE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("guidestone_arrow", GUIDESTONE_ARROW, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("guidestone_home", GUIDESTONE_HOME, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("guidestone_interest", GUIDESTONE_INTEREST, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("guidestone_danger", GUIDESTONE_DANGER, itemSettings().group(NON_NATURAL_BLOCKS));

        //odd blocks go here
        Reg.registerWithItem("arrow_block", STUCK_ARROW_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("sword_block", SWORD_BLOCK, itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON));
        Reg.registerWithItem("glowsquid_lantern", GLOWSQUID_LANTERN, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("vex_lantern", VEX_LANTERN, itemSettings().rarity(Rarity.RARE).group(BOOKS).fireproof());
        Reg.registerWithItem("defective_spawner", DEFECTIVE_SPAWNER, itemSettings().rarity(Rarity.RARE).group(BOOKS).fireproof());

        //redstonery
        Reg.registerWithItem("sprinkler", SPRINKLER, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("optic_glass", OPTIC_GLASS, itemSettings().group(NON_NATURAL_BLOCKS));

        //wood types
        //wattle and daub
        //mamon
        Reg.registerWithItem("mamon_wood", MAMON_WOOD, itemSettings());
        Reg.registerWithItem("stripped_mamon_wood", STRIPPED_MAMON_WOOD, itemSettings());
        Reg.registerWithItem("stripped_mamon_log", STRIPPED_MAMON_LOG, itemSettings());
        Reg.registerWithItem("mamon_planks", MAMON_PLANKS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_door", MAMON_DOOR, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_trapdoor", MAMON_TRAPDOOR, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_slab", MAMON_SLAB, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_stairs", MAMON_STAIRS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_button", MAMON_BUTTON, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_fence", MAMON_FENCE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_fence_gate", MAMON_FENCE_GATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mamon_pressure_plate", MAMON_PRESSURE_PLATE, itemSettings().group(NON_NATURAL_BLOCKS));
        //apple
        Reg.registerWithItem("apple_wood", APPLE_WOOD, itemSettings());
        Reg.registerWithItem("stripped_apple_wood", STRIPPED_APPLE_WOOD, itemSettings());
        Reg.registerWithItem("stripped_apple_log", STRIPPED_APPLE_LOG, itemSettings());
        Reg.registerWithItem("apple_planks", APPLE_PLANKS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_door", APPLE_DOOR, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_trapdoor", APPLE_TRAPDOOR, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_slab", APPLE_SLAB, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_stairs", APPLE_STAIRS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_button", APPLE_BUTTON, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_fence", APPLE_FENCE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_fence_gate", APPLE_FENCE_GATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("apple_pressure_plate", APPLE_PRESSURE_PLATE, itemSettings().group(NON_NATURAL_BLOCKS));

        //carved
        Reg.registerWithItem("ghost_pumpkin_carved", GHOST_PUMPKIN_CARVED, itemSettings().equipmentSlot(i-> EquipmentSlot.HEAD).group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("ghost_jack_o_lantern", GHOST_JACK_O_LANTERN, itemSettings().group(NON_NATURAL_BLOCKS));

        //tombstones
        Reg.registerWithItem("grave_marker", MARKER_GRAVE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("grave_marker_pet", MARKER_GRAVE_PET, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("erd_stone_gravestone", ERD_GRAVE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("erd_stone_gravestone_pet", ERD_GRAVE_PET, itemSettings().group(NON_NATURAL_BLOCKS));
        //Reg.registerWithItem("smooth_stone_gravestone", SMOOTH_STONE_GRAVE, itemSettings().group(NON_NATURAL_BLOCKS));
        //Reg.registerWithItem("smooth_stone_gravestone_pet", SMOOTH_STONE_GRAVE_PET, itemSettings().group(NON_NATURAL_BLOCKS));
        //Reg.registerWithItem("polished_deepslate_gravestone", POLISHED_GRAVE, itemSettings().group(NON_NATURAL_BLOCKS));
        //Reg.registerWithItem("polished_deepslate_gravestone_pet", POLISHED_GRAVE_PET, itemSettings().group(NON_NATURAL_BLOCKS));

        //bales
        Reg.registerWithItem("glow_kelp_block", GLOW_KELP_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("orange_kelp_block", ORANGE_KELP_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("fiber_bale", FIBER_BALE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("rotten_flesh_block", ROTTEN_FLESH_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        //seperator of raw blocks and bales
        Reg.registerWithItem("salt_block", SALT_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        //raw blocks of "_____"
        Reg.registerWithItem("raw_golemite_block", RAW_GOLEMITE_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("raw_primsteel_block", RAW_PRIMSTEEL_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("charcoal_block", CHARCOAL_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        //not strictly either
        Reg.registerWithItem("anthracite_block", ANTHRACITE_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("amber_block", AMBER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        //refined blocks of "___"
        Reg.registerWithItem("rosegold_block", ROSEGOLD_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("primsteel_plate_block", PRIMSTEEL_PLATE_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("primsteel_tiled_plate", PRIMSTEEL_TILED_PLATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("primsteel_chain", PRIMSTEEL_CHAIN, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("iron_grate", IRON_GRATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("golemite_block", GOLEMITE_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("golemite_chain", GOLEMITE_CHAIN, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("golemite_grate", GOLEMITE_GRATE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("golemite_ladder", GOLEMITE_LADDER, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("golemite_bars", GOLEMITE_BARS, itemSettings().group(NON_NATURAL_BLOCKS));

        //stones
        Reg.registerWithItem("polished_erdstone", POLISHED_ERDSTONE, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("erdstone_bricks", ERDSTONE_BRICKS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("mossy_erdstone_bricks", MOSSY_ERDSTONE_BRICKS, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("arid_mossy_erdstone_bricks", ARID_MOSSY_ERDSTONE_BRICKS, itemSettings().group(NON_NATURAL_BLOCKS));

        //polished stones
        Reg.registerWithItem("serpentinite_smooth", SERPENTINITE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("diabase_smooth", DIABASE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("carmine_smooth", CARMINE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("grimestone_smooth", GRIMESTONE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("limestone_smooth", LIMESTONE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("shiverstone_smooth", SHIVERSTONE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("pumice_smooth", PUMICE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("verdantine_smooth", VERDANTINE_SMOOTH, itemSettings().group(NON_NATURAL_BLOCKS));

        //leathers are last
        Reg.registerWithItem("leather_block", LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("black_leather_block", BLACK_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("blue_leather_block", BLUE_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("brown_leather_block", BROWN_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("cyan_leather_block", CYAN_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("green_leather_block", GREEN_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("grey_leather_block", GREY_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("light_blue_leather_block", LIGHT_BLUE_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("light_grey_leather_block", LIGHT_GREY_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("lime_leather_block", LIME_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("magenta_leather_block", MAGENTA_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("orange_leather_block", ORANGE_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("pink_leather_block", PINK_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("purple_leather_block", PURPLE_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("red_leather_block", RED_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("white_leather_block", WHITE_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
        Reg.registerWithItem("yellow_leather_block", YELLOW_LEATHER_BLOCK, itemSettings().group(NON_NATURAL_BLOCKS));
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(ModGroups.NON_NATURAL_BLOCKS);
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
}
