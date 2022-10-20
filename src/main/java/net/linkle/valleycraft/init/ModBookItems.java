package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum ModBookItems implements ItemEnum {
    RUNE_ETCHING_BLADE(new Item(itemSettings().rarity(Rarity.UNCOMMON))),
    BOOK_RUNECALLING(new Item(itemSettings()));

    public static void initialize() {
        
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ModGroups.BOOKS).maxCount(1);
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    /** @param register the item */
    ModBookItems(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
}
