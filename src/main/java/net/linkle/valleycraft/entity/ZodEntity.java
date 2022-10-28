package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModFishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ZodEntity extends UndeadFishEntity implements Monster {

    public ZodEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    protected void initGoals() {
        super.initGoals();
        targetSelector.add(1, new RevengeGoal(this, new Class[0]));
        targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, false, this::canTarget0));
        targetSelector.add(3, new ActiveTargetGoal<FishEntity>(this, FishEntity.class, false, this::canTarget0));
    }
    
    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModFishing.ZOD_BUCKET);
    }
}
