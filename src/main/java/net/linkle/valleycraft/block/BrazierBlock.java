package net.linkle.valleycraft.block;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.linkle.valleycraft.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class BrazierBlock extends BlockWithWater {
    protected static final VoxelShape SHAPE = createCuboidShape(5, 0, 5, 11, 16, 11);
    protected static final BooleanProperty LIT = Properties.LIT;

    private final float fireDamage;

    public BrazierBlock(int luminance, float fireDamage) {
        super(Settings.of(Material.DECORATION)
                .sounds(BlockSoundGroup.STONE)
                .luminance(state -> state.get(LIT) ? luminance : 0)
                .strength(1.0f).nonOpaque());
        this.fireDamage = fireDamage;
        setDefaultState(newDefaultState().with(LIT, true));
    }
    
    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(LIT);
    }
    
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        var inWater = Util.inWater(ctx);
        var state = super.getPlacementState(ctx);
        return state.with(WATERLOGGED, inWater).with(LIT, !inWater);
    }
    
    public static void extinguish(@Nullable Entity entity, WorldAccess world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            var random = world.getRandom();
            for (int i = 0; i < 10; i++) {
                ((World)world).addParticle(ParticleTypes.SMOKE, 
                pos.getX() + 0.5 + random.nextDouble() / 4.0 * (random.nextBoolean() ? 1 : -1), pos.getY() + 1.2, 
                pos.getZ() + 0.5 + random.nextDouble() / 4.0 * (random.nextBoolean() ? 1 : -1), 0.0, 0.005, 0.0);
            }
        }
        world.emitGameEvent(entity, GameEvent.BLOCK_CHANGE, pos);
    }
    
    @Override
    public boolean tryFillWithFluid(WorldAccess world, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.get(Properties.WATERLOGGED) && fluidState.getFluid() == Fluids.WATER) {
            if (state.get(LIT)) {
                extinguish(null, world, pos, state);
                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
            world.setBlockState(pos, (BlockState)((BlockState)state.with(WATERLOGGED, true)).with(LIT, false), Block.NOTIFY_ALL);
            world.createAndScheduleFluidTick(pos, fluidState.getFluid(), fluidState.getFluid().getTickRate(world));
            return true;
        }
        return false;
    }
    
    @Override
    public void onProjectileHit(World world, BlockState state, BlockHitResult hit, ProjectileEntity projectile) {
        var pos = hit.getBlockPos();
        if (!world.isClient && projectile.isOnFire() && projectile.canModifyAt(world, pos) && !state.get(LIT) && !state.get(WATERLOGGED)) {
            world.setBlockState(pos, state.with(Properties.LIT, true), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
        }
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.isFireImmune() && state.get(LIT) && entity instanceof LivingEntity living && !EnchantmentHelper.hasFrostWalker(living)) {
            entity.damage(DamageSource.IN_FIRE, fireDamage);
        }
    }
    
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand,
            BlockHitResult hit) {
        var stack = player.getStackInHand(hand);
        if (stack.isIn(ConventionalItemTags.SHOVELS) && state.get(LIT)) {
            if (!world.isClient) {
                world.setBlockState(pos, state.with(Properties.LIT, false), Block.NOTIFY_ALL | Block.REDRAW_ON_MAIN_THREAD);
                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXTINGUISH_FIRE, SoundCategory.BLOCKS, 0.5f, 2f);
            }
            if (!player.getAbilities().creativeMode) {
                stack.damage(1, world.random, player instanceof ServerPlayerEntity server ? server : (ServerPlayerEntity)null);;
            }
            extinguish(player, world, pos, state);
            return ActionResult.success(world.isClient);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (!state.get(LIT))  {
            return;
        }

        if (random.nextInt(10) == 0) {
            world.playSound(pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, SoundEvents.BLOCK_CAMPFIRE_CRACKLE, SoundCategory.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
        }

        if (random.nextInt(100) == 0) {
            for(int i = 0; i < random.nextInt(1) + 1; ++i) {
                world.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, random.nextFloat() / 2.0F, 5.0E-5D, random.nextFloat() / 2.0F);
            }
        }
    }
}

