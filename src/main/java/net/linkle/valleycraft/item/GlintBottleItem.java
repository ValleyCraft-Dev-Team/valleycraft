package net.linkle.valleycraft.item;

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

public class GlintBottleItem extends FoodItem {

    private boolean isMilk;

    public GlintBottleItem(Settings settings, int hunger, float satMod) {
        super(settings, hunger, satMod);
    }

    public GlintBottleItem(Settings settings, int hunger, float satMod, FoodStatusEffect effects) {
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
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            var bowl = new ItemStack(Items.GLASS_BOTTLE);
            if (!player.getInventory().insertStack(bowl)) {
                player.dropItem(bowl, false);
            }
        }
        return stack;
    }
    
    /** Make this item clear effects when consumed like bucket of milk. */
    public GlintBottleItem setMilk() {
        isMilk = true;
        return this;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 16;
    }
    
    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
