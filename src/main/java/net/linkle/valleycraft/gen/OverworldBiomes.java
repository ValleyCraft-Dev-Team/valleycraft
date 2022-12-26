package net.linkle.valleycraft.gen;

import static net.linkle.valleycraft.gen.feature.ModBiomeFeatures.*;
import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;
import net.linkle.valleycraft.gen.feature.VegetationPlaced;
import net.linkle.valleycraft.init.ModBiomes;
import net.linkle.valleycraft.widener.OverworldBiomeWidener;
import net.minecraft.client.sound.MusicType;
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

    static void addSnowyBiomeEffects(BiomeEffects.Builder builder) {
        builder.waterColor(4020182);
        builder.waterFogColor(329011);
        builder.fogColor(12638463);
        builder.moodSound(BiomeMoodSound.CAVE);
        builder.skyColor(8625919);
    }

    static void addDefaultVegetation(GenerationSettings.Builder gens) {
        addDefaultMushrooms(gens);
        addDefaultFlowers(gens);
        addDefaultGrass(gens);
        gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_SUGAR_CANE);
        gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_PUMPKIN);
    }

    //public static Biome amberBirchOldGrowth() {}

    /** Amberblossom Forest */
    public static Biome amberDarkForest() {
        var gens = new GenerationSettings.Builder();
        addBasicFeatures(gens);

        addInfestedStone(gens);

        addMossyRocks(gens);
        addDefaultMushrooms(gens);
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
        effects.grassColor(5274162);
        effects.foliageColor(5877296);
        
        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }

    public static Biome snowyOldGrowthTaiga() {
        var gens = new GenerationSettings.Builder();
        addBasicFeatures(gens);

        addFrozenLavaSpring(gens);
        addMossyRocks(gens);
        addInfestedStone(gens);

        addDefaultVegetation(gens);

        addLargeFerns(gens);
        addGiantTaigaGrass(gens);
        addSweetBerryBushesSnowy(gens);
        gens.feature(VEGETAL_DECORATION, VegetationPlacedFeatures.TREES_OLD_GROWTH_SPRUCE_TAIGA);

        var spawns = new SpawnSettings.Builder();

        // surface mobs
        addWilderForestMobs(spawns);
        addWilderHarshFrozenMobs(spawns);
        addFarmAnimals(spawns);
        // cave mobs
        addBatsAndMonsters(spawns);
        addWilderCaveMobs(spawns);

        float temps = -0.5f;
        var effects = new BiomeEffects.Builder();
        addSnowyBiomeEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_OLD_GROWTH_TAIGA));
        effects.grassColor(8434839);
        effects.foliageColor(6332795);

        return BiomeUtils.create(Precipitation.SNOW, temps, 0.4f, effects, spawns, gens);
    }
}
