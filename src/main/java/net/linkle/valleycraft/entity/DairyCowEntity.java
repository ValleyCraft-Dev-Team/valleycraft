package net.linkle.valleycraft.entity;

import net.linkle.valleycraft.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class DairyCowEntity extends CowEntity {

    public DairyCowEntity(EntityType<? extends DairyCowEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public DairyCowEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntityType.DAIRY_COW.create(world);
    }
}
