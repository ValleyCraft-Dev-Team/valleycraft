package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class IcicleGrowingBlock extends Block {
    
    public IcicleGrowingBlock() {
        super(Settings.copy(Blocks.PACKED_ICE).ticksRandomly());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.random.nextInt(40) == 0) {
            BlockPos blockPos = pos.down();
            if (world.isAir(blockPos)) {
                world.setBlockState(blockPos, ModNaturalBlocks.ICICLE.getState());
            }
            return;
        }
    }
}
