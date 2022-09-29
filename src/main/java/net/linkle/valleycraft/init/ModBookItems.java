package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;

public class ModBookItems {
    public static final Item RUNE_ENGRAVING_TOOL = new Item(itemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
    public static final Item BOOK_RUNE = new Item(itemSettings());
    public static final Item BOOK_GOLEMANCY = new Item(itemSettings());

    public static void initialize() {
        Reg.register("rune_etching_blade", RUNE_ENGRAVING_TOOL);
        Reg.register("book_runecalling", BOOK_RUNE);
        Reg.register("book_golemancy", BOOK_GOLEMANCY);

    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(BOOKS).maxCount(1);
    }
}
