package net.linkle.valleycraft.util;

import java.util.function.Predicate;

import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

/** Block Predicates */
public enum PlantGroundPredicates implements Predicate<BlockState> {
    DIRT(state -> state.isIn(BlockTags.DIRT) || state.isOf(Blocks.FARMLAND)),
    SAND(state -> state.isIn(BlockTags.SAND)),
    TERRACOTTA(state -> state.isIn(BlockTags.TERRACOTTA)),
    STONE(state -> state.isIn(BlockTags.BASE_STONE_OVERWORLD)),
    ENDSTONE(state -> state.isOf(Blocks.END_STONE)),
    ARID_DESERT(state -> state.isIn(BlockTags.DEAD_BUSH_MAY_PLACE_ON)),
    END_PLANTS(state -> state.isOf(Blocks.END_STONE) || state.isOf(ModNaturalBlocks.END_GRASS_BLOCK.block));


    private final Predicate<BlockState> predicate;
    
    PlantGroundPredicates(Predicate<BlockState> predicate) {
        this.predicate = predicate;
    }

    @Override
    public boolean test(BlockState state) {
        return predicate.test(state);
    }
}
