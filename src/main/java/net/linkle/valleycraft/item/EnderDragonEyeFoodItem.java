package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EnderDragonEyeFoodItem extends FoodItem {
    public EnderDragonEyeFoodItem(Settings settings, int hunger, float satMod, StatusEffect effect, StatusEffect effect_2, StatusEffect effect_3) {
        super(settings, hunger, satMod, new FoodStatusEffect(
                //blindness
                new StatusEffectInstance(effect, 60 * 20),
                //poison
                new StatusEffectInstance(effect_2, 60 * 20, 2),
                //nausea
                new StatusEffectInstance(effect_3, 60 * 20, 30)));
    }
}