package net.linkle.valleycraft.tool.unbreakable;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.interfaces.PreventDestroy;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnbreakableMythicSwordBase
        extends SwordItem
        implements EnchantmentHandler, PreventDestroy {

    public UnbreakableMythicSwordBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return super.canMine(state, world, pos, miner) && PreventDestroy.isUsable(miner.getMainHandStack());
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.permanently_repairable.tooltip").formatted(Formatting.GRAY));
        tooltip.add( Text.translatable("item.valley.unique.tooltip").formatted(Formatting.GOLD));
        tooltip.add( Text.translatable("item.valley.mythic.tooltip").formatted(Formatting.RED));
    }
}