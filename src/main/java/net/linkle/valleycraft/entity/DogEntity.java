package net.linkle.valleycraft.entity;

import org.jetbrains.annotations.Nullable;

import net.linkle.valleycraft.init.Entities;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class DogEntity extends WolfEntity {

    public static final int VARIANTS = 2;
    
    private static final TrackedData<Byte> DOG_TYPE = DataTracker.registerData(DogEntity.class, TrackedDataHandlerRegistry.BYTE);
    
    public DogEntity(EntityType<? extends DogEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public DogEntity createChild(ServerWorld serverWorld, PassiveEntity entity) {
        DogEntity child = Entities.DOG.create(serverWorld);
        int type = getDogType();
        if (random.nextBoolean() && entity instanceof DogEntity dog) {
            type = dog.getDogType();
        }
        child.setDogType(type);
        return child;
    }
    
    public int getDogType() {
        return dataTracker.get(DOG_TYPE);
    }

    public void setDogType(int rabbitType) {
        dataTracker.set(DOG_TYPE, (byte)rabbitType);
    }
    
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(DOG_TYPE, (byte)0);
    }
    
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("DogType", getDogType());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        setDogType(nbt.getInt("DogType"));
    }
    
    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        int type = world.getRandom().nextInt(VARIANTS);
        if (entityData instanceof DogData) {
            type = ((DogData)entityData).type;
        } else {
            entityData = new DogData(type);
        }
        setDogType(type);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
    
    protected static class DogData
    extends PassiveEntity.PassiveData {
        public final int type;

        public DogData(int type) {
            super(1f);
            this.type = type;
        }
    }
}
