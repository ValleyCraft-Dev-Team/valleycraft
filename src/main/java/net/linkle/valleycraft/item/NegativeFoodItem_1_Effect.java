package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class NegativeFoodItem_1_Effect extends FoodItem {
    public NegativeFoodItem_1_Effect(Settings settings, int hunger, float satMod, FoodStatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 15 * 20))); // 15 seconds
    }
}