package net.linkle.valleycraft.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class CrateBlockEntity extends BarrelBlockEntity {
    public CrateBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    protected Text getContainerName() {
        return new TranslatableText("container.valleycraft.crate");
    }
}
