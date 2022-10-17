package net.linkle.valleycraft;

import net.fabricmc.api.ModInitializer;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.gen.features.TreeConfigFeatures;
import net.linkle.valleycraft.init.*;
import net.linkle.valleycraft.tags.ModFluidTags;
import net.linkle.valleycraft.tool.ModToolMaterials;
import net.linkle.valleycraft.tool.ModToolMaterialsExtended;
import net.linkle.valleycraft.villager.CustomTradeRegistry;
import net.linkle.valleycraft.villager.ModVillagers;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		TreeConfigFeatures.initialize();
		
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
	
	public String toId(String id) {
	    return ID + ':' + id;
	}
}
