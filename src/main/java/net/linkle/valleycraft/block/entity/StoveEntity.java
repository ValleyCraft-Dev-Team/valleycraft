package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SmokerBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class StoveEntity extends SmokerBlockEntity {
    public StoveEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("container.valleycraft.stove");
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.STOVE;
    }
}
