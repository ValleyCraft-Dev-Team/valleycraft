package net.linkle.valleycraft.villager;

import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableSet;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    /** this code is held together by rubber bands and rusty paper clips. please do NOT CHANGE IT **/

    //can generate in stables
    public static final PointOfInterestType STABLEHAND_POI = registerPOI("stablehand_poi", ModBlocks.STABLEHAND_STATION.block);
    public static final VillagerProfession STABLEHAND = registerPro("stablehand", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "stablehand_poi")));

    public static final PointOfInterestType INNKEEPER_POI = registerPOI("innkeeper_poi", ModBlocks.STOVE.block);
    public static final VillagerProfession INNKEEPER = registerPro("innkeeper", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "innkeeper_poi")));

    //can generate alone
    public static final PointOfInterestType LUMBERJACK_POI = registerPOI("lumberjack_poi", ModBlocks.LUMBERJACK_STATION.block);
    public static final VillagerProfession LUMBERJACK = registerPro("lumberjack", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "lumberjack_poi")));

    //can generate in diaspora camps
    public static final PointOfInterestType DIASPORA_POI = registerPOI("diaspora_poi", ModBlocks.CAMPFIRE_POT.block);
    public static final VillagerProfession DIASPORA = registerPro("diaspora", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "diaspora_poi")));

    //can generate in villages
    public static final PointOfInterestType COOK_POI = registerPOI("cook_poi", ModBlocks.KEG.block);
    public static final VillagerProfession COOK = registerPro("cook", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "cook_poi")));

    public static final PointOfInterestType BEEKEEPER_POI = registerPOI("beekeeper_poi", ModBlocks.BEEKEEPER_STATION.block);
    public static final VillagerProfession BEEKEEPER = registerPro("beekeeper",RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "beekeeper_poi")));

    public static final PointOfInterestType HUNTER_POI = registerPOI("hunter_poi", ModBlocks.HUNTING_STATION.block);
    public static final VillagerProfession HUNTER = registerPro("hunter", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "hunter_poi")));

    //can generate in mining camps
    public static final PointOfInterestType MINER_POI = registerPOI("miner_poi", ModBlocks.MINER_STATION.block);
    public static final VillagerProfession MINER = registerPro("miner", RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Main.ID, "miner_poi")));

    public static final VillagerProfession registerPro(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(Main.ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(Main.ID, name)).workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER).build());
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
