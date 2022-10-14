package net.linkle.valleycraft.tool;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.linkle.valleycraft.init.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {

    PRIMSTEEL(2, 190, 5.0F, 1.5F, 18, () -> {
        return Ingredient.ofItems(ModItems.PRIMSTEEL_INGOT);
    }),
    ROSEGOLD(1, 440, 7.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(ModItems.ROSEGOLD);
    }),
    GOLEMITE(2, 705, 8.0F, 2.5F, 5, () -> {
        return Ingredient.ofItems(ModItems.GOLEMITE_INGOT);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
