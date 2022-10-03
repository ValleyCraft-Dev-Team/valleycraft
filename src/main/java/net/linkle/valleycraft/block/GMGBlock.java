package net.linkle.valleycraft.block;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

public class GMGBlock extends HorizontalWithWaterBlock {

    public GMGBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        // for versions 1.18.2 and before
        tooltip.add( new TranslatableText("item.valley.broken.tooltip"));

        // for versions since 1.19
        //tooltip.add(Text.translatable("item.valley.broken.tooltip"));
    }
}
