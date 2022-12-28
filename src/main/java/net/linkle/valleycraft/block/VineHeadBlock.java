package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.AbstractPlantBlock;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CaveVines;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;

public class VineHeadBlock extends AbstractPlantStemBlock implements Fertilizable, CaveVines {
    
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.0, 9.0, 3.0, 13.0, 16.0, 13.0);
    
    private AbstractPlantBlock plant;

    public VineHeadBlock() {
        this(Settings.of(Material.PLANT).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CAVE_VINES));
    }
    
    public VineHeadBlock(Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
    }
    
    public void setPlant(BlockConvertible plant) {
        this.plant = (AbstractPlantBlock)plant.asBlock();
    }

    @Override
    protected int getGrowthLength(Random random) {
        return 1;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    @Override
    protected Block getPlant() {
        return plant;
    }
}
