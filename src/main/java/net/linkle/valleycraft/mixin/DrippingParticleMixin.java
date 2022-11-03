package net.linkle.valleycraft.mixin;

import net.linkle.valleycraft.util.BlockLeakParticleDuck;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.ParticleEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Part of the custom fluid dripping particle implementation made by FoundationGames.
 * The original can be found here: https://github.com/FoundationGames/Sandwichable/blob/1.18.2/src/main/java/io/github/foundationgames/sandwichable/mixin/ContinuousFallingParticleMixin.java
 */

@Mixin(targets = "net/minecraft/client/particle/BlockLeakParticle$Dripping")
public abstract class DrippingParticleMixin extends Particle implements BlockLeakParticleDuck {
    @Unique
    private ParticleEffect customNextParticle;

    @Inject(method = "updateAge()V", at = @At("HEAD"), cancellable = true)
    public void sandwichable$spawnCustomNextParticle(CallbackInfo ci) {
        if(customNextParticle != null && this.maxAge - 1 <= 0) {
            this.markDead();
            this.world.addParticle(this.customNextParticle, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
            ci.cancel();
        }
    }

    @Override
    public void setNextParticle(ParticleEffect effect) {
        customNextParticle = effect;
    }

    protected DrippingParticleMixin(ClientWorld clientWorld, double d, double e, double f) {
        super(clientWorld, d, e, f);
        throw new AssertionError("dummy constructor called");
    }
}