package net.linkle.valleycraft.widener;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;

@Mixin(OverworldBiomeCreator.class)
public interface OverworldBiomeWideners {
    @Invoker("addBasicFeatures")
    static void addBasicFeatures(GenerationSettings.Builder builder) {
        throw new AssertionError();
    }
}
