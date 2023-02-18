package net.linkle.valleycraft.block;

import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class PoisonPlantBlock extends ModPlantBlock {

    public PoisonPlantBlock(VoxelShape shape, Settings settings) {
        super(shape, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity living) {
            living.addStatusEffect(new StatusEffectInstance(ModEffects.ROT_BLIGHT, 3*20));
        }
    }
    
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        int color = ModEffects.ROT_BLIGHT.getColor();
        double r = (double)(color >> 16 & 0xFF) / 255.0;
        double g = (double)(color >> 8 & 0xFF) / 255.0;
        double b = (double)(color >> 0 & 0xFF) / 255.0;
        var shape = getOutlineShape(state, world, pos, ShapeContext.absent());
        Vec3d center = shape.getBoundingBox().getCenter();
        world.addParticle(ParticleTypes.EFFECT, pos.getX()+center.getX(), pos.getY()+center.getY(), pos.getZ()+center.getZ(), r, g, b);
    }
}
