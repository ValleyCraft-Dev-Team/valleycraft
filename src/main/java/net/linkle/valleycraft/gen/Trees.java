package net.linkle.valleycraft.gen;

import java.util.OptionalInt;

import com.google.common.collect.ImmutableList;

import net.linkle.valleycraft.init.NaturalBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.ThreeLayersFeatureSize;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

/** see {@link TreeConfiguredFeatures} for vanilla trees */
public class Trees {
    
    public static TreeFeatureConfig appleTree() {
        var dataPool = new DataPool.Builder<BlockState>();
        dataPool.add(NaturalBlocks.APPLE_LEAVES_EMPTY.getState(), 4);
        dataPool.add(NaturalBlocks.APPLE_LEAVES.getState(), 1);
        var foliageProvider = new WeightedBlockStateProvider(dataPool);
        var trunkProvider = BlockStateProvider.of(NaturalBlocks.APPLE_LOG.getState());
        var foliagePlacer = new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4);
        var trunkPlacer = new LargeOakTrunkPlacer(5, 9, 0);
        var minimumSize = new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4));
        var builder = new TreeFeatureConfig.Builder(foliageProvider, trunkPlacer, trunkProvider, foliagePlacer, minimumSize);
        return builder.ignoreVines().build();
    }

    /** AKA The Mamon. */
    public static TreeFeatureConfig amberTree() {
        var foliageProvider = BlockStateProvider.of(NaturalBlocks.MAMON_LEAVES.getState());
        var trunkProvider = BlockStateProvider.of(NaturalBlocks.MAMON_LOG.getState());
        var foliagePlacer = new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
        var trunkPlacer = new DarkOakTrunkPlacer(9, 3, 1);
        var minimumSize = new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty());
        var builder = new TreeFeatureConfig.Builder(trunkProvider, trunkPlacer, foliageProvider, foliagePlacer, minimumSize);
        return builder.decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).ignoreVines().build();
    }
}
