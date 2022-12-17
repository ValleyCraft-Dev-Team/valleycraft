package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.util.Identifier;

public class ModLootTables {
    public static final Identifier WATER_STRAINER = register("water_strainer/loot");
    
    private static Identifier register(String id) {
        return Main.makeId(id);
    }
}
