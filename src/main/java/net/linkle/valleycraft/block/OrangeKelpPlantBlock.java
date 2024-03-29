package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.BlocksNatural;
import net.minecraft.block.AbstractPlantStemBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.KelpPlantBlock;

public class OrangeKelpPlantBlock extends KelpPlantBlock {

    public OrangeKelpPlantBlock() {
        super(Settings.copy(Blocks.KELP_PLANT));
    }

    @Override
    protected AbstractPlantStemBlock getStem() {
        return (AbstractPlantStemBlock) BlocksNatural.ORANGE_KELP.block;
    }

}