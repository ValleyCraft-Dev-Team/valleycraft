package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class NegativeFoodItem_3_Effects extends FoodItem {
    public NegativeFoodItem_3_Effects(Settings settings, int hunger, float satMod, StatusEffect effect, StatusEffect effect_2, StatusEffect effect_3) {
        super(settings, hunger, satMod, new FoodStatusEffect(
                //hunger
                new StatusEffectInstance(effect, 15 * 20, 3),
                //poison
                new StatusEffectInstance(effect_2, 60 * 20, 2),
                //nausea
                new StatusEffectInstance(effect_3, 15 * 20, 30)));
    }
}