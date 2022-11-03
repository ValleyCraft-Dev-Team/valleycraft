package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModMusic implements IdProvider {

    ANCIENT,
    OFTHEWILDRMOUNTAIN;

    public static void initialize() {
    }
    
    // ### The Enum Class Itself ###
    
    public final SoundEvent sound, music;
    
    ModMusic() {
        sound = music = new SoundEvent(Main.makeId(name().toLowerCase()));
        Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }

    @Override
    public Identifier getId() {
        return sound.getId();
    }
}
