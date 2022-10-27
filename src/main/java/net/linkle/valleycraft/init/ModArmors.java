package net.linkle.valleycraft.init;

import net.linkle.valleycraft.armors.*;
import net.linkle.valleycraft.util.ItemEnum;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.linkle.valleycraft.init.ModGroups.*;

import net.linkle.valleycraft.Main;

public enum ModArmors implements ItemEnum {
    
    MOBLIN_TALISMAN(new ArmorItem(ArmorMats.MOBLIN_TALISMAN, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    MOGARS_BROKEN_GOLEMITE_GOGGLES(new BrokenArmorItem(ArmorMats.MOGARS_BROKEN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    MOGARS_FIXED_GOLEMITE_GOGGLES(new ArmorItem(ArmorMats.MOGARS_FIXED, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    STRAYAS_CARTOGRAPHY_BAG(new ArmorItem(ArmorMats.STRAYA, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    ALCHEMISTS_LEGGINGS(new ArmorItem(ArmorMats.LEGGINGS, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    LIBRARIANS_HAT(new ArmorItem(ArmorMats.LIBRARIAN, EquipmentSlot.HEAD, settingsArtifacts())),
    SNOW_CAP(new ArmorItem(ArmorMats.SNOW_CAP, EquipmentSlot.HEAD, settingsArtifacts())),
    STABLEHAND_HAT(new ArmorItem(ArmorMats.STABLEHAND_HAT, EquipmentSlot.HEAD, settingsArtifacts())),
    VILLAGER_TUNIC(new ArmorItem(ArmorMats.VILLAGER, EquipmentSlot.LEGS, settingsArtifacts())),
    WITCH_CLOAK(new ArmorItem(ArmorMats.WITCH, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    EMERALD_TALISMAN(new ArmorItem(ArmorMats.EMERALD_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.UNCOMMON))),
    AMETHYST_TALISMAN(new ArmorItem(ArmorMats.AMETHYST_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.UNCOMMON))),
    ECHO_SHARD_TALISMAN(new ArmorItem(ArmorMats.ECHO_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.EPIC))),
    ENDER_DRAGON_TALISMAN(new ArmorItem(ArmorMats.ENDER_DRAGON_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.EPIC))),
    GOLDEN_GLASSES(new ArmorItem(ArmorMats.GOLDEN_GLASSES, EquipmentSlot.HEAD, settingsNormal(Rarity.UNCOMMON))),
    ROSEGOLD_GLASSES(new ArmorItem(ArmorMats.ROSEGOLD_GLASSES, EquipmentSlot.HEAD, settingsNormal(Rarity.RARE))),

    BUTTON(new ArmorItem(ArmorMats.BUTTON, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    CHEF_HAT(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.HEAD, settingsNormal())),
    CHEF_APRON(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.LEGS, settingsNormal())),

    TRADER_HEAD_SCARF(new ArmorItem(ArmorMats.TRADER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_COAT(new ArmorItem(ArmorMats.TRADER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_SKIRT(new ArmorItem(ArmorMats.TRADER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    TRADER_SANDALS(new ArmorItem(ArmorMats.TRADER, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    VISOR(new ArmorItem(ArmorMats.VISOR, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    PILLAGER_EYEPATCH(new ArmorItem(ArmorMats.EYEPATCH, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    PILLAGER_FLANNEL(new ArmorItem(ArmorMats.PILLAGER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    PILLAGER_BOOTS(new ArmorItem(ArmorMats.PILLAGER, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),

    //PIGLIN_TUNIC(new ArmorItem(BruteMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    PIGLIN_SKIRT(new ArmorItem(ArmorMats.PIGLIN, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //PIGLIN_TUNIC(new ArmorItem(PiglinMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    BRUTE_SKIRT(new ArmorItem(ArmorMats.BRUTE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    SCALE_MAIL(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    SCALE_MAIL_SKIRT(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    ZOMBIE_BOOTS(new ArmorItem(ArmorMats.ALEX, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),
    EFE_BOOTS(new ArmorItem(ArmorMats.EFE, EquipmentSlot.FEET, settingsArtifacts(Rarity.UNCOMMON))),

    DROWNED_CLOTHES(new BrokenArmorItem(ArmorMats.DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_DROWNED_CLOTHES(new ArmorItem(ArmorMats.REPAIRED_DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    HUSK_SHIRT(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    HUSK_PANTS(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    MUMMY_WRAPS(new ArmorItem(ArmorMats.MUMMY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    REPAIRED_HUSK_SHIRT(new ArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    REPAIRED_HUSK_PANTS(new ArmorItem(ArmorMats.REPAIRED_HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    MINER_SHIRT(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    MINER_PANTS(new BrokenArmorItem(ArmorMats.MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_MINER_SHIRT(new ArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    REPAIRED_MINER_PANTS(new ArmorItem(ArmorMats.REPAIRED_MINER, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),

    STRAY_HOOD(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_COAT(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    STRAY_SKIRT(new ArmorItem(ArmorMats.STRAY, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),

    RED_HOOD(new ArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    RED_CLOAK(new ArmorItem(ArmorMats.RED_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    GREEN_HOOD(new ArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    GREEN_CLOAK(new ArmorItem(ArmorMats.GREEN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    PURPLE_HOOD(new ArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    PURPLE_CLOAK(new ArmorItem(ArmorMats.PURPLE_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    CYAN_HOOD(new ArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    CYAN_CLOAK(new ArmorItem(ArmorMats.CYAN_CLOAK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),

    STRAW_HAT(new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settingsNormal())),

    FLOWER_CROWN(new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settingsNormal())),

    REINFORCED_GOLDEN_HELMET(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_IRON_HELMET(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_ROSEGOLD_HELMET(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_GOLEMITE_HELMET(new ArmorItem(ArmorMats.RF_GOLEMITE, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_DIAMOND_HELMET(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_NETHERITE_HELMET(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    GOLDEN_ARM_GUARDS(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_ARM_GUARDS(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    IRON_ARM_GUARDS(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_ARM_GUARDS(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    GOLEMITE_ARM_GUARDS(new ArmorItem(ArmorMats.RF_GOLEMITE, EquipmentSlot.CHEST, settingsNormal())),
    DIAMOND_ARM_GUARDS(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.CHEST, settingsNormal())),
    NETHERITE_ARM_GUARDS(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.CHEST, settingsNormal())),

    GOLDEN_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    EMERALD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_EMERALD, EquipmentSlot.HEAD, settingsNormal())),
    IRON_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_IRON, EquipmentSlot.HEAD, settingsNormal())),
    AMBER_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_AMBER, EquipmentSlot.HEAD, settingsNormal())),
    AMETHYST_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_AMETHYST, EquipmentSlot.HEAD, settingsNormal())),
    DIAMOND_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    PRISMARINE_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_PRISMARINE, EquipmentSlot.HEAD, settingsNormal())),
    ECHO_SHARD_DIADEM(new ArmorItem(ArmorMats.ECHO_DIADEM, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),

    CANVAS_HOOD(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settingsNormal())),
    CANVAS_TUNIC(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settingsNormal())),
    CANVAS_LEGGINGS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settingsNormal())),
    CANVAS_BOOTS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settingsNormal())),

    LEATHER_HELMET(new DyeableArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.HEAD, settingsNormal())),
    LEATHER_CHESTPLATE(new DyeableArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_LEGGINGS(new DyeableArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.LEGS, settingsNormal())),
    LEATHER_BOOTS(new DyeableArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.FEET, settingsNormal())),

    CLOTH_HELMET(new ModDyeableArmorItem(ArmorMats.CLOTH, EquipmentSlot.HEAD, settingsNormal())),
    CLOTH_CHESTPLATE(new ModDyeableArmorItem(ArmorMats.CLOTH, EquipmentSlot.CHEST, settingsNormal())),
    CLOTH_LEGGINGS(new ModDyeableArmorItem(ArmorMats.CLOTH, EquipmentSlot.LEGS, settingsNormal())),
    CLOTH_BOOTS(new ModDyeableArmorItem(ArmorMats.CLOTH, EquipmentSlot.FEET, settingsNormal())),

    FUR_BOOTS(new ArmorItem(ArmorMats.FUR, EquipmentSlot.FEET, settingsNormal(Rarity.UNCOMMON))),

    BIKINI_MASC(new ArmorItem(ArmorMats.BIKINI_MASC, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI(new ArmorItem(ArmorMats.BIKINI, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI_COAT(new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.CHEST, settingsNormal())),
    BIKINI_MASC_REPAIRED(new ArmorItem(ArmorMats.BIKINI_MASC_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_REPAIRED(new ArmorItem(ArmorMats.BIKINI_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    SWIMSUIT_MASC(new ArmorItem(ArmorMats.SWIMSUIT_BLACK_MASC, EquipmentSlot.LEGS, settingsNormal())),
    SWIMSUIT_FEMME(new ArmorItem(ArmorMats.SWIMSUIT_BLACK_FEMME, EquipmentSlot.LEGS, settingsNormal())),

    TURTLE_CHESTPLATE(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settingsNormal())),
    TURTLE_LEGGINGS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settingsNormal())),
    TURTLE_BOOTS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settingsNormal())),

    DIVING_HELMET(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    DIVING_CHESTPLATE(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    DIVING_LEGGINGS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    DIVING_BOOTS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),

    //ALEX_SHIRT(new ArmorItem(AlexMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    //ALEX_SHORTS(new ArmorItem(AlexMaterial.INSTANCE, EquipmentSlot.LEGS, settingsNormal())),
    //STEVE_SHIRT(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.CHEST, settingsNormal())),
    //STEVE_PANTS(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.LEGS, settingsNormal())),
    //STEVE_SHOES(new ArmorItem(SteveMaterial.INSTANCE, EquipmentSlot.FEET, settingsNormal())),

    PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    PRIMSTEEL_CHESTPLATE(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_LEGGINGS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_BOOTS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),

    ROSEGOLD_HELMET(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CHESTPLATE(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_LEGGINGS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_BOOTS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),

    GOLEMITE_HELMET(new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.HEAD, settingsNormal())),
    GOLEMITE_CHESTPLATE(new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.CHEST, settingsNormal())),
    GOLEMITE_LEGGINGS(new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.LEGS, settingsNormal())),
    GOLEMITE_BOOTS(new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.FEET, settingsNormal())),

    SHULKER_HELMET(new ArmorItem(ArmorMats.SHULKER, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    SHULKER_ARM_GUARDS(new ArmorItem(ArmorMats.SHULKER, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC)));

    /** Called from {@link ModItems} */
    static void initialize() {
        
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
}
