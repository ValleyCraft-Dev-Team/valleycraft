package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class MogarsFixedMaterial implements ArmorMaterial {
    public static final ArmorMaterial INSTANCE = new MogarsFixedMaterial();

    static final int[] PROTECTION_VALUES = {2, 5, 6, 2};

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
        return Ingredient.ofItems();
    }

    @Override
    public String getName() {
        return "mogars_fixed_golemite_goggles";
    }

}
