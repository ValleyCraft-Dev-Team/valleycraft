package net.linkle.valleycraft.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import static net.linkle.valleycraft.init.ModEntities.ThrownBoneDartEntityType;
import static net.linkle.valleycraft.init.ModTools.BONE_DART_ITEM;

public class ThrownBoneDartEntity extends ThrownItemEntity {

    public ThrownBoneDartEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrownBoneDartEntity(World world, LivingEntity owner) {
        super(ThrownBoneDartEntityType, owner, world);
    }

    public ThrownBoneDartEntity(World world, double x, double y, double z) {
        super(ThrownBoneDartEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return BONE_DART_ITEM;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = 3;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i); // deals damage
        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            //livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 1))); // applies a status effect
        }
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }
    }
}
