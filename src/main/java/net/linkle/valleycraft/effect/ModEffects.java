package net.linkle.valleycraft.effect;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ROT_BLIGHT = register("rot_blight", new RotBlightEffect());
    public static StatusEffect SOUL_FADING = register("soul_fading", new SoulFadingEffect());
    public static StatusEffect CLEANSED = register("cleansed", new CleansedEffect());

    public static void initialize() {}
    
    public static StatusEffect register(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, Main.makeId(name), effect);
    }
}
