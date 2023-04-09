package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Paintings {
    // do not alter this code please!

    public static final PaintingVariant MOGAR = registerPainting("mogar", new PaintingVariant(32,32));
    public static final PaintingVariant TERRA_INCOGNITA = registerPainting("terra_incognita", new PaintingVariant(32,64));
    public static final PaintingVariant TEMPLE = registerPainting("temple", new PaintingVariant(48,32));
    public static final PaintingVariant FATE = registerPainting("fate", new PaintingVariant(32,16));
    public static final PaintingVariant STRANGE_DREAM = registerPainting("strange_dream", new PaintingVariant(16,16));
    public static final PaintingVariant GWEYIRS_FINAL_VOYAGE = registerPainting("gweyirs_final_voyage", new PaintingVariant(48,32));
    public static final PaintingVariant ANCIENT_HISTORY = registerPainting("ancient_history", new PaintingVariant(16,16));
    public static final PaintingVariant HOME = registerPainting("home", new PaintingVariant(32,16));
    public static final PaintingVariant HEX_AIRSHIP = registerPainting("hex_airship", new PaintingVariant(48,32));
    public static final PaintingVariant CYCLES = registerPainting("cycles", new PaintingVariant(32,16));
    public static final PaintingVariant CYCLES_TWO = registerPainting("cycles_two", new PaintingVariant(32,16));
    public static final PaintingVariant ISLAND = registerPainting("island", new PaintingVariant(32,32));
    public static final PaintingVariant HOUSE = registerPainting("house", new PaintingVariant(16,16));
    public static final PaintingVariant BELAENU = registerPainting("belaenu", new PaintingVariant(16,32));
    public static final PaintingVariant DEPTHS = registerPainting("depths", new PaintingVariant(32,32));
    public static final PaintingVariant RUIN = registerPainting("ruin", new PaintingVariant(48,32));
    public static final PaintingVariant ELDER_LARGE = registerPainting("elder_large", new PaintingVariant(32,32));
    public static final PaintingVariant ELDER_SMALL = registerPainting("elder_small", new PaintingVariant(32,16));
    public static final PaintingVariant WRETCH = registerPainting("wretch", new PaintingVariant(16,32));
    public static final PaintingVariant WRETCH_PRIOR = registerPainting("wretch_prior", new PaintingVariant(16,32));
    public static final PaintingVariant AIR = registerPainting("air", new PaintingVariant(16,16));
    public static final PaintingVariant EARTH = registerPainting("earth", new PaintingVariant(16,16));
    public static final PaintingVariant FIRE = registerPainting("fire", new PaintingVariant(16,16));
    public static final PaintingVariant WATER = registerPainting("water", new PaintingVariant(16,16));
    public static final PaintingVariant SPIRIT = registerPainting("spirit", new PaintingVariant(16,16));
    public static final PaintingVariant TENDER_ROSE = registerPainting("tender_rose", new PaintingVariant(32,32));
    public static final PaintingVariant VOID = registerPainting("void", new PaintingVariant(32,16));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(Main.ID, name), paintingVariant);
    }



    public static void initialize() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
}
