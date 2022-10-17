package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public enum ModSounds {
    
    SPRINKLER("sprinkler"),
    
    CURTAIN_OPEN("curtain_open"),
    CURTAIN_CLOSE("curtain_close");

    public static void initialize() {
    }
    
    
    // ### The Enum Class Itself ###
    
    public final SoundEvent sound;
    
    ModSounds(String id) {
        sound = new SoundEvent(Main.makeId(id));
        Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
