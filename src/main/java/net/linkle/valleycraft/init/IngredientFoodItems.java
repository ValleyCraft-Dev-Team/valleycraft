package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.*;

import net.linkle.valleycraft.Main;

public enum IngredientFoodItems implements ItemEnum {

    //AMETHYSTLE_SALAD(new Tier1Normal(settings(), 4, 2, StatusEffects.HASTE);
    
    MILK(new BottleItem(settings().maxCount(16), 0, 0.2f).setMilk()),
    MOREL_OIL(new Tier1Bottle(settings().maxCount(16), 2, 5, StatusEffects.SLOWNESS)),
    
    GLOW_BERRY_JUICE(new BottleItem(settings().maxCount(16), 4, 0.5f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 15 * 20)))
    .addText("item.valleycraft.dishes.tooltip", Formatting.GRAY).addText("item.valleycraft.dishes.tooltip_8", Formatting.GRAY)),

    GLOOM_BERRY(new AliasedBlockItem(NaturalBlocks.GLOOM_BERRY.block, settings().food(FoodComponents.GLOW_BERRIES))),
    ALOE_VERA(new AliasedBlockItem(NaturalBlocks.ALOE_VERAS.block, settings().food(Foods.create(3, 0.3f)))),
    
    AMETHYSTLE(new FoodItem(settings(), 2, 0.3f)
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_10")),
    
    ANCIENT_FLOWER(new FoodItem(settings(), 6, 0.7f)
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_7")),
    
    CAVE_ROOT(new FoodItem(settings(), 4, 0.3f)),
    
    ENDURA_CARROT(new FoodItem(settings(), 5, 0.3f)
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_9")),
    
    FIRE_PEPPER(new FoodItem(settings(), 3, 0.3f)),
    
    HEARTY_BEETROOT(new FoodItem(settings(), 4, 0.6f)
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_6")),
    
    MAIZE(new AliasedBlockItem(NaturalBlocks.MAIZE.block, settings().rarity(Rarity.RARE).food(Foods.create(3, 0.3f)))),
    MINERS_LETTUCE(new AliasedBlockItem(NaturalBlocks.MINERS_LETTUCES.block, settings().food(Foods.create(3, 0.3f)))),
    ONION(new FoodItem(settings(), 3, 0.3f)),
    RAW_RICE(new FoodItem(settings(), 2, 0.3f)),
    
    SYRUPY_HONEYCOMB(new FoodItem(settings(), 3, 0.6f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_5")),
    
    PUMPKIN_SLICE(new FoodItem(settings(), 2, 0.4f)),
    GHOST_PUMPKIN_SLICE(new FoodItem(settings(), 2, 0.4f)),
    MONSTER_GUTS(new Tier1Normal(settings(), 6, 0.3f, StatusEffects.HUNGER)),
    INFECTED_MONSTER_LIVER(new Tier1Normal(settings(), 3, 0.4f, StatusEffects.POISON)),
    ZOD(new Tier1Normal(settings().group(ModGroups.INGREDIENTS), 5, 2, StatusEffects.HUNGER)),
    
    RAW_BAT_WING(new FoodItem(settings(), 2, 0.1f)),
    RAW_SILVERFISH(new FoodItem(settings(), 1, 0.1f)),
    RAW_PHANTOM_EYE(new Tier1Normal(settings(), 3, 0.3f, StatusEffects.NAUSEA)),
    
    RAW_GLOWSQUID_TENTACLE(new FoodItem(settings(), 2, 0.2f)
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_4")),
    
    RAW_SQUID_TENTACLE(new FoodItem(settings(), 2, 0.3f)),
    RAW_BACON(new FoodItem(settings(), 2, 0.2f)),
    
    RAW_BIRD_THIGH(new FoodItem(settings(), 2, 0.2f)),
    RAW_BEAST_LIVER(new FoodItem(settings(), 4, 0.4f, true)),
    RAW_BEAST_HEART(new FoodItem(settings(), 6, 0.4f, true)),

    HARDTACK_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    BREAD_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CORN_BREAD_DOUGH(new FoodItem(settings(), 2, 0.2f)),
    COOKIE_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    PUMPKIN_SPICE_COOKIE_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    PUMPKIN_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CHOCOLATE_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    APPLE_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    SWEET_BERRY_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    GLOW_BERRY_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    GLOOM_BERRY_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CHORUS_FRUIT_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CAKE_DOUGH(new FoodItem(settings(), 3, 0.2f));

    //1.1 planned
    //MONSTER_FLESH(new Tier2Normal(settings(), 8, 2, StatusEffects.HUNGER)),
    //dw its not sea turtles!
    //RAW_TURTLE(new FoodItem(settings(), 4, 0.8f)),

    /** Called from {@link ModItems} */
    static void initialize() {
        
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(INGREDIENTS);
    }
    
    
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    private IngredientFoodItems(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }
    
    @Override
    public Item asItem() {
        return item;
    }
}
