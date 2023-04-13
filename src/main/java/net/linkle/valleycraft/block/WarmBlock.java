package net.linkle.valleycraft.block;

import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class WarmBlock extends Block {
    public WarmBlock(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        BubbleColumnBlock.update(world, pos.up(), state);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, ServerWorld world, Direction direction, BlockState neighborState, BlockPos pos, BlockPos neighborPos, Random random) {
        if (direction == Direction.UP && neighborState.isOf(Blocks.WATER) || neighborState.isOf(Blocks.AIR)) {
            if (random.nextInt(10) == 0) {
                DefaultParticleType defaultParticleType = ParticleTypes.CAMPFIRE_COSY_SMOKE;
                world.addImportantParticle(defaultParticleType, true, (double) pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double) (random.nextBoolean() ? 1 : -1), (double) pos.getY() + random.nextDouble() + random.nextDouble(), (double) pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double) (random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
                world.addParticle(ParticleTypes.SMOKE, (double) pos.getX() + 0.5D + random.nextDouble() / 4.0D * (double) (random.nextBoolean() ? 1 : -1), (double) pos.getY() + 0.4D, (double) pos.getZ() + 0.5D + random.nextDouble() / 4.0D * (double) (random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
            }
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient) {
            if (entity instanceof LivingEntity living) {
                living.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 3, 0, true, false));
            }
        }
    }
}
