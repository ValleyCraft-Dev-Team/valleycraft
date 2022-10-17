package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.registry.Registry;

public enum ModPaintings {

    MOGAR(32, 32),
    BELAENU(16, 32),
    TERRA_INCOGNITA(32, 64),
    FINAL_RITUAL(96, 64),
    FATE(32, 16),
    STRANGE_DREAM(16, 16),
    GWEYIRS_FINAL_VOYAGE(48, 32),
    ANCIENT_HISTORY(16, 16),
    HOME(32, 16),
    HEX_AIRSHIP(48, 32),
    CYCLES(32, 16),
    //TRANSLATION_CANVAS(32, 32),
    WINGS_TO_THE_SKY(32, 32),
    MONSTER_DAYS(32, 32);

    public static void initialize() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
    
    
    // ### The Enum Class Itself ###
    
    public final PaintingVariant painting;
    
    ModPaintings(int width, int height) {
        painting = Registry.register(Registry.PAINTING_VARIANT, Main.makeId(name().toLowerCase()), new PaintingVariant(width, height));
    }
}
