package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.List;

public class Tier2Normal extends FoodItem {
    public Tier2Normal(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 60 * 20))); // 60 seconds
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.valley.tier_two.tooltip"));
    }
}