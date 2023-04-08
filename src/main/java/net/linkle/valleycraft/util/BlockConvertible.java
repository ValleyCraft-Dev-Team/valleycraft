package net.linkle.valleycraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

/** Represents an object that has a block form. */
public interface BlockConvertible {
    /** Gets this object in its block form. */
    Block asBlock();
    
    static BlockConvertible of(Block block) {
        return () -> block;
    }
}
