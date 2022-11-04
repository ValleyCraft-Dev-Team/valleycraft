package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MimicFlowerBlock extends ModFlowerBlock {
    
    public MimicFlowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(24) == 0) {
            world.playSound(pos.getX()+0.5, pos.getY()+0.4, pos.getZ()+0.5, SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.BLOCKS, 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
        }
        var shape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        var vec = shape.getBoundingBox().getCenter();
        double x = (double)pos.getX() + vec.x;
        double z = (double)pos.getZ() + vec.z;
        for (int i = 0; i < 3; ++i) {
            if (!random.nextBoolean()) continue;
            world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, x + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), z + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public static Settings settings(int luminance) {
        return Block.Settings.copy(Blocks.WITHER_ROSE).luminance(s->luminance);
    }
}
