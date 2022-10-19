package net.linkle.valleycraft.gen.foliage;

import static net.linkle.valleycraft.widener.FoliagePlacerTypeWidener.register;

import com.mojang.serialization.Codec;

import net.linkle.valleycraft.Main;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public enum ModFoliagePlacerType {
    
    AMBER(AmberFoliagePlacer.CODEC);
    
    
    public static void initialize() {
    }
    
    // ### The Enum Class Itself ###
    
    public final Codec<? extends FoliagePlacer> codec;
    public final FoliagePlacerType<?> type;
    
    ModFoliagePlacerType(Codec<? extends FoliagePlacer> codec) {
        this.codec = codec;
        type = register(Main.toId(name().toLowerCase().concat("_foliage_placer")), codec);
    }
}
