package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.NON_NATURAL_BLOCKS;

import java.util.function.BiFunction;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.*;
import net.linkle.valleycraft.util.BlockEnum;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public enum ModBlocks implements ItemEnum, BlockEnum {
    
    // furniture
    WAYPOINT(new WaypointBlock(Block.Settings.copy(Blocks.POLISHED_DEEPSLATE)), itemSettings()),

    STABLEHAND_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    STABLEHAND_COUNTER(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    KEG(new KegBlock(), itemSettings()),
    MINER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    BEEKEEPER_STATION(new HorizontalBlock(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),
    LUMBERJACK_STATION(new LumberjackBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().sounds(BlockSoundGroup.CHAIN)), itemSettings()),
    STOVE(new StoveBlock(Block.Settings.copy(Blocks.SMOKER)), itemSettings()),
    CAMPFIRE_POT(new CampfirePotBlock(Block.Settings.copy(Blocks.CAULDRON).ticksRandomly().luminance(s -> 13).nonOpaque()), itemSettings()),
    LOG_PILE(new SlabBlock(Block.Settings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).nonOpaque()), itemSettings()),
    CRATE(new CrateBlock(Block.Settings.copy(Blocks.BARREL)), itemSettings()),
    EMPTY_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    POTION_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    ANTHRO_BOOKSHELF(new Block(Block.Settings.copy(Blocks.BOOKSHELF)), itemSettings()),
    WATTLE_STOOL(new StoolBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_CHAIR(new ChairBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    WATTLE_TABLE_CLOTHE(new TableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    
    ANCIENT_WAGON_WHEEL(new WagonWheelBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_PLATFORM(new WagonWheelPlatformBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),
    ANCIENT_WAGON_WHEEL_TABLE(new WagonWheelTableBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings().group(BOOKS)),

    DIRT_ROAD(new FallingBlock(Block.Settings.copy(Blocks.DIRT)), itemSettings()),

    CANVAS_BLOCK(new Block(Block.Settings.copy(Blocks.BROWN_WOOL).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CANVAS_CARPET(new CarpetBlock(Block.Settings.copy(Blocks.BROWN_CARPET).sounds(BlockSoundGroup.MOSS_CARPET)), itemSettings()),
    CURTAIN(new CurtainBlock(), itemSettings()),
    ROPE(new ChainBlock(Block.Settings.copy(Blocks.BROWN_WOOL).nonOpaque()), itemSettings()),
    NET(new NetBlock(), itemSettings()),
    ROPE_BRIDGE_ANCHOR(new RopeBridgeBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().noCollision()), itemSettings()),
    ROPE_BRIDGE(new RopeBridgeBlock(Block.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()), itemSettings()),
    BAMBOO_LADDER(new LadderBlock(Block.Settings.copy(Blocks.BAMBOO).strength(1.0f).sounds(BlockSoundGroup.BAMBOO).nonOpaque()), itemSettings()),

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

    BLOCK_WATTLE_AND_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_CROSS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    BLOCK_WATTLE_AND_GLASS_PLUS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),

    WATTLE_DOOR(new DoorBlock(Block.Settings.copy(Blocks.OAK_DOOR)), itemSettings()),
    WATTLE_TRAPDOOR(new TrapdoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR)), itemSettings()),

    GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.GLASS).sounds(BlockSoundGroup.GLASS).nonOpaque()), itemSettings()),
    TINTED_GLASS_DOOR(new DoorBlock(Block.Settings.copy(Blocks.TINTED_GLASS).nonOpaque()), itemSettings()),

    // odd blocks go here
    SWORD_BLOCK(new SwordBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PICKAXE_BLOCK(new PickaxeBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CHAIN)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    
    ARROW_BLOCK(new ArrowBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BAMBOO).noCollision()), itemSettings()),
    BURNT_OUT_TORCH(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.WOOD)), itemSettings().group(BOOKS)),
    BURNT_OUT_CANDLE(new BurntTorchBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.CANDLE)).shape(4, 12), itemSettings().group(BOOKS)),
    SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    VILLAGER_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    MOBLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    PIGLIN_SKELETAL_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),
    DAERDRI_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    GEITLIN_SKULL(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.EPIC)),
    SKELETAL_MINING_REMAINS(new SkeletalRemainsBlock(Block.Settings.of(Material.DECORATION).nonOpaque().breakInstantly().sounds(BlockSoundGroup.BONE)), itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON)),

    RUSTED_CHEST(new RustedChestBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    TRANSLATION_CANVAS(new SpecialPaintingBlock(Block.Settings.copy(Blocks.OAK_WOOD).breakInstantly().sounds(BlockSoundGroup.CANDLE).nonOpaque()), itemSettings().group(BOOKS)),

    GLOWSQUID_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 6)), itemSettings()),
    BRIMSTONE_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(state -> 16)), itemSettings()),
    ALLAY_LANTERN(new AllayLanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->3)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),
    VEX_LANTERN(new WispLanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->3)), itemSettings().rarity(Rarity.RARE).maxCount(1).group(BOOKS).fireproof()),
    DEAD_LANTERN(new LanternBlock(Block.Settings.copy(Blocks.LANTERN).luminance(s->0)), itemSettings().group(BOOKS)),
    DEFECTIVE_SPAWNER(new DefectiveBlock(Block.Settings.copy(Blocks.SPAWNER)), itemSettings().rarity(Rarity.RARE).maxCount(64).group(BOOKS).fireproof()),

    GRAVE_MARKER(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    GRAVE_MARKER_PET(new GraveBlock(Block.Settings.copy(Blocks.OAK_WOOD).hardness(1).resistance(100).nonOpaque()), itemSettings()),
    ERD_STONE_GRAVESTONE(new GraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).resistance(100).nonOpaque()), itemSettings().rarity(Rarity.UNCOMMON)),
    ERD_STONE_GRAVESTONE_PET(new GraveBlock(Block.Settings.copy(Blocks.DEEPSLATE).hardness(1).resistance(100).nonOpaque()), itemSettings()),
    
    // clay pots go here (not the baking item one)
    BROWN_CLAY_POT(new ClayPotBlock(Block.Settings.copy(Blocks.GLASS).breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    BLUE_CLAY_POT(new ClayPotBlock(Block.Settings.copy(Blocks.GLASS).breakInstantly()), itemSettings().group(BOOKS).rarity(Rarity.RARE)),
    
    // redstonery
    STAKE(new StakeBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD).breakInstantly()), itemSettings()),
    LANTERN_HANGER(new LanternHangerBlock(Block.Settings.of(Material.WOOD, MapColor.OAK_TAN).sounds(BlockSoundGroup.WOOD)), itemSettings()),
    SPRINKLER(new SprinklerBlock(), itemSettings()),
    SCARECROW(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_GLOWING(new ScarecrowBlock(true), itemSettings()),
    SCARECROW_HAT(new ScarecrowBlock(false), itemSettings()),
    SCARECROW_HAT_GLOWING(new ScarecrowBlock(true), itemSettings()),
    SCARECROW_TARGET(new ScarecrowBlock(false), itemSettings()),

    // glass blocks & windows
    OPTIC_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS)), itemSettings()),
    BRIMSTONE_GLASS(new GlassBlock(Block.Settings.copy(Blocks.GLASS).nonOpaque().luminance(s -> 8).resistance(30).hardness(2)), itemSettings()),

    // Potted flowers
    POTTED_BLACK_DAHLIA(new FlowerPotBlock(NaturalBlocks.BLACK_DAHLIA.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_FLUFFY_DANDELION(new FlowerPotBlock(NaturalBlocks.FLUFFY_DANDELION.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_FADED_SOUL_ROSE(new FlowerPotBlock(NaturalBlocks.FADED_SOUL_ROSE.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_HONEYCLUSTER(new FlowerPotBlock(NaturalBlocks.HONEYCLUSTER.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_LAVENDER(new FlowerPotBlock(NaturalBlocks.LAVENDER.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_ORANGE_BEAUTY(new FlowerPotBlock(NaturalBlocks.ORANGE_BEAUTY.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_POISON_BLOSSOM(new FlowerPotBlock(NaturalBlocks.POISON_BLOSSOM.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_PURPLE_TULIP(new FlowerPotBlock(NaturalBlocks.PURPLE_TULIP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_YELLOW_TULIP(new FlowerPotBlock(NaturalBlocks.YELLOW_TULIP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_LIGHT_BLUE_TULIP(new FlowerPotBlock(NaturalBlocks.LIGHT_BLUE_TULIP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_BLACK_TULIP(new FlowerPotBlock(NaturalBlocks.BLACK_TULIP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_GODDESS_LILY(new FlowerPotBlock(NaturalBlocks.GODDESS_LILY.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_RED_LUPINE(new FlowerPotBlock(NaturalBlocks.RED_LUPINE.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_YELLOW_LUPINE(new FlowerPotBlock(NaturalBlocks.YELLOW_LUPINE.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_PINK_LUPINE(new FlowerPotBlock(NaturalBlocks.PINK_LUPINE.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_ORANGE_POPPY(new FlowerPotBlock(NaturalBlocks.ORANGE_POPPY.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_YELLOW_POPPY(new FlowerPotBlock(NaturalBlocks.YELLOW_POPPY.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_WHITE_POPPY(new FlowerPotBlock(NaturalBlocks.WHITE_POPPY.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_SNOWFLOWER(new FlowerPotBlock(NaturalBlocks.SNOWFLOWER.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),

    // Potted mushrooms
    POTTED_GLOW_CAP(new FlowerPotBlock(NaturalBlocks.GLOW_CAP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_JUNGLE_CAP(new FlowerPotBlock(NaturalBlocks.JUNGLE_CAP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_SOULSPORE(new FlowerPotBlock(NaturalBlocks.SOULSPORE_SINGLE.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_MOREL(new FlowerPotBlock(NaturalBlocks.MOREL.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_GOOP_CAP(new FlowerPotBlock(NaturalBlocks.GOOP_CAP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_GILDED_CAP(new FlowerPotBlock(NaturalBlocks.GILDED_CAP.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_IRONSHROOM(new FlowerPotBlock(NaturalBlocks.IRONSHROOM.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),

    // Potted saplings
    POTTED_DRIED_SAPLING(new FlowerPotBlock(NaturalBlocks.DRIED_SAPLING.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_MAMON_SAPLING(new FlowerPotBlock(NaturalBlocks.MAMON_SAPLING.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_APPLE_SAPLING(new FlowerPotBlock(NaturalBlocks.APPLE_SAPLING.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_WARM_BIRCH_SAPLING(new FlowerPotBlock(NaturalBlocks.WARM_BIRCH_SAPLING.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),

    // Other potted plants
    POTTED_FOXTAIL_FERN(new FlowerPotBlock(NaturalBlocks.FOXTAIL_FERN.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_LEATHERLEAF_FERN(new FlowerPotBlock(NaturalBlocks.LEATHERLEAF_FERN.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_MOSS_SPROUTLET(new FlowerPotBlock(NaturalBlocks.MOSS_SPROUTLET.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_ORANGE_FERN(new FlowerPotBlock(NaturalBlocks.ORANGE_FERN.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_SPROUT(new FlowerPotBlock(NaturalBlocks.SPROUT.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_DESERT_SHRUB(new FlowerPotBlock(NaturalBlocks.DESERT_SHRUB.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_LUSH_BUSH(new FlowerPotBlock(NaturalBlocks.LUSH_BUSH.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),

    // Potted plants that need custom models (due to not using the cross shape, or their texture being too big for the pot)
    POTTED_FLOWERING_CACTUS(new FlowerPotBlock(NaturalBlocks.FLOWERING_CACTUS.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_JUNGLE_BUSH(new FlowerPotBlock(NaturalBlocks.JUNGLE_BUSH.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_PANFLOWERS(new FlowerPotBlock(NaturalBlocks.PANFLOWERS.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_FROSTFERN(new FlowerPotBlock(NaturalBlocks.FROSTFERN.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_CLARET_LEAF(new FlowerPotBlock(NaturalBlocks.CLARET_LEAF.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_WEEPING_GHOST_WILLOW(new FlowerPotBlock(NaturalBlocks.WEEPING_GHOST_WILLOW.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    POTTED_BONE_WEED(new FlowerPotBlock(NaturalBlocks.BONE_WEED.asBlock(), Block.Settings.copy(Blocks.POTTED_POPPY))),
    
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
    
    //ancient
    ANCIENT_WOOD(new PillarBlock(Block.Settings.copy(Blocks.OAK_WOOD)), itemSettings()),
    STRIPPED_ANCIENT_WOOD(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_WOOD)), itemSettings()),
    STRIPPED_ANCIENT_LOG(new PillarBlock(Block.Settings.copy(Blocks.STRIPPED_OAK_LOG)), itemSettings()),
    ANCIENT_PLANKS(new Block(Block.Settings.copy(Blocks.OAK_PLANKS)), itemSettings()),

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
    SUGARCANE_BALE(new HayBlock(Block.Settings.copy(Blocks.HAY_BLOCK).mapColor(MapColor.TERRACOTTA_GREEN)), itemSettings()),
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

    PRIMSTEEL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_TILED_PLATE(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    PRIMSTEEL_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    PRIMSTEEL_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    PRIMSTEEL_LADDER(new LadderBlock(Block.Settings.of(Material.DECORATION).strength(3.0f).sounds(BlockSoundGroup.METAL).nonOpaque()), itemSettings()),
    PRIMSTEEL_BARS(new PaneBlock(Block.Settings.copy(Blocks.IRON_BARS)), itemSettings()),

    IRON_LADDER(new LadderBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(3.0f).sounds(BlockSoundGroup.METAL).nonOpaque()), itemSettings()),
    IRON_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),

    GOLDEN_GRATE(new GrateBlock(Block.Settings.copy(Blocks.GOLD_BLOCK).nonOpaque()), itemSettings()),
    GOLDEN_BARS(new PaneBlock(Block.Settings.copy(Blocks.GOLD_BLOCK)), itemSettings()),

    ROSEGOLD_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f)), itemSettings()),

    GOLEMITE_BLOCK(new Block(Block.Settings.copy(Blocks.IRON_BLOCK)), itemSettings()),
    GOLEMITE_CHAIN(new ChainBlock(Block.Settings.copy(Blocks.CHAIN)), itemSettings()),
    GOLEMITE_GRATE(new GrateBlock(Block.Settings.copy(Blocks.IRON_BLOCK).strength(4.1f, 5.0f).nonOpaque()), itemSettings()),
    GOLEMITE_LADDER(new LadderBlock(Block.Settings.of(Material.DECORATION).strength(3.0f).sounds(BlockSoundGroup.METAL).nonOpaque()), itemSettings()),
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

    // polished stones
    PUMICE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    VERDANTINE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SHIVERSTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    GRIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    SERPENTINITE_SMOOTH(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),
    DIABASE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    LIMESTONE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),

    // Polished stone stairs & slabs
    CARMINE_SMOOTH(new Block(Block.Settings.copy(Blocks.STONE)), itemSettings()),
    CARMINE_SMOOTH_STAIRS(new StairsBlock(CARMINE_SMOOTH.getState(), Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_SLAB(new SlabBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),
    CARMINE_SMOOTH_WALL(new WallBlock(Block.Settings.copy(CARMINE_SMOOTH.block)), itemSettings()),

    //ice and snow blocks
    PACKED_SNOW_BRICKS_LARGE(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.SNOW)), itemSettings()),
    PACKED_SNOW_BRICKS_SMALL(new Block(Block.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.SNOW)), itemSettings()),

    //dripstone bricks
    POLISHED_DRIPSTONE(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_BRICKS(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),
    DRIPSTONE_TILES(new Block(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK)), itemSettings()),

    //industrial blocks
    INDUSTRIAL_BRICKS(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),
    INDUSTRIAL_PLATE_BLOCK(new Block(Block.Settings.copy(Blocks.SMOOTH_BASALT)), itemSettings()),

    //??? other misc stone blocks ig
    STONE_TILES(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    POLISHED_STONE(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    SMOOTH_STONE_TILES(new Block(Block.Settings.copy(Blocks.SMOOTH_STONE)), itemSettings()),

    //cobblestone bricks
    COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    MOSSY_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),
    CHISELED_COBBLESTONE_BRICKS(new Block(Block.Settings.copy(Blocks.STONE_BRICKS)), itemSettings()),

    //chimneys aka hell
    INDUSTRIAL_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SMOOTH_BASALT).nonOpaque()), itemSettings()),
    COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    COBBLESTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    STONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.STONE_BRICKS).nonOpaque()), itemSettings()),
    BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.BRICKS).nonOpaque()), itemSettings()),
    MUD_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.MUD_BRICKS).nonOpaque()), itemSettings()),
    ERDCOBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(NaturalBlocks.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    ERDSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(NaturalBlocks.ERDCOBBLESTONE.block).nonOpaque()), itemSettings()),
    SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.SANDSTONE).nonOpaque()), itemSettings()),
    RED_SANDSTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.RED_SANDSTONE).nonOpaque()), itemSettings()),
    CARMINE_COBBLESTONE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.COBBLESTONE).nonOpaque()), itemSettings()),
    DRIPSTONE_TILE_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
    DRIPSTONE_BRICK_CHIMNEY(new ChimneyBlock(Block.Settings.copy(Blocks.DRIPSTONE_BLOCK).nonOpaque()), itemSettings()),
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
}
