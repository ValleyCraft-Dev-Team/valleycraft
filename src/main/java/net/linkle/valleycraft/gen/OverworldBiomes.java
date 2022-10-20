package net.linkle.valleycraft.gen;

import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;
import static net.minecraft.world.gen.feature.DefaultBiomeFeatures.*;

import net.linkle.valleycraft.gen.feature.VegetationPlaced;
import net.linkle.valleycraft.init.ModBiomes;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.widener.OverworldBiomeWidener;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

/** Register the biome at {@link ModBiomes} */
public class OverworldBiomes {
    
    /** {@link OverworldBiomeCreator#addBasicFeatures} */
    static void addBasicFeatures(GenerationSettings.Builder builder) {
        OverworldBiomeWidener.addBasicFeatures(builder);
    }
    
    static void addBasicEffects(BiomeEffects.Builder builder) {
        builder.waterColor(4159204);
        builder.waterFogColor(329011);
        builder.fogColor(12638463);
        builder.moodSound(BiomeMoodSound.CAVE);
    }
    
    /** Amberblossom Forest */
    public static Biome amberForest() {
        var gens = new GenerationSettings.Builder();
        addBasicFeatures(gens);
        addDefaultOres(gens);
        addDefaultDisks(gens);
        gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_PLAINS);
        gens.feature(VEGETAL_DECORATION, VegetationPlaced.WARM_BIRCH_PLACED.entry);
        gens.feature(VEGETAL_DECORATION, VegetationPlaced.AMBER_PLACED.entry);
        addDefaultFlowers(gens);
        addForestGrass(gens);
        addDefaultMushrooms(gens);
        addDefaultVegetation(gens);
        gens.feature(VEGETAL_DECORATION, VegetationPlaced.PATCH_PUMPKIN.entry);
        
        var spawns = new SpawnSettings.Builder();
        addFarmAnimals(spawns);
        addBatsAndMonsters(spawns);
        spawns.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PUPKIN, 5, 1, 3));
        
        float temps = 0.8f;
        var effects = new BiomeEffects.Builder();
        addBasicEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_JUNGLE_AND_FOREST));
        effects.grassColor(0xE58639);
        effects.foliageColor(0xFF8B26);
        
        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }
}
