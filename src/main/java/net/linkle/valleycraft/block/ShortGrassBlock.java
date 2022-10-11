package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/** ModPlantBlock but with two changes:
 * Random horizontal offsets for each block, to match the behavior of vanilla grass, and a shorter hitbox (VoxelShape). */

public class ShortGrassBlock extends ModPlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 7, 14);

    protected VoxelShape shape = SHAPE;

    @Override
    public ModPlantBlock shape(VoxelShape shape) {
        this.shape = shape;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    /** This is what makes a block have random offsets.~
     * Referenced from FlowerBlock and FernBlock (the class for vanilla grass and fern blocks).
     * FernBlock also has a vertical offset that can randomly move it down, but I figured it's unnecessary for short grass, given that it's so short already.*/
    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}
