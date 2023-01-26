package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class Tier3Bowl extends BowlItem {
    
    public Tier3Bowl(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 120 * 20)));
    }
}
