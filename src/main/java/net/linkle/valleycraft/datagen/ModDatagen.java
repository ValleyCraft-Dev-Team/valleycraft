package net.linkle.valleycraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.linkle.valleycraft.datagen.api.LanguageDataProvider;
import net.linkle.valleycraft.init.ModBlocks;

public class ModDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ValleyModelGenerator::new);
        //fabricDataGenerator.addProvider(ValleyLanguageDataProvider::new); // disabled for now to fix the error.
    }

    private static class ValleyLanguageDataProvider extends LanguageDataProvider {
        protected ValleyLanguageDataProvider(FabricDataGenerator dataGenerator) {
            super(dataGenerator, "en_us");
        }

        @Override
        protected void registerTranslations() {
            // Potted Flowers
            this.addBlock(ModBlocks.POTTED_BLACK_DAHLIA.block, "Potted Black Dahlia");
            this.addBlock(ModBlocks.POTTED_FLUFFY_DANDELION.block, "Potted Fluffy Dandelion");
            this.addBlock(ModBlocks.POTTED_FADED_SOUL_ROSE.block, "Potted Faded Soul Rose");
            this.addBlock(ModBlocks.POTTED_HONEYCLUSTER.block, "Potted Honeycluster");
            this.addBlock(ModBlocks.POTTED_LAVENDER.block, "Potted Lavender");
            this.addBlock(ModBlocks.POTTED_ORANGE_BEAUTY.block, "Potted Orange Beauty");
            this.addBlock(ModBlocks.POTTED_POISON_BLOSSOM.block, "Potted Poison Blossom");
            this.addBlock(ModBlocks.POTTED_PURPLE_TULIP.block, "Potted Purple Tulip");
            this.addBlock(ModBlocks.POTTED_YELLOW_TULIP.block, "Potted Yellow Tulip");
            this.addBlock(ModBlocks.POTTED_LIGHT_BLUE_TULIP.block, "Potted Light Blue Tulip");
            this.addBlock(ModBlocks.POTTED_BLACK_TULIP.block, "Potted Black Tulip");
            this.addBlock(ModBlocks.POTTED_GODDESS_LILY.block, "Potted Goddess Lily");
            this.addBlock(ModBlocks.POTTED_RED_LUPINE.block, "Potted Red Lupine");
            this.addBlock(ModBlocks.POTTED_YELLOW_LUPINE.block, "Potted Yellow Lupine");
            this.addBlock(ModBlocks.POTTED_PINK_LUPINE.block, "Potted Pink Lupine");
            this.addBlock(ModBlocks.POTTED_ORANGE_POPPY.block, "Potted Orange Poppy");
            this.addBlock(ModBlocks.POTTED_YELLOW_POPPY.block, "Potted Yellow Poppy");
            this.addBlock(ModBlocks.POTTED_WHITE_POPPY.block, "Potted White Poppy");
            this.addBlock(ModBlocks.POTTED_SNOWFLOWER.block, "Potted Snowflower");

            // Potted Fungi
            this.addBlock(ModBlocks.POTTED_GLOW_CAP.block, "Potted Glowcap");
            this.addBlock(ModBlocks.POTTED_JUNGLE_CAP.block, "Potted Orange Mushroom");
            this.addBlock(ModBlocks.POTTED_SOULSPORE.block, "Potted Soulspore Mushroom");
            this.addBlock(ModBlocks.POTTED_MOREL.block, "Potted Morel");
            this.addBlock(ModBlocks.POTTED_GOOP_CAP.block, "Potted Goopshroom");
            this.addBlock(ModBlocks.POTTED_GILDED_CAP.block, "Potted Gildedshroom");
            this.addBlock(ModBlocks.POTTED_IRONSHROOM.block, "Potted Patinacap");

            // Potted Saplings
            this.addBlock(ModBlocks.POTTED_DRIED_SAPLING.block, "Potted Dried Sapling");
            this.addBlock(ModBlocks.POTTED_MAMON_SAPLING.block, "Potted Amberblossom Sapling");
            this.addBlock(ModBlocks.POTTED_APPLE_SAPLING.block, "Potted Apple Sapling");
            this.addBlock(ModBlocks.POTTED_WARM_BIRCH_SAPLING.block, "Potted Warm Birch Sapling");

            // Other potted plants
            this.addBlock(ModBlocks.POTTED_FOXTAIL_FERN.block, "Potted Foxtail Fern");
            this.addBlock(ModBlocks.POTTED_LEATHERLEAF_FERN.block, "Potted Leatherleaf Fern");
            this.addBlock(ModBlocks.POTTED_MOSS_SPROUTLET.block, "Potted Moss Sproutlet");
            this.addBlock(ModBlocks.POTTED_ORANGE_FERN.block, "Potted Orange Fern");
            this.addBlock(ModBlocks.POTTED_SPROUT.block, "Potted Sproutlet");
            this.addBlock(ModBlocks.POTTED_DESERT_SHRUB.block, "Potted Desert Shrub");
            this.addBlock(ModBlocks.POTTED_LUSH_BUSH.block, "Potted Lush Creosote Bush");

            this.addBlock(ModBlocks.POTTED_FLOWERING_CACTUS.block, "Potted Flowering Cactus");
            this.addBlock(ModBlocks.POTTED_JUNGLE_BUSH.block, "Potted Plumbago Bush");
            this.addBlock(ModBlocks.POTTED_PANFLOWERS.block, "Potted Panflowers");
            this.addBlock(ModBlocks.POTTED_FROSTFERN.block, "Potted Frostfern");
            this.addBlock(ModBlocks.POTTED_CLARET_LEAF.block, "Potted Arterium Claret Leaf");
            this.addBlock(ModBlocks.POTTED_WEEPING_GHOST_WILLOW.block, "Potted Weeping Cave Willow");
            this.addBlock(ModBlocks.POTTED_BONE_WEED.block, "Potted Bone Weed");
        }
    }
}