package net.linkle.valleycraft.item;

import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class WaterCupItem extends FoodItem {

    private boolean isMilk;

    public WaterCupItem(Settings settings, int hunger, float satMod) {
        super(settings, hunger, satMod);
    }

    public WaterCupItem(Settings settings, int hunger, float satMod, FoodStatusEffect effects) {
        super(settings, hunger, satMod, effects);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity player) {
            Criteria.CONSUME_ITEM.trigger(player, stack);
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (!world.isClient && isMilk) {
            user.clearStatusEffects();
        }
        if (stack.isEmpty()) {
            return new ItemStack(ModItems.WOODEN_CUP);
        }
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            var bowl = new ItemStack(ModItems.WOODEN_CUP);
            if (!player.getInventory().insertStack(bowl)) {
                player.dropItem(bowl, false);
            }
        }
        return stack;
    }
    
    /** Make this item clear effects when consumed like bucket of milk. */
    public WaterCupItem setMilk() {
        isMilk = true;
        return this;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 13;
    }
    
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
