package net.linkle.valleycraft.init;

import java.util.stream.Stream;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.entity.*;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static BlockEntityType<CrateBlockEntity> CRATE;
    public static BlockEntityType<DeepslateChestBlockEntity> DEEPSLATE_CHEST;
    public static BlockEntityType<CoffinBlockEntity> COFFIN;

    public static BlockEntityType<CounterBlockEntity> COUNTER;
    public static BlockEntityType<CabinetBlockEntity> CABINET;
    public static BlockEntityType<StoveBlockEntity> STOVE;

    public static void initialize() {
        CRATE = create("crate", CrateBlockEntity::new, BlocksModded.CRATE);
        DEEPSLATE_CHEST = create("deepslate_chest", DeepslateChestBlockEntity::new, BlocksModded.DEEPSLATE_CHEST);
        COFFIN = create("coffin", CoffinBlockEntity::new, BlocksModded.COFFIN);
        COUNTER = create("counter", CounterBlockEntity::new, BlocksModded.COUNTER);
        CABINET = create("cabinet", CabinetBlockEntity::new, BlocksModded.CABINET);
        STOVE = create("stove", StoveBlockEntity::new, BlocksModded.BRICK_STOVE);
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
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
