package net.linkle.valleycraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.emi.trinkets.api.TrinketsApi;
import net.linkle.valleycraft.init.Baubles;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(EndermanEntity.class)
abstract class EndermanEntityMixin {
	@Inject(method = "isPlayerStaring", at = @At("HEAD"), cancellable = true)
    void isPlayerStaring(PlayerEntity player, CallbackInfoReturnable<Boolean> info) {
		var comp = TrinketsApi.getTrinketComponent(player);
		if (comp.isPresent() && comp.get().isEquipped(Baubles.ENDER_DRAGON_TALISMAN.item)) {
			info.setReturnValue(false);
		}
    }
}
