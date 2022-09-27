package net.linkle.valleycraft.armors;

import net.linkle.valleycraft.init.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CanvasMaterial implements ArmorMaterial {
    public static final ArmorMaterial INSTANCE = new CanvasMaterial();

    static final int[] PROTECTION_VALUES = {1, 1, 2, 1};

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
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.COVER);
    }

    @Override
    public String getName() {
        return "canvas";
    }

}
