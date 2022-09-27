package net.linkle.valleycraft.effect;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEffects {
    public static StatusEffect ROT_BLIGHT;

    public static StatusEffect registerStatusEffectRotBlightEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Main.ID, name),
                new RotBlightEffect(StatusEffectCategory.HARMFUL, 2109722));
    }

    public static void registerEffects() {
        ROT_BLIGHT = registerStatusEffectRotBlightEffect("rot_blight");
    }
}
