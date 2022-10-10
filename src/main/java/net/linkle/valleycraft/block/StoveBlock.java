package net.linkle.valleycraft.block;

import net.linkle.valleycraft.block.entity.CrateBlockEntity;
import net.linkle.valleycraft.block.entity.StoveEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SmokerBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class StoveBlock extends SmokerBlock {
    public StoveBlock(Settings settings) {
        super(settings);
    }
    @Override @Nullable
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StoveEntity(pos, state);
    }
}