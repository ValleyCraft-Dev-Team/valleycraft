package net.linkle.valleycraft.init;

import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.LilyPadItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.block.GhostPumpkinBlock;
import net.linkle.valleycraft.block.GloomBerryBodyBlock;
import net.linkle.valleycraft.block.GloomBerryHeadBlock;
import net.linkle.valleycraft.block.ModCarvedPumpkinBlock;
import net.linkle.valleycraft.block.ModPlantBlock;
import net.linkle.valleycraft.block.RockBlock;
import net.linkle.valleycraft.util.BlockPres;
import net.linkle.valleycraft.util.Reg;

public class ModBlocks {

    public static final Block DRY_DIRT = new Block(Block.Settings.copy(Blocks.COARSE_DIRT));
    public static final Block SANDY_GRAVEL = new FallingBlock(Block.Settings.copy(Blocks.GRAVEL));
    public static final Block ARID_MOSSY_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block MOSSY_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE_COBBLESTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block CARMINE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block DIABASE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block DIABASE_SMOOTH = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block SERPENTINITE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block GRIMESTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block LIMESTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block SHIVERSTONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VERDANTINE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VOLCANIC_STONE = new Block(Block.Settings.copy(Blocks.STONE));
    public static final Block VOLCANIC_ASH = new FallingBlock(Block.Settings.copy(Blocks.SAND));
    public static final Block PUMICE = new Block(Block.Settings.copy(Blocks.STONE));

    public static final Block BEE_NEST_WALL = new Block(Block.Settings.copy(Blocks.OAK_PLANKS));

