package net.linkle.valleycraft.util;

import java.util.function.Predicate;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

/** Block Predicates */
public enum BlockPres implements Predicate<BlockState> {
    DIRT(state -> state.isIn(BlockTags.DIRT) || state.isOf(Blocks.FARMLAND)),
    SAND(state -> state.isIn(BlockTags.SAND)),
    TERRACOTTA(state -> state.isIn(BlockTags.TERRACOTTA)),
    STONE(state -> state.isIn(BlockTags.BASE_STONE_OVERWORLD)),
    ARID_DESERT_PLANTS(state -> state.isIn(BlockTags.SAND) || state.isIn(BlockTags.DIRT) || state.isIn(BlockTags.TERRACOTTA) || state.isIn(BlockTags.DEAD_BUSH_MAY_PLACE_ON)),
    SOUL_PLANTS(state -> state.isIn(BlockTags.BASE_STONE_OVERWORLD) || state.isIn(BlockTags.BASE_STONE_NETHER) || state.isIn(BlockTags.DEAD_BUSH_MAY_PLACE_ON) || state.isIn(BlockTags.TERRACOTTA) || state.isIn(BlockTags.DIRT) || state.isIn(BlockTags.SAND));
    private final Predicate<BlockState> predicate;
    
    BlockPres(Predicate<BlockState> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(BlockState state) {
        return predicate.test(state);
    }
}
