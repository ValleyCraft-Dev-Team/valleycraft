package net.linkle.valleycraft.util;

import net.minecraft.block.BlockState;

/** For Enum classes that contains blocks This interface adds common methods. */
public interface BlockEnum extends BlockConvertible, IdProvider {
    /** Get block default state. */
    default BlockState getState() {
        return asBlock().getDefaultState();
    }
}
