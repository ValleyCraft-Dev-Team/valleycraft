package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.SnailEntityModel;
import net.linkle.valleycraft.client.entity.model.ZodEntityModel;
import net.linkle.valleycraft.client.entity.renderer.SnailEntityRenderer;
import net.linkle.valleycraft.client.entity.renderer.ZodEntityRenderer;
import net.linkle.valleycraft.entity.SnailEntity;
import net.linkle.valleycraft.entity.ThrownBoneDartEntity;
import net.linkle.valleycraft.entity.ZodEntity;
import net.minecraft.client.render.entity.CodEntityRenderer;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntities {

    public static final EntityType<SnailEntity> SNAIL = register("snail", 
            FabricEntityTypeBuilder.createMob().entityFactory(SnailEntity::new).spawnGroup(SpawnGroup.CREATURE)
            .dimensions(new EntityDimensions(0.5F, 0.4F, true)).trackRangeChunks(8).build());

    public static final EntityType<ZodEntity> ZOD = Registry.register(Registry.ENTITY_TYPE,
            new Identifier(Main.ID, "zod"),
            FabricEntityTypeBuilder.createMob().spawnGroup(SpawnGroup.WATER_AMBIENT).entityFactory(ZodEntity::new)
                    .trackRangeBlocks(4).dimensions(EntityDimensions.fixed(0.5f, 0.3f))
                    .spawnRestriction(SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ZodEntity::canSpawn).build()
    );

    public static final EntityType<ThrownBoneDartEntity> ThrownBoneDartEntityType = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(Main.ID, "bone_dart"),
            FabricEntityTypeBuilder.<ThrownBoneDartEntity>create(SpawnGroup.MISC, ThrownBoneDartEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
                    .build() // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
    );

    public static void initialize() {
        FabricDefaultAttributeRegistry.register(SNAIL, SnailEntity.createSnailAttributes());
        FabricDefaultAttributeRegistry.register(ZOD, FishEntity.createFishAttributes());
    }

    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        EntityModelLayerRegistry.registerModelLayer(SnailEntityModel.LAYER, ()->SnailEntityModel.getTexturedModelData());
        EntityModelLayerRegistry.registerModelLayer(ZodEntityModel.LAYER, ()->ZodEntityModel.getTexturedModelData());
        EntityRendererRegistry.register(SNAIL, SnailEntityRenderer.create("snail"));
        EntityRendererRegistry.register(ZOD, ZodEntityRenderer.create("zod"));

    }
    
    private static <T extends Entity> EntityType<T> register(String id, EntityType<T> entity) {
        return Registry.register(Registry.ENTITY_TYPE, Main.makeId(id), entity);
    }
}
