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

public class Tier1Normal extends FoodItem {
    public Tier1Normal(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 30 * 20))); // 30 seconds
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.translatable("item.valley.tier_one.tooltip"));
    }
}