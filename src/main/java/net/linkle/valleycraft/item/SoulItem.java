package net.linkle.valleycraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SoulItem extends Item {
    public SoulItem(Settings settings) {
        super(settings);
    }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

}
