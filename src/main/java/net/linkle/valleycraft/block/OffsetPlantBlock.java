package net.linkle.valleycraft.block;

import net.minecraft.util.shape.VoxelShape;

/**
 * ModPlantBlock with random horizontal offsets to match the behavior of vanilla
 * grass, flowers, etc.
 */
public class OffsetPlantBlock extends ModPlantBlock {
    
    {
        offset(OffsetType.XZ);
    }
    
    public OffsetPlantBlock(VoxelShape shape) {
        super(shape);
    }
    
    public OffsetPlantBlock(Settings settings) {
        super(settings);
    }
}
