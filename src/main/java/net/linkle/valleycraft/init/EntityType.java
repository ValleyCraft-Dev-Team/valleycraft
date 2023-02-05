package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.util.EntityTypeEnum.*;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.pupkins.PupkinEntityModel;
import net.linkle.valleycraft.client.entity.model.snails.CaveSnailEntityModel;
import net.linkle.valleycraft.client.entity.model.snails.SculkSnailEntityModel;
import net.linkle.valleycraft.client.entity.model.snails.SnailEntityModel;
import net.linkle.valleycraft.client.entity.renderer.ChickenRenderer;
import net.linkle.valleycraft.client.entity.renderer.CowRenderer;
import net.linkle.valleycraft.client.entity.renderer.fish.CodEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.fish.SalmonEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.pupkins.PupkinEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.snails.SnailEntityRenderer;
import net.linkle.valleycraft.entity.ChickenVariant;
import net.linkle.valleycraft.entity.DairyCowEntity;
import net.linkle.valleycraft.entity.fish.*;
import net.linkle.valleycraft.entity.projectiles.thrown_items.GlowBallEntity;
import net.linkle.valleycraft.entity.projectiles.thrown_items.ThrownRockEntity;
import net.linkle.valleycraft.entity.pupkins.PupkinEntity;
import net.linkle.valleycraft.entity.snails.CaveSnailEntity;
import net.linkle.valleycraft.entity.snails.SculkSnailEntity;
import net.linkle.valleycraft.entity.snails.SnailEntity;
import net.linkle.valleycraft.util.EntityTypeEnum;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.SpawnRestriction.Location;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

/**
 * See {@link net.minecraft.entity.EntityType} for vanilla entities as a reference to determine the
 * entity builder for the modded one. Also see {@link SpawnRestriction} for
 * spawn restriction references.
 */
public enum EntityType implements EntityTypeEnum {
    
    // Others
    PUPKIN(createMob(SpawnGroup.CREATURE, PupkinEntity::new).dimensions(new EntityDimensions(0.6F, 0.8F, false)).trackRangeChunks(6)
            .spawnRestriction(Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn)),
    
    DAIRY_COW(createMob(SpawnGroup.CREATURE, DairyCowEntity::new).dimensions(new EntityDimensions(0.9f, 1.4f, false)).trackRangeChunks(10)
            .spawnRestriction(Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn)),
    
    CHICKEN(createMob(SpawnGroup.CREATURE, ChickenVariant::new).dimensions(new EntityDimensions(0.4f, 0.7f, false)).trackRangeChunks(10)
            .spawnRestriction(Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn)),

    // Snails
    SNAIL(createMob(SpawnGroup.AMBIENT, SnailEntity::new).dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(5)),
    CAVE_SNAIL(createMob(SpawnGroup.AMBIENT, CaveSnailEntity::new).dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(5)),
    SCULK_SNAIL(createMob(SpawnGroup.AMBIENT, SculkSnailEntity::new).dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(5)),
    
    // fishes
    ZOD(createMob(SpawnGroup.MONSTER, ZodEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, UndeadFishEntity::canSpawn)),
    
    BONEFIN(createMob(SpawnGroup.MONSTER, BonefinEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, BonefinEntity::canSpawn)),
    
    STONEROLLER_MINNOW(createMob(SpawnGroup.WATER_CREATURE, StonerollerMinnowEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, StonerollerMinnowEntity::canSpawn)),
    
    ABYSSWATCHER(createMob(SpawnGroup.WATER_CREATURE, AbysswatcherEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AbysswatcherEntity::canSpawn)),
    
    SARDINE(createMob(SpawnGroup.WATER_CREATURE, SardineEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SardineEntity::canSpawn)),
    
    RED_PORGY(createMob(SpawnGroup.WATER_CREATURE, RedPorgyEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RedPorgyEntity::canSpawn).trackRangeChunks(5)),
    
