package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.BlockPres;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModPlantBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 14, 14);
    
    protected VoxelShape shape = SHAPE;

    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = BlockPres.DIRT;

    public ModPlantBlock() {
        this(Settings.copy(Blocks.POPPY));
    }
    
    public ModPlantBlock(Settings settings) {
        super(settings);
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock shape(VoxelShape shape) {
        this.shape = shape;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
