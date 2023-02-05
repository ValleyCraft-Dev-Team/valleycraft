package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.fluid.SludgeFluid;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum Fluids implements IdProvider {
    SLUDGE_STILL(new SludgeFluid.Still()),
    SLUDGE_FLOWING(new SludgeFluid.Flowing());

    public static void initialize() {}
    
    public final Fluid fluid;
    public final Identifier id;
    
    Fluids(Fluid fluid) {
        this.fluid = Registry.register(Registry.FLUID, id = Main.makeId(name().toLowerCase()), fluid);
    }
    
    public FlowableFluid flowable() {
        return (FlowableFluid)fluid;
    }

    @Override
    public Identifier getId() {
        return id;
    }
}
