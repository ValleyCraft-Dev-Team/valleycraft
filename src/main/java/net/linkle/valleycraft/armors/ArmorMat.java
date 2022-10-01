package net.linkle.valleycraft.armors;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

/** Mod Armor Material */
public final class ArmorMat implements ArmorMaterial {
    
    static final int[] BASE_DURABILITY = {13, 15, 16, 11};

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;
    private final float toughness;
    private final float knockbackResistance;
    
    public ArmorMat(String name, int[] prtAmts, int durMul, int ench, SoundEvent sound, Ingredient repair) {
        this(name, prtAmts, durMul, ench, sound, repair, 0, 0);
    }
    
    public ArmorMat(String name, int[] prtAmts, int durMul, int ench, SoundEvent sound, Ingredient repair, float tough, float knockback) {
        this.name = name;
        this.durabilityMultiplier = durMul;
        this.protectionAmounts = prtAmts;
        this.enchantability = ench;
        this.equipSound = sound;
        this.repairIngredient = repair;
        this.toughness = tough;
        this.knockbackResistance = knockback;
    }
    
    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
