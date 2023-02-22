package net.linkle.valleycraft.init;

import net.linkle.valleycraft.Main;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Paintings {
    // do not alter this code please!

    public static final PaintingVariant MOGAR = registerPainting("mogar", new PaintingVariant(32,32));
    public static final PaintingVariant TERRA_INCOGNITA = registerPainting("terra_incognita", new PaintingVariant(32,64));
    public static final PaintingVariant TEMPLE = registerPainting("temple", new PaintingVariant(48,48));
    public static final PaintingVariant FATE = registerPainting("fate", new PaintingVariant(32,16));
    public static final PaintingVariant STRANGE_DREAM = registerPainting("strange_dream", new PaintingVariant(16,16));
    public static final PaintingVariant GWEYIRS_FINAL_VOYAGE = registerPainting("gweyirs_final_voyage", new PaintingVariant(48,32));
    public static final PaintingVariant ANCIENT_HISTORY = registerPainting("ancient_history", new PaintingVariant(16,16));
    public static final PaintingVariant HOME = registerPainting("home", new PaintingVariant(32,16));
    public static final PaintingVariant HEX_AIRSHIP = registerPainting("hex_airship", new PaintingVariant(48,32));
    public static final PaintingVariant CYCLES = registerPainting("cycles", new PaintingVariant(32,16));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(Main.ID, name), paintingVariant);
    }
    


    public static void initialize() {
        Main.LOGGER.debug("Registering paintings for Wilder Horizons");
    }
}
