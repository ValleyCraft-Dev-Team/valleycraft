package net.linkle.valleycraft.tool;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {

    PRIMSTEEL(2, 190, 5.0F, 1.5F, 18, () -> {
        return Ingredient.ofItems(ModItems.PRIMSTEEL_INGOT);
    }),
    ROSEGOLD(1, 440, 7.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(ModItems.ROSEGOLD_INGOT);
    }),

    COPPER(1, 250, 6.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(Items.COPPER_INGOT);
    }),

    GOLEMITE(2, 705, 8.0F, 2.5F, 5, () -> {
        return Ingredient.ofItems(ModItems.GOLEMITE_INGOT);
    }),

    METEORITE(2, 440, 7.0F, 2.0F, 18, () -> {
        return Ingredient.ofItems(ModNaturalBlocks.METEORITE);
    }),

    PRISMARINE(2, 190, 5.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(Items.PRISMARINE_SHARD);
    }),

    BROKEN(2, 195, 5.0F, 2.0F, 10, () -> {
        return Ingredient.ofItems(Items.IRON_INGOT);
    }),

    BRASIUM(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(ModItems.BRASIUM_INGOT);
    }),

    //unique - only used once
    NATURES_BLESSING(2, 440, 7.0F, 2.0F, 22, () -> {
        return Ingredient.ofItems(Items.BAMBOO);
    }),

    BAMBOO(2, 220, 7.0F, 1.0F, 15, () -> {
        return Ingredient.ofItems(Items.BAMBOO);
    }),

    PLANK(2, 220, 7.0F, 1.0F, 15, () -> {
        return Ingredient.ofItems(ModItems.PLANK);
    }),

    OBSIDIAN(2, 440, 7.0F, 2.0F, 18, () -> {
        return Ingredient.ofItems(ModItems.OBSIDIAN_CHUNK);
    }),

    AMETHYST(2, 190, 5.0F, 1.5F, 18, () -> {
        return Ingredient.ofItems(Items.AMETHYST_SHARD);
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
