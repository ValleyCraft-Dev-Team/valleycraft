package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.linkle.valleycraft.init.ModGroups.TOOLS;

public class RegularFoodItems {

    // cooked
    public static final Item BAKED_APPLE = new FoodItem(settings(), 6, 0.6f);
    public static final Item BAKED_BEETROOT = new FoodItem(settings(), 2, 0.6f);
    public static final Item BAKED_HEARTY_BEETROOT = new FoodItem(settings(), 7, 0.6f);
    public static final Item BAKED_CARROT = new FoodItem(settings(), 5, 0.6f);
    public static final Item BAKED_ENDURA_CARROT = new FoodItem(settings(), 6, 0.6f);
    public static final Item BAKED_FIRE_PEPPER = new FoodItem(settings(), 5, 0.6f);
    public static final Item BAKED_GHOST_PUMPKIN_SLICE = new FoodItem(settings(), 4, 0.6f);
    public static final Item BAKED_PUMPKIN_SLICE = new FoodItem(settings(), 4, 0.6f);
    public static final Item BAKED_MELON_SLICE = new FoodItem(settings(), 3, 0.6f);
    public static final Item BAKED_ONION = new FoodItem(settings(), 4, 0.6f);
    public static final Item BAKED_SEEDS = new FoodItem(settings(), 2, 0.6f);
    public static final Item BAKED_SWEET_BERRIES = new FoodItem(settings(), 4, 0.6f);
    public static final Item BAKED_GLOW_BERRIES = new FoodItem(settings(), 4, 0.6f);
    public static final Item BAKED_GLOOM_BERRIES = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_RICE = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_CAVE_ROOT = new FoodItem(settings(), 5, 0.6f);

    public static final Item COOKED_SQUID = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_SILVERFISH = new FoodItem(settings(), 3, 0.6f);
    public static final Item COOKED_PHANTOM = new FoodItem(settings(), 6, 0.6f);
    public static final Item COOKED_TURTLE = new FoodItem(settings(), 8, 0.6f);
    public static final Item COOKED_BIRD = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_BACON = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_BAT = new FoodItem(settings(), 5, 0.6f, true);
    public static final Item FRIED_EGG = new FoodItem(settings(), 4, 0.6f);
    public static final Item COOKED_ROTTEN_FLESH = new FoodItem(settings(), 6, 0.4f,true);
    public static final Item COOKED_TROPICAL_FISH = new FoodItem(settings(), 4, 0.6f);
    public static final Item BEAST_LIVER_COOKED = new FoodItem(settings(), 8, 0.4f, true);

    // pastries
    public static final Item CAKE_SLICE = new FoodItem(settings(), 2, 0.1f);
    public static final Item HARDTACK = new FoodItem(settings(), 3, 0.8f);
    public static final Item UBE_BREAD = new FoodItem(settings(), 8, 0.6f);
    public static final Item PUMPKIN_SPICE_COOKIE = new FoodItem(settings(), 3, 0.2f);
    public static final Item CHORUS_FRUIT_PIE = new FoodItem(settings(), 9, 0.5f);
    public static final Item CHOCOLATE_PIE = new FoodItem(settings(), 7, 0.5f);
    public static final Item APPLE_PIE = new FoodItem(settings(), 6, 0.3f);
    public static final Item SWEET_BERRY_PIE = new FoodItem(settings(), 6, 0.3f);
    public static final Item GLOW_BERRY_PIE = new FoodItem(settings(), 6, 0.3f);
    public static final Item GLOOM_BERRY_PIE = new FoodItem(settings(), 6, 0.3f);

    // no tier bottles
    public static final Item CHOCOLATE_MILK = new BottleItem(settings().maxCount(16), 3, 0.3f).setMilk();
    public static final Item APPLE_JUICE = new BottleItem(settings().maxCount(16), 4, 0.3f);
    public static final Item SWEET_BERRY_JUICE = new BottleItem(settings().maxCount(16), 4, 0.3f);
    public static final Item CHORUS_FRUIT_JUICE = new BottleItem(settings().maxCount(16), 4, 0.3f);
    public static final Item WARM_PUMPKIN_SOUP_BOTTLE = new BottleItem(settings().maxCount(16), 9, 0.8f);
    public static final Item GLOOM_BERRY_JUICE = new Tier0Bottle(settings().maxCount(16), 4, 0.3f, StatusEffects.NIGHT_VISION);
    public static final Item ALOE_VERA_JUICE = new Tier0Bottle(settings().maxCount(16), 4, 0.3f, StatusEffects.HEALTH_BOOST);