    PERCH(createMob(SpawnGroup.WATER_CREATURE, PerchEntity::new).trackRangeChunks(5).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
            .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, PerchEntity::canSpawn)),
    
    // Misc
    THROWN_ROCK(createEntity(SpawnGroup.MISC, ThrownRockEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10)),
    GLOW_BALL(createEntity(SpawnGroup.MISC, GlowBallEntity::new).dimensions(EntityDimensions.fixed(0.25F, 0.25F)).trackRangeBlocks(4).trackedUpdateRate(10));
    
    public static void initialize() {
        registerAttribute(SNAIL, SnailEntity.createSnailAttributes());
        registerAttribute(CAVE_SNAIL, CaveSnailEntity.createSnailAttributes());
        registerAttribute(SCULK_SNAIL, SculkSnailEntity.createSnailAttributes());
        
        registerAttribute(PUPKIN, PupkinEntity.createPupkinAttributes());
        registerAttribute(DAIRY_COW, DairyCowEntity.createCowAttributes());
        registerAttribute(CHICKEN, ChickenVariant.createChickenAttributes());
        
        registerAttribute(ZOD, UndeadFishEntity.createUndeadFishAttributes());
        registerAttribute(BONEFIN, UndeadFishEntity.createUndeadFishAttributes());
        
        registerAttribute(STONEROLLER_MINNOW, FishEntity.createFishAttributes());
        registerAttribute(ABYSSWATCHER, FishEntity.createFishAttributes());
        registerAttribute(SARDINE, FishEntity.createFishAttributes());
        registerAttribute(RED_PORGY, FishEntity.createFishAttributes());
        registerAttribute(PERCH, FishEntity.createFishAttributes());
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SnailEntityModel.LAYER, SnailEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(CaveSnailEntityModel.LAYER, CaveSnailEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(SculkSnailEntityModel.LAYER, SculkSnailEntityModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(PupkinEntityModel.LAYER, PupkinEntityModel::getTexturedModelData);
        
        registerRenderer(SNAIL, SnailEntityRenderer.create("snail"));
        registerRenderer(CAVE_SNAIL, SnailEntityRenderer.create("cave_snail"));
        registerRenderer(SCULK_SNAIL, SnailEntityRenderer.create("sculk_snail"));
        
        registerRenderer(PUPKIN, PupkinEntityRenderer::new);
        registerRenderer(DAIRY_COW, CowRenderer.create("dairy_cow"));
        registerRenderer(CHICKEN, ChickenRenderer::new);
        
        registerRenderer(ZOD, CodEntityRenderer.create("zod"));
        registerRenderer(ABYSSWATCHER, CodEntityRenderer.create("abysswatcher"));
        registerRenderer(BONEFIN, SalmonEntityRenderer.create("bonefin"));
        registerRenderer(STONEROLLER_MINNOW, CodEntityRenderer.create("minnow"));
        registerRenderer(PERCH, CodEntityRenderer.create("perch"));
        registerRenderer(RED_PORGY, CodEntityRenderer.create("red_porgy"));
        registerRenderer(SARDINE, CodEntityRenderer.create("sardine"));
        
        registerRenderer(THROWN_ROCK, FlyingItemEntityRenderer::new);
        registerRenderer(GLOW_BALL, FlyingItemEntityRenderer::new);
    }
    
    private final net.minecraft.entity.EntityType<?> type;
    
    public final Identifier id;
    
    private EntityType(FabricEntityTypeBuilder<?> builder) {
        this(builder.build());
    }
    
    private EntityType(net.minecraft.entity.EntityType<?> type) {
        this.type = Registry.register(Registry.ENTITY_TYPE, id = Main.makeId(name().toLowerCase()), type);
    }
    
    @Override
    public <T extends Entity> net.minecraft.entity.EntityType<T> type() {
        return (net.minecraft.entity.EntityType<T>) type;
    }
    
    @Override
    public Identifier getId() {
        return id;
    }
}
