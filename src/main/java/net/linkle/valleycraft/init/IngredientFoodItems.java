package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModFishing.ZOD;
import static net.linkle.valleycraft.init.ModGroups.*;

public class IngredientFoodItems {

    //public static final Item AMETHYSTLE_SALAD = new Tier1Normal(settings(), 4, 2, StatusEffects.HASTE);

    //raw ingredients
    public static final Item ALOE = new AliasedBlockItem(ModNaturalBlocks.ALOE_VERAS, settings().food(Foods.create(3, 1)));
    public static final Item AMETHYSTLE = new FoodItem(settings(), 2, 1);
    public static final Item ANCIENT_FLOWER = new FoodItem(settings(), 6, 2);
    public static final Item CAVE_ROOT = new FoodItem(settings(), 4, 2);
    public static final Item ENDURA_CARROT = new FoodItem(settings(), 5, 3);
    public static final Item FIRE_PEPPER = new FoodItem(settings(), 3, 3);
    public static final Item GLOW_BERRY_JUICE = new Tier0Bottle(settings().maxCount(16), 4, 2, StatusEffects.GLOWING);

    public static final Item HEARTY_BEETROOT = new FoodItem(settings(), 4, 4);
    public static final Item MAIZE = new AliasedBlockItem(ModNaturalBlocks.MAIZE, settings().rarity(Rarity.RARE).food(Foods.create(3, 4)));
    public static final Item MINERS_LETTUCE = new AliasedBlockItem(ModNaturalBlocks.MINERS_LETTUCES, settings().food(Foods.create(3, 2)));
    public static final Item MONSTER_GUTS = new Tier1Normal(settings(), 6, 2, StatusEffects.HUNGER);
    public static final Item MONSTER_LIVER = new Tier1Normal(settings(), 3, 2, StatusEffects.POISON);
    public static final Item SYRUPY_HONEYCOMB = new Tier0Normal(settings(), 3, 2, StatusEffects.REGENERATION);

    public static final Item MOREL_OIL = new Tier1Bottle(settings().maxCount(16), 2, 5, StatusEffects.SLOWNESS);
    public static final Item ONION = new FoodItem(settings(), 3, 3);
    public static final Item RAW_BACON = new FoodItem(settings(), 2, 1);
    public static final Item RAW_BAT = new FoodItem(settings(), 2, 1);
    public static final Item GHOST_PUMPKIN_SLICE = new FoodItem(settings(), 2, 2);
    public static final Item PUMPKIN_SLICE = new FoodItem(settings(), 2, 2);
    public static final Item RAW_GLOWSQUID = new FoodItem(settings(), 2, 1.2f);
    public static final Item RAW_SQUID = new FoodItem(settings(), 2, 1.2f);
    public static final Item RAW_RICE = new FoodItem(settings(), 2, 3);
    public static final Item RAW_SILVERFISH = new FoodItem(settings(), 1, 1);
    public static final Item RAW_PHANTOM = new Tier1Normal(settings(), 3, 1.4f, StatusEffects.NAUSEA);
    public static final Item RAW_BIRD = new FoodItem(settings(), 2, 1);

    public static final Item BREAD_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item CORN_BREAD_DOUGH = new FoodItem(settings(), 2, 4);
    public static final Item CAKE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item HARDTACK_DOUGH = new FoodItem(settings(), 1, 3);
    public static final Item PUMPKIN_SPICE_COOKIE_DOUGH = new FoodItem(settings(), 1, 3);
    public static final Item PUMPKIN_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item COOKIE_DOUGH = new FoodItem(settings(), 1, 3);
    public static final Item CHORUS_FRUIT_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item CHOCOLATE_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item APPLE_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item SWEET_BERRY_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item GLOW_BERRY_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item GLOOM_BERRY_PIE_DOUGH = new FoodItem(settings(), 3, 3);
    public static final Item GLOOM_BERRY = new AliasedBlockItem(ModNaturalBlocks.GLOOM_BERRY, settings().food(FoodComponents.GLOW_BERRIES));
    public static final Item MILK = new BottleItem(settings().maxCount(16), 0, 2).setMilk();
    public static final Item BEAST_LIVER_RAW = new FoodItem(settings(), 4, 0.4f, true);

