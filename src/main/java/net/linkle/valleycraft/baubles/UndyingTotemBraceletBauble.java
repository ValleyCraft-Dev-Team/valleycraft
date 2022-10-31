package net.linkle.valleycraft.baubles;

import net.linkle.valleycraft.init.ModBaubles;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class UndyingTotemBraceletBauble extends AbstractTotemBase {
    public UndyingTotemBraceletBauble(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
        Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }

        if (playerEntity != null) {
        playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!playerEntity.getAbilities().creativeMode) {
        stack.decrement(1);
        }
        }

        showFloatingItem(world, user);
        return stack.isEmpty() ? new ItemStack(ModBaubles.TOTEM_OF_UNDYING_BRACELET) : stack;
    }

    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( Text.translatable("item.valley.bauble.tooltip").formatted(Formatting.GRAY));
    }
}