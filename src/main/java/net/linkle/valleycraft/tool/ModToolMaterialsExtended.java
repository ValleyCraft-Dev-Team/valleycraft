package net.linkle.valleycraft.tool;

import net.linkle.valleycraft.init.ItemsModded;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterialsExtended implements ToolMaterial {

    PRIMSTEEL_EXTENDED(2, 285, 5.0F, 1.5F, 18, () -> {
        return Ingredient.ofItems(ItemsModded.PRIMSTEEL_INGOT);
    }),
    ROSEGOLD_EXTENDED(1, 660, 7.0F, 2.0F, 15, () -> {
        return Ingredient.ofItems(ItemsModded.ROSEGOLD_INGOT);
    }),
    //GOLEMITE_EXTENDED (2, 1057, 8.0F, 2.5F, 5, () -> {
    //    return Ingredient.ofItems(ModItems.GOLEMITE_INGOT);
    //}),
    WOOD_EXTENDED(0, 89, 2.0F, 0.0F, 15, () -> {
        return Ingredient.fromTag(ItemTags.PLANKS);
    }),
    STONE_EXTENDED(1, 197, 4.0F, 1.0F, 5, () -> {
        return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
    }),
    BONE_EXTENDED(1, 197, 4.0F, 1.0F, 5, () -> {
        return Ingredient.ofItems(Items.BONE);
    }),
    IRON_EXTENDED(2, 375, 6.0F, 2.0F, 14, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.IRON_INGOT});
    }),
    DIAMOND_EXTENDED(3, 2342, 8.0F, 3.0F, 10, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.DIAMOND});
    }),
    GOLD_EXTENDED(0, 48, 12.0F, 0.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_INGOT});
    }),
    ECHOCHALCUM_EXTENDED(4, 3047, 9.0F, 4.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{ItemsModded.ECHOCHALCUM_INGOT});
    }),
    NETHERITE_EXTENDED(4, 3047, 9.0F, 4.0F, 15, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.NETHERITE_INGOT});
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterialsExtended(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
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
        return (Ingredient)this.repairIngredient.get();
    }
}
