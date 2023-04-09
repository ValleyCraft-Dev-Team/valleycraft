package net.linkle.valleycraft.block;

import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
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
        var shape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
        var vec = shape.getBoundingBox().getCenter();
        double x = (double)pos.getX() + vec.x;
        double z = (double)pos.getZ() + vec.z;
        for (int i = 0; i < 3; ++i) {
            if (!random.nextBoolean()) continue;
            var pm = MinecraftClient.getInstance().particleManager;
            var p = pm.addParticle(ParticleTypes.EFFECT, x + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), z + random.nextDouble() / 5.0, 0, 0, 0);
            var c = ModEffects.ROT_BLIGHT.getColor();
            var r = (float)(c >> 16 & 0xFF) / 255.0f;
            var g = (float)(c >> 8 & 0xFF) / 255.0f;
            var b = (float)(c >> 0 & 0xFF) / 255.0f;
            var v = 0.75f + random.nextFloat() * 0.25f;
            p.setColor(r*v, g * v, b * v);
        }
    }
}
