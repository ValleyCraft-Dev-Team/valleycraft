package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class ArrowBlock extends DirectionBlockWithWater {
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4, 4, 0, 12, 12,1);
    protected static final VoxelShape WEST_SHAPE =  Block.createCuboidShape(0, 4, 4, 1,  12,12);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(4, 4, 15,12, 12,16);
    protected static final VoxelShape EAST_SHAPE =  Block.createCuboidShape(15,4, 4, 16, 12,12);
    protected static final VoxelShape UP_SHAPE =    Block.createCuboidShape(4, 15,4, 12, 16,12);
    protected static final VoxelShape DOWN_SHAPE =  Block.createCuboidShape(4, 0, 4, 12, 1, 12);

    public ArrowBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            case UP -> UP_SHAPE;
            case DOWN -> DOWN_SHAPE;
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
        pos = pos.offset(state.get(FACING));
        var otherState = world.getBlockState(pos);
        return !otherState.isAir() && !otherState.getMaterial().isReplaceable();
    }
    
    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return ctx.getSide().getOpposite();
    }
}
