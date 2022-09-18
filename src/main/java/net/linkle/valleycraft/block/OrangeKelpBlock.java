package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpBlock;

public class OrangeKelpBlock extends KelpBlock {

    public OrangeKelpBlock() {
        super(Settings.copy(Blocks.KELP));
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.ORANGE_KELP_PLANT;
    }

}