package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.DyeableArmorItem;

public class ModDyeableArmorItem extends DyeableArmorItem implements ModDyeableItem {
    public ModDyeableArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }
}
