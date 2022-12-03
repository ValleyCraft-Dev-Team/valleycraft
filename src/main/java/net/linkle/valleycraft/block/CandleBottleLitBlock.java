package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class CandleBottleLitBlock extends CandleBottleBlock {
    
    public CandleBottleLitBlock() {
        super(settings().ticksRandomly());
    }
    
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        var value = random.nextFloat();
        var yPos = 4/16d;
        if (value < 0.3f) {
            world.addParticle(ParticleTypes.SMOKE, 0.5, yPos, 0.5, 0.0, 0.0, 0.0);
            if (value < 0.17f) {
                world.playSound(1, yPos + 0.5, 1, SoundEvents.BLOCK_CANDLE_AMBIENT, SoundCategory.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        world.addParticle(ParticleTypes.SMALL_FLAME, 0.5, yPos, 0.5, 0.0, 0.0, 0.0);
    }
}
