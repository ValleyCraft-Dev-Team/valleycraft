package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;

public class VineBodyBlock extends AbstractPlantBlock {
    public static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    
    private AbstractPlantStemBlock stem;
    
    public VineBodyBlock() {
        this(Settings.of(Material.PLANT).noCollision().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES));
    }

    public VineBodyBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false);
    }
    
    public void setStem(BlockConvertible stem) {
        this.stem = (AbstractPlantStemBlock)stem.asBlock();
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return stem;
    }
}
