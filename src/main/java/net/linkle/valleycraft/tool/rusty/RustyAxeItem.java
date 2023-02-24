package net.linkle.valleycraft.tool.rusty;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.Groups;
import net.minecraft.item.AxeItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class RustyAxeItem
extends AxeItem
implements EnchantmentHandler {
    public RustyAxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(Groups.VC_TOOLS));
    }
}
