package net.linkle.valleycraft.item;

import net.linkle.valleycraft.util.FoodStatusEffect;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class Tier3Bowl extends FoodItem {
    
    public Tier3Bowl(Settings settings, int hunger, float satMod, StatusEffect effect) {
        super(settings, hunger, satMod, new FoodStatusEffect(new StatusEffectInstance(effect, 120 * 20)));
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        super.finishUsing(stack, world, user);
        if (user instanceof ServerPlayerEntity player) {
            Criteria.CONSUME_ITEM.trigger(player, stack);
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }
        if (stack.isEmpty()) {
            return new ItemStack(Items.BOWL);
        }
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            var bowl = new ItemStack(Items.BOWL);
            if (!player.getInventory().insertStack(bowl)) {
                player.dropItem(bowl, false);
            }
        }
        return stack;
    }
}
