package net.linkle.valleycraft.gen;

import java.util.OptionalInt;

import com.google.common.collect.ImmutableList;

import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.linkle.valleycraft.init.ModNaturalBlocks;
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

/** <p> See {@link TreeConfiguredFeatures} for vanilla trees </p>
 *  <p> Tree registering is at {@link TreeConfigs} </p> */
public class Trees {
    
    public static TreeFeatureConfig appleTree() {
        var dataPool = new DataPool.Builder<BlockState>();
        dataPool.add(ModNaturalBlocks.APPLE_LEAVES_EMPTY.getState(), 4);
        dataPool.add(ModNaturalBlocks.APPLE_LEAVES.getState(), 1);
        var foliageProvider = new WeightedBlockStateProvider(dataPool);
        var trunkProvider = BlockStateProvider.of(ModNaturalBlocks.APPLE_LOG.getState());
        var foliagePlacer = new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4);
        var trunkPlacer = new LargeOakTrunkPlacer(5, 9, 0);
        var minimumSize = new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4));
        var builder = new TreeFeatureConfig.Builder(trunkProvider, trunkPlacer, foliageProvider, foliagePlacer, minimumSize);
        return builder.ignoreVines().build();
    }

    public static TreeFeatureConfig warmBirchTree() {
        var foliageProvider = BlockStateProvider.of(ModNaturalBlocks.WARM_BIRCH_LEAVES.getState());
        var trunkProvider = BlockStateProvider.of(Blocks.BIRCH_LOG.getDefaultState());
        var foliagePlacer = new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4);
        var trunkPlacer = new LargeOakTrunkPlacer(5, 9, 0);
        var minimumSize = new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4));
        var builder = new TreeFeatureConfig.Builder(trunkProvider, trunkPlacer, foliageProvider, foliagePlacer, minimumSize);
        return builder.ignoreVines().build();
    }

    public static TreeFeatureConfig celestialTree() {
        var foliageProvider = BlockStateProvider.of(ModNaturalBlocks.CELESTIAL_LEAVES.getState());
        var trunkProvider = BlockStateProvider.of(ModNaturalBlocks.CELESTIAL_LOG.getState());
        var foliagePlacer = new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4);
        var trunkPlacer = new LargeOakTrunkPlacer(5, 15, 0);
        var minimumSize = new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4));
        var builder = new TreeFeatureConfig.Builder(trunkProvider, trunkPlacer, foliageProvider, foliagePlacer, minimumSize);
        return builder.ignoreVines().build();
    }
    
    /** AKA The Mamon. */
    public static TreeFeatureConfig amberTree() {
        var foliageProvider = BlockStateProvider.of(ModNaturalBlocks.MAMON_LEAVES.getState());
        var trunkProvider = BlockStateProvider.of(ModNaturalBlocks.MAMON_LOG.getState());
        var foliagePlacer = new DarkOakFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0));
        var trunkPlacer = new DarkOakTrunkPlacer(9, 3, 1);
        var minimumSize = new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty());
        var builder = new TreeFeatureConfig.Builder(trunkProvider, trunkPlacer, foliageProvider, foliagePlacer, minimumSize);
        return builder.decorators(ImmutableList.of(new AlterGroundTreeDecorator(BlockStateProvider.of(Blocks.PODZOL)))).ignoreVines().build();
    }
}
