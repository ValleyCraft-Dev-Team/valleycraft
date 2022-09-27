package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPaintings {

    public static final PaintingMotive MOGAR = registerPainting("mogar", new PaintingMotive(32,32));
    public static final PaintingMotive HORSE_PATRON = registerPainting("belaenu", new PaintingMotive(16,32));
    public static final PaintingMotive TERRA_INCOGNITA = registerPainting("terra_incognita", new PaintingMotive(32,64));
    public static final PaintingMotive FINAL_RITUAL = registerPainting("final_ritual", new PaintingMotive(96,64));
    public static final PaintingMotive FATE = registerPainting("fate", new PaintingMotive(32,16));
    public static final PaintingMotive STRANGE_DREAM = registerPainting("strange_dream", new PaintingMotive(16,16));
    public static final PaintingMotive GWEYIRS_FINAL_VOYAGE = registerPainting("gweyirs_final_voyage", new PaintingMotive(48,32));
    public static final PaintingMotive ANCIENT_HISTORY = registerPainting("ancient_history", new PaintingMotive(16,16));
    public static final PaintingMotive ILLAGER_HOME = registerPainting("home", new PaintingMotive(32,16));

    private static PaintingMotive registerPainting(String name, PaintingMotive paintingMotive) {
        return Registry.register(Registry.PAINTING_MOTIVE, new Identifier(Main.ID, name), paintingMotive);

    }
    public static void registerPaintings() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
}
