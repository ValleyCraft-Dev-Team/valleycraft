package net.linkle.valleycraft.tool.woodcutter_axe.special;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

import static net.linkle.valleycraft.init.Groups.VC_TOOLS;

public class TimberAxeItem extends AxeItem {
    public TimberAxeItem(ToolMaterial TimberAxeToolMaterial) {
        super(TimberAxeToolMaterial, 7.5f, -3.2f, new Settings().group(VC_TOOLS));
    }
}


