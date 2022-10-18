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
public enum TreeConfigs {

    APPLE_TREE(Trees.appleTree()),
    AMBER_TREE(Trees.amberTree());

    
    public static void initialize() {
        //TreePlaced.initialize();
    }
    
    
    
    // ### The Enum Class Itself ###
    
    public final ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>> config;
    public final RegistryEntry<ConfiguredFeature<?, ?>> key;
    
    TreeConfigs(TreeFeatureConfig config) {
        var configured = new ConfiguredFeature<TreeFeatureConfig, Feature<TreeFeatureConfig>>(Feature.TREE, config);
        this.config = configured;
        key = Reg.add(BuiltinRegistries.CONFIGURED_FEATURE, name().toLowerCase(), configured);
    }
}
