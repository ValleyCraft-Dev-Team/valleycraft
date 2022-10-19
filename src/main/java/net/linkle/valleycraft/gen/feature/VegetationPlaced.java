package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.util.Reg;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;

/** Known as {@link VegetationPlacedFeatures} */
public enum VegetationPlaced {
    ASD();
    
    private VegetationPlaced() {
        //var list = VegetationPlacedFeatures.modifiers(RarityFilterPlacementModifier.of(1));
        //var placed = Reg.register("redwood_placed", TreePlaced.AMBER_CHECKED.entry, list);
        
        //list = VegetationPlacedFeatures.modifiersWithWouldSurvive(RarityFilterPlacementModifier.of(1), ModBlocks.REDWOOD_SAPLING);
        //placed = Reg.register("redwood_placed", TreeConfigFeatures.MEGA_REDWOOD, list);
    }
}
