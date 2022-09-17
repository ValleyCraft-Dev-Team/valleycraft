package net.linkle.valleycraft.gen.features;

import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.block.BlockState;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class TreeConfigFeatures {

    public static final RegistryEntry<ConfiguredFeature<?, ?>> APPLE_TREE = 
    Reg.register("apple_tree", Feature.TREE,
        new TreeFeatureConfig.Builder(
        BlockStateProvider.of(ModBlocks.APPLE_LOG), 
        new StraightTrunkPlacer(4, 2, 0), 
        new WeightedBlockStateProvider(new DataPool.Builder<BlockState>().add(ModBlocks.APPLE_LEAVES.getDefaultState(), 1).add(ModBlocks.APPLE_LEAVES_EMPTY.getDefaultState(), 5)), 
        new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3), 
        new TwoLayersFeatureSize(1, 0, 1)).build()
    );

    public static void initialize() {
    }
}
