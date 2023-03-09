package net.linkle.valleycraft.client.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.linkle.valleycraft.client.armor.renderer.CowPokeHatRenderer;
import net.linkle.valleycraft.client.armor.renderer.StrawHatRenderer;
import net.linkle.valleycraft.init.Armors;
import net.minecraft.item.ItemConvertible;

/** Armor Renderers */
@Environment(EnvType.CLIENT)
public class ArmorRenderers {
    
    public static void intialize() {
        register(new StrawHatRenderer(), Armors.STRAW_HAT);
        register(new CowPokeHatRenderer(), Armors.COWPOKE_HAT);
    }
    
    private static void register(ArmorRenderer renderer, ItemConvertible... items) {
        ArmorRenderer.register(renderer, items);
    }
}
