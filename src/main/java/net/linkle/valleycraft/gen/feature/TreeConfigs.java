package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.gen.Trees;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

/** Known as {@link TreeConfiguredFeatures} */
public enum TreeConfigs implements ConfigFeature {

    APPLE_TREE(Trees.appleTree()),
    AMBER_TREE(Trees.amberTree()),
    WARM_BIRCH_TREE(Trees.warmBirchTree());

    
    public static void initialize() {
        
    }
    
    
    
    // ### The Enum Class Itself ###
    
    public final ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>> config;
    public final RegistryEntry<ConfiguredFeature<?, ?>> entry;
    
    TreeConfigs(TreeFeatureConfig config) {
        this.config = new ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>>(Feature.TREE, config);
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
