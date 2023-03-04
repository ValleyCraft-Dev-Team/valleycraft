package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class RushBlock extends SugarCaneBlock implements Waterloggable {
    
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public RushBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var state = ctx.getWorld().getBlockState(ctx.getBlockPos().up());
        if (state.isAir() || state.isOf(this)) {
            return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
        }
        return null;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.isOf(this)) {
            return true;
        }
        if (blockState.isIn(BlockTags.DIRT) || blockState.isIn(BlockTags.SAND)) {
            if (state.getFluidState().getFluid() == Fluids.WATER) {
                return true;
            }
        }
        return false;
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
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.isAir(pos.up())) {
            int i;
            for(i = 1; world.getBlockState(pos.down(i)).isOf(this); ++i) {
            }
            if (i < 6) {
                int age = state.get(AGE);
                if (age == 15) {
                    world.setBlockState(pos.up(), this.getDefaultState());
                    world.setBlockState(pos, state.with(AGE, 0), 4);
                } else {
                    world.setBlockState(pos, state.with(AGE, age + 1), 4);
                }
            }
        }
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(WATERLOGGED));
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
