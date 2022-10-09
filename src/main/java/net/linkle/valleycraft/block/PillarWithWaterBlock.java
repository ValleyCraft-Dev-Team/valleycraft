package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

/**
 * Commonly used for blocks with waterloggable. Overriding some method such as
 * appendProperties without calling the subclass method
 * 'super.appendProperties()' is prone to break block's waterloggable.
 */
public class PillarWithWaterBlock extends PillarBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public PillarWithWaterBlock(Settings settings) {
        super(settings);
        setDefaultState();
    }

    /** A common method to set its default state. */
    protected final void setDefaultState() {
        setDefaultState(newDefaultState());
    }
    
    /** A common method to get a new default state. */
    protected BlockState newDefaultState() {
        return stateManager.getDefaultState().with(WATERLOGGED, false);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    /** Please call this subclass method to append waterlogged property: <code>super.appendProperties(builder)</code> */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
