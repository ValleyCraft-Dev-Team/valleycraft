package net.linkle.valleycraft.tool.environmental;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

public class RockToolItem extends PickaxeItem {
    public RockToolItem(ToolMaterial RockToolMaterial) {
        super(RockToolMaterial, 1, -2.0f, new Settings().group(VC_TOOLS));
    }
}


