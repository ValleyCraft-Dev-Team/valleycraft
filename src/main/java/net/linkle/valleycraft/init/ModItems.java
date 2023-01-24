package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.EPIC;
import static net.minecraft.util.Rarity.RARE;
import static net.minecraft.util.Rarity.UNCOMMON;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.baubles.UniqueBaubleItem;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.item.clay_pot.ClayPotItem;
import net.linkle.valleycraft.item.clay_pot.WaterClayPotItem;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum ModItems implements ItemEnum {
    RAW_CLAY_POT(new ClayPotItem(itemSettings().maxCount(16).group(VC_ITEMS))),
    CLAY_POT(new ClayPotItem(itemSettings().maxCount(16).group(VC_ITEMS))),
    WATER_FILLED_CLAY_POT(new WaterClayPotItem(itemSettings().maxCount(1).group(VC_ITEMS).recipeRemainder(ModItems.CLAY_POT.item), 0, 0.0f)),
    //MILK_FILLED_CLAY_POT(new WaterClayPotItem(itemSettings().maxCount(1).group(INGREDIENTS).recipeRemainder(ModItems.CLAY_POT.item), 0, 0.0f).setMilk()),

    ROPE(new RopeItem(itemSettings().group(VC_ITEMS))),
    
    // tree seeds
    OAK_SEED(new AliasedBlockItem(ModNaturalBlocks.OAK_SEED.block, itemSettings())),
    DARK_OAK_SEED(new AliasedBlockItem(ModNaturalBlocks.DARK_OAK_SEED.block, itemSettings())),
    SPRUCE_SEED(new AliasedBlockItem(ModNaturalBlocks.SPRUCE_SEED.block, itemSettings())),
    BIRCH_SEED(new AliasedBlockItem(ModNaturalBlocks.BIRCH_SEED.block, itemSettings())),
    JUNGLE_SEED(new AliasedBlockItem(ModNaturalBlocks.JUNGLE_SEED.block, itemSettings())),
    ACACIA_SEED(new AliasedBlockItem(ModNaturalBlocks.ACACIA_SEED.block, itemSettings())),
    APPLE_SEED(new AliasedBlockItem(ModNaturalBlocks.APPLE_SEED.block, itemSettings())),
    AMBERBLOSSOM_SEED(new AliasedBlockItem(ModNaturalBlocks.AMBERBLOSSOM_SEED.block, itemSettings())),
    WARM_BIRCH_SEED(new AliasedBlockItem(ModNaturalBlocks.WARM_BIRCH_SEED.block, itemSettings())),

    // crops
    RICE_SEEDS(new AliasedBlockItem(ModNaturalBlocks.RICES.block, itemSettings())),
    PUFF_BALL_SEEDS(new AliasedBlockItem(ModNaturalBlocks.PUFF_BALL.block, itemSettings())),
    ONION_SEEDS(new AliasedBlockItem(ModNaturalBlocks.ONIONS.block, itemSettings())),
    FIRE_PEPPER_SEEDS(new AliasedBlockItem(ModNaturalBlocks.FIRE_PEPPERS.block, itemSettings())),
    CAVE_ROOT_SEEDS(new AliasedBlockItem(ModNaturalBlocks.CAVE_ROOT_CROP.block, itemSettings())),
    ANCIENT_FLOWER_SEEDS(new AliasedBlockItem(ModNaturalBlocks.ANCIENT_FLOWERS.block, itemSettings().rarity(Rarity.RARE))),
    AMETHYSTLE_SEEDS(new AliasedBlockItem(ModNaturalBlocks.AMETHYSTLES.block, itemSettings())),

    GLOW_BALL(new GlowBallItem(itemSettings().group(VC_TOOLS))),
    FIBER(new Item(itemSettings())),
    DRIED_FIBER(new Item(itemSettings())),
    PLANT_FIBER_STRING(new Item(itemSettings())),
    PLANT_FIBER_CANVAS(new Item(itemSettings())),
    DAUB(new Item(itemSettings())),
    PLANK(new Item(itemSettings())),
    SALT(new Item(itemSettings().group(INGREDIENTS))),

    //FUR_CLUMP(new Item(itemSettings())),
    SHEEP_HIDE(new Item(itemSettings())),
    PIG_HIDE(new Item(itemSettings())),
    MONSTER_CLAW(new Item(itemSettings())),
    BEAST_BONE(new Item(itemSettings())),
    SKULL_SHARD(new Item(itemSettings())),
    WITHERED_SKULL_SHARD(new Item(itemSettings())),
    BONEFIN(new Item(itemSettings())),
    DRAGON_TOOTH(new Item(itemSettings().rarity(RARE).fireproof())),
    SEAGULLS_FEATHER(new Item(itemSettings())),
    DUCKS_FEATHER(new Item(itemSettings())),
    DUCKS_EGG(new Item(itemSettings())),
    CROWS_FEATHER(new Item(itemSettings())),
    SLIME_BLOB(new Item(itemSettings())),
    EVIL_CRYSTAL(new Item(itemSettings().rarity(UNCOMMON).fireproof())),

    HANDLE(new Item(itemSettings())),
    STURDY_HANDLE(new Item(itemSettings())),
    REINFORCED_HANDLE(new Item(itemSettings())),
    TREATED_LEATHER(new Item(itemSettings())),
    LEATHER_STRAP(new Item(itemSettings())),
    GHAST_TEARS(new Tier0Bottle(itemSettings().maxCount(16).rarity(UNCOMMON).recipeRemainder(Items.GLASS_BOTTLE), 0, 0.0f, StatusEffects.REGENERATION).hideTooltip()),
    INK_BOTTLE(new Tier0Bottle(itemSettings().maxCount(16), 0, 0.0f, StatusEffects.BLINDNESS).hideTooltip()),
    QUILL(new Item(itemSettings())),
    RUNE_ETCHING_BLADE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),

    BOW_STRING(new Item(itemSettings())),
    FLOUR(new Item(itemSettings().group(INGREDIENTS))),
    MAIZE_FLOUR(new Item(itemSettings().group(INGREDIENTS))),

    AMBER(new Item(itemSettings())),
    ANTHRACITE(new Item(itemSettings())),
    BRIMSTONE_SHARD(new Item(itemSettings())),
    NETHER_GARNET(new Item(itemSettings())),
    COPPER_NUGGET(new Item(itemSettings())),
    GOLD_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_NUGGET(new Item(itemSettings())),
    PRIMSTEEL_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_RAW(new Item(itemSettings())),
    PRIMSTEEL_INGOT(new Item(itemSettings())),
    IRON_SCRAP(new Item(itemSettings())),
    BRASIUM_INGOT(new Item(itemSettings())),
    ROSEGOLD_INGOT(new Item(itemSettings())),
    DIAMOND_PLATE(new Item(itemSettings())),
    NETHERITE_NUGGET(new Item(itemSettings())),
    SPYGLASS_LENSE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),
    HOT_PLATE(new Item(itemSettings().rarity(Rarity.RARE))),
    AGITATOR(new Item(itemSettings().rarity(Rarity.RARE))),
    THERMAL_BLAZE_CORE(new Item(itemSettings().rarity(Rarity.RARE))),
    STRANGE_CATALYST(new Item(itemSettings().rarity(RARE))),

    //pets
    DOG_BISCUIT(new FoodItem(itemSettings().group(REGULAR_DISHES), 2, 0.4f, true)),

    //souls
    SOUL_ITEM_FADING(new SoulItem(itemSettings().group(BOOKS).fireproof(), 30)),
    SOUL_ITEM(new SoulItem(itemSettings().rarity(UNCOMMON).group(BOOKS).fireproof(), 60)),
    SOUL_ITEM_ENRAGED(new SoulItem(itemSettings().rarity(RARE).group(BOOKS).fireproof(), 120)),
    SOUL_ITEM_PET(new SoulPetItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof())),
    SOUL_ITEM_WARDEN(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof(), 3750)),
    SOUL_ITEM_WITHERED(new SoulItem(itemSettings().rarity(RARE).group(BOOKS).fireproof(), 15)),
    SOUL_ITEM_AMALGAMATED(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof(), 3750)),
    SOUL_ITEM_DRAGON(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof(), 7000)),

    GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON).maxCount(64))),
    ELDER_GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE).maxCount(64))),

    //SEAOLOGER_TOKEN(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.COMMON).maxCount(64))),
    TOTEM_OF_TRADE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON).maxCount(1))),
    TOTEM_OF_APPRECIATION(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE).maxCount(1))),
    //TOTEM_OF_VISITORS(new UniqueMythicItem(itemSettings().rarity(RARE).maxCount(1))),
    TOTEM_OF_FRIENDSHIP(new Item(itemSettings().group(VC_ITEMS).rarity(EPIC).maxCount(1))),
    BOMB_BAG(new BombBagItem(itemSettings().group(VC_ITEMS))),
    ARROW_BUNDLE(new ArrowBundleItem(itemSettings().group(VC_ITEMS))),
    SEED_BAG(new SeedBagItem(itemSettings().group(VC_ITEMS))),

    //record items
    ANCIENT_RECORD_FRAGMENT(new ModDiscFragmentItem(itemSettings().group(BOOKS))),
    ANCIENT_RECORD_MUSIC_DISC(new ModMusicDiscItem(7, ModMusic.ANCIENT.sound, itemSettings().group(BOOKS).rarity(RARE).maxCount(1),110)),

    //big bottle items
    //BIG_BOTTLE(new Item(itemSettings())),
    //BB_SNAIL(new Item(itemSettings().maxCount(16))),
    //BB_CAVE_SNAIL(new Item(itemSettings().maxCount(16))),
    //BB_SCULK_SNAIL(new Item(itemSettings().maxCount(16))),
    //BB_RHINO_BEETLE(new Item(itemSettings().maxCount(16))),

    //cloth items
    //BLACK_CLOTH(new Item(itemSettings())),
    //BLUE_CLOTH(new Item(itemSettings())),
    //BROWN_CLOTH(new Item(itemSettings())),
    //CYAN_CLOTH(new Item(itemSettings())),
    //GRAY_CLOTH(new Item(itemSettings())),
    //GREEN_CLOTH(new Item(itemSettings())),
    //LIGHT_BLUE_CLOTH(new Item(itemSettings())),
    //LIGHT_GRAY_CLOTH(new Item(itemSettings())),
    //LIME_CLOTH(new Item(itemSettings())),
    //MAGENTA_CLOTH(new Item(itemSettings())),
    //ORANGE_CLOTH(new Item(itemSettings())),
    //PINK_CLOTH(new Item(itemSettings())),
    //PURPLE_CLOTH(new Item(itemSettings())),
    //RED_CLOTH(new Item(itemSettings())),
    CLOTH(new Item(itemSettings())),
    //YELLOW_CLOTH(new Item(itemSettings())),

    //bucket items
    SLUDGE_BUCKET(new BucketItem(ModFluids.SLUDGE_STILL.fluid, itemSettings().maxCount(1))),

    // spawn eggs
    ABYSSWATCHER_SPAWN_EGG(new SpawnEggItem(ModEntityType.ABYSSWATCHER, 0x09424C, 0x22DBE5, itemSettings())), // abysswatcher_spawn_egg
    PERCH_SPAWN_EGG(new SpawnEggItem(ModEntityType.PERCH, 0x724E00, 0xCC9D26, itemSettings())), // perch_spawn_egg
    RED_PORGY_SPAWN_EGG(new SpawnEggItem(ModEntityType.RED_PORGY, 0xF48DB0, 0xF9EDF1, itemSettings())), // red_porgy_spawn_egg
    SARDINE_SPAWN_EGG(new SpawnEggItem(ModEntityType.SARDINE, 0x2E445B, 0xA1B1CC, itemSettings())), // sardine_spawn_egg
    STONEROLLER_MINNOW_SPAWN_EGG(new SpawnEggItem(ModEntityType.STONEROLLER_MINNOW, 0x608C85, 0xCCCCCC, itemSettings())), // STONEROLLER_MINNOW_spawn_egg
    BONEFIN_SPAWN_EGG(new SpawnEggItem(ModEntityType.BONEFIN, 0xE5E0CE, 0xBFB799, itemSettings())), // bonefin_spawn_egg
    ZOD_SPAWN_EGG(new SpawnEggItem(ModEntityType.ZOD, 0x557571, 0xCCB599, itemSettings())); // zod_spawn_egg

    public static void initialize() {
        TieredFoodItems.initialize();
        IngredientFoodItems.initialize();
        RegularFoodItems.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(VC_ITEMS);
    }

    private static Item.Settings unlistedWIPItemSettings() {
        return new Item.Settings();
    }

    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    ModItems(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
    
    @Override
    public Identifier getId() {
        return id;
    }
}
