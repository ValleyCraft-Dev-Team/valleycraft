package net.linkle.valleycraft.block;

import net.linkle.valleycraft.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;

public class DivineOakLog extends HorizontalBlock {
    public DivineOakLog(Settings settings) {
        super(settings);
    }
}
