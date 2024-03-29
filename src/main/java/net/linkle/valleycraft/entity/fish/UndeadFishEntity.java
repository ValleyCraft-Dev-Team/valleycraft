package net.linkle.valleycraft.entity.fish;

import net.minecraft.entity.damage.DamageSource;
import org.jetbrains.annotations.Nullable;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public abstract class UndeadFishEntity extends FishEntity implements Monster {

    public UndeadFishEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    protected void initGoals() {
        goalSelector.add(1, new MeleeAttackGoal(this, 1, false));
        goalSelector.add(2, new SwimToRandomPlaceGoal());
    }
    
    public boolean canTarget0(@Nullable LivingEntity target) {
        if (target != null) {
            return target.isTouchingWater() && !(target instanceof UndeadFishEntity);
        }
        return false;
    }
    
    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COD_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_COD_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }
    
    public static DefaultAttributeContainer.Builder createUndeadFishAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }
    
    public static boolean canUndeadSpawn(EntityType<? extends WaterCreatureEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        int level = world.getSeaLevel();
        int zone = level - 8;
        return pos.getY() >= zone && pos.getY() <= level && world.getFluidState(pos.down()).isIn(FluidTags.WATER) && world.getBlockState(pos.up()).isOf(Blocks.WATER);
    }

    class SwimToRandomPlaceGoal extends SwimAroundGoal {
        public SwimToRandomPlaceGoal() {
            super(UndeadFishEntity.this, 1.0, 40);
        }

        @Override
        public boolean canStart() {
            return hasSelfControl() && super.canStart();
        }
    }
}
