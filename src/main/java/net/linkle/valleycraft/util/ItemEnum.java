package net.linkle.valleycraft.util;

import java.util.function.Supplier;

import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

/** For Enum classes that contains items. This interface adds common methods. */
public interface ItemEnum extends ItemConvertible {
    /** Get item supplier. */
    default Supplier<Item> getItemSupplier() {
        return () -> asItem();
    }
    /** Get item default stack supplier. */
    default Supplier<ItemStack> getStackSupplier() {
        return () -> getStack();
    }
    /** Get item default stack. */
    default ItemStack getStack() {
        return asItem().getDefaultStack();
    }
}
