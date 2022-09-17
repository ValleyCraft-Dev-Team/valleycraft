package net.linkle.valleycraft.block.sapling;

import java.util.Random;

import net.linkle.valleycraft.gen.features.TreeConfigFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class AppleSaplingGen extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return TreeConfigFeatures.APPLE_TREE;
    }
}
