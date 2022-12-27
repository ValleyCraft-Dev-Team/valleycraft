package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModEntityType;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

public class StrongerTnTEntity extends Entity {
    private static final TrackedData<Integer> FUSE;
    private static final int DEFAULT_FUSE = 80;

    @Nullable
    private LivingEntity causingEntity;

    public StrongerTnTEntity(EntityType<StrongerTnTEntity> strongerTnt, World world) {
        super(strongerTnt, world);
        this.intersectionChecked = true;
    }

    public StrongerTnTEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this(ModEntityType.STRONGER_TNT, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * 6.2831854820251465D;
        this.setVelocity(-Math.sin(d) * 0.02D, 0.20000000298023224D, -Math.cos(d) * 0.02D);
        this.setFuse(120);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
    }

    protected void initDataTracker() {
        this.dataTracker.startTracking(FUSE, 80);
    }

    protected MoveEffect getMoveEffect() {
        return MoveEffect.NONE;
    }

    public boolean canHit() {
        return !this.isRemoved();
    }

    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0D, -0.04D, 0.0D));
        }

        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98D));
        if (this.onGround) {
            this.setVelocity(this.getVelocity().multiply(0.7D, -0.5D, 0.7D));
        }

        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.world.isClient) {
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.world.isClient) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    private void explode() {
        float f = 4.0F;
        this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 8.0F, Explosion.DestructionType.BREAK);
    }

    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short)this.getFuse());
    }

    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort("Fuse"));
    }

    @Nullable
    public LivingEntity getCausingEntity() {
        return this.causingEntity;
    }

    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15F;
    }

    public void setFuse(int fuse) {
        this.dataTracker.set(FUSE, fuse);
    }

    public int getFuse() {
        return (Integer)this.dataTracker.get(FUSE);
    }

    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    static {
        FUSE = DataTracker.registerData(TntEntity.class, TrackedDataHandlerRegistry.INTEGER);
    }
}
