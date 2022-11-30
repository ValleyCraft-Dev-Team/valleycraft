package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.baubles.*;
import net.linkle.valleycraft.block.TranslationCanvasBlock;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import net.minecraft.item.Item;

import static net.linkle.valleycraft.init.ModGroups.*;
import static net.minecraft.util.Rarity.*;

public enum ModBaubles implements ItemEnum {
    //Use Bauble item if it has no functionality set,
    //otherwise create an item class that extends BaubleItem
    //and use that for the individual bauble.

    //baubles
    PIGLIN_CHILDS_TOY(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    MONSTER_TOOTH(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    POLISHED_GLOWSTONE_CHUNK(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    ANCIENT_DUNGEON_KEY(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    STRANGE_RUNE(new UniqueBaubleItem(itemSettings().rarity(UNCOMMON))),
    DIVINE_ACORN(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    GHAST_TEARS(new UniqueBaubleItem(itemSettings().rarity(RARE))),

    LUCKY_FISHING_HOOK(new UniqueBaubleItem(itemSettings().rarity(RARE))),
    RAVAGER_GOLEM_TUSK(new BaubleItem(itemSettings().rarity(RARE))),
    GREEN_SCALE(new BaubleItem(itemSettings().rarity(RARE))),
    RED_SCALE(new BaubleItem(itemSettings().rarity(RARE))),
    BLUE_SCALE(new BaubleItem(itemSettings().rarity(RARE))),
    BLACK_SCALE(new BaubleItem(itemSettings().rarity(EPIC))),
    TOTEM_OF_VISITORS_BRACELET(new BaubleItem(itemSettings().rarity(RARE))),
    TOTEM_OF_UNDYING_BRACELET(new BaubleItem(itemSettings().rarity(RARE))),
    TOTEM_OF_FRIENDSHIP_BRACELET(new BaubleItem(itemSettings().rarity(EPIC))),
    WARDEN_ANTLER(new BaubleItem(itemSettings().rarity(EPIC))),
    STRANGE_DOLL(new UniqueBaubleItem(itemSettings().rarity(EPIC))),

    //necklaces
    //prismarine/iron base
    IRON_NECKLACE(new TalismanItem(itemSettings().group(CLOTHING).maxCount(1))),
    AMBER_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    AMETHYST_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    DIAMOND_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    EMERALD_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    ENDER_PEARL_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    NETHER_QUARTZ_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    PRISMARINE_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),

    //leather base
    LEATHER_NECKLACE(new TalismanItem(itemSettings().group(CLOTHING).maxCount(1))),
    ECHO_SHARD_TALISMAN(new TalismanItem(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    FISHING_HOOK_TALISMAN(new TalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    GUARDIAN_SPIKE_NECKLACE(new TalismanItem(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    SCUTE_NECKLACE(new TalismanItem(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    SEAOLOGER_RUNE_NECKLACE(new TalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),

    //boss
    ELDER_GUARDIAN_SPIKE_NECKLACE(new TalismanItem(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    ENDER_DRAGON_TALISMAN(new TalismanItem(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    BRIMSTONE_NECKLACE(new UniqueTalismanItem(itemSettings().rarity(EPIC).group(BOOKS).maxCount(1))),

    //unique
    PIGLIN_NECKLACE(new UniqueTalismanItem(itemSettings().rarity(UNCOMMON).group(BOOKS).maxCount(1))),
    STRAY_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(UNCOMMON).group(BOOKS).maxCount(1))),
    ARROWHEAD_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    MOBLIN_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1)));

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
    
    @Override
    public Identifier getId() {
        return id;
    }
}
