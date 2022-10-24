package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModFishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ZodEntity extends UndeadFishEntity implements Monster {

    public ZodEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModFishing.ZOD_BUCKET);
    }
}
