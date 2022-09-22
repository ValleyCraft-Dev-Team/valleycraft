package net.linkle.valleycraft;

import net.fabricmc.api.ModInitializer;
import net.linkle.valleycraft.gen.features.TreeConfigFeatures;
import net.linkle.valleycraft.init.Contents;
import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.init.ModGroups;
import net.linkle.valleycraft.init.ModItems;
import net.linkle.valleycraft.init.ModParticles;
import net.linkle.valleycraft.init.ModSounds;
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
		ModItems.initialize();
		
		Contents.initialize();
		TreeConfigFeatures.initialize();
		
		ModParticles.initialize();
		ModSounds.initialize();
	}
	
	public static Identifier makeId(String id) {
	    return new Identifier(ID, id);
	}
}