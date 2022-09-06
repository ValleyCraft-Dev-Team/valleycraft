package net.linkle.floracore.init;

import net.linkle.floracore.util.Reg;
import net.minecraft.item.Item;

public class ModItems {

    //public static final Item MINERS_LETTUCE = new Item(itemSettings());
    
    public static void initialize() {
        //Reg.register("miners_lettuce", MINERS_LETTUCE);
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ModGroups.FLORA_GROUP);
    }
}
