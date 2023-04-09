package net.linkle.valleycraft.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer.Builder;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.World;

public class DogEntity extends WolfEntity {
    
    public DogEntity(EntityType<? extends DogEntity> entityType, World world) {
        super(entityType, world);
    }

	public static Builder createDogAttributes() {
		return createWolfAttributes();
	}
}
