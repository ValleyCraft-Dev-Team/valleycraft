package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class StalwartBlock extends ModPlantBlock {
    public StalwartBlock() {
        this(Settings.copy(Blocks.RED_MUSHROOM));
    }

    public StalwartBlock(Settings settings) {
        super(settings);
    }
    
    public StalwartBlock large() {
        shape = Block.createCuboidShape(4, 0, 4, 12, 9, 12);
        return this;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("block.valleycraft.dishes.tooltip").formatted(Formatting.GRAY) );
        tooltip.add( Text.translatable("block.valleycraft.dishes.tooltip_3").formatted(Formatting.GRAY) );
    }
}
