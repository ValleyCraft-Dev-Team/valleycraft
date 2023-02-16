package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.Particles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class ModGlowingAncientFlowerBlock extends ModPlantBlock {

    public ModGlowingAncientFlowerBlock() {
        this(Settings.copy(Blocks.POPPY).luminance(s -> 14));
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
    }

    public ModGlowingAncientFlowerBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }
}
