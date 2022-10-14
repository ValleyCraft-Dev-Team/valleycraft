package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class SnailEntity extends AnimalEntity {

    public SnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new MeleeAttackGoal(this, 8.0, false){
            @Override
            protected void resetCooldown() {
            }
            
            @Override
            protected int getMaxCooldown() {
                return 0;
            }
            @Override
            protected int getTickCount(int ticks) {
                return 0;
            }
            @Override
            protected double getSquaredMaxAttackDistance(LivingEntity entity) {
                return 0;
            }
        });
        //goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        //this.goalSelector.add(3, new TemptGoal(this, 1.25, Ingredient.ofItems(Items.WHEAT), false));
        goalSelector.add(3, new FollowParentGoal(this, 1.25));
        goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        goalSelector.add(6, new LookAroundGoal(this));
        targetSelector.add(0, new ActiveTargetGoal<MobEntity>(this, MobEntity.class, false) {
            @Override
            public boolean canStart() {
                this.findClosestTarget();
                return this.targetEntity != null;
            }
        });
    }
    
    @Override
    public void tickMovement() {
        super.tickMovement();
        var entites = world.getEntitiesByClass(MobEntity.class, getBoundingBox().expand(1.5), e -> {
            return e.getClass() != SnailEntity.class && e.isAlive();
        });
        for (var entity : entites) {
            var offset = entity.getPos().subtract(getPos()).normalize();
            entity.setVelocity(offset.x*0.5, 0.8, offset.z*0.5);
            entity.setPosition(entity.getPos().add(offset.x*1.0, 2, offset.z*1.0));
            
            entity.damage(DamageSource.GENERIC, 1000);
            if (!world.isClient) 
            world.getServer().execute(() -> {
                if (entity.isAlive()) {
                }
            });
            
        }
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntityType.SNAIL.create(world);
    }
    
    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0).add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.3).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10000.0);
    }
}
