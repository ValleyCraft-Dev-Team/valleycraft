package net.linkle.valleycraft.widener;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import com.mojang.serialization.Codec;

import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

@Mixin(FoliagePlacerType.class)
public interface FoliagePlacerTypeWidener {

    @Invoker("register")
    static <P extends FoliagePlacer> FoliagePlacerType<P> register(String id, Codec<P> codec) {
        throw new AssertionError();
    }
}
