package net.linkle.valleycraft.init;

import net.linkle.valleycraft.armors.*;
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
    
    MOBLIN_TALISMAN(new ArmorItem(ArmorMats.MOBLIN_TALISMAN, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    MOGARS_BROKEN_GOLEMITE_GOGGLES(new BrokenArmorItem(ArmorMats.MOGARS_BROKEN, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    MOGARS_FIXED_GOLEMITE_GOGGLES(new ArmorItem(ArmorMats.MOGARS_FIXED, EquipmentSlot.HEAD, settingsArtifacts(Rarity.EPIC))),
    STRAYAS_CARTOGRAPHY_BAG(new ArmorItem(ArmorMats.STRAYA, EquipmentSlot.CHEST, settingsArtifacts(Rarity.EPIC))),
    ALCHEMISTS_LEGGINGS(new ArmorItem(ArmorMats.LEGGINGS, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    LIBRARIANS_HAT(new ArmorItem(ArmorMats.LIBRARIAN, EquipmentSlot.HEAD, settingsArtifacts())),
    SNOW_CAP(new ArmorItem(ArmorMats.SNOW_CAP, EquipmentSlot.HEAD, settingsArtifacts())),
    STABLEHAND_HAT(new ArmorItem(ArmorMats.STABLEHAND_HAT, EquipmentSlot.HEAD, settingsArtifacts())),
    VILLAGER_TUNIC(new ArmorItem(ArmorMats.VILLAGER, EquipmentSlot.LEGS, settingsArtifacts())),
    EMERALD_TALISMAN(new ArmorItem(ArmorMats.EMERALD_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.UNCOMMON))),
    AMETHYST_TALISMAN(new ArmorItem(ArmorMats.AMETHYST_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.UNCOMMON))),
    ECHO_SHARD_TALISMAN(new ArmorItem(ArmorMats.ECHO_TALISMAN, EquipmentSlot.CHEST, settingsNormal(Rarity.EPIC))),
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

    DROWNED_CLOTHES(new BrokenArmorItem(ArmorMats.DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
    REPAIRED_DROWNED_CLOTHES(new ArmorItem(ArmorMats.REPAIRED_DROWNED, EquipmentSlot.LEGS, settingsArtifacts(Rarity.RARE))),
    HUSK_SHIRT(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.CHEST, settingsArtifacts(Rarity.UNCOMMON))),
    HUSK_PANTS(new BrokenArmorItem(ArmorMats.HUSK, EquipmentSlot.LEGS, settingsArtifacts(Rarity.UNCOMMON))),
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

    STRAW_HAT(new ArmorItem(ArmorMats.STRAW_HAT, EquipmentSlot.HEAD, settingsNormal())),

    FLOWER_CROWN(new ArmorItem(ArmorMats.FLOWERING_HAT, EquipmentSlot.HEAD, settingsNormal())),
    
    REINFORCED_IRON_HELMET(new ArmorItem(ArmorMats.SCALE, EquipmentSlot.HEAD, settingsArtifacts(Rarity.UNCOMMON))),
    FUR_BOOTS(new ArmorItem(ArmorMats.FUR, EquipmentSlot.FEET, settingsNormal(Rarity.UNCOMMON))),
    
    CANVAS_HOOD(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.HEAD, settingsNormal())),
    CANVAS_TUNIC(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.CHEST, settingsNormal())),
    CANVAS_LEGGINGS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.LEGS, settingsNormal())),
    CANVAS_BOOTS(new ArmorItem(ArmorMats.CANVAS, EquipmentSlot.FEET, settingsNormal())),

    BIKINI_MASC(new ArmorItem(ArmorMats.BIKINI_MASC, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI(new ArmorItem(ArmorMats.BIKINI, EquipmentSlot.LEGS, settingsArtifacts())),
    BIKINI_COAT(new ArmorItem(ArmorMats.BIKINI_COAT, EquipmentSlot.CHEST, settingsNormal())),
    BIKINI_MASC_REPAIRED(new ArmorItem(ArmorMats.BIKINI_MASC_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),
    BIKINI_REPAIRED(new ArmorItem(ArmorMats.BIKINI_REPAIRED, EquipmentSlot.LEGS, settingsNormal())),

    TURTLE_CHESTPLATE(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.CHEST, settingsNormal())),
    TURTLE_LEGGINGS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.LEGS, settingsNormal())),
    TURTLE_BOOTS(new ArmorItem(ArmorMaterials.TURTLE, EquipmentSlot.FEET, settingsNormal())),

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
    GOLEMITE_BOOTS(new ArmorItem(ArmorMats.GOLEMITE, EquipmentSlot.FEET, settingsNormal()));

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
