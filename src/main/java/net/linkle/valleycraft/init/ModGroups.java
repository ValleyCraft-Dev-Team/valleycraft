package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups {
    public static final Item TIERED_DISHES_ICON = Reg.register("tiered_dishes_icon", new Item(itemSettings()));
    public static final Item INGREDIENTS_ICON = Reg.register("ingredients_icon", new Item(itemSettings()));
    public static final Item REGULAR_DISHES_ICON = Reg.register("regular_dishes_icon", new Item(itemSettings()));
    public static final Item ITEMS_ICON = Reg.register("items_icon", new Item(itemSettings()));
    public static final Item BOOKS_ICON = Reg.register("books_icon", new Item(itemSettings()));
    public static final Item TOOLS_ICON = Reg.register("tools_icon", new Item(itemSettings()));

    public static final ItemGroup FLORA_GROUP = create("flora", ModBlocks.LAVENDER);

    public static final ItemGroup INGREDIENTS = create("ingredients", ModGroups.INGREDIENTS_ICON);
    public static final ItemGroup REGULAR_DISHES = create("regular_dishes", ModGroups.REGULAR_DISHES_ICON);
    public static final ItemGroup TIERED_DISHES = create("dishes", ModGroups.TIERED_DISHES_ICON);

    public static final ItemGroup ITEMS = create("items", ModGroups.ITEMS_ICON);
    public static final ItemGroup BOOKS = create("books", ModGroups.BOOKS_ICON);
    public static final ItemGroup TOOLS = create("tools", ModGroups.TOOLS_ICON);

    public static final ItemGroup NON_NATURAL_BLOCKS = create("blocks", ModBlocks.APPLE_DOOR);

    public static void initialize() {
    }
    
    private static ItemGroup create(String id, ItemConvertible item) {
        var builder = FabricItemGroupBuilder.create(Main.makeId(id));
        return builder.icon(() -> new ItemStack(item)).build();
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings();
    }
}
