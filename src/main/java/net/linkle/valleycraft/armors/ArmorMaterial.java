package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;

interface ArmorMaterial extends net.minecraft.item.ArmorMaterial {
    int[] BASE_DURABILITY = {13, 15, 16, 11};

    @Override
    default float getToughness() {
        return 0;
    }

    @Override
    default float getKnockbackResistance() {
        return 0;
    }

    default int getDurability(EquipmentSlot slot, int multiplier) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * multiplier;
    }
}
