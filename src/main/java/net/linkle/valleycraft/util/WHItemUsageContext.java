package net.linkle.valleycraft.util;

import net.linkle.valleycraft.mixin.ItemUsageContextAccessor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;

public class WHItemUsageContext extends ItemUsageContext {
    public WHItemUsageContext(ItemUsageContext context, ItemStack stack) {
        super(context.getWorld(), context.getPlayer(), context.getHand(), stack, ((ItemUsageContextAccessor)context).getHit());
    }
}
