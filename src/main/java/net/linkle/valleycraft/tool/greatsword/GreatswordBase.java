package net.linkle.valleycraft.tool.greatsword;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.util.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class GreatswordBase
        extends SwordItem
        implements EnchantmentHandler {

    public GreatswordBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    //These two methods use our special mixin to force specific enchantments to work on the sickle
    //despite enchantment compatibility being hardcoded in vanilla.

    //Make the knife accept any weapon enchantments
    @Override
    public List<EnchantmentTarget> getEnchantmentTypes() {
        return List.of(EnchantmentTarget.WEAPON);
    }
    
    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return Util.equalsAny(enchantment, Enchantments.SWEEPING);
    }
}