package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.INGREDIENTS;
import static net.linkle.valleycraft.init.ModGroups.ITEMS;

public class ModItems {

    //ingredients
    public static final Item SALT = new Item(itemSettings());
    public static final Item FLOUR = new Item(itemSettings());

    //misc
    public static final Item FIBER = new Item(itemSettings().group(ITEMS));
    public static final Item COVER = new Item(itemSettings().group(ITEMS));
    public static final Item MULCH = new Item(itemSettings().group(ITEMS));
    public static final Item CROWS_FEATHER = new Item(itemSettings().group(ITEMS));
    public static final Item SEAGULLS_FEATHER = new Item(itemSettings().group(ITEMS));
    public static final Item DUCKS_FEATHER = new Item(itemSettings().group(ITEMS));

    public static void initialize() {
        Reg.register("flour", FLOUR);
        Reg.register("salt", SALT);

        Reg.register("mulch", MULCH);
        Reg.register("fiber", FIBER);
        Reg.register("book_cover", COVER);
        Reg.register("seagulls_feather", SEAGULLS_FEATHER);
        Reg.register("ducks_feather", DUCKS_FEATHER);
        Reg.register("crows_feather", CROWS_FEATHER);

        TieredFoodItems.initialize();
        IngredientFoodItems.initialize();
        RegularFoodItems.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
