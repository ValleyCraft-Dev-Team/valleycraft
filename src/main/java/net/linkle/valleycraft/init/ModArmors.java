package net.linkle.valleycraft.init;

import net.linkle.valleycraft.armors.*;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.linkle.valleycraft.init.ModGroups.*;

public class ModArmors {
    private static final Item.Settings settings = new Item.Settings().group(CLOTHING);
    private static final Item.Settings settings_artifacts_uncommon = new Item.Settings().group(BOOKS).rarity(Rarity.UNCOMMON);
    private static final Item.Settings settings_artifacts_scarce = new Item.Settings().group(BOOKS);
    private static final Item.Settings settings_artifacts_rare = new Item.Settings().group(BOOKS).rarity(Rarity.RARE);
    private static final Item.Settings settings_artifacts_epic = new Item.Settings().group(BOOKS).rarity(Rarity.EPIC);
    private static final Item.Settings settings_artifacts_repaired = new Item.Settings().group(BOOKS).rarity(Rarity.EPIC);
    private static final Item.Settings settings_uncommon = new Item.Settings().group(CLOTHING).rarity(Rarity.UNCOMMON);

    public static final Item MOBLIN_TALISMAN = new ArmorItem(ArmorMats.MOBLIN_TALISMAN, EquipmentSlot.CHEST, settings_artifacts_uncommon);
    public static final Item MOGARS_BROKEN = new ArmorItem(ArmorMats.MOGARS_BROKEN, EquipmentSlot.HEAD, settings_artifacts_epic);
    public static final Item MOGARS_FIXED = new ArmorItem(ArmorMats.MOGARS_FIXED, EquipmentSlot.HEAD, settings_artifacts_repaired);

    public static final Item STRAYA = new ArmorItem(ArmorMats.STRAYA, EquipmentSlot.CHEST, settings_artifacts_epic);

    public static final Item OLDWORLD_LEGGINGS = new ArmorItem(ArmorMats.LEGGINGS, EquipmentSlot.LEGS, settings_artifacts_rare);

    public static final Item FUR_BOOTS = new ArmorItem(ArmorMats.FUR, EquipmentSlot.FEET, settings_uncommon);

    public static final Item EYEPATCH = new ArmorItem(ArmorMats.EYEPATCH, EquipmentSlot.HEAD, settings_artifacts_uncommon);

