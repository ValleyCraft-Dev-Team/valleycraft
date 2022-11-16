package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableCandelabraBlock extends CandelabraBlock implements Oxidizable {
    
    private final OxidationLevel level;

    public OxidizableCandelabraBlock(OxidationLevel level, boolean small) {
        super(small);
        this.level = level;
    }
    
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        tickDegradation(state, world, pos, random);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }
    
    @Override
    public OxidationLevel getDegradationLevel() {
        return level;
    }
}