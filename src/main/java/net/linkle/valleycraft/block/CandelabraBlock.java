package net.linkle.valleycraft.block;

import java.util.List;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
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

public class CandelabraBlock extends AbstractCandleBlock implements Waterloggable {
    
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    
    private final VoxelShape shape;
    private final List<Vec3d> particleOffsets;

    public CandelabraBlock(boolean small) {
        super(Settings.of(Material.DECORATION, MapColor.TERRACOTTA_ORANGE).luminance(s->s.get(LIT)?3:0).nonOpaque().strength(0.6f).sounds(BlockSoundGroup.COPPER));
        shape = small ? Block.createCuboidShape(5, 0, 5, 11, 7, 11) : Block.createCuboidShape(5, 0, 5, 11, 16, 11);
        particleOffsets = small ? List.of(new Vec3d(0.5, 9/16d, 0.5)) : List.of(new Vec3d(0.5, 18/16d, 0.5));
        setDefaultState(stateManager.getDefaultState().with(LIT, false).with(WATERLOGGED, false));
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (player.getAbilities().allowModifyWorld && player.getStackInHand(hand).isEmpty() && state.get(LIT).booleanValue()) {
            AbstractCandleBlock.extinguish(player, state, world, pos);
            return ActionResult.success(world.isClient);
        }
        return ActionResult.PASS;
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
        var fluid = ctx.getWorld().getFluidState(ctx.getBlockPos());
        var bool = fluid.getFluid() == Fluids.WATER;
        return super.getPlacementState(ctx).with(WATERLOGGED, bool);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
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

    @Override
    protected Iterable<Vec3d> getParticleOffsets(BlockState state) {
        return particleOffsets;
    }
}