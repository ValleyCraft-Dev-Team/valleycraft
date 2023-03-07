package net.linkle.valleycraft.init;

import static net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry.*;

import net.fabricmc.fabric.api.registry.*;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA.block, BlocksModded.SMALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA_EXPOSED.block, BlocksModded.SMALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.SMALL_CANDELABRA_WEATHERED.block, BlocksModded.SMALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA.block, BlocksModded.WAXED_SMALL_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_SMALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_SMALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.SMALL_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_SMALL_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA.block, BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block, BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block, BlocksModded.MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA.block, BlocksModded.WAXED_MEDIUM_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.MEDIUM_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_MEDIUM_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA.block, BlocksModded.LARGE_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA_EXPOSED.block, BlocksModded.LARGE_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.LARGE_CANDELABRA_WEATHERED.block, BlocksModded.LARGE_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA.block, BlocksModded.WAXED_LARGE_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_LARGE_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_LARGE_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.LARGE_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_LARGE_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA.block, BlocksModded.WALL_CANDELABRA_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA_EXPOSED.block, BlocksModded.WALL_CANDELABRA_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.WALL_CANDELABRA_WEATHERED.block, BlocksModded.WALL_CANDELABRA_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA.block, BlocksModded.WAXED_WALL_CANDELABRA.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_EXPOSED.block, BlocksModded.WAXED_WALL_CANDELABRA_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_WEATHERED.block, BlocksModded.WAXED_WALL_CANDELABRA_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.WALL_CANDELABRA_OXIDIZED.block, BlocksModded.WAXED_WALL_CANDELABRA_OXIDIZED.block);
        
        registerOxidizableBlockPair(BlocksModded.WASTEBIN.block, BlocksModded.WASTEBIN_EXPOSED.block);
        registerOxidizableBlockPair(BlocksModded.WASTEBIN_EXPOSED.block, BlocksModded.WASTEBIN_WEATHERED.block);
        registerOxidizableBlockPair(BlocksModded.WASTEBIN_WEATHERED.block, BlocksModded.WASTEBIN_OXIDIZED.block);
        
        registerWaxableBlockPair(BlocksModded.WASTEBIN.block, BlocksModded.WAXED_WASTEBIN.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_EXPOSED.block, BlocksModded.WAXED_WASTEBIN_EXPOSED.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_WEATHERED.block, BlocksModded.WAXED_WASTEBIN_WEATHERED.block);
        registerWaxableBlockPair(BlocksModded.WASTEBIN_OXIDIZED.block, BlocksModded.WAXED_WASTEBIN_OXIDIZED.block);
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
        putFuels(BlocksModded.CHARCOAL_BLOCK, 16000);
        putFuels(BlocksNatural.GLOW_CAP, 800);
        putFuels(BlocksNatural.GLOW_CAP_CLUSTER, 2400);
        putFuels(BlocksNatural.CATTAILS, 100);
        putFuels(ItemsModded.PUFF_BALL, 100);
        putFuels(ItemsModded.CLOTH, 100);
        putFuels(ItemsModded.PLANT_FIBER_CANVAS, 100);
        putFuels(ItemsModded.PLANT_FIBER_STRING, 100);
        putFuels(ItemsModded.FIBER, 100);
        putFuels(ItemsModded.DRIED_FIBER, 100);
        putFuels(ItemsModded.PLANK, 150);
        putFuels(FoodIngredients.FIRE_PEPPER, 50);
        putFuels(ItemsModded.HANDLE, 250);
        putFuels(ItemsModded.REINFORCED_HANDLE, 250);
        putFuels(ItemsModded.STURDY_HANDLE, 250);
        putFuels(ItemsModded.COAL_NUGGET, 400);
        putFuels(ItemsModded.ANTHRACITE, 1600);
        putFuels(BlocksModded.ANTHRACITE_BLOCK, 16000);
        putFuels(ItemsModded.BRIMSTONE_SHARD, 800);
        putFuels(Items.BLAZE_POWDER, 1200);
        putFuels(Items.NETHER_STAR, 32000);
        putFuels(ItemsModded.STRANGE_CATALYST, 32000);
        putFuels(ItemsModded.THERMAL_BLAZE_CORE, 4000);

        putFuels(Tools.KNIFE_WOODEN, 200);
        putFuels(Tools.GREATSWORD_WOODEN, 200);
        putFuels(Tools.TRAVELER_WOODEN, 200);
        putFuels(Tools.DAGGER_WOODEN, 200);
        putFuels(Tools.SCYTHE_WOODEN, 200);
        putFuels(Tools.WOODCUTTER_AXE_WOODEN, 200);
        putFuels(Tools.HATCHET_WOODEN, 200);
        putFuels(Tools.WOODEN_OAR, 200);
        putFuels(Tools.BRANCH, 400);
        putFuels(Tools.WOODEN_STAFF, 300);
        putFuels(Tools.BAMBOO_STAFF, 300);
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
