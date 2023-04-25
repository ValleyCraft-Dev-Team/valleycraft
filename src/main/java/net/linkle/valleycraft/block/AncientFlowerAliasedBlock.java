package net.linkle.valleycraft.block;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class AncientFlowerAliasedBlock extends AliasedBlockItem {
    public AncientFlowerAliasedBlock(Block block, Settings settings) {
        super(block, settings);
    }

    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valleycraft.dishes.tooltip"));
        tooltip.add( Text.translatable("item.valleycraft.dishes.tooltip_7"));
    }
}
