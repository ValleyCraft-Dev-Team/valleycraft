package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.TagKey;

public class Contents {
    public static void initialize() {
        compost();
        flammable();
        fuels();
        strips();
    }
    
    private static void strips() {
        
    }

    @SuppressWarnings("unused")
    private static void compost() {
        Float levelLow = 0.3f; // leaves, seeds, saplings, grass.
        Float levelMed = 0.5f; // double plant, vines.
        Float levelHigh = 0.65f; // foods, flowers.
        Float levelVery = 0.85f; // blocks.
        Float levelUltra = 1.0f; // specials.
        
    }
    
    private static void flammable() {
        
    }
    
    private static void fuels() {
        
    }
    
    private static void putStrip(Block input, Block stripped) {
        StrippableBlockRegistry.register(input, stripped);
    }
    
    private static void putCompost(ItemConvertible item, Float chance) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }
    
    private static void putFlammable(Block block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);;
    }
    
    private static void putFuels(ItemConvertible item, Integer tick) {
        FuelRegistry.INSTANCE.add(item, tick);
    }
    
    private static void putFuels(TagKey<Item> tag, Integer tick) {
        FuelRegistry.INSTANCE.add(tag, tick);
    }
}
