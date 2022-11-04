package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModMushroomBlock extends ModPlantBlock {
    
    public ModMushroomBlock() {
        this(Settings.copy(Blocks.POPPY));
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
    }

    public ModMushroomBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }
    
    public ModMushroomBlock large() {
        shape = Block.createCuboidShape(3, 0, 3, 13, 14, 13);
        return this;
    }
}
