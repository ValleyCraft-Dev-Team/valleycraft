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
    
    //ALCHEMISTS_LEGGINGS(new UniqueArmorItem(ArmorMats.LEGGINGS, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    LIBRARIANS_HAT(new UniqueArmorItem(ArmorMats.LIBRARIAN, EquipmentSlot.HEAD, settingsArtifacts())),
    SNOW_CAP(new UniqueArmorItem(ArmorMats.SNOW_CAP, EquipmentSlot.HEAD, settingsArtifacts())),
    STABLEHAND_HAT(new UniqueArmorItem(ArmorMats.STABLEHAND_HAT, EquipmentSlot.HEAD, settingsArtifacts())),
    VILLAGER_TUNIC(new UniqueArmorItem(ArmorMats.VILLAGER, EquipmentSlot.LEGS, settingsArtifacts())),

    //IRON_GLASSES(new ArmorItem(ArmorMats.GOLDEN_GLASSES, EquipmentSlot.HEAD, settingsNormal())),
    //GOLDEN_GLASSES(new ArmorItem(ArmorMats.GOLDEN_GLASSES, EquipmentSlot.HEAD, settingsNormal())),
    //ROSEGOLD_GLASSES(new ArmorItem(ArmorMats.ROSEGOLD_GLASSES, EquipmentSlot.HEAD, settingsNormal())),
    //GOLEMITE_READING_GLASSES(new ArmorItem(ArmorMats.GOLEMITE_READING_GLASSES, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),

    CHEF_HAT(new UniqueArmorItem(ArmorMats.CHEF, EquipmentSlot.HEAD, settingsArtifacts())),
    CHEF_APRON(new UniqueArmorItem(ArmorMats.CHEF, EquipmentSlot.LEGS, settingsArtifacts())),

    TRADER_HEAD_SCARF(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_COAT(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_SKIRT(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_SANDALS(new UniqueArmorItem(ArmorMats.TRADER, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    PILLAGER_HEADSCARF(new UniqueArmorItem(ArmorMats.HEADSCARF, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    //PILLAGER_EYEPATCH(new ArmorItem(ArmorMats.EYEPATCH, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    PILLAGER_FLANNEL(new UniqueArmorItem(ArmorMats.PILLAGER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    PILLAGER_BOOTS(new UniqueArmorItem(ArmorMats.PILLAGER, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),
    EVOKER_ROBE(new UniqueArmorItem(ArmorMats.EVOKER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    WITCH_CLOAK(new UniqueArmorItem(ArmorMats.WITCH, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    COPPER_AVIATORS(new UniqueArmorItem(ArmorMats.COPPER_AVIATORS, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    VISOR(new UniqueArmorItem(ArmorMats.VISOR, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    MOGARS_BROKEN_GOLEMITE_GOGGLES(new BrokenArmorItem(ArmorMats.MOGARS_BROKEN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    MOGARS_FIXED_GOLEMITE_GOGGLES(new FixedUniqueArmorItem(ArmorMats.MOGARS_FIXED, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    STRAYAS_CARTOGRAPHY_BAG(new UniqueArmorItem(ArmorMats.STRAYA, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),

    //PIGLIN_TUNIC(new ArmorItem(BruteMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    PIGLIN_SKIRT(new UniqueArmorItem(ArmorMats.PIGLIN, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //PIGLIN_TUNIC(new ArmorItem(PiglinMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    BRUTE_SKIRT(new UniqueArmorItem(ArmorMats.BRUTE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    SCALE_MAIL_HELMET(new UniqueArmorItem(ArmorMats.SCALE, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    SCALE_MAIL(new UniqueArmorItem(ArmorMats.SCALE, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    SCALE_MAIL_SKIRT(new UniqueArmorItem(ArmorMats.SCALE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    DROWNED_CLOTHES(new BrokenArmorItem(ArmorMats.DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_DROWNED_CLOTHES(new FixedUniqueArmorItem(ArmorMats.REPAIRED_DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    MINER_SHIRT(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    MINER_PANTS(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_MINER_SHIRT(new FixedUniqueArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    REPAIRED_MINER_PANTS(new FixedUniqueArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    HUSK_SHIRT(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    HUSK_PANTS(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_HUSK_SHIRT(new FixedUniqueArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    REPAIRED_HUSK_PANTS(new FixedUniqueArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    MUMMY_WRAPS(new UniqueArmorItem(ArmorMats.MUMMY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //ANCIENT_AGLETS(new UniqueArmorItem(ArmorMats.ANCIENT_AGLETS, EquipmentSlot.LEGS, settingsArtifacts(Rarity.EPIC))),
    ANCIENT_ROBE(new UniqueArmorItem(ArmorMats.ANCIENT_ROBE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    STRAY_HOOD(new UniqueArmorItem(ArmorMats.STRAY, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_COAT(new UniqueArmorItem(ArmorMats.STRAY, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_SKIRT(new UniqueArmorItem(ArmorMats.STRAY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    ZOMBIE_BOOTS(new UniqueArmorItem(ArmorMats.ALEX, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    EFE_BOOTS(new UniqueArmorItem(ArmorMats.EFE, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),

    RED_HOOD(new UniqueArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    RED_CLOAK(new UniqueArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    GREEN_HOOD(new UniqueArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    GREEN_CLOAK(new UniqueArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    PURPLE_HOOD(new UniqueArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    PURPLE_CLOAK(new UniqueArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    CYAN_HOOD(new UniqueArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    CYAN_CLOAK(new UniqueArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),

    STRAW_HAT(new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settingsNormal())),

    FLOWER_CROWN(new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settingsNormal())),
    DIERDRA_LAUREL(new ArmorItem(ArmorMats.DIERDRA_LAUREL, EquipmentSlot.HEAD, settingsNormal())),

    REINFORCED_LEATHER_HELMET(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_GOLDEN_HELMET(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_IRON_HELMET(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_ROSEGOLD_HELMET(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    //REINFORCED_GOLEMITE_HELMET(new ArmorItem(ArmorMats.RF_GOLEMITE, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_DIAMOND_HELMET(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_NETHERITE_HELMET(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    LEATHER_BREASTPLATE(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.CHEST, settingsNormal())),
    GOLDEN_BREASTPLATE(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_BREASTPLATE(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    IRON_BREASTPLATE(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_BREASTPLATE(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    //GOLEMITE_BREASTPLATE(new ArmorItem(ArmorMats.RF_GOLEMITE, EquipmentSlot.CHEST, settingsNormal())),
    DIAMOND_BREASTPLATE(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.CHEST, settingsNormal())),
    NETHERITE_BREASTPLATE(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.CHEST, settingsNormal())),

    GOLDEN_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    //EMERALD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_EMERALD, EquipmentSlot.HEAD, settingsNormal())),
    IRON_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_IRON, EquipmentSlot.HEAD, settingsNormal())),
    //AMBER_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_AMBER, EquipmentSlot.HEAD, settingsNormal())),
    //AMETHYST_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_AMETHYST, EquipmentSlot.HEAD, settingsNormal())),
    //DIAMOND_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    //PRISMARINE_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_PRISMARINE, EquipmentSlot.HEAD, settingsNormal())),
    //ECHO_SHARD_DIADEM(new ArmorItem(ArmorMats.ECHO_DIADEM, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),

    CROWN(new UniqueArmorItem(ArmorMats.CROWN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),

    BIKINI_MASC_REPAIRED(new ArmorItem(ArmorMats.BIKINI_MASC_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_REPAIRED(new ArmorItem(ArmorMats.BIKINI_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),

    TREE_GOD_MASK(new UniqueArmorItem(ArmorMats.TREE_GOD, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),

    CANVAS_HOOD(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settingsNormal())),
    CANVAS_TUNIC(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settingsNormal())),
    CANVAS_LEGGINGS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settingsNormal())),
    CANVAS_BOOTS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settingsNormal())),

    WATTLE_HELMET(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.HEAD, settingsNormal())),
    WATTLE_CHESTPLATE(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.CHEST, settingsNormal())),
    WATTLE_LEGGINGS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.LEGS, settingsNormal())),
    WATTLE_BOOTS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.FEET, settingsNormal())),

    LEATHER_HELMET(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.HEAD, settingsNormal())),
    LEATHER_CHESTPLATE(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_LEGGINGS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.LEGS, settingsNormal())),
    LEATHER_BOOTS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.FEET, settingsNormal())),
    LEATHER_HOOD(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.HEAD, settingsNormal())),
    LEATHER_TUNIC(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_SHORTS(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.LEGS, settingsNormal())),
    LEATHER_SHOES(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.FEET, settingsNormal())),

    FUR_BOOTS(new UniqueArmorItem(ArmorMats.FUR, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),

    BIKINI_MASC(new BrokenArmorItem(ArmorMats.BIKINI_MASC, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI(new BrokenArmorItem(ArmorMats.BIKINI, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI_COAT(new UniqueArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.CHEST, settingsArtifacts())),
    SWIMSUIT_MASC(new UniqueArmorItem(ArmorMats.SWIMSUIT_BLACK_MASC, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    SWIMSUIT_FEMME(new UniqueArmorItem(ArmorMats.SWIMSUIT_BLACK_FEMME, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    DIVING_HELMET(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.HEAD, settingsNormal(Rarity.RARE))),
    DIVING_CHESTPLATE(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.CHEST, settingsNormal(Rarity.RARE))),
    DIVING_LEGGINGS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.LEGS, settingsNormal(Rarity.RARE))),
    DIVING_BOOTS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.FEET, settingsNormal(Rarity.RARE))),

    //ALEX_SHIRT(new ArmorItem(AlexMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    //ALEX_SHORTS(new ArmorItem(AlexMaterial.INSTANCE, EquipmentSlot.LEGS, settingsNormal())),
    //STEVE_SHIRT(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    //STEVE_PANTS(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.LEGS, settingsNormal())),
    //STEVE_SHOES(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.FEET, settingsNormal())),

    //PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    //PRIMSTEEL_CHESTPLATE(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    //PRIMSTEEL_LEGGINGS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    //PRIMSTEEL_BOOTS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),

    ROSEGOLD_HELMET(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CHESTPLATE(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_LEGGINGS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_BOOTS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),

    GOLEMITE_HELMET(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    GOLEMITE_CHESTPLATE(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    GOLEMITE_LEGGINGS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    GOLEMITE_BOOTS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),

    SHULKER_HELMET(new UniqueArmorItem(ArmorMats.SHULKER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),

    TURTLE_CHESTPLATE(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settingsNormal())),
    TURTLE_LEGGINGS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settingsNormal())),
    TURTLE_BOOTS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settingsNormal())),

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
