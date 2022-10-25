package net.linkle.valleycraft.block;

import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class FadedSoulRoseBlock extends SoulPlantBlock {
    
    public FadedSoulRoseBlock(Settings settings) {
        super(ParticleTypes.SMOKE, settings);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && world.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity living) {
                if (!living.isInvulnerableTo(DamageSource.MAGIC)) {
                    living.addStatusEffect(new StatusEffectInstance(ModEffects.SOUL_FADING, 40));
                }
            }
        }
    }
}
