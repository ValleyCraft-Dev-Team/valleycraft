package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.PlantVoxelShapes;
import net.minecraft.block.*;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SoulPlantBlock extends ModPlantBlock {
    
    private final ParticleEffect particleEffect;
    
    public SoulPlantBlock(ParticleEffect effect, Settings settings) {
        super(settings);
        this.particleEffect = effect;
        shape = PlantVoxelShapes.FLOWER_SHAPE;
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }
    
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        var shape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        var vec = shape.getBoundingBox().getCenter();
        double x = (double)pos.getX() + vec.x;
        double z = (double)pos.getZ() + vec.z;
        for (int i = 0; i < 3; ++i) {
            if (!random.nextBoolean()) continue;
            world.addParticle(particleEffect, x + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), z + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
        }
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
        return Block.Settings.copy(Blocks.WITHER_ROSE).luminance(s->luminance);
    }
}
