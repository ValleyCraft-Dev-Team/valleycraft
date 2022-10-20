package net.linkle.valleycraft.block;

import net.minecraft.block.GourdBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class GhostPumpkinStemBlock extends StemBlock {
    public GhostPumpkinStemBlock(GourdBlock gourdBlock, Supplier<Item> pickBlockItem, Settings settings) {
        super(gourdBlock, pickBlockItem, settings);
    }
}
