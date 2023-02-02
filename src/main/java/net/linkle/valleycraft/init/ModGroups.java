package net.linkle.valleycraft.init;

import java.util.function.Supplier;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.*;

public class ModGroups {
    private static final Item TIERED_DISHES_ICON = Reg.register("tiered_dishes_icon", new Item(itemSettings()));
    private static final Item INGREDIENTS_ICON = Reg.register("ingredients_icon", new Item(itemSettings()));
    private static final Item REGULAR_DISHES_ICON = Reg.register("regular_dishes_icon", new Item(itemSettings()));
    private static final Item ITEMS_ICON = Reg.register("items_icon", new Item(itemSettings()));
    private static final Item GUIDEBOOK_ICON = Reg.register("guidebook_icon", new Item(itemSettings()));

    public static final ItemGroup FLORA_GROUP = create("flora", () -> ModNaturalBlocks.WILD_FIRE_PEPPER);

    public static final ItemGroup INGREDIENTS = create("ingredients", () -> INGREDIENTS_ICON);
    public static final ItemGroup REGULAR_DISHES = create("regular_dishes", () -> REGULAR_DISHES_ICON);
    public static final ItemGroup TIERED_DISHES = create("dishes", () -> TIERED_DISHES_ICON);

    public static final ItemGroup VC_ITEMS = create("items", () -> ITEMS_ICON);
    public static final ItemGroup VC_TOOLS = create("tools", () -> ModBlocks.CRAFTING_MAT);
    public static final ItemGroup CLOTHING = create("clothing", () -> ModArmors.STRAW_HAT);

    public static final ItemGroup NON_NATURAL_BLOCKS = create("blocks", () -> Items.BIRCH_DOOR);


    public static void initialize() {
    }
    
    private static ItemGroup create(String id, Supplier<ItemConvertible> item) {
        var builder = FabricItemGroupBuilder.create(Main.makeId(id));
        return builder.icon(() -> new ItemStack(item.get().asItem())).build();
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings();
    }
}
