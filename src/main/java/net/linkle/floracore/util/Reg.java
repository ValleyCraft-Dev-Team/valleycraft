package net.linkle.floracore.util;

import static net.linkle.floracore.Main.makeId;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class Reg {
    /**
     * Register the item.
     * 
     * @param id for the item.
     * @param item to register.
     * @return item
     */
    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, makeId(id), item);
    }

    /**
     * Register the block.
     * 
     * @param id for the block.
     * @param block to register.
     * @return block
     */
    public static Block register(String id, Block block) {
        return Registry.register(Registry.BLOCK, makeId(id), block);
    }

    /**
     * Register the block with item.
     * 
     * @param id for the block and the item.
     * @param block to register.
     * @param settings for the item.
     */
    public static void registerWithItem(String id, Block block, Item.Settings settings) {
        var identifier = makeId(id);
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, settings));
    }

    public static <C extends FeatureConfig> Feature<C> register(String id, Feature<C> feature) {
        return Registry.register(Registry.FEATURE, makeId(id), feature);
    }

    public static <T> RegistryEntry<T> add(Registry<T> registry, String id, T value) {
        return BuiltinRegistries.add(registry, makeId(id), value);
    }

    public static RegistryEntry<PlacedFeature> register(String id,
            RegistryEntry<? extends ConfiguredFeature<?, ?>> entry, List<PlacementModifier> modifiers) {
        return add(BuiltinRegistries.PLACED_FEATURE, id, new PlacedFeature(RegistryEntry.upcast(entry), modifiers));
    }

    public static RegistryEntry<PlacedFeature> register(String id, ConfiguredFeature<?, ?> config,
            List<PlacementModifier> modifiers) {
        var identifier = makeId(id);
        var entry = BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, identifier, config);
        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, identifier,
                new PlacedFeature(RegistryEntry.upcast(entry), modifiers));
    }

    public static RegistryEntry<PlacedFeature> register(String id, ConfiguredFeature<?, ?> config,
            PlacementModifier... modifiers) {
        return register(id, config, List.of(modifiers));
    }

    public static RegistryEntry<PlacedFeature> register(String id,
            RegistryEntry<? extends ConfiguredFeature<?, ?>> entry, PlacementModifier... modifiers) {
        return register(id, entry, List.of(modifiers));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<?, ?>> register(
            String id, F feature, FC config) {
        return add(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<FC, F>(feature, config));
    }
}