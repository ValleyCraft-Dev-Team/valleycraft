package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;

public class EnchantedFoodItem extends FoodItem {
    public EnchantedFoodItem(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20, 4), new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 2), new StatusEffectInstance(effect, 60 * 5 * 20), new StatusEffectInstance(StatusEffects.RESISTANCE, 60 * 5 * 20))); // 60 seconds
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}