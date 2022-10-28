package net.linkle.valleycraft.block;

import java.util.function.Predicate;

import net.linkle.valleycraft.util.PlantGroundPredicates;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModTallPlantBlock extends TallPlantBlock {
    
    /** The ground whitelist for placing plant. */
    protected Predicate<BlockState> groundList = PlantGroundPredicates.DIRT;

    public ModTallPlantBlock() {
        this(Settings.copy(Blocks.TALL_GRASS));
    }
    
    public ModTallPlantBlock(Settings settings) {
        super(settings);
    }
    
    /** Set ground whitelist for placing plant. */
    public ModTallPlantBlock ground(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
