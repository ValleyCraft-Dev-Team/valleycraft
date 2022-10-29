package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.item.BaubleItem;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.BOOKS;
import static net.minecraft.util.Rarity.EPIC;

public enum ModBookItems implements ItemEnum {
    BOOK_RUNECALLING(new Item(itemSettings().group(BOOKS).maxCount(1))),
    RUNEKEEPERS_TOME(new BaubleItem(itemSettings().group(BOOKS).rarity(EPIC).maxCount(1)));

    public static void initialize() {
        
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().group(ModGroups.BOOKS).maxCount(1);
    }
    
    
    // ### The Enum Class Itself ###
    
    public final Item item;
    public final Identifier id;
    
    /** @param //register the item */
    ModBookItems(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
}
