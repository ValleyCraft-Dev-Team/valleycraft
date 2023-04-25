package net.linkle.valleycraft.entity.zombies;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.world.World;

public class ModHuskEntity extends HuskEntity {
    public ModHuskEntity(EntityType<? extends HuskEntity> entityType, World world) {
        super(entityType, world);
    }
}
