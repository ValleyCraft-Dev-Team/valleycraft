package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

/** The configured feature interface. */
public interface ConfigFeature extends IdProvider {
    ConfiguredFeature<?, ?> getConfig();
    RegistryEntry<ConfiguredFeature<?, ?>> getEntry();
}
