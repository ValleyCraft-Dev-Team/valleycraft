package net.linkle.valleycraft.interfaces;

import net.linkle.valleycraft.init.ModEvents;
import net.minecraft.item.ItemStack;

/**
 * Used for tool/weapon item to prevent from being destroyed by using or
 * attacking with it if the item's damage level is 1. See {@link ModEvents} for
 * code.
 */
public interface PreventDestroy {
    static boolean isUsable(ItemStack stack) {
        return stack.getDamage() < stack.getMaxDamage() - 1;
    }
}
