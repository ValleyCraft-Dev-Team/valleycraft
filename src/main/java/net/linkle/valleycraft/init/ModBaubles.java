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

    //baubles
    //PIGLIN_CHILDS_TOY(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    //MONSTER_TOOTH(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    //POLISHED_GLOWSTONE_CHUNK(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    //ANCIENT_DUNGEON_KEY(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    //STRANGE_RUNE(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    //DIVINE_ACORN(new BaubleAliasedBlockItem(ModNaturalBlocks.DIVINE_ACORN.block, itemSettings().rarity(UNCOMMON))),

    //STUCK_SLIME(new UniqueBaubleItem(itemSettings().rarity(RARE))),
    //RING(new BaubleItem(itemSettings().rarity(RARE))),
    //HEART_MEDALLION(new UniqueBaubleItem(itemSettings().rarity(RARE))),
    //TOTUM_LUNA_MEDALLION(new UniqueBaubleItem(itemSettings().rarity(RARE))),

    //LUCKY_FISHING_HOOK(new BaubleItem(itemSettings().rarity(RARE))),
    //RAVAGER_GOLEM_TUSK(new BaubleItem(itemSettings().rarity(RARE))),
    //GREEN_SCALE(new BaubleItem(itemSettings().rarity(RARE))),
    //RED_SCALE(new BaubleItem(itemSettings().rarity(RARE))),
    //BLUE_SCALE(new UniqueMythicBaubleItem(itemSettings().rarity(RARE))),
    //BLACK_SCALE(new BaubleItem(itemSettings().rarity(EPIC))),
    //TOTEM_OF_VISITORS_BRACELET(new BaubleItem(itemSettings().rarity(RARE))),
    LEATHER_BRACELET(new Item(itemSettings().group(CLOTHING))),
    TOTEM_OF_UNDYING_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(RARE))),
    TOTEM_OF_FRIENDSHIP_BRACELET(new Item(itemSettings().group(CLOTHING).rarity(EPIC))),
    //WARDEN_ANTLER(new BaubleItem(itemSettings().rarity(EPIC))),
    //ILLAGER_TRINKET(new UniqueBaubleItem(itemSettings().rarity(EPIC))),
    //STRANGE_DOLL(new UniqueMythicBaubleItem(itemSettings().rarity(EPIC))),

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
    //FISHING_HOOK_TALISMAN(new Item(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    GUARDIAN_SPIKE_TALISMAN(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    SCUTE_NECKLACE(new Item(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    //SEAOLOGER_RUNE_NECKLACE(new TalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),

    //boss
    ELDER_GUARDIAN_SPIKE_KEEPSAKE(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    ENDER_DRAGON_TALISMAN(new Item(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1)));

    //unique
    //PIGLIN_NECKLACE(new UniqueTalismanItem(itemSettings().rarity(UNCOMMON).group(BOOKS).maxCount(1))),
    //STRAY_TALISMAN(new Item(itemSettings().rarity(UNCOMMON).group(BOOKS).maxCount(1)));
    //ARROWHEAD_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    //MOBLIN_TALISMAN(new UniqueMythicTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    //EVIL_CRYSTAL_KEEPSAKE(new UniqueTalismanItem(itemSettings().rarity(EPIC).group(BOOKS).maxCount(1)));

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
