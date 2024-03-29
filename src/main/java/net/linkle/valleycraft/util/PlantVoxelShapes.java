package net.linkle.valleycraft.util;

import net.minecraft.block.Block;
import net.minecraft.util.shape.VoxelShape;

/** Contains common shapes */
public class PlantVoxelShapes {
    public static final VoxelShape DEFAULT_PLANT_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape TUMBLEWEED_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    public static final VoxelShape SHORT_GRASS_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 7, 14);
    public static final VoxelShape FLOWER_SHAPE = Block.createCuboidShape(5, 0, 5, 11, 10, 11);
    public static final VoxelShape SHORT_FLOWER_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 2, 14);
    public static final VoxelShape FLOWERING_CACTUS_SHAPE = Block.createCuboidShape(4, 0, 4, 12, 8, 12);
    public static final VoxelShape CACTUS_SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
}
