package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroups {
    private static final Item TIERED_DISHES_ICON = Reg.register("tiered_dishes_icon", new Item(itemSettings()));
    private static final Item INGREDIENTS_ICON = Reg.register("ingredients_icon", new Item(itemSettings()));
    private static final Item REGULAR_DISHES_ICON = Reg.register("regular_dishes_icon", new Item(itemSettings()));
    private static final Item ITEMS_ICON = Reg.register("items_icon", new Item(itemSettings()));
    private static final Item BOOKS_ICON = Reg.register("books_icon", new Item(itemSettings()));
    private static final Item TOOLS_ICON = Reg.register("tools_icon", new Item(itemSettings()));

    public static final ItemGroup FLORA_GROUP = create("flora", ModBlocks.LAVENDER);

    public static final ItemGroup INGREDIENTS = create("ingredients", INGREDIENTS_ICON);
    public static final ItemGroup REGULAR_DISHES = create("regular_dishes", REGULAR_DISHES_ICON);
    public static final ItemGroup TIERED_DISHES = create("dishes", TIERED_DISHES_ICON);

    public static final ItemGroup ITEMS = create("items", ITEMS_ICON);
    public static final ItemGroup VC_TOOLS = create("tools", TOOLS_ICON);
    public static final ItemGroup BOOKS = create("books", BOOKS_ICON);

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
