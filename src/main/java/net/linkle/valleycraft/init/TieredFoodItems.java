package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.Tier1Normal;
import net.linkle.valleycraft.item.Tier2Normal;
import net.linkle.valleycraft.item.Tier3Bowl;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.TIERED_DISHES;

import net.linkle.valleycraft.Main;

public enum TieredFoodItems implements ItemEnum {
    
    // tier 1
    AMETHYSTLE_SALAD(new Tier1Normal(settings(), 5, 2, StatusEffects.HASTE)),
    CARROT_SALAD(new Tier1Normal(settings(), 5, 2, StatusEffects.SPEED)),
    DRIED_SPICY_GLOW_BERRIES(new Tier1Normal(settings(), 5, 2, StatusEffects.NIGHT_VISION)),
    FRUIT_AND_VEGGIE_MIX(new Tier1Normal(settings(), 5, 2, StatusEffects.HEALTH_BOOST)),
    HEARTY_SKEWER(new Tier1Normal(settings(), 5, 2, StatusEffects.STRENGTH)),
    HONEYED_APPLE(new Tier1Normal(settings(), 5, 2, StatusEffects.REGENERATION)),
    SAVORY_SHROOM_SKEWER(new Tier1Normal(settings(), 5, 2, StatusEffects.RESISTANCE)),
    SHIVERCAP_SKEWER(new Tier1Normal(settings(), 5, 2, StatusEffects.FIRE_RESISTANCE)),
    SPICY_CALAMARI_SKEWER(new Tier1Normal(settings(), 5, 2, StatusEffects.WATER_BREATHING)),
    
    // tier 2
    GLOW_BERRY_EGG_PUDDING(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.NIGHT_VISION)),
    GLOW_SQUID_SUSHI(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.WATER_BREATHING)),
    HONEY_GLAZED_CREPE(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.REGENERATION)),
    SPICY_GRILLED_LAMB(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.HASTE)),
    SPICY_SALMON_AND_CARROTS(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.SPEED)),
    STEAMED_VEGETABLES(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.HEALTH_BOOST)),
    STUFFED_BAKED_POTATO(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.STRENGTH)),
    STUFFED_ONION(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.RESISTANCE)),
    SWEET_RABBIT_STEAK(new Tier2Normal(settings().maxCount(32), 6, 2, StatusEffects.FIRE_RESISTANCE)),
    
    // tier 3
    ANCIENT_FLOWER_SOUP(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.HEALTH_BOOST)),
    CARROT_STEW(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.SPEED)),
    COD_CHOWDER(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.RESISTANCE)),
    CREAMY_HEART_STEW(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.STRENGTH)),
    GLOW_BERRY_STEW(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.NIGHT_VISION)),
    GLOW_SQUID_SOUP(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.WATER_BREATHING)),
    SHIVERCAP_STIR_FRY(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.FIRE_RESISTANCE)),
    SPICY_BEEF_RISOTTO(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.HASTE)),
    SWEET_CHICKEN_RISOTTO(new Tier3Bowl(settings().maxCount(16), 8, 2, StatusEffects.REGENERATION));
    
    /** Called from {@link ModItems} */
    static void initialize() {
    }
    
    private static Item.Settings settings() {
        return new Item.Settings().group(TIERED_DISHES);
    }
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    TieredFoodItems(Item item) {
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
