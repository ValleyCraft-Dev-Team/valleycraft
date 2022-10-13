package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.BlockPres;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModPlantBlock extends PlantBlock {

    protected VoxelShape shape;
    protected OffsetType offset = OffsetType.NONE;

    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = BlockPres.DIRT;

    public ModPlantBlock(VoxelShape shape) {
        this(Settings.copy(Blocks.POPPY));
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
    
    /** Set shape size for this plant block. */
    public ModPlantBlock shape(VoxelShape shape) {
        this.shape = shape;
        return this;
    }
    
    /** Set random offset for this plant block. */
    public ModPlantBlock offset(OffsetType offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
    
    @Override
    public OffsetType getOffsetType() {
        return offset;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
