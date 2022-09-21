package net.linkle.valleycraft.init;

import net.linkle.valleycraft.item.FoodItem;
import net.linkle.valleycraft.item.SalveItem;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.*;

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
    public static final Item BEAST_BONE = new Item(itemSettings().group(ITEMS));
    public static final Item STRING = new Item(itemSettings().group(ITEMS));
    public static final Item SALVE = new SalveItem(itemSettings().group(TOOLS).maxCount(16), 0, 0.0f, StatusEffects.REGENERATION);
    public static final Item DOG_BISCUIT = new FoodItem(itemSettings().group(TOOLS), 2, 0.4f, true);

    //disabled unless needed in future
    //public static final Item EVIL_CRYSTAL = new Item(itemSettings().group(ITEMS));
    //public static final Item GRATITUDE_CRYSTAL = new Item(itemSettings().group(ITEMS));
    //public static final Item MONSTER_CLAW = new Item(itemSettings().group(ITEMS));
    //public static final Item MONSTER_TOOTH = new Item(itemSettings().group(ITEMS));
    //public static final Item JELLY_BLOB = new Item(itemSettings().group(ITEMS));

    public static void initialize() {
        Reg.register("salve", SALVE);
        Reg.register("dog_biscuit", DOG_BISCUIT);

        Reg.register("flour", FLOUR);
        Reg.register("salt", SALT);

        Reg.register("fiber", FIBER);

        Reg.register("beast_bone", BEAST_BONE);

        Reg.register("seagulls_feather", SEAGULLS_FEATHER);
        Reg.register("ducks_feather", DUCKS_FEATHER);
        Reg.register("crows_feather", CROWS_FEATHER);

        //Reg.register("jelly_blob", JELLY_BLOB);
        //Reg.register("monster_claw", MONSTER_CLAW);
        //Reg.register("monster_tooth", MONSTER_TOOTH);
        //Reg.register("evil_crystal", EVIL_CRYSTAL);
        //Reg.register("gratitude_crystal", GRATITUDE_CRYSTAL);

        Reg.register("book_cover", COVER);
        Reg.register("plant_fiber_string", STRING);

        Reg.register("mulch", MULCH);

        TieredFoodItems.initialize();
        IngredientFoodItems.initialize();
        RegularFoodItems.initialize();
    }
    
    private static Item.Settings itemSettings() {
        return new Item.Settings().group(INGREDIENTS);
    }
}
