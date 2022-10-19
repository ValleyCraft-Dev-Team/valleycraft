package net.linkle.valleycraft.block.sapling;

import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class WarmBirchSaplingGen extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return TreeConfigs.WARM_BIRCH_TREE.entry;
    }
}
