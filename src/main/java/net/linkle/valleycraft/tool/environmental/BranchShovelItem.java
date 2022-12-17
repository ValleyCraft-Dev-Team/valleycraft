package net.linkle.valleycraft.tool.environmental;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.ModGroups.VC_TOOLS;

public class BranchShovelItem
extends ShovelItem
implements EnchantmentHandler {
    public BranchShovelItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(VC_TOOLS));
    }
}
