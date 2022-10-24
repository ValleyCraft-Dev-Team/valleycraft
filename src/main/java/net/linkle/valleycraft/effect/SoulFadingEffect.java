package net.linkle.valleycraft.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class SoulFadingEffect extends StatusEffect {

    public SoulFadingEffect() {
        super(StatusEffectCategory.HARMFUL, 12117082);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.damage(DamageSource.MAGIC, 1.0F);
        ((PlayerEntity)entity).addExhaustion(0.005F * (float)(amplifier + 1));

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 20 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        }
        return true;
    }
}
