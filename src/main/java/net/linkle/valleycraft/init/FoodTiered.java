package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.Groups.TIERED_DISHES;

import net.linkle.valleycraft.Main;

public enum FoodTiered implements ItemEnum {

    /**recipes done**/
    // tier 1
    AMETHYSTLE_SALAD(new Tier1Bowl(settings(), 6  , 0.4f, StatusEffects.HASTE)),
    CARROT_SALAD(new Tier1Bowl(settings(), 6, 0.4f, StatusEffects.SPEED)),
    DRIED_SPICY_GLOW_BERRIES(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.NIGHT_VISION)),
    FRUIT_AND_VEGGIE_MIX(new Tier1Bowl(settings(), 6, 0.4f, StatusEffects.HEALTH_BOOST)),
    HEARTY_SKEWER(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.STRENGTH)),
    HONEYED_APPLE(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.REGENERATION)),
    SAVORY_SHROOM_SKEWER(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.RESISTANCE)),
    SHIVERCAP_SKEWER(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.FIRE_RESISTANCE)),
    SPICY_CALAMARI_SKEWER(new Tier1Normal(settings(), 6, 0.4f, StatusEffects.WATER_BREATHING)),
    
    // tier 2
    SPICY_GRILLED_LAMB(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.HASTE)),
    SPICY_SALMON_AND_CARROTS(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.SPEED)),
    GLOW_BERRY_EGG_PUDDING(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.NIGHT_VISION)),
    STEAMED_VEGETABLES(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.HEALTH_BOOST)),
    STUFFED_BAKED_POTATO(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.STRENGTH)),
    HONEY_GLAZED_CREPE(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.REGENERATION)),
    STUFFED_ONION(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.RESISTANCE)),
    SWEET_RABBIT_STEAK(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.FIRE_RESISTANCE)),
    GLOW_SQUID_SUSHI(new Tier2Bowl(settings().maxCount(32), 8, 0.4f, StatusEffects.WATER_BREATHING)),

    // tier 3
    SPICY_BEEF_RISOTTO(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.HASTE)),
    CARROT_STEW(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.SPEED)),
    GLOW_BERRY_STEW(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.NIGHT_VISION)),
    ANCIENT_FLOWER_SOUP(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.HEALTH_BOOST)),
    CREAMY_HEART_STEW(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.STRENGTH)),
    SWEET_CHICKEN_RISOTTO(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.REGENERATION)),
    COD_CHOWDER(new Tier3Bowl(settings().maxCount(16), 10, 2, StatusEffects.RESISTANCE)),
    SHIVERCAP_STIR_FRY(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.FIRE_RESISTANCE)),
    GLOW_SQUID_SOUP(new Tier3Bowl(settings().maxCount(16), 10, 0.6f, StatusEffects.WATER_BREATHING));

    /**list new items below here, move above after adding a recipe for them**/

    /** Called from {@link ItemsModded} */
    static void initialize() {
    }
    
    private static Item.Settings settings() {
        return new Item.Settings().group(TIERED_DISHES);
    }
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    FoodTiered(Item item) {
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
