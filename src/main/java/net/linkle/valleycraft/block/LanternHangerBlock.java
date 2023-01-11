package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class LanternHangerBlock extends HorizontalWithWaterBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(6.5, 0, 6.5, 9.5, 7, 9.5);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(SHAPE, Block.createCuboidShape(6.5, 5, 6.5, 9.5, 7, 16));
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SHAPE, Block.createCuboidShape(6.5, 5, 0, 9.5, 7, 9.5));
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(SHAPE,  Block.createCuboidShape(6.5, 5, 6.5, 16, 7, 9.5));
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(SHAPE,  Block.createCuboidShape(0, 5, 6.5, 9.5, 7, 9.5));

    public LanternHangerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
        case EAST -> EAST_SHAPE;
        case SOUTH -> SOUTH_SHAPE;
        case WEST -> WEST_SHAPE;
        default -> NORTH_SHAPE;
        };
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (!canPlaceAt(state, world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        pos = pos.offset(state.get(FACING).getOpposite());
        var otherState = world.getBlockState(pos);
        return !otherState.isAir() && !otherState.getMaterial().isReplaceable();
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return getSideElseUserFacing(ctx).getOpposite();
    }
}