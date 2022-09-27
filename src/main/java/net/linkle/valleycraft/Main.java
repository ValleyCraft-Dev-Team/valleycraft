package net.linkle.valleycraft;

import net.fabricmc.api.ModInitializer;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.fluid.ModFluids;
import net.linkle.valleycraft.gen.features.TreeConfigFeatures;
import net.linkle.valleycraft.init.*;
import net.linkle.valleycraft.potion.ModPotions;
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
		ModBlocks.initialize();
		ModFluids.initialize();
		ModItems.initialize();
		ModTools.initialize();
		
		Contents.initialize();
		TreeConfigFeatures.initialize();
		
		ModParticles.initialize();
		ModSounds.initialize();
		ModEntities.initialize();
		ModPaintings.initialize();

		ModEffects.registerEffects();
		ModPotions.registerPotions();
	}
	
	public static Identifier makeId(String id) {
	    return new Identifier(ID, id);
	}
}
