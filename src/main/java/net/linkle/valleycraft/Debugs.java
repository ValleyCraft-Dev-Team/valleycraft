package net.linkle.valleycraft;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.linkle.valleycraft.extension.LivingEntityExt;
import net.linkle.valleycraft.item.ClimbingAxeItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;

/** This class exists because you can't debug mixin codes like add breakpoints or hot-swap codes. */
public class Debugs {
    
    public static void climbingAxe(LivingEntity entity, CallbackInfoReturnable<Boolean> info) {
        var entityExt = (LivingEntityExt)entity;
        entityExt.setIsAxeClimbing(false);
        if (entity.isHolding(item -> item.getItem() instanceof ClimbingAxeItem)) {
            if (entity.horizontalCollision || !entity.world.isSpaceEmpty(entity.getBoundingBox().expand(0.01, 0, 0.01))) {
                entityExt.setIsAxeClimbing(true);
                if (!entity.isOnGround() && entityExt.isYmoved()) { // is climbing up or down
                    entity.swingHand(entity.getMainHandStack().getItem() instanceof ClimbingAxeItem ? Hand.MAIN_HAND : Hand.OFF_HAND);
                }
                info.setReturnValue(true);
            }
        }
    }
}
