package net.linkle.valleycraft.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;
import java.util.Set;

public class ScaldingBlock extends MagmaBlock {
    private static final int SCHEDULED_TICK_DELAY = 20;

    public ScaldingBlock(Settings settings) {
        super(settings);
    }

    public static final Set<EntityType<?>> hurtList = Set.of(
            EntityType.FOX,
            EntityType.PLAYER,
            EntityType.WOLF,
            EntityType.ENDERMITE,
            EntityType.ENDERMAN,
            EntityType.VILLAGER,
            EntityType.WITCH,
            EntityType.WANDERING_TRADER,
            EntityType.PIG,
            EntityType.CAT,
            EntityType.CHICKEN,
            EntityType.PILLAGER,
            EntityType.COW,
            EntityType.FROG,
            EntityType.MOOSHROOM,
            EntityType.OCELOT,
            EntityType.PARROT,
            EntityType.POLAR_BEAR,
            EntityType.SILVERFISH,
            EntityType.TNT_MINECART
            );

    public static final Set<EntityType<?>> slimeList = Set.of(
            EntityType.SLIME,
            EntityType.MAGMA_CUBE
            );

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!entity.bypassesSteppingEffects() && entity instanceof LivingEntity && hurtList.contains(entity.getType())) {
            if (entity == hurtList) {
                entity.damage(DamageSource.HOT_FLOOR, 1.0F);
            }
        }
        if (entity == slimeList) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BlockPos blockPos = pos.up();
        if (world.getFluidState(pos).isIn(FluidTags.WATER)) {
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
            world.spawnParticles(ParticleTypes.LARGE_SMOKE, (double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.25D, (double)blockPos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
        }
        int i;
        double d;
        double e;
        double f;
        for(i = 0; i < 3; ++i) {
            d = (double) pos.getX() + random.nextDouble();
            e = (double) pos.getY() + random.nextDouble() * 0.5D + 0.5D;
            f = (double) pos.getZ() + random.nextDouble();
            world.addParticle(ParticleTypes.LAVA, d, e, f, 0.0D, 0.0D, 0.0D);
        }
        int ii = pos.getX();
        int jj = pos.getY();
        int kk = pos.getZ();
        double dd = (double)ii + random.nextDouble();
        double ee = (double)jj + 0.7D;
        double ff = (double)kk + random.nextDouble();
        world.addParticle(ParticleTypes.DRIPPING_LAVA, dd, ee, ff, 0.0D, 0.0D, 0.0D);
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        for(int l = 0; l < 14; ++l) {
            mutable.set(ii + MathHelper.nextInt(random, -10, 10), jj + random.nextInt(7), kk + MathHelper.nextInt(random, -10, 10));
            BlockState blockState = world.getBlockState(mutable);
            if (!blockState.isFullCube(world, mutable)) {
                world.addParticle(ParticleTypes.WHITE_ASH, (double)mutable.getX() + random.nextDouble(), (double)mutable.getY() + random.nextDouble(), (double)mutable.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BubbleColumnBlock.update(world, pos.up(), state);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.UP && neighborState.isOf(Blocks.WATER)) {
            world.createAndScheduleBlockTick(pos, this, 20);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        world.createAndScheduleBlockTick(pos, this, 20);
    }
}