    //1.1 planned
    //public static final Item MONSTER_FLESH = new Tier2Normal(settings(), 8, 2, StatusEffects.HUNGER);
    //dw its not sea turtles!
    //public static final Item RAW_TURTLE = new FoodItem(settings(), 4, 0.8f);

    /** Called from {@link ModItems} */
    static void initialize() {
        Reg.register("milk", MILK);
        Reg.register("morel_oil", MOREL_OIL);
        Reg.register("glow_berry_juice", GLOW_BERRY_JUICE);

        Reg.register("gloom_berry", GLOOM_BERRY);
        Reg.register("aloe_vera", ALOE);
        Reg.register("amethystle", AMETHYSTLE);
        Reg.register("ancient_flower", ANCIENT_FLOWER);
        Reg.register("cave_root", CAVE_ROOT);
        Reg.register("endura_carrot", ENDURA_CARROT);
        Reg.register("fire_pepper", FIRE_PEPPER);
        Reg.register("hearty_beetroot", HEARTY_BEETROOT);
        Reg.register("maize", MAIZE);
        Reg.register("miners_lettuce", MINERS_LETTUCE);
        Reg.register("onion", ONION);
        Reg.register("raw_rice", RAW_RICE);
        Reg.register("syrupy_honeycomb", SYRUPY_HONEYCOMB);

        Reg.register("pumpkin_slice", PUMPKIN_SLICE);
        Reg.register("ghost_pumpkin_slice", GHOST_PUMPKIN_SLICE);

        Reg.register("monster_guts", MONSTER_GUTS);
        Reg.register("infected_monster_liver", MONSTER_LIVER);
        Reg.register("zod", ZOD);

        Reg.register("raw_bat_wing", RAW_BAT);
        Reg.register("raw_silverfish", RAW_SILVERFISH);
        Reg.register("raw_phantom_eye", RAW_PHANTOM);

        Reg.register("raw_glowsquid_tentacle", RAW_GLOWSQUID);
        Reg.register("raw_squid_tentacle", RAW_SQUID);
        Reg.register("raw_bacon", RAW_BACON);

        Reg.register("raw_bird_thigh", RAW_BIRD);
        Reg.register("raw_beast_liver", BEAST_LIVER_RAW);
        //Reg.register("raw_turtle_neck", RAW_TURTLE);

        Reg.register("hardtack_dough", HARDTACK_DOUGH);
        Reg.register("bread_dough", BREAD_DOUGH);
        Reg.register("corn_bread_dough", CORN_BREAD_DOUGH);
        Reg.register("cookie_dough", COOKIE_DOUGH);
        Reg.register("pumpkin_spice_cookie_dough", PUMPKIN_SPICE_COOKIE_DOUGH);

        Reg.register("pumpkin_pie_dough", PUMPKIN_PIE_DOUGH);
        Reg.register("chocolate_pie_dough", CHOCOLATE_PIE_DOUGH);
        Reg.register("apple_pie_dough", APPLE_PIE_DOUGH);
        Reg.register("sweet_berry_pie_dough", SWEET_BERRY_PIE_DOUGH);
        Reg.register("glow_berry_pie_dough", GLOW_BERRY_PIE_DOUGH);
        Reg.register("gloom_berry_pie_dough", GLOOM_BERRY_PIE_DOUGH);
        Reg.register("chorus_fruit_pie_dough", CHORUS_FRUIT_PIE_DOUGH);

        Reg.register("cake_dough", CAKE_DOUGH);

        //Reg.register("monster_flesh", MONSTER_FLESH);
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
