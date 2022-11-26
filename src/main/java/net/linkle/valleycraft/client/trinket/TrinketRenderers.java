package net.linkle.valleycraft.client.trinket;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.linkle.valleycraft.client.trinket.renderer.TalismanRenderer;
import net.linkle.valleycraft.init.ModArmors;
import net.linkle.valleycraft.init.ModBaubles;
import net.linkle.valleycraft.init.ModItems;
import net.minecraft.item.ItemConvertible;

// Trinket
public class TrinketRenderers {
    public static void intialize() {
        // Check valleycraft/textures/models/trinket for textures
        register(new TalismanRenderer("amethyst_talisman"), ModBaubles.AMETHYST_TALISMAN);
        register(new TalismanRenderer("echo_shard"), ModBaubles.ECHO_SHARD_TALISMAN);
        register(new TalismanRenderer("emerald_talisman"), ModBaubles.EMERALD_TALISMAN);
        register(new TalismanRenderer("ender_dragon_talisman"), ModBaubles.ENDER_DRAGON_TALISMAN);
        register(new TalismanRenderer("moblin_talisman"), ModBaubles.MOBLIN_TALISMAN);
    }
    
    private static void register(TrinketRenderer renderer, ItemConvertible... items) {
        for (var item : items) {
            TrinketRendererRegistry.registerRenderer(item.asItem(), renderer);
        }
    }
}
