package net.linkle.valleycraft.network;

import net.linkle.valleycraft.Main;
import net.minecraft.util.Identifier;

public enum Networks {
    FLOATING_ITEM;
    
    public final Identifier id;
    private Networks() {
        id = Main.makeId(name().toLowerCase());
    }
}
