package net.linkle.valleycraft.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class MossySheepEntity extends AnimalEntity implements Shearable {

    private static final TrackedData<Boolean> SHEARED = DataTracker.registerData(SheepEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    
    private int eatGrassTimer;
    private EatGrassGoal eatGrassGoal;

    public MossySheepEntity(EntityType<? extends MossySheepEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void initGoals() {
        eatGrassGoal = new EatGrassGoal(this);
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new EscapeDangerGoal(this, 1.25));
        goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        goalSelector.add(3, new TemptGoal(this, 1.1, Ingredient.ofItems(Items.WHEAT), false));
        goalSelector.add(4, new FollowParentGoal(this, 1.1));
        goalSelector.add(5, this.eatGrassGoal);
        goalSelector.add(6, new WanderAroundFarGoal(this, 1.0));
        goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        goalSelector.add(8, new LookAroundGoal(this));
    }

    @Override
    protected void mobTick() {
        eatGrassTimer = eatGrassGoal.getTimer();
        super.mobTick();
    }

    @Override
    public void tickMovement() {
        if (world.isClient) {
            eatGrassTimer = Math.max(0, eatGrassTimer - 1);
        }
        super.tickMovement();
    }

    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        dataTracker.startTracking(SHEARED, false);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.SET_SHEEP_EAT_GRASS_TIMER_OR_PRIME_TNT_MINECART) {
            eatGrassTimer = 40;
        } else {
            super.handleStatus(status);
        }
    }

    public float getNeckAngle(float delta) {
        if (eatGrassTimer <= 0) {
            return 0.0f;
        }
        if (eatGrassTimer >= 4 && eatGrassTimer <= 36) {
            return 1.0f;
        }
        if (eatGrassTimer < 4) {
            return ((float)eatGrassTimer - delta) / 4.0f;
        }
        return -((float)(eatGrassTimer - 40) - delta) / 4.0f;
    }

    public float getHeadAngle(float delta) {
        if (eatGrassTimer > 4 && eatGrassTimer <= 36) {
            float f = ((float)(eatGrassTimer - 4) - delta) / 32.0f;
            return 0.62831855f + 0.21991149f * MathHelper.sin(f * 28.7f);
        }
        if (eatGrassTimer > 0) {
            return 0.62831855f;
        }
        return this.getPitch() * (MathHelper.PI / 180f);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (stack.isOf(Items.SHEARS)) {
            if (!world.isClient && isShearable()) {
                sheared(SoundCategory.PLAYERS);
                emitGameEvent(GameEvent.SHEAR, player);
                stack.damage(1, player, p -> p.sendToolBreakStatus(hand));
                return ActionResult.SUCCESS;
            }
            return ActionResult.CONSUME;
        }
        return super.interactMob(player, hand);
    }

    @Override
    public void sheared(SoundCategory shearedSoundCategory) {
        world.playSoundFromEntity(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0f, 1.0f);
        setSheared(true);
        int i = 1 + random.nextInt(3);
        for (int j = 0; j < i; ++j) {
            var entity = dropItem(Items.MOSS_BLOCK, 1);
            if (entity == null) continue;
            entity.setVelocity(entity.getVelocity().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1f, this.random.nextFloat() * 0.05f, (this.random.nextFloat() - this.random.nextFloat()) * 0.1f));
        }
    }

    @Override
    public boolean isShearable() {
        return isAlive() && !isSheared() && !isBaby();
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("Sheared", isSheared());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        setSheared(nbt.getBoolean("Sheared"));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SHEEP_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15f, 1.0f);
    }

    public boolean isSheared() {
        return dataTracker.get(SHEARED);
    }

    public void setSheared(boolean sheared) {
        dataTracker.set(SHEARED, sheared);
    }

    @Override
    public MossySheepEntity createChild(ServerWorld serverWorld, PassiveEntity entity) {
        return null;
    }

    @Override
    public void onEatingGrass() {
        super.onEatingGrass();
        setSheared(false);
        if (isBaby()) {
            growUp(60);
        }
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.95f * dimensions.height;
    }
}
