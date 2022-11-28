package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.baubles.BaubleItem;
import net.linkle.valleycraft.baubles.LovePotionBauble;
import net.linkle.valleycraft.baubles.TalismanItem;
import net.linkle.valleycraft.baubles.UniqueTalismanItem;
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
    TOTEM_OF_UNDYING_BRACELET(new BaubleItem(itemSettings().rarity(RARE))),
    TOTEM_OF_VISITORS_BRACELET(new BaubleItem(itemSettings().rarity(RARE))),
    TOTEM_OF_FRIENDSHIP_BRACELET(new BaubleItem(itemSettings().rarity(EPIC))),
    //POLISHED_GEAR(new BaubleItem(itemSettings().rarity(RARE))),
    //SHARD_OF_THE_FIRST_GOLEM(new BaubleItem(itemSettings().rarity(EPIC))),
    STRANGE_DOLL(new BaubleItem(itemSettings().rarity(EPIC))),
    PIGLIN_CHILDS_TOY(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    LUCKY_FISHING_HOOK(new BaubleItem(itemSettings().rarity(RARE))),
    MONSTER_TOOTH(new BaubleItem(itemSettings().rarity(UNCOMMON))),
    //LOVE_POTION(new LovePotionBauble(itemSettings().rarity(RARE))),
    RAVAGER_GOLEM_TUSK(new BaubleItem(itemSettings().rarity(RARE))),
    WARDEN_ANTLER(new BaubleItem(itemSettings().rarity(EPIC))),

    //necklaces
    EMERALD_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    AMETHYST_TALISMAN(new TalismanItem(itemSettings().rarity(UNCOMMON).group(CLOTHING).maxCount(1))),
    ECHO_SHARD_TALISMAN(new TalismanItem(itemSettings().rarity(RARE).group(CLOTHING).maxCount(1))),
    ENDER_DRAGON_TALISMAN(new TalismanItem(itemSettings().rarity(EPIC).group(CLOTHING).maxCount(1))),
    MOBLIN_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    FISHING_HOOK_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(RARE).group(BOOKS).maxCount(1))),
    STRAY_TALISMAN(new UniqueTalismanItem(itemSettings().rarity(UNCOMMON).group(BOOKS).maxCount(1)));

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
