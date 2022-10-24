package net.linkle.valleycraft.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.RainSplashParticle;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class GreenExpOrbParticle extends RainSplashParticle {

    protected GreenExpOrbParticle(ClientWorld clientWorld, double x, double y, double z, double xVel, double yVel, double zVel) {
        super(clientWorld, x, y, z);
        gravityStrength = 0.05f;
        velocityX = xVel;
        velocityY = yVel;
        velocityZ = zVel;
    }

    @Environment(EnvType.CLIENT)
    public static class GreenExpFactory
    implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider provider;

        public GreenExpFactory(SpriteProvider provider) {
            this.provider = provider;
        }

        @Override
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double x, double y, double z, double xVel, double yVel, double zVel) {
            var particle = new GreenExpOrbParticle(clientWorld, x, y, z, xVel, yVel, zVel);
            particle.setSprite(provider);
            return particle;
        }
    }
}
