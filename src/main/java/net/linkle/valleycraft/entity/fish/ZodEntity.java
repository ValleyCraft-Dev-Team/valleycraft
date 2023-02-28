package net.linkle.valleycraft.entity.fish;

import net.linkle.valleycraft.init.Fishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
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
        goalSelector.add(1, new MeleeAttackGoal(this, 1, false));
    }
    
    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(Fishing.ZOD_BUCKET);
    }
}
