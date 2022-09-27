package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;

public class ModBookItems {
    public static final Item RUNE_ENGRAVING_TOOL = new Item(itemSettings().rarity(Rarity.UNCOMMON).maxCount(1));
    public static final Item RUNE_BOOK = new Item(itemSettings());

    public static void initialize() {
        Reg.register("book_runecalling", RUNE_BOOK);
        Reg.register("rune_etching_blade", RUNE_ENGRAVING_TOOL);

    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(BOOKS).maxCount(1);
    }
}