    // no tier items
    public static final Item CAVE_ROOT_STIR_FRY = new BowlItem(settings(), 10, 0.6f);
    public static final Item COOKED_MONSTER_GUTS = new BowlItem(settings(), 8, 3.8f);
    public static final Item MONSTER_STEW = new BowlItem(settings(), 6, 5.8f);

    public static final Item FRUIT_MIX = new BowlItem(settings(), 6, 0.6f);
    public static final Item VEGETABLE_MIX = new BowlItem(settings(), 6, 0.6f);
    public static final Item SAVORY_BREAKFAST = new BowlItem(settings(), 10, 5.8f);
    public static final Item SAUTEED_EYES = new FoodItem(settings(), 8, 7.8f);

    public static final Item MAGMA_CREME_SOUP = new BowlItem(settings(), 7, 0.6f);
    public static final Item SLIME_SOUP = new BowlItem(settings(), 5, 0.6f);
    public static final Item PUMPKIN_SOUP = new BowlItem(settings(), 8, 0.8f);
    public static final Item FUNGUS_STEW = new BowlItem(settings(), 8, 0.8f);
    public static final Item MUSHROOM_SKEWER = new FoodItem(settings(), 8, 0.8f);

    public static final Item SANDWICH_CHICKEN = new FoodItem(settings(), 10, 0.8f);
    public static final Item SANDWICH_MUTTON = new FoodItem(settings(), 10, 0.8f);
    public static final Item SANDWICH_BEEF = new FoodItem(settings(), 10, 0.8f);
    public static final Item SANDWICH_PORK = new FoodItem(settings(), 10, 0.8f);

    // golden
    public static final Item GOLDEN_WATERMELON_JUICE = new BottleItem(settings(), 2, 1.2f);
    public static final Item GOLDEN_POTATO = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_ALOE_VERA = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_CAVE_ROOT = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_CHORUS_FRUIT = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_ENDURA_CARROT = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_BEETROOT = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_HEARTY_BEETROOT = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_FIRE_PEPPER = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_SWEET_BERRIES = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_GLOW_BERRIES = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_GLOOM_BERRY = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_ANCIENT_MAIZE = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_ONION = new FoodItem(settings(), 4, 1.2f);
    public static final Item GOLDEN_PUMPKIN_SLICE = new FoodItem(settings(), 4, 1.2f);

