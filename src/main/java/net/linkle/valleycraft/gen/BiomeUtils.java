package net.linkle.valleycraft.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.Biome.Precipitation;

public class BiomeUtils {
    
    public static Biome create(Precipitation precipitation, float temperature, float downfall, BiomeEffects.Builder effects, SpawnSettings.Builder spawnSettings, GenerationSettings.Builder generationSettings) {
        return create(precipitation, temperature, downfall, effects.build(), spawnSettings.build(), generationSettings.build());
    }
    
    public static Biome create(Precipitation precipitation, float temperature, float downfall, BiomeEffects effects, SpawnSettings spawnSettings, GenerationSettings generationSettings) {
        var builder = new Biome.Builder();
        builder.precipitation(precipitation);
        builder.temperature(temperature);
        builder.downfall(downfall);
        builder.effects(effects);
        builder.spawnSettings(spawnSettings);
        builder.generationSettings(generationSettings);
        return builder.build();
    }
}
