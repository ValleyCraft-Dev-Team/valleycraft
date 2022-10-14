package net.linkle.valleycraft.tool.environmental;

import static net.linkle.valleycraft.init.ModGroups.VC_TOOLS;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class BranchToolItem
extends SwordItem
implements EnchantmentHandler {
    public BranchToolItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(VC_TOOLS));
    }

    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.SWEEPING);
    }
}
