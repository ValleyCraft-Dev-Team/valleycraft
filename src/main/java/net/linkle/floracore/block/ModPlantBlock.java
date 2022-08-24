package net.linkle.floracore.block;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PlantBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModPlantBlock extends PlantBlock {
    
    public static final Predicate<BlockState> DIRT = floor -> floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND);
    public static final Predicate<BlockState> SAND = floor -> floor.isIn(BlockTags.SAND);
    
    /** The ground whitelist for placing plant. */
    private Predicate<BlockState> groundList = DIRT;

    public ModPlantBlock() {
        this(Settings.copy(Blocks.POPPY));
    }
    
    public ModPlantBlock(Settings settings) {
        super(settings);
    }
    
    /** Set ground whitelist for placing plant. */
    public ModPlantBlock setGround(Predicate<BlockState> predicate) {
        groundList = predicate;
        return this;
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return groundList.test(floor);
    }
}
