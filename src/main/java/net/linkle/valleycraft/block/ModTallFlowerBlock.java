package net.linkle.valleycraft.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.TallFlowerBlock;

public class ModTallFlowerBlock extends TallFlowerBlock {

    public ModTallFlowerBlock() {
        this(Settings.copy(Blocks.ROSE_BUSH));
    }
    
    public ModTallFlowerBlock(Settings settings) {
        super(settings);
    }

}
