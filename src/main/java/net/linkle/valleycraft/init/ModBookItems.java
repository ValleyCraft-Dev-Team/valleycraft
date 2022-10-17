package net.linkle.valleycraft.init;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;

public enum ModBookItems implements ItemConvertible {
    RUNE_ETCHING_BLADE(new Item(itemSettings().rarity(Rarity.UNCOMMON).maxCount(1))),
    BOOK_RUNECALLING(new Item(itemSettings()));

    public static void initialize() {
        
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(BOOKS).maxCount(1);
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    
    ModBookItems(Item item) {
        this.item = Reg.register(name().toLowerCase(), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
}
