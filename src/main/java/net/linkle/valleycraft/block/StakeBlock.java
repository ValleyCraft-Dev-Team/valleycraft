package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class StakeBlock extends PillarWithWaterBlock {
    protected static final VoxelShape X_SHAPE = Block.createCuboidShape(0, 7, 7, 16, 9, 9);
    protected static final VoxelShape Y_SHAPE = Block.createCuboidShape(7, 0, 7, 9, 16, 9);
    protected static final VoxelShape Z_SHAPE = Block.createCuboidShape(7, 7, 0, 9, 9, 16);

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
}