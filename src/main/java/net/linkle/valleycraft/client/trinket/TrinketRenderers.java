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

        //iron base
        register(new TalismanRenderer("iron_necklace"), ModBaubles.IRON_NECKLACE);
        register(new TalismanRenderer("amethyst_talisman"), ModBaubles.AMETHYST_TALISMAN);
        register(new TalismanRenderer("diamond_talisman"), ModBaubles.DIAMOND_TALISMAN);
        register(new TalismanRenderer("emerald_talisman"), ModBaubles.EMERALD_TALISMAN);
        register(new TalismanRenderer("ender_pearl_talisman"), ModBaubles.ENDER_PEARL_TALISMAN);
        register(new TalismanRenderer("nether_quartz_talisman"), ModBaubles.NETHER_QUARTZ_TALISMAN);
        register(new TalismanRenderer("prismarine_crystal_talisman"), ModBaubles.PRISMARINE_TALISMAN);
        //leather base
        register(new TalismanRenderer("leather_necklace"), ModBaubles.LEATHER_NECKLACE);
        register(new TalismanRenderer("echo_shard"), ModBaubles.ECHO_SHARD_TALISMAN);
        register(new TalismanRenderer("fishing_hook_necklace"), ModBaubles.FISHING_HOOK_TALISMAN);
        register(new TalismanRenderer("guardian_spike_talisman"), ModBaubles.GUARDIAN_SPIKE_TALISMAN);
        register(new TalismanRenderer("scute_necklace"), ModBaubles.SCUTE_NECKLACE);
        //register(new TalismanRenderer("seaologer_rune_necklace"), ModBaubles.SEAOLOGER_RUNE_NECKLACE);

        //strange base
        register(new TalismanRenderer("elder_guardian_spike_talisman"), ModBaubles.ELDER_GUARDIAN_SPIKE_KEEPSAKE);
        register(new TalismanRenderer("ender_dragon_talisman"), ModBaubles.ENDER_DRAGON_TALISMAN);

        //unique
        //register(new TalismanRenderer("arrowhead_necklace"), ModBaubles.ARROWHEAD_TALISMAN);
        register(new TalismanRenderer("brimstone_talisman"), ModBaubles.BRIMSTONE_NECKLACE);
        //register(new TalismanRenderer("evil_crystal_keepsake"), ModBaubles.EVIL_CRYSTAL_KEEPSAKE);
        //register(new TalismanRenderer("moblin_talisman"), ModBaubles.MOBLIN_TALISMAN);
        //register(new TalismanRenderer("stray_necklace"), ModBaubles.STRAY_TALISMAN);
    }
    
    private static void register(TrinketRenderer renderer, ItemConvertible... items) {
        for (var item : items) {
            TrinketRendererRegistry.registerRenderer(item.asItem(), renderer);
        }
    }
}
