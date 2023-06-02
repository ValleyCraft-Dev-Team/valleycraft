package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.widener.BrewingRecipeRegistryWidener;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.util.registry.Registry;

public class ModPotions {
    
    public static Potion ROT_BLIGHT_POTION = registerPotion("rot_blight_potion", new Potion(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 45 * 20)));

    public static Potion LEVITATION_POTION = registerPotion("levitation_potion", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 45 * 20)));
    public static Potion LEVITATION_POTION_LONG = registerPotion("levitation_potion_long", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 90 * 20)));
    public static Potion LEVITATION_POTION_FAST = registerPotion("levitation_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 21 * 20, 1)));

    public static Potion ABSORPTION_POTION = registerPotion("absorption_potion", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 60 * 20)));
    public static Potion ABSORPTION_POTION_LONG = registerPotion("absorption_potion_long", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20)));
    public static Potion ABSORPTION_POTION_FAST = registerPotion("absorption_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 1)));

    public static Potion LUCK_LONG = registerPotion("luck_potion_long", new Potion(new StatusEffectInstance(StatusEffects.LUCK, 480 * 20)));
    public static Potion LUCK_FAST = registerPotion("luck_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.LUCK, 150 * 20, 1)));

    public static Potion HASTE_POTION = registerPotion("haste_potion", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 180 * 20)));
    public static Potion HASTE_POTION_LONG = registerPotion("haste_potion_long", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 480 * 20)));
    public static Potion HASTE_POTION_FAST = registerPotion("haste_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 1)));

    public static Potion FERAL_STRENGTH = registerPotion("feral_strength_potion", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 45 * 20, 2), new StatusEffectInstance(StatusEffects.NAUSEA, 45 *20, 2)));
    public static Potion FERAL_STRENGTH_LONG = registerPotion("feral_strength_potion_long", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 90 * 20, 2), new StatusEffectInstance(StatusEffects.NAUSEA, 90 *20, 2)));

    public static Potion DRAGONHEARTED = registerPotion("dragonhearted_potion", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 45 * 20, 3), new StatusEffectInstance(StatusEffects.POISON, 21 *20, 1)));
    public static Potion BAD_OMEN = registerPotion("terrible_omen_potion", new Potion(new StatusEffectInstance(StatusEffects.BAD_OMEN, 6000 * 20, 5), new StatusEffectInstance(StatusEffects.BLINDNESS, 6000 *20, 1), new StatusEffectInstance(ModEffects.SOUL_FADING, 21 *20, 1)));

    public static void initialize() {
        registerRecipe(net.minecraft.potion.Potions.WATER, FoodIngredients.MONSTER_HEART.item, ModPotions.ROT_BLIGHT_POTION);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.RAW_BAT_WING.item, ModPotions.LEVITATION_POTION);
        registerRecipe(ModPotions.LEVITATION_POTION, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_LONG);
        registerRecipe(ModPotions.LEVITATION_POTION, Items.REDSTONE, ModPotions.LEVITATION_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, BlocksNatural.CLAM_BLOCK.item, ModPotions.ABSORPTION_POTION);
        registerRecipe(ModPotions.ABSORPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.ABSORPTION_POTION_LONG);
        registerRecipe(ModPotions.ABSORPTION_POTION, Items.REDSTONE, ModPotions.ABSORPTION_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.NAUTILUS_SHELL, net.minecraft.potion.Potions.LUCK);
        registerRecipe(net.minecraft.potion.Potions.LUCK, Items.GLOWSTONE_DUST, ModPotions.LUCK_LONG);
        registerRecipe(net.minecraft.potion.Potions.LUCK, Items.REDSTONE, ModPotions.LUCK_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.AMETHYST_SHARD, ModPotions.HASTE_POTION);
        registerRecipe(ModPotions.HASTE_POTION, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_LONG);
        registerRecipe(ModPotions.HASTE_POTION, Items.REDSTONE, ModPotions.HASTE_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.GOAT_HORN, net.minecraft.potion.Potions.STRENGTH);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.MONSTER_CLAW.item, ModPotions.FERAL_STRENGTH);
        registerRecipe(ModPotions.FERAL_STRENGTH, Items.GLOWSTONE_DUST, ModPotions.FERAL_STRENGTH_LONG);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.SLIME_BLOB.item, net.minecraft.potion.Potions.LEAPING);
        registerRecipe(net.minecraft.potion.Potions.AWKWARD, FoodRegular.CRYSTALLIZED_HONEYDROP.item, net.minecraft.potion.Potions.REGENERATION);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.DRAGON_TOOTH.item, ModPotions.DRAGONHEARTED);
    }
    
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, Main.makeId(name), potion);
    }
    
    private static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.MONSTER_HEART.item, ModPotions.ROT_BLIGHT_POTION);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.RAW_BAT_WING.item, LEVITATION_POTION);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.LEVITATION_POTION, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_LONG);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.LEVITATION_POTION, Items.REDSTONE, ModPotions.LEVITATION_POTION_FAST);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, BlocksNatural.CLAM_BLOCK.item, ABSORPTION_POTION);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.ABSORPTION_POTION, Items.GLOWSTONE_DUST, ModPotions.ABSORPTION_POTION_LONG);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.ABSORPTION_POTION, Items.REDSTONE, ModPotions.ABSORPTION_POTION_FAST);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.NAUTILUS_SHELL, net.minecraft.potion.Potions.LUCK);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.LUCK, Items.GLOWSTONE_DUST, ModPotions.LUCK_LONG);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.LUCK, Items.REDSTONE, ModPotions.LUCK_FAST);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.AMETHYST_SHARD, ModPotions.HASTE_POTION);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_LONG);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.HASTE_POTION, Items.REDSTONE, ModPotions.HASTE_POTION_FAST);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.GOAT_HORN, net.minecraft.potion.Potions.STRENGTH);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.MONSTER_CLAW.item, ModPotions.FERAL_STRENGTH);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(ModPotions.FERAL_STRENGTH, Items.GLOWSTONE_DUST, ModPotions.FERAL_STRENGTH_LONG);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.SLIME_BLOB.item, net.minecraft.potion.Potions.LEAPING);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, FoodRegular.CRYSTALLIZED_HONEYDROP.item, net.minecraft.potion.Potions.REGENERATION);

        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.DRAGON_TOOTH.item, ModPotions.DRAGONHEARTED);
    }
}
