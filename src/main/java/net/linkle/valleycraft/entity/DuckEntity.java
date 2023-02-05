package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.Entities;
import net.linkle.valleycraft.init.Sounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DuckEntity extends AnimalEntity {

    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.KELP);
    private static final int DROP_DURATION = 6000;
    
    public float flapProgress;
    public float maxWingDeviation;
    public float prevMaxWingDeviation;
    public float prevFlapProgress;
    public float flapSpeed = 1.0f;
    private float field = 1.0f;
    
    private int eggLayTime = getRandomTime();
    private int dropFeatherTime = getRandomTime();

    public DuckEntity(EntityType<? extends DuckEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        goalSelector.add(3, new TemptGoal(this, 1.0, BREEDING_INGREDIENT, false));
        goalSelector.add(4, new FollowParentGoal(this, 1.1));
        goalSelector.add(5, new WanderAroundGoal(this, 1.0));
        goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6f));
        goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public ChickenEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        return Entities.DUCK.create(serverWorld);
    }
    
    @Override
    public void tickMovement() {
        super.tickMovement();
        
        prevFlapProgress = flapProgress;
        prevMaxWingDeviation = maxWingDeviation;
        maxWingDeviation += (onGround && !touchingWater ? -1.0f : 4.0f) * 0.3f;
        maxWingDeviation = MathHelper.clamp(maxWingDeviation, 0.0f, 1.0f);
        if (!onGround && !touchingWater && flapSpeed < 1.0f) {
            this.flapSpeed = 1.0f;
        }
        flapSpeed *= 0.9f;
        var vel = this.getVelocity();
        if (!this.onGround && vel.y < 0.0) {
            this.setVelocity(vel.multiply(1.0, 0.6, 1.0));
        }
        flapProgress += flapSpeed * 2.0f;
        
        if (!world.isClient && isAlive() && !isBaby()) {
            if (--eggLayTime <= 0) {
                playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
                eggLayTime = getRandomTime();
                dropItem(Items.EGG); // TODO Duck egg
            }
            if (--dropFeatherTime <= 0) {
                dropFeatherTime = getRandomTime();
                dropItem(Items.FEATHER);
            }
        }
    }
    
    @Override
    protected boolean hasWings() {
        return speed > field;
    }

    @Override
    protected void addFlapEffects() {
        field = speed + maxWingDeviation / 2.0f;
    }
    
    @Override
    public boolean handleFallDamage(float fallDistance, float damageMultiplier, DamageSource damageSource) {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return Sounds.DUCK_QUACK.sound;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return Sounds.DUCK_QUACK.sound;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return Sounds.DUCK_QUACK.sound;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        dropFeatherTime = nbt.getInt("DropFeatherTime");
        eggLayTime  = nbt.getInt("EggLayTime");
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("DropFeatherTime", dropFeatherTime);
        nbt.putInt("EggLayTime", eggLayTime);
    }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new MobNavigation(this, world) {
            @Override
            public boolean isValidPosition(BlockPos pos) {
                pos = pos.down();
                return world.getBlockState(pos).isOpaqueFullCube(world, pos) || world.isWater(pos);
            }
        };
    }

    private int getRandomTime() {
        return random.nextInt(DROP_DURATION) + DROP_DURATION;
    }
    
    public static DefaultAttributeContainer.Builder createDuckAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 4.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }
}
