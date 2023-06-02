package net.linkle.valleycraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.linkle.valleycraft.effect.ModEffects;
import net.linkle.valleycraft.gen.feature.TreeConfigs;
import net.linkle.valleycraft.gen.feature.VegetationPlaced;
import net.linkle.valleycraft.gen.foliage.ModFoliagePlacerType;
import net.linkle.valleycraft.init.*;
import net.linkle.valleycraft.network.ServerNetwork;
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

		// Keep these inits above the blocks so the creative inventory stays sorted properly.
		ItemsModded.initialize();
			//initializes food items and misc items
		Fishing.initialize();
			//initializes fish bucket items
		Tools.initialize();
		Armors.initialize();

	    Groups.initialize();
		BlocksNatural.initialize();
		BlockEntities.initialize();
		Fluids.initialize();
		BlocksModded.initialize();

		Contents.initialize();
		ModFoliagePlacerType.initialize();
		TreeConfigs.initialize();
		VegetationPlaced.initialize();
		//GensModded.initialize();
		
		Particles.initialize();
		Sounds.initialize();
		Entities.initialize();
		ModFluidTags.initialize();
		ModLootTables.initialize();
		Events.initialize();

		ModEffects.initialize();
		Potions.initialize();
		ModVillagers.registerVillagers();
		CustomTradeRegistry.setupTrades();
		ServerNetwork.initialize();
	}
	
	public static Identifier makeId(String id) {
	    return new Identifier(ID, id);
	}
	
	public static String toId(String id) {
	    return ID + ':' + id;
	}
}
