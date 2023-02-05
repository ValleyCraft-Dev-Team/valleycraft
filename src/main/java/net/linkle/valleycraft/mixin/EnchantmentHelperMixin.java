package net.linkle.valleycraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.linkle.valleycraft.entity.DuckEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;

@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {

    // Treat ducks as if they have depth strider
    @Inject(method =  "getDepthStrider", at = @At("HEAD"), cancellable = true)
    private static void getDepthStrider(LivingEntity entity, CallbackInfoReturnable<Integer> info) {
        if (entity instanceof DuckEntity) {
            info.setReturnValue(2);
        }
    }
}
