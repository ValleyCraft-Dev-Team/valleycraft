package net.linkle.valleycraft.widener;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;

@Mixin(OverworldBiomeCreator.class)
public interface OverworldBiomeWidener {
    
    /** {@link OverworldBiomeCreator#addBasicFeatures} */
    @Invoker("addBasicFeatures")
    static void addBasicFeatures(GenerationSettings.Builder builder) {
        throw new AssertionError();
    }
    
    /** {@link OverworldBiomeCreator#getSkyColor} */
    @Invoker("getSkyColor")
    static int getSkyColor(float temperature) {
        throw new AssertionError();
    }
}
