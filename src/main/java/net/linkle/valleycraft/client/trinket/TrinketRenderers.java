package net.linkle.valleycraft.client.trinket;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.linkle.valleycraft.client.trinket.renderer.ArmRenderer;
import net.linkle.valleycraft.client.trinket.renderer.BodyRenderer;
import net.linkle.valleycraft.init.Baubles;
import net.minecraft.item.ItemConvertible;

// Trinket
public class TrinketRenderers {
    public static void intialize() {
        // Check valleycraft/textures/models/trinket for textures

        //iron base
        register(new BodyRenderer("iron_necklace"), Baubles.IRON_NECKLACE);
        register(new BodyRenderer("amethyst_talisman"), Baubles.AMETHYST_TALISMAN);
        register(new BodyRenderer("diamond_talisman"), Baubles.DIAMOND_TALISMAN);
        register(new BodyRenderer("emerald_talisman"), Baubles.EMERALD_TALISMAN);
        register(new BodyRenderer("ender_pearl_talisman"), Baubles.ENDER_PEARL_TALISMAN);
        register(new BodyRenderer("nether_quartz_talisman"), Baubles.NETHER_QUARTZ_TALISMAN);
        register(new BodyRenderer("prismarine_crystal_talisman"), Baubles.PRISMARINE_TALISMAN);
        //leather base
        register(new BodyRenderer("leather_necklace"), Baubles.LEATHER_NECKLACE);
        register(new BodyRenderer("echo_shard"), Baubles.ECHO_SHARD_TALISMAN);
        //register(new TalismanRenderer("fishing_hook_necklace"), ModBaubles.FISHING_HOOK_TALISMAN);
        register(new BodyRenderer("guardian_spike_talisman"), Baubles.GUARDIAN_SPIKE_TALISMAN);
        register(new BodyRenderer("scute_necklace"), Baubles.SCUTE_NECKLACE);
        //register(new TalismanRenderer("seaologer_rune_necklace"), ModBaubles.SEAOLOGER_RUNE_NECKLACE);

        //strange base
        register(new BodyRenderer("elder_guardian_spike_talisman"), Baubles.ELDER_GUARDIAN_SPIKE_KEEPSAKE);
        register(new BodyRenderer("ender_dragon_talisman"), Baubles.ENDER_DRAGON_TALISMAN);
        register(new BodyRenderer("undying_keepsake"), Baubles.UNDYING_KEEPSAKE);

        //unique
        //register(new TalismanRenderer("arrowhead_necklace"), ModBaubles.ARROWHEAD_TALISMAN);
        register(new BodyRenderer("brimstone_talisman"), Baubles.BRIMSTONE_NECKLACE);
        //register(new TalismanRenderer("evil_crystal_keepsake"), ModBaubles.EVIL_CRYSTAL_KEEPSAKE);
        //register(new TalismanRenderer("moblin_talisman"), ModBaubles.MOBLIN_TALISMAN);
        //register(new TalismanRenderer("stray_necklace"), ModBaubles.STRAY_TALISMAN);
        
        //register(new ArmRenderer(""), null);
    }
    
    private static void register(TrinketRenderer renderer, ItemConvertible item) {
        TrinketRendererRegistry.registerRenderer(item.asItem(), renderer);
    }
}
