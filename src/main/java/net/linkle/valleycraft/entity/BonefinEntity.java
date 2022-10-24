package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModFishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BonefinEntity extends UndeadFishEntity implements Monster {

    public BonefinEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModFishing.BONEFIN_BUCKET);
    }
}
