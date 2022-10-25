package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ModMushroomBlock extends ModPlantBlock {
    public ModMushroomBlock() {
        this(Settings.copy(Blocks.POPPY));
    }

    public ModMushroomBlock(Settings settings) {
        super(settings);
    }
    
    public ModMushroomBlock large() {
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
        return this;
    }
}
