package net.linkle.valleycraft.mixin;

import java.util.function.Predicate;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.linkle.valleycraft.Debugs;
import net.linkle.valleycraft.extension.LivingEntityExt;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
abstract class LivingEntityMixin extends Entity implements LivingEntityExt {
    
    private boolean isAxeClimbing;
    private double lastY;

    LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }
    
    @Override
    public boolean isAxeClimbing() {
        return isAxeClimbing;
    }
    
    @Override
    public void setIsAxeClimbing(boolean bool) {
        isAxeClimbing = bool;
    }
    
    @Override
    public boolean isYmoved() {
        return !MathHelper.approximatelyEquals(lastY, getY());
    }

    @Shadow
    abstract boolean isHolding(Predicate<ItemStack> item);

    @Shadow
    abstract void swingHand(Hand hand);

    @Shadow
    abstract ItemStack getMainHandStack();
    
    @Shadow
    abstract ItemStack getOffHandStack();
    
    @Inject(method = "tickMovement", at = @At("HEAD"))
    void tickMovement(CallbackInfo info) {
        lastY = getY();
    }
    
    @Inject(method = "isClimbing", at = @At("HEAD"), cancellable = true)
    void climbingAxe(CallbackInfoReturnable<Boolean> info) {
        Debugs.climbingAxe((LivingEntity)(Object)this, info);
    }
}
