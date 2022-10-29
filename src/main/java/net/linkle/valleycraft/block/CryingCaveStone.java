package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CryingCaveStone extends Block{
    public CryingCaveStone(Settings settings) {
        super(settings);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(10) == 0) {
            world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 1.0f, 0.9f, true);
        }

        if (world.isClient()) {
            for(int i = 0; i < 20; ++i) {
                spawnRainParticle((World)world, pos, true);
            }
        }
    }


    public static void spawnRainParticle(World world, BlockPos pos, boolean lotsOfRain) {
        Random random = world.getRandom();
        DefaultParticleType defaultParticleType = ParticleTypes.RAIN;
        world.addImportantParticle(defaultParticleType, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), ((double)pos.getY() + random.nextDouble() + random.nextDouble()) * -1, (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, -0.07D, 0.0D);
        if (lotsOfRain) {
            world.addParticle(ParticleTypes.RAIN, (double)pos.getX() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1), ((double)pos.getY() + 0.4D) * -1, (double)pos.getZ() + 0.5D + random.nextDouble() / 4.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, -0.005D, 0.0D);
        }

    }
}
