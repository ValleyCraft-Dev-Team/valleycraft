package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EnchantedFastFoodItem extends FoodItem {
    public EnchantedFastFoodItem(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20, 4), new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 20, 2), new StatusEffectInstance(effect, 60 * 5 * 20), new StatusEffectInstance(StatusEffects.RESISTANCE, 60 * 5 * 20))); // 60 seconds
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 10;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add( Text.translatable("item.valleycraft.fastfood.tooltip").formatted(Formatting.GRAY));
        tooltip.add( Text.translatable("item.valleycraft.fastfood.tooltip_2").formatted(Formatting.GRAY));
    }
}