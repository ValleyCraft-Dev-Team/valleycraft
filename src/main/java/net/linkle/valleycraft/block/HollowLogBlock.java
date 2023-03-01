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

public class HollowLogBlock extends PillarBlock implements Waterloggable {

    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    
    protected static final VoxelShape SHAPE_X;
    protected static final VoxelShape SHAPE_Y;
    protected static final VoxelShape SHAPE_Z;
    
    public HollowLogBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(WATERLOGGED, false));
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(AXIS)) {
        case X -> SHAPE_X;
        case Z -> SHAPE_Z;
        default -> SHAPE_Y;
        };
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
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    
    static {
        VoxelShape topBase, bottomBase, leftBase, rightBase;
        topBase = createCuboidShape(0, 0, 15, 16, 16, 16);
        bottomBase = createCuboidShape(0, 0, 0, 16, 16, 1);
        leftBase = createCuboidShape(0, 0, 0, 1, 16, 16);
        rightBase = createCuboidShape(15, 0, 0, 16, 16, 16);
        SHAPE_Y = VoxelShapes.union(topBase, bottomBase, leftBase, rightBase);
        topBase = createCuboidShape(0, 15, 0, 16, 16, 16);
        bottomBase = createCuboidShape(0, 0, 0, 16, 1, 16);
        leftBase = createCuboidShape(0, 0, 0, 16, 16, 1);
        rightBase = createCuboidShape(0, 0, 15, 16, 16, 16);
        SHAPE_X = VoxelShapes.union(topBase, bottomBase, leftBase, rightBase);
        topBase = createCuboidShape(0, 15, 0, 16, 16, 16);
        bottomBase = createCuboidShape(0, 0, 0, 16, 1, 16);
        leftBase = createCuboidShape(0, 0, 0, 1, 16, 16);
        rightBase = createCuboidShape(15, 0, 0, 16, 16, 16);
        SHAPE_Z = VoxelShapes.union(topBase, bottomBase, leftBase, rightBase);
    }
}
