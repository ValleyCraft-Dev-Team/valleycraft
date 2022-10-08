package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModFishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.SchoolingFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class ZodEntity extends SchoolingFishEntity {

    public ZodEntity(EntityType<? extends SchoolingFishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModFishing.ZOD_BUCKET);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

}
