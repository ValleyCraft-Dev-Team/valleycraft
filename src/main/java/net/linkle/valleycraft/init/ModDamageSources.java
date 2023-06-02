package net.linkle.valleycraft.init;

import net.minecraft.entity.damage.DamageSource;

public class ModDamageSources {
    public static final DamageSource JELLYCAP = new DamageSource("jellycap");
    public static final DamageSource GLOWCAP = new DamageSource("glowcap").setBypassesArmor().setFire();
}
