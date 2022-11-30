package net.linkle.valleycraft.item;

import net.linkle.valleycraft.init.ModItems;
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

public class SeedBagItem extends Item {
    public SeedBagItem(Settings settings) {
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
                inventory.insertStack(new ItemStack(Items.WHEAT_SEEDS, 1));
            }

            inventory.insertStack(new ItemStack(Items.WHEAT_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(Items.MELON_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(Items.BEETROOT_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(Items.PUMPKIN_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(ModItems.GHOST_PUMPKIN_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(ModItems.CAVE_ROOT_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(ModItems.PUFF_BALL_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(ModItems.FIRE_PEPPER_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
            inventory.insertStack(new ItemStack(ModItems.ONION_SEEDS, MathHelper.nextInt(world.random, 0, 1)));
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