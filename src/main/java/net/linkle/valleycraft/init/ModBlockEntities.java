package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.entity.CrateBlockEntity;
import net.linkle.valleycraft.block.entity.StoveEntity;
import net.linkle.valleycraft.block.entity.WispLanternBlockEntity;
import net.linkle.valleycraft.client.block.entity.WispLanternRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {

    public static BlockEntityType<WispLanternBlockEntity> WISP_LANTERN;
    public static BlockEntityType<CrateBlockEntity> CRATE;
    public static BlockEntityType<StoveEntity> STOVE;

    public static void initialize() {
        WISP_LANTERN = create("wisp_lantern", WispLanternBlockEntity::new, ModBlocks.VEX_LANTERN);
        CRATE = create("crate", CrateBlockEntity::new, ModBlocks.CRATE);
        STOVE = create("stove", StoveEntity::new, ModBlocks.STOVE);
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        BlockEntityRendererRegistry.register(WISP_LANTERN, WispLanternRenderer::new);
    }
    
    /** Create block entity */
    private static <T extends BlockEntity> BlockEntityType<T> create(String id, Factory<T> factory, Block... block) {
        var entity = FabricBlockEntityTypeBuilder.create(factory, block).build();
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, Main.makeId(id), entity);
    }
}
