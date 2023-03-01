package net.linkle.valleycraft.enums;

import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;

/** For Enum classes that contains BlockEntityType. This interface adds common methods. */
public interface BlockEntityEnum extends IdProvider {
    
    <T extends BlockEntity> BlockEntityType<T> type();
}
