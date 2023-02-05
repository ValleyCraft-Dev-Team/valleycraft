package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.SmokerBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class StoveBlockEntity extends SmokerBlockEntity {
    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.valleycraft.stove");
    }

    @Override
    public net.minecraft.block.entity.BlockEntityType getType() {
        return ModBlockEntityType.STOVE;
    }
}
