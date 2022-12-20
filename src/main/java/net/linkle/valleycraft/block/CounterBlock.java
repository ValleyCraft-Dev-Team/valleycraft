package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class CounterBlock extends HorizontalWithWaterBlock {

    protected static final VoxelShape NORTH_BASE_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 13, 12);
    protected static final VoxelShape SOUTH_BASE_SHAPE = Block.createCuboidShape(0, 0, 4, 16, 13, 16);
    protected static final VoxelShape EAST_BASE_SHAPE = Block.createCuboidShape(4, 0, 0, 16, 13, 16);
    protected static final VoxelShape WEST_BASE_SHAPE = Block.createCuboidShape(0, 0, 0, 12, 13, 16);

    protected static final VoxelShape NORTH_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 0, 16, 16, 14);
    protected static final VoxelShape SOUTHE_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 2, 16, 16, 16);
    protected static final VoxelShape EAST_COUNTER_SHAPE = Block.createCuboidShape(2, 13, 0, 16, 16, 16);
    protected static final VoxelShape WEST_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 0, 14, 16, 16);

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(NORTH_COUNTER_SHAPE, NORTH_BASE_SHAPE);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SOUTHE_COUNTER_SHAPE, SOUTH_BASE_SHAPE);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(EAST_COUNTER_SHAPE, EAST_BASE_SHAPE);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(WEST_COUNTER_SHAPE, WEST_BASE_SHAPE);

    public CounterBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
}
