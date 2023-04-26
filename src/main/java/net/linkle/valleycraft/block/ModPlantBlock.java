package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.PlantGroundPredicates;
import net.linkle.valleycraft.util.PlantVoxelShapes;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * Extension of the vanilla PlantBlock class with a few QOL utilities:
 * <p>It uses the vanilla poppy's block settings by default, saving us from extra effort and clutter in NaturalBlocks.</p>
 * <p>It can use different VoxelShapes (hitbox shapes) depending on what we give it for each block.</p>
 */
public class ModPlantBlock extends PlantBlock {

    protected VoxelShape shape;

    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = PlantGroundPredicates.DIRT;
    
    public ModPlantBlock(Settings settings) {
        this(PlantVoxelShapes.DEFAULT_PLANT_SHAPE, settings);
    }
    
    public ModPlantBlock(VoxelShape shape, Settings settings) {
        super(settings);
        this.shape = shape;
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        var vec = state.getModelOffset(world, pos);
        return shape.offset(vec.x, vec.y, vec.z);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
