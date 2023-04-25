package net.linkle.valleycraft.entity.zombies;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class FrozenZombieEntity extends ZombieEntity {
    public FrozenZombieEntity(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }
}
