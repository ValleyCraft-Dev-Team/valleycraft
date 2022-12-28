package net.linkle.valleycraft.item;

import net.linkle.valleycraft.baubles.AbstractTotemBase;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
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
            if (!world.isClient) {
                ExperienceOrbEntity.spawn((ServerWorld) world, user.getPos(), exp);
            }
        }

        showFloatingItem(world, user);

        return stack.isEmpty() ? new ItemStack(this) : stack;
    }
}
