package net.linkle.valleycraft.entity.fish;

import net.linkle.valleycraft.init.Fishing;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class AbysswatcherEntity extends FishEntity {

    public AbysswatcherEntity(EntityType<? extends FishEntity> type, World world) {
        super(type, world);
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(Fishing.ABYSSWATCHER_BUCKET);
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
}
