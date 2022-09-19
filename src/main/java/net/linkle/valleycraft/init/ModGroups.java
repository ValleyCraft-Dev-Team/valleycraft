package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.linkle.valleycraft.Main;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups {
    public static final ItemGroup FLORA_GROUP = create("flora", ModBlocks.LAVENDER);
    public static final ItemGroup INGREDIENTS = create("ingredients", ModItems.SALT);
    public static final ItemGroup TIERED_DISHES = create("dishes", TieredFoodItems.COD_CHOWDER);

    public static void initialize() {
    }
    
    private static ItemGroup create(String id, ItemConvertible item) {
        var builder = FabricItemGroupBuilder.create(Main.makeId(id));
        return builder.icon(() -> new ItemStack(item)).build();
    }
}