    /** Called from {@link ModItems} */
    static void initialize() {
        // cooked
        Reg.register("baked_apple", BAKED_APPLE);
        Reg.register("baked_beetroot", BAKED_BEETROOT);
        Reg.register("baked_hearty_beetroot", BAKED_HEARTY_BEETROOT);
        Reg.register("baked_carrot", BAKED_CARROT);
        Reg.register("baked_endura_carrot", BAKED_ENDURA_CARROT);
        Reg.register("baked_fire_pepper", BAKED_FIRE_PEPPER);
        Reg.register("baked_pumpkin_slice", BAKED_PUMPKIN_SLICE);
        Reg.register("baked_ghost_pumpkin_slice", BAKED_GHOST_PUMPKIN_SLICE);
        Reg.register("baked_melon_slice", BAKED_MELON_SLICE);
        Reg.register("baked_onion", BAKED_ONION);
        Reg.register("baked_seeds", BAKED_SEEDS);
        Reg.register("baked_sweet_berries", BAKED_SWEET_BERRIES);
        Reg.register("baked_glow_berries", BAKED_GLOW_BERRIES);
        Reg.register("baked_gloom_berries", BAKED_GLOOM_BERRIES);
        Reg.register("cooked_rice", COOKED_RICE);
        Reg.register("cooked_cave_root", COOKED_CAVE_ROOT);
        
        Reg.register("cooked_squid", COOKED_SQUID);
        Reg.register("cooked_silverfish", COOKED_SILVERFISH);
        Reg.register("cooked_phantom", COOKED_PHANTOM);
        Reg.register("cooked_turtle", COOKED_TURTLE);
        Reg.register("cooked_bird", COOKED_BIRD);
        Reg.register("cooked_bat", COOKED_BAT);
        Reg.register("cooked_bacon", COOKED_BACON);
        Reg.register("fried_egg", FRIED_EGG);
        Reg.register("cooked_rotten_flesh", COOKED_ROTTEN_FLESH);
        Reg.register("cooked_tropical_fish", COOKED_TROPICAL_FISH);
        Reg.register("cooked_beast_liver", BEAST_LIVER_COOKED);

        // pastries
        Reg.register("hardtack", HARDTACK);
        Reg.register("ube_bread", UBE_BREAD);
        Reg.register("pumpkin_spice_cookie", PUMPKIN_SPICE_COOKIE);
        Reg.register("chocolate_pie", CHOCOLATE_PIE);
        Reg.register("apple_pie", APPLE_PIE);
        Reg.register("sweet_berry_pie", SWEET_BERRY_PIE);
        Reg.register("glow_berry_pie", GLOW_BERRY_PIE);
        Reg.register("gloom_berry_pie", GLOOM_BERRY_PIE);
        Reg.register("chorus_fruit_pie", CHORUS_FRUIT_PIE);
        Reg.register("cake_slice", CAKE_SLICE);

        // no tier bottles
        Reg.register("chocolate_milk", CHOCOLATE_MILK);
        Reg.register("aloe_vera_juice", ALOE_VERA_JUICE);
        Reg.register("apple_juice", APPLE_JUICE);
        Reg.register("sweet_berry_juice", SWEET_BERRY_JUICE);
        Reg.register("gloom_berry_juice", GLOOM_BERRY_JUICE);
        Reg.register("chorus_fruit_juice", CHORUS_FRUIT_JUICE);

        //soups
        Reg.register("warm_pumpkin_soup_bottle", WARM_PUMPKIN_SOUP_BOTTLE);

        //no tier
        Reg.register("pumpkin_soup", PUMPKIN_SOUP);
        Reg.register("savory_breakfast", SAVORY_BREAKFAST);
        Reg.register("cave_root_stir_fry", CAVE_ROOT_STIR_FRY);
        Reg.register("fruit_mix", FRUIT_MIX);
        Reg.register("vegetable_mix", VEGETABLE_MIX);

        Reg.register("fungus_stew", FUNGUS_STEW);
        Reg.register("mushroom_skewer", MUSHROOM_SKEWER);

        Reg.register("sandwich_chicken", SANDWICH_CHICKEN);
        Reg.register("sandwich_mutton", SANDWICH_MUTTON);
        Reg.register("sandwich_beef", SANDWICH_BEEF);
        Reg.register("sandwich_pork", SANDWICH_PORK);

        Reg.register("monster_stew", MONSTER_STEW);
        Reg.register("stir_fried_monster_guts", COOKED_MONSTER_GUTS);
        Reg.register("slime_soup", SLIME_SOUP);
        Reg.register("magma_creme_soup", MAGMA_CREME_SOUP);
        Reg.register("sauteed_eyes_and_mushrooms", SAUTEED_EYES);

        //golden
        Reg.register("golden_watermelon_juice", GOLDEN_WATERMELON_JUICE);
        Reg.register("golden_potato", GOLDEN_POTATO);
        Reg.register("golden_endura_carrot", GOLDEN_ENDURA_CARROT);
        Reg.register("golden_beetroot", GOLDEN_BEETROOT);
        Reg.register("golden_hearty_beetroot", GOLDEN_HEARTY_BEETROOT);
        Reg.register("golden_fire_pepper", GOLDEN_FIRE_PEPPER);
        Reg.register("golden_ancient_maize", GOLDEN_ANCIENT_MAIZE);
        Reg.register("golden_onion", GOLDEN_ONION);
        Reg.register("golden_pumpkin_slice", GOLDEN_PUMPKIN_SLICE);
        Reg.register("golden_cave_root", GOLDEN_CAVE_ROOT);
        Reg.register("golden_aloe_vera", GOLDEN_ALOE_VERA);
        Reg.register("golden_sweet_berries", GOLDEN_SWEET_BERRIES);
        Reg.register("golden_glow_berries", GOLDEN_GLOW_BERRIES);
        Reg.register("golden_gloom_berry", GOLDEN_GLOOM_BERRY);
        Reg.register("golden_chorus_fruit", GOLDEN_CHORUS_FRUIT);
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(REGULAR_DISHES);
    }
}
