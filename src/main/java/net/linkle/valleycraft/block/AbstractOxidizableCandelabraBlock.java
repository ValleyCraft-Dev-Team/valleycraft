package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public abstract class AbstractOxidizableCandelabraBlock extends AbstractCandelabraBlock implements Oxidizable {

    protected final OxidationLevel level;
    
    public AbstractOxidizableCandelabraBlock(OxidationLevel level) {
        this.level = level;
    }
    
    public AbstractOxidizableCandelabraBlock(OxidationLevel level, int luminance) {
        super(luminance);
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