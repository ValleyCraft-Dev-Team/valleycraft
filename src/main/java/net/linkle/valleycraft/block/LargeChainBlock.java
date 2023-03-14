package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class LargeChainBlock extends ChainBlock {
    protected static final VoxelShape Y_SHAPE;
    protected static final VoxelShape Z_SHAPE;
    protected static final VoxelShape X_SHAPE;

    public LargeChainBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch((Direction.Axis)state.get(AXIS)) {
            case X:
            default:
                return X_SHAPE;
            case Z:
                return Z_SHAPE;
            case Y:
                return Y_SHAPE;
        }
    }

    static {
        Y_SHAPE = Block.createCuboidShape(5.5D, 0.0D, 5.5D, 10.5D, 16.0D, 10.5D);
        Z_SHAPE = Block.createCuboidShape(5.5D, 5.5D, 0.0D, 10.5D, 10.5D, 16.0D);
        X_SHAPE = Block.createCuboidShape(0.0D, 5.5D, 5.5D, 16.0D, 10.5D, 10.5D);
    }
}
