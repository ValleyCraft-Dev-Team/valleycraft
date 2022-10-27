package net.linkle.valleycraft.tool.anthro;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.ModGroups.VC_TOOLS;

public class AnthroPickaxeItem extends PickaxeItem {
    public AnthroPickaxeItem(ToolMaterial AnthroPickaxeMaterial) {
        super(AnthroPickaxeMaterial, 5, -2.5f, new Settings().group(VC_TOOLS));
    }
}


