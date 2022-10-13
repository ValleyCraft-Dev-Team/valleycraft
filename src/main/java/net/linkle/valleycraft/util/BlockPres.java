package net.linkle.valleycraft.util;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

/** Block Predicates */
public enum BlockPres implements Predicate<BlockState> {
    DIRT(floor -> floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND)),
    SAND(floor -> floor.isIn(BlockTags.SAND)),
    TERRACOTTA(floor -> floor.isIn(BlockTags.TERRACOTTA)),
    STONE(floor -> floor.isIn(BlockTags.BASE_STONE_OVERWORLD));

    private final Predicate<BlockState> predicate;
    
    BlockPres(Predicate<BlockState> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(BlockState state) {
        return predicate.test(state);
    }
}
