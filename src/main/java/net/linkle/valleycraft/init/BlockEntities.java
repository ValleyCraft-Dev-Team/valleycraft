package net.linkle.valleycraft.init;

import java.util.stream.Stream;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.block.entity.*;
import net.linkle.valleycraft.enums.BlockEntityEnum;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum BlockEntities implements BlockEntityEnum {

    CRATE(CrateBlockEntity::new, BlocksModded.CRATE),
    DEEPSLATE_CHEST(DeepslateChestBlockEntity::new, BlocksModded.DEEPSLATE_CHEST),
    COFFIN(CoffinBlockEntity::new, BlocksModded.COFFIN),

    COUNTER(CounterBlockEntity::new, BlocksModded.COUNTER),
    CABINET(CabinetBlockEntity::new, BlocksModded.CABINET),
    STOVE(StoveBlockEntity::new, BlocksModded.BRICK_STOVE),
    MEMORYBOX(MemoryBoxEntity::new, BlocksModded.MEMORY_BOX);

    public static void initialize() {
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        
    }
    
    private final BlockEntityType<?> type;
    
    public final Identifier id;
    
    private <T extends BlockEntity> BlockEntities(Factory<T> factory, BlockConvertible... blocks) {
        this(factory, Stream.of(blocks).map(BlockConvertible::asBlock).toArray(Block[]::new));
    }
    
    private <T extends BlockEntity> BlockEntities(Factory<T> factory, Block... blocks) {
        var entity = FabricBlockEntityTypeBuilder.create(factory, blocks).build();
        type = Registry.register(Registry.BLOCK_ENTITY_TYPE, id = Main.makeId(name().toLowerCase()), entity);
    }

    @Override
    public Identifier getId() {
        return id;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public <T extends BlockEntity> BlockEntityType<T> type() {
        return (BlockEntityType<T>) type;
    }
}
