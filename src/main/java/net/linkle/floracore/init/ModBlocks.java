package net.linkle.floracore.init;

import net.linkle.floracore.util.Reg;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

public class ModBlocks {
    
    public static final Block BLOCK = new Block(Block.Settings.copy(Blocks.STONE));
    
    public static void initialize() {
        Reg.registerWithItem("block", BLOCK, itemSettings());
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings();
    }
}
