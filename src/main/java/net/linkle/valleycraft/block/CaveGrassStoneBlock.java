package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CaveGrassStoneBlock extends SpreadableStoneBlock implements Fertilizable {

    public CaveGrassStoneBlock(Block base, BlockSoundGroup sounds) {
        super(base, sounds);
    }

    @Override
    public boolean isFertilizable(BlockView var1, BlockPos var2, BlockState var3, boolean var4) {
        return false;
    }

    @Override
    public boolean canGrow(World var1, Random var2, BlockPos var3, BlockState var4) {
        return false;
    }

    @Override
    public void grow(ServerWorld var1, Random var2, BlockPos var3, BlockState var4) {
        
    }
}
