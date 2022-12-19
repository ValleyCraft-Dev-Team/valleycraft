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
    COOKED_RICE(new FoodItem(settings(), 4, 0.6f)),
    COOKED_CAVE_ROOT(new FoodItem(settings(), 5, 0.6f)),
    DRIED_ORANGE_KELP(new FoodItem(settings(), 1, 0.6f)),
    DRIED_GLOW_KELP(new FoodItem(settings(), 1, 0.6f)),

    COOKED_TROPICAL_FISH(new FoodItem(settings(), 4, 0.6f)),
    COOKED_ABYSSWATCHER(new FoodItem(settings(), 6, 0.7f)),
    COOKED_STONETOSSER_MINNOW(new FoodItem(settings(), 3, 0.4f)),
    COOKED_RED_PORGY(new FoodItem(settings(), 4, 0.6f)),
    COOKED_PERCH(new FoodItem(settings(), 4, 0.6f)),
    COOKED_CLAM(new FoodItem(settings(), 4, 0.3f)),
    COOKED_SEA_URCHIN(new FoodItem(settings(), 6, 0.6f)),
    COOKED_SQUID(new FoodItem(settings(), 4, 0.6f)),
    COOKED_LOBSTER(new FoodItem(settings(), 7, 0.7f)),
    COOKED_MOSSY_CRAB(new FoodItem(settings(), 7, 0.7f)),

    COOKED_SILVERFISH(new FoodItem(settings(), 3, 0.6f)),
    COOKED_PHANTOM(new FoodItem(settings(), 6, 0.6f)),
    COOKED_BIRD(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BACON(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BAT(new FoodItem(settings(), 5, 0.6f, true)),
    FRIED_EGG(new FoodItem(settings(), 4, 0.6f)),
    COOKED_BEAST_LIVER(new FoodItem(settings(), 8, 0.8f, true)),
    COOKED_BEAST_HEART(new FoodItem(settings(), 10, 1f, true)),
    COOKED_TRIPE(new FoodItem(settings(), 8, 1f, true)),

    // pastries
    HARDTACK(new FoodItem(settings(), 3, 0.8f)),
    CORN_BREAD(new FoodItem(settings(), 3, 0.9f)),
    CHOCOLATE(new FoodItem(settings(), 2, 0.5f)),
    CAKE_SLICE(new FoodItem(settings(), 2, 0.3f)),
    PUMPKIN_SPICE_COOKIE(new FoodItem(settings(), 3, 0.2f)),
    PUMPKIN_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),
    APPLE_PIE(new FoodItem(settings(), 8, 0.4f)),
    APPLE_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),
    SWEET_BERRY_PIE(new FoodItem(settings(), 8, 0.4f)),
    SWEET_BERRY_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),
    GLOW_BERRY_PIE(new FoodItem(settings(), 8, 0.4f)),
    GLOW_BERRY_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),
    CHOCOLATE_PIE(new FoodItem(settings(), 8, 0.6f)),
    CHOCOLATE_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),
    CHORUS_FRUIT_PIE(new FoodItem(settings(), 10, 0.7f)),
    CHORUS_FRUIT_PIE_SLICE(new FoodItem(settings(), 2, 0.5f)),

    // no tier bottles
    CHOCOLATE_MILK(new BottleItem(settings().maxCount(16), 3, 0.3f).setMilk()),
    ATOLE_MILK(new BottleItem(settings().maxCount(16), 4, 0.2f).setMilk()),
    EGGNOG(new BottleItem(settings().maxCount(16), 3, 0.3f).setMilk()),
    APPLE_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    CARROT_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    SWEET_BERRY_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    CHORUS_FRUIT_JUICE(new BottleItem(settings().maxCount(16), 4, 0.3f)),
    ALOE_VERA_JUICE(new Tier0Bottle(settings().maxCount(16), 4, 0.3f, StatusEffects.HEALTH_BOOST)),

    // no tier items
    CAVE_ROOT_STIR_FRY(new BowlItem(settings().maxCount(1), 10, 0.6f)),
    COD_GEFILTE(new BowlItem(settings().maxCount(1), 10, 0.6f)),

    STIR_FRIED_MONSTER_GUTS(new BowlItem(settings().maxCount(1), 8, 0.4f)),
    MONSTER_STEW(new BowlItem(settings().maxCount(1), 6, 0.4f)),
    SPICY_POTATOES_AND_BAT(new FoodItem(settings().maxCount(1), 8, 0.4f)),
    SPICY_POTATOES_AND_CARROTS(new FoodItem(settings().maxCount(1), 8, 0.4f)),

    BROTH(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    BEEF_STEW(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    KELP_SALAD(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    BROWN_MUSHROOM_SALAD(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    ORANGE_MUSHROOM_SALAD(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    RED_MUSHROOM_SALAD(new BowlItem(settings().maxCount(1), 4, 0.5f)),
    BROWN_MUSHROOM_SKEWER(new FoodItem(settings(), 6, 0.8f)),
    ORANGE_MUSHROOM_SKEWER(new FoodItem(settings(), 6, 0.8f)),
    RED_MUSHROOM_SKEWER(new FoodItem(settings(), 6, 0.8f)),

    FRUIT_MIX(new BowlItem(settings().maxCount(1), 6, 0.6f)),
    VEGETABLE_MIX(new BowlItem(settings().maxCount(1), 6, 0.6f)),
    SAVORY_BREAKFAST(new BowlItem(settings().maxCount(1), 9, 0.6f)),
    HEARTY_BREAKFAST(new BowlItem(settings().maxCount(1), 10, 0.8f)),
    FRIED_RICE_AND_EGGS(new FoodItem(settings().maxCount(1), 8, 0.7f)),
    SAUTEED_EYES_AND_MUSHROOMS(new FoodItem(settings(), 8, 0.8f)),

    MAGMA_CREME_SOUP(new BowlItem(settings().maxCount(1), 7, 0.6f)),
    SLIME_SOUP(new BowlItem(settings().maxCount(1), 5, 0.6f)),
    PUMPKIN_SOUP(new BowlItem(settings().maxCount(1), 8, 0.8f)),
    //WARM_PUMPKIN_SOUP_BOTTLE(new GlassJarItem(settings().maxCount(1), 9, 0.8f)),
    FUNGUS_STEW(new BowlItem(settings().maxCount(1), 8, 0.8f)),
    SQUID_SOUP(new BowlItem(settings().maxCount(1), 6, 0.8f)),
    SEA_URCHIN_CHOWDER(new FoodItem(settings().maxCount(1), 6, 0.8f)),
    CLAM_CHOWDER(new BowlItem(settings().maxCount(1), 6, 0.8f)),
    FISH_PLATTER(new BowlItem(settings().maxCount(1), 6, 0.8f)),

    //sandwich items
    TOAST(new FoodItem(settings(), 1, 1.0f)),
    EGGS_ON_TOAST(new FoodItem(settings(), 6, 1.3f)),
    GRILLED_CHEESE(new FoodItem(settings(), 6, 1.3f)),
    SANDWICH_FISH(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_CHICKEN(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_MUTTON(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_BEEF(new FoodItem(settings(), 10, 0.8f)),
    SANDWICH_PORK(new FoodItem(settings(), 10, 0.8f)),

    // golden
    GOLDEN_WATERMELON_JUICE(new BottleItem(settings(), 2, 2.4f)),
    GOLDEN_POTATO(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_ALOE_VERA(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_CAVE_ROOT(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_CHORUS_FRUIT(new FoodItem(settings().rarity(Rarity.RARE), 4, 2.4f)),
    GOLDEN_ENDURA_CARROT(new FoodItem(settings().rarity(Rarity.RARE), 4, 2.4f)),
    GOLDEN_BEETROOT(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_HEARTY_BEETROOT(new FoodItem(settings().rarity(Rarity.RARE), 4, 2.4f)),
    GOLDEN_FIRE_PEPPER(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_SWEET_BERRIES(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_GLOW_BERRIES(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_ANCIENT_MAIZE(new FoodItem(settings().rarity(Rarity.RARE), 4, 2.4f)),
    GOLDEN_ONION(new FoodItem(settings(), 4, 2.4f)),
    GOLDEN_PUMPKIN_SLICE(new FoodItem(settings(), 4, 2.4f)),

    ENCHANTED_CHORUS_FRUIT(new EnchantedFoodItem(settings().rarity(EPIC), 4, 1.2f, StatusEffects.SLOW_FALLING).hideTooltip()),
    ENCHANTED_APPLE_PIE(new EnchantedFoodItem(settings().rarity(EPIC), 10, 1.6f, StatusEffects.FIRE_RESISTANCE).hideTooltip()),
    ENCHANTED_APPLE_PIE_SLICE(new EnchantedFoodItem(settings().rarity(EPIC), 3, 1.6f, StatusEffects.FIRE_RESISTANCE).hideTooltip());

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
    
    @Override
    public Identifier getId() {
        return id;
    }
}
