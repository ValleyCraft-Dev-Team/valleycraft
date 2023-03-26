package net.linkle.valleycraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LifeGemItem extends Item {
    public LifeGemItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
        	user.addExperience(21);
        	world.playSound((ServerPlayerEntity)null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.NEUTRAL, 0.3F, (world.getRandom().nextFloat() * 0.3F + 0.8F));
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
