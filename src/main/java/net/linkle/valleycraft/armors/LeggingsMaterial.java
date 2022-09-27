package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.item.Items.LEATHER;

public class LeggingsMaterial implements ArmorMaterial {
    public static final ArmorMaterial INSTANCE = new LeggingsMaterial();

    static final int[] PROTECTION_VALUES = {1, 2, 2, 2};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return getDurability(slot, 30);
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
        return Ingredient.ofItems(LEATHER);
    }

    @Override
    public String getName() {
        return "leggings";
    }

}
