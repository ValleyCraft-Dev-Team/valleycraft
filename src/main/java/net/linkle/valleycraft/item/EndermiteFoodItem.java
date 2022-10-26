package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class EndermiteFoodItem extends FoodItem {
    public EndermiteFoodItem(Settings settings, int hunger, float satMod, StatusEffect effect, StatusEffect effect_2) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 30 * 20, 3), new StatusEffectInstance(effect_2, 30 * 20, 30))); // 30 seconds
    }
}