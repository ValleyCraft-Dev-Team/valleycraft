package net.linkle.valleycraft.gen;

import static net.linkle.valleycraft.gen.feature.ModBiomeFeatures.*;
import static net.minecraft.world.biome.OverworldBiomeCreator.createColdOcean;
import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;
import net.linkle.valleycraft.gen.feature.VegetationPlaced;
import net.linkle.valleycraft.init.ModBiomes;
import net.linkle.valleycraft.widener.OverworldBiomeWidener;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.OceanPlacedFeatures;
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

    //public static Biome snowyOldGrowthTaiga() {}

    //public static Biome amberBirchOldGrowth() {}

    /** Amberblossom Forest */
    public static Biome amberDarkForest() {
        var gens = new GenerationSettings.Builder();
        addBasicFeatures(gens);
        addMossyRocks(gens);
        addDefaultOres(gens);
        addDefaultDisks(gens);
        //gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.MUSHROOM_ISLAND_VEGETATION);
        //gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_WATERLILY);
        addJungleGrass(gens);
        addLargeFerns(gens);
        addGiantTaigaGrass(gens);
        addSweetBerryBushes(gens);
        gens.feature(VEGETAL_DECORATION, VegetationPlaced.AMBERBLOSSOM_VEGETATION.entry);
        gens.feature(VEGETAL_DECORATION, VegetationPlaced.PATCH_PUMPKIN.entry);

        var spawns = new SpawnSettings.Builder();

        // surface mobs
        addWilderForestMobs(spawns);
        addWilderAutumnalMobs(spawns);

        // cave mobs
        addBatsAndMonsters(spawns);
        addWilderCaveMobs(spawns);

        float temps = 0.8f;
        var effects = new BiomeEffects.Builder();
        addBasicEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_OLD_GROWTH_TAIGA));
        effects.grassColor(0xE58639);
        effects.foliageColor(0xFF8B26);
        
        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }
}
