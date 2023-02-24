package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.CrateBlockEntity;
import net.linkle.valleycraft.block.entity.DeepslateChestBlockEntity;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class DeepslateChestBlock extends BarrelBlock implements Waterloggable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1, 0, 1, 15, 14, 15);
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public DeepslateChestBlock(Settings settings) {
        super(settings);
        setDefaultState();
    }

    protected final void setDefaultState() {
        setDefaultState(newDefaultState());
    }
    protected BlockState newDefaultState() {
        return stateManager.getDefaultState().with(WATERLOGGED, false);
    }

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

    @Override @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DeepslateChestBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
