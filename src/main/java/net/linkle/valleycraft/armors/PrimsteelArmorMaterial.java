package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.linkle.valleycraft.init.ModItems.BEAST_BONE;

public class PrimsteelArmorMaterial implements ArmorMaterial {
    public static final ArmorMaterial INSTANCE = new PrimsteelArmorMaterial();

    static final int[] PROTECTION_VALUES = {1, 3, 5, 2};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return getDurability(slot, 15);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BEAST_BONE);
    }

    @Override
    public String getName() {
        return "moblin";
    }
}
