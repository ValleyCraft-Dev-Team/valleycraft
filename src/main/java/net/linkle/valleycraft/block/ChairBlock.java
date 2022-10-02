package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

/**
 * Commonly used for blocks with horizontal facing and waterlogged. Overriding
 * some method without calling the subclass's method 'super.appendProperties()'
 * is prone to break block's horizontal facing and waterlogged.
 */
public class ChairBlock extends HorizontalBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 8, 13);
    protected static final VoxelShape NORTH_BACK_SHAPE = Block.createCuboidShape(3,0, 13, 14, 19, 14);
    protected static final VoxelShape WEST_BACK_SHAPE = Block.createCuboidShape(2, 0, 3, 3, 19, 14);
    protected static final VoxelShape SOUTH_BACK_SHAPE = Block.createCuboidShape(3, 0, 2, 14, 19, 3);
    protected static final VoxelShape EAST_BACK_SHAPE = Block.createCuboidShape(13, 0, 3, 14, 19, 13);
    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(SHAPE, NORTH_BACK_SHAPE);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SHAPE, SOUTH_BACK_SHAPE);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(SHAPE, EAST_BACK_SHAPE);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(SHAPE, WEST_BACK_SHAPE);

    public ChairBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }

    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().with(WATERLOGGED, false);
    }

    /** Please call this subclass method to append facing and waterlogged properties: <code>super.getPlacementState(ctx)</code> */
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
            WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            fluidTick(world, pos);
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }
    
    protected static void fluidTick(WorldAccess world, BlockPos pos) {
        world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
