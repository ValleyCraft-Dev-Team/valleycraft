package net.linkle.valleycraft.item.cultural_drinks;

import net.linkle.valleycraft.item.BottleItem;
import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;

public class ElixerBottleItemPillager extends BottleItem {

    public ElixerBottleItemPillager(Settings settings, int hunger, float satMod, StatusEffect effect, StatusEffect effect_2, StatusEffect effect_3) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 8 * 60 * 20), new StatusEffectInstance(effect_2, 8 * 60 * 20, 2), new StatusEffectInstance(effect_3, 30 * 20)));
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
