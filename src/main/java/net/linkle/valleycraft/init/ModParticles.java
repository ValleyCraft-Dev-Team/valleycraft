package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.PendingParticleFactory;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.particle.SoulSmokeParticle;
import net.linkle.valleycraft.client.particle.WaterSprinkleParticle.SprinkleFactory;
import net.linkle.valleycraft.util.BlockLeakParticleDuck;
import net.minecraft.client.particle.BlockLeakParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.WaterSplashParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    
    public static final DefaultParticleType SPRINKLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_EXP_ORB = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_EXP_ORB = FabricParticleTypes.simple();
    public static final DefaultParticleType DRIPPING_SLUDGE = FabricParticleTypes.simple();
    public static final DefaultParticleType FALLING_SLUDGE = FabricParticleTypes.simple();
    public static final DefaultParticleType SLUDGE_SPLASH = FabricParticleTypes.simple();
    public static final DefaultParticleType SCULK_POLLEN = FabricParticleTypes.simple();

    public static void initialize() {
        register("sprinkle", SPRINKLE);
        register("green_exp_orb", GREEN_EXP_ORB);
        register("blue_exp_orb", BLUE_EXP_ORB);
        register("dripping_sludge", DRIPPING_SLUDGE);
        register("falling_sludge", FALLING_SLUDGE);
        register("sludge_splash", SLUDGE_SPLASH);
        register("sculk_pollen", SCULK_POLLEN);
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        register(SPRINKLE, SprinkleFactory::new);
        register(SCULK_POLLEN, BlockLeakParticle.FallingSporeBlossomFactory::new);
        register(GREEN_EXP_ORB, SoulSmokeParticle.Factory::new);
        register(BLUE_EXP_ORB, SoulSmokeParticle.Factory::new);
        register(SLUDGE_SPLASH, WaterSplashParticle.SplashFactory::new);
        ParticleFactoryRegistry.getInstance().register(DRIPPING_SLUDGE, s -> new BlockLeakParticle.DrippingWaterFactory(s) {
            @Override
            public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
                BlockLeakParticle r = (BlockLeakParticle)super.createParticle(parameters, world, x, y, z, velocityX, velocityY, velocityZ);
                r.setColor(0.5f, 0.5f, 0.5f);
                ((BlockLeakParticleDuck)r).setNextParticle(FALLING_SLUDGE);
                return r;
            }
        });
        ParticleFactoryRegistry.getInstance().register(FALLING_SLUDGE, s -> new BlockLeakParticle.FallingWaterFactory(s) {
            @Override
            public Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
                BlockLeakParticle r = (BlockLeakParticle)super.createParticle(parameters, world, x, y, z, velocityX, velocityY, velocityZ);
                r.setColor(0.5f, 0.5f, 0.5f);
                ((BlockLeakParticleDuck)r).setNextParticle(SLUDGE_SPLASH);
                return r;
            }
        });
    }

    private static <T extends ParticleEffect> ParticleType<T> register(String id, ParticleType<T> type) {
        return Registry.register(Registry.PARTICLE_TYPE, Main.makeId(id), type);
    }
    
    @Environment(EnvType.CLIENT)
    private static <T extends ParticleEffect> void register(ParticleType<T> type, PendingParticleFactory<T> constructor) {
        ParticleFactoryRegistry.getInstance().register(type, constructor);
    }
}
