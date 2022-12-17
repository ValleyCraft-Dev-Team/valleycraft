package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.armors.ArmorMats;
import net.linkle.valleycraft.baubles.BaubleItem;
import net.linkle.valleycraft.baubles.TalismanItem;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.*;

public enum ModItems implements ItemEnum {
    //cups
    WOODEN_CUP(new CupItem(itemSettings().group(INGREDIENTS))),
    WATER_FILLED_WOODEN_CUP(new WaterCupItem(itemSettings().maxCount(16).group(INGREDIENTS).recipeRemainder(ModItems.WOODEN_CUP.item), 0, 0.0f)),

    // tree seeds
    OAK_SEED(new Item(itemSettings())),
    DARK_OAK_SEED(new Item(itemSettings())),
    SPRUCE_SEED(new Item(itemSettings())),
    BIRCH_SEED(new Item(itemSettings())),
    JUNGLE_SEED(new Item(itemSettings())),
    ACACIA_SEED(new Item(itemSettings())),
    APPLE_SEED(new Item(itemSettings())),
    AMBERBLOSSOM_SEED(new Item(itemSettings())),
    WARM_BIRCH_SEED(new Item(itemSettings())),
    //CELESTIAL_SEED(new Item(itemSettings())),

    // crops
    RICE_SEEDS(new AliasedBlockItem(ModNaturalBlocks.RICES.block, itemSettings())),
    PUFF_BALL_SEEDS(new AliasedBlockItem(ModNaturalBlocks.PUFF_BALL.block, itemSettings())),
    ONION_SEEDS(new AliasedBlockItem(ModNaturalBlocks.ONIONS.block, itemSettings())),
    FIRE_PEPPER_SEEDS(new AliasedBlockItem(ModNaturalBlocks.FIRE_PEPPERS.block, itemSettings())),
    CAVE_ROOT_SEEDS(new AliasedBlockItem(ModNaturalBlocks.CAVE_ROOT_CROP.block, itemSettings())),
    ANCIENT_FLOWER_SEEDS(new AliasedBlockItem(ModNaturalBlocks.ANCIENT_FLOWERS.block, itemSettings().rarity(Rarity.RARE))),
    AMETHYSTLE_SEEDS(new AliasedBlockItem(ModNaturalBlocks.AMETHYSTLES.block, itemSettings())),
    //GHOST_PUMPKIN_SEEDS(new AliasedBlockItem(ModNaturalBlocks.GHOST_PUMPKIN_STEM.block, itemSettings())),

    FIBER(new Item(itemSettings())),
    DRIED_FIBER(new Item(itemSettings())),
    PLANT_FIBER_STRING(new Item(itemSettings())),
    PLANT_FIBER_CANVAS(new Item(itemSettings())),
    DAUB(new Item(itemSettings())),
    PLANK(new Item(itemSettings())),
    SALT(new Item(itemSettings().group(INGREDIENTS))),

    FUR_CLUMP(new Item(itemSettings())),
    SHEEP_HIDE(new Item(itemSettings())),
    PIG_HIDE(new Item(itemSettings())),
    MONSTER_CLAW(new Item(itemSettings())),
    //SPIDER_SILK(new Item(itemSettings().rarity(UNCOMMON))),
    BEAST_BONE(new Item(itemSettings())),
    SKULL_SHARD(new Item(itemSettings())),
    WITHERED_SKULL_SHARD(new Item(itemSettings())),
    BONEFIN(new Item(itemSettings())),
    SEAGULLS_FEATHER(new Item(itemSettings())),
    DUCKS_FEATHER(new Item(itemSettings())),
    CROWS_FEATHER(new Item(itemSettings())),
    SLIME_BLOB(new Item(itemSettings())),
    EVIL_CRYSTAL(new Item(itemSettings().rarity(RARE).fireproof())),

