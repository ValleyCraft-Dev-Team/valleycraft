package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.widener.BrewingRecipeRegistryWidener;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class Potions {
    
    public static Potion ROT_BLIGHT_POTION = registerPotion("rot_blight_potion", new Potion(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 45 * 20)));

    public static void initialize() {
        registerRecipe(net.minecraft.potion.Potions.WATER, FoodIngredients.INFECTED_MONSTER_HEART.item, Potions.ROT_BLIGHT_POTION);
        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);
    }
    
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, Main.makeId(name), potion);
    }
    
    private static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.INFECTED_MONSTER_HEART.item, Potions.ROT_BLIGHT_POTION);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);
    }
}
