package net.linkle.valleycraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.linkle.valleycraft.gen.foliage.ModFoliagePlacerType;
import net.linkle.valleycraft.init.*;
import net.linkle.valleycraft.tags.ModFluidTags;
import net.linkle.valleycraft.villager.CustomTradeRegistry;
import net.linkle.valleycraft.villager.ModVillagers;
import net.minecraft.util.Identifier;

/** The main ValleyCraft mod entry. */
public class Main implements ModInitializer {
    public static final String ID = "valleycraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {
	    Config.initialize();

	    ModGroups.initialize();
		NaturalBlocks.initialize();
		ModBlockEntities.initialize();
		ModFluids.initialize();
		ModItems.initialize();
		ModFishing.initialize();
		ModTools.initialize();
		ModBlocks.initialize();

		Contents.initialize();
		ModFoliagePlacerType.initialize();
		TreeConfigs.initialize();
		ModBiomes.initialize();
		
		ModParticles.initialize();
		ModSounds.initialize();
		ModEntityType.initialize();
		ModPaintings.initialize();
		ModFluidTags.initialize();

		ModEffects.initialize();
		ModPotions.initialize();

		ModVillagers.initialize();
		CustomTradeRegistry.setupTrades();
	}
	
	public static Identifier makeId(String id) {
	    return new Identifier(ID, id);
	}
	
	public static String toId(String id) {
	    return ID + ':' + id;
	}
}
