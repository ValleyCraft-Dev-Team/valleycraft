package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {

    public static final PaintingMotive MOGAR = register("mogar", 32, 32);
    public static final PaintingMotive HORSE_PATRON = register("belaenu", 16, 32);
    public static final PaintingMotive TERRA_INCOGNITA = register("terra_incognita", 32, 64);
    public static final PaintingMotive FINAL_RITUAL = register("final_ritual", 96, 64);
    public static final PaintingMotive FATE = register("fate", 32, 16);
    public static final PaintingMotive STRANGE_DREAM = register("strange_dream", 16, 16);
    public static final PaintingMotive GWEYIRS_FINAL_VOYAGE = register("gweyirs_final_voyage", 48, 32);
    public static final PaintingMotive ANCIENT_HISTORY = register("ancient_history", 16, 16);
    public static final PaintingMotive ILLAGER_HOME = register("home", 32, 16);
    public static final PaintingMotive HEXS_AIRSHIP = register("hex_airship", 48, 32);
    public static final PaintingMotive CYCLES = register("cycles", 32, 16);

    public static void initialize() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
    
    private static PaintingMotive register(String name, int width, int height) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(Main.ID, name), new PaintingMotive(width, height));
    }
}
