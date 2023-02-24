package net.linkle.valleycraft.tool.rusty;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.Groups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class RustyPickaxeItem
extends PickaxeItem
implements EnchantmentHandler {
    public RustyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(Groups.VC_TOOLS));
    }
}
