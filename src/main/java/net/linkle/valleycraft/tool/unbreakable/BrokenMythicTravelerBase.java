package net.linkle.valleycraft.tool.unbreakable;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.tool.WeaponItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class BrokenMythicTravelerBase
        extends WeaponItem
        implements EnchantmentHandler {

    public BrokenMythicTravelerBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.broken.tooltip").formatted(Formatting.GRAY));
        tooltip.add( Text.translatable("item.valley.unique.tooltip").formatted(Formatting.GOLD));
        tooltip.add( Text.translatable("item.valley.mythic.tooltip").formatted(Formatting.RED));
    }

    @Override
    public List<EnchantmentTarget> getEnchantmentTypes() {
        return List.of(EnchantmentTarget.WEAPON);
    }

    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }

    @Override
    public boolean isInvalid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.SWEEPING);
    }
}