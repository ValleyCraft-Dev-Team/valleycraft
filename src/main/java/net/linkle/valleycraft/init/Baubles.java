package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.armors.ArmorMats;
import net.linkle.valleycraft.enums.ItemEnum;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.Groups.*;
import static net.minecraft.util.Rarity.*;

public enum Baubles implements ItemEnum {
    //Use Bauble item if it has no functionality set,
    //otherwise create an item class that extends BaubleItem
    //and use that for the individual bauble.

    //talismans are necklaces made with special items
    //amulets are necklaces made with minerals
    //keepsakes are boss specific items
    //base material necklaces are just called necklaces
    //ignore some of the coded names are wrong, theyre fixed in the lang file

    //LEATHER_BRACELET(new Item(itemSettings().group(CLOTHING))),
    //TOTEM_OF_UNDYING_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(RARE))),
    //TOTEM_OF_FRIENDSHIP_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(EPIC))),

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
    CRYSTALLIZED_HONEY_NECKLACE(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    SCUTE_NECKLACE(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    UNDYING_NECKLACE(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    GUARDIAN_SPIKE_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    DRAGON_TOOTH_KEEPSAKE(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),

    //miniboss keepsakes
    ELDER_GUARDIAN_SPIKE_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    WARDEN_HEART_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    LICHES_LUCKY_BONE_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),

    //boss keepsakes
    NETHER_STAR_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    ENDER_DRAGON_TALISMAN(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1)));


    public static void initialize() {
    }

    private static Item.Settings itemSettings() {
        return new Item.Settings().maxCount(1).group(CLOTHING);
    }

    public final Item item;
    public final Identifier id;

    Baubles(Item item) {
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
