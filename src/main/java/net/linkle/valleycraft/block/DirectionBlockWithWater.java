package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

/**
 * Commonly used for blocks with facing and waterlogged. Overriding
 * some method without calling the subclass's method 'super.appendProperties()'
 * is prone to break block's facing and waterlogged.
 */
public class DirectionBlockWithWater extends DirectionBlock implements Waterloggable {
    // DON"T COPY THIS CLASS! Just extent it lmao.
    
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public DirectionBlockWithWater(Settings settings) {
        super(settings);
    }

    @Override
    protected BlockState newDefaultState(Direction facing) {
        return super.newDefaultState(facing).with(WATERLOGGED, false);
    }

    /** Please call this subclass method to append facing and waterlogged properties: <code>super.appendProperties(builder)</code> */
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState,
            WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
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
