package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.BlockPres;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * Extension of the vanilla PlantBlock class with a few QOL utilities:
 * - It uses the vanilla poppy's block settings by default, saving us from extra effort and clutter in NaturalBlocks.
 * - It can use different VoxelShapes (hitbox shapes) depending on what we give it for each block.
 */

public class ModPlantBlock extends PlantBlock {

    protected VoxelShape shape;

    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = BlockPres.DIRT;

    public ModPlantBlock(VoxelShape shape) {
        this(Settings.copy(Blocks.POPPY).offsetType(OffsetType.NONE));
        this.shape = shape;
    }
    
    public ModPlantBlock(Settings settings) {
        super(settings);
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
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
