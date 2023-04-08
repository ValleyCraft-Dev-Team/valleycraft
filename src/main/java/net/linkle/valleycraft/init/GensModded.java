package net.linkle.valleycraft.init;

import java.util.List;
import java.util.stream.Stream;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.linkle.valleycraft.enums.BlockEnum;
import net.linkle.valleycraft.util.MoreBiomeSelectors;
import net.linkle.valleycraft.util.Reg;
import net.minecraft.block.BlockState;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;

public class GensModded {

	public static void initialize() {
		RegistryEntry<PlacedFeature> placed;
        RegistryEntry<ConfiguredFeature<?, ?>> config;
        List<PlacementModifier> list;
        var vegetal = GenerationStep.Feature.VEGETAL_DECORATION;
        
        placed = registerPlant(createConfig("black_dahlia", 60, BlocksNatural.BLACK_DAHLIA), 20);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("flowering_cactus", 60, BlocksNatural.FLOWERING_CACTUS), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.tag(ConventionalBiomeTags.DESERT), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("tumbleweed", 60, BlocksNatural.TUMBLEWEED), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.includeByTag(ConventionalBiomeTags.DESERT, ConventionalBiomeTags.BADLANDS), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("thorny_bush", 60, BlocksNatural.THORNY_BUSH), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.tag(ConventionalBiomeTags.BADLANDS), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("fluffy_dandelion", 60, BlocksNatural.FLUFFY_DANDELION), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.includeByTag(ConventionalBiomeTags.FOREST, ConventionalBiomeTags.PLAINS), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("foxtail_fern", 60, BlocksNatural.FOXTAIL_FERN), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.includeByTag(ConventionalBiomeTags.TAIGA), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("jungle_bush", 60, BlocksNatural.JUNGLE_BUSH), 20);
        BiomeModifications.addFeature(MoreBiomeSelectors.includeByTag(ConventionalBiomeTags.JUNGLE), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("panflowers", 60, BlocksNatural.PANFLOWERS), 20);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("clover", 60, BlocksNatural.CLOVER), 20);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("honeycluster", 60, BlocksNatural.HONEYCLUSTER), 20);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW), vegetal, placed.getKey().get());
        
        placed = registerPlant(createConfig("lavender", 60, BlocksNatural.LAVENDER, BlocksNatural.TALL_LAVENDER), 20);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST, BiomeKeys.MANGROVE_SWAMP), vegetal, placed.getKey().get());
	}
	
	/** Create a random patch feature config. */
    public static RegistryEntry<ConfiguredFeature<?, ?>> createConfig(String id, int tries, BlockEnum... blocks) {
        return createConfig(id, tries, Stream.of(blocks).map(BlockEnum::getState).toArray(BlockState[]::new));
    }
    
    /** Create a random patch feature config. */
    public static RegistryEntry<ConfiguredFeature<?, ?>> createConfig(String id, int tries, BlockState... blocks) {
        SimpleBlockFeatureConfig config;
        if (blocks.length > 1) {
            var data = new DataPool.Builder<BlockState>();
            for (var block : blocks) {
                data.add(block, 1);
            }
            config = new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(data));
        } else {
            config = new SimpleBlockFeatureConfig(BlockStateProvider.of(blocks[0]));
        }
        var entry = PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, config, BlockPredicate.IS_AIR);
        var configured = ConfiguredFeatures.createRandomPatchFeatureConfig(tries, entry);
        return Reg.register(id, Feature.RANDOM_PATCH, configured);
    }
    
    public static RegistryEntry<PlacedFeature> registerPlant(RegistryEntry<ConfiguredFeature<?, ?>> config, int rarity) {
        return registerPlant(config.getKey().get().getValue().getPath(), config, rarity);
    }
    
    public static RegistryEntry<PlacedFeature> registerPlant(String id, RegistryEntry<ConfiguredFeature<?, ?>> config, int rarity) {
        return Reg.register(id, config, RarityFilterPlacementModifier.of(rarity), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
    }
}
