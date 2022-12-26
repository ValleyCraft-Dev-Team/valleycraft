package net.linkle.valleycraft.item;

import net.linkle.valleycraft.baubles.AbstractTotemBase;
import net.linkle.valleycraft.init.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class SoulItem extends AbstractTotemBase {
    private final int exp;

    public SoulItem(Settings settings, int exp) {
        super(settings);
        this.exp = exp;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 4;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user, int exp) {
        PlayerEntity playerEntity = user instanceof PlayerEntity ? (PlayerEntity)user : null;
        if (playerEntity instanceof ServerPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity)playerEntity, stack);
        }

        if (playerEntity != null) {
            playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
            if (!playerEntity.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            if (!world.isClient) {
                ExperienceOrbEntity.spawn((ServerWorld) world, user.getPos(), exp);
            }
        }

        showFloatingItem(world, user);

        return stack.isEmpty() ? new ItemStack(this) : stack;
    }
}
