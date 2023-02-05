package net.linkle.valleycraft.block.entity;

import net.linkle.valleycraft.init.ModBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BarrelBlockEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class CrateBlockEntity extends BarrelBlockEntity {
    public CrateBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.valleycraft.crate");
    }
    
    @Override
    public net.minecraft.block.entity.BlockEntityType getType() {
        return ModBlockEntityType.CRATE;
    }
}
