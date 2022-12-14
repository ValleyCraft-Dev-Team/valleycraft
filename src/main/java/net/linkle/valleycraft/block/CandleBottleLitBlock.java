package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CandleBottleLitBlock extends BottleBlock {
    
    public CandleBottleLitBlock() {
        super(settings().luminance(s->3));
    }
    
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        var value = random.nextFloat();
        var yPos = 5/16d;
        if (value < 0.3f) {
            world.addParticle(ParticleTypes.SMOKE, pos.getX()+0.5, pos.getY()+yPos, pos.getZ()+0.5, 0.0, 0.0, 0.0);
            if (value < 0.17f) {
                world.playSound(pos.getX()+1, pos.getY()+yPos + 0.5, pos.getZ()+1, SoundEvents.BLOCK_CANDLE_AMBIENT, SoundCategory.BLOCKS, 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
            }
        }
        world.addParticle(ParticleTypes.SMALL_FLAME, pos.getX()+0.5, pos.getY()+yPos, pos.getZ()+0.5, 0.0, 0.0, 0.0);
    }
}
