package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class DeepslateChestBlockEntity extends ChestBlockEntity {
    public DeepslateChestBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.CRATE.type(), pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.valleycraft.deepslate_chest");
    }
}
