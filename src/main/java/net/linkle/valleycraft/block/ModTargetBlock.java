package net.linkle.valleycraft.block;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class ModTargetBlock extends HorizontalWithWaterBlock {
    private static final double OFFSET = -0.2;
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(1, 2+OFFSET, 2, 15, 16+OFFSET, 9);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(1, 2+OFFSET, 7, 15, 16+OFFSET, 14);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(7, 2+OFFSET, 1, 14, 16+OFFSET, 15);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(2, 2+OFFSET, 1, 9, 16+OFFSET, 15);
    
    private static final IntProperty POWER = Properties.POWER;
    private static final int RECOVERABLE_POWER_DELAY = 20;
    private static final int REGULAR_POWER_DELAY = 8;

    public ModTargetBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected BlockState newDefaultState() {
        return super.newDefaultState().with(POWER, 0);
    }
    
    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        var power = trigger(world, state, hit, projectile);
        var entity = projectile.getOwner();
        if (entity instanceof ServerPlayerEntity player) {
            player.incrementStat(Stats.TARGET_HIT);
            Criteria.TARGET_HIT.trigger(player, projectile, hit.getPos(), power);
        }
    }

    private static int trigger(WorldAccess world, BlockState state, BlockHitResult hitResult, Entity entity) {
        int power = calculatePower(state.get(FACING), hitResult, hitResult.getPos());
        int delay = entity instanceof PersistentProjectileEntity ? RECOVERABLE_POWER_DELAY : REGULAR_POWER_DELAY;
        if (!world.getBlockTickScheduler().isQueued(hitResult.getBlockPos(), state.getBlock())) {
            setPower(world, state, power, hitResult.getBlockPos(), delay);
        }
        return power;
    }
    
    private static int calculatePower(Direction face, BlockHitResult hitResult, Vec3d pos) {
        var side = hitResult.getSide();
        if (side != face) return 0;
        var x = Math.abs(MathHelper.fractionalPart(pos.x) - (8/16d)) * (1+(2/16d));
        var y = Math.abs(MathHelper.fractionalPart(pos.y) - (9/16d)) * (1+(2/16d)+OFFSET);
        var z = Math.abs(MathHelper.fractionalPart(pos.z) - (8/16d)) * (1+(2/16d));
        var value = side.getAxis() == Direction.Axis.Z ? Math.max(x, y) : Math.max(y, z);
        return Math.max(1, MathHelper.ceil(15.0 * MathHelper.clamp((0.5 - value) / 0.5, 0.0, 1.0)));
    }
    
    private static void setPower(WorldAccess world, BlockState state, int power, BlockPos pos, int delay) {
        world.setBlockState(pos, state.with(POWER, power), Block.NOTIFY_ALL);
        world.createAndScheduleBlockTick(pos, state.getBlock(), delay);
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
    
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(POWER) != 0) {
            world.setBlockState(pos, (BlockState)state.with(POWER, 0), Block.NOTIFY_ALL);
        }
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(POWER);
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder.add(POWER));
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (world.isClient() || state.isOf(oldState.getBlock())) {
            return;
        }
        if (state.get(POWER) > 0 && !world.getBlockTickScheduler().isQueued(pos, this)) {
            world.setBlockState(pos, state.with(POWER, 0), Block.NOTIFY_LISTENERS | Block.FORCE_STATE);
        }
    }

    @Override
    protected Direction getFacing(ItemPlacementContext ctx) {
        return super.getFacing(ctx).getOpposite();
    }
}
