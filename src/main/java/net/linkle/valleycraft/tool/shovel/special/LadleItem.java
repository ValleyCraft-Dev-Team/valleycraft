package net.linkle.valleycraft.tool.shovel.special;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.Groups;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class LadleItem
extends ShovelItem
implements EnchantmentHandler {
    public LadleItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(Groups.VC_TOOLS));
    }

    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.FIRE_ASPECT);
    }
}
