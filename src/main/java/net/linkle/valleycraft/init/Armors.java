package net.linkle.valleycraft.init;

import static net.linkle.valleycraft.init.Groups.CLOTHING;
import static net.minecraft.util.Rarity.EPIC;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.armors.*;
import net.linkle.valleycraft.enums.ItemEnum;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public enum Armors implements ItemEnum {
    OLD_CLOTHES(new OldClothesItem(ArmorMats.OLD_CLOTHES, EquipmentSlot.LEGS, settingsNormal())),
    OLD_CLOTHES_REPAIRED(new OldClothesItem(ArmorMats.OLD_CLOTHES_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),

    STRAW_HAT(new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settingsNormal())),
    AMETHYST_GOGGLES(new ArmorItem(ArmorMats.AMETHYST_GOGGLES, EquipmentSlot.HEAD, settingsNormal())),
    NIGHTVISION_GOGGLES(new NightGoggleItem(ArmorMats.NIGHTVISION_GOGGLES, EquipmentSlot.HEAD, settingsNormal())),
    CHEF_HAT(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.HEAD, settingsNormal())),
    CHEF_APRON(new ArmorItem(ArmorMats.CHEF, EquipmentSlot.LEGS, settingsNormal())),

    BIKINI_NEUTRAL_REPAIRED(new ArmorItem(ArmorMats.BIKINI_NEUTRAL_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_REPAIRED(new ArmorItem(ArmorMats.BIKINI_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_MASC_REPAIRED(new ArmorItem(ArmorMats.BIKINI_MASC_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),

    COWPOKE_HAT(new ArmorItem(ArmorMats.COWPOKE_HAT, EquipmentSlot.HEAD, settingsNormal())),
    FUR_BOOTS(new WarmBootItem(ArmorMats.RABBIT, EquipmentSlot.FEET, settingsNormal())),

    DIERDRA_LAUREL(new ArmorItem(ArmorMats.DIERDRA_LAUREL, EquipmentSlot.HEAD, settingsNormal())),
    FLOWER_CROWN(new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settingsNormal())),
    DRIPLEAF_HAT(new ArmorItem(ArmorMats.DRIPLEAF, EquipmentSlot.HEAD, settingsNormal())),

    CLAM_BREASTPLATE(new ArmorItem(ArmorMats.CLAM_BREASTPLATE, EquipmentSlot.CHEST, settingsNormal())),
    TURTLE_CHESTPLATE(new TurtleChestItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settingsNormal())),
    //TURTLE_BOOTS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settingsNormal())),

    HUNTERS_HAT(new ArmorItem(ArmorMats.HUNTERS_CAP, EquipmentSlot.HEAD, settingsNormal())),
    SEAGULL_FEATHER(new FastFeatherItem(ArmorMats.SEAGULL_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    DUCK_FEATHER(new FastFeatherItem(ArmorMats.DUCK_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    CROW_FEATHER(new FastFeatherItem(ArmorMats.CROW_FEATHER, EquipmentSlot.HEAD, settingsNormal())),
    FEATHER(new FastFeatherItem(ArmorMats.WHITE_FEATHER, EquipmentSlot.HEAD, settingsNormal())),

    REINFORCED_LEATHER_HELMET(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_GOLDEN_HELMET(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_IRON_HELMET(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_ROSEGOLD_HELMET(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_DIAMOND_HELMET(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_ECHOCHALCUM_HELMET(new ArmorItem(ArmorMats.RF_ECHOCHALCUM, EquipmentSlot.HEAD, settingsNormal())),
    REINFORCED_NETHERITE_HELMET(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    LEATHER_BREASTPLATE(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.CHEST, settingsNormal())),
    GOLDEN_BREASTPLATE(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_BREASTPLATE(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    IRON_BREASTPLATE(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_BREASTPLATE(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    DIAMOND_BREASTPLATE(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.CHEST, settingsNormal())),
    ECHOCHALCUM_BREASTPLATE(new ArmorItem(ArmorMats.RF_ECHOCHALCUM, EquipmentSlot.CHEST, settingsNormal())),
    NETHERITE_BREASTPLATE(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.CHEST, settingsNormal())),

    LEATHER_SANDALS(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.FEET, settingsNormal())),
    GOLDEN_SANDALS(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.FEET, settingsNormal())),
    PRIMSTEEL_SANDALS(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),
    IRON_SANDALS(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.FEET, settingsNormal())),
    ROSEGOLD_SANDALS(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),
    DIAMOND_SANDALS(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.FEET, settingsNormal())),
    ECHOCHALCUM_SANDALS(new ArmorItem(ArmorMats.RF_ECHOCHALCUM, EquipmentSlot.FEET, settingsNormal())),
    NETHERITE_SANDALS(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.FEET, settingsNormal())),

    LEATHER_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_LEATHER, EquipmentSlot.LEGS, settingsNormal())),
    GOLDEN_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_GOLD, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    IRON_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_IRON, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    DIAMOND_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_DIAMOND, EquipmentSlot.LEGS, settingsNormal())),
    ECHOCHALCUM_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_ECHOCHALCUM, EquipmentSlot.LEGS, settingsNormal())),
    NETHERITE_HAUBERK(new ArmorItem(ArmorMats.HAUBERK_NETHERITE, EquipmentSlot.LEGS, settingsNormal())),

    LEATHER_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_LEATHER, EquipmentSlot.LEGS, settingsNormal())),
    GOLDEN_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_GOLD, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    IRON_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_IRON, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    DIAMOND_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_DIAMOND, EquipmentSlot.LEGS, settingsNormal())),
    ECHOCHALCUM_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_ECHOCHALCUM, EquipmentSlot.LEGS, settingsNormal())),
    NETHERITE_THIGH_GUARDS(new ArmorItem(ArmorMats.RF_NETHERITE, EquipmentSlot.LEGS, settingsNormal())),

    //LEATHER_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_LEATHER, EquipmentSlot.HEAD, settingsNormal())),
    //GOLDEN_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_GOLD, EquipmentSlot.HEAD, settingsNormal())),
    //PRIMSTEEL_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    //IRON_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_IRON, EquipmentSlot.HEAD, settingsNormal())),
    //ROSEGOLD_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    //DIAMOND_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_DIAMOND, EquipmentSlot.HEAD, settingsNormal())),
    //NETHERITE_CIRCLET(new ArmorItem(ArmorMats.CIRCLET_NETHERITE, EquipmentSlot.HEAD, settingsNormal())),

    CANVAS_HOOD(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settingsNormal())),
    CANVAS_TUNIC(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settingsNormal())),
    CANVAS_LEGGINGS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settingsNormal())),
    CANVAS_BOOTS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settingsNormal())),

    WATTLE_HELMET(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.HEAD, settingsNormal())),
    WATTLE_CHESTPLATE(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.CHEST, settingsNormal())),
    WATTLE_LEGGINGS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.LEGS, settingsNormal())),
    WATTLE_BOOTS(new ArmorItem(ArmorMats.WATTLE, EquipmentSlot.FEET, settingsNormal())),

    LEATHER_HELMET(new ArmorItem(ArmorMats.LEATHER_MODIFIED, EquipmentSlot.HEAD, settingsNormal())),
    LEATHER_CHESTPLATE(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.CHEST, settingsNormal())),
    LEATHER_LEGGINGS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.LEGS, settingsNormal())),
    LEATHER_BOOTS(new ArmorItem(ArmorMats.LEATHER_NO_OVERLAY, EquipmentSlot.FEET, settingsNormal())),

    PRIMSTEEL_HELMET(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.HEAD, settingsNormal())),
    PRIMSTEEL_CHESTPLATE(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.CHEST, settingsNormal())),
    PRIMSTEEL_LEGGINGS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.LEGS, settingsNormal())),
    PRIMSTEEL_BOOTS(new ArmorItem(ArmorMats.PRIMSTEEL, EquipmentSlot.FEET, settingsNormal())),

    ROSEGOLD_HELMET(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.HEAD, settingsNormal())),
    ROSEGOLD_CHESTPLATE(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.CHEST, settingsNormal())),
    ROSEGOLD_LEGGINGS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.LEGS, settingsNormal())),
    ROSEGOLD_BOOTS(new ArmorItem(ArmorMats.ROSEGOLD, EquipmentSlot.FEET, settingsNormal())),

    ECHOCHALCUM_HELMET(new ArmorItem(ArmorMats.ECHOCHALCUM, EquipmentSlot.HEAD, settingsNormal())),
    ECHOCHALCUM_CHESTPLATE(new ArmorItem(ArmorMats.ECHOCHALCUM, EquipmentSlot.CHEST, settingsNormal())),
    ECHOCHALCUM_LEGGINGS(new ArmorItem(ArmorMats.ECHOCHALCUM, EquipmentSlot.LEGS, settingsNormal())),
    ECHOCHALCUM_BOOTS(new ArmorItem(ArmorMats.ECHOCHALCUM, EquipmentSlot.FEET, settingsNormal())),

    LICH_HOOD_KEEPSAKE(new ArmorItem(ArmorMats.LICH_CLOAK, EquipmentSlot.HEAD, settingsNormal().rarity(EPIC).maxCount(1))),
    LICH_CLOAK_KEEPSAKE(new ArmorItem(ArmorMats.LICH_CLOAK, EquipmentSlot.CHEST, settingsNormal().rarity(EPIC).maxCount(1)));

    //DIVING_HELMET(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.HEAD, settingsArtifacts(Rarity.RARE))),
    //DIVING_CHESTPLATE(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.CHEST, settingsArtifacts(Rarity.RARE))),
    //DIVING_LEGGINGS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    //DIVING_BOOTS(new ArmorItem(ArmorMats.DIVING, EquipmentSlot.FEET, settingsArtifacts(Rarity.RARE))),

    /** Called from {@link ItemsModded} */
    public static void initialize() {
        Baubles.initialize();
    }

    private static final Item.Settings settingsArtifacts() {
        return new Item.Settings().group(Groups.VC_TOOLS);
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

    // ### The Enum Class Itself ###

    public final Item item;
    public final Identifier id;

    Armors(Item item) {
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
