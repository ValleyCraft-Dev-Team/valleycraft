package net.linkle.valleycraft.tool.pickaxes;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.init.ModGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class RustyPickaxeItem
extends PickaxeItem
implements EnchantmentHandler {
    public RustyPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, attackDamage, attackSpeed, new Settings().group(ModGroups.VC_TOOLS));
    }
}
