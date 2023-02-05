package net.linkle.valleycraft.entity.pupkins;

import net.linkle.valleycraft.init.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class PupkinEntity extends AnimalEntity {
    
    public static final Ingredient BREEDING_ITEMS = Ingredient.ofItems(Items.PUMPKIN_PIE);

    public PupkinEntity(net.minecraft.entity.EntityType entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        goalSelector.add(0, new SwimGoal(this));
        goalSelector.add(1, new EscapeDangerGoal(this, 2.0));
        goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        goalSelector.add(3, new TemptGoal(this, 1.25, BREEDING_ITEMS, false));
        goalSelector.add(4, new FollowParentGoal(this, 1.25));
        goalSelector.add(5, new WanderAroundFarGoal(this, 1.0));
        goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        goalSelector.add(7, new LookAroundGoal(this));
    }
    
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_ITEMS.test(stack);
    }
    
    @Override
    public void tickMovement() {
        super.tickMovement();
        //bodyYaw = getYaw();
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return EntityType.PUPKIN.create(world);
    }
    
    public static DefaultAttributeContainer.Builder createPupkinAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.175f);
    }
}