    //MULCH(new Item(itemSettings())),
    //RAW_CLAY_POT(new Item(itemSettings())),
    HANDLE(new Item(itemSettings())),
    STURDY_HANDLE(new Item(itemSettings())),
    REINFORCED_HANDLE(new Item(itemSettings())),
    TREATED_LEATHER(new Item(itemSettings())),
    LEATHER_STRAP(new Item(itemSettings())),
    CLOTH(new Item(itemSettings())),
    BOOK_COVER(new Item(itemSettings())),
    INK_BOTTLE(new Tier0Bottle(itemSettings().maxCount(16), 0, 0.0f, StatusEffects.NAUSEA).hideTooltip()),
    QUILL(new Item(itemSettings())),
    RUNE_ETCHING_BLADE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),

    BOW_STRING(new Item(itemSettings())),
    FLOUR(new Item(itemSettings().group(INGREDIENTS))),
    MAIZE_FLOUR(new Item(itemSettings().group(INGREDIENTS))),

    //_RAW(new Item(itemSettings())),
    //GOLEMITE_NUGGET(new Item(itemSettings())),
    AMBER(new Item(itemSettings())),
    //ADVENTURINE_SHARDS(new Item(itemSettings())),
    ANTHRACITE(new Item(itemSettings())),
    BRIMSTONE_SHARD(new Item(itemSettings())),
    NETHER_GARNET(new Item(itemSettings())),
    //OBSIDIAN_CHUNK(new Item(itemSettings())),
    COPPER_NUGGET(new Item(itemSettings())),
    COPPER_SCRAP(new Item(itemSettings())),
    GOLD_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_NUGGET(new Item(itemSettings())),
    PRIMSTEEL_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_RAW(new Item(itemSettings())),
    PRIMSTEEL_INGOT(new Item(itemSettings())),
    IRON_SCRAP(new Item(itemSettings())),
    //GOLEMITE_INGOT(new Item(itemSettings())),
    BRASIUM_INGOT(new Item(itemSettings())),
    ROSEGOLD_INGOT(new Item(itemSettings())),
    DIAMOND_PLATE(new Item(itemSettings())),
    NETHERITE_NUGGET(new Item(itemSettings())),
    SPYGLASS_LENSE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),
    HOT_PLATE(new Item(itemSettings().rarity(Rarity.RARE))),
    AGITATOR(new Item(itemSettings().rarity(Rarity.RARE))),
    THERMAL_BLAZE_CORE(new Item(itemSettings().rarity(Rarity.RARE))),
    STRANGE_CATALYST(new Item(itemSettings().rarity(RARE))),
    //SHATTERED_EYE_OF_ENDER(new Item(itemSettings().rarity(EPIC))),
    //EYE_OF_RETURN(new ReturnItem(itemSettings().rarity(UNCOMMON).maxCount(16))),

    DOG_BISCUIT(new FoodItem(itemSettings().group(REGULAR_DISHES), 2, 0.4f, true)),
    //SALVE(new SalveItem(itemSettings().group(VC_TOOLS).maxCount(16), 0, 0.0f, StatusEffects.REGENERATION)),

    //souls
    SOUL_ITEM_FADING(new SoulItem(itemSettings().group(BOOKS).fireproof())),
    SOUL_ITEM(new SoulItem(itemSettings().rarity(UNCOMMON).group(BOOKS).fireproof())),
    SOUL_ITEM_ENRAGED(new SoulItem(itemSettings().rarity(RARE).group(BOOKS).fireproof())),
    SOUL_ITEM_PET(new SoulPetItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof())),
    SOUL_ITEM_WARDEN(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof())),
    SOUL_ITEM_WITHERED(new SoulItem(itemSettings().rarity(RARE).group(BOOKS).fireproof())),
    SOUL_ITEM_AMALGAMATED(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof())),
    SOUL_ITEM_DRAGON(new SoulItem(itemSettings().rarity(EPIC).group(BOOKS).fireproof())),

    GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.COMMON).maxCount(64))),
    ELDER_GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.COMMON).maxCount(64))),

    SEAOLOGER_TOKEN(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.COMMON).maxCount(64))),
    TOTEM_OF_TRADE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON).maxCount(1))),
    TOTEM_OF_APPRECIATION(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE).maxCount(1))),
    TOTEM_OF_VISITORS(new Item(itemSettings().rarity(RARE))),
    TOTEM_OF_FRIENDSHIP(new Item(itemSettings().group(VC_ITEMS).rarity(EPIC))),
    BOMB_BAG(new BombBagItem(itemSettings().group(VC_ITEMS))),
    ARROW_BUNDLE(new ArrowBundleItem(itemSettings().group(VC_ITEMS))),
    SEED_BAG(new SeedBagItem(itemSettings().group(VC_ITEMS))),

    //record items
    ANCIENT_RECORD_FRAGMENT(new ModDiscFragmentItem(itemSettings().group(BOOKS))),
    ANCIENT_RECORD_MUSIC_DISC(new ModMusicDiscItem(7, ModMusic.ANCIENT.sound, itemSettings().group(BOOKS).rarity(RARE).maxCount(1),110)),

    //big bottle items
    BIG_BOTTLE(new Item(itemSettings())),
    BB_SNAIL(new Item(itemSettings().maxCount(16))),
    BB_CAVE_SNAIL(new Item(itemSettings().maxCount(16))),
    BB_SCULK_SNAIL(new Item(itemSettings().maxCount(16))),
    BB_RHINO_BEETLE(new Item(itemSettings().maxCount(16))),

    //bucket items
    SLUDGE_BUCKET(new BucketItem(ModFluids.SLUDGE_STILL.fluid, itemSettings().maxCount(1))),

    // spawn eggs
    ABYSSWATCHER_SPAWN_EGG(new SpawnEggItem(ModEntityType.ABYSSWATCHER, 0x09424C, 0x22DBE5, itemSettings())), // abysswatcher_spawn_egg
    PERCH_SPAWN_EGG(new SpawnEggItem(ModEntityType.PERCH, 0x724E00, 0xCC9D26, itemSettings())), // perch_spawn_egg
    RED_PORGY_SPAWN_EGG(new SpawnEggItem(ModEntityType.RED_PORGY, 0xF48DB0, 0xF9EDF1, itemSettings())), // red_porgy_spawn_egg
    SARDINE_SPAWN_EGG(new SpawnEggItem(ModEntityType.SARDINE, 0x2E445B, 0xA1B1CC, itemSettings())), // sardine_spawn_egg
    STONETOSSER_MINNOW_SPAWN_EGG(new SpawnEggItem(ModEntityType.STONETOSSER_MINNOW, 0x608C85, 0xCCCCCC, itemSettings())), // stonetosser_minnow_spawn_egg
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
