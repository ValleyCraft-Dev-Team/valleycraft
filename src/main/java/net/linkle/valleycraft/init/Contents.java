package net.linkle.valleycraft.init;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.*;

import net.fabricmc.fabric.api.registry.*;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.TagKey;

public class Contents {
    public static void initialize() {
        compost();
        flammable();
        fuels();
        strips();
        oxidizables();
    }
    
    private static void oxidizables() {
        registerOxidizableBlockPair(ModBlocks.SMALL_CANDELABRA.block, ModBlocks.SMALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(ModBlocks.SMALL_CANDELABRA_EXPOSED.block, ModBlocks.SMALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(ModBlocks.SMALL_CANDELABRA_WEATHERED.block, ModBlocks.SMALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(ModBlocks.SMALL_CANDELABRA.block, ModBlocks.WAXED_SMALL_CANDELABRA.block);
        registerWaxableBlockPair(ModBlocks.SMALL_CANDELABRA_EXPOSED.block, ModBlocks.WAXED_SMALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(ModBlocks.SMALL_CANDELABRA_WEATHERED.block, ModBlocks.WAXED_SMALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(ModBlocks.SMALL_CANDELABRA_OXIDIZED.block, ModBlocks.WAXED_SMALL_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(ModBlocks.MEDIUM_CANDELABRA.block, ModBlocks.MEDIUM_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(ModBlocks.MEDIUM_CANDELABRA_EXPOSED.block, ModBlocks.MEDIUM_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(ModBlocks.MEDIUM_CANDELABRA_WEATHERED.block, ModBlocks.MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(ModBlocks.MEDIUM_CANDELABRA.block, ModBlocks.WAXED_MEDIUM_CANDELABRA.block);
        registerWaxableBlockPair(ModBlocks.MEDIUM_CANDELABRA_EXPOSED.block, ModBlocks.WAXED_MEDIUM_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(ModBlocks.MEDIUM_CANDELABRA_WEATHERED.block, ModBlocks.WAXED_MEDIUM_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(ModBlocks.MEDIUM_CANDELABRA_OXIDIZED.block, ModBlocks.WAXED_MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(ModBlocks.LARGE_CANDELABRA.block, ModBlocks.LARGE_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(ModBlocks.LARGE_CANDELABRA_EXPOSED.block, ModBlocks.LARGE_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(ModBlocks.LARGE_CANDELABRA_WEATHERED.block, ModBlocks.LARGE_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(ModBlocks.LARGE_CANDELABRA.block, ModBlocks.WAXED_LARGE_CANDELABRA.block);
        registerWaxableBlockPair(ModBlocks.LARGE_CANDELABRA_EXPOSED.block, ModBlocks.WAXED_LARGE_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(ModBlocks.LARGE_CANDELABRA_WEATHERED.block, ModBlocks.WAXED_LARGE_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(ModBlocks.LARGE_CANDELABRA_OXIDIZED.block, ModBlocks.WAXED_LARGE_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(ModBlocks.WALL_CANDELABRA.block, ModBlocks.WALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(ModBlocks.WALL_CANDELABRA_EXPOSED.block, ModBlocks.WALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(ModBlocks.WALL_CANDELABRA_WEATHERED.block, ModBlocks.WALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(ModBlocks.WALL_CANDELABRA.block, ModBlocks.WAXED_WALL_CANDELABRA.block);
        registerWaxableBlockPair(ModBlocks.WALL_CANDELABRA_EXPOSED.block, ModBlocks.WAXED_WALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(ModBlocks.WALL_CANDELABRA_WEATHERED.block, ModBlocks.WAXED_WALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(ModBlocks.WALL_CANDELABRA_OXIDIZED.block, ModBlocks.WAXED_WALL_CANDELABRA_OXIDIZED.block);
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
    
    private static void putStrip(BlockConvertible input, BlockConvertible stripped) {
        StrippableBlockRegistry.register(input.asBlock(), stripped.asBlock());
    }
    
    private static void putCompost(ItemConvertible item, Float chance) {
        CompostingChanceRegistry.INSTANCE.add(item, chance);
    }
    
    private static void putFlammable(BlockConvertible block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block.asBlock(), burn, spread);;
    }
    
    private static void putFuels(ItemConvertible item, Integer tick) {
        FuelRegistry.INSTANCE.add(item, tick);
    }
    
    private static void putFuels(TagKey<Item> tag, Integer tick) {
        FuelRegistry.INSTANCE.add(tag, tick);
    }
}
