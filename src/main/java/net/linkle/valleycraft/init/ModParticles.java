package net.linkle.valleycraft.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry.PendingParticleFactory;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.particle.WaterSprinkleParticle.SprinkleFactory;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.util.registry.Registry;

public class ModParticles {
    
    public static final DefaultParticleType SPRINKLE = FabricParticleTypes.simple();
    
    public static void initialize() {
        register("sprinkle", SPRINKLE);
    }
    
    @Environment(EnvType.CLIENT)
    public static void initializeClient() {
        register(SPRINKLE, SprinkleFactory::new);
    }
    
    private static <T extends ParticleEffect> ParticleType<T> register(String id, ParticleType<T> type) {
        return Registry.register(Registry.PARTICLE_TYPE, Main.makeId(id), type);
    }
    
    @Environment(EnvType.CLIENT)
    private static <T extends ParticleEffect> void register(ParticleType<T> type, PendingParticleFactory<T> constructor) {
        ParticleFactoryRegistry.getInstance().register(type, constructor);
    }
}
