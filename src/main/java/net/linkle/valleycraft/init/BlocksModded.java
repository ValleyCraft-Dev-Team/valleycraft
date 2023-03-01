package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.BlocksNatural.VOLCANIC_STONE;
import static net.linkle.valleycraft.init.Groups.NON_NATURAL_BLOCKS;
import static net.linkle.valleycraft.init.Groups.VC_TOOLS;
import static net.linkle.valleycraft.util.BookStackVoxelShapes.*;

import java.util.function.BiFunction;
import java.util.function.ToIntFunction;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.baubles.CraftingMatBauble;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.enums.BlockEnum;
import net.linkle.valleycraft.enums.ItemEnum;
import net.linkle.valleycraft.item.BridgeItem;
import net.linkle.valleycraft.util.BlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.Oxidizable.OxidationLevel;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public enum BlocksModded implements ItemEnum, BlockEnum {

    CRAFTING_MAT(new CraftingMatBauble(Block.Settings.of(Material.DECORATION).sounds(BlockSoundGroup.WOOL).breakInstantly().noCollision().nonOpaque()), toolItemSettings()),
    CRATE(new CrateBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    DEEPSLATE_CHEST(new DeepslateChestBlock(Block.Settings.copy(Blocks.DEEPSLATE_BRICKS)), itemSettings()),
    COFFIN(new DeepslateChestBlock(Block.Settings.copy(Blocks.DEEPSLATE_BRICKS)), itemSettings()),
    MILLSTONE(new MillstoneBlock(Block.Settings.copy(Blocks.STONECUTTER).resistance(6).hardness(2.25f)), itemSettings()),

    /**cook_poi**/
    BRICK_STOVE(new StoveBlock(Block.Settings.copy(Blocks.SMOKER)), itemSettings()),
    /**innkeeper_poi**/
    KEG(new KegBlock(), itemSettings()),
    /**stablehand_poi**/
    STABLEHAND_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    STABLEHAND_COUNTER(new HorizontalBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    /**miner_poi**/
    MINER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    /**beekeeper_poi**/
    BEEKEEPER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    /**lumberjack_poi**/
    LUMBERJACK_STATION(new WoodCutterBlock(Block.Settings.copy(Blocks.STONECUTTER).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    /**storekeeper_poi**/
    STOREKEEPS_COUNTER(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    /**gardener_poi**/
    GARDENER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),

    BARREL_PLANTER(new Block(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    RAIN_COLLECTOR(new RainCollectorBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(1.8f).nonOpaque()), itemSettings()),
    LEVELED_RAIN_COLLECTOR(new LeveledRainCollectorBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(1.8f).nonOpaque())),
    //WATER_SHOWERER(new ShowerBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).strength(1.8f).nonOpaque().ticksRandomly()), itemSettings()),
    SPRINKLER(new SprinklerBlock(), itemSettings()),
    WATER_STRAINER(new WaterStrainerBlock(), itemSettings()),
    WITCH_LADLE(new LadleBlock(Block.Settings.copy(Blocks.OAK_PLANKS).breakInstantly().noCollision().nonOpaque()), itemSettings()),

    COUNTER_DRAWER(new CounterDrawerBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    COUNTER(new CounterBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    COUNTER_CORNER(new CounterCornerBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),

    CABINET(new CabinetBlock(Block.Settings.copy(Blocks.BARREL).nonOpaque()), itemSettings()),
    EMPTY_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    ANTHRO_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    BEEKEEPING_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    CARTOGRAPHY_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    POTION_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    SCROLL_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    TOOL_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    ORNATE_OBSIDIAN_TABLE(new OrnateTableBlock(Block.Settings.copy(Blocks.ENCHANTING_TABLE)), itemSettings()),
    CLOTHED_ORNATE_OBSIDIAN_TABLE(new OrnateTableBlock(Block.Settings.copy(Blocks.ENCHANTING_TABLE)), itemSettings()),
    LOG_PILE(new LogPile(Block.Settings.of(Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD).nonOpaque()), itemSettings()),

    BOOK_STACK_0(new BookStackBlock(BLOCK_SHAPE_0), itemSettings()),
    BOOK_STACK_1(new BookStackBlock(BLOCK_SHAPE_1), itemSettings()),
    BOOK_STACK_2(new BookStackBlock(BLOCK_SHAPE_2), itemSettings()),
    BOOK_STACK_3(new BookStackBlock(BLOCK_SHAPE_3), itemSettings()),
    BOOK_STACK_4(new BookStackBlock(BLOCK_SHAPE_4), itemSettings()),
    BOOK_STACK_5(new BookStackBlock(BLOCK_SHAPE_5), itemSettings()),
    BOOK_STACK_6(new BookStackBlock(BLOCK_SHAPE_6), itemSettings()),
    BOOK_STACK_7(new BookStackBlock(BLOCK_SHAPE_7), itemSettings()),
    BOOK_STACK_8(new BookStackBlock(BLOCK_SHAPE_8), itemSettings()),
    //INK_WELL(new InkWellBlock(), itemSettings()),
    PET_WATER_BOWL(new PetWaterBowlBlock(Block.Settings.copy(Blocks.TERRACOTTA).nonOpaque().breakInstantly()), itemSettings()),
    EMPTY_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    WATER_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    GLOW_BERRY_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    MILK_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    HONEY_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    INK_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),
    EXP_BOTTLE_BLOCK(new BottleBlock(), itemSettings()),

    WATTLE_STOOL(new StoolBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_CHAIR(new ChairBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE_CLOTHE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),

    BLACK_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    BLUE_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    BROWN_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    CYAN_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    GRAY_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    GREEN_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    LIGHT_BLUE_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    LIGHT_GRAY_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    LIME_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    MAGENTA_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    ORANGE_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    PURPLE_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    PINK_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    YELLOW_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WHITE_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    RED_CUSHION(new CushionBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),

    DIRT_ROAD(new Block(Block.Settings.copy(Blocks.COARSE_DIRT)), itemSettings()),

    CANVAS_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CANVAS_STAIRS(new StairsBlock(CANVAS_BLOCK.getState(), Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CANVAS_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_BLOCK)), itemSettings()),

    CANVAS_CARPET(new CarpetBlock(Block.Settings.copy(net.minecraft.block.Blocks.BROWN_CARPET).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    LEATHER_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).strength(0.8f)), itemSettings()),
    LEATHER_CARPET(new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).strength(0.8f)), itemSettings()),
    TREATED_LEATHER_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).strength(0.8f)), itemSettings()),
    TREATED_LEATHER_CARPET(new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).strength(0.8f)), itemSettings()),
    MEMBRANE_BLOCK(new MembraneBlock(Block.Settings.copy(Blocks.GLASS).sounds(net.minecraft.sound.BlockSoundGroup.WOOL).strength(0.8f).breakInstantly()), itemSettings()),

    CURTAIN(new CurtainBlock(), itemSettings()),
    FIREGUARD(new FireGuardBlock(AbstractBlock.Settings.of(Material.METAL).sounds(BlockSoundGroup.CHAIN).nonOpaque()), itemSettings()),

    BRAZIER(new BrazierBlock(15, 2), itemSettings()),
    SOUL_BRAZIER(new BrazierBlock(10, 2), itemSettings()),
    IRON_BRAZIER(new IronBrazierBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4f, 5f).luminance(lightFromLit(15)).nonOpaque().ticksRandomly()), itemSettings()),

    CANDLE_BOTTLE(new CandleBottleBlock(), itemSettings()),
    
    GLOW_SPLATTER(new GlowSplatterBlock()),

    //rope and net blocks
    ROPE_VERTICAL(new RopeVerticalBlock(Block.Settings.of(BlockMats.ROPE).nonOpaque().noCollision().sounds(BlockSoundGroup.WOOL))),
    ROPE_HORIZONTAL(new RopeHorizontalBlock(Block.Settings.of(BlockMats.ROPE).nonOpaque().sounds(BlockSoundGroup.WOOL))),
    ROPE_LADDER(new ModLadderBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),
    BAMBOO_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(1).sounds(BlockSoundGroup.BAMBOO)), itemSettings()),

    NET(new NetBlock(), itemSettings()),
    //NET_BLOCK(new GrateBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),

    ROPE_BRIDGE_ANCHOR(new RopeBridgeBlock(Block.Settings.of(Material.WOOD).nonOpaque().sounds(BlockSoundGroup.WOOD).strength(1).noCollision()), itemSettings(), BridgeItem::new),
    ROPE_BRIDGE(new RopeBridgeBlock(Block.Settings.of(Material.WOOD).nonOpaque().sounds(BlockSoundGroup.WOOD).strength(1)), itemSettings(), BridgeItem::new),
    SPIKE_TRAP(new SpikeTrapBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque().strength(0.5f, 1.0f)), itemSettings()),
    SPIKE_TRAP_EXTENSION(new SpikeTrapExtensionBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque().strength(0.5f, 1.0f)), itemSettings()),
    //FIRE_TRAP(new FireTrapBlock(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),

    NAUTILUS_SHELL_BLOCK(new NautilusShellBlock(), itemSettings()),

    //guidestones
    GUIDESTONE_BLANK(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    GUIDESTONE_BACK(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_FORWARD(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_HERE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_LEFT(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_RIGHT(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    GUIDESTONE_CAMPSITE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_DUNGEON(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_HOMESTEAD(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_PORT(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_PORTAL(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_STABLES(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOWER(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TRADE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_VILLAGE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    GUIDESTONE_TOOL_AXE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_BOW(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_FISHING_ROD(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_HOE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_PICKAXE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_POTION(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_SHOVEL(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_TOOL_SWORD(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    GUIDESTONE_SYMBOL_DEATH(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_SYMBOL_HEART(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),
    GUIDESTONE_SYMBOL_HUNGER(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).strength(1, 5).nonOpaque()), itemSettings()),

    //wattle and daub
    BLOCK_DAUB(new Block(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    DAUB_STAIRS(new StairsBlock(BLOCK_DAUB.getState(), Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    DAUB_SLAB(new SlabBlock(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    DAUB_WALL(new WallBlock(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    
    BLOCK_WATTLE_AND_DAUB(new Block(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    BLOCK_WATTLE_AND_DAUB_CROSS(new Block(Block.Settings.copy(net.minecraft.block.Blocks.TUFF)), itemSettings()),
    BLOCK_WATTLE_AND_DAUB_PLUS(new Block(Block.Settings.copy(net.minecraft.block.Blocks.TUFF)), itemSettings()),

    BLOCK_WATTLE_AND_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()), // block_wattle_and_glass
    BLOCK_WATTLE_AND_GLASS_CROSS(new GlassBlock(Block.Settings.copy(net.minecraft.block.Blocks.GLASS)), itemSettings()), // block_wattle_and_glass_cross
    BLOCK_WATTLE_AND_GLASS_PLUS(new GlassBlock(Block.Settings.copy(net.minecraft.block.Blocks.GLASS)), itemSettings()), // block_wattle_and_glass_plus
    
    BLOCK_WATTLE_AND_GLASS_PANE(new PaneBlock(Block.Settings.copy(Blocks.GLASS_PANE)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_CROSS_PANE(new PaneBlock(Block.Settings.copy(net.minecraft.block.Blocks.GLASS_PANE)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_PLUS_PANE(new PaneBlock(Block.Settings.copy(net.minecraft.block.Blocks.GLASS_PANE)), itemSettings()),

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
    WARPED_LATTICE(new PaneBlock(Block.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()), itemSettings()),

    //thatch
    THATCH_BLOCK(new PillarBlock(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    THATCH_STAIRS(new StairsBlock(THATCH_BLOCK.getState(), Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    THATCH_SLAB(new SlabBlock(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),

    WEAVED_THATCH_BLOCK(new Block(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    WEAVED_THATCH_STAIRS(new StairsBlock(WEAVED_THATCH_BLOCK.getState(), Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    WEAVED_THATCH_SLAB(new SlabBlock(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),

    TIGHTLY_WEAVED_THATCH_BLOCK(new Block(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    TIGHTLY_WEAVED_THATCH_STAIRS(new StairsBlock(TIGHTLY_WEAVED_THATCH_BLOCK.getState(), Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),
    TIGHTLY_WEAVED_THATCH_SLAB(new SlabBlock(Block.Settings.copy(Blocks.HAY_BLOCK)), itemSettings()),

    GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR).hardness(0.3f).sounds(BlockSoundGroup.GLASS).nonOpaque()), itemSettings()),
    TINTED_GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR).hardness(0.3f).sounds(BlockSoundGroup.GLASS)), itemSettings()),

    REDSTONE_LANTERN(new RedstoneLanternBlock(), itemSettings()),
    GLOWSQUID_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 6)), itemSettings()),
    //BRIMSTONE_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //AMBER_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //DIAMOND_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //AMETHYST_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //GARNET_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //EMERALD_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    //QUARTZ_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),

    DEAD_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->0)), itemSettings()),
    BURNT_OUT_TORCH(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.WOOD)), itemSettings()),
    BURNT_OUT_CANDLE(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CANDLE)).shape(4, 12), itemSettings()),
    //ARROW_BLOCK(new ArrowBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BAMBOO).noCollision()), itemSettings()),

    GRAVE_MARKER(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    SHALE_GRAVESTONE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_SPIRIT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_HEART(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_ROSE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    SHALE_GRAVESTONE_TEXT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),

    //GRAVE_MARKER_PET(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings()),
    //SHALE_PET_GRAVESTONE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    //SHALE_PET_GRAVESTONE_SPIRIT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    //SHALE_PET_GRAVESTONE_HEART(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    //SHALE_PET_GRAVESTONE_ROSE(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    //SHALE_PET_GRAVESTONE_TEXT(new ShaleGraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.BASALT).resistance(666).hardness(2.25f).nonOpaque()), itemSettings()),
    
    // candelabras
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
    
    WASTEBIN(new OxidizableWastebinBlock(OxidationLevel.UNAFFECTED), itemSettings()),
    WASTEBIN_EXPOSED(new OxidizableWastebinBlock(OxidationLevel.EXPOSED), itemSettings()),
    WASTEBIN_WEATHERED(new OxidizableWastebinBlock(OxidationLevel.WEATHERED), itemSettings()),
    WASTEBIN_OXIDIZED(new OxidizableWastebinBlock(OxidationLevel.OXIDIZED), itemSettings()),
    
    WAXED_WASTEBIN(new WastebinBlock(), itemSettings()),
    WAXED_WASTEBIN_EXPOSED(new WastebinBlock(), itemSettings()),
    WAXED_WASTEBIN_WEATHERED(new WastebinBlock(), itemSettings()),
    WAXED_WASTEBIN_OXIDIZED(new WastebinBlock(), itemSettings()),

    //scarecrows
    SCARECROW(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_GLOWING(new ScarecrowBlock(true), itemSettings()),
    SCARECROW_TARGET(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_HAT(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_HAT_GLOWING(new ScarecrowBlock(true), itemSettings()),
    //TARGET_DUMMY(new ScarecrowBlock(false), itemSettings()),

    //redstonery
    //TARGET_BLOCK(new ModTargetBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    STAKE(new StakeBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).breakInstantly()), itemSettings()),
    //STAKE_BASE(new StakeBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).breakInstantly()), itemSettings()),
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
    POTTED_ANCIENT_FLOWER(new GlowingPotBlock(BlocksNatural.ANCIENT_FLOWER_BLOCK)),
    POTTED_BLACK_DAHLIA(new PotBlock(BlocksNatural.BLACK_DAHLIA)),
    POTTED_FLUFFY_DANDELION(new PotBlock(BlocksNatural.FLUFFY_DANDELION)),
    POTTED_FADED_SOUL_ROSE(new PotBlock(BlocksNatural.FADED_SOUL_ROSE)),
    POTTED_HONEYCLUSTER(new PotBlock(BlocksNatural.HONEYCLUSTER)),
    POTTED_LAVENDER(new PotBlock(BlocksNatural.LAVENDER)),
    POTTED_ORANGE_BEAUTY(new PotBlock(BlocksNatural.ORANGE_BEAUTY)),
    POTTED_POISON_BLOSSOM(new PotBlock(BlocksNatural.POISON_BLOSSOM)),
    POTTED_PURPLE_TULIP(new PotBlock(BlocksNatural.PURPLE_TULIP)),
    POTTED_YELLOW_TULIP(new PotBlock(BlocksNatural.YELLOW_TULIP)),
    POTTED_LIGHT_BLUE_TULIP(new PotBlock(BlocksNatural.LIGHT_BLUE_TULIP)),
    POTTED_BLACK_TULIP(new PotBlock(BlocksNatural.BLACK_TULIP)),
    POTTED_GODDESS_LILY(new PotBlock(BlocksNatural.GODDESS_LILY)),
    POTTED_RED_LUPINE(new PotBlock(BlocksNatural.RED_LUPINE)),
    POTTED_YELLOW_LUPINE(new PotBlock(BlocksNatural.YELLOW_LUPINE)),
    POTTED_PINK_LUPINE(new PotBlock(BlocksNatural.PINK_LUPINE)),
    POTTED_ORANGE_POPPY(new PotBlock(BlocksNatural.ORANGE_POPPY)),
    POTTED_YELLOW_POPPY(new PotBlock(BlocksNatural.YELLOW_POPPY)),
    POTTED_WHITE_POPPY(new PotBlock(BlocksNatural.WHITE_POPPY)),
    POTTED_SNOWFLOWER(new PotBlock(BlocksNatural.SNOWFLOWER)),

    // Potted mushrooms
    POTTED_GLOW_CAP(new PotBlock(BlocksNatural.GLOW_CAP)),
    POTTED_JUNGLE_CAP(new PotBlock(BlocksNatural.JUNGLE_CAP)),
    //POTTED_SOULSPORE(new PotBlock(ModNaturalBlocks.SOULSPORE_SINGLE)),
    POTTED_MOREL(new PotBlock(BlocksNatural.MOREL)),
    //POTTED_GOOP_CAP(new PotBlock(ModNaturalBlocks.GOOP_CAP)),

    // Potted saplings
    POTTED_MAMON_SAPLING(new PotBlock(BlocksNatural.MAMON_SAPLING)),
    POTTED_APPLE_SAPLING(new PotBlock(BlocksNatural.APPLE_SAPLING)),
    POTTED_WARM_BIRCH_SAPLING(new PotBlock(BlocksNatural.WARM_BIRCH_SAPLING)),

    // Other potted plants
    POTTED_FOXTAIL_FERN(new PotBlock(BlocksNatural.FOXTAIL_FERN)),
    POTTED_LEATHERLEAF_FERN(new PotBlock(BlocksNatural.LEATHERLEAF_FERN)),
    POTTED_MOSS_SPROUTLET(new PotBlock(BlocksNatural.MOSS_SPROUTLET)),
    //POTTED_ORANGE_FERN(new PotBlock(ModNaturalBlocks.ORANGE_FERN)),
    POTTED_SPROUT(new PotBlock(BlocksNatural.SPROUT)),
    POTTED_DESERT_SHRUB(new PotBlock(BlocksNatural.DESERT_SHRUB)),
    POTTED_LUSH_BUSH(new PotBlock(BlocksNatural.LUSH_BUSH)),

    // Potted plants that need custom models (due to not using the cross shape, or their texture being too big for the pot)
    POTTED_FLOWERING_CACTUS(new PotBlock(BlocksNatural.FLOWERING_CACTUS)),
    POTTED_JUNGLE_BUSH(new PotBlock(BlocksNatural.JUNGLE_BUSH)),
    POTTED_PANFLOWERS(new PotBlock(BlocksNatural.PANFLOWERS)),
    POTTED_FIREFERN(new PotBlock(BlocksNatural.FIREFERN)),
    POTTED_WEEPING_GHOST_WILLOW(new WillowPotBlock(BlocksNatural.WEEPING_GHOST_WILLOW)),
    //POTTED_FIDDLEHEAD_FERN(new PotBlock(ModNaturalBlocks.FIDDLEHEAD_FERN)),

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
    SALTPETER_BLOCK(new Block(Block.Settings.copy(Blocks.CALCITE).strength(4.1f, 5.0f)), itemSettings()),

    // refined blocks of "___"
    ROSEGOLD_BLOCK(new Block(Block.Settings.copy(Blocks.GOLD_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    SCULKERITE_BLOCK(new Block(Block.Settings.copy(Blocks.NETHERITE_BLOCK)), itemSettings()),

    PRIMSTEEL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_PLATE_STAIRS(new StairsBlock(PRIMSTEEL_PLATE_BLOCK.getState(), Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_PLATE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_PLATE(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_STAIRS(new StairsBlock(PRIMSTEEL_TILED_PLATE.getState(), Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_SLAB(new SlabBlock(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),

    PRIMSTEEL_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    PRIMSTEEL_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    PRIMSTEEL_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    PRIMSTEEL_BARS(new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS)), itemSettings()),
    PRIMSTEEL_DOOR(new DoorBlock(Block.Settings.copy(Blocks.IRON_DOOR)), itemSettings()),
    PRIMSTEEL_TRAPDOOR(new TrapdoorBlock(Block.Settings.copy(Blocks.IRON_TRAPDOOR)), itemSettings()),
    PRIMSTEEL_PRESSURE_PLATE(new PressurePlateBlock(ActivationRule.MOBS, Block.Settings.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)), itemSettings()),

    IRON_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_PLATE_STAIRS(new StairsBlock(IRON_PLATE_BLOCK.getState(), Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_PLATE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_CUT_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_CUT_STAIRS(new StairsBlock(IRON_CUT_BLOCK.getState(), Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    IRON_CUT_SLAB(new SlabBlock(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),

    IRON_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    IRON_LADDER(new ModLadderBlock(ModLadderBlock.settings().strength(3.0f).sounds(BlockSoundGroup.METAL)), itemSettings()),
    IRON_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    
    DEEPSLATE_PRESSURE_PLATE(new PressurePlateBlock(ActivationRule.MOBS, Block.Settings.copy(Blocks.STONE_PRESSURE_PLATE)), itemSettings()),
    SHALE_PRESSURE_PLATE(new PressurePlateBlock(ActivationRule.MOBS, Block.Settings.copy(Blocks.STONE_PRESSURE_PLATE).strength(0.2f)), itemSettings()),

    //erdstone
    ERDSTONE_STAIRS(new StairsBlock(BlocksNatural.ERDSTONE.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    ERDCOBBLESTONE_STAIRS(new StairsBlock(BlocksNatural.ERDCOBBLESTONE.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDCOBBLESTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDCOBBLESTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    POLISHED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    POLISHED_ERDSTONE_STAIRS(new StairsBlock(POLISHED_ERDSTONE.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    POLISHED_ERDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    POLISHED_ERDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    MOSSY_ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    MOSSY_ERDSTONE_BRICK_STAIRS(new StairsBlock(MOSSY_ERDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    MOSSY_ERDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    MOSSY_ERDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_BRICK_STAIRS(new StairsBlock(ERDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    ERDSTONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.QUARTZ_PILLAR).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings()),
    
    ERDSTONE_TILES(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_TILE_STAIRS(new StairsBlock(ERDSTONE_TILES.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    //ERDSTONE_TILE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    CHISELED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE_CRAFTABLE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    PATTERNED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    ERDSTONE_CAPPED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_SPIRIT(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_MOSAIC(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_MOSAIC_STAIRS(new StairsBlock(ERDSTONE_MOSAIC.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_MOSAIC_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),

    //adventurine
    ADVENTURINE_STAIRS(new StairsBlock(BlocksNatural.ADVENTURINE.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ADVENTURINE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ADVENTURINE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),

    POLISHED_ADVENTURINE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    POLISHED_ADVENTURINE_STAIRS(new StairsBlock(POLISHED_ADVENTURINE.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    POLISHED_ADVENTURINE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    POLISHED_ADVENTURINE_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),

    ADVENTURINE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ADVENTURINE_BRICK_STAIRS(new StairsBlock(ADVENTURINE_BRICKS.getState(), Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ADVENTURINE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),
    ADVENTURINE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(2).resistance(2500f).luminance(s ->5)), itemSettings()),

    //shale
    SHALE_STAIRS(new StairsBlock(BlocksNatural.SHALE.getState(), Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    COBBLED_SHALE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    COBBLED_SHALE_STAIRS(new StairsBlock(COBBLED_SHALE.getState(), Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    COBBLED_SHALE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    COBBLED_SHALE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    POLISHED_SHALE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    POLISHED_SHALE_STAIRS(new StairsBlock(POLISHED_SHALE.getState(), Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    POLISHED_SHALE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    POLISHED_SHALE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    SHALE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_BRICK_STAIRS(new StairsBlock(SHALE_BRICKS.getState(), Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),
    SHALE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    SHALE_RUNE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.BASALT).resistance(6).hardness(2.25f)), itemSettings()),

    //marble
    MARBLE_STAIRS(new StairsBlock(BlocksNatural.MARBLE.getState(), Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    MARBLE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    MARBLE_WALL(new WallBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),

    POLISHED_MARBLE(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    POLISHED_MARBLE_STAIRS(new StairsBlock(POLISHED_MARBLE.getState(), Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    POLISHED_MARBLE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    POLISHED_MARBLE_WALL(new WallBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),

    MARBLE_BRICKS(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_BRICK_STAIRS(new StairsBlock(POLISHED_MARBLE.getState(), Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    MARBLE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),
    MARBLE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.CALCITE)), itemSettings()),

    MARBLE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_CHISELED(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_CHISELED_FACE(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_PATTERNED(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),
    MARBLE_AIR(new Block(Block.Settings.copy(Blocks.CALCITE).sounds(BlockSoundGroup.CALCITE)), itemSettings()),

    //shiverstone
    SHIVERSTONE_STAIRS(new StairsBlock(BlocksNatural.SHIVERSTONE.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings()),
    SHIVERSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    SHIVERSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),

    SHIVERSTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_SMOOTH_STAIRS(new StairsBlock(SHIVERSTONE_SMOOTH.getState(), Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_SMOOTH_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_SMOOTH_WALL(new WallBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    SHIVERSTONE_TILES(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_TILE_STAIRS(new StairsBlock(SHIVERSTONE_TILES.getState(), Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_TILE_WALL(new WallBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    //serpentinite
    SERPENTINITE_STAIRS(new StairsBlock(BlocksNatural.SERPENTINITE.getState(), Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_WALL(new WallBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    SERPENTINITE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SMOOTH_STAIRS(new StairsBlock(SERPENTINITE_SMOOTH.getState(), Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SMOOTH_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SMOOTH_WALL(new WallBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    SERPENTINITE_BRICKS(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_BRICK_STAIRS(new StairsBlock(SERPENTINITE_BRICKS.getState(), Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    SERPENTINITE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    //SERPENTINITE_WINDOW(new GrateBlock(Block.Settings.copy(Blocks.SMOOTH_STONE).nonOpaque()), itemSettings()),
    //CHISELED_SERPENTINITE(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    CHISELED_SERPENTINITE_CRAFTABLE(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_WATER(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    // polished stones
    VERDANTINE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    DIABASE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    //LIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    GRIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    // carmine
    CARMINE_STAIRS(new StairsBlock(BlocksNatural.CARMINE.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),

    CARMINE_COBBLESTONE_STAIRS(new StairsBlock(BlocksNatural.CARMINE_COBBLESTONE.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_COBBLESTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    CARMINE_COBBLESTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),

    CARMINE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_SMOOTH_STAIRS(new StairsBlock(CARMINE_SMOOTH.getState(), Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_SLAB(new SlabBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_WALL(new WallBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),

    CARMINE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_BRICK_STAIRS(new StairsBlock(CARMINE_BRICKS.getState(), Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_BRICK_WALL(new WallBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),

    //ice and snows blocks
    PACKED_SNOW_STAIRS(new StairsBlock(BlocksNatural.PACKED_SNOW.getState(), Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_SLAB(new SlabBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_WALL(new WallBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),

    PACKED_SNOW_POLISHED(new Block(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_POLISHED_STAIRS(new StairsBlock(PACKED_SNOW_POLISHED.getState(), Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_POLISHED_SLAB(new SlabBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_POLISHED_WALL(new WallBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),

    PACKED_SNOW_BRICKS_LARGE(new Block(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_LARGE_STAIRS(new StairsBlock(PACKED_SNOW_BRICKS_LARGE.getState(), Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_LARGE_SLAB(new SlabBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_LARGE_WALL(new WallBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),

    PACKED_SNOW_BRICKS_SMALL(new Block(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_SMALL_STAIRS(new StairsBlock(PACKED_SNOW_BRICKS_SMALL.getState(), Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_SMALL_SLAB(new SlabBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),
    PACKED_SNOW_BRICKS_SMALL_WALL(new WallBlock(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),

    PACKED_SNOW_BRICKS_CHISELED(new Block(Block.Settings.copy(BlocksNatural.PACKED_SNOW.block)), itemSettings()),

    //andesite/diorite/granite
    ANDESITE_BRICKS(new Block(Block.Settings.copy(Blocks.ANDESITE)), itemSettings()),
    ANDESITE_BRICK_STAIRS(new StairsBlock(ANDESITE_BRICKS.getState(), Block.Settings.copy(Blocks.ANDESITE)), itemSettings()),
    ANDESITE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.ANDESITE)), itemSettings()),
    ANDESITE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.ANDESITE)), itemSettings()),

    DIORITE_BRICKS(new Block(Block.Settings.copy(Blocks.DIORITE)), itemSettings()),
    DIORITE_BRICK_STAIRS(new StairsBlock(DIORITE_BRICKS.getState(), Block.Settings.copy(Blocks.DIORITE)), itemSettings()),
    DIORITE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.DIORITE)), itemSettings()),
    DIORITE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.DIORITE)), itemSettings()),

    GRANITE_BRICKS(new Block(Block.Settings.copy(Blocks.GRANITE)), itemSettings()),
    GRANITE_BRICK_STAIRS(new StairsBlock(GRANITE_BRICKS.getState(), Block.Settings.copy(Blocks.GRANITE)), itemSettings()),
    GRANITE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.GRANITE)), itemSettings()),
    GRANITE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.GRANITE)), itemSettings()),

    //prismarine
    POLISHED_PRISMARINE(new Block(Block.Settings.copy(Blocks.PRISMARINE)), itemSettings()),
    POLISHED_PRISMARINE_STAIRS(new StairsBlock(POLISHED_PRISMARINE.getState(), Block.Settings.copy(POLISHED_PRISMARINE.block)), itemSettings()),
    POLISHED_PRISMARINE_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_PRISMARINE.block)), itemSettings()),
    POLISHED_PRISMARINE_WALL(new WallBlock(Block.Settings.copy(POLISHED_PRISMARINE.block)), itemSettings()),

    CHISELED_PRISMARINE(new Block(Block.Settings.copy(Blocks.PRISMARINE)), itemSettings()),

    //dripstone bricks
    POLISHED_DRIPSTONE(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    POLISHED_DRIPSTONE_STAIRS(new StairsBlock(POLISHED_DRIPSTONE.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    POLISHED_DRIPSTONE_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    POLISHED_DRIPSTONE_WALL(new WallBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_BRICK_STAIRS(new StairsBlock(DRIPSTONE_BRICKS.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    DRIPSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    DRIPSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    MOSSY_DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    MOSSY_DRIPSTONE_BRICK_STAIRS(new StairsBlock(MOSSY_DRIPSTONE_BRICKS.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    MOSSY_DRIPSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    MOSSY_DRIPSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    DRIPSTONE_TILES(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_TILE_STAIRS(new StairsBlock(DRIPSTONE_TILES.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    DRIPSTONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    DRIPSTONE_TILE_WALL(new WallBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    PATTERNED_DRIPSTONE(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    PATTERNED_DRIPSTONE_STAIRS(new StairsBlock(PATTERNED_DRIPSTONE.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    PATTERNED_DRIPSTONE_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    CHISELED_DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_EARTH(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),

    DRIPSTONE_MOSAIC(new PillarBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_MOSAIC_STAIRS(new StairsBlock(DRIPSTONE_MOSAIC.getState(), Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),
    DRIPSTONE_MOSAIC_SLAB(new SlabBlock(Block.Settings.copy(POLISHED_DRIPSTONE.block)), itemSettings()),

    DRIPSTONE_CAPPED(new PillarBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),

    //industrial basalt blocks
    //INDUSTRIAL_BRICKS(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),
    //INDUSTRIAL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),

    //salt
    POLISHED_SALT_BLOCK(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    POLISHED_SALT_BLOCK_STAIRS(new StairsBlock(POLISHED_SALT_BLOCK.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    POLISHED_SALT_BLOCK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    POLISHED_SALT_BLOCK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    SALT_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SALT_BRICK_STAIRS(new StairsBlock(SALT_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SALT_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SALT_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    CHISELED_SALT_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SALT_BRICKS_CAPPED(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    //basalt bricks
    POLISHED_BASALT(new Block(Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_STAIRS(new StairsBlock(POLISHED_BASALT.getState(), Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_WALL(new WallBlock(Block.Settings.copy(Blocks.BASALT)), itemSettings()),

    POLISHED_BASALT_BRICKS(new Block(Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_BRICK_STAIRS(new StairsBlock(POLISHED_BASALT_BRICKS.getState(), Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.BASALT)), itemSettings()),

    POLISHED_BASALT_PATTERNED(new Block(Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_PATTERNED_STAIRS(new StairsBlock(POLISHED_BASALT_PATTERNED.getState(), Block.Settings.copy(Blocks.BASALT)), itemSettings()),
    POLISHED_BASALT_PATTERNED_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BASALT)), itemSettings()),

    //sandstone
    ROUGH_SANDSTONE_STAIRS(new StairsBlock(BlocksNatural.ROUGH_SANDSTONE.getState(), Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),
    ROUGH_SANDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),
    ROUGH_SANDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),

    ROUGH_RED_SANDSTONE_STAIRS(new StairsBlock(BlocksNatural.ROUGH_RED_SANDSTONE.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    ROUGH_RED_SANDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    ROUGH_RED_SANDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    STRATIFIED_SANDSTONE_STAIRS(new StairsBlock(BlocksNatural.STRATIFIED_SANDSTONE.getState(), Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),
    STRATIFIED_SANDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),
    STRATIFIED_SANDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings()),

    STRATIFIED_RED_SANDSTONE_STAIRS(new StairsBlock(BlocksNatural.STRATIFIED_RED_SANDSTONE.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    STRATIFIED_RED_SANDSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    STRATIFIED_RED_SANDSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SANDSTONE_BRICK_STAIRS(new StairsBlock(SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    CRACKED_SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_SANDSTONE_BRICK_STAIRS(new StairsBlock(CRACKED_SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    MOSSY_SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_SANDSTONE_BRICK_STAIRS(new StairsBlock(MOSSY_SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    CHISELED_SANDSTONE_BLANK(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    //red sandstone
    RED_SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    RED_SANDSTONE_BRICK_STAIRS(new StairsBlock(RED_SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    RED_SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    RED_SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    CRACKED_RED_SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_RED_SANDSTONE_BRICK_STAIRS(new StairsBlock(CRACKED_RED_SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_RED_SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    CRACKED_RED_SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    MOSSY_RED_SANDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_RED_SANDSTONE_BRICK_STAIRS(new StairsBlock(MOSSY_RED_SANDSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_RED_SANDSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),
    MOSSY_RED_SANDSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    CHISELED_RED_SANDSTONE_BLANK(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE))),

    //scorchstone
    SCORCHSTONE_STAIRS(new StairsBlock(BlocksNatural.SCORCHSTONE.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    SCORCHSTONE_POLISHED(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_POLISHED_STAIRS(new StairsBlock(SCORCHSTONE_POLISHED.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_POLISHED_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_POLISHED_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    SCORCHSTONE_TILES(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_TILE_STAIRS(new StairsBlock(SCORCHSTONE_TILES.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_TILE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_BRICK_STAIRS(new StairsBlock(SCORCHSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    MOSSY_SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    MOSSY_SCORCHSTONE_BRICK_STAIRS(new StairsBlock(MOSSY_SCORCHSTONE_BRICKS.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    MOSSY_SCORCHSTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    MOSSY_SCORCHSTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    SCORCHSTONE_CHISELED_FACE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    //CHISELED_SCORCHSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_FIRE(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    //SCORCHSTONE_WINDOW(new GrateBlock(Block.Settings.copy(Blocks.STONE).nonOpaque()), itemSettings().fireproof()),
    SCORCHSTONE_MOSAIC(new PillarBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_MOSAIC_STAIRS(new StairsBlock(SCORCHSTONE_MOSAIC.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),
    SCORCHSTONE_MOSAIC_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof()),

    //volc
    VOLCANIC_STONE_STAIRS(new StairsBlock(VOLCANIC_STONE.getState(), Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    VOLCANIC_STONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.TUFF)), itemSettings()),
    VOLCANIC_STONE_WALL(new WallBlock(Block.Settings.copy(Blocks.TUFF)), itemSettings()),

    //mud bricks
    PACKED_MUD_STAIRS(new StairsBlock(Blocks.PACKED_MUD.getDefaultState(), Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),
    PACKED_MUD_SLAB(new SlabBlock(Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),
    PACKED_MUD_WALL(new WallBlock(Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),

    POLISHED_PACKED_MUD(new Block(Block.Settings.copy(Blocks.MUD_BRICKS)), itemSettings()),
    POLISHED_PACKED_MUD_STAIRS(new StairsBlock(POLISHED_PACKED_MUD.getState(), Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),
    POLISHED_PACKED_MUD_SLAB(new SlabBlock(Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),
    POLISHED_PACKED_MUD_WALL(new WallBlock(Block.Settings.copy(Blocks.PACKED_MUD)), itemSettings()),

    PACKED_MUD_CAPPED(new Block(Block.Settings.copy(Blocks.MUD_BRICKS)), itemSettings()),

    //red bricks
    SMOOTH_BRICK(new Block(Block.Settings.copy(Blocks.BRICKS)), itemSettings()),
    SMOOTH_BRICK_STAIRS(new StairsBlock(SMOOTH_BRICK.getState(), Block.Settings.copy(Blocks.BRICKS)), itemSettings()),
    SMOOTH_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BRICKS)), itemSettings()),
    SMOOTH_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.BRICKS)), itemSettings()),

    MOSAIC_BRICK(new Block(Block.Settings.copy(Blocks.BRICKS)), itemSettings()),
    MOSAIC_BRICK_STAIRS(new StairsBlock(MOSAIC_BRICK.getState(), Block.Settings.copy(Blocks.BRICKS)), itemSettings()),
    MOSAIC_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.BRICKS)), itemSettings()),

    MOSSY_STONE_STAIRS(new StairsBlock(BlocksNatural.MOSSY_STONE.getState(), Block.Settings.copy(Blocks.STONE)), itemSettings()),
    MOSSY_STONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    MOSSY_STONE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE)), itemSettings()),

    //cobblestone bricks
    //POLISHED_COBBLESTONE(new Block(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    COBBLESTONE_BRICK_STAIRS(new StairsBlock(COBBLESTONE_BRICKS.getState(), Block.Settings.copy(Blocks.COBBLESTONE)), itemSettings()),
    COBBLESTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.COBBLESTONE_SLAB)), itemSettings()),
    COBBLESTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.COBBLESTONE_WALL)), itemSettings()),

    MOSSY_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.MOSSY_COBBLESTONE)), itemSettings()),
    MOSSY_COBBLESTONE_BRICK_STAIRS(new StairsBlock(MOSSY_COBBLESTONE_BRICKS.getState(), Block.Settings.copy(Blocks.MOSSY_COBBLESTONE_STAIRS)), itemSettings()),
    MOSSY_COBBLESTONE_BRICK_SLAB(new SlabBlock(Block.Settings.copy(Blocks.MOSSY_COBBLESTONE_SLAB)), itemSettings()),
    MOSSY_COBBLESTONE_BRICK_WALL(new WallBlock(Block.Settings.copy(Blocks.MOSSY_COBBLESTONE_WALL)), itemSettings()),

    //ARID_MOSSY_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    CHISELED_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    //stone bricks
    STONE_TILES(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    STONE_TILE_STAIRS(new StairsBlock(STONE_TILES.getState(), Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    STONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    STONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    STONE_CAPPED(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    //deepslate blocks
    DEEPSLATE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.DEEPSLATE)), itemSettings()),

    //??? other misc stone blocks ig
    POLISHED_STONE(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    POLISHED_STONE_STAIRS(new StairsBlock(POLISHED_STONE.getState(), Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    POLISHED_STONE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    POLISHED_STONE_WALL(new WallBlock(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    SMOOTH_STONE_TILES(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SMOOTH_STONE_TILE_STAIRS(new StairsBlock(SMOOTH_STONE_TILES.getState(), Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    SMOOTH_STONE_TILE_SLAB(new SlabBlock(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    SMOOTH_STONE_CAPPED(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    //INDUSTRIAL_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SMOOTH_BASALT).nonOpaque()), itemSettings()),
    COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    COBBLESTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    STONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.BRICKS).nonOpaque()), itemSettings()),
    MUD_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.MUD_BRICKS).nonOpaque()), itemSettings()),
    ERDCOBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(BlocksNatural.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    ERDSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(BlocksNatural.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    DAUB_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SANDSTONE).nonOpaque()), itemSettings()),
    SANDSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    RED_SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_SANDSTONE).nonOpaque()), itemSettings()),
    RED_SANDSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    SCORCHSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    SALT_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    CARMINE_COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    CARMINE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    SERPENTINITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    ANDESITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.ANDESITE).nonOpaque()), itemSettings()),
    GRANITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.GRANITE).nonOpaque()), itemSettings()),
    DIORITE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DIORITE).nonOpaque()), itemSettings()),
    DRIPSTONE_TILE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
    DRIPSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
    BASALT_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    MARBLE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    SHALE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE).nonOpaque()), itemSettings()),
    ADVENTURINE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    DEEPSLATE_TILE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DEEPSLATE).nonOpaque()), itemSettings()),
    DEEPSLATE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DEEPSLATE).nonOpaque()), itemSettings()),
    NETHER_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.NETHER_BRICKS).nonOpaque()), itemSettings()),
    RED_NETHER_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_NETHER_BRICKS).nonOpaque()), itemSettings()),
    END_STONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_NETHER_BRICKS).nonOpaque()), itemSettings()),
    PURPUR_BLOCK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_NETHER_BRICKS).nonOpaque()), itemSettings()),
    // leathers are last

    //TANNED_LEATHER_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //BLACK_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLACK).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //BLUE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //BROWN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.BROWN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //CYAN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.CYAN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //GREEN_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //GREY_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //LIGHT_BLUE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_BLUE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //LIGHT_GREY_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIGHT_GRAY).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //LIME_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.LIME).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //MAGENTA_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.MAGENTA).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //ORANGE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.ORANGE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //PINK_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PINK).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //PURPLE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.PURPLE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //RED_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.RED).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //WHITE_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.WHITE).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),
    //YELLOW_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings()),

    /**artifact blocks go here**/
    //TRANSLATION_CANVAS(new TranslationCanvasBlock(Block.Settings.copy(Blocks.OAK_PLANKS).breakInstantly().sounds(BlockSoundGroup.CANDLE).nonOpaque()), itemSettings().group(BOOKS)),

    // clay pots go here (not the baking item one)
    ROUNDED_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSounds.POT.sound).breakInstantly()), itemSettings().group(NON_NATURAL_BLOCKS)),
    ROUNDED_BLUE_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSounds.POT.sound).breakInstantly()), itemSettings().group(NON_NATURAL_BLOCKS)),

    BROWN_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSounds.POT.sound).breakInstantly()), itemSettings().group(NON_NATURAL_BLOCKS)),
    BLUE_CLAY_POT(new ClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSounds.POT.sound).nonOpaque().breakInstantly()), itemSettings().group(NON_NATURAL_BLOCKS)),
    GREEN_CLAY_POT(new ExplosiveClayPotBlock(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSounds.POT.sound).nonOpaque().breakInstantly()), itemSettings().group(NON_NATURAL_BLOCKS)),
    //PURPLE_CLAY_POT(new SoulClayPot(Block.Settings.of(BlockMats.POT).strength(0.3f).sounds(BlockSoundGroup.POT.sound).nonOpaque().breakInstantly(), UniformIntProvider.create(2, 6)), itemSettings().group(NON_NATURAL_BLOCKS)),

    DEEPSLATE_URN_PLAIN(new UrnBlock(BlockSettings.urn()), itemSettings().group(NON_NATURAL_BLOCKS)),
    DEEPSLATE_URN_ANGRY(new ExplosiveUrnBlock(BlockSettings.urn()), itemSettings().group(NON_NATURAL_BLOCKS)),
    //DEEPSLATE_URN_CREEPER(new ExplosiveUrnBlock(BlockSettings.urn()), itemSettings().group(BOOKS)),
    //DEEPSLATE_URN_EARTH(new UrnBlock(BlockSettings.urn()), itemSettings().group(BOOKS)),
    //DEEPSLATE_URN_ERDIS(new UrnBlock(BlockSettings.urn()), itemSettings().group(BOOKS)),
    DEEPSLATE_URN_SOUL(new UrnBlock(BlockSettings.urn(), UniformIntProvider.create(2, 6)), itemSettings().group(NON_NATURAL_BLOCKS)),
    //DEEPSLATE_URN_SYMBOL(new UrnBlock(BlockSettings.urn()), itemSettings().group(BOOKS)),
    
    //cobblestone statues
    //OCELOT_STATUE(new AnimalStatueBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque().resistance(2500)), itemSettings().maxCount(1).group(BOOKS)),

    //villager and illager blocks go here
    //CAMPFIRE_POT(new CampfirePotBlock(Block.Settings.copy(Blocks.CAULDRON).ticksRandomly().luminance(s -> 16).nonOpaque()), itemSettings().group(BOOKS)),
    //ANCIENT_WAGON_WHEEL(new WagonWheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    //ANCIENT_WAGON_WHEEL_PLATFORM(new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    //ANCIENT_WAGON_WHEEL_TABLE(new WagonWheelTableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),

    //lodged and rusty blocks go here
    //GODDESS_BLADE_BLOCK(new SwordBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.EPIC).group(BOOKS)),
    SWORD_BLOCK(new SwordBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(NON_NATURAL_BLOCKS)),
    SHOVEL_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(NON_NATURAL_BLOCKS)),
    PICKAXE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(NON_NATURAL_BLOCKS)),
    AXE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(NON_NATURAL_BLOCKS)),
    HOE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().rarity(Rarity.UNCOMMON).group(NON_NATURAL_BLOCKS)),

    //RUSTED_CHEST(new RustedChestBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    //CHAINED_RUSTED_CHEST(new RustedChestBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    //BONFIRE(new ModCampfireBlock(true, 1, Block.Settings.copy(Blocks.CAMPFIRE)), itemSettings().rarity(Rarity.RARE)),

    //rare sandstone temple blocks go here
    //CHISELED_SANDSTONE_PORTAL_COMING(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_SANDSTONE_PORTAL_LEAVING(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_SANDSTONE_ENDERMAN(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_SANDSTONE_REST(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_SANDSTONE_TEMPLE(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),

    //CHISELED_RED_SANDSTONE_PIGLIN(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_RED_SANDSTONE_PORTAL_COMING(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //CHISELED_RED_SANDSTONE_PORTAL_LEAVING(new Block(Block.Settings.copy(Blocks.RED_SANDSTONE)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),

    //SCORCHSTONE_CHISELED_FACE_PIGLIN(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings().fireproof().rarity(Rarity.UNCOMMON).group(BOOKS)),

    //CHISELED_ERDSTONE_BRICK_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    //CHISELED_ERDSTONE_BRICK_FACE_HAPPY(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    //MOSSY_PATTERNED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //PRIMSTEEL_WINDOW(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON).group(BOOKS)),
    //ERDSTONE_TARGET_BLOCK(new TargetBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1).luminance(s ->10)), itemSettings().group(BOOKS)),
    //ERDSTONE_DISPENSER(new DispenserBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS)),
    //ERDSTONE_SPIRIT_LIT(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).luminance(s ->16)), itemSettings().group(BOOKS)),
    //ERDSTONE_LANTERN(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).luminance(s ->10)), itemSettings().group(BOOKS)),

    //last block on the artifacts tab
    DEFECTIVE_SPAWNER(new DefectiveBlock(Block.Settings.copy(Blocks.SPAWNER)), itemSettings().group(NON_NATURAL_BLOCKS).maxCount(64).rarity(Rarity.RARE).fireproof());

    public static void initialize() {
        
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(NON_NATURAL_BLOCKS);
    }

    private static FabricItemSettings toolItemSettings() {
        return new FabricItemSettings().group(VC_TOOLS);
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
    
    /** create light level from lit blockstate */
    private static ToIntFunction<BlockState> lightFromLit(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }
    
    // ### The Enum Class Itself ###
    
    public final Block block;
    
    @Nullable
    public final Item item;
    
    public final Identifier id;
    
    /** Register the block without the item. */
    BlocksModded(Block block) {
        this.block = block;
        this.item = null;
        Registry.register(Registry.BLOCK, id = id(), block);
    }
    
    /** Register the block with the item. */
    BlocksModded(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    BlocksModded(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
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
