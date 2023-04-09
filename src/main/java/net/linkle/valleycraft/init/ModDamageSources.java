package net.linkle.valleycraft.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.text.Text;

public class ModDamageSources extends DamageSource {
    public static final DamageSource JELLYCAP = new DamageSource("jellycap");
    public static final DamageSource GLOWCAP = (new DamageSource("glowcap")).setBypassesArmor().setFire();

    public ModDamageSources(String name) {
        super(name);
    }
}