    public static final Item FLOWER_CROWN = new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settings);
    public static final Item STRAW_HAT = new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settings);

    public static final Item CANVAS_HOOD = new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settings);
    public static final Item CANVAS_TUNIC = new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settings);
    public static final Item CANVAS_LEGGINGS = new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settings);
    public static final Item CANVAS_BOOTS = new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settings);

    public static final Item BIKINI_MASC = new ArmorItem(ArmorMats.BIKINI_MASC, EquipmentSlot.LEGS, settings);
    public static final Item BIKINI = new ArmorItem(ArmorMats.BIKINI, EquipmentSlot.LEGS, settings);
    public static final Item BIKINI_COAT = new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.CHEST, settings);

    public static final Item TURTLE_CHESTPLATE = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settings);
    public static final Item TURTLE_LEGGINGS = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settings);
    public static final Item TURTLE_BOOTS = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settings);

    public static final Item TRADER_HEAD_SCARF = new ArmorItem(ArmorMats.TRADER, EquipmentSlot.HEAD, settings_artifacts_uncommon);
    public static final Item TRADER_COAT = new ArmorItem(ArmorMats.TRADER, EquipmentSlot.CHEST, settings_artifacts_uncommon);
    public static final Item TRADER_SKIRT = new ArmorItem(ArmorMats.TRADER, EquipmentSlot.LEGS, settings_artifacts_uncommon);
    public static final Item TRADER_SANDALS = new ArmorItem(ArmorMats.TRADER, EquipmentSlot.FEET, settings_artifacts_uncommon);

    public static final Item LIBRARIAN = new ArmorItem(ArmorMats.LIBRARIAN, EquipmentSlot.HEAD, settings_artifacts_scarce);
    public static final Item VISOR = new ArmorItem(ArmorMats.VISOR, EquipmentSlot.HEAD, settings_artifacts_rare);
    public static final Item SNOW_CAP = new ArmorItem(ArmorMats.SNOW_CAP, EquipmentSlot.HEAD, settings_artifacts_scarce);
    public static final Item VILLAGER_TUNIC = new ArmorItem(ArmorMats.VILLAGER, EquipmentSlot.LEGS, settings_artifacts_scarce);

    public static final Item PILLAGER_FLANNEL = new ArmorItem(ArmorMats.PILLAGER, EquipmentSlot.CHEST, settings_artifacts_rare);
    public static final Item PILLAGER_BOOTS = new ArmorItem(ArmorMats.PILLAGER, EquipmentSlot.FEET, settings_artifacts_rare);

    //public static final Item BRUTE_TUNIC = new ArmorItem(ArmorMats.BRUTE, EquipmentSlot.CHEST, settings);
    //public static final Item BRUTE_SKIRT = new ArmorItem(ArmorMats.BRUTE, EquipmentSlot.LEGS, settings);
    //public static final Item PIGLIN_TUNIC = new ArmorItem(ArmorMats.PIGLIN, EquipmentSlot.CHEST, settings);
    //public static final Item PIGLIN_SKIRT = new ArmorItem(ArmorMats.PIGLIN, EquipmentSlot.LEGS, settings);

    //public static final Item ALEX_SHIRT = new ArmorItem(ArmorMats.ALEX, EquipmentSlot.CHEST, settings);
    //public static final Item ALEX_SHORTS = new ArmorItem(ArmorMats.ALEX, EquipmentSlot.LEGS, settings);
    public static final Item ALEX_BOOTS = new ArmorItem(ArmorMats.ALEX, EquipmentSlot.FEET, settings_artifacts_uncommon);
    //public static final Item STEVE_SHIRT = new ArmorItem(ArmorMats.STEVE, EquipmentSlot.CHEST, settings);
    //public static final Item STEVE_PANTS = new ArmorItem(ArmorMats.STEVE, EquipmentSlot.LEGS, settings);
    //public static final Item STEVE_SHOES = new ArmorItem(ArmorMats.STEVE, EquipmentSlot.FEET, settings);

    public static final Item DROWNED_CLOTHES = new ArmorItem(ArmorMats.DROWNED, EquipmentSlot.LEGS, settings_artifacts_uncommon);
    public static final Item HUSK_SHIRT = new ArmorItem(ArmorMats.HUSK, EquipmentSlot.CHEST, settings_artifacts_uncommon);
    public static final Item HUSK_SHORTS = new ArmorItem(ArmorMats.HUSK, EquipmentSlot.LEGS, settings_artifacts_uncommon);
    public static final Item STRAY_HOOD = new ArmorItem(ArmorMats.STRAY, EquipmentSlot.HEAD, settings_artifacts_uncommon);
    public static final Item STRAY_COAT = new ArmorItem(ArmorMats.STRAY, EquipmentSlot.CHEST, settings_artifacts_uncommon);
    public static final Item STRAY_SKIRT = new ArmorItem(ArmorMats.STRAY, EquipmentSlot.LEGS, settings_artifacts_uncommon);

    //public static final Item GOLEMITE_HELMET = new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.CHEST, settings);
    //public static final Item GOLEMITE_CHESTPLATE = new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.CHEST, settings);
    //public static final Item GOLEMITE_LEGGINGS = new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.LEGS, settings);
    //public static final Item GOLEMITE_BOOTS = new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.FEET, settings);

    //public static final Item PRIMSTEEL_HELMET = new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settings);
    //public static final Item PRIMSTEEL_CHESTPLATE = new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settings);
    //public static final Item PRIMSTEEL_LEGGINGS = new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settings);
    //public static final Item PRIMSTEEL_BOOTS = new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settings);

    public static void initialize() {
        //artifact armors
        Reg.register("moblin_talisman", MOBLIN_TALISMAN);
        Reg.register("mogars_broken_golemite_goggles", MOGARS_BROKEN);
        Reg.register("mogars_fixed_golemite_goggles", MOGARS_FIXED);
        Reg.register("strayas_cartography_bag", STRAYA);
        Reg.register("alchemists_leggings", OLDWORLD_LEGGINGS);
        Reg.register("fur_boots", FUR_BOOTS);
        Reg.register("librarians_hat", LIBRARIAN);
        Reg.register("snow_cap", SNOW_CAP);
        Reg.register("villager_tunic", VILLAGER_TUNIC);

        Reg.register("trader_head_scarf", TRADER_HEAD_SCARF);
        Reg.register("trader_coat", TRADER_COAT);
        Reg.register("trader_skirt", TRADER_SKIRT);
        Reg.register("trader_sandals", TRADER_SANDALS);
        Reg.register("visor", VISOR);
        Reg.register("pillager_eyepatch", EYEPATCH);
        Reg.register("pillager_flannel", PILLAGER_FLANNEL);
        Reg.register("pillager_boots", PILLAGER_BOOTS);

        //Reg.register("piglin_tunic", PIGLIN_TUNIC);
        //Reg.register("piglin_skirt", PIGLIN_SKIRT);
        //Reg.register("brute_tunic", BRUTE_TUNIC);
        //Reg.register("brute_skirt", BRUTE_SKIRT);

        //Reg.register("zombie_shirt_masc", STEVE_SHIRT);
        //Reg.register("zombie_pants", STEVE_PANTS);
        //Reg.register("zombie_shoes", STEVE_SHOES);
        //Reg.register("zombie_shirt_femme", ALEX_SHIRT);
        //Reg.register("zombie_shorts", ALEX_SHORTS);
        Reg.register("zombie_boots", ALEX_BOOTS);

        Reg.register("drowned_clothes", DROWNED_CLOTHES);
        Reg.register("husk_shirt", HUSK_SHIRT);
        Reg.register("husk_pants", HUSK_SHORTS);
        Reg.register("stray_hood", STRAY_HOOD);
        Reg.register("stray_coat", STRAY_COAT);
        Reg.register("stray_skirt", STRAY_SKIRT);


        //regular clothing
        Reg.register("straw_hat", STRAW_HAT);

        Reg.register("flower_crown", FLOWER_CROWN);

        Reg.register("canvas_hood", CANVAS_HOOD);
        Reg.register("canvas_tunic", CANVAS_TUNIC);
        Reg.register("canvas_leggings", CANVAS_LEGGINGS);
        Reg.register("canvas_boots", CANVAS_BOOTS);

        Reg.register("bikini_masc", BIKINI_MASC);
        Reg.register("bikini", BIKINI);
        Reg.register("bikini_coat", BIKINI_COAT);

        Reg.register("turtle_chestplate", TURTLE_CHESTPLATE);
        Reg.register("turtle_leggings", TURTLE_LEGGINGS);
        Reg.register("turtle_boots", TURTLE_BOOTS);
    }
}
