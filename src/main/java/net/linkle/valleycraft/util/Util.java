package net.linkle.valleycraft.util;

import java.util.Random;
import java.util.random.RandomGenerator;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;

public class Util extends net.minecraft.util.Util {
    public static final Random RANDOM = new Random();
    
    public static boolean inWater(ItemPlacementContext context) {
        return context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER;
    }
    
    /** {@return the ticker if the given type and expected type are the same, or {@code null} if they are different} */
    @Nullable
    @SuppressWarnings("unchecked")
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> checkType(BlockEntityType<A> givenType, BlockEntityType<E> expectedType, BlockEntityTicker<? super E> ticker) {
        return expectedType == givenType ? (BlockEntityTicker<A>) ticker : null;
    }
    
    public static int nextInt(RandomGenerator random, int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    
    /** Return true if the first object equals *any* of the second objects.
     *  You can append more objects into this method. */
    public static boolean equalsAny(Object first, Object... objects) {
        for (var object : objects) {
            if (first.equals(object)) return true;
        }
        return false;
    }
    
    /** Return true if the first object equals *all* of the second objects.
     *  You can append more objects into this method. */
    public static boolean equals(Object first, Object... objects) {
        for (var object : objects) {
            if (!first.equals(object)) return false;
        }
        return true;
    }
    
    public static float pow(float val, int num) {
        float result = val;
        for (int i = 1; i < num; i++) {
            result *= val;
        }
        return result;
    }
}
