package net.linkle.valleycraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.init.ModBlocks;
import net.linkle.valleycraft.init.NaturalBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.util.Identifier;

class ValleyModelGenerator extends FabricModelProvider {
    
    ValleyModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        
        // Doors
        generator.registerDoor(ModBlocks.APPLE_DOOR.block);
        generator.registerDoor(ModBlocks.MAMON_DOOR.block);
        generator.registerDoor(ModBlocks.WATTLE_DOOR.block);
        generator.registerDoor(ModBlocks.GLASS_DOOR.block);
        generator.registerDoor(ModBlocks.TINTED_GLASS_DOOR.block);
        
        // Potted flowers
        generator.registerFlowerPotPlant(NaturalBlocks.BLACK_DAHLIA.block, ModBlocks.POTTED_BLACK_DAHLIA.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.FLUFFY_DANDELION.block, ModBlocks.POTTED_FLUFFY_DANDELION.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.FADED_SOUL_ROSE.block, ModBlocks.POTTED_FADED_SOUL_ROSE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.HONEYCLUSTER.block, ModBlocks.POTTED_HONEYCLUSTER.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.LAVENDER.block, ModBlocks.POTTED_LAVENDER.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.ORANGE_BEAUTY.block, ModBlocks.POTTED_ORANGE_BEAUTY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.POISON_BLOSSOM.block, ModBlocks.POTTED_POISON_BLOSSOM.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.PURPLE_TULIP.block, ModBlocks.POTTED_PURPLE_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.YELLOW_TULIP.block, ModBlocks.POTTED_YELLOW_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.LIGHT_BLUE_TULIP.block, ModBlocks.POTTED_LIGHT_BLUE_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.BLACK_TULIP.block, ModBlocks.POTTED_BLACK_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.GODDESS_LILY.block, ModBlocks.POTTED_GODDESS_LILY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.RED_LUPINE.block, ModBlocks.POTTED_RED_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.YELLOW_LUPINE.block, ModBlocks.POTTED_YELLOW_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.PINK_LUPINE.block, ModBlocks.POTTED_PINK_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.ORANGE_POPPY.block, ModBlocks.POTTED_ORANGE_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.YELLOW_POPPY.block, ModBlocks.POTTED_YELLOW_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.WHITE_POPPY.block, ModBlocks.POTTED_WHITE_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.SNOWFLOWER.block, ModBlocks.POTTED_SNOWFLOWER.block, TintType.NOT_TINTED);

        // Potted fungi
        generator.registerFlowerPotPlant(NaturalBlocks.GLOW_CAP.block, ModBlocks.POTTED_GLOW_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.JUNGLE_CAP.block, ModBlocks.POTTED_JUNGLE_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.SOULSPORE_SINGLE.block, ModBlocks.POTTED_SOULSPORE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.MOREL.block, ModBlocks.POTTED_MOREL.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.GOOP_CAP.block, ModBlocks.POTTED_GOOP_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.GILDED_CAP.block, ModBlocks.POTTED_GILDED_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.IRONSHROOM.block, ModBlocks.POTTED_IRONSHROOM.block, TintType.NOT_TINTED);

        // Potted saplings
        generator.registerFlowerPotPlant(NaturalBlocks.DRIED_SAPLING.block, ModBlocks.POTTED_DRIED_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.MAMON_SAPLING.block, ModBlocks.POTTED_MAMON_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.APPLE_SAPLING.block, ModBlocks.POTTED_APPLE_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.WARM_BIRCH_SAPLING.block, ModBlocks.POTTED_WARM_BIRCH_SAPLING.block, TintType.NOT_TINTED);

        // Other potted plants (that don't use custom models; see ModBlocks for which ones do)
        generator.registerFlowerPotPlant(NaturalBlocks.FOXTAIL_FERN.block, ModBlocks.POTTED_FOXTAIL_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.LEATHERLEAF_FERN.block, ModBlocks.POTTED_LEATHERLEAF_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.MOSS_SPROUTLET.block, ModBlocks.POTTED_MOSS_SPROUTLET.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.ORANGE_FERN.block, ModBlocks.POTTED_ORANGE_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.SPROUT.block, ModBlocks.POTTED_SPROUT.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.DESERT_SHRUB.block, ModBlocks.POTTED_DESERT_SHRUB.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(NaturalBlocks.LUSH_BUSH.block, ModBlocks.POTTED_LUSH_BUSH.block, TintType.NOT_TINTED);

        // Smooth Carmine
        TextureMap carmineTextureMap = new TextureMap()
                .put(TextureKey.SIDE, Main.makeId("block/carmine_smooth"))
                .put(TextureKey.END,  Main.makeId("block/carmine_smooth"))
                .put(TextureKey.WALL, Main.makeId("block/carmine_smooth"));

        stairs(ModBlocks.CARMINE_SMOOTH_STAIRS.block, carmineTextureMap, generator);
        slab(ModBlocks.CARMINE_SMOOTH_SLAB.block, ModBlocks.CARMINE_SMOOTH.block, carmineTextureMap, generator);
        wall(ModBlocks.CARMINE_SMOOTH_WALL.block, carmineTextureMap, generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // ...
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a stairs block.~
     * @param block The stairs block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void stairs(Block block, TextureMap texture, BlockStateModelGenerator generator) {
        var stairsInner = Models.INNER_STAIRS.upload(block, texture, generator.modelCollector);
        var stairsStraight = Models.STAIRS.upload(block, texture, generator.modelCollector);
        var stairsOuter = Models.OUTER_STAIRS.upload(block, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(block, stairsInner, stairsStraight, stairsOuter));
        generator.registerParentedItemModel(block, stairsStraight);
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a slab block.~
     * @param slabBlock The slab block. Find this in ModBlocks or a similar block-initializing class.
     * @param fullBlock The matching full block.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void slab(Block slabBlock, Block fullBlock, TextureMap texture, BlockStateModelGenerator generator) {
        var slabUpper = Models.SLAB_TOP.upload(slabBlock, texture, generator.modelCollector);
        var slabLower = Models.SLAB.upload(slabBlock, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, slabLower, slabUpper, ModelIds.getBlockModelId(fullBlock)));
        generator.registerParentedItemModel(slabBlock, slabLower);
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a wall block.~
     * @param wallBlock The wall block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void wall(Block wallBlock, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.TEMPLATE_WALL_POST.upload(wallBlock, texture, generator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_WALL_SIDE.upload(wallBlock, texture, generator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_WALL_SIDE_TALL.upload(wallBlock, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wallBlock, identifier, identifier2, identifier3));
        Identifier identifier4 = Models.WALL_INVENTORY.upload(wallBlock, texture, generator.modelCollector);
        generator.registerParentedItemModel(wallBlock, identifier4);
    }
}