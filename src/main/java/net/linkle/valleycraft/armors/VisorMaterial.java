package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.item.Items.COPPER_INGOT;
import static net.minecraft.item.Items.LEATHER;

public class VisorMaterial implements ArmorMaterial {
    public static final ArmorMaterial INSTANCE = new VisorMaterial();

    static final int[] PROTECTION_VALUES = {3, 3, 3, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return getDurability(slot, 10);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(COPPER_INGOT);
    }

    @Override
    public String getName() {
        return "visor";
    }

}
