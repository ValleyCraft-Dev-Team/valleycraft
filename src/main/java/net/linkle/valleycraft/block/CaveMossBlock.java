package net.linkle.valleycraft.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlowLichenBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;

public class CaveMossBlock extends GlowLichenBlock {

    public CaveMossBlock() {
        super(Settings.of(Material.PLANT, MapColor.DARK_GREEN).noCollision().strength(0.2f).sounds(BlockSoundGroup.MOSS_CARPET));
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return !context.getStack().isOf(this.asItem()) || super.canReplace(state, context);
    }
}
