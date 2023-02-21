package net.linkle.valleycraft.block;

import java.util.List;

import net.linkle.valleycraft.util.Util;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class CandleBottleBlock extends AbstractCandleBlock implements Waterloggable {
    
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    
    private static final List<Vec3d> PARTICLE_OFFSETS = List.of(new Vec3d(0.5, 5/16d, 0.5));
    
    public CandleBottleBlock() {
        super(BottleBlock.settings().luminance(s->s.get(LIT)?5:0));
        setDefaultState(stateManager.getDefaultState().with(LIT, false).with(WATERLOGGED, false));
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getAbilities().allowModifyWorld && player.getStackInHand(hand).isEmpty() && state.get(LIT).booleanValue()) {
            extinguish(player, state, world, pos);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
    }
    
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BottleBlock.SHAPE;
    }
    
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(WATERLOGGED, Util.inWater(ctx));
    }

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return PARTICLE_OFFSETS;
    }
    
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return Block.sideCoversSmallSquare(world, pos.down(), Direction.UP);
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, LIT);
    }
    
    @Override
    protected boolean isNotLit(BlockState state) {
        return state.get(WATERLOGGED) == false && super.isNotLit(state);
    }
    
    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (state.get(WATERLOGGED).booleanValue() || fluidState.getFluid() != Fluids.WATER) {
            return false;
        }
        var stateWithWater = state.with(WATERLOGGED, true);
        if (state.get(LIT).booleanValue()) {
            AbstractCandleBlock.extinguish(null, stateWithWater, world, pos);
        } else {
            world.setBlockState(pos, stateWithWater, Block.NOTIFY_ALL);
        }
        world.createAndScheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
        return true;
    }
}
