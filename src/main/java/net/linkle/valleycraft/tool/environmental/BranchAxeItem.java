package net.linkle.valleycraft.tool.environmental;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

public class BranchAxeItem
extends AxeItem
implements EnchantmentHandler {
    public BranchAxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(VC_TOOLS));
    }
}
