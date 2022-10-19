package net.linkle.valleycraft.gen.features;

import net.linkle.valleycraft.gen.Trees;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

public class TreeConfigFeatures {

    public static final RegistryEntry<ConfiguredFeature<?, ?>> APPLE_TREE = Reg.register("apple_tree", Feature.TREE, Trees.appleTree());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> WARM_BIRCH_TREE = Reg.register("warm_birch_tree", Feature.TREE, Trees.warmBirchTree());

    public static void initialize() {
        //TreeFeatureConfig
    }
}
