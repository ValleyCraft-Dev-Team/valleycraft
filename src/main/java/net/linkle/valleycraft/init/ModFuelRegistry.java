package net.linkle.valleycraft.init;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;

public class ModFuelRegistry {

    public static void registerModFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ItemsModded.PUFF_BALL, 100);
        registry.add(ItemsModded.CLOTH, 100);
        registry.add(ItemsModded.PLANT_FIBER_CANVAS, 100);
        registry.add(ItemsModded.PLANT_FIBER_STRING, 100);
        registry.add(ItemsModded.FIBER, 100);
        registry.add(ItemsModded.DRIED_FIBER, 100);
        registry.add(ItemsModded.PLANK, 150);
        registry.add(FoodIngredients.FIRE_PEPPER, 50);
        registry.add(ItemsModded.HANDLE, 250);
        registry.add(ItemsModded.REINFORCED_HANDLE, 250);
        registry.add(ItemsModded.STURDY_HANDLE, 250);
        registry.add(ItemsModded.ANTHRACITE, 1600);
        registry.add(BlocksModded.ANTHRACITE_BLOCK, 16000);
        registry.add(ItemsModded.BRIMSTONE_SHARD, 800);
        registry.add(Items.BLAZE_POWDER, 1200);
        registry.add(ItemsModded.STRANGE_CATALYST, 40000);
        registry.add(ItemsModded.THERMAL_BLAZE_CORE, 4000);

        registry.add(Tools.KNIFE_WOODEN, 200);
        registry.add(Tools.GREATSWORD_WOODEN, 200);
        registry.add(Tools.TRAVELER_WOODEN, 200);
        registry.add(Tools.DAGGER_WOODEN, 200);
        registry.add(Tools.SCYTHE_WOODEN, 200);
        registry.add(Tools.WOODCUTTER_AXE_WOODEN, 200);
        registry.add(Tools.HATCHET_WOODEN, 200);
        registry.add(Tools.WOODEN_OAR, 200);
        registry.add(Tools.BRANCH, 400);
        registry.add(Tools.WOODEN_STAFF, 300);
        registry.add(Tools.BAMBOO_STAFF, 300);
    }
}
