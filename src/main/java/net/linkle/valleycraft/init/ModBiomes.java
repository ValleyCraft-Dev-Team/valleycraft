package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.gen.OverworldBiomes;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public enum ModBiomes implements IdProvider {
    
    // Biome List
    AMBER_DARK_FOREST(OverworldBiomes.amberDarkForest());
    //OLD_GROWTH_AMBER_BIRCH_FOREST(OverworldBiomes.amberBirchForestTall());

    // Enum class
    public static void initialize() {} 
    
    public final RegistryKey<Biome> key;
    public final RegistryEntry<Biome> entry;
    public final Identifier id;
    public final Biome biome;
    
    ModBiomes(Biome biome) {
        key = RegistryKey.of(Registry.BIOME_KEY, id = Main.makeId(name().toLowerCase()));
        entry = BuiltinRegistries.add(BuiltinRegistries.BIOME, key, biome);
        this.biome = biome;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
