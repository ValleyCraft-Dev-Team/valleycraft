package net.linkle.valleycraft.gen.feature;

import java.util.List;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.NaturalBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

/** Known as {@link VegetationPlacedFeatures} */
public enum VegetationPlaced {
    
    PATCH_PUMPKIN(VegetationConfigs.PATCH_PUMPKIN, RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()),
    AMBER_PLACED(TreeConfigs.AMBER_TREE, tree(CountPlacementModifier.of(3), NaturalBlocks.MAMON_SAPLING.block)),
    WARM_BIRCH_PLACED(TreeConfigs.WARM_BIRCH_TREE, tree(RarityFilterPlacementModifier.of(4), NaturalBlocks.MAMON_SAPLING.block));
    
    
    // Utilities
    
    public static List<PlacementModifier> tree(PlacementModifier modifier, Block block) {
        return VegetationPlacedFeatures.modifiersWithWouldSurvive(modifier, block);
    }
    
    
    // Enum
    
    public static void initialize() {
        VegetationConfigs.initialize();
    }
    
    public final RegistryEntry<PlacedFeature> entry;
    
    private VegetationPlaced(ConfigFeature config, PlacementModifier... modifiers) {
        this(config, List.of(modifiers));
    }
    
    private VegetationPlaced(ConfigFeature config, List<PlacementModifier> modifiers) {
        entry = PlacedFeatures.register(Main.toId(name().toLowerCase()), config.getEntry(), modifiers);
    }
}
