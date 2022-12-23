package net.linkle.valleycraft.gen;

import java.util.function.Consumer;

import com.mojang.datafixers.util.Pair;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.ModBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.source.util.MultiNoiseUtil.NoiseHypercube;
import terrablender.api.Region;
import terrablender.api.RegionType;

public class ModRegion extends Region {

    public ModRegion() {
        super(Main.makeId("overworld"), RegionType.OVERWORLD, 2);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<NoiseHypercube, RegistryKey<Biome>>> mapper) {
        addBiomeSimilar(mapper, BiomeKeys.DARK_FOREST, ModBiomes.AMBER_DARK_FOREST.key);

        //addBiomeSimilar(mapper, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, ModBiomes.OLD_GROWTH_AMBER_BIRCH_FOREST.key);
    }
}
