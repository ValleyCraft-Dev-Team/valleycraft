package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.PupkinEntityModel;
import net.linkle.valleycraft.client.entity.model.SnailEntityModel;
import net.linkle.valleycraft.client.entity.renderer.PupkinEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.SnailEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.SoulPetEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.ZodEntityRenderer;
import net.linkle.valleycraft.entity.*;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.SpawnRestriction.Location;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class ModEntityType {

    public static final EntityType<SnailEntity> SNAIL = register("snail", 
            FabricEntityTypeBuilder.createMob().entityFactory(SnailEntity::new).spawnGroup(SpawnGroup.CREATURE)
            .dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(5).build());

    public static final EntityType<ZodEntity> ZOD = register("zod",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.MONSTER).entityFactory(ZodEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZodEntity::canSpawn).build()
    );

    public static final EntityType<ThrownRockEntity> THROWN_ROCK = register("thrown_rock",
            FabricEntityTypeBuilder.<ThrownRockEntity>create(SpawnGroup.MISC, ThrownRockEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );
    
    public static final EntityType<PupkinEntity> PUPKIN = register("pupkin", 
            FabricEntityTypeBuilder.createMob().entityFactory(PupkinEntity::new).spawnGroup(SpawnGroup.CREATURE)
            .dimensions(new EntityDimensions(0.6F, 0.8F, true)).trackRangeChunks(6)
            .spawnRestriction(Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn).build());
    
    public static final EntityType<SoulPetEntity> SOUL_PET = register("soul_pet", 
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, SoulPetEntity::new)
            .trackRangeChunks(8).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).build());

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(SNAIL, SnailEntity.createSnailAttributes());
        FabricDefaultAttributeRegistry.register(ZOD, ZodEntity.createZodAttributes());
        FabricDefaultAttributeRegistry.register(PUPKIN, PupkinEntity.createPupkinAttributes());
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SnailEntityModel.LAYER, SnailEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(SNAIL, SnailEntityRenderer.create("snail"));
        
        EntityModelLayerRegistry.registerModelLayer(PupkinEntityModel.LAYER, PupkinEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(PUPKIN, PupkinEntityRenderer::new);
        
        EntityRendererRegistry.register(ZOD, ZodEntityRenderer.create("zod"));
        EntityRendererRegistry.register(SOUL_PET, SoulPetEntityRenderer::new);
        EntityRendererRegistry.register(THROWN_ROCK, FlyingItemEntityRenderer::new);
    }
    
    private static <T extends Entity> EntityType<T> register(String id, EntityType<T> entity) {
        return Registry.register(Registry.ENTITY_TYPE, Main.makeId(id), entity);
    }
}
