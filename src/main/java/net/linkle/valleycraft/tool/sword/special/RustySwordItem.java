package net.linkle.valleycraft.tool.sword.special;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.ModGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RustySwordItem
extends SwordItem
implements EnchantmentHandler {
    public RustySwordItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ModGroups.VC_TOOLS));
    }
}
