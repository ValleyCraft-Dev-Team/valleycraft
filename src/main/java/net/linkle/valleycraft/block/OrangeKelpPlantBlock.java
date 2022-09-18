package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpPlantBlock;

public class OrangeKelpPlantBlock extends KelpPlantBlock {

    public OrangeKelpPlantBlock() {
        super(Settings.copy(Blocks.KELP_PLANT));
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock)ModBlocks.ORANGE_KELP;
    }

}