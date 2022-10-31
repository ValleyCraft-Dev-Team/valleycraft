package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class IcicleGrowingBlock extends IceBlock {
    public IcicleGrowingBlock(Settings settings) {
        super(settings);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextInt(48) == 0) {
            BlockPos blockPos = pos.down();
            if (world.isAir(blockPos)) {
                world.setBlockState(blockPos, ModNaturalBlocks.ICICLE.getState());
            }
            return;
        }
    }
}
