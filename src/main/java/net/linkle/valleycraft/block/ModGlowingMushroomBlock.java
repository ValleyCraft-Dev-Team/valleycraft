package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModGlowingMushroomBlock extends ModMushroomBlock {

    public ModGlowingMushroomBlock() {
        this(Settings.copy(Blocks.POPPY).luminance(s -> 7).ticksRandomly());
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
    }

    public ModGlowingMushroomBlock(Settings settings) {
        super(settings);
    }
    
    public ModGlowingMushroomBlock large() {
        shape = Block.createCuboidShape(3, 0, 3, 13, 14, 13);
        return this;
    }
}
