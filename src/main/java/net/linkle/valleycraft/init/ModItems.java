package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.FoodItem;
import net.linkle.valleycraft.item.SalveItem;
import net.linkle.valleycraft.item.SoulItem;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.EPIC;
import static net.minecraft.util.Rarity.UNCOMMON;

import net.linkle.valleycraft.armors.ArmorMats;

public class ModItems {

    //ingredients
    public static final Item SALT = new Item(itemSettings());
    public static final Item FLOUR = new Item(itemSettings());

    //fluids
    public static final Item SLUDGE_BUCKET = new BucketItem(ModFluids.SLUDGE_STILL, itemSettings().group(VC_ITEMS).maxCount(1));

    //misc
    public static final Item FIBER = new Item(itemSettings().group(VC_ITEMS));
    public static final Item COVER = new Item(itemSettings().group(VC_ITEMS));
    public static final Item MULCH = new Item(itemSettings().group(VC_ITEMS));
    public static final Item CROWS_FEATHER = new Item(itemSettings().group(VC_ITEMS));
    public static final Item SEAGULLS_FEATHER = new Item(itemSettings().group(VC_ITEMS));
    public static final Item DUCKS_FEATHER = new Item(itemSettings().group(VC_ITEMS));
    public static final Item BEAST_BONE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item STRING = new Item(itemSettings().group(VC_ITEMS));
    public static final Item SALVE = new SalveItem(itemSettings().group(VC_TOOLS).maxCount(16), 0, 0.0f, StatusEffects.REGENERATION);
    public static final Item DOG_BISCUIT = new FoodItem(itemSettings().group(REGULAR_DISHES), 2, 0.4f, true);

    // crops
    public static final Item RICE_SEEDS = new AliasedBlockItem(ModNaturalBlocks.RICES, itemSettings().group(VC_ITEMS));
    public static final Item PUFF_BALL_SEEDS = new AliasedBlockItem(ModNaturalBlocks.PUFF_BALL, itemSettings().group(VC_ITEMS));
    public static final Item ONION_SEEDS = new AliasedBlockItem(ModNaturalBlocks.ONIONS, itemSettings().group(VC_ITEMS));
    public static final Item FIRE_PEPPER_SEEDS = new AliasedBlockItem(ModNaturalBlocks.FIRE_PEPPERS, itemSettings().group(VC_ITEMS));
    public static final Item CAVE_ROOT_SEEDS = new AliasedBlockItem(ModNaturalBlocks.CAVE_ROOT_CROP, itemSettings().group(VC_ITEMS));
    public static final Item ANCIENT_FLOWER_SEEDS = new AliasedBlockItem(ModNaturalBlocks.ANCIENT_FLOWERS, itemSettings().group(VC_ITEMS).rarity(Rarity.RARE));
    public static final Item AMETHYSTLE_SEEDS = new AliasedBlockItem(ModNaturalBlocks.AMETHYSTLES, itemSettings().group(VC_ITEMS));

    public static final Item T_TRADE = new Item(itemSettings().group(BOOKS).rarity(Rarity.UNCOMMON).maxCount(1));
    public static final Item T_APPRECIATION = new Item(itemSettings().group(BOOKS).rarity(Rarity.RARE).maxCount(1));
    public static final Item T_VISITORS = new Item(itemSettings().group(BOOKS).rarity(EPIC).maxCount(1));
    public static final Item S_TOKEN = new Item(itemSettings().group(BOOKS).rarity(Rarity.COMMON).maxCount(64));

