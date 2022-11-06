package net.linkle.valleycraft.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CattailsBlock extends TallPlantBlock implements FluidFillable {
    
    public CattailsBlock() {
        this(Settings.of(Material.UNDERWATER_PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS).offsetType(AbstractBlock.OffsetType.XZ));
    }
    
    public CattailsBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isSideSolidFullSquare(world, pos, Direction.UP) && !floor.isOf(Blocks.MAGMA_BLOCK);
    }
    
    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return false;
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState blockState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        if (!blockState.isAir()) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return blockState;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        var half = state.get(HALF);
        if (half == DoubleBlockHalf.LOWER && world.getFluidState(pos).getFluid() != Fluids.WATER) {
            return false;
        }
        var upperPos = half == DoubleBlockHalf.LOWER ? pos.up() : pos;
        var currentState = world.getBlockState(upperPos);
        if (!currentState.isOf(this) && (!currentState.getMaterial().isReplaceable() || !currentState.getFluidState().isEmpty())) {
            return false;
        }
        return super.canPlaceAt(state, world, pos);
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(HALF) == DoubleBlockHalf.LOWER ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    
    @Override
    public float getMaxHorizontalModelOffset() {
        return 0.2f;
    }

    @Override
    public boolean canFillWithFluid(BlockView world, BlockPos pos, BlockState state, Fluid fluid) {
        return false;
    }

    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluid) {
        return false;
    }
}
