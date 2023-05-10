package net.linkle.valleycraft.util.loot;

import java.util.Collection;
import java.util.function.Function;

import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.LootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

/** A extended Loot Pool Builder with extra features. */
public class LootBuilder extends LootPool.Builder {

    @Override
    public <E> LootBuilder apply(Iterable<E> functions,
            Function<E, net.minecraft.loot.function.LootFunction.Builder> toBuilderFunction) {
        super.apply(functions, toBuilderFunction);
        return this;
    }

    @Override
    public <E> LootBuilder apply(E[] functions,
            Function<E, net.minecraft.loot.function.LootFunction.Builder> toBuilderFunction) {
        super.apply(functions, toBuilderFunction);
        return this;
    }

    @Override
    public <E> LootBuilder conditionally(Iterable<E> conditions,
            Function<E, net.minecraft.loot.condition.LootCondition.Builder> toBuilderFunction) {
        super.conditionally(conditions, toBuilderFunction);
        return this;
    }

    @Override
    public LootBuilder getThisConditionConsumingBuilder() {
        return this;
    }

    @Override
    public LootBuilder with(LootPoolEntry entry) {
        super.with(entry);
        return this;
    }

    @Override
    public LootBuilder with(Collection<? extends LootPoolEntry> entries) {
        super.with(entries);
        return this;
    }

    @Override
    public LootBuilder conditionally(LootCondition condition) {
        super.conditionally(condition);
        return this;
    }

    @Override
    public LootBuilder conditionally(Collection<? extends LootCondition> conditions) {
        super.conditionally(conditions);
        return this;
    }

    @Override
    public LootBuilder apply(LootFunction function) {
        super.apply(function);
        return this;
    }

    @Override
    public LootBuilder apply(Collection<? extends LootFunction> functions) {
        super.apply(functions);
        return this;
    }

    @Override
    public LootBuilder bonusRolls(LootNumberProvider bonusRolls) {
        super.bonusRolls(bonusRolls);
        return this;
    }

    @Override
    public LootBuilder with(net.minecraft.loot.entry.LootPoolEntry.Builder<?> entry) {
        super.with(entry);
        return this;
    }

    @Override
    public LootBuilder getThisFunctionConsumingBuilder() {
        super.getThisFunctionConsumingBuilder();
        return this;
    }

    @Override
    public LootBuilder apply(net.minecraft.loot.function.LootFunction.Builder function) {
        super.apply(function);
        return this;
    }

    @Override
    public LootBuilder conditionally(net.minecraft.loot.condition.LootCondition.Builder condition) {
        super.conditionally(condition);
        return this;
    }

    @Override
    public LootBuilder rolls(LootNumberProvider range) {
        rolls(range);
        return this;
    }

    public LootBuilder rolls(float value) {
        rolls(ConstantLootNumberProvider.create(value));
        return this;
    }

    public LootBuilder rolls(float min, float max) {
        rolls(UniformLootNumberProvider.create(min, max));
        return this;
    }

    public LootBuilder with(ItemConvertible item) {
        with(ItemEntry.builder(item));
        return this;
    }

    public static LootBuilder create() {
        return new LootBuilder();
    }
}
