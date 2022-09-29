package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.List;

/**
 * Commonly used for blocks with horizontal facing and waterlogged. Overriding
 * some method without calling the subclass's method 'super.appendProperties()'
 * is prone to break block's horizontal facing and waterlogged.
 */
public class GMGBlock extends HorizontalBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public GMGBlock(Settings settings) {
        super(settings);
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

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        // for versions 1.18.2 and before
        tooltip.add( new TranslatableText("item.valley.broken.tooltip"));

        // for versions since 1.19
        //tooltip.add(Text.translatable("item.valley.broken.tooltip"));
    }
}
