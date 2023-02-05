package net.linkle.valleycraft.entity.projectiles.thrown_items;

import static net.linkle.valleycraft.init.Tools.THROWING_ROCK;

import net.linkle.valleycraft.init.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ThrownRockEntity extends ThrownItemEntity {

    public ThrownRockEntity(net.minecraft.entity.EntityType entityType, World world) {
        super(entityType, world);
    }

    private ThrownRockEntity(World world, PlayerEntity user) {
        super(Entities.THROWN_ROCK.type(), user, world);
    }
    
    public static ThrownRockEntity create(World world, PlayerEntity user) {
        return new ThrownRockEntity(world, user);
    }

    @Override
    protected Item getDefaultItem() {
        return THROWING_ROCK;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        int i = 3;
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), (float)i); // deals damage
        if (entity instanceof LivingEntity livingEntity) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)
            //livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.POISON, 20 * 3, 1))); // applies a status effect
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }
    }
}
