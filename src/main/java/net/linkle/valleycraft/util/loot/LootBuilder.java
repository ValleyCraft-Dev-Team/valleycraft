package net.linkle.valleycraft.util.loot;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

/** Loot Pool Builder helper class. */
public class LootBuilder {
    private final LootPool.Builder pool = new LootPool.Builder();
    private final FabricLootPoolBuilder poolExt = (FabricLootPoolBuilder)pool;

    public LootBuilder rolls(LootNumberProvider range) {
        pool.rolls(range);
        return this;
    }

    public LootBuilder rolls(float value) {
        pool.rolls(ConstantLootNumberProvider.create(value));
        return this;
    }

    public LootBuilder rolls(float min, float max) {
        pool.rolls(UniformLootNumberProvider.create(min, max));
        return this;
    }
    
    public LootBuilder bonusRolls(LootNumberProvider bonusRolls) {
        pool.bonusRolls(bonusRolls);
        return this;
    }

    public LootBuilder with(LootPoolEntry.Builder<?> entry) {
        pool.with(entry);
        return this;
    }

    public LootBuilder with(ItemConvertible item) {
        pool.with(ItemEntry.builder(item));
        return this;
    }

    public LootBuilder conditionally(LootCondition.Builder condition) {
        pool.conditionally(condition);
        return this;
    }

    public LootBuilder apply(LootFunction.Builder function) {
        pool.apply(function);
        return this;
    }

    public LootBuilder with(LootPoolEntry entry) {
        poolExt.with(entry);
        return this;
    }

    public LootBuilder conditionally(LootCondition condition) {
        poolExt.conditionally(condition);
        return this;
    }

    public LootBuilder apply(LootFunction function) {
        poolExt.apply(function);
        return this;
    }

    public LootPool.Builder build() {
        return pool;
    }

    public static LootBuilder create() {
        return new LootBuilder();
    }
}
