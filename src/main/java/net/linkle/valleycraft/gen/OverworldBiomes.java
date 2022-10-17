package net.linkle.valleycraft.gen;

import net.linkle.valleycraft.widener.OverworldBiomeWideners;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;

public class OverworldBiomes {
    
    static void addBasicFeatures(GenerationSettings.Builder builder) {
        OverworldBiomeWideners.addBasicFeatures(builder);
    }
    
    /** Amberblossom Forest */
    public static Biome amberForest() {
        return null;
    }
}
