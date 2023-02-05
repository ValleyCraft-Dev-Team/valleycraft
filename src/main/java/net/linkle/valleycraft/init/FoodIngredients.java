package net.linkle.valleycraft.init;

import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.Groups.*;

import net.linkle.valleycraft.Main;

public enum FoodIngredients implements ItemEnum {

    MILK(new BottleItem(settings().recipeRemainder(net.minecraft.item.Items.GLASS_BOTTLE).maxCount(16), 0, 0.2f).setMilk()),
    MOREL_OIL(new Tier1Bottle(settings().recipeRemainder(net.minecraft.item.Items.GLASS_BOTTLE).maxCount(16), 2, 5, StatusEffects.SLOWNESS).hideTooltip()),
    BUTTER(new FoodItem(settings(), 0, 0.2f)),

    GLOW_BERRY_JUICE(new GlintBottleItem(settings().recipeRemainder(net.minecraft.item.Items.GLASS_BOTTLE).maxCount(16), 4, 0.5f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip", Formatting.GRAY).addText("item.valleycraft.dishes.tooltip_8", Formatting.GRAY)),

    ALOE_VERA(new AliasedBlockItem(BlocksNatural.ALOE_VERAS.block, settings().food(Foods.create(3, 0.3f)))),
    
    AMETHYSTLE(new FoodItem(settings(), 2, 0.3f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_10")),

    ENDURA_CARROT(new FoodItem(settings(), 5, 0.3f,  new FoodStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_9")),
    HEARTY_BEETROOT(new FoodItem(settings(), 4, 0.6f,  new FoodStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5 * 20)))
            .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_6")),
    ONION(new FoodItem(settings(), 3, 0.3f)),

    //dropped by husk
    FIRE_PEPPER(new FoodItem(settings(), 3, 0.3f)),

    //desert temple
    MAIZE(new AliasedBlockItem(BlocksNatural.MAIZE.block, settings().rarity(Rarity.RARE).food(Foods.create(3, 0.3f)))),
    ANCIENT_FLOWER(new FoodItem(settings(), 6, 0.7f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 5 * 20)))
            .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_7")),

    //dropped by miner zombie
    CAVE_ROOT(new FoodItem(settings(), 4, 0.3f)),
    MINERS_LETTUCE(new AliasedBlockItem(BlocksNatural.MINERS_LETTUCES.block, settings().food(Foods.create(3, 0.3f)))),

    //jungle temple
    RAW_RICE(new FoodItem(settings(), 2, 0.3f)),
    
    SYRUPY_HONEYCOMB(new FoodItem(settings(), 3, 0.6f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_5")),
    
    PUMPKIN_SLICE(new FoodItem(settings(), 2, 0.4f)),

    RAW_ABYSSWATCHER(new FoodItem(settings(), 3, 0.5f)),
    RAW_STONEROLLER_MINNOW(new FoodItem(settings(), 1, 0.2f)),
    RAW_RED_PORGY(new FoodItem(settings(), 2, 0.5f)),
    RAW_PERCH(new FoodItem(settings(), 2, 0.4f)),

    RAW_SQUID_TENTACLE(new FoodItem(settings(), 2, 0.3f)),
    RAW_GLOWSQUID_TENTACLE(new FoodItem(settings(), 2, 0.2f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 5 * 20)))
            .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_4")),

    //RAW_LOBSTER(new NegativeFoodItem_3_Effects(settings(), 3, 0.2f, StatusEffects.HUNGER, StatusEffects.POISON, StatusEffects.NAUSEA).hideTooltip()),
    //RAW_MOSSY_CRAB(new NegativeFoodItem_3_Effects(settings(), 3, 0.2f, StatusEffects.HUNGER, StatusEffects.POISON, StatusEffects.NAUSEA).hideTooltip()),

    RAW_BACON(new FoodItem(settings(), 2, 0.2f, true)),
    
    RAW_BIRD_THIGH(new FoodItem(settings(), 2, 0.2f)),
    RAW_BEAST_LIVER(new FoodItem(settings(), 4, 0.4f, true)),
    RAW_BAT_WING(new FoodItem(settings(), 2, 0.1f)),
    RAW_SILVERFISH(new FoodItem(settings(), 1, 0.1f)),
    RAW_PHANTOM_EYE(new NegativeFoodItem_2_Effects(settings(), 3, 0.3f, StatusEffects.NAUSEA, StatusEffects.NIGHT_VISION).hideTooltip()),
    RAW_TRIPE(new NegativeFoodItem_2_Effects(settings(), 6, 0.3f, StatusEffects.HUNGER, StatusEffects.NAUSEA).hideTooltip()),
    RAW_BEAST_HEART(new FoodItem(settings(), 6, 0.4f, true)),
    MONSTER_HEART(new NegativeFoodItem_2_Effects(settings(), 8, 0.3f, StatusEffects.MINING_FATIGUE, StatusEffects.HUNGER).hideTooltip()),
    INFECTED_MONSTER_HEART(new NegativeFoodItem_3_Effects(settings(), 6, 0.3f, StatusEffects.MINING_FATIGUE, StatusEffects.HUNGER, ModEffects.ROT_BLIGHT).hideTooltip()),
    MONSTER_GUTS(new NegativeFoodItem_2_Effects(settings(), 6, 0.3f, StatusEffects.BLINDNESS, StatusEffects.HUNGER).hideTooltip()),
    INFECTED_MONSTER_GUTS(new NegativeFoodItem_3_Effects(settings(), 6, 0.3f, StatusEffects.BLINDNESS, StatusEffects.HUNGER, ModEffects.ROT_BLIGHT).hideTooltip()),
    MONSTER_LIVER(new NegativeFoodItem_2_Effects(settings(), 3, 0.4f, StatusEffects.NAUSEA, StatusEffects.HUNGER).hideTooltip()),
    INFECTED_MONSTER_LIVER(new NegativeFoodItem_3_Effects(settings(), 3, 0.4f, StatusEffects.NAUSEA, StatusEffects.HUNGER, ModEffects.ROT_BLIGHT).hideTooltip()),
    ZOD(new NegativeFoodItem_3_Effects(settings().group(Groups.INGREDIENTS), 5, 2, StatusEffects.HUNGER, ModEffects.ROT_BLIGHT, StatusEffects.NAUSEA).hideTooltip()),
    RAW_ENDERMAN_EYE(new Tier1Normal(settings(), 3, 0.3f, StatusEffects.WEAKNESS).hideTooltip()),
    ENDER_DRAGON_EYE(new EnderDragonEyeFoodItem(settings().rarity(Rarity.EPIC).fireproof(), 3, 0.4f, StatusEffects.POISON, StatusEffects.BLINDNESS, ModEffects.ROT_BLIGHT).hideTooltip()),
    ENDER_DRAGON_GLAND(new NegativeFoodItem_3_Effects(settings().rarity(Rarity.EPIC).fireproof(), 6, 0.3f, StatusEffects.BLINDNESS, StatusEffects.HUNGER, StatusEffects.NAUSEA).hideTooltip()),
    RAW_ENDERMITE(new EndermiteFoodItem(settings(), 3, 0.4f, StatusEffects.POISON, StatusEffects.BLINDNESS, StatusEffects.NAUSEA).hideTooltip()),

    HARDTACK_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    BREAD_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CORN_BREAD_DOUGH(new FoodItem(settings(), 2, 0.2f)),
    COOKIE_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    CHOCOLATE_CHUNK_COOKIE_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    PUMPKIN_SPICE_COOKIE_DOUGH(new FoodItem(settings(), 1, 0.2f)),
    PUMPKIN_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CHOCOLATE_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    APPLE_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    SWEET_BERRY_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    GLOW_BERRY_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CHORUS_FRUIT_PIE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    ENCHANTED_APPLE_PIE_DOUGH(new EnchantedFoodItemNoEffect(settings(), 3, 0.2f)),
    CAKE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    CHOCOLATE_CAKE_DOUGH(new FoodItem(settings(), 3, 0.2f)),
    VANILLA_FROSTING(new BowlItem(settings().maxCount(1).recipeRemainder(Items.BOWL), 4, 0.1f));
    /** Called from {@link ItemsModded} */
    static void initialize() {
        
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(INGREDIENTS);
    }

    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    private FoodIngredients(Item item) {
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
