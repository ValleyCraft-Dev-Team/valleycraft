package net.linkle.valleycraft.gen.features;

import java.util.OptionalInt;

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
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

public class TreeConfigFeatures {

    public static final RegistryEntry<ConfiguredFeature<?, ?>> APPLE_TREE = 
    Reg.register("apple_tree", Feature.TREE,
            new TreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.APPLE_LOG),
            new LargeOakTrunkPlacer(5, 9, 0), 
            new WeightedBlockStateProvider(new DataPool.Builder<BlockState>()
                .add(ModBlocks.APPLE_LEAVES_EMPTY.getDefaultState(), 4)
                .add(ModBlocks.APPLE_LEAVES.getDefaultState(), 1)), 
            new LargeOakFoliagePlacer(ConstantIntProvider.create(2), 
            ConstantIntProvider.create(4), 4),
            new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

    public static void initialize() {
        //TreeFeatureConfig
    }
}
