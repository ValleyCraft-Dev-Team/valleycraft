package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.EntityType;
import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class ChickenVariant extends ChickenEntity {
    
    public static final int VARIANTS = 3;
    
    private static final TrackedData<Byte> CHICKEN_TYPE = DataTracker.registerData(RabbitEntity.class, TrackedDataHandlerRegistry.BYTE);

    public ChickenVariant(net.minecraft.entity.EntityType type, World world) {
        super(type, world);
    }

    @Override
    public ChickenVariant createChild(ServerWorld serverWorld, PassiveEntity entity) {
        ChickenVariant child = EntityType.CHICKEN.create(serverWorld);
        int type = getChickenType();
        if (random.nextBoolean() && entity instanceof ChickenVariant chicken) {
            type = chicken.getChickenType();
        }
        child.setChickenType(type);
        return child;
    }
    
    public int getChickenType() {
        return dataTracker.get(CHICKEN_TYPE);
    }

    public void setChickenType(int rabbitType) {
        dataTracker.set(CHICKEN_TYPE, (byte)rabbitType);
    }
    
    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(CHICKEN_TYPE, (byte)0);
    }
    
    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("ChickenType", getChickenType());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        setChickenType(nbt.getInt("ChickenType"));
    }
    
    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        int type = world.getRandom().nextInt(VARIANTS);
        if (entityData instanceof ChickenData) {
            type = ((ChickenData)entityData).type;
        } else {
            entityData = new ChickenData(type);
        }
        setChickenType(type);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }
    
    public static class ChickenData
    extends PassiveEntity.PassiveData {
        public final int type;

        public ChickenData(int type) {
            super(1f);
            this.type = type;
        }
    }
}
