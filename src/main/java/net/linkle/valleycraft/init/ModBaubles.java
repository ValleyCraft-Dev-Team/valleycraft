package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.item.*;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.*;

public enum ModBaubles implements ItemEnum {
    //Use Bauble item if it has no functionality set,
    //otherwise create an item class that extends BaubleItem
    //and use that for the individual bauble.

    TOTEM_OF_VISITORS(new BaubleItem(itemSettings().rarity(EPIC))),
    TOTEM_OF_FRIENDSHIP(new BaubleItem(itemSettings().rarity(RARE))),
    POLISHED_GEAR(new BaubleItem(itemSettings().rarity(RARE))),
    SHARD_OF_THE_FIRST_GOLEM(new BaubleItem(itemSettings().rarity(EPIC))),
    STRANGE_DOLL(new BaubleItem(itemSettings().rarity(EPIC))),
    PIGLIN_CHILDS_TOY(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    LUCKY_FISHING_HOOK(new BaubleItem(itemSettings().rarity(RARE))),
    MONSTER_TOOTH(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    LOVE_POTION(new BaubleItem(itemSettings().rarity(RARE)));

    public static void initialize() {
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().maxCount(1).group(BOOKS);
    }

    public final Item item;
    public final Identifier id;

    ModBaubles(Item item) {
        this.item = Registry.register(Registry.ITEM, id = Main.makeId(name().toLowerCase()), item);
    }

    @Override
    public Item asItem() {
        return item;
    }
}
