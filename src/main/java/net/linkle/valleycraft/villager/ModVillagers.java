package net.linkle.valleycraft.villager;

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

    public static final PointOfInterestType STABLEHAND_POI = registerPOI("stablehand_poi", 1, 1, ModBlocks.STABLEHAND);
    public static final VillagerProfession STABLEHAND = registerPro("stablehand", "stablehand_poi", SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);

    public static final PointOfInterestType INNKEEPER_POI = registerPOI("innkeeper_poi", 1, 1, ModBlocks.STOVE);
    public static final VillagerProfession INNKEEPER = registerPro("innkeeper", "innkeeper_poi", SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);

    public static final PointOfInterestType LUMBERJACK_POI = registerPOI("lumberjack_poi", 1, 1, ModBlocks.LUMBERJACK_STATION);
    public static final VillagerProfession LUMBERJACK = registerPro("lumberjack", "lumberjack_poi", SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);

    public static final PointOfInterestType DIASPORA_POI = registerPOI("diaspora_poi", 1, 1, ModBlocks.CAMPFIRE_POT);
    public static final VillagerProfession DIASPORA = registerPro("diaspora", "diaspora_poi", SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER);

    private static VillagerProfession registerPro(String name, String heldWorkstation, @Nullable SoundEvent workSound) {
        return registerPro(name, heldWorkstation, heldWorkstation, workSound);
    }

    private static VillagerProfession registerPro(String name, String heldWorkstation, String acquirableWorkstation, @Nullable SoundEvent workSound) {
        return registerPro(name, heldWorkstation, acquirableWorkstation, ImmutableSet.of(), ImmutableSet.of(), workSound);
    }

    private static VillagerProfession registerPro(String name, String heldWorkstation, ImmutableSet<Item> gatherableItems, ImmutableSet<Block> secondaryJobSites, @Nullable SoundEvent workSound) {
        return registerPro(name, heldWorkstation, heldWorkstation, gatherableItems, secondaryJobSites, workSound);
    }

    private static VillagerProfession registerPro(String name, String heldWorkstation, String acquirableWorkstation, ImmutableSet<Item> gatherableItems, ImmutableSet<Block> secondaryJobSites, @Nullable SoundEvent workSound) {
        var key1 = RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, Main.makeId(heldWorkstation));
        var key2 = RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, Main.makeId(acquirableWorkstation));
        return Registry.register(Registry.VILLAGER_PROFESSION, Main.makeId(name), new VillagerProfession(Main.ID + ":" + name, entry -> entry.matchesKey(key1), entry -> entry.matchesKey(key2), gatherableItems, secondaryJobSites, workSound));
    }

    /** @see PointOfInterestHelper#register(net.minecraft.util.Identifier, int, int, Block...) */
    private static PointOfInterestType registerPOI(String name, int ticketCount, int searchDistance, Block... block) {
        return PointOfInterestHelper.register(Main.makeId(name), ticketCount, searchDistance, block);
    }

    public static void initialize() {
        
    }
}