    public static final Block APPLE_WOOD = new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block APPLE_LOG = new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG));
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
    public static final Block APPLE_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    
    public static final Block MAMON_WOOD = new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD));
    public static final Block MAMON_LOG = new PillarBlock(Block.Settings.copy(Blocks.OAK_LOG));
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
    public static final Block MAMON_PRESSURE_PLATE = new PressurePlateBlock(ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    
    public static final Block GHOST_PUMPKIN = new GhostPumpkinBlock();
    public static final Block GHOST_PUMPKIN_CARVED = new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().allowsSpawning(ModBlocks::always));
    public static final Block GHOST_JACK_O_LANTERN = new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().luminance(15).allowsSpawning(ModBlocks::always));

    public static final Block ARGENTSHROOM = new ModPlantBlock();
    public static final Block BLACK_DAHLIA = new ModPlantBlock();
    public static final Block BLACK_TULIP = new ModPlantBlock();
    public static final Block FLOWERING_CACTUS = new ModPlantBlock().setGround(BlockPres.SAND);
    public static final Block FLUFFY_DANDELION = new ModPlantBlock();
    public static final Block FOXTAIL_FERN = new ModPlantBlock();
    public static final Block GILDED_CAP = new ModPlantBlock();
    public static final Block GLOW_CAP = new ModPlantBlock();
    public static final Block HONEYCLUSTER = new ModPlantBlock();
    public static final Block IRONSHROOM = new ModPlantBlock();
    public static final Block JUNGLE_CAP = new ModPlantBlock();
    public static final Block LAVENDER = new ModPlantBlock();
    public static final Block LEATHERLEAF_FERN = new ModPlantBlock();
    public static final Block LIGHT_BLUE_TULIP = new ModPlantBlock();
    public static final Block MINERS_LETTUCE = new ModPlantBlock();
    public static final Block MOSS_SPROUTLET = new ModPlantBlock();
    public static final Block ORANGE_BEAUTY = new ModPlantBlock();
    public static final Block ORANGE_FERN = new ModPlantBlock();
    public static final Block PINK_LUPINE = new ModPlantBlock();
    public static final Block POISON_BLOSSOM = new ModPlantBlock();
    public static final Block PURPLE_TULIP = new ModPlantBlock();
    public static final Block RED_LUPINE = new ModPlantBlock();
	public static final Block ROOTED_WATCHER = new ModPlantBlock();
    public static final Block SHIVERCAP = new ModPlantBlock();
    public static final Block SHORT_GRASS = new ModPlantBlock();
    public static final Block SNOWFLOWER = new ModPlantBlock();
    public static final Block SPROUT = new ModPlantBlock();
    public static final Block THORNY_BUSH = new ModPlantBlock();
    public static final Block WARDING_SHROOM = new ModPlantBlock();
    public static final Block WEAPING_GHOST_WILLOW = new ModPlantBlock();
    public static final Block WILD_BEET = new ModPlantBlock();
    public static final Block WILD_CARROT = new ModPlantBlock();
    public static final Block WILD_MINERS_LETTUCE = new ModPlantBlock();
    public static final Block WILD_POTATO = new ModPlantBlock();
    public static final Block WILD_WHEAT = new ModPlantBlock();
    //public static final Block WILD_SPICY_PEPPERS = new ModPlantBlock();
    //public static final Block WILD_ONION = new ModPlantBlock();
    //public static final Block WILD_CAVE_ROOT = new ModPlantBlock();
    //public static final Block WILD_HERBS = new ModPlantBlock();
    //public static final Block WILD_ALOE = new ModPlantBlock();
    //public static final Block WILD_AMETHYSTLE = new ModPlantBlock();
    public static final Block WILD_PUFF_BALL = new ModPlantBlock();

    public static final Block YELLOW_LUPINE = new ModPlantBlock();
    public static final Block YELLOW_TULIP = new ModPlantBlock();

    public static final Block PANFLOWERS = new ModPlantBlock();
    public static final Block JUNGLE_BUSH = new ModPlantBlock();
    //public static final Block FROSTFERN = new ModPlantBlock();
    //public static final Block TALL_CORNFLOWER = new ModPlantBlock();
    //public static final Block TALL_OYXEYE_DAISY = new ModPlantBlock();

    public static final Block BONE_JOINT = new Block(Block.Settings.copy(Blocks.BONE_BLOCK));
    public static final Block ROCKS = new RockBlock();

    //public static final Block STALWART_SHROOM = new ModPlantBlock();
    //public static final Block MOREL = new ModPlantBlock();
    public static final Block STICKY_SHROOM = new ModPlantBlock();
    public static final Block GOOP_CAP = new ModPlantBlock();
    public static final Block ORANGE_POPPY = new ModPlantBlock();
    public static final Block YELLOW_POPPY = new ModPlantBlock();
    public static final Block WHITE_POPPY = new ModPlantBlock();
    public static final Block CAVE_ROOTS = new ModPlantBlock();
    public static final Block DESERT_SHRUB = new ModPlantBlock();
    public static final Block BUSH = new ModPlantBlock();
    public static final Block BONE_WEED = new ModPlantBlock();
    public static final Block LIVING_BUSH = new ModPlantBlock();
    public static final Block STALAGMITE = new ModPlantBlock();
    public static final Block STALAGTITE = new ModPlantBlock();

    public static final Block BIG_FERN = new ModPlantBlock();
    public static final Block FLOWERING_LILYPAD = new LilyPadBlock(Block.Settings.copy(Blocks.LILY_PAD));
    
    public static final Block GLOOM_BERRY = new GloomBerryHeadBlock();
    public static final Block GLOOM_BERRY_PLANT = new GloomBerryBodyBlock();

    public static void initialize() {
        Reg.registerWithItem("dry_dirt", DRY_DIRT, itemSettings());
        Reg.registerWithItem("sandy_gravel", SANDY_GRAVEL, itemSettings());
        Reg.registerWithItem("arid_mossy_stone", ARID_MOSSY_STONE, itemSettings());
        Reg.registerWithItem("mossy_stone", MOSSY_STONE, itemSettings());
        Reg.registerWithItem("carmine", CARMINE, itemSettings());
        Reg.registerWithItem("carmine_cobblestone", CARMINE_COBBLESTONE, itemSettings());
        Reg.registerWithItem("carmine_smooth", CARMINE_SMOOTH, itemSettings());
        Reg.registerWithItem("diabase", DIABASE, itemSettings());
        Reg.registerWithItem("diabase_smooth", DIABASE_SMOOTH, itemSettings());
        Reg.registerWithItem("serpentinite", SERPENTINITE, itemSettings());
        Reg.registerWithItem("grimestone", GRIMESTONE, itemSettings());
        Reg.registerWithItem("limestone", LIMESTONE, itemSettings());
        Reg.registerWithItem("shiverstone", SHIVERSTONE, itemSettings());
        Reg.registerWithItem("verdantine", VERDANTINE, itemSettings());
        Reg.registerWithItem("volcanic_stone", VOLCANIC_STONE, itemSettings());
        Reg.registerWithItem("volcanic_ash", VOLCANIC_ASH, itemSettings());
        Reg.registerWithItem("pumice", PUMICE, itemSettings());
        Reg.registerWithItem("rocks", ROCKS, itemSettings());

        Reg.registerWithItem("bone_joint", BONE_JOINT, itemSettings());

        Reg.registerWithItem("apple_wood", APPLE_WOOD, itemSettings());
        Reg.registerWithItem("apple_log", APPLE_LOG, itemSettings());
        Reg.registerWithItem("stripped_apple_wood", STRIPPED_APPLE_WOOD, itemSettings());
        Reg.registerWithItem("stripped_apple_log", STRIPPED_APPLE_LOG, itemSettings());
        Reg.registerWithItem("apple_planks", APPLE_PLANKS, itemSettings());
        Reg.registerWithItem("apple_door", APPLE_DOOR, itemSettings());
        Reg.registerWithItem("apple_trapdoor", APPLE_TRAPDOOR, itemSettings());
        Reg.registerWithItem("apple_slab", APPLE_SLAB, itemSettings());
        Reg.registerWithItem("apple_stairs", APPLE_STAIRS, itemSettings());
        Reg.registerWithItem("apple_button", APPLE_BUTTON, itemSettings());
        Reg.registerWithItem("apple_fence", APPLE_FENCE, itemSettings());
        Reg.registerWithItem("apple_fence_gate", APPLE_FENCE_GATE, itemSettings());
        Reg.registerWithItem("apple_pressure_plate", APPLE_PRESSURE_PLATE, itemSettings());
        
        Reg.registerWithItem("mamon_wood", MAMON_WOOD, itemSettings());
        Reg.registerWithItem("mamon_log", MAMON_LOG, itemSettings());
        Reg.registerWithItem("stripped_mamon_wood", STRIPPED_MAMON_WOOD, itemSettings());
        Reg.registerWithItem("stripped_mamon_log", STRIPPED_MAMON_LOG, itemSettings());
        Reg.registerWithItem("mamon_planks", MAMON_PLANKS, itemSettings());
        Reg.registerWithItem("mamon_door", MAMON_DOOR, itemSettings());
        Reg.registerWithItem("mamon_trapdoor", MAMON_TRAPDOOR, itemSettings());
        Reg.registerWithItem("mamon_slab", MAMON_SLAB, itemSettings());
        Reg.registerWithItem("mamon_stairs", MAMON_STAIRS, itemSettings());
        Reg.registerWithItem("mamon_button", MAMON_BUTTON, itemSettings());
        Reg.registerWithItem("mamon_fence", MAMON_FENCE, itemSettings());
        Reg.registerWithItem("mamon_fence_gate", MAMON_FENCE_GATE, itemSettings());
        Reg.registerWithItem("mamon_pressure_plate", MAMON_PRESSURE_PLATE, itemSettings());
        
        Reg.registerWithItem("ghost_pumpkin", GHOST_PUMPKIN, itemSettings());
        Reg.registerWithItem("ghost_pumpkin_carved", GHOST_PUMPKIN_CARVED, itemSettings().equipmentSlot(i->EquipmentSlot.HEAD));
        Reg.registerWithItem("ghost_jack_o_lantern", GHOST_JACK_O_LANTERN, itemSettings());

        Reg.registerWithItem("argentshroom", ARGENTSHROOM, itemSettings());
        Reg.registerWithItem("black_dahlia", BLACK_DAHLIA, itemSettings());
        Reg.registerWithItem("flowering_cactus", FLOWERING_CACTUS, itemSettings());
        Reg.registerWithItem("fluffy_dandelion", FLUFFY_DANDELION, itemSettings());
        Reg.registerWithItem("foxtail_fern", FOXTAIL_FERN, itemSettings());
        Reg.registerWithItem("jungle_bush", JUNGLE_BUSH, itemSettings());
        Reg.registerWithItem("panflowers", PANFLOWERS, itemSettings());

        Reg.registerWithItem("honeycluster", HONEYCLUSTER, itemSettings());
        Reg.registerWithItem("lavender", LAVENDER, itemSettings());
        Reg.registerWithItem("leatherleaf_fern", LEATHERLEAF_FERN, itemSettings());
        Reg.registerWithItem("miners_lettuce", MINERS_LETTUCE, itemSettings());
        Reg.registerWithItem("moss_sproutlet", MOSS_SPROUTLET, itemSettings());
        Reg.registerWithItem("orange_beauty", ORANGE_BEAUTY, itemSettings());
        Reg.registerWithItem("orange_fern", ORANGE_FERN, itemSettings());
        Reg.registerWithItem("poison_blossom", POISON_BLOSSOM, itemSettings());
        Reg.registerWithItem("purple_tulip", PURPLE_TULIP, itemSettings());
        Reg.registerWithItem("yellow_tulip", YELLOW_TULIP, itemSettings());
        Reg.registerWithItem("light_blue_tulip", LIGHT_BLUE_TULIP, itemSettings());
        Reg.registerWithItem("black_tulip", BLACK_TULIP, itemSettings());

        Reg.registerWithItem("red_lupine", RED_LUPINE, itemSettings());
        Reg.registerWithItem("yellow_lupine", YELLOW_LUPINE, itemSettings());
        Reg.registerWithItem("pink_lupine", PINK_LUPINE, itemSettings());

        Reg.registerWithItem("orange_poppy", ORANGE_POPPY, itemSettings());
        Reg.registerWithItem("yellow_poppy", YELLOW_POPPY, itemSettings());
        Reg.registerWithItem("white_poppy", WHITE_POPPY, itemSettings());

        Reg.registerWithItem("bee_nest_wall", BEE_NEST_WALL, itemSettings());
        Reg.registerWithItem("sticky_shroom", STICKY_SHROOM, itemSettings());
        Reg.registerWithItem("shivercap", SHIVERCAP, itemSettings());
        Reg.registerWithItem("warding_shroom", WARDING_SHROOM, itemSettings());
        Reg.registerWithItem("goop_cap", GOOP_CAP, itemSettings());
        Reg.registerWithItem("glow_cap", GLOW_CAP, itemSettings());
        Reg.registerWithItem("jungle_cap", JUNGLE_CAP, itemSettings());
        Reg.registerWithItem("gilded_cap", GILDED_CAP, itemSettings());
        Reg.registerWithItem("ironshroom", IRONSHROOM, itemSettings());
        Reg.registerWithItem("rooted_watcher", ROOTED_WATCHER, itemSettings());

        Reg.registerWithItem("short_grass", SHORT_GRASS, itemSettings());
        Reg.registerWithItem("snowflower", SNOWFLOWER, itemSettings());
        Reg.registerWithItem("sprout", SPROUT, itemSettings());
        Reg.registerWithItem("thorny_bush", THORNY_BUSH, itemSettings());
        Reg.registerWithItem("weaping_ghost_willow", WEAPING_GHOST_WILLOW, itemSettings());
        Reg.registerWithItem("wild_beet", WILD_BEET, itemSettings());
        Reg.registerWithItem("wild_carrot", WILD_CARROT, itemSettings());
        Reg.registerWithItem("wild_miners_lettuce", WILD_MINERS_LETTUCE, itemSettings());
        Reg.registerWithItem("wild_potato", WILD_POTATO, itemSettings());
        Reg.registerWithItem("wild_wheat", WILD_WHEAT, itemSettings());

        Reg.registerWithItem("wild_puff_ball", WILD_PUFF_BALL, itemSettings());
        Reg.registerWithItem("cave_roots", CAVE_ROOTS, itemSettings());
        Reg.registerWithItem("bone_weed", BONE_WEED, itemSettings());
        Reg.registerWithItem("desert_shrub", DESERT_SHRUB, itemSettings());
        Reg.registerWithItem("bush", BUSH, itemSettings());
        Reg.registerWithItem("lush_bush", LIVING_BUSH, itemSettings());
        Reg.registerWithItem("stalagmite", STALAGMITE, itemSettings());
        Reg.registerWithItem("stalagtite", STALAGTITE, itemSettings());
        
        Reg.registerWithItem("big_fern", BIG_FERN, itemSettings());
        Reg.register("flowering_lilypad", FLOWERING_LILYPAD);
        Reg.register("flowering_lilypad", new LilyPadItem(FLOWERING_LILYPAD, itemSettings()));
        
        Reg.register("gloom_berry", GLOOM_BERRY);
        Reg.register("gloom_berry_plant", GLOOM_BERRY_PLANT);
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(ModGroups.FLORA_GROUP);
    }
    
    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }

    private static PillarBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(Block.Settings.of(Material.WOOD, state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    }
}
