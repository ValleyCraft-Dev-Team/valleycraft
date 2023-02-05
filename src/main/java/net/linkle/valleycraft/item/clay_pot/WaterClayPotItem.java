package net.linkle.valleycraft.item.clay_pot;

import net.linkle.valleycraft.init.ItemsModded;
import net.linkle.valleycraft.item.FoodItem;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class WaterClayPotItem extends FoodItem {

    private boolean isMilk;

    public WaterClayPotItem(Settings settings, int hunger, float satMod) {
        super(settings, hunger, satMod);
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
            return new ItemStack(ItemsModded.CLAY_POT);
        }
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            var bowl = new ItemStack(ItemsModded.CLAY_POT);
            if (!player.getInventory().insertStack(bowl)) {
                player.dropItem(bowl, false);
            }
        }
        return stack;
    }

    //@Override
    //public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
    //    ItemStack itemStack = user.getStackInHand(hand);
    //    if (itemStack.isOf(Items.BUCKET) && !this.isBaby()) {
    //        user.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
    //        ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, user, ModItems.MILK_FILLED_WOODEN_CUP.getStack());
    //        user.setStackInHand(hand, itemStack2);
    //        return ActionResult.success();
    //    } else {
    //        return super.useOnEntity(user, hand);
    //    }
    //}
    
    /** Make this item clear effects when consumed like bucket of milk. */
    public WaterClayPotItem setMilk() {
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
