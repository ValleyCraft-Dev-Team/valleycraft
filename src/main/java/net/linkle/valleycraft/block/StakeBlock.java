package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class StakeBlock extends PillarWithWaterBlock {
    protected static final VoxelShape X_SHAPE;
    protected static final VoxelShape Y_SHAPE;
    protected static final VoxelShape Z_SHAPE;

    public StakeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
        case X -> X_SHAPE;
        case Y -> Y_SHAPE;
        case Z -> Z_SHAPE;
        };
    }

    static {
        Y_SHAPE = Block.createCuboidShape(6.5D, 0.0D, 6.5D, 9.5D, 16.0D, 9.5D);
        Z_SHAPE = Block.createCuboidShape(6.5D, 6.5D, 0.0D, 9.5D, 9.5D, 16.0D);
        X_SHAPE = Block.createCuboidShape(0.0D, 6.5D, 6.5D, 16.0D, 9.5D, 9.5D);
    }
}