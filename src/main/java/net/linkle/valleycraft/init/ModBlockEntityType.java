package net.linkle.valleycraft.init;

import java.util.stream.Stream;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.entity.*;
import net.linkle.valleycraft.client.block.entity.WispLanternRenderer;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static BlockEntityType<WispLanternBlockEntity> WISP_LANTERN;
    public static BlockEntityType<AllayLanternBlockEntity> ALLAY_LANTERN;
    public static BlockEntityType<CrateBlockEntity> CRATE;
    public static BlockEntityType<StoveBlockEntity> STOVE;
    public static BlockEntityType<WaypointBlockEntity> WAYPOINT_ENTITY;

    public static void initialize() {
        WISP_LANTERN = create("wisp_lantern", WispLanternBlockEntity::new, ModBlocks.VEX_LANTERN);
        ALLAY_LANTERN = create("allay_lantern", AllayLanternBlockEntity::new, ModBlocks.ALLAY_LANTERN);
        CRATE = create("crate", CrateBlockEntity::new, ModBlocks.CRATE);
        STOVE = create("stove", StoveBlockEntity::new, ModBlocks.STOVE);
        WAYPOINT_ENTITY = create("waypoint", WaypointBlockEntity::new, ModBlocks.WAYPOINT);
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        BlockEntityRendererRegistry.register(WISP_LANTERN, WispLanternRenderer::new);
    }
    
    /** Create block entity */
    private static <T extends BlockEntity> BlockEntityType<T> create(String id, Factory<T> factory, BlockConvertible... blocks) {
        return create(id, factory, Stream.of(blocks).map(BlockConvertible::asBlock).toArray(Block[]::new));
    }
    
    /** Create block entity */
    private static <T extends BlockEntity> BlockEntityType<T> create(String id, Factory<T> factory, Block... blocks) {
        var entity = FabricBlockEntityTypeBuilder.create(factory, blocks).build();
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, Main.makeId(id), entity);
    }
}
