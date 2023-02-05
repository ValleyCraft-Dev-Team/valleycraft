package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.Entities;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class DairyCowEntity extends CowEntity {

    public DairyCowEntity(net.minecraft.entity.EntityType entityType, World world) {
        super(entityType, world);
    }

    @Override
    public DairyCowEntity createChild(ServerWorld world, PassiveEntity entity) {
        return Entities.DAIRY_COW.create(world);
    }
}
