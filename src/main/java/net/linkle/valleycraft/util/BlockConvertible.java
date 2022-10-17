package net.linkle.valleycraft.util;

import net.minecraft.block.Block;

/**
 * Represents an object that has an block form.
 */
public interface BlockConvertible {
    /**
     * Gets this object in its item form.
     */
    public Block asBlock();
}
