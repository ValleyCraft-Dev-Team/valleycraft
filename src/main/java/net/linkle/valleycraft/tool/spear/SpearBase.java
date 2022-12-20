package net.linkle.valleycraft.tool.spear;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.tool.WeaponItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ToolMaterial;

public class SpearBase
        extends WeaponItem
        implements EnchantmentHandler {

    public SpearBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    //Add the explanatory tooltip
    //@Override
    //public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
    //    tooltip.add( new TranslatableText("item.valley.knife.tooltip").formatted(Formatting.YELLOW) );
    //}

    //These two methods use our special mixin to force specific enchantments to work on the sickle
    //despite enchantment compatibility being hardcoded in vanilla.

    @Override
    public List<EnchantmentTarget> getEnchantmentTypes() {
        return List.of(EnchantmentTarget.WEAPON);
    }
    
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}