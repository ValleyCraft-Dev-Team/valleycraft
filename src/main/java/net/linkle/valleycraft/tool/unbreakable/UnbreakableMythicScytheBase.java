package net.linkle.valleycraft.tool.unbreakable;

import java.util.List;

import net.linkle.valleycraft.api.EnchantmentHandler;
import net.linkle.valleycraft.interfaces.PreventDestroy;
import net.linkle.valleycraft.tool.WeaponItem;
import net.linkle.valleycraft.util.WHItemUsageContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.item.Items.BONE_MEAL;

public class UnbreakableMythicScytheBase
        extends WeaponItem
        implements EnchantmentHandler, PreventDestroy {

    public UnbreakableMythicScytheBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return PreventDestroy.isUsable(miner.getMainHandStack());
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        var result = BONE_MEAL.useOnBlock(new WHItemUsageContext(context, new ItemStack(this)));
        if (result.isAccepted()) {
            context.getStack().damage(1, context.getPlayer(), entity -> entity.sendToolBreakStatus(context.getHand()));
        }
        return result;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.permanently_repairable.tooltip").formatted(Formatting.GRAY));
        tooltip.add( Text.translatable("item.valley.unique.tooltip").formatted(Formatting.GOLD));
        tooltip.add( Text.translatable("item.valley.mythic.tooltip").formatted(Formatting.RED));
    }

    @Override
    public List<EnchantmentTarget> getEnchantmentTypes() {
        return List.of(EnchantmentTarget.WEAPON);
    }
    
    public boolean isExplicitlyValid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.SWEEPING);
    }
    
    public boolean isInvalid(Enchantment enchantment) {
        return enchantment.equals(Enchantments.IMPALING);
    }
}