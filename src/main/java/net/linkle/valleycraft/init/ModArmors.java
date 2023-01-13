package net.linkle.valleycraft.init;

import net.linkle.valleycraft.armors.*;
import net.linkle.valleycraft.item.ClothingArmorItem;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.*;

import net.linkle.valleycraft.Main;

public enum ModArmors implements ItemEnum {
    STRAW_HAT(new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settingsNormal())),

    SEAGULL_FEATHER(new ArmorItem(ArmorMats.SEAGULL_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    DUCK_FEATHER(new ArmorItem(ArmorMats.DUCK_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    CROW_FEATHER(new ArmorItem(ArmorMats.CROW_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    FEATHER(new ArmorItem(ArmorMats.WHITE_FEATHER, EquipmentSlot.HEAD, settingsNormal())),

    DIERDRA_LAUREL(new ArmorItem(ArmorMats.DIERDRA_LAUREL, EquipmentSlot.HEAD, settingsNormal())),
    FLOWER_CROWN(new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settingsNormal())),
    DRIPLEAF_HAT(new ArmorItem(ArmorMats.DRIPLEAF, EquipmentSlot.HEAD, settingsNormal())),

    REINFORCED_LEATHER_HELMET(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_GOLDEN_HELMET(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_IRON_HELMET(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_ROSEGOLD_HELMET(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_DIAMOND_HELMET(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_NETHERITE_HELMET(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    LEATHER_BREASTPLATE(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.CHEST, settingsNormal())),
    GOLDEN_BREASTPLATE(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_BREASTPLATE(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    IRON_BREASTPLATE(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_BREASTPLATE(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    DIAMOND_BREASTPLATE(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.CHEST, settingsNormal())),
    NETHERITE_BREASTPLATE(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.CHEST, settingsNormal())),

    LEATHER_SANDALS(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.FEET, settingsNormal())),
    GOLDEN_SANDALS(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.FEET, settingsNormal())),
    PRIMSTEEL_SANDALS(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),
    IRON_SANDALS(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.FEET, settingsNormal())),
    ROSEGOLD_SANDALS(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),
    DIAMOND_SANDALS(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.FEET, settingsNormal())),
    NETHERITE_SANDALS(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.FEET, settingsNormal())),

    LEATHER_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_LEATHER, EquipmentSlot.LEGS, settingsNormal())),
    GOLDEN_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_GOLD, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    IRON_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_IRON, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    DIAMOND_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_DIAMOND, EquipmentSlot.LEGS, settingsNormal())),
    NETHERITE_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_NETHERITE, EquipmentSlot.LEGS, settingsNormal())),

    LEATHER_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.LEGS, settingsNormal())),
    GOLDEN_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    IRON_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    DIAMOND_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.LEGS, settingsNormal())),
    NETHERITE_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.LEGS, settingsNormal())),

    LEATHER_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_LEATHER, EquipmentSlot.HEAD, settingsNormal())),
    GOLDEN_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    PRIMSTEEL_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    IRON_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_IRON, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    DIAMOND_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    NETHERITE_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    BIKINI_NEUTRAL_REPAIRED(new ArmorItem(ArmorMats.BIKINI_NEUTRAL_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_REPAIRED(new ArmorItem(ArmorMats.BIKINI_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_MASC_REPAIRED(new ArmorItem(ArmorMats.BIKINI_MASC_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),

    CANVAS_HOOD(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settingsNormal())),
    CANVAS_TUNIC(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settingsNormal())),
    CANVAS_LEGGINGS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settingsNormal())),
    CANVAS_BOOTS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settingsNormal())),

    WATTLE_HELMET(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.HEAD, settingsNormal())),
    WATTLE_CHESTPLATE(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.CHEST, settingsNormal())),
    WATTLE_LEGGINGS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.LEGS, settingsNormal())),
    WATTLE_BOOTS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.FEET, settingsNormal())),

    //QUIVER(new ArmorItem(ArmorMats.QUIVER, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_HELMET(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.HEAD, settingsNormal())),
    LEATHER_CHESTPLATE(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_LEGGINGS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.LEGS, settingsNormal())),
    LEATHER_BOOTS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.FEET, settingsNormal())),
    //LEATHER_HOOD(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.HEAD, settingsNormal())),
    //LEATHER_TUNIC(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.CHEST, settingsNormal())),
    //LEATHER_SHORTS(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.LEGS, settingsNormal())),
    //LEATHER_SHOES(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.FEET, settingsNormal())),

    ROSEGOLD_HELMET(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CHESTPLATE(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_LEGGINGS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_BOOTS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),

    GOLEMITE_HELMET(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    GOLEMITE_CHESTPLATE(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    GOLEMITE_LEGGINGS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    GOLEMITE_BOOTS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),

    TURTLE_CHESTPLATE(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settingsNormal())),
    //TURTLE_LEGGINGS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settingsNormal())),
    TURTLE_BOOTS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settingsNormal())),
    //COPPER_DIVING_HELMET(new ArmorItem(ArmorMats.COPPER_DIVING, EquipmentSlot.HEAD, settingsNormal())),

    
    /**special armors**/

    //villager armors
    //VILLAGER_TUNIC(new UniqueArmorItem(ArmorMats.VILLAGER, EquipmentSlot.LEGS, settingsArtifacts())),
    CHEF_HAT(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.HEAD, settingsArtifacts())),
    CHEF_APRON(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.LEGS, settingsArtifacts())),
    STABLEHAND_HAT(new ArmorItem(ArmorMats.STABLEHAND_HAT, EquipmentSlot.HEAD, settingsArtifacts())),
    //BLACK_FEATHERED_HAT(new UniqueArmorItem(ArmorMats.BLACK_FEATHERED_HAT, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    //VISOR(new UniqueArmorItem(ArmorMats.VISOR, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    SNOW_CAP(new ArmorItem(ArmorMats.SNOW_CAP, EquipmentSlot.HEAD, settingsArtifacts())),
    //LIBRARIANS_HAT(new UniqueArmorItem(ArmorMats.LIBRARIAN, EquipmentSlot.HEAD, settingsArtifacts())),
    //TRADER_HEAD_SCARF(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    //TRADER_COAT(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    //TRADER_SKIRT(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //TRADER_SANDALS(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),

    //seaologer stuff
    PILLAGER_HEADSCARF(new ArmorItem(ArmorMats.HEADSCARF, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),

    //pillager armors
    //EVOKER_ROBE(new UniqueArmorItem(ArmorMats.EVOKER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //PILLAGER_FLANNEL(new UniqueArmorItem(ArmorMats.PILLAGER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    PILLAGER_BOOTS(new ArmorItem(ArmorMats.PILLAGER, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),

    //witch armors
    //WITCH_CLOAK(new UniqueArmorItem(ArmorMats.WITCH, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    //piglin armors
    PIGLIN_SKIRT(new ArmorItem(ArmorMats.PIGLIN, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    BRUTE_SKIRT(new ArmorItem(ArmorMats.BRUTE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    //moblin armors
    MOGARS_BROKEN_GOLEMITE_GOGGLES(new BrokenArmorItem(ArmorMats.MOGARS_BROKEN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    MOGARS_FIXED_GOLEMITE_GOGGLES(new ArmorItem(ArmorMats.MOGARS_FIXED, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),

    //living ppls junk
    //STRAYAS_CARTOGRAPHY_BAG(new UniqueArmorItem(ArmorMats.STRAYA, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    //FUR_BOOTS(new UniqueArmorItem(ArmorMats.FUR, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    //COPPER_AVIATORS(new UniqueArmorItem(ArmorMats.COPPER_AVIATORS, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),

    //zombie armors
    ZOMBIE_BOOTS(new ArmorItem(ArmorMats.ALEX, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    EFE_BOOTS(new ArmorItem(ArmorMats.EFE, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    //MINER_SHIRT(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    //MINER_PANTS(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //REPAIRED_MINER_SHIRT(new FixedUniqueArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    //REPAIRED_MINER_PANTS(new FixedUniqueArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //HUSK_SHIRT(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    //HUSK_PANTS(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //REPAIRED_HUSK_SHIRT(new FixedUniqueArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    //REPAIRED_HUSK_PANTS(new FixedUniqueArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //DROWNED_CLOTHES(new BrokenArmorItem(ArmorMats.DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //REPAIRED_DROWNED_CLOTHES(new FixedUniqueArmorItem(ArmorMats.REPAIRED_DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    //skeleton armors
    RIBCAGE(new ArmorItem(ArmorMats.RIBCAGE, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    WITHER_RIBCAGE(new ArmorItem(ArmorMats.WITHER_RIBCAGE, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_HOOD(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_COAT(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_SKIRT(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    //skeleton or zombie armors
    SCALE_MAIL_HELMET(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    SCALE_MAIL(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    SCALE_MAIL_SKIRT(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    //ancient dead ppl
    TREE_GOD_MASK(new ArmorItem(ArmorMats.TREE_GOD, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    ANCIENT_ROBE(new ArmorItem(ArmorMats.ANCIENT_ROBE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //SHULKER_HELMET(new UniqueArmorItem(ArmorMats.SHULKER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    MUMMY_WRAPS(new ArmorItem(ArmorMats.MUMMY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //BIKINI_COAT_GAITERS(new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),

    //BIKINI_NEUTRAL(new BrokenArmorItem(ArmorMats.BIKINI_NEUTRAL, EquipmentSlot.LEGS, settingsArtifacts())),
    //BIKINI(new BrokenArmorItem(ArmorMats.BIKINI, EquipmentSlot.LEGS, settingsArtifacts())),
    //BIKINI_MASC(new BrokenArmorItem(ArmorMats.BIKINI_MASC, EquipmentSlot.LEGS, settingsArtifacts())),
    //BIKINI_COAT_HOOD(new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.HEAD, settingsArtifacts())),
    //BIKINI_COAT(new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.CHEST, settingsArtifacts())),

    CROWN(new ArmorItem(ArmorMats.CROWN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    //BLIGHT_CROWN(new MythicArmorItem(ArmorMats.BLIGHT_CROWN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    RED_HOOD(new ArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    RED_CLOAK(new ArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    GREEN_HOOD(new ArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    GREEN_CLOAK(new ArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    PURPLE_HOOD(new ArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    PURPLE_CLOAK(new ArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    CYAN_HOOD(new ArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    CYAN_CLOAK(new ArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),

    //SWIMSUIT_NEUTRAL(new UniqueArmorItem(ArmorMats.SWIMSUIT_BLACK_NEUTRAL, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //SWIMSUIT_FEMME(new UniqueArmorItem(ArmorMats.SWIMSUIT_BLACK_FEMME, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    //SWIMSUIT_MASC(new UniqueArmorItem(ArmorMats.SWIMSUIT_BLACK_MASC, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    DIVING_HELMET(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    DIVING_CHESTPLATE(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    DIVING_LEGGINGS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    DIVING_BOOTS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),

    //test to get the 3d armor models running
    TEST_HELMET(new ClothingArmorItem(ArmorMats.CLOTH, EquipmentSlot.HEAD, settingDebug())),
    TEST_CHESTPLATE(new ClothingArmorItem(ArmorMats.CLOTH, EquipmentSlot.CHEST, settingDebug())),
    TEST_LEGGINGS(new ClothingArmorItem(ArmorMats.CLOTH, EquipmentSlot.LEGS, settingDebug())),
    TEST_BOOTS(new ClothingArmorItem(ArmorMats.CLOTH, EquipmentSlot.FEET, settingDebug()));

    /** Called from {@link ModItems} */
    public static void initialize() {

    }

    private static final Item.Settings settingsArtifacts() {
        return new Item.Settings().group(BOOKS);
    }

    private static final Item.Settings settingsArtifacts(Rarity rarity) {
        return settingsArtifacts().rarity(rarity);
    }

    private static Item.Settings settingsNormal() {
        return new Item.Settings().group(CLOTHING);
    }

    private static Item.Settings settingDebug() {
        return new Item.Settings();
    }

    private static Item.Settings settingsNormal(Rarity rarity) {
        return settingsNormal().rarity(rarity);
    }

    // ### The Enum Class Itself ###

    public final Item item;
    public final Identifier id;

    ModArmors(Item item) {
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
