package net.linkle.valleycraft.potion;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.init.IngredientFoodItems;
import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    public static Potion ROT_BLIGHT_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(Main.ID, name),
                new Potion(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 45 * 20,0)));
    }

    public static void registerPotions() {
        ROT_BLIGHT_POTION = registerPotion("rot_blight_potion");

        registerPotionRecipes();
    }


    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, IngredientFoodItems.MONSTER_LIVER, ModPotions.ROT_BLIGHT_POTION);
    }
}
