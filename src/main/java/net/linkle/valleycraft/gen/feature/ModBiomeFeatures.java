package net.linkle.valleycraft.gen.feature;

import net.linkle.valleycraft.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ModBiomeFeatures extends DefaultBiomeFeatures {
    public ModBiomeFeatures() {
    }

    /**biome categorized mob spawns**/

    public static void addWilderForestMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSurfaceRegionSnails(builder);
        addPerchForest(builder);
    }

    public static void addWilderRiverMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPerchRiver(builder);
        addStonerollerRiver(builder);
    }

    public static void addWilderMangroveMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPerchRiver(builder);
        addStonerollerRiver(builder);
    }

    public static void addWilderSwampMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPerchRiver(builder);
        addStonerollerRiver(builder);
    }

    public static void addWilderJungleMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPorgyJungle(builder);
        addPerchForest(builder);
        }

    public static void addWilderOceanMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSardines(builder);
    }

    public static void addWilderLukewarmOceanMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSardines(builder);
        addPorgyLukewarm(builder);
    }

    public static void addWilderWarmOceanMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSardines(builder);
    }

    public static void addWilderColdOceanMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSardines(builder);
    }

    public static void addWilderFrozenOceanMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSardines(builder);
    }

    public static void addWilderFrozenRiverMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPerchRiver(builder);
    }

    public static void addWilderAutumnalMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addPupkins(builder);
        addVanillaRabbits(builder);
        addVanillaChickens(builder);
    }

    public static void addWilderCaveMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addHostileCaveRegionFish(builder);
        addPassiveCaveRegionFish(builder);
        addCaveRegionSnails(builder);
    }

    public static void addWilderDeepDarkMobs(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addDeepDarkRegionSnails(builder);
    }

    /**region categorized mob spawns**/

    public static void addSurfaceRegionSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSnails(builder);
    }

    public static void addCaveRegionSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addCaveSnails(builder);
    }

    public static void addHostileCaveRegionFish(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addBoneFins(builder);
        addZods(builder);
    }

    public static void addPassiveCaveRegionFish(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addAbyssWatchers(builder);
    }

    public static void addDeepDarkRegionSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        addSculkSnails(builder);
    }

    /**individual mob spawns**/

    public static void addPupkins(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PUPKIN, 5, 1, 3));
    }

    public static void addVanillaRabbits(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 10, 2, 3));
    }

    public static void addVanillaChickens(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.CHICKEN, 10, 4, 4));
    }

    /** snails **/
    public static void addSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(ModEntityType.SNAIL, 10, 8, 8));
    }

    public static void addCaveSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(ModEntityType.CAVE_SNAIL, 10, 8, 8));
    }

    public static void addSculkSnails(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(ModEntityType.SCULK_SNAIL, 10, 8, 8));
    }

    /** fish **/
    public static void addSardines(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.SARDINE, 25, 5, 10));
    }

    public static void addPorgyLukewarm(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.RED_PORGY, 15, 3, 6));
    }

    public static void addPorgyJungle(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PERCH, 5, 3, 6));
    }

    public static void addStonerollerRiver(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.STONEROLLER_MINNOW, 8, 3, 8));
    }

    public static void addPerchRiver(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PERCH, 16, 3, 8));
    }

    public static void addPerchForest(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.PERCH, 5, 3, 6));
    }

    public static void addAbyssWatchers(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.UNDERGROUND_WATER_CREATURE, new SpawnSettings.SpawnEntry(ModEntityType.ABYSSWATCHER, 10, 1, 1));
    }

    /** hostile fish **/
    public static void addBoneFins(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntityType.BONEFIN, 100, 4, 4));
    }

    public static void addZods(net.minecraft.world.biome.SpawnSettings.Builder builder) {
        builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(ModEntityType.ZOD, 100, 4, 4));
    }
}
