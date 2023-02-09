package net.linkle.valleycraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class BearEntity extends PolarBearEntity {

    public BearEntity(EntityType<? extends BearEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AttackGoal());
        this.goalSelector.add(1, new PolarBearEscapeDangerGoal());
        this.goalSelector.add(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.add(5, new WanderAroundGoal(this, 1.0));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(7, new LookAroundGoal(this));
        this.targetSelector.add(1, new PolarBearRevengeGoal());
        this.targetSelector.add(2, new ProtectBabiesGoal());
        this.targetSelector.add(3, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, 10, true, false, this::shouldAngerAt));
        this.targetSelector.add(4, new ActiveTargetGoal<FoxEntity>(this, FoxEntity.class, 10, true, true, null));
        this.targetSelector.add(5, new UniversalAngerGoal<PolarBearEntity>(this, false));
    }
    
    public static DefaultAttributeContainer.Builder createBearAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 20.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0);
    }
    
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return EntityType.POLAR_BEAR.create(world);
    }
    
    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(BearEntity.this, 1.25, true);
        }

        @Override
        protected void attack(LivingEntity target, double squaredDistance) {
            double d = this.getSquaredMaxAttackDistance(target);
            if (squaredDistance <= d && this.isCooledDown()) {
                this.resetCooldown();
                this.mob.tryAttack(target);
                setWarning(false);
            } else if (squaredDistance <= d * 2.0) {
                if (this.isCooledDown()) {
                    setWarning(false);
                    this.resetCooldown();
                }
                if (this.getCooldown() <= 10) {
                    setWarning(true);
                    playWarningSound();
                }
            } else {
                this.resetCooldown();
                setWarning(false);
            }
        }

        @Override
        public void stop() {
            setWarning(false);
            super.stop();
        }

        @Override
        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            return 4.0f + entity.getWidth();
        }
    }

    class PolarBearEscapeDangerGoal extends EscapeDangerGoal {
        public PolarBearEscapeDangerGoal() {
            super(BearEntity.this, 2.0);
        }

        @Override
        protected boolean isInDanger() {
            return this.mob.getAttacker() != null && this.mob.isBaby() || this.mob.isOnFire();
        }
    }

    class PolarBearRevengeGoal extends RevengeGoal {
        public PolarBearRevengeGoal() {
            super(BearEntity.this, new Class[0]);
        }

        @Override
        public void start() {
            super.start();
            if (isBaby()) {
                this.callSameTypeForRevenge();
                this.stop();
            }
        }

        @Override
        protected void setMobEntityTarget(MobEntity mob, LivingEntity target) {
            if (mob instanceof BearEntity && !mob.isBaby()) {
                super.setMobEntityTarget(mob, target);
            }
        }
    }

    class ProtectBabiesGoal extends ActiveTargetGoal<PlayerEntity> {
        public ProtectBabiesGoal() {
            super(BearEntity.this, PlayerEntity.class, 20, true, true, null);
        }

        @Override
        public boolean canStart() {
            if (isBaby()) {
                return false;
            }
            if (super.canStart()) {
                var list = world.getNonSpectatingEntities(BearEntity.class, getBoundingBox().expand(8.0, 4.0, 8.0));
                for (var entity : list) {
                    if (!entity.isBaby()) continue;
                    return true;
                }
            }
            return false;
        }

        @Override
        protected double getFollowRange() {
            return super.getFollowRange() * 0.5;
        }
    }
}
