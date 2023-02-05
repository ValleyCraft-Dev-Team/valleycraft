package net.linkle.valleycraft.tool.environmental;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

public class FlintToolItem extends AxeItem {
    public FlintToolItem(ToolMaterial FlintToolMaterial) {
        super(FlintToolMaterial, 1f, -2.0f, new Settings().group(VC_TOOLS));
    }
}


