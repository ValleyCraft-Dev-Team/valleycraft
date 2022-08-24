package net.linkle.floracore.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.linkle.floracore.Main;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class ModGroups {
    public static final ItemGroup FLORA_GROUP = create("flora", Items.LILAC);

    public static void initialize() {
    }
    
    private static ItemGroup create(String id, ItemConvertible item) {
        var builder = FabricItemGroupBuilder.create(Main.makeId(id));
        return builder.icon(() -> new ItemStack(item)).build();
    }
}
