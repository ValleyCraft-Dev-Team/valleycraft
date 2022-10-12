package net.linkle.valleycraft.block;

import net.minecraft.block.Block;

/**
 * ModPlantBlock but with two changes: Random horizontal offsets for each block,
 * to match the behavior of vanilla grass, and a shorter hitbox (VoxelShape).
 */
public class ShortGrassBlock extends ModPlantBlock {

    {
        shape(Block.createCuboidShape(2, 0, 2, 14, 7, 14));
    }

    /**
     * This is what makes a block have random offsets.~ Referenced from FlowerBlock
     * and FernBlock (the class for vanilla grass and fern blocks). FernBlock also
     * has a vertical offset that can randomly move it down, but I figured it's
     * unnecessary for short grass, given that it's so short already.
     */
    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
