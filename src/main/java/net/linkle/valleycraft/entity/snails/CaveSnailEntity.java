package net.linkle.valleycraft.entity.snails;

import net.linkle.valleycraft.init.IngredientFoodItems;
import net.linkle.valleycraft.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class CaveSnailEntity extends AnimalEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public CaveSnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, 8.0F);
        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0F);
        this.setPathfindingPenalty(PathNodeType.LAVA, 16.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 16.0F);
    }
    
    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AnimalMateGoal(this, 0.5D));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 0.75D));
        this.goalSelector.add(3, new TemptGoal(this, 0.5D, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 0.5D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 2.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));
    }
    
    @Override
    public void tickMovement() {
        super.tickMovement();
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntityType.SNAIL.create(world);
    }

    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }

    public boolean canBeLeashedBy(PlayerEntity player) {
        return true;
    }

    public boolean hurtByWater() {
        return true;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(new ItemConvertible[]{
                Items.BEETROOT,
                IngredientFoodItems.HEARTY_BEETROOT,
                IngredientFoodItems.CAVE_ROOT,
                IngredientFoodItems.ONION
        });
    }
}
