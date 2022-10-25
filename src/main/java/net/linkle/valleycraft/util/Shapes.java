package net.linkle.valleycraft.util;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

/** Contains common shapes */
public class Shapes {
    public static final VoxelShape DEFAULT_PLANT_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape TUMBLEWEED_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape SHORT_GRASS_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape FLOWER_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape SHORT_FLOWER_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
}
