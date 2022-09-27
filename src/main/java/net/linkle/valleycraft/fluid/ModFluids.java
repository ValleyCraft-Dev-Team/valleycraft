package net.linkle.valleycraft.fluid;

import net.linkle.valleycraft.Main;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid SLUDGE_STILL = register("sludge_still", new SludgeFluid.Still());
    public static final FlowableFluid SLUDGE_FLOWING = register("sludge_flowing", new SludgeFluid.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registry.FLUID, new Identifier(Main.ID, name), flowableFluid);
    }
}
