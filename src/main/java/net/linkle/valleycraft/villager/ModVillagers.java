package net.linkle.valleycraft.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.mixin.object.builder.PointOfInterestTypeAccessor;
import net.fabricmc.fabric.mixin.object.builder.VillagerProfessionAccessor;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final PointOfInterestType STABLEHAND_POI = registerPOI( "stablehand_poi", ModBlocks.STABLEHAND);
    public static final VillagerProfession STABLEHAND = registerProfession("stablehand", STABLEHAND_POI);

    public static final PointOfInterestType INNKEEPER_POI = registerPOI( "innkeeper_poi", ModBlocks.STOVE);
    public static final VillagerProfession INNKEEPER = registerProfession("innkeeper", INNKEEPER_POI);

    public static final PointOfInterestType LUMBERJACK_POI = registerPOI( "lumberjack_poi", ModBlocks.LUMBERJACK_STATION);
    public static final VillagerProfession LUMBERJACK = registerProfession("lumberjack", LUMBERJACK_POI);

    public static VillagerProfession registerProfession(String name, PointOfInterestType type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(Main.ID, name),
                VillagerProfessionAccessor.create(name, type, ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.ENTITY_VILLAGER_WORK_LEATHERWORKER));
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return Registry.register(Registry.POINT_OF_INTEREST_TYPE, new Identifier(Main.ID, name),
                PointOfInterestTypeAccessor.callCreate(name, ImmutableSet.copyOf(block.getStateManager().getStates()), 1,1));
    }

    public static void setupPOIs() {
        PointOfInterestTypeAccessor.callSetup(STABLEHAND_POI);
        PointOfInterestTypeAccessor.callSetup(LUMBERJACK_POI);
        PointOfInterestTypeAccessor.callSetup(INNKEEPER_POI);
    }
}
