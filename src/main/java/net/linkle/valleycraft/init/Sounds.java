package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum Sounds implements IdProvider {
    
    SPRINKLER,
    
    CURTAIN_OPEN,
    CURTAIN_CLOSE,
    
    POT_BREAK;

    public static void initialize() {
    }
    
    
    // ### The Enum Class Itself ###
    
    public final SoundEvent sound;
    
    Sounds() {
        sound = new SoundEvent(Main.makeId(name().toLowerCase()));
        Registry.register(Registry.SOUND_EVENT, sound.getId(), sound);
    }

    @Override
    public Identifier getId() {
        return sound.getId();
    }
}
