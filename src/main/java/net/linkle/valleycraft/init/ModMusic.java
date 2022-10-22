package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModMusic {

    public static SoundEvent ANCIENT = registerSoundEvent("ancient");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Main.ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void initialize() {
    }
}
