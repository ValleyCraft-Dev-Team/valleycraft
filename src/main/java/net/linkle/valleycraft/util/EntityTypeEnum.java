package net.linkle.valleycraft.util;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;

/** For Enum classes that contains EntityType. This interface adds common methods. */
public interface EntityTypeEnum extends IdProvider {
    
    <T extends Entity> EntityType<T> type();
    
    default <T extends Entity> T create(ServerWorld world) {
        return (T) type().create(world);
    }
    
    static void registerAttribute(EntityTypeEnum entityType, DefaultAttributeContainer.Builder builder) {
        FabricDefaultAttributeRegistry.register(entityType.type(), builder);
    }
    
    public static <E extends Entity> void registerRenderer(EntityTypeEnum entityType, EntityRendererFactory<E> entityRendererFactory) {
        EntityRendererRegistry.register(entityType.type(), entityRendererFactory);
    }
    
    public static <T extends Entity> FabricEntityTypeBuilder<T> createEntity(SpawnGroup group, EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.<T>create(group, factory);
    }
    
    static <T extends LivingEntity> FabricEntityTypeBuilder.Living<T> createLiving(SpawnGroup group, EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.<T>createLiving().spawnGroup(group).entityFactory(factory);
    }
    
    static <T extends MobEntity> FabricEntityTypeBuilder.Mob<T> createMob(SpawnGroup group, EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.<T>createMob().spawnGroup(group).entityFactory(factory);
    }
}
