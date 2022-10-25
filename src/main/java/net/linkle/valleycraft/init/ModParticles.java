package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.PendingParticleFactory;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.particle.SoulSmokeParticle;
import net.linkle.valleycraft.client.particle.WaterSprinkleParticle.SprinkleFactory;
import net.minecraft.client.particle.ExplosionSmokeParticle;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    
    public static final DefaultParticleType SPRINKLE = FabricParticleTypes.simple();
    public static final DefaultParticleType GREEN_EXP_ORB = FabricParticleTypes.simple();
    public static final DefaultParticleType BLUE_EXP_ORB = FabricParticleTypes.simple();

    public static void initialize() {
        register("sprinkle", SPRINKLE);
        register("green_exp_orb", GREEN_EXP_ORB);
        register("blue_exp_orb", BLUE_EXP_ORB);

    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        register(SPRINKLE, SprinkleFactory::new);
        register(GREEN_EXP_ORB, SoulSmokeParticle.Factory::new);
        register(BLUE_EXP_ORB, SoulSmokeParticle.Factory::new);

    }

    private static <T extends ParticleEffect> ParticleType<T> register(String id, ParticleType<T> type) {
        return Registry.register(Registry.PARTICLE_TYPE, Main.makeId(id), type);
    }
    
    @Environment(EnvType.CLIENT)
    private static <T extends ParticleEffect> void register(ParticleType<T> type, PendingParticleFactory<T> constructor) {
        ParticleFactoryRegistry.getInstance().register(type, constructor);
    }
}
