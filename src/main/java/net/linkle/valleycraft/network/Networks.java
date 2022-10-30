package net.linkle.valleycraft.network;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.util.Identifier;

public enum Networks implements IdProvider {
    
    FLOATING_ITEM;
    
    public final Identifier id;
    private Networks() {
        id = Main.makeId(name().toLowerCase());
    }
    @Override
    public Identifier getId() {
        return id;
    }
}
