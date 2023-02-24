package net.linkle.valleycraft.tool.rusty;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.Groups;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class RustySwordItem
extends SwordItem
implements EnchantmentHandler {
    public RustySwordItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(Groups.VC_TOOLS));
    }
}
