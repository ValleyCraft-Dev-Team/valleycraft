package net.linkle.valleycraft.util;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;

public class PlantBlockSettings {
    public static final AbstractBlock.Settings OFFSET_FLOWER = AbstractBlock.Settings.copy(Blocks.POPPY);
    public static final AbstractBlock.Settings FLOWER = AbstractBlock.Settings.copy(Blocks.POPPY).offsetType(AbstractBlock.OffsetType.NONE);
    public static final AbstractBlock.Settings OFFSET_REPLACEABLE = AbstractBlock.Settings.copy(Blocks.GRASS);
}
