package net.linkle.valleycraft.tool.environmental;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;

public class BranchWeaponItem
extends SwordItem
implements EnchantmentHandler {
    public BranchWeaponItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(VC_TOOLS));
    }

    @Override
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.SWEEPING);
    }
}
