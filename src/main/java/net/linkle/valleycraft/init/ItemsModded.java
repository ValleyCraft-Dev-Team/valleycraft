package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.Groups.*;
import static net.minecraft.util.Rarity.EPIC;
import static net.minecraft.util.Rarity.RARE;
import static net.minecraft.util.Rarity.UNCOMMON;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.enums.ItemEnum;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.item.clay_pot.ClayPotItem;
import net.linkle.valleycraft.item.clay_pot.WaterClayPotItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum ItemsModded implements ItemEnum {
    CLAY_POT(new ClayPotItem(itemSettings().maxCount(8).group(VC_ITEMS))),
    WATER_FILLED_CLAY_POT(new WaterClayPotItem(itemSettings().maxCount(4).group(VC_ITEMS).recipeRemainder(ItemsModded.CLAY_POT.item), 0, 0.0f)),

    ROPE(new RopeItem(itemSettings().group(VC_ITEMS))),
    
    // tree seeds
    OAK_SEED(new AliasedBlockItem(BlocksNatural.OAK_SEED.block, itemSettings())),
    DARK_OAK_SEED(new AliasedBlockItem(BlocksNatural.DARK_OAK_SEED.block, itemSettings())),
    SPRUCE_SEED(new AliasedBlockItem(BlocksNatural.SPRUCE_SEED.block, itemSettings())),
    BIRCH_SEED(new AliasedBlockItem(BlocksNatural.BIRCH_SEED.block, itemSettings())),
    JUNGLE_SEED(new AliasedBlockItem(BlocksNatural.JUNGLE_SEED.block, itemSettings())),
    ACACIA_SEED(new AliasedBlockItem(BlocksNatural.ACACIA_SEED.block, itemSettings())),
    APPLE_SEED(new AliasedBlockItem(BlocksNatural.APPLE_SEED.block, itemSettings())),
    AMBERBLOSSOM_SEED(new AliasedBlockItem(BlocksNatural.AMBERBLOSSOM_SEED.block, itemSettings())),
    WARM_BIRCH_SEED(new AliasedBlockItem(BlocksNatural.WARM_BIRCH_SEED.block, itemSettings())),

    // crops
    RICE_SEEDS(new AliasedBlockItem(BlocksNatural.RICES.block, itemSettings())),
    PUFF_BALL_SEEDS(new AliasedBlockItem(BlocksNatural.PUFF_BALL.block, itemSettings())),
    ONION_SEEDS(new AliasedBlockItem(BlocksNatural.ONIONS.block, itemSettings())),
    FIRE_PEPPER_SEEDS(new AliasedBlockItem(BlocksNatural.FIRE_PEPPERS.block, itemSettings())),
    CAVE_ROOT_SEEDS(new AliasedBlockItem(BlocksNatural.CAVE_ROOT_CROP.block, itemSettings())),
    ANCIENT_FLOWER_SEEDS(new AliasedBlockItem(BlocksNatural.ANCIENT_FLOWERS.block, itemSettings().rarity(Rarity.RARE))),
    AMETHYSTLE_SEEDS(new AliasedBlockItem(BlocksNatural.AMETHYSTLES.block, itemSettings())),

    GLOW_BALL(new GlowBallItem(itemSettings().group(VC_TOOLS))),
    ROCK_ITEM(new Item(itemSettings())),
    FIBER(new Item(itemSettings())),
    DRIED_FIBER(new Item(itemSettings())),
    PLANT_FIBER_STRING(new Item(itemSettings())),
    PLANT_FIBER_CANVAS(new Item(itemSettings())),
    DAUB(new Item(itemSettings())),
    PLANK(new Item(itemSettings())),
    SALT(new Item(itemSettings().group(INGREDIENTS))),

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
    CROWS_FEATHER(new Item(itemSettings())),
    METAL_FEATHER(new Item(itemSettings().rarity(RARE))),
    SLIME_BLOB(new Item(itemSettings())),

    HANDLE(new Item(itemSettings())),
    STURDY_HANDLE(new Item(itemSettings())),
    REINFORCED_HANDLE(new Item(itemSettings())),
    TREATED_LEATHER(new Item(itemSettings())),
    LEATHER_STRAP(new Item(itemSettings())),
    GHAST_TEARS(new Tier0Bottle(itemSettings().maxCount(16).rarity(UNCOMMON).recipeRemainder(net.minecraft.item.Items.GLASS_BOTTLE), 0, 0.0f, StatusEffects.REGENERATION).hideTooltip()),

    ALLAY_BOTTLE(new SpawnEggItem(EntityType.ALLAY,16777215,16777215, (new Item.Settings().group(VC_ITEMS).rarity(UNCOMMON)))),

    INK_BOTTLE(new Tier0Bottle(itemSettings().maxCount(16), 0, 0.0f, StatusEffects.BLINDNESS).hideTooltip()),
    QUILL(new Item(itemSettings())),
    RUNE_ETCHING_BLADE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),
    BOOK_RUNECALLING(new Item(itemSettings().rarity(EPIC))),

    BOW_STRING(new Item(itemSettings())),
    FLOUR(new Item(itemSettings().group(INGREDIENTS))),
    MAIZE_FLOUR(new Item(itemSettings().group(INGREDIENTS))),

    COAL_NUGGET(new Item(itemSettings())),
    SALTPETER(new Item(itemSettings())),
    ANTHRACITE(new Item(itemSettings())),
    BRIMSTONE_SHARD(new Item(itemSettings())),
    COPPER_NUGGET(new Item(itemSettings())),
    COPPER_SCRAP(new Item(itemSettings())),
    GOLD_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_RAW(new Item(itemSettings())),
    PRIMSTEEL_NUGGET(new Item(itemSettings())),
    PRIMSTEEL_SCRAP(new Item(itemSettings())),
    PRIMSTEEL_INGOT(new Item(itemSettings())),
    IRON_SCRAP(new Item(itemSettings())),
    BRASIUM_INGOT(new Item(itemSettings())),
    ROSEGOLD_INGOT(new Item(itemSettings())),
    DIAMOND_FRAGMENTS(new Item(itemSettings())),
    ECHOCHALCUM_INGOT(new Item(itemSettings())),
    NETHERITE_NUGGET(new Item(itemSettings())),
    TRIGGER_MECHANISM(new Item(itemSettings())),
    SPYGLASS_LENSE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),
    ECHO_SHARD_LENSE(new Item(itemSettings().rarity(Rarity.RARE))),
    HOT_PLATE(new Item(itemSettings().rarity(Rarity.RARE))),
    AGITATOR(new Item(itemSettings().rarity(Rarity.RARE))),
    THERMAL_BLAZE_CORE(new Item(itemSettings().rarity(Rarity.RARE))),
    STRANGE_CATALYST(new Item(itemSettings().rarity(RARE))),

    GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON).maxCount(64))),
    ELDER_GUARDIAN_SPIKE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE).maxCount(64))),
    LICHES_IRON_BONE_AMULET(new Item(itemSettings().rarity(Rarity.EPIC))),
    WARDEN_ANTLER(new Item(itemSettings().rarity(Rarity.EPIC))),

    TOTEM_OF_TRADE(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON).maxCount(1))),
    TOTEM_OF_APPRECIATION(new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE).maxCount(1))),
    //TOTEM_OF_FRIENDSHIP(new Item(itemSettings().group(VC_ITEMS).rarity(EPIC).maxCount(1))),
    BOMB_BAG(new BombBagItem(itemSettings().group(VC_ITEMS).rarity(Rarity.UNCOMMON))),
    ARROW_BUNDLE(new ArrowBundleItem(itemSettings().group(VC_TOOLS))),
    SEED_BAG(new SeedBagItem(itemSettings().group(VC_ITEMS))),
    STRING_SPOOL(new StringSpoolItem(itemSettings().group(VC_ITEMS).recipeRemainder(Items.STICK))),
    PUFF_BALL(new Item(itemSettings())),
    CLOTH(new Item(itemSettings())),

    //bucket items
    SLUDGE_BUCKET(new BucketItem(Fluids.SLUDGE_STILL.fluid, itemSettings().maxCount(1).recipeRemainder(Items.BUCKET))),

    // spawn eggs
    ABYSSWATCHER_SPAWN_EGG(new SpawnEggItem(Entities.ABYSSWATCHER.type(), 0x07313a, 0x00999c, itemSettings())),
    PERCH_SPAWN_EGG(new SpawnEggItem(Entities.PERCH.type(), 0x724E00, 0xCC9D26, itemSettings())),
    RED_PORGY_SPAWN_EGG(new SpawnEggItem(Entities.RED_PORGY.type(), 0xF48DB0, 0xF9EDF1, itemSettings())),
    SARDINE_SPAWN_EGG(new SpawnEggItem(Entities.SARDINE.type(), 0x2E445B, 0xA1B1CC, itemSettings())),
    STONEROLLER_MINNOW_SPAWN_EGG(new SpawnEggItem(Entities.STONEROLLER_MINNOW.type(), 0x608C85, 0xCCCCCC, itemSettings())),
    BONEFIN_SPAWN_EGG(new SpawnEggItem(Entities.BONEFIN.type(), 0xE5E0CE, 0xBFB799, itemSettings())),
    ZOD_SPAWN_EGG(new SpawnEggItem(Entities.ZOD.type(), 0x557571, 0xCCB599, itemSettings())),
    PUPKIN_SPAWN_EGG(new SpawnEggItem(Entities.PUPKIN.type(), 0xe38a1d, 0x441300, itemSettings())),
    DAIRY_COW_SPAWN_EGG(new SpawnEggItem(Entities.DAIRY_COW.type(), 0xf1f1f1, 0x282828, itemSettings())),
    CHICKEN_SPAWN_EGG(new SpawnEggItem(Entities.CHICKEN.type(), 0xac5d31, 0xc19343, itemSettings())),
    DUCK_SPAWN_EGG(new SpawnEggItem(Entities.DUCK.type(), 0x502e00, 0x1a3aad, itemSettings())),
    MOSSY_SHEEP_SPAWN_EGG(new SpawnEggItem(Entities.MOSSY_SHEEP.type(), 0x647233, 0x6a5227, itemSettings())),
    //GOLDEN_RETRIEVER_SPAWN_EGG(new SpawnEggItem(Entities.DOG.type(), 0xe38a1d, 0x441300, itemSettings())),
    //BORDER_COLLIE_SPAWN_EGG(new SpawnEggItem(Entities.DOG.type(), 0xe38a1d, 0x441300, itemSettings())),
    BROWN_BEAR_SPAWN_EGG(new SpawnEggItem(Entities.BROWN_BEAR.type(), 0x3e2912, 0x291a0c, itemSettings())),
    SNAIL_SPAWN_EGG(new SpawnEggItem(Entities.SNAIL.type(), 0xf1da85, 0xb88d55, itemSettings())),
    CAVE_SNAIL_SPAWN_EGG(new SpawnEggItem(Entities.CAVE_SNAIL.type(), 0xa08d71, 0x735450, itemSettings())),
    SCULK_SNAIL_SPAWN_EGG(new SpawnEggItem(Entities.SCULK_SNAIL.type(), 0x009295, 0x0c232c, itemSettings()));

    public static void initialize() {
        FoodTiered.initialize();
        FoodIngredients.initialize();
        FoodRegular.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(VC_ITEMS);
    }

    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    ItemsModded(Item item) {
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
