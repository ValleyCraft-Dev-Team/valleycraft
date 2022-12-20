package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class SpreadableStoneBlock extends Block {
    
    /** base stone block */
    protected final Block base;
    
    public SpreadableStoneBlock(Block base, BlockSoundGroup sounds) {
        super(Settings.copy(base).ticksRandomly().sounds(sounds));
        this.base = base;
    }

    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        int level = ChunkLightProvider.getRealisticOpacity(world, state, pos, blockState, blockPos, Direction.UP, blockState.getOpacity(world, blockPos));
        return level < world.getMaxLightLevel();
    }

    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        return canSurvive(state, world, pos) && world.getFluidState(pos.up()).isEmpty();
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!canSurvive(state, world, pos)) {
            world.setBlockState(pos, base.getDefaultState());
            return;
        }
        int level = world.getLightLevel(pos.up());
        if (level == 0) {
            BlockState blockState = this.getDefaultState();
            for (int i = 0; i < 4; ++i) {
                BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (!world.getBlockState(blockPos).isOf(base) || !canSpread(blockState, world, blockPos)) continue;
                world.setBlockState(blockPos, blockState);
            }
        }
    }
}
