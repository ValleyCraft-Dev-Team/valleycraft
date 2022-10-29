package net.linkle.valleycraft.block;

import net.minecraft.block.LadderBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class TranslationCanvasBlock extends SpecialPaintingBlock {
    public TranslationCanvasBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.bauble.tooltip").formatted(Formatting.GRAY));
    }
}
