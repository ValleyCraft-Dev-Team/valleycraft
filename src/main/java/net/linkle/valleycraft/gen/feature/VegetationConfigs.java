package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

/** Known as {@link VegetationConfiguredFeatures} */
public enum VegetationConfigs implements ConfigFeature {
    
    PATCH_PUMPKIN(Feature.RANDOM_PATCH, cratePatch(50, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, simpleBlock(Blocks.PUMPKIN), BlockPredicate.bothOf(BlockPredicate.replaceable(), BlockPredicate.matchingBlockTag(Direction.DOWN.getVector(), BlockTags.DIRT)))));

    
    public static void initialize() {}
    
    // Utilities
    
    private static RandomPatchFeatureConfig cratePatch(int tries, RegistryEntry<PlacedFeature> entry) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, entry);
    }
    
    private static SimpleBlockFeatureConfig simpleBlock(Block block) {
        return simpleBlock(block.getDefaultState());
    }
    
    private static SimpleBlockFeatureConfig simpleBlock(BlockState state) {
        return new SimpleBlockFeatureConfig(BlockStateProvider.of(state));
    }
    
    // Enum
    
    public final ConfiguredFeature<?, ?> config;
    public final RegistryEntry<ConfiguredFeature<?, ?>> entry;

    <T extends FeatureConfig> VegetationConfigs(Feature<T> feature, T config) {
        this.config = new ConfiguredFeature<T, Feature<T>>(feature, config);
        entry = Reg.add(BuiltinRegistries.CONFIGURED_FEATURE, name().toLowerCase(), this.config);
    }

    @Override
    public ConfiguredFeature<?, ?> getConfig() {
        return config;
    }

    @Override
    public RegistryEntry<ConfiguredFeature<?, ?>> getEntry() {
        return entry;
    }
}
