package net.linkle.valleycraft.entity.zombies;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.world.World;

public class ZombieEntity extends net.minecraft.entity.mob.ZombieEntity {
    public ZombieEntity(EntityType<? extends net.minecraft.entity.mob.ZombieEntity> entityType, World world) {
        super(entityType, world);
    }
}
