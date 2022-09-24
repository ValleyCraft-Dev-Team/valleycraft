package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    
    public static final SoundEvent SPRINKLER = register("sprinkler");
    
    public static final SoundEvent CURTAIN_OPEN = register("curtain_open");
    public static final SoundEvent CURTAIN_CLOSE = register("curtain_close");
    
    public static void initialize() {
    }
    
    private static SoundEvent register(String id) {
        var sound = new SoundEvent(Main.makeId(id));
        return Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
