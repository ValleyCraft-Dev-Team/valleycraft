package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class Tier1Bottle extends BottleItem {
    public Tier1Bottle(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 30 * 20)));
    }
}
