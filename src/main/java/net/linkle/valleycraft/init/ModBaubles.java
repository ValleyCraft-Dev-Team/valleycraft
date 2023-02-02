package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.baubles.*;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.*;

public enum ModBaubles implements ItemEnum {
    //Use Bauble item if it has no functionality set,
    //otherwise create an item class that extends BaubleItem
    //and use that for the individual bauble.

    LEATHER_BRACELET(new Item(itemSettings().group(CLOTHING))),
    TOTEM_OF_UNDYING_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(RARE))),
    TOTEM_OF_FRIENDSHIP_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(EPIC))),

    //necklaces
    //prismarine/iron base
    IRON_NECKLACE(new Item(itemSettings().group(CLOTHING).maxCount(1))),
    AMETHYST_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    BRIMSTONE_NECKLACE(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    DIAMOND_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    ECHO_SHARD_TALISMAN(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    EMERALD_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    ENDER_PEARL_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    NETHER_QUARTZ_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    PRISMARINE_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),

    //leather base
    LEATHER_NECKLACE(new Item(itemSettings().group(CLOTHING).maxCount(1))),
    GUARDIAN_SPIKE_TALISMAN(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    SCUTE_NECKLACE(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),

    //boss
    ELDER_GUARDIAN_SPIKE_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    ENDER_DRAGON_TALISMAN(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1)));

    public static void initialize() {
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().maxCount(1).group(CLOTHING);
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
    
    @Override
    public Identifier getId() {
        return id;
    }
}
