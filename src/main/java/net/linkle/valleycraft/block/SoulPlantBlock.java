package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SoulPlantBlock extends ModPlantBlock {
    
    private final ParticleEffect particleEffect;
    
    public SoulPlantBlock(ParticleEffect effect, Settings settings) {
        super(settings);
        this.particleEffect = effect;
        shape = Block.createCuboidShape(5, 0, 5, 11, 10, 11);
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isOf(Blocks.NETHERRACK) || floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL);
    }
    
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double offset = 0.3;
        double x = pos.getX() + 0.5 + MathHelper.nextDouble(random, -offset, offset);
        double z = pos.getZ() + 0.5 + MathHelper.nextDouble(random, -offset, offset);
        world.addParticle(particleEffect, x, (double)pos.getY() + (0.7D - (random.nextDouble()*0.7)), z, 0, 0, 0);
    }
    
    public SoulPlantBlock smallShape() {
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
        return this;
    }
    
    public SoulPlantBlock largeShape() {
        shape = Block.createCuboidShape(2, 0, 2, 14, 12, 14);
        return this;
    }
    
    public static Settings settings(int luminance) {
        return Block.Settings.copy(Blocks.WITHER_ROSE).offsetType(OffsetType.NONE).luminance(s->luminance).ticksRandomly();
    }
}
