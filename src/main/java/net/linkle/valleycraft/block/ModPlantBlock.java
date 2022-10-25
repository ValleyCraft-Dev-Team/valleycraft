package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.BlockPres;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModPlantBlock extends PlantBlock {

    protected VoxelShape shape;
    protected OffsetType offset = OffsetType.NONE;

    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = BlockPres.DIRT;

    public ModPlantBlock(VoxelShape shape) {
        this(Settings.copy(Blocks.POPPY).offsetType(OffsetType.NONE));
        shape(shape);
    }
    
    public ModPlantBlock(Settings settings) {
        super(settings);
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }
    
    /** Set the VoxelShape (hitbox shape shown when looking at the block) for this plant block. */
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
