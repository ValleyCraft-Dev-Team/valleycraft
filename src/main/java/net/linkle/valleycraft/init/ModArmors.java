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

    public static final Item MOBLIN_TALISMAN = new ArmorItem(MoblinTalismanMaterial.INSTANCE, EquipmentSlot.CHEST, settings_artifacts_rare);
    public static final Item MOGARS_BROKEN = new ArmorItem(MogarsBrokenMaterial.INSTANCE, EquipmentSlot.HEAD, settings_artifacts_epic);
    public static final Item MOGARS_FIXED = new ArmorItem(MogarsFixedMaterial.INSTANCE, EquipmentSlot.HEAD, settings_artifacts_repaired);

    public static final Item STRAYA = new ArmorItem(StrayaMaterial.STRAYA, EquipmentSlot.CHEST, settings_artifacts_epic);

    public static final Item OLDWORLD_LEGGINGS = new ArmorItem(LeggingsMaterial.INSTANCE, EquipmentSlot.LEGS, settings_artifacts_rare);

    public static final Item FUR_BOOTS = new ArmorItem(FurMaterial.INSTANCE, EquipmentSlot.FEET, settings_artifacts_scarce);

    public static final Item EYEPATCH = new ArmorItem(EyePatchMaterial.INSTANCE, EquipmentSlot.HEAD, settings_artifacts_scarce);

    public static final Item FLOWER_CROWN = new ArmorItem(FlowerHatMaterial.INSTANCE, EquipmentSlot.HEAD, settings);
    public static final Item STRAW_HAT = new ArmorItem(StrawHatMaterial.INSTANCE, EquipmentSlot.HEAD, settings);

    public static final Item CANVAS_HOOD = new ArmorItem(CanvasMaterial.INSTANCE, EquipmentSlot.HEAD, settings);
    public static final Item CANVAS_TUNIC = new ArmorItem(CanvasMaterial.INSTANCE, EquipmentSlot.CHEST, settings);
    public static final Item CANVAS_LEGGINGS = new ArmorItem(CanvasMaterial.INSTANCE, EquipmentSlot.LEGS, settings);
    public static final Item CANVAS_BOOTS = new ArmorItem(CanvasMaterial.INSTANCE, EquipmentSlot.FEET, settings);

    public static final Item TURTLE_CHESTPLATE = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settings);
    public static final Item TURTLE_LEGGINGS = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settings);
    public static final Item TURTLE_BOOTS = new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settings);

    //public static final Item GOLEMITE_HELMET = new ArmorItem(GolemiteArmorMaterial.INSTANCE, EquipmentSlot.CHEST, settings);
    //public static final Item GOLEMITE_CHESTPLATE = new ArmorItem(GolemiteArmorMaterial.INSTANCE, EquipmentSlot.CHEST, settings);
    //public static final Item GOLEMITE_LEGGINGS = new ArmorItem(GolemiteArmorMaterial.INSTANCE, EquipmentSlot.LEGS, settings);
    //public static final Item GOLEMITE_BOOTS = new ArmorItem(GolemiteArmorMaterial.INSTANCE, EquipmentSlot.FEET, settings);

    //public static final Item PRIMSTEEL_HELMET = new ArmorItem(PrimsteelArmorMaterial.INSTANCE, EquipmentSlot.CHEST, settings);
    //public static final Item PRIMSTEEL_CHESTPLATE = new ArmorItem(PrimsteelArmorMaterial.INSTANCE, EquipmentSlot.CHEST, settings);
    //public static final Item PRIMSTEEL_LEGGINGS = new ArmorItem(PrimsteelArmorMaterial.INSTANCE, EquipmentSlot.LEGS, settings);
    //public static final Item PRIMSTEEL_BOOTS = new ArmorItem(PrimsteelArmorMaterial.INSTANCE, EquipmentSlot.FEET, settings);

    public static void initialize() {
        //artifact armors
        Reg.register("moblin_talisman", MOBLIN_TALISMAN);
        Reg.register("mogars_broken_golemite_goggles", MOGARS_BROKEN);
        Reg.register("mogars_fixed_golemite_goggles", MOGARS_FIXED);
        Reg.register("strayas_cartography_bag", STRAYA);
        Reg.register("alchemists_leggings", OLDWORLD_LEGGINGS);
        Reg.register("fur_boots", FUR_BOOTS);
        Reg.register("pillager_eyepatch", EYEPATCH);

        //regular clothing
        Reg.register("straw_hat", STRAW_HAT);

        Reg.register("flower_crown", FLOWER_CROWN);

        Reg.register("canvas_hood", CANVAS_HOOD);
        Reg.register("canvas_tunic", CANVAS_TUNIC);
        Reg.register("canvas_leggings", CANVAS_LEGGINGS);
        Reg.register("canvas_boots", CANVAS_BOOTS);

        Reg.register("turtle_chestplate", TURTLE_CHESTPLATE);
        Reg.register("turtle_leggings", TURTLE_LEGGINGS);
        Reg.register("turtle_boots", TURTLE_BOOTS);
    }
}
