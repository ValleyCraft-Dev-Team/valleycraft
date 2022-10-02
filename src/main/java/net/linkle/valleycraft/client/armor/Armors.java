package net.linkle.valleycraft.client.armor;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.linkle.valleycraft.client.armor.renderer.StrawHatRenderer;
import net.linkle.valleycraft.init.ModArmors;
import net.minecraft.item.ItemConvertible;

/** Armor Renderers */
@Environment(EnvType.CLIENT)
public class Armors {
    
    public static void intialize() {
        register(new StrawHatRenderer(), ModArmors.STRAW_HAT);
    }
    
    private static void register(ArmorRenderer renderer, ItemConvertible... items) {
        ArmorRenderer.register(renderer, items);
    }
}
