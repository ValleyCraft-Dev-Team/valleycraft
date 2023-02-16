package net.linkle.valleycraft.block;

import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;

public class GlowingPotBlock extends FlowerPotBlock {

    public GlowingPotBlock(BlockConvertible content) {
        super(content.asBlock(), Settings.copy(Blocks.POTTED_POPPY).luminance(s -> 14));
    }

}
