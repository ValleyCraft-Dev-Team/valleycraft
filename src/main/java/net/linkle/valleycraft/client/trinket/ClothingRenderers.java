package net.linkle.valleycraft.client.trinket;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.linkle.valleycraft.client.trinket.renderer.BodyRenderer;
import net.linkle.valleycraft.client.trinket.renderer.FullRenderer;
import net.linkle.valleycraft.init.Baubles;
import net.linkle.valleycraft.init.Clothing;
import net.linkle.valleycraft.init.ItemsModded;
import net.minecraft.item.ItemConvertible;

// Trinket
public class ClothingRenderers {
    public static void initialize() {
        // Check valleycraft/textures/models/clothing for textures

        register(new FullRenderer("labcoat"), Clothing.LABCOAT);

    }
    
    private static void register(TrinketRenderer renderer, ItemConvertible item) {
        TrinketRendererRegistry.registerRenderer(item.asItem(), renderer);
    }
}
