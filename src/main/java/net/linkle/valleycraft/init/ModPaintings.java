package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {

    public static final PaintingVariant MOGAR = register("mogar", 32, 32);
    public static final PaintingVariant HORSE_PATRON = register("belaenu", 16, 32);
    public static final PaintingVariant TERRA_INCOGNITA = register("terra_incognita", 32, 64);
    public static final PaintingVariant FINAL_RITUAL = register("final_ritual", 96, 64);
    public static final PaintingVariant FATE = register("fate", 32, 16);
    public static final PaintingVariant STRANGE_DREAM = register("strange_dream", 16, 16);
    public static final PaintingVariant GWEYIRS_FINAL_VOYAGE = register("gweyirs_final_voyage", 48, 32);
    public static final PaintingVariant ANCIENT_HISTORY = register("ancient_history", 16, 16);
    public static final PaintingVariant ILLAGER_HOME = register("home", 32, 16);
    public static final PaintingVariant HEXS_AIRSHIP = register("hex_airship", 48, 32);
    public static final PaintingVariant CYCLES = register("cycles", 32, 16);
    //public static final PaintingMotive ROSETTA = register("translation_canvas", 32, 32);
    public static final PaintingVariant WINGS = register("wings_to_the_sky", 32, 32);
    public static final PaintingVariant MONSTER_DAYS = register("monster_days", 32, 32);

    public static void initialize() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
    
    private static PaintingVariant register(String name, int width, int height) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(Main.ID, name), new PaintingVariant(width, height));
    }
}
