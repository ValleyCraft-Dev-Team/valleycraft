package net.linkle.valleycraft.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/** An abstract throwable Item class. */
public abstract class ThrowableItem extends ModItem {

    public ThrowableItem(Settings settings) {
        super(settings);
    }
    
    /** create a thrown entity. */
    protected abstract ThrownItemEntity newThrownEntity(World world, PlayerEntity user);
    
    /** An optional item cooldown. Override it with a tick amount. */
    protected int getCooldownTick() {
        return 0;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        var stack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));

        int tick = getCooldownTick();
        if (tick > 0) {
            user.getItemCooldownManager().set(this, tick);
        }
        
        if (!world.isClient) {
            var entity = newThrownEntity(world, user);
            entity.setItem(stack);
            entity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            world.spawnEntity(entity);
        }
        
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }
        
        return TypedActionResult.success(stack, world.isClient());
    }
}
