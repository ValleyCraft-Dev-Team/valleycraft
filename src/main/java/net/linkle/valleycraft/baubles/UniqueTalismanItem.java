package net.linkle.valleycraft.baubles;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class UniqueTalismanItem extends Item {
    public UniqueTalismanItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.necklace.tooltip").formatted(Formatting.GRAY));
        tooltip.add( Text.translatable("item.valley.unique.tooltip").formatted(Formatting.GOLD));
    }
}
