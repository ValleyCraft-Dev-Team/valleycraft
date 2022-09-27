package net.linkle.valleycraft.fluid;

import net.linkle.valleycraft.Main;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid SLUDGE_STILL = register("sludge_still", new SludgeFluid.Still());
    public static final FlowableFluid SLUDGE_FLOWING = register("sludge_flowing", new SludgeFluid.Flowing());
    
    public static void initialize() {}

    private static <T extends Fluid> T register(String name, T flowableFluid) {
        return Registry.register(Registry.FLUID, Main.makeId(name), flowableFluid);
    }
}
