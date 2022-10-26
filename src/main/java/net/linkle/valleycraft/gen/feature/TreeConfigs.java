package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.gen.Trees;
import net.minecraft.util.Identifier;
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
    WARM_BIRCH_TREE(Trees.warmBirchTree()),
    CELESTIAL_TREE(Trees.celestialTree());

    
    public static void initialize() {
        
    }
    
    
    
    // ### The Enum Class Itself ###
    
    public final ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>> config;
    
    private final RegistryEntry<ConfiguredFeature<?, ?>> entry;
    private final Identifier id;
    
    TreeConfigs(TreeFeatureConfig config) {
        this.config = new ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>>(Feature.TREE, config);
        entry = BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, id = Main.makeId(name().toLowerCase()), this.config);
    }

    @Override
    public ConfiguredFeature<?, ?> getConfig() {
        return config;
    }

    @Override
    public RegistryEntry<ConfiguredFeature<?, ?>> getEntry() {
        return entry;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
