package net.linkle.floracore.init;

import net.linkle.floracore.util.Reg;
import net.minecraft.item.Item;

public class ModItems {

    public static final Item ITEM = new Item(itemSettings());
    
    public static void initialize() {
        Reg.register("item", ITEM);
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings();
    }
}
