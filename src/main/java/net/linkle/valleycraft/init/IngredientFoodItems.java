package net.linkle.valleycraft.init;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.linkle.valleycraft.block.CheeseBlock;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.*;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.*;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.*;

import net.linkle.valleycraft.Main;

public enum IngredientFoodItems implements ItemEnum {

    MILK(new BottleItem(settings().maxCount(16), 0, 0.2f).setMilk()),
    CHEESE_SLICE(new FoodItem(settings(), 2, 0.4f)),
    MOREL_OIL(new Tier1Bottle(settings().maxCount(16), 2, 5, StatusEffects.SLOWNESS).hideTooltip()),

    GLOW_BERRY_JUICE(new GlintBottleItem(settings().maxCount(16), 4, 0.5f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip", Formatting.GRAY).addText("item.valleycraft.dishes.tooltip_8", Formatting.GRAY)),

    ALOE_VERA(new AliasedBlockItem(ModNaturalBlocks.ALOE_VERAS.block, settings().food(Foods.create(3, 0.3f)))),
    
    AMETHYSTLE(new FoodItem(settings(), 2, 0.3f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_10")),
    
    ANCIENT_FLOWER(new FoodItem(settings(), 6, 0.7f, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_7")),
    
    CAVE_ROOT(new FoodItem(settings(), 4, 0.3f)),
    
    ENDURA_CARROT(new FoodItem(settings(), 5, 0.3f,  new FoodStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_9")),
    
    FIRE_PEPPER(new FoodItem(settings(), 3, 0.3f)),
    
    HEARTY_BEETROOT(new FoodItem(settings(), 4, 0.6f,  new FoodStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5 * 20)))
    .addText("item.valleycraft.dishes.tooltip").addText("item.valleycraft.dishes.tooltip_6")),
    
    MAIZE(new AliasedBlockItem(ModNaturalBlocks.MAIZE.block, settings().rarity(Rarity.RARE).food(Foods.create(3, 0.3f)))),
    MINERS_LETTUCE(new AliasedBlockItem(ModNaturalBlocks.MINERS_LETTUCES.block, settings().food(Foods.create(3, 0.3f)))),
    ONION(new FoodItem(settings(), 3, 0.3f)),
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
    ZOD(new NegativeFoodItem_3_Effects(settings().group(ModGroups.INGREDIENTS), 5, 2, StatusEffects.HUNGER, ModEffects.ROT_BLIGHT, StatusEffects.NAUSEA).hideTooltip()),
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
    CAKE_DOUGH(new FoodItem(settings(), 3, 0.2f));

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

    @Override
    public Identifier getId() {
        return id;
    }
}
