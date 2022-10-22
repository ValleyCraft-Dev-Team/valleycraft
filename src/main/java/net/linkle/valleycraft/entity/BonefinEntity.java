package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModFishing;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.ai.goal.SwimAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BonefinEntity extends FishEntity implements Monster {

    public BonefinEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    protected void initGoals() {
        goalSelector.add(1, new MeleeAttackGoal(this, 1, false));
        goalSelector.add(2, new SwimToRandomPlaceGoal());
        targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, false, this::canZodTarget));
        targetSelector.add(3, new ActiveTargetGoal<FishEntity>(this, FishEntity.class, false, this::canZodTarget));
    }
    
    public boolean canZodTarget(@Nullable LivingEntity target) {
        if (target != null) {
            return target.isTouchingWater() || !(target instanceof BonefinEntity);
        }
        return false;
    }
    
    @Override
    public EntityGroup getGroup() {
        return EntityGroup.UNDEAD;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModFishing.BONEFIN_BUCKET);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }
    
    public static DefaultAttributeContainer.Builder createZodAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0);
    }
    
    public static boolean canSpawn(EntityType<? extends WaterCreatureEntity> type, WorldAccess world, SpawnReason reason, BlockPos pos, Random random) {
        int level = world.getSeaLevel();
        int zone = level - 8;
        return pos.getY() >= zone && pos.getY() <= level && world.getFluidState(pos.down()).isIn(FluidTags.WATER) && world.getBlockState(pos.up()).isOf(Blocks.WATER);
    }

    class SwimToRandomPlaceGoal extends SwimAroundGoal {
        public SwimToRandomPlaceGoal() {
            super(BonefinEntity.this, 1.0, 40);
        }

        @Override
        public boolean canStart() {
            return hasSelfControl() && super.canStart();
        }
    }
}
