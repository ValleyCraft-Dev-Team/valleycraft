package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.Main;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

/** Known as {@link VegetationPlacedFeatures} */
public enum VegetationPlaced {
    PATCH_PUMPKIN(VegetationConfigs.PATCH_PUMPKIN, RarityFilterPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    public static void initialize() {
        VegetationConfigs.initialize();
    }
    
    public final RegistryEntry<PlacedFeature> entry;
    
    private VegetationPlaced(ConfigFeature config, PlacementModifier... modifiers) {
        entry = PlacedFeatures.register(Main.toId(name().toLowerCase()), config.getEntry(), modifiers);
    }
}
