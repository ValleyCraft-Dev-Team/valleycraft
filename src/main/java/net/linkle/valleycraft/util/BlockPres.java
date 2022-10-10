package net.linkle.valleycraft.util;

import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

/** Block Predicates */
public class BlockPres {
    public static final Predicate<BlockState> DIRT = floor -> floor.isIn(BlockTags.DIRT) || floor.isOf(Blocks.FARMLAND);
    public static final Predicate<BlockState> SAND = floor -> floor.isIn(BlockTags.SAND) || floor.isOf(Blocks.TERRACOTTA) || floor.isOf(Blocks.GRAVEL);
    public static final Predicate<BlockState> STONE = floor -> floor.isIn(BlockTags.BASE_STONE_OVERWORLD);
}
