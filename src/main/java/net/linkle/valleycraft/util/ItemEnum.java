package net.linkle.valleycraft.util;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

/** For Enum classes that contains items. This interface adds common methods. */
public interface ItemEnum extends ItemConvertible, IdProvider {
    /** Get item default stack. */
    default ItemStack getStack() {
        return asItem().getDefaultStack();
    }
}
