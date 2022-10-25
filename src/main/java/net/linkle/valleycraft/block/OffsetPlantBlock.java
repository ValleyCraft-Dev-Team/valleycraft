package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.shape.VoxelShape;

/**
 * ModPlantBlock with random horizontal offsets to match the behavior of vanilla
 * grass, flowers, etc.
 */
public class OffsetPlantBlock extends ModPlantBlock {
    
    public OffsetPlantBlock(VoxelShape shape) {
        this(Settings.copy(Blocks.POPPY));
        this.shape = shape;
    }
    
    public OffsetPlantBlock(Settings settings) {
        super(Block.createCuboidShape(4, 0, 4, 12, 9, 12));
    }
}
