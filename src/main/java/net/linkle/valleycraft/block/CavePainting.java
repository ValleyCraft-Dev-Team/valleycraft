package net.linkle.valleycraft.block;

import java.util.List;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

public class CavePainting extends HorizontalBlock {
    
    private final String transKey;
    
    /** transKey translation keys to type: family, home, portrait, zombie. **/
    public CavePainting(Settings settings, String transKey) {
        super(settings);
        this.transKey = "item.valley.cave_painting.tooltip.".concat(transKey);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable(transKey).formatted(Formatting.GRAY));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return super.getPlacementState(ctx).with(FACING, getFacing(ctx).getOpposite());
    }
}
