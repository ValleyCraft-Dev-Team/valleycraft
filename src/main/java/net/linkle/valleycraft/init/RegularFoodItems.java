package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.linkle.valleycraft.init.ModGroups.REGULAR_DISHES;
import static net.minecraft.util.Rarity.EPIC;
import static net.minecraft.util.Rarity.UNCOMMON;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.item.cultural_drinks.ElixerBottleItemMoblin;
import net.linkle.valleycraft.item.cultural_drinks.ElixerBottleItemPillager;
import net.linkle.valleycraft.item.cultural_drinks.ElixerBottleItemVillager;
import net.linkle.valleycraft.util.ItemEnum;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum RegularFoodItems implements ItemEnum {

    // cooked
    BAKED_APPLE(new FoodItem(settings(), 6, 0.6f)),
    BAKED_BEETROOT(new FoodItem(settings(), 2, 0.6f)),
    BAKED_HEARTY_BEETROOT(new FoodItem(settings(), 7, 0.6f)),
    BAKED_CARROT(new FoodItem(settings(), 5, 0.6f)),
    BAKED_ENDURA_CARROT(new FoodItem(settings(), 6, 0.6f)),
    BAKED_FIRE_PEPPER(new FoodItem(settings(), 5, 0.6f)),
    BAKED_GHOST_PUMPKIN_SLICE(new FoodItem(settings(), 4, 0.6f)),
    BAKED_PUMPKIN_SLICE(new FoodItem(settings(), 4, 0.6f)),
    BAKED_MELON_SLICE(new FoodItem(settings(), 3, 0.6f)),
    BAKED_ONION(new FoodItem(settings(), 4, 0.6f)),
    BAKED_SEEDS(new FoodItem(settings(), 2, 0.6f)),
    BAKED_SWEET_BERRIES(new FoodItem(settings(), 4, 0.6f)),
    BAKED_GLOW_BERRIES(new FoodItem(settings(), 4, 0.6f)),
    BAKED_GLOOM_BERRIES(new FoodItem(settings(), 4, 0.6f)),
    COOKED_RICE(new FoodItem(settings(), 4, 0.6f)),
    COOKED_CAVE_ROOT(new FoodItem(settings(), 5, 0.6f)),

    COOKED_SQUID(new FoodItem(settings(), 4, 0.6f)),
    COOKED_SILVERFISH(new FoodItem(settings(), 3, 0.6f)),
    COOKED_PHANTOM(new FoodItem(settings(), 6, 0.6f)),
    COOKED_BIRD(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BACON(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BAT(new FoodItem(settings(), 5, 0.6f, true)),
    FRIED_EGG(new FoodItem(settings(), 4, 0.6f)),
    COOKED_ROTTEN_FLESH(new FoodItem(settings(), 6, 0.4f,true)),
    COOKED_TROPICAL_FISH(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BEAST_LIVER(new FoodItem(settings(), 8, 0.4f, true)),

    // pastries
    CAKE_SLICE(new FoodItem(settings(), 2, 0.1f)),
    HARDTACK(new FoodItem(settings(), 3, 0.8f)),
    CORN_BREAD(new FoodItem(settings(), 3, 0.9f)),
    PUMPKIN_SPICE_COOKIE(new FoodItem(settings(), 3, 0.2f)),
    CHORUS_FRUIT_PIE(new FoodItem(settings(), 9, 0.5f)),
    CHOCOLATE_PIE(new FoodItem(settings(), 7, 0.5f)),
    APPLE_PIE(new FoodItem(settings(), 6, 0.3f)),
    SWEET_BERRY_PIE(new FoodItem(settings(), 6, 0.3f)),
    GLOW_BERRY_PIE(new FoodItem(settings(), 6, 0.3f)),
    GLOOM_BERRY_PIE(new FoodItem(settings(), 6, 0.3f)),

    // no tier bottles
    CHOCOLATE_MILK(new BottleItem(settings().maxCount(16), 3, 0.3f).setMilk()),
    APPLE_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    SWEET_BERRY_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    CHORUS_FRUIT_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    WARM_PUMPKIN_SOUP_BOTTLE(new BottleItem(settings().maxCount(16), 9, 0.8f)),
    GLOOM_BERRY_JUICE(new Tier0Bottle(settings().maxCount(16), 4, 0.3f, StatusEffects.NIGHT_VISION)),
    ALOE_VERA_JUICE(new Tier0Bottle(settings().maxCount(16), 4, 0.3f, StatusEffects.HEALTH_BOOST)),

    // no tier items
    CAVE_ROOT_STIR_FRY(new BowlItem(settings(), 10, 0.6f)),
    STIR_FRIED_MONSTER_GUTS(new BowlItem(settings(), 8, 3.8f)),
    MONSTER_STEW(new BowlItem(settings(), 6, 5.8f)),

    FRUIT_MIX(new BowlItem(settings(), 6, 0.6f)),
    VEGETABLE_MIX(new BowlItem(settings(), 6, 0.6f)),
    SAVORY_BREAKFAST(new BowlItem(settings(), 10, 5.8f)),
    SAUTEED_EYES_AND_MUSHROOMS(new FoodItem(settings(), 8, 7.8f)),

    MAGMA_CREME_SOUP(new BowlItem(settings(), 7, 0.6f)),
    SLIME_SOUP(new BowlItem(settings(), 5, 0.6f)),
    PUMPKIN_SOUP(new BowlItem(settings(), 8, 0.8f)),
    FUNGUS_STEW(new BowlItem(settings(), 8, 0.8f)),
    MUSHROOM_SKEWER(new FoodItem(settings(), 8, 0.8f)),

    SANDWICH_CHICKEN(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_MUTTON(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_BEEF(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_PORK(new FoodItem(settings(), 10, 0.8f)),

    // golden
    GOLDEN_WATERMELON_JUICE(new BottleItem(settings(), 2, 1.2f)),
    GOLDEN_POTATO(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_ALOE_VERA(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_CAVE_ROOT(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_CHORUS_FRUIT(new FoodItem(settings().rarity(Rarity.RARE), 4, 1.2f)),
    GOLDEN_ENDURA_CARROT(new FoodItem(settings().rarity(Rarity.RARE), 4, 1.2f)),
    GOLDEN_BEETROOT(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_HEARTY_BEETROOT(new FoodItem(settings().rarity(Rarity.RARE), 4, 1.2f)),
    GOLDEN_FIRE_PEPPER(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_SWEET_BERRIES(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_GLOW_BERRIES(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_GLOOM_BERRY(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_ANCIENT_MAIZE(new FoodItem(settings().rarity(Rarity.RARE), 4, 1.2f)),
    GOLDEN_ONION(new FoodItem(settings(), 4, 1.2f)),
    GOLDEN_PUMPKIN_SLICE(new FoodItem(settings(), 4, 1.2f)),

    //special items
    VILLAGER_ELIXER(new ElixerBottleItemVillager(settings().maxCount(1).rarity(UNCOMMON).group(BOOKS), 0, 0, StatusEffects.REGENERATION, StatusEffects.NAUSEA, StatusEffects.SLOWNESS)),
    MOBLIN_ELIXER(new ElixerBottleItemMoblin(settings().maxCount(1).rarity(UNCOMMON).group(BOOKS), 0, 0, StatusEffects.NIGHT_VISION, StatusEffects.NAUSEA, StatusEffects.POISON)),
    PILLAGER_TONIC(new ElixerBottleItemPillager(settings().maxCount(1).rarity(UNCOMMON).group(BOOKS), 0, 0, StatusEffects.STRENGTH, StatusEffects.NAUSEA, StatusEffects.POISON)),
    //ENCHANTED_CHORUS_FRUIT(new EnchantedFoodItem(settings().rarity(EPIC)4, 1.2f)),
    ENCHANTED_CHORUS_FRUIT(new EnchantedFoodItem(settings().rarity(EPIC), 4, 1.2f, StatusEffects.SLOW_FALLING)),
    ENCHANTED_APPLE_PIE(new EnchantedFoodItem(settings().rarity(EPIC), 6, 1.6f, StatusEffects.FIRE_RESISTANCE));

    //1.1 planned - dw its not sea turtles!
    //COOKED_TURTLE(new FoodItem(settings(), 8, 0.6f)),
    
    /** Called from {@link ModItems} */
    static void initialize() {
        
    }

    private static Item.Settings settings() {
        return new Item.Settings().group(REGULAR_DISHES);
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    RegularFoodItems(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }
    
    @Override
    public Item asItem() {
        return item;
    }
}
