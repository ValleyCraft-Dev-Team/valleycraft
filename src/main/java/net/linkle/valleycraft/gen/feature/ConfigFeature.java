package net.linkle.valleycraft.gen.feature;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

/** The configured feature interface. */
public interface ConfigFeature {
    ConfiguredFeature<?, ?> getConfig();
    RegistryEntry<ConfiguredFeature<?, ?>> getEntry();
    Identifier getId();
}
