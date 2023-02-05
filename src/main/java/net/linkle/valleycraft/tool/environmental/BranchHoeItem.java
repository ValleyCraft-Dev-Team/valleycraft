package net.linkle.valleycraft.tool.environmental;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

public class BranchHoeItem
extends HoeItem
implements EnchantmentHandler {
    public BranchHoeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(VC_TOOLS));
    }
}
