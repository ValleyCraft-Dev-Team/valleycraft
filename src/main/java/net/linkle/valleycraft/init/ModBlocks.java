package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.util.BlockConvertible;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

import static net.linkle.valleycraft.Main.makeId;
import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.NON_NATURAL_BLOCKS;

import java.util.function.BiFunction;

import org.jetbrains.annotations.Nullable;

public enum ModBlocks implements ItemConvertible, BlockConvertible {
    
    // furniture
    STABLEHAND_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    STABLEHAND_COUNTER(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    KEG(new KegBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings()),

    LUMBERJACK_STATION(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings()),
    STOVE(new StoveBlock(Block.Settings.copy(Blocks.SMOKER)), itemSettings()),
    CAMPFIRE_POT(new CampfirePotBlock(Block.Settings.copy(Blocks.CAULDRON).luminance(s -> 13).nonOpaque()), itemSettings()),
    LOG_PILE(new SlabBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque()), itemSettings()),
    CRATE(new CrateBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    EMPTY_BOOKSHELF(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    POTION_BOOKSHELF(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    ANTHRO_BOOKSHELF(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    WATTLE_STOOL(new StoolBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_CHAIR(new ChairBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE_CLOTHE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    
    ANCIENT_WAGON_WHEEL(new WagonWheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_PLATFORM(new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_TABLE(new WagonWheelTableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    
    CANVAS_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CANVAS_CARPET(new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CURTAIN(new CurtainBlock(), itemSettings()),
    
    // guidestones
    GUIDESTONE(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(1).nonOpaque()), itemSettings()),
    GUIDESTONE_ARROW(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(1).nonOpaque()), itemSettings()),
    GUIDESTONE_HOME(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(1).nonOpaque()), itemSettings()),
    GUIDESTONE_INTEREST(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(1).nonOpaque()), itemSettings()),
    GUIDESTONE_DANGER(new GuidestoneBlock(Block.Settings.copy(Blocks.STONE).hardness(1).nonOpaque()), itemSettings()),
    
    // odd blocks go here
    SWORD_BLOCK(new SwordBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PICKAXE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    
    ARROW_BLOCK(new ArrowBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BAMBOO).noCollision()), itemSettings()),
    BURNT_OUT_TORCH(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.WOOD)), itemSettings().group(BOOKS)),
    BURNT_OUT_CANDLE(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CANDLE)).shape(4, 12), itemSettings().group(BOOKS)),
    SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    SKELETAL_MINING_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    RUSTED_CHEST(new RustedChestBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    
    GLOWSQUID_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 6)), itemSettings()),
    VEX_LANTERN(new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),
    DEFECTIVE_SPAWNER(new DefectiveBlock(Block.Settings.copy(Blocks.SPAWNER)), itemSettings().rarity(Rarity.RARE).maxCount(64).group(BOOKS).fireproof()),
    DEAD_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->0)), itemSettings().group(BOOKS)),
    
    GRAVE_MARKER(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    GRAVE_MARKER_PET(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.EPIC)),
    ERD_STONE_GRAVESTONE(new GraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    ERD_STONE_GRAVESTONE_PET(new GraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.EPIC)),
    
    // clay pots go here (not the baking item one)
    BROWN_CLAY_POT(new ClayPotBlock(Block.Settings.copy(Blocks.GLASS).breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    BLUE_CLAY_POT(new ClayPotBlock(Block.Settings.copy(Blocks.GLASS).breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    
    // redstonery
    STAKE(new StakeBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).breakInstantly()), itemSettings()),
    LANTERN_HANGER(new LanternHangerBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD)), itemSettings()),
    SPRINKLER(new SprinklerBlock(), itemSettings()),
    
    // misc decor?
    OPTIC_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    
    // wood types
    // wattle and daub
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
    
    // carved
    GHOST_PUMPKIN_CARVED(new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().allowsSpawning(ModBlocks::always)), itemSettings().equipmentSlot(i-> EquipmentSlot.HEAD)),
    GHOST_JACK_O_LANTERN(new ModCarvedPumpkinBlock(GhostPumpkinBlock.settings().luminance(15).allowsSpawning(ModBlocks::always)), itemSettings()),
    
    // bales
    GLOW_KELP_BLOCK(new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TEAL).luminance(s->10)), itemSettings()),
    ORANGE_KELP_BLOCK(new Block(Block.Settings.copy(Blocks.DRIED_KELP_BLOCK).mapColor(MapColor.TERRACOTTA_GRAY)), itemSettings()),
    FIBER_BALE(new HayBlock(Block.Settings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN)), itemSettings()),
    ROTTEN_FLESH_BLOCK(new Block(Block.Settings.copy(Blocks.NETHER_WART_BLOCK).mapColor(MapColor.TERRACOTTA_RED)), itemSettings()),
    
    // Separator of raw blocks and bales
    SALT_BLOCK(new Block(Block.Settings.copy(Blocks.SANDSTONE)), itemSettings()),

    // raw blocks of "_____"
    RAW_GOLEMITE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    RAW_PRIMSTEEL_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    CHARCOAL_BLOCK(new Block(Block.Settings.copy(Blocks.COAL_BLOCK)), itemSettings()),
    
    // not strictly either
    ANTHRACITE_BLOCK(new Block(Block.Settings.copy(Blocks.COAL_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    AMBER_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    
    // refined blocks of "___"
    ROSEGOLD_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),
    PRIMSTEEL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_PLATE(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    IRON_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    GOLEMITE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    GOLEMITE_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    GOLEMITE_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    GOLEMITE_LADDER(new LadderBlock(Block.Settings.of(Material.DECORATION).requiresTool().strength(3.0f).sounds(BlockSoundGroup.METAL).nonOpaque()), itemSettings()),
    GOLEMITE_BARS(new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS)), itemSettings()),
    
    // erdstone
    POLISHED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    MOSSY_ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ARID_MOSSY_ERDSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    
    ERDSTONE_PILLAR(new PillarBlock(Block.Settings.copy(Blocks.QUARTZ_PILLAR).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings()),
    
    ERDSTONE_TILES(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    CHISELED_ERDSTONE_BRICK_FACE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    ERDSTONE_WINDOW(new GlassBlock(Block.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.DEEPSLATE).hardness(1).nonOpaque()), itemSettings().group(BOOKS)),
    PATTERNED_ERDSTONE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1)), itemSettings()),
    ERDSTONE_TARGET_BLOCK(new TargetBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    ERDSTONE_DISPENSER(new DispenserBlock(Block.Settings.copy(Blocks.DEEPSLATE).sounds(BlockSoundGroup.DEEPSLATE).hardness(1)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    
    // adventurine
    POLISHED_ADVENTURINE(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(25).resistance(2500f).luminance(s ->5)), itemSettings()),
    
    // adventurine infused erdstone
    ERDSTONE_PILLAR_POWERED(new PillarBlock(Block.Settings.copy(Blocks.QUARTZ_PILLAR).sounds(BlockSoundGroup.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    ERDSTONE_TILES_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    CHISELED_ERDSTONE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    CHISELED_ERDSTONE_FACE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    CHISELED_ERDSTONE_BRICK_FACE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    ERDSTONE_WINDOW_POWERED(new GlassBlock(Block.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.DEEPSLATE).hardness(50).resistance(2500f).nonOpaque().luminance(s ->3)), itemSettings().group(BOOKS)),
    PATTERNED_ERDSTONE_POWERED(new Block(Block.Settings.copy(Blocks.DEEPSLATE).hardness(50).resistance(2500f).luminance(s ->3)), itemSettings()),
    
    // stones
    // polished stones
    PUMICE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VERDANTINE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    GRIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    DIABASE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    LIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),

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
    YELLOW_LEATHER_BLOCK(new Block(Block.Settings.of(Material.SOLID_ORGANIC, MapColor.YELLOW).strength(0.8f).sounds(BlockSoundGroup.WOOL)), itemSettings());

    public static void initialize() {
        
    }

    private static FabricItemSettings itemSettings() {
        return new FabricItemSettings().group(NON_NATURAL_BLOCKS);
    }

    private static Boolean always(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return true;
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Block block;
    
    @Nullable
    public final Item item;
    
    /** Register the block without the item. */
    ModBlocks(Block block) {
        this.block = block;
        this.item = null;
        Reg.register(id(), block);
    }
    
    /** Register the block without the item. */
    ModBlocks(Block block, Item.Settings settings) {
        this(block, settings, BlockItem::new);
    }

    /** Register the block with the item.
     * @param function create and register the block item. Example: BlockItem::new  */
    ModBlocks(Block block, Item.Settings settings, BiFunction<Block, Item.Settings, Item> function) {
        this.block = block;
        var id = makeId(id());
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, item = function.apply(block, settings));
    }
    
    private String id() {
        return name().toLowerCase();
    }
    
    /** Get default state */
    public BlockState getState() {
        return block.getDefaultState();
    }

    @Override
    public Item asItem() {
        return item;
    }

    @Override
    public Block asBlock() {
        return block;
    }
}
