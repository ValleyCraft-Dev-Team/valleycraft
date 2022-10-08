package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.BlockPres;
import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.function.Predicate;

public class ModLargerMushroomBlock extends PlantBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(4, 0, 4, 12, 9, 12);

    /** The ground whitelist for placing plant. */
    private Predicate<BlockState> groundList = BlockPres.DIRT;

    public ModLargerMushroomBlock() {
        this(Settings.copy(Blocks.POPPY));
    }

    public ModLargerMushroomBlock(Settings settings) {
        super(settings);
    }

    /** Set ground whitelist for placing plant. */
    public ModLargerMushroomBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
