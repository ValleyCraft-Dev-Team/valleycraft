package net.linkle.valleycraft.client.trinket;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.linkle.valleycraft.client.trinket.renderer.TalismanRenderer;
import net.linkle.valleycraft.init.ModArmors;
import net.linkle.valleycraft.init.ModItems;
import net.minecraft.item.ItemConvertible;

// Trinket
public class TrinketRenderers {
    public static void intialize() {
        // Check valleycraft/textures/models/trinket for textures
        register(new TalismanRenderer("amethyst_talisman"), ModItems.AMETHYST_TALISMAN);
        register(new TalismanRenderer("echo_shard"), ModItems.ECHO_SHARD_TALISMAN);
        register(new TalismanRenderer("emerald_talisman"), ModItems.EMERALD_TALISMAN);
        register(new TalismanRenderer("ender_dragon_talisman"), ModItems.ENDER_DRAGON_TALISMAN);
        register(new TalismanRenderer("moblin_talisman"), ModItems.MOBLIN_TALISMAN);
    }
    
    private static void register(TrinketRenderer renderer, ItemConvertible... items) {
        for (var item : items) {
            TrinketRendererRegistry.registerRenderer(item.asItem(), renderer);
        }
    }
}
