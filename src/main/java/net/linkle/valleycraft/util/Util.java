package net.linkle.valleycraft.util;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;

public class Util {
    public static boolean inWater(ItemPlacementContext context) {
        return context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER;
    }
    
    /** {@return the ticker if the given type and expected type are the same, or {@code null} if they are different} */
    @Nullable
    @SuppressWarnings("unchecked")
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> checkType(BlockEntityType<A> givenType, BlockEntityType<E> expectedType, BlockEntityTicker<? super E> ticker) {
        return expectedType == givenType ? (BlockEntityTicker<A>) ticker : null;
    }
}
