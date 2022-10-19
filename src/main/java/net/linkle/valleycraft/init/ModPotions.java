package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.widener.BrewingRecipeRegistryWidener;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    
    public static Potion ROT_BLIGHT_POTION = registerPotion("rot_blight_potion", new Potion(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 45 * 20)));

    public static void initialize() {
        registerRecipe(Potions.AWKWARD, IngredientFoodItems.INFECTED_MONSTER_LIVER.item, ModPotions.ROT_BLIGHT_POTION);
    }
    
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, Main.makeId(name), potion);
    }
    
    private static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(Potions.AWKWARD, IngredientFoodItems.INFECTED_MONSTER_LIVER.item, ModPotions.ROT_BLIGHT_POTION);
    }
}
