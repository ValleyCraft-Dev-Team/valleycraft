package net.linkle.floracore.init;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WoodenButtonBlock;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import net.linkle.floracore.block.ModPlantBlock;
import net.linkle.floracore.util.Reg;

public class ModBlocks {
    
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
    
    public static final Block BLACK_DAHLIA = new ModPlantBlock();
    public static final Block BLACK_TULIP = new ModPlantBlock();
    public static final Block FLOWERING_CACTUS = new ModPlantBlock().setGround(ModPlantBlock.SAND);
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
    public static final Block MYRTLES = new ModPlantBlock();
    public static final Block ORANGE_BEAUTY = new ModPlantBlock();
    public static final Block ORANGE_FERN = new ModPlantBlock();
    public static final Block PINK_LUPINE = new ModPlantBlock();
    public static final Block POISON_BLOSSOM = new ModPlantBlock();
    public static final Block PURPLE_LADY_SHROOM = new ModPlantBlock();
    public static final Block PURPLE_TULIP = new ModPlantBlock();
    public static final Block RED_LUPINE = new ModPlantBlock();
	public static final Block ROOTED_WATCHER = new ModPlantBlock();
	public static final Block SHIVERCAP = new ModPlantBlock();
	public static final Block SHORT_GRASS = new ModPlantBlock();
	public static final Block SNOWFLOWER = new ModPlantBlock();
	public static final Block SPROUT = new ModPlantBlock();
	public static final Block SWEET_SHROOM = new ModPlantBlock();
	public static final Block THORNY_BUSH = new ModPlantBlock();
	public static final Block WARDING_SHROOM = new ModPlantBlock();
	public static final Block WEAPING_GHOST_WILLOW = new ModPlantBlock();
	public static final Block WILD_BEET = new ModPlantBlock();
	public static final Block WILD_CARROT = new ModPlantBlock();
	public static final Block WILD_POTATO = new ModPlantBlock();
	public static final Block WILD_WHEAT = new ModPlantBlock();
	public static final Block YELLOW_LUPINE = new ModPlantBlock();
	public static final Block YELLOW_TULIP = new ModPlantBlock();

    public static final Block GOOP_CAP = new ModPlantBlock();

    public static final Block ORANGE_POPPY = new ModPlantBlock();
    public static final Block YELLOW_POPPY = new ModPlantBlock();
    public static final Block WHITE_POPPY = new ModPlantBlock();

    public static void initialize() {
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
        
        Reg.registerWithItem("black_dahlia", BLACK_DAHLIA, itemSettings());
        Reg.registerWithItem("flowering_cactus", FLOWERING_CACTUS, itemSettings());
        Reg.registerWithItem("fluffy_dandelion", FLUFFY_DANDELION, itemSettings());
        Reg.registerWithItem("foxtail_fern", FOXTAIL_FERN, itemSettings());

        Reg.registerWithItem("honeycluster", HONEYCLUSTER, itemSettings());
        Reg.registerWithItem("lavender", LAVENDER, itemSettings());
        Reg.registerWithItem("leatherleaf_fern", LEATHERLEAF_FERN, itemSettings());
        Reg.registerWithItem("miners_lettuce", MINERS_LETTUCE, itemSettings());
        Reg.registerWithItem("moss_sproutlet", MOSS_SPROUTLET, itemSettings());
        //Reg.registerWithItem("myrtles", MYRTLES, itemSettings());
        Reg.registerWithItem("orange_beauty", ORANGE_BEAUTY, itemSettings());
        Reg.registerWithItem("orange_fern", ORANGE_FERN, itemSettings());
        Reg.registerWithItem("poison_blossom", POISON_BLOSSOM, itemSettings());
        //Reg.registerWithItem("purple_lady_shroom", PURPLE_LADY_SHROOM, itemSettings());
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
        //Reg.registerWithItem("sweet_shroom", SWEET_SHROOM, itemSettings());
        Reg.registerWithItem("thorny_bush", THORNY_BUSH, itemSettings());
        Reg.registerWithItem("weaping_ghost_willow", WEAPING_GHOST_WILLOW, itemSettings());
        Reg.registerWithItem("wild_beet", WILD_BEET, itemSettings());
        Reg.registerWithItem("wild_carrot", WILD_CARROT, itemSettings());
        Reg.registerWithItem("wild_potato", WILD_POTATO, itemSettings());
        Reg.registerWithItem("wild_wheat", WILD_WHEAT, itemSettings());
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ModGroups.FLORA_GROUP);
    }
    
    private static PillarBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(Block.Settings.of(Material.WOOD, state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor).strength(2.0f).sounds(BlockSoundGroup.WOOD));
    }
}
