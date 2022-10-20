package net.linkle.valleycraft.block.sapling;

import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class AmberSaplingGen extends LargeTreeSaplingGenerator {

    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
        return TreeConfigs.AMBER_TREE.getEntry();
    }

    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random var1, boolean var2) {
        return null;
    }
    
}
