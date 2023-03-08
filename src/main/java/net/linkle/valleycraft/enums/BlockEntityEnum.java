package net.linkle.valleycraft.enums;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

/** For Enum classes that contains BlockEntityType. This interface adds common methods. */
public interface BlockEntityEnum extends IdProvider {
    
    <T extends BlockEntity> BlockEntityType<T> type();
    
    @Environment(EnvType.CLIENT)
    static <T extends BlockEntity> void registerRenderer(BlockEntityEnum entity, BlockEntityRendererFactory<T> factory) {
        BlockEntityRendererFactories.register(entity.type(), factory);
    }
}
