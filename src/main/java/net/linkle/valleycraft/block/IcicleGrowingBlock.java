package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.NaturalBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import static net.minecraft.block.Blocks.MOSS_CARPET;
import static net.minecraft.block.Blocks.SPORE_BLOSSOM;

public class IcicleGrowingBlock extends IceBlock {
    public IcicleGrowingBlock(Settings settings) {
        super(settings);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextInt(48) == 0) {
            BlockPos blockPos = pos.down();
            if (world.isAir(blockPos)) {
                world.setBlockState(blockPos, NaturalBlocks.ICICLE.getState());
            }
            return;
        }
    }
}
