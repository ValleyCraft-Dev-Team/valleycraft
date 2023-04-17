package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.enums.ItemEnum;
import net.linkle.valleycraft.interfaces.TrinketEffectItem;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.Groups.CLOTHING;
import static net.minecraft.util.Rarity.*;

public enum Clothing implements ItemEnum {

    LABCOAT(new Item(itemSettings().group(CLOTHING).maxCount(1)));

    public static void initialize() {
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().maxCount(1).group(CLOTHING);
    }

    public final Item item;
    public final Identifier id;

    Clothing(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
    
    @Override
    public Identifier getId() {
        return id;
    }
}
