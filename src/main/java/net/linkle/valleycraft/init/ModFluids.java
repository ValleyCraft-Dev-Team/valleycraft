package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.fluid.SludgeFluid;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModFluids {
    SLUDGE_STILL(new SludgeFluid.Still()),
    SLUDGE_FLOWING(new SludgeFluid.Flowing());

    public static void initialize() {}
    
    public final Fluid fluid;
    public final Identifier id;
    
    ModFluids(Fluid fluid) {
        this.fluid = Registry.register(Registry.FLUID, id = Main.makeId(name().toLowerCase()), fluid);
    }
    
    public FlowableFluid flowable() {
        return (FlowableFluid)fluid;
    }
}