    //
    public static final Item ARROW_BUNDLE = new Item(itemSettings().group(VC_TOOLS));
    public static final Item BOMB_BAG = new Item(itemSettings().group(BOOKS));
    public static final Item SHEEP_HIDE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item BOW_STRING = new Item(itemSettings().group(VC_ITEMS));
    public static final Item CLOTH = new Item(itemSettings().group(VC_ITEMS));
    public static final Item HANDLE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item PLANK = new Item(itemSettings().group(VC_ITEMS));
    public static final Item AGITATOR = new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE));
    public static final Item HOT_PLATE = new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE));
    public static final Item THERMAL = new Item(itemSettings().group(VC_ITEMS).rarity(Rarity.RARE));
    public static final Item ROSEGOLD = new Item(itemSettings().group(VC_ITEMS));
    public static final Item GOLEMITE_RAW = new Item(itemSettings().group(VC_ITEMS));
    public static final Item PRIMSTEEL_RAW = new Item(itemSettings().group(VC_ITEMS));
    public static final Item GOLEMITE_NUGGET = new Item(itemSettings().group(VC_ITEMS));
    public static final Item PRIMSTEEL_NUGGET = new Item(itemSettings().group(VC_ITEMS));
    public static final Item GOLEMITE_INGOT = new Item(itemSettings().group(VC_ITEMS));
    public static final Item PRIMSTEEL_INGOT = new Item(itemSettings().group(VC_ITEMS));
    public static final Item ANTHRACITE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item BIG_BOTTLE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item BB_SNAIL = new Item(itemSettings().group(VC_ITEMS).maxCount(16));
    public static final Item BB_CAVE_SNAIL = new Item(itemSettings().group(VC_ITEMS).maxCount(16));
    public static final Item BB_RHINO = new Item(itemSettings().group(VC_ITEMS).maxCount(16));
    public static final Item MONSTER_CLAW = new Item(itemSettings().group(VC_ITEMS));
    public static final Item DAUB = new Item(itemSettings().group(VC_ITEMS));
    public static final Item PIG_HIDE = new Item(itemSettings().group(VC_ITEMS));
    public static final Item AMBER = new Item(itemSettings().group(VC_ITEMS));

    public static final Item SOUL_ITEM = new SoulItem(itemSettings().rarity(UNCOMMON).group(BOOKS));
    public static final Item SOUL_ITEM_PET = new SoulItem(itemSettings().rarity(EPIC).group(BOOKS));

    public static void initialize() {
        ModBookItems.initialize();

        // crops
        Reg.register("rice_seeds", RICE_SEEDS);
        Reg.register("puff_ball_seeds", PUFF_BALL_SEEDS);
        Reg.register("onion_seeds", ONION_SEEDS);
        Reg.register("fire_pepper_seeds", FIRE_PEPPER_SEEDS);
        Reg.register("cave_root_seeds", CAVE_ROOT_SEEDS);
        Reg.register("ancient_flower_seeds", ANCIENT_FLOWER_SEEDS);
        Reg.register("amethystle_seeds", AMETHYSTLE_SEEDS);

        Reg.register("fiber", FIBER);
        Reg.register("plank", PLANK);
        Reg.register("salt", SALT);
        Reg.register("monster_claw", MONSTER_CLAW);
        Reg.register("beast_bone", BEAST_BONE);
        Reg.register("sheep_hide", SHEEP_HIDE);
        Reg.register("pig_hide", PIG_HIDE);
        Reg.register("seagulls_feather", SEAGULLS_FEATHER);
        Reg.register("ducks_feather", DUCKS_FEATHER);
        Reg.register("crows_feather", CROWS_FEATHER);
        Reg.register("primsteel_nugget", PRIMSTEEL_NUGGET);
        Reg.register("primsteel_raw", PRIMSTEEL_RAW);
        Reg.register("golemite_raw", GOLEMITE_RAW);
        Reg.register("golemite_nugget", GOLEMITE_NUGGET);
        Reg.register("amber", AMBER);
        Reg.register("anthracite", ANTHRACITE);

        Reg.register("mulch", MULCH);
        Reg.register("daub", DAUB);
        Reg.register("handle", HANDLE);
        Reg.register("cloth", CLOTH);
        Reg.register("plant_fiber_string", STRING);
        Reg.register("book_cover", COVER);
        Reg.register("bow_string", BOW_STRING);
        Reg.register("flour", FLOUR);

        Reg.register("primsteel_ingot", PRIMSTEEL_INGOT);
        Reg.register("golemite_ingot", GOLEMITE_INGOT);
        Reg.register("rosegold_ingot", ROSEGOLD);
        Reg.register("hot_plate", HOT_PLATE);
        Reg.register("agitator", AGITATOR);
        Reg.register("thermal_blaze_core", THERMAL);

        Reg.register("big_bottle", BIG_BOTTLE);
        Reg.register("bb_snail", BB_SNAIL);
        Reg.register("bb_cave_snail", BB_CAVE_SNAIL);
        Reg.register("bb_rhino_beetle", BB_RHINO);

        Reg.register("sludge_bucket", SLUDGE_BUCKET);

        Reg.register("dog_biscuit", DOG_BISCUIT);
        Reg.register("salve", SALVE);

        Reg.register("seaologer_token", S_TOKEN);
        Reg.register("totem_of_trade", T_TRADE);
        Reg.register("totem_of_appreciation", T_APPRECIATION);
        Reg.register("totem_of_visitors", T_VISITORS);

        Reg.register("bomb_bag", BOMB_BAG);
        Reg.register("arrow_bundle", ARROW_BUNDLE);

        //souls
        Reg.register("soul_item", SOUL_ITEM);
        Reg.register("soul_item_pet", SOUL_ITEM_PET);

        TieredFoodItems.initialize();
        IngredientFoodItems.initialize();
        RegularFoodItems.initialize();
        ArmorMats.initialize();
        ModArmors.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
