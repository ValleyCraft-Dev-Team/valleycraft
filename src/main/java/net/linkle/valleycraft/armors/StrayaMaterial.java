package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.minecraft.item.Items.LEATHER;

public class StrayaMaterial implements ArmorMaterial {
    public static final ArmorMaterial STRAYA = new StrayaMaterial();

    static final int[] PROTECTION_VALUES = {1, 5, 6, 2};

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
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(LEATHER);
    }

    @Override
    public String getName() {
        return "cartographers_bag";
    }

}
