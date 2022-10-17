package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public enum ModSounds {
    
    SPRINKLER,
    CURTAIN_OPEN,
    
    CURTAIN_CLOSE;

    public static void initialize() {
    }
    
    
    // ### The Enum Class Itself ###
    
    public final SoundEvent sound;
    
    ModSounds() {
        sound = new SoundEvent(Main.makeId(name().toLowerCase()));
        Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }
}
