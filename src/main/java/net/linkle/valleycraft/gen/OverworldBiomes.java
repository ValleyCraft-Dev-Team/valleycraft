package net.linkle.valleycraft.gen;

import static net.linkle.valleycraft.gen.feature.ModBiomeFeatures.*;
import static net.minecraft.world.gen.GenerationStep.Feature.VEGETAL_DECORATION;
import net.linkle.valleycraft.gen.feature.VegetationPlaced;
import net.linkle.valleycraft.init.Biomes;
import net.linkle.valleycraft.widener.OverworldBiomeWidener;
import net.minecraft.client.sound.MusicType;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.CaveCarver;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

/** Register the biome at {@link Biomes} */
public class OverworldBiomes {

    /**
     * {@link OverworldBiomeCreator#addBasicFeatures}
     */
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

    static void addDesertBiomeEffects(BiomeEffects.Builder builder) {
        builder.waterColor(4159204);
        builder.waterFogColor(329011);
        builder.fogColor(12638463);
        builder.moodSound(BiomeMoodSound.CAVE);
        builder.skyColor(7254527);
    }

    static void addSwampLikeBiomeEffects(BiomeEffects.Builder builder) {
        builder.waterColor(3832426);
        builder.waterFogColor(5077600);
        builder.fogColor(12638463);
        builder.moodSound(BiomeMoodSound.CAVE);
        builder.skyColor(7907327);
    }

    static void addWindsweptBiomeEffects(BiomeEffects.Builder builder) {
        builder.waterColor(4159204);
        builder.waterFogColor(329011);
        builder.fogColor(12638463);
        builder.moodSound(BiomeMoodSound.CAVE);
        builder.skyColor(7972607);
    }

    public static void addWHSwampFeatures(GenerationSettings.Builder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.FLOWER_SWAMP);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_NORMAL);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_DEAD_BUSH);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_WATERLILY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_SWAMP);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_SWAMP);
    }

    static void addDefaultFeatures(GenerationSettings.Builder gens) {
        OverworldBiomeWidener.addBasicFeatures(gens);
        //mineables includes glow lichen//
        addDripstone(gens);
        addDefaultOres(gens);
        addDefaultDisks(gens);
    }

    static void addDefaultPlantFeatures(GenerationSettings.Builder gens) {
        addDefaultMushrooms(gens);
        addDefaultFlowers(gens);
        addDefaultGrass(gens);
        addDefaultVegetation(gens);
    }

    static void addTaigaMushrooms(GenerationSettings.Builder gens) {
        gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.BROWN_MUSHROOM_TAIGA);
        gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.RED_MUSHROOM_TAIGA);
    }

    /*** Amberblossom Forest*/

    public static Biome amberDarkForest() {
        var gens = new GenBuilder();
        addDefaultFeatures(gens);
        //addDefaultPlantFeatures(gens);
        addMossyRocks(gens);
        //addLargeFerns(gens);
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

        float temps = 0.7f;
        var effects = new BiomeEffects.Builder();
        addBasicEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_OLD_GROWTH_TAIGA));
        effects.grassColor(5274162);
        effects.foliageColor(5877296);

        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }

    /*** Snowy Old Growth Taiga*/

    public static Biome snowyOldGrowthTaiga() {
        var gens = new GenBuilder();
        addDefaultFeatures(gens);

        addFrozenLavaSpring(gens);
        addMossyRocks(gens);
        addInfestedStone(gens);

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
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SNOWY_SLOPES));
        effects.grassColor(8434839);
        effects.foliageColor(6332795);

        return BiomeUtils.create(Precipitation.SNOW, temps, 0.4f, effects, spawns, gens);
    }

    /*** Snowy Cold Spruce and Oak Forest*/

    public static Biome snowyColdForest() {
        var gens = new GenBuilder();
        addDefaultFeatures(gens);
        addLargeFerns(gens);
        addForestFlowers(gens);
        addTaigaGrass(gens);
        addDefaultVegetation(gens);
        addSweetBerryBushesSnowy(gens);

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
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SNOWY_SLOPES));
        effects.grassColor(8434839);
        effects.foliageColor(6332795);

        return BiomeUtils.create(Precipitation.SNOW, temps, 0.4f, effects, spawns, gens);
    }

    /*** Cold Spruce and Oak Forest*/

    public static Biome coldForest() {
        var gens = new GenBuilder();
        addDefaultFeatures(gens);
        addLargeFerns(gens);
        addForestFlowers(gens);
        addTaigaGrass(gens);
        addDefaultVegetation(gens);
        addSweetBerryBushesSnowy(gens);

        var spawns = new SpawnSettings.Builder();

        // surface mobs
        addWilderForestMobs(spawns);
        addWilderHarshFrozenMobs(spawns);
        addFarmAnimals(spawns);
        // cave mobs
        addBatsAndMonsters(spawns);
        addWilderCaveMobs(spawns);

        float temps = 0.25f;
        var effects = new BiomeEffects.Builder();
        addSnowyBiomeEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_GROVE));
        effects.grassColor(8828803);
        effects.foliageColor(6857828);

        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }

    /*** Rainy Desert*/

    public static Biome rainyDesert() {
        var gens = new GenBuilder();

        addDefaultFeatures(gens);
        addDesertFeatures(gens);
        addFossils(gens);
        addSeagrassOnStone(gens);
        addDesertVegetation(gens);

        var spawns = new SpawnSettings.Builder();
        addDesertMobs(spawns);
        addBatsAndMonsters(spawns);

        float temps = 2f;
        var effects = new BiomeEffects.Builder();
        addDesertBiomeEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.grassColor(12564309);
        effects.foliageColor(11445290);

        return BiomeUtils.create(Precipitation.RAIN, temps, 0.6f, effects, spawns, gens);
    }

    /*** Marshlands*/

    public static Biome marshlands() {
        var gens = new GenBuilder();

        addDefaultFeatures(gens);
        addDesertFeatures(gens);
        addFossils(gens);
        //addSeagrassOnStone(gens);
        //addSwampVegetation(gens);
        //addWHSwampFeatures(gens);

        var spawns = new SpawnSettings.Builder();
        addWilderSwampMobs(spawns);
        addBatsAndMonsters(spawns);

        float temps = 0.8f;
        var effects = new BiomeEffects.Builder();
        addSwampLikeBiomeEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_SWAMP));
        effects.grassColor(6975545);
        effects.foliageColor(5011004);

        return BiomeUtils.create(Precipitation.RAIN, temps, 0.9f, effects, spawns, gens);
    }

    /*** Windswept Forest*/

    public static Biome windsweptForest() {
        var gens = new GenBuilder();

        addDefaultFeatures(gens);
        addDefaultPlantFeatures(gens);
        addSparseMelons(gens);

        var spawns = new SpawnSettings.Builder();
        addWilderForestMobs(spawns);
        addBatsAndMonsters(spawns);
        addFarmAnimals(spawns);

        float temps = 0.7f;
        var effects = new BiomeEffects.Builder();
        addWindsweptBiomeEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_JUNGLE_AND_FOREST));
        effects.grassColor(7979098);
        effects.foliageColor(5877296);

        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }
}
