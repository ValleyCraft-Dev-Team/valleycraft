package net.linkle.valleycraft.item;

import net.linkle.valleycraft.init.ItemsModded;
import net.linkle.valleycraft.init.Tools;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class StringSpoolItem extends Item {
    public StringSpoolItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            if (player instanceof ServerPlayerEntity serverPlayer)
                Criteria.CONSUME_ITEM.trigger(serverPlayer, stack);
            player.incrementStat(Stats.USED.getOrCreateStat(this));

            stack.decrement(1);
            var inventory = player.getInventory();

            if (stack.isEmpty()) {
                inventory.insertStack(new ItemStack(ItemsModded.PLANT_FIBER_STRING, 4));
                return new ItemStack(Items.STICK, 1);
            }

            inventory.insertStack(new ItemStack(ItemsModded.PLANT_FIBER_STRING, MathHelper.nextInt(world.random, 4, 8)));
            inventory.insertStack(new ItemStack(Items.STICK, 1));
            return stack;
        }

        return stack;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}