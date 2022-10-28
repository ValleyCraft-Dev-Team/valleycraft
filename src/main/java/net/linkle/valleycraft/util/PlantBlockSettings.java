package net.linkle.valleycraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class PlantBlockSettings {
    public static final Block.Settings OFFSET_FLOWER = Block.Settings.copy(Blocks.POPPY);
    public static final Block.Settings FLOWER = Block.Settings.copy(Blocks.POPPY).offsetType(Block.OffsetType.NONE);
    public static final Block.Settings OFFSET_REPLACEABLE = Block.Settings.copy(Blocks.GRASS);
}
