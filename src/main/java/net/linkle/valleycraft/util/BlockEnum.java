package net.linkle.valleycraft.util;

import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

/** For Enum classes that contains blocks This interface adds common methods. */
public interface BlockEnum extends BlockConvertible {
    /** Get block supplier. */
    default Supplier<Block> getBlockSupplier() {
        return () -> asBlock();
    }
    /** Get default block state supplier. */
    default Supplier<BlockState> getStateSupplier() {
        return () -> getState();
    }
    /** Get block default state. */
    default BlockState getState() {
        return asBlock().getDefaultState();
    }
}
