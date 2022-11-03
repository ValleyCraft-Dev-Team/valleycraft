package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ChimneyBlock extends BlockWithWater {

    protected static final VoxelShape LEFT_X_SHAPE;
    protected static final VoxelShape RIGHT_X_SHAPE;
    protected static final VoxelShape LEFT_Z_SHAPE;
    protected static final VoxelShape RIGHT_Z_SHAPE;
    protected static final VoxelShape FULL_SHAPE;

    public ChimneyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return FULL_SHAPE;
    }

    static {
        LEFT_X_SHAPE = Block.createCuboidShape(0,0,0,2,16,16);
        RIGHT_X_SHAPE = Block.createCuboidShape(14,0,0,16,16,16);
        LEFT_Z_SHAPE = Block.createCuboidShape(0,0,0,16,16,2);
        RIGHT_Z_SHAPE = Block.createCuboidShape(0,0,14,16,16,16);
        FULL_SHAPE = VoxelShapes.union(LEFT_X_SHAPE, RIGHT_X_SHAPE,LEFT_Z_SHAPE, RIGHT_Z_SHAPE);
    }
}

