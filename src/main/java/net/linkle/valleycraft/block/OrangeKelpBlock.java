package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpBlock;

public class OrangeKelpBlock extends KelpBlock {

    public OrangeKelpBlock() {
        super(Settings.copy(Blocks.KELP));
    }

    @Override
    protected Block getPlant() {
        return ModNaturalBlocks.ORANGE_KELP_PLANT.block;
    }

}