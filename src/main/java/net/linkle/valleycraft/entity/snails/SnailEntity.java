package net.linkle.valleycraft.entity.snails;

import net.linkle.valleycraft.init.Entities;
import net.linkle.valleycraft.init.FoodIngredients;
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

public class SnailEntity extends AnimalEntity {
    private static final Ingredient BREEDING_INGREDIENT;

    public SnailEntity(EntityType<? extends SnailEntity> type, World world) {
        super(type, world);
        setPathfindingPenalty(PathNodeType.WATER, 8.0F);
        setPathfindingPenalty(PathNodeType.WATER_BORDER, 16.0F);
        setPathfindingPenalty(PathNodeType.LAVA, 16.0F);
        setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0F);
        setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 16.0F);
    }

    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new AnimalMateGoal(this, 0.5D));
        goalSelector.add(2, new EscapeDangerGoal(this, 0.75D));
        goalSelector.add(3, new TemptGoal(this, 0.5D, BREEDING_INGREDIENT, false));
        goalSelector.add(4, new FollowParentGoal(this, 0.5D));
        goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
        goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 2.0F));
        goalSelector.add(7, new LookAroundGoal(this));
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return Entities.SNAIL.create(world);
    }

    public static DefaultAttributeContainer.Builder createSnailAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 3.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1);
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return true;
    }

    @Override
    public boolean hurtByWater() {
        return true;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    static {
        BREEDING_INGREDIENT = Ingredient.ofItems(Items.BEETROOT,
                FoodIngredients.HEARTY_BEETROOT, FoodIngredients.CAVE_ROOT, FoodIngredients.ONION);
    }
}
