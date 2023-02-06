package net.linkle.valleycraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        generator.addProvider(ValleyModelGenerator::new);
        generator.addProvider(ValleyRecipeGenerator::new);
        generator.addProvider(ValleyLootGenerator::new);
    }
}