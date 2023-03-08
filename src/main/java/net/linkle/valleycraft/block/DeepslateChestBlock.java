package net.linkle.valleycraft.block;

import net.linkle.valleycraft.init.BlockEntities;
import net.minecraft.block.ChestBlock;

public class DeepslateChestBlock extends ChestBlock {
    public DeepslateChestBlock(Settings settings) {
        super(settings, () -> BlockEntities.DEEPSLATE_CHEST.type());
    }
}
