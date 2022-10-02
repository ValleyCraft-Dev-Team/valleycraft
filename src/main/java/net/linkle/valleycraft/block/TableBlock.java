package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
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
public class TableBlock extends HorizontalBlock implements Waterloggable {
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape TABLE_SHAPE = Block.createCuboidShape(0, 13, 0, 16, 16, 16);
    protected static final VoxelShape LEG_1_SHAPE = Block.createCuboidShape(1,0,1,3,13,3);
    protected static final VoxelShape LEG_2_SHAPE = Block.createCuboidShape(14,0,1,16,13,3);
    protected static final VoxelShape LEG_3_SHAPE = Block.createCuboidShape(1,0,14,3,13,15);
    protected static final VoxelShape LEG_4_SHAPE = Block.createCuboidShape(14,0,15,16,14,15);
    protected static final VoxelShape SHAPE = VoxelShapes.union(TABLE_SHAPE, LEG_1_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE, LEG_2_SHAPE);

    public TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
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
}
