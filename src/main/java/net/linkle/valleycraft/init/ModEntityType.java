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
import net.linkle.valleycraft.client.entity.renderer.*;
import net.linkle.valleycraft.entity.*;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.SpawnRestriction.Location;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class ModEntityType {

    public static final EntityType<SnailEntity> SNAIL = register("snail", 
            FabricEntityTypeBuilder.createMob().entityFactory(SnailEntity::new).spawnGroup(SpawnGroup.CREATURE)
            .dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(5).build());

    public static final EntityType<ZodEntity> ZOD = register("zod",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.MONSTER).entityFactory(ZodEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, UndeadFishEntity::canSpawn).build()
    );

    public static final EntityType<BonefinEntity> BONEFIN = register("bonefin",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.MONSTER).entityFactory(BonefinEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, UndeadFishEntity::canSpawn).build()
    );

    public static final EntityType<StonetosserMinnowEntity> STONETOSSER_MINNOW = register("stonetosser_minnow",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_CREATURE).entityFactory(StonetosserMinnowEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StonetosserMinnowEntity::canSpawn).build()
    );

    public static final EntityType<AbysswatcherEntity> ABYSSWATCHER = register("abysswatcher",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_CREATURE).entityFactory(AbysswatcherEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbysswatcherEntity::canSpawn).build()
    );

    public static final EntityType<SardineEntity> SARDINE = register("sardine",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_CREATURE).entityFactory(SardineEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SardineEntity::canSpawn).build()
    );

    public static final EntityType<RedPorgyEntity> RED_PORGY = register("red_porgy",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_CREATURE).entityFactory(RedPorgyEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RedPorgyEntity::canSpawn).build()
    );

    public static final EntityType<PerchEntity> PERCH = register("perch",
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_CREATURE).entityFactory(PerchEntity::new)
                    .trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PerchEntity::canSpawn).build()
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
        FabricDefaultAttributeRegistry.register(PUPKIN, PupkinEntity.createPupkinAttributes());
        
        FabricDefaultAttributeRegistry.register(ZOD, UndeadFishEntity.createUndeadFishAttributes());
        FabricDefaultAttributeRegistry.register(BONEFIN, UndeadFishEntity.createUndeadFishAttributes());
        FabricDefaultAttributeRegistry.register(STONETOSSER_MINNOW, FishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSWATCHER, FishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(SARDINE, FishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(RED_PORGY, FishEntity.createFishAttributes());
        FabricDefaultAttributeRegistry.register(PERCH, FishEntity.createFishAttributes());
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SnailEntityModel.LAYER, SnailEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(SNAIL, SnailEntityRenderer.create("snail"));
        
        EntityModelLayerRegistry.registerModelLayer(PupkinEntityModel.LAYER, PupkinEntityModel::getTexturedModelData);
        EntityRendererRegistry.register(PUPKIN, PupkinEntityRenderer::new);
        
        EntityRendererRegistry.register(ZOD, CodEntityRenderer.create("zod"));
        EntityRendererRegistry.register(ABYSSWATCHER, CodEntityRenderer.create("abysswatcher"));
        EntityRendererRegistry.register(BONEFIN, SalmonEntityRenderer.create("bonefin"));
        EntityRendererRegistry.register(STONETOSSER_MINNOW, CodEntityRenderer.create("minnow"));
        EntityRendererRegistry.register(PERCH, CodEntityRenderer.create("perch"));
        EntityRendererRegistry.register(RED_PORGY, CodEntityRenderer.create("red_porgy"));
        EntityRendererRegistry.register(SARDINE, CodEntityRenderer.create("sardine"));
        
        EntityRendererRegistry.register(SOUL_PET, SoulPetEntityRenderer::new);
        EntityRendererRegistry.register(THROWN_ROCK, FlyingItemEntityRenderer::new);
    }
    
    
    private static <T extends Entity> EntityType<T> register(String id, EntityType<T> entity) {
        return Registry.register(Registry.ENTITY_TYPE, Main.makeId(id), entity);
    }
}
