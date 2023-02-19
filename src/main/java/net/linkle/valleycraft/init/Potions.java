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

public class Potions {
    
    public static Potion ROT_BLIGHT_POTION = registerPotion("rot_blight_potion", new Potion(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 45 * 20)));

    public static Potion LEVITATION_POTION = registerPotion("levitation_potion", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 45 * 20)));
    public static Potion LEVITATION_POTION_LONG = registerPotion("levitation_potion_long", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 90 * 20)));
    public static Potion LEVITATION_POTION_FAST = registerPotion("levitation_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.LEVITATION, 21 * 20, 2)));

    public static Potion ABSORPTION_POTION = registerPotion("absorption_potion", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 60 * 20)));
    public static Potion ABSORPTION_POTION_LONG = registerPotion("absorption_potion_long", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20)));
    public static Potion ABSORPTION_POTION_FAST = registerPotion("absorption_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.ABSORPTION, 30 * 20, 2)));

    public static Potion LUCK_LONG = registerPotion("luck_potion_long", new Potion(new StatusEffectInstance(StatusEffects.LUCK, 480 * 20)));
    public static Potion LUCK_FAST = registerPotion("luck_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.LUCK, 150 * 20, 2)));

    public static Potion HASTE_POTION = registerPotion("haste_potion", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 180 * 20)));
    public static Potion HASTE_POTION_LONG = registerPotion("haste_potion_long", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 480 * 20)));
    public static Potion HASTE_POTION_FAST = registerPotion("haste_potion_fast", new Potion(new StatusEffectInstance(StatusEffects.HASTE, 90 * 20, 2)));

    public static Potion FERAL_STRENGTH = registerPotion("feral_strength_potion", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 45 * 20, 3), new StatusEffectInstance(StatusEffects.NAUSEA, 45 *20, 2)));
    public static Potion FERAL_STRENGTH_LONG = registerPotion("feral_strength_potion_long", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 90 * 20, 3), new StatusEffectInstance(StatusEffects.NAUSEA, 90 *20, 2)));

    public static Potion DRAGONHEARTED = registerPotion("dragonhearted_potion", new Potion(new StatusEffectInstance(StatusEffects.STRENGTH, 45 * 20, 4), new StatusEffectInstance(StatusEffects.BLINDNESS, 45 *20, 1), new StatusEffectInstance(StatusEffects.POISON, 21 *20, 1)));
    public static Potion BAD_OMEN = registerPotion("terrible_omen_potion", new Potion(new StatusEffectInstance(StatusEffects.BAD_OMEN, 6000 * 20, 5), new StatusEffectInstance(StatusEffects.BLINDNESS, 6000 *20, 1), new StatusEffectInstance(ModEffects.SOUL_FADING, 21 *20, 1)));

    public static void initialize() {
        registerRecipe(net.minecraft.potion.Potions.WATER, FoodIngredients.INFECTED_MONSTER_HEART.item, Potions.ROT_BLIGHT_POTION);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.RAW_BAT_WING.item, Potions.LEVITATION_POTION);
        registerRecipe(Potions.LEVITATION_POTION, Items.GLOWSTONE_DUST, Potions.LEVITATION_POTION_LONG);
        registerRecipe(Potions.LEVITATION_POTION, Items.REDSTONE, Potions.LEVITATION_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, BlocksNatural.CLAM_BLOCK.item, Potions.ABSORPTION_POTION);
        registerRecipe(Potions.ABSORPTION_POTION, Items.GLOWSTONE_DUST, Potions.ABSORPTION_POTION_LONG);
        registerRecipe(Potions.ABSORPTION_POTION, Items.REDSTONE, Potions.ABSORPTION_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.NAUTILUS_SHELL, net.minecraft.potion.Potions.LUCK);
        registerRecipe(net.minecraft.potion.Potions.LUCK, Items.GLOWSTONE_DUST, Potions.LUCK_LONG);
        registerRecipe(net.minecraft.potion.Potions.LUCK, Items.REDSTONE, Potions.LUCK_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.AMETHYST_SHARD, Potions.HASTE_POTION);
        registerRecipe(Potions.HASTE_POTION, Items.GLOWSTONE_DUST, Potions.HASTE_POTION_LONG);
        registerRecipe(Potions.HASTE_POTION, Items.REDSTONE, Potions.HASTE_POTION_FAST);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.GOAT_HORN, net.minecraft.potion.Potions.STRENGTH);
        registerRecipe(net.minecraft.potion.Potions.AWKWARD, Items.ECHO_SHARD, net.minecraft.potion.Potions.STRENGTH);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.MONSTER_CLAW.item, Potions.FERAL_STRENGTH);
        registerRecipe(Potions.FERAL_STRENGTH, Items.GLOWSTONE_DUST, Potions.FERAL_STRENGTH_LONG);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.SLIME_BLOB.item, net.minecraft.potion.Potions.LEAPING);
        registerRecipe(net.minecraft.potion.Potions.AWKWARD, FoodRegular.CRYSTALLIZED_HONEYDROP.item, net.minecraft.potion.Potions.REGENERATION);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, ItemsModded.DRAGON_TOOTH.item, Potions.DRAGONHEARTED);

        registerRecipe(net.minecraft.potion.Potions.AWKWARD, BlocksNatural.VILLAGER_SKULL.item, Potions.BAD_OMEN);

    }
    
    private static Potion registerPotion(String name, Potion potion) {
        return Registry.register(Registry.POTION, Main.makeId(name), potion);
    }
    
    private static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, FoodIngredients.INFECTED_MONSTER_HEART.item, Potions.ROT_BLIGHT_POTION);
        BrewingRecipeRegistryWidener.invokeRegisterPotionRecipe(net.minecraft.potion.Potions.AWKWARD, Items.SCUTE, net.minecraft.potion.Potions.TURTLE_MASTER);
    }
}
