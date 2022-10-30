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

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(10) == 0) {
            world.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 1.0f, 0.9f, true);
        }

        for(int i = 0; i < 20; ++i) {
            spawnRainParticle((World)world, pos, true);
        }
    }

    public static void spawnRainParticle(World world, BlockPos pos, boolean lotsOfRain) {
        var random = world.getRandom();
        world.addParticle(ParticleTypes.RAIN, true, pos.getX() + 0.5 + random.nextDouble() / 3.0D * (random.nextBoolean() ? 1d : -1d), (pos.getY() + random.nextDouble() + random.nextDouble()) * -1d, pos.getZ() + 0.5 + random.nextDouble() / 3.0D * (random.nextBoolean() ? 1d : -1d), 0, -0.07, 0);
        if (lotsOfRain) {
            world.addParticle(ParticleTypes.RAIN, pos.getX() + 0.5 + random.nextDouble() / 4.0 * (random.nextBoolean() ? 1d : -1d), (pos.getY() + 0.4) * -1d, pos.getZ() + 0.5 + random.nextDouble() / 4.0 * (random.nextBoolean() ? 1d : -1d), 0.0, -0.005, 0.0);
        }
    }
}
