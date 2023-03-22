package net.linkle.valleycraft.gen;

import java.util.HashSet;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.gen.feature.PlacedFeature;

public class GenBuilder extends Builder {
    
    /** used to remove duplicated features */
//    private final Int2ObjectOpenHashMap<HashSet<Object>> map = new Int2ObjectOpenHashMap<>();
    
//    private final HashSet<Object> set = new HashSet<>(200);
    
    @Override
    public Builder feature(int stepIndex, RegistryEntry<PlacedFeature> featureEntry) {
        //if (map.computeIfAbsent(stepIndex, HashSet::new).add(featureEntry.getKey().get())) {
//        if (set.add(featureEntry.getKey().get())) {
            return super.feature(stepIndex, featureEntry);
//        }
//        return this;
    }
}
