package net.linkle.valleycraft.util;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;

public class Util {
    public static boolean inWater(ItemPlacementContext context) {
        return context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER;
    }
}
