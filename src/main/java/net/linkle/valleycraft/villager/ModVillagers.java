package net.linkle.valleycraft.villager;

import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.util.Identifier;

import com.google.common.collect.ImmutableSet;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.BlocksModded;
import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    /** this code is held together by rubber bands and rusty paper clips. please do NOT CHANGE IT **/

    //can generate in stables
    public static final PointOfInterestType STABLEHAND_POI = registerPOI("stablehand_poi", BlocksModded.STABLEHAND_STATION.block);
    public static final VillagerProfession STABLEHAND = registerPro("stablehand", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "stablehand_poi")));

    public static final PointOfInterestType INNKEEPER_POI = registerPOI("innkeeper_poi", BlocksModded.KEG.block);
    public static final VillagerProfession INNKEEPER = registerPro("innkeeper", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "innkeeper_poi")));

    //can generate alone
    public static final PointOfInterestType LUMBERJACK_POI = registerPOI("lumberjack_poi", BlocksModded.LUMBERJACK_STATION.block);
    public static final VillagerProfession LUMBERJACK = registerPro("lumberjack", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "lumberjack_poi")));

    //can generate in villages
    public static final PointOfInterestType COOK_POI = registerPOI("cook_poi", BlocksModded.BRICK_STOVE.block);
    public static final VillagerProfession COOK = registerPro("cook", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "cook_poi")));

    public static final PointOfInterestType BEEKEEPER_POI = registerPOI("beekeeper_poi", BlocksModded.BEEKEEPER_STATION.block);
    public static final VillagerProfession BEEKEEPER = registerPro("beekeeper",RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "beekeeper_poi")));

    public static final PointOfInterestType GARDENER_POI = registerPOI("gardener_poi", BlocksModded.GARDENER_STATION.block);
    public static final VillagerProfession GARDENER = registerPro("gardener",RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "gardener_poi")));

    public static final PointOfInterestType STOREKEEP_POI = registerPOI("storekeeper_poi", BlocksModded.STOREKEEPS_COUNTER.block);
    public static final VillagerProfession STOREKEEP = registerPro("storekeeper", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "storekeeper_poi")));

    //can generate in mining camps
    public static final PointOfInterestType MINER_POI = registerPOI("miner_poi", BlocksModded.MINER_STATION.block);
    public static final VillagerProfession MINER = registerPro("miner", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "miner_poi")));

    public static final VillagerProfession registerPro(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(Main.ID, name), VillagerProfessionBuilder.create().id(new Identifier(Main.ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER).build());
    }

    public static final PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Main.ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }
    public static void registerVillagers() {
        Main.LOGGER.debug("Registering villagers for " + Main.ID);
        //looks like it just outputs but its actually needed here DO NOT REMOVE IT!//
    }
}
