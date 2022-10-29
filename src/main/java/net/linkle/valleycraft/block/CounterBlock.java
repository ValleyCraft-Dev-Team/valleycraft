package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.CounterBlockEntity;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CounterBlock extends BlockWithEntity implements Waterloggable{
    protected static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    protected static final VoxelShape NORTH_BASE_SHAPE = Block.createCuboidShape(0, 0, 0, 16, 13, 12);
    protected static final VoxelShape SOUTH_BASE_SHAPE = Block.createCuboidShape(0, 0, 4, 16, 13, 16);
    protected static final VoxelShape EAST_BASE_SHAPE = Block.createCuboidShape(4, 2, 0, 16, 13, 16);
    protected static final VoxelShape WEST_BASE_SHAPE = Block.createCuboidShape(0, 2, 0, 12, 13, 12);

    protected static final VoxelShape NORTH_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 0, 16, 16, 14);
    protected static final VoxelShape SOUTHE_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 2, 16, 16, 16);
    protected static final VoxelShape EAST_COUNTER_SHAPE = Block.createCuboidShape(2, 13, 0, 16, 16, 16);
    protected static final VoxelShape WEST_COUNTER_SHAPE = Block.createCuboidShape(0, 13, 0, 14, 16, 16);

    protected static final VoxelShape NORTH_SHAPE = VoxelShapes.union(NORTH_COUNTER_SHAPE, NORTH_BASE_SHAPE);
    protected static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(SOUTHE_COUNTER_SHAPE, SOUTH_BASE_SHAPE);
    protected static final VoxelShape EAST_SHAPE = VoxelShapes.union(EAST_COUNTER_SHAPE, EAST_BASE_SHAPE);
    protected static final VoxelShape WEST_SHAPE = VoxelShapes.union(WEST_COUNTER_SHAPE, WEST_BASE_SHAPE);

    public CounterBlock(Settings settings) {
        super(settings);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CounterBlockEntity) {
                player.openHandledScreen((CounterBlockEntity)blockEntity);
                player.incrementStat(Stats.OPEN_BARREL);
                PiglinBrain.onGuardedBlockInteracted(player, true);
            }

            return ActionResult.CONSUME;
        }
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof Inventory) {
                ItemScatterer.spawn(world, pos, (Inventory)blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof CounterBlockEntity) {
            ((CounterBlockEntity)blockEntity).tick();
        }

    }

    @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CounterBlockEntity(pos, state);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (itemStack.hasCustomName()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CounterBlockEntity) {
                ((CounterBlockEntity)blockEntity).setCustomName(itemStack.getName());
            }
        }

    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, OPEN, WATERLOGGED});
    }

    public BlockState getPlacementState(Waterloggable waterloggable, ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(WATERLOGGED, Util.inWater(ctx)).with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    static {
        FACING = Properties.HORIZONTAL_FACING;
        OPEN = Properties.OPEN;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            case EAST ->  EAST_SHAPE;
            default -> NORTH_SHAPE;
        };
    }
}
