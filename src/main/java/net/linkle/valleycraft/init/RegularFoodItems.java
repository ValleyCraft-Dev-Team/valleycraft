package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.INGREDIENTS;
import static net.linkle.valleycraft.init.ModGroups.REGULAR_DISHES;

public class RegularFoodItems {

    // cooked
    public static final Item BAKED_APPLE = new FoodItem(settings(), 6, 4.8f);
    public static final Item BAKED_BEETROOT = new FoodItem(settings(), 2, 2.4f);
    public static final Item BAKED_HEARTY_BEETROOT = new FoodItem(settings(), 7, 6);
    public static final Item BAKED_CARROT = new FoodItem(settings(), 5, 4);
    public static final Item BAKED_ENDURA_CARROT = new FoodItem(settings(), 6, 7);
    public static final Item BAKED_FIRE_PEPPER = new FoodItem(settings(), 5, 4);
    public static final Item BAKED_GHOST_PUMPKIN_SLICE = new FoodItem(settings(), 4, 3);
    public static final Item BAKED_PUMPKIN_SLICE = new FoodItem(settings(), 4, 3);
    public static final Item BAKED_MELON_SLICE = new FoodItem(settings(), 3, 2);
    public static final Item BAKED_ONION = new FoodItem(settings(), 4, 3);
    public static final Item BAKED_SEEDS = new FoodItem(settings(), 2, 3);
    public static final Item BAKED_SWEET_BERRIES = new FoodItem(settings(), 4, 2);
    public static final Item BAKED_GLOW_BERRIES = new FoodItem(settings(), 4, 3);
    public static final Item BAKED_GLOOM_BERRIES = new FoodItem(settings(), 4, 3);
    public static final Item COOKED_RICE = new FoodItem(settings(), 4, 6);
    public static final Item COOKED_CAVE_ROOT = new FoodItem(settings(), 5, 2);

    public static final Item COOKED_GLOWSQUID = new FoodItem(settings(), 4, 2.6f);
    public static final Item COOKED_SQUID = new FoodItem(settings(), 4, 2.6f);
    public static final Item COOKED_SILVERFISH = new FoodItem(settings(), 3, 2);
    public static final Item COOKED_PHANTOM = new FoodItem(settings(), 6, 3);
    public static final Item COOKED_TURTLE = new FoodItem(settings(), 8, 2f);
    public static final Item COOKED_BIRD = new FoodItem(settings(), 4, 2);

    // pastries
    public static final Item CAKE_SLICE = new FoodItem(settings(), 2, 0.4f);
    public static final Item HARDTACK = new FoodItem(settings(), 3, 3);
    public static final Item UBE_BREAD = new FoodItem(settings(), 8, 8);
    public static final Item PUMPKIN_SPICE_COOKIE = new FoodItem(settings(), 3, 0.4f);
    public static final Item CHORUS_FRUIT_PIE = new FoodItem(settings(), 9, 4.8f);
    public static final Item CHOCOLATE_PIE = new FoodItem(settings(), 7, 5.8f);
    public static final Item APPLE_PIE = new FoodItem(settings(), 6, 4.8f);
    public static final Item SWEET_BERRY_PIE = new FoodItem(settings(), 6, 3.8f);
    public static final Item GLOW_BERRY_PIE = new FoodItem(settings(), 6, 3.8f);
    public static final Item GLOOM_BERRY_PIE = new FoodItem(settings(), 6, 3.8f);

    // no tier bottles
    public static final Item CHOCOLATE_MILK = new BottleItem(settings(), 3, 2).setMilk();
    public static final Item MILK = new BottleItem(settings(), 2, 2).setMilk();
    public static final Item APPLE_JUICE = new BottleItem(settings(), 4, 2);
    public static final Item SWEET_BERRY_JUICE = new BottleItem(settings(), 4, 2);
    public static final Item CHORUS_FRUIT_JUICE = new BottleItem(settings(), 4, 2);
    public static final Item WARM_PUMPKIN_SOUP_BOTTLE = new BottleItem(settings(), 8, 6);

    // no tier items

    // golden

    /** Called from {@link ModItems} */
    static void initialize() {
        // cooked
        Reg.register("baked_apple", BAKED_APPLE);
        Reg.register("baked_beetroot", BAKED_BEETROOT);
        Reg.register("baked_hearty_beetroot", BAKED_HEARTY_BEETROOT);
        Reg.register("baked_carrot", BAKED_CARROT);
        Reg.register("baked_endura_carrot", BAKED_ENDURA_CARROT);
        Reg.register("baked_fire_pepper", BAKED_FIRE_PEPPER);
        Reg.register("baked_ghost_pumpkin_slice", BAKED_GHOST_PUMPKIN_SLICE);
        Reg.register("baked_pumpkin_slice", BAKED_PUMPKIN_SLICE);
        Reg.register("baked_melon_slice", BAKED_MELON_SLICE);
        Reg.register("baked_onion", BAKED_ONION);
        Reg.register("baked_seeds", BAKED_SEEDS);
        Reg.register("baked_sweet_berries", BAKED_SWEET_BERRIES);
        Reg.register("baked_glow_berries", BAKED_GLOW_BERRIES);
        Reg.register("baked_gloom_berries", BAKED_GLOOM_BERRIES);
        Reg.register("cooked_rice", COOKED_RICE);
        Reg.register("cooked_cave_root", COOKED_CAVE_ROOT);
        
        Reg.register("cooked_glowsquid", COOKED_GLOWSQUID);
        Reg.register("cooked_squid", COOKED_SQUID);
        Reg.register("cooked_silverfish", COOKED_SILVERFISH);
        Reg.register("cooked_phantom", COOKED_PHANTOM);
        Reg.register("cooked_turtle", COOKED_TURTLE);
        Reg.register("cooked_bird", COOKED_BIRD);
        
        // pastries
        Reg.register("cake_slice", CAKE_SLICE);
        Reg.register("hardtack", HARDTACK);
        Reg.register("ube_bread", UBE_BREAD);
        Reg.register("pumpkin_spice_cookie", PUMPKIN_SPICE_COOKIE);
        Reg.register("chorus_fruit_pie", CHORUS_FRUIT_PIE);
        Reg.register("chocolate_pie", CHOCOLATE_PIE);
        Reg.register("apple_pie", APPLE_PIE);
        Reg.register("sweet_berry_pie", SWEET_BERRY_PIE);
        Reg.register("glow_berry_pie", GLOW_BERRY_PIE);
        Reg.register("gloom_berry_pie", GLOOM_BERRY_PIE);
        
        // no tier bottles
        Reg.register("chocolate_milk", CHOCOLATE_MILK);
        Reg.register("milk", MILK);
        Reg.register("apple_juice", APPLE_JUICE);
        Reg.register("sweet_berry_juice", SWEET_BERRY_JUICE);
        Reg.register("chorus_fruit_juice", CHORUS_FRUIT_JUICE);
        Reg.register("warm_pumpkin_soup_bottle", WARM_PUMPKIN_SOUP_BOTTLE);
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(REGULAR_DISHES);
    }
}
