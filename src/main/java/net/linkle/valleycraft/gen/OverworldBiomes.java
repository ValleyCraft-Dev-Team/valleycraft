package net.linkle.valleycraft.gen;

import static net.minecraft.world.gen.feature.DefaultBiomeFeatures.*;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.linkle.valleycraft.init.ModBiomes;
import net.linkle.valleycraft.init.ModEntityType;
import net.linkle.valleycraft.init.NaturalBlocks;
import net.linkle.valleycraft.util.Reg;
import net.linkle.valleycraft.widener.OverworldBiomeWidener;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.*;
import net.minecraft.world.biome.Biome.Precipitation;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;

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
        addDefaultFlowers(gens);
        addForestGrass(gens);
        addDefaultMushrooms(gens);
        addDefaultVegetation(gens);
        gens.feature(GenerationStep.Feature.VEGETAL_DECORATION, AMBER_PLACED);
        
        var spawns = new SpawnSettings.Builder();
        addFarmAnimals(spawns);
        addBatsAndMonsters(spawns);
        spawns.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PUPKIN, 5, 1, 3));
        
        float temps = 0.7f;
        var effects = new BiomeEffects.Builder();
        addBasicEffects(effects);
        effects.skyColor(OverworldBiomeWidener.getSkyColor(temps));
        effects.music(MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_JUNGLE_AND_FOREST));
        effects.grassColor(0xF28430);
        effects.foliageColor(0xFF871E);
        
        return BiomeUtils.create(Precipitation.RAIN, temps, 0.8f, effects, spawns, gens);
    }
    
    private static final RegistryEntry<PlacedFeature> AMBER_PLACED;
    static {
      var list = VegetationPlacedFeatures.modifiersWithWouldSurvive(CountPlacementModifier.of(2), NaturalBlocks.MAMON_SAPLING.block);
      AMBER_PLACED = BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, Main.makeId("amber_placed"), new PlacedFeature(RegistryEntry.upcast(TreeConfigs.AMBER_TREE.key), list));
    }
}
