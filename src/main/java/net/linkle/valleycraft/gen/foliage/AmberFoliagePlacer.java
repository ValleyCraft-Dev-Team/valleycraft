package net.linkle.valleycraft.gen.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.foliage.DarkOakFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

/** Currently unused */
public class AmberFoliagePlacer extends DarkOakFoliagePlacer {
    public static final Codec<AmberFoliagePlacer> CODEC = RecordCodecBuilder.create(instance -> AmberFoliagePlacer.fillFoliagePlacerFields(instance).apply(instance, AmberFoliagePlacer::new));

    public AmberFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return ModFoliagePlacerType.AMBER.type;
    }
}
