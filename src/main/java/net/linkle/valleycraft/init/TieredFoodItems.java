package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.Tier1Normal;
import net.linkle.valleycraft.item.Tier2Normal;
import net.linkle.valleycraft.item.Tier3Bowl;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

public class TieredFoodItems {
    
    // tier 1
    public static final Item AMETHYSTLE_SALAD = new Tier1Normal(settings(), 4, 2, StatusEffects.HASTE);
    public static final Item CARROT_SALAD = new Tier1Normal(settings(), 4, 2, StatusEffects.SPEED);
    public static final Item DRIED_SPICY_GLOW_BERRIES = new Tier1Normal(settings(), 4, 2, StatusEffects.NIGHT_VISION);
    public static final Item FRUIT_AND_VEGGIE_MIX = new Tier1Normal(settings(), 4, 2, StatusEffects.HEALTH_BOOST);
    public static final Item HEARTY_SKEWER = new Tier1Normal(settings(), 4, 2, StatusEffects.STRENGTH);
    public static final Item HONEYED_APPLE = new Tier1Normal(settings(), 4, 2, StatusEffects.REGENERATION);
    public static final Item SAVORY_SHROOM_SKEWER = new Tier1Normal(settings(), 4, 2, StatusEffects.RESISTANCE);
    public static final Item SHIVERCAP_SKEWER = new Tier1Normal(settings(), 4, 2, StatusEffects.FIRE_RESISTANCE);
    public static final Item SPICY_CALAMARI_SKEWER = new Tier1Normal(settings(), 4, 2, StatusEffects.WATER_BREATHING);
    
    // tier 2
    public static final Item GLOW_BERRY_EGG_PUDDING = new Tier2Normal(settings(), 4, 2, StatusEffects.NIGHT_VISION);
    public static final Item GLOW_SQUID_SUSHI = new Tier2Normal(settings(), 4, 2, StatusEffects.WATER_BREATHING);
    public static final Item HONEY_GLAZED_CREPE = new Tier2Normal(settings(), 4, 2, StatusEffects.REGENERATION);
    public static final Item SPICY_GRILLED_LAMB = new Tier2Normal(settings(), 4, 2, StatusEffects.HASTE);
    public static final Item SPICY_SALMON_AND_CARROTS = new Tier2Normal(settings(), 4, 2, StatusEffects.SPEED);
    public static final Item STEAMED_VEGETABLES = new Tier2Normal(settings(), 4, 2, StatusEffects.HEALTH_BOOST);
    public static final Item STUFFED_BAKED_POTATO = new Tier2Normal(settings(), 4, 2, StatusEffects.STRENGTH);
    public static final Item STUFFED_ONION = new Tier2Normal(settings(), 4, 2, StatusEffects.RESISTANCE);
    public static final Item SWEET_RABBIT_STEAK = new Tier2Normal(settings(), 4, 2, StatusEffects.FIRE_RESISTANCE);
    
    // tier 3
    public static final Item ANCIENT_FLOWER_SOUP = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.HEALTH_BOOST);
    public static final Item CARROT_STEW = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.SPEED);
    public static final Item COD_CHOWDER = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.RESISTANCE);
    public static final Item CREAMY_HEART_STEW = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.STRENGTH);
    public static final Item GLOW_BERRY_STEW = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.NIGHT_VISION);
    public static final Item GLOW_SQUID_SOUP = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.WATER_BREATHING);
    public static final Item SHIVERCAP_STIR_FRY = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.FIRE_RESISTANCE);
    public static final Item SPICY_BEEF_RISOTTO = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.HASTE);
    public static final Item SWEET_CHICKEN_RISOTTO = new Tier3Bowl(settings().maxCount(16), 4, 2, StatusEffects.REGENERATION);
    
    /** Called from ModItem */
    static void initialize() {
        // tier 1
        Reg.register("amethystle_salad", AMETHYSTLE_SALAD);
        Reg.register("carrot_salad", CARROT_SALAD);
        Reg.register("dried_spicy_glow_berries", DRIED_SPICY_GLOW_BERRIES);
        Reg.register("fruit_and_veggie_mix", FRUIT_AND_VEGGIE_MIX);
        Reg.register("hearty_skewer", HEARTY_SKEWER);
        Reg.register("honeyed_apple", HONEYED_APPLE);
        Reg.register("savory_shroom_skewer", SAVORY_SHROOM_SKEWER);
        Reg.register("shivercap_skewer", SHIVERCAP_SKEWER);
        Reg.register("spicy_calamari_skewer", SPICY_CALAMARI_SKEWER);
        
        // tier 2
        Reg.register("glow_berry_egg_pudding", GLOW_BERRY_EGG_PUDDING);
        Reg.register("glow_squid_sushi", GLOW_SQUID_SUSHI);
        Reg.register("honey_glazed_crepe", HONEY_GLAZED_CREPE);
        Reg.register("spicy_grilled_lamb", SPICY_GRILLED_LAMB);
        Reg.register("spicy_salmon_and_carrots", SPICY_SALMON_AND_CARROTS);
        Reg.register("steamed_vegetables", STEAMED_VEGETABLES);
        Reg.register("stuffed_baked_potato", STUFFED_BAKED_POTATO);
        Reg.register("stuffed_onion", STUFFED_ONION);
        Reg.register("sweet_rabbit_steak", SWEET_RABBIT_STEAK);
        
        // tier 3
        Reg.register("ancient_flower_soup", ANCIENT_FLOWER_SOUP);
        Reg.register("carrot_stew", CARROT_STEW);
        Reg.register("cod_chowder", COD_CHOWDER);
        Reg.register("creamy_heart_stew", CREAMY_HEART_STEW);
        Reg.register("glow_berry_stew", GLOW_BERRY_STEW);
        Reg.register("glow_squid_soup", GLOW_SQUID_SOUP);
        Reg.register("shivercap_stir_fry", SHIVERCAP_STIR_FRY);
        Reg.register("spicy_beef_risotto", SPICY_BEEF_RISOTTO);
        Reg.register("sweet_chicken_risotto", SWEET_CHICKEN_RISOTTO);
    }
    
    private static Item.Settings settings() {
        return new Item.Settings().group(ModGroups.TIERED_DISHES);
    }
}
