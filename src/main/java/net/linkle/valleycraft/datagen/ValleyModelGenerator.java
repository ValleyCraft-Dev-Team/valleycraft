package net.linkle.valleycraft.datagen;

import static net.linkle.valleycraft.init.ModBlocks.*;
import static net.linkle.valleycraft.init.ModNaturalBlocks.*;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.util.Identifier;

class ValleyModelGenerator extends FabricModelProvider {
    
    ValleyModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        TextureMap map;
        
        // Doors
        generator.registerDoor(APPLE_DOOR.block);
        generator.registerDoor(MAMON_DOOR.block);
        generator.registerDoor(CELESTIAL_DOOR.block);
        generator.registerDoor(ANCIENT_DOOR.block);
        generator.registerDoor(WATTLE_DOOR.block);
        generator.registerDoor(GLASS_DOOR.block);
        generator.registerDoor(TINTED_GLASS_DOOR.block);
        
        // Mamon
        map = textureAll(MAMON_PLANKS);
        generator.registerLog(MAMON_WOOD.block);
        generator.registerLog(STRIPPED_MAMON_WOOD.block);
        generator.registerLog(STRIPPED_MAMON_LOG.block);
        generator.registerLog(MAMON_LOG.block);
        generator.registerSimpleCubeAll(MAMON_PLANKS.block);
        generator.registerOrientableTrapdoor(MAMON_TRAPDOOR.block);
        slab(MAMON_SLAB.block, MAMON_PLANKS.block, map, generator);
        stairs(MAMON_STAIRS.block, map, generator);
        button(MAMON_BUTTON.block, map, generator);
        fence(MAMON_FENCE.block, map, generator);
        fenceGate(MAMON_FENCE_GATE.block, map, generator);
        pressurePlate(MAMON_PRESSURE_PLATE.block, map, generator);
        
        // Apple
        map = textureAll(APPLE_PLANKS);
        generator.registerLog(APPLE_WOOD.block);
        generator.registerLog(STRIPPED_APPLE_WOOD.block);
        generator.registerLog(STRIPPED_APPLE_LOG.block);
        generator.registerLog(APPLE_LOG.block);
        generator.registerSimpleCubeAll(APPLE_PLANKS.block);
        generator.registerOrientableTrapdoor(APPLE_TRAPDOOR.block);
        slab(APPLE_SLAB.block, APPLE_PLANKS.block, map, generator);
        stairs(APPLE_STAIRS.block, map, generator);
        button(APPLE_BUTTON.block, map, generator);
        fence(APPLE_FENCE.block, textureAll("apple_fence_planks"), generator);
        fenceGate(APPLE_FENCE_GATE.block, textureAll("apple_fence_planks"), generator);
        pressurePlate(APPLE_PRESSURE_PLATE.block, map, generator);
        
        // Ancient
        map = textureAll(ANCIENT_PLANKS);
        generator.registerLog(ANCIENT_WOOD.block);
        generator.registerLog(STRIPPED_ANCIENT_WOOD.block);
        generator.registerLog(STRIPPED_ANCIENT_LOG.block);
        generator.registerLog(ANCIENT_LOG.block);
        generator.registerOrientableTrapdoor(ANCIENT_TRAPDOOR.block);
        slab(ANCIENT_SLAB.block, ANCIENT_PLANKS.block, map, generator);
        stairs(ANCIENT_STAIRS.block, map, generator);
        button(ANCIENT_BUTTON.block, map, generator);
        fence(ANCIENT_FENCE.block, map, generator);
        fenceGate(ANCIENT_FENCE_GATE.block, map, generator);
        pressurePlate(ANCIENT_PRESSURE_PLATE.block, map, generator);
        
        // Celestial
        map = textureAll(CELESTIAL_PLANKS);
        generator.registerLog(CELESTIAL_WOOD.block);
        generator.registerLog(STRIPPED_CELESTIAL_WOOD.block);
        generator.registerLog(STRIPPED_CELESTIAL_LOG.block);
        generator.registerLog(CELESTIAL_LOG.block);
        generator.registerSimpleCubeAll(CELESTIAL_PLANKS.block);
        generator.registerOrientableTrapdoor(CELESTIAL_TRAPDOOR.block);
        slab(CELESTIAL_SLAB.block, CELESTIAL_PLANKS.block, map, generator);
        stairs(CELESTIAL_STAIRS.block, map, generator);
        button(CELESTIAL_BUTTON.block, map, generator);
        fence(CELESTIAL_FENCE.block, map, generator);
        fenceGate(CELESTIAL_FENCE_GATE.block, map, generator);
        pressurePlate(CELESTIAL_PRESSURE_PLATE.block, map, generator);
        
        // Tall plants
        generator.registerDoubleBlock(CATTAILS.block, TintType.NOT_TINTED);
        
        // Glass pane
        generator.registerGlassPane(TERRARIUM_GLASS.block, TERRARIUM_GLASS_PANE.block);
        generator.registerGlassPane(BRIMSTONE_GLASS.block, BRIMSTONE_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_GLASS.block, BEVELED_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_BRIMSTONE_GLASS.block, BEVELED_BRIMSTONE_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_TINTED_GLASS.block, BEVELED_TINTED_GLASS_PANE.block);
        generator.registerGlassPane(Blocks.TINTED_GLASS, TINTED_GLASS_PANE.block);
        generator.registerGlassPane(BLOCK_WATTLE_AND_GLASS.block, BLOCK_WATTLE_AND_GLASS_PANE.block);
        generator.registerGlassPane(BLOCK_WATTLE_AND_GLASS_CROSS.block, BLOCK_WATTLE_AND_GLASS_CROSS_PANE.block);
        generator.registerGlassPane(BLOCK_WATTLE_AND_GLASS_PLUS.block, BLOCK_WATTLE_AND_GLASS_PLUS_PANE.block);

        // Potted flowers
        generator.registerFlowerPotPlant(BLACK_DAHLIA.block, POTTED_BLACK_DAHLIA.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(FLUFFY_DANDELION.block, POTTED_FLUFFY_DANDELION.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(FADED_SOUL_ROSE.block, POTTED_FADED_SOUL_ROSE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(HONEYCLUSTER.block, POTTED_HONEYCLUSTER.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LAVENDER.block, POTTED_LAVENDER.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ORANGE_BEAUTY.block, POTTED_ORANGE_BEAUTY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(POISON_BLOSSOM.block, POTTED_POISON_BLOSSOM.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(PURPLE_TULIP.block, POTTED_PURPLE_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(YELLOW_TULIP.block, POTTED_YELLOW_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LIGHT_BLUE_TULIP.block, POTTED_LIGHT_BLUE_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(BLACK_TULIP.block, POTTED_BLACK_TULIP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(GODDESS_LILY.block, POTTED_GODDESS_LILY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(RED_LUPINE.block, POTTED_RED_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(YELLOW_LUPINE.block, POTTED_YELLOW_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(PINK_LUPINE.block, POTTED_PINK_LUPINE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ORANGE_POPPY.block, POTTED_ORANGE_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(YELLOW_POPPY.block, POTTED_YELLOW_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(WHITE_POPPY.block, POTTED_WHITE_POPPY.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(SNOWFLOWER.block, POTTED_SNOWFLOWER.block, TintType.NOT_TINTED);

        // Potted fungi
        generator.registerFlowerPotPlant(GLOW_CAP.block, POTTED_GLOW_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(JUNGLE_CAP.block, POTTED_JUNGLE_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(SOULSPORE_SINGLE.block, POTTED_SOULSPORE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(MOREL.block, POTTED_MOREL.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(GOOP_CAP.block, POTTED_GOOP_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(GILDED_CAP.block, POTTED_GILDED_CAP.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(IRONSHROOM.block, POTTED_IRONSHROOM.block, TintType.NOT_TINTED);

        // Potted saplings
        generator.registerFlowerPotPlant(DRIED_SAPLING.block, POTTED_DRIED_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(MAMON_SAPLING.block, POTTED_MAMON_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(APPLE_SAPLING.block, POTTED_APPLE_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(WARM_BIRCH_SAPLING.block, POTTED_WARM_BIRCH_SAPLING.block, TintType.NOT_TINTED);

        // Other potted plants (that don't use custom models; see ModBlocks for which ones do)
        generator.registerFlowerPotPlant(FOXTAIL_FERN.block, POTTED_FOXTAIL_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LEATHERLEAF_FERN.block, POTTED_LEATHERLEAF_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(MOSS_SPROUTLET.block, POTTED_MOSS_SPROUTLET.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ORANGE_FERN.block, POTTED_ORANGE_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(SPROUT.block, POTTED_SPROUT.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(DESERT_SHRUB.block, POTTED_DESERT_SHRUB.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LUSH_BUSH.block, POTTED_LUSH_BUSH.block, TintType.NOT_TINTED);
        
        // Potted glare
        generator.registerFlowerPotPlant(RED_GLARE.block, POTTED_RED_GLARE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(GREEN_GLARE.block, POTTED_GREEN_GLARE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(BLUE_GLARE.block, POTTED_BLUE_GLARE.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(PURPLE_GLARE.block, POTTED_PURPLE_GLARE.block, TintType.NOT_TINTED);

        // Smooth Carmine
        map = textureAll(CARMINE_SMOOTH);
        stairs(CARMINE_SMOOTH_STAIRS.block, map, generator);
        slab(CARMINE_SMOOTH_SLAB.block, CARMINE_SMOOTH.block, map, generator);
        wall(CARMINE_SMOOTH_WALL.block, map, generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Not needed for now.
    }
    
    Identifier texture(IdProvider block) {
        return texture(block, "");
    }
    
    Identifier texture(IdProvider block, String subfix) {
        var id = block.getId();
        return new Identifier(id.getNamespace(), "block/"+id.getPath()+subfix);
    }
    
    Identifier texture(String string) {
        return Main.makeId("block/"+string);
    }
    
    TextureMap textureAll(IdProvider block) {
        var id = texture(block);
        return TextureMap.sideEnd(id, id).put(TextureKey.WALL, id).put(TextureKey.ALL, id).put(TextureKey.TEXTURE, id);
    }
    
    TextureMap textureAll(String texture) {
        return textureAll(()->Main.makeId(texture));
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a stairs block.
     * @param stair The stairs block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void stairs(Block stair, TextureMap texture, BlockStateModelGenerator generator) {
        var stairsInner = Models.INNER_STAIRS.upload(stair, texture, generator.modelCollector);
        var stairsStraight = Models.STAIRS.upload(stair, texture, generator.modelCollector);
        var stairsOuter = Models.OUTER_STAIRS.upload(stair, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createStairsBlockState(stair, stairsInner, stairsStraight, stairsOuter));
        generator.registerParentedItemModel(stair, stairsStraight);
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a slab block.
     * @param slab The slab block. Find this in ModBlocks or a similar block-initializing class.
     * @param fullBlock The matching full block.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void slab(Block slab, Block fullBlock, TextureMap texture, BlockStateModelGenerator generator) {
        var slabUpper = Models.SLAB_TOP.upload(slab, texture, generator.modelCollector);
        var slabLower = Models.SLAB.upload(slab, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slab, slabLower, slabUpper, ModelIds.getBlockModelId(fullBlock)));
        generator.registerParentedItemModel(slab, slabLower);
    }

    /**
     * Datagens the blockstate, block model and item model .jsons needed for a wall block.
     * @param wall The wall block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. See my example with smooth carmine.
     * @param generator Just type `generator` for this.
     */
    void wall(Block wall, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.TEMPLATE_WALL_POST.upload(wall, texture, generator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_WALL_SIDE.upload(wall, texture, generator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(wall, identifier, identifier2, identifier3));
        Identifier identifier4 = Models.WALL_INVENTORY.upload(wall, texture, generator.modelCollector);
        generator.registerParentedItemModel(wall, identifier4);
    }
    
    /**
     * Datagens the blockstate, block model and item model .jsons needed for a button block.
     * @param button The button block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. Uses TEXTURE texture key.
     * @param generator Just type `generator` for this.
     */
    void button(Block button, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.BUTTON.upload(button, texture, generator.modelCollector);
        Identifier identifier2 = Models.BUTTON_PRESSED.upload(button, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(button, identifier, identifier2));
        Identifier identifier3 = Models.BUTTON_INVENTORY.upload(button, texture, generator.modelCollector);
        generator.registerParentedItemModel(button, identifier3);
    }
    
    /**
     * Datagens the blockstate, block model and item model .jsons needed for a fence block.
     * @param fence The fence block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. Uses TEXTURE texture key.
     * @param generator Just type `generator` for this.
     */
    void fence(Block fence, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.FENCE_POST.upload(fence, texture, generator.modelCollector);
        Identifier identifier2 = Models.FENCE_SIDE.upload(fence, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceBlockState(fence, identifier, identifier2));
        Identifier identifier3 = Models.FENCE_INVENTORY.upload(fence, texture, generator.modelCollector);
        generator.registerParentedItemModel(fence, identifier3);
    }
    
    /**
     * Datagens the blockstate, block model and item model .jsons needed for a fence gate block.
     * @param fenceGate The fence gate block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. Uses TEXTURE texture key.
     * @param generator Just type `generator` for this.
     */
    void fenceGate(Block fenceGate, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.TEMPLATE_FENCE_GATE_OPEN.upload(fenceGate, texture, generator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_FENCE_GATE.upload(fenceGate, texture, generator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(fenceGate, texture, generator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_FENCE_GATE_WALL.upload(fenceGate, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createFenceGateBlockState(fenceGate, identifier, identifier2, identifier3, identifier4));
    }
    
    /**
     * Datagens the blockstate, block model and item model .jsons needed for a pressure plate block.
     * @param pressurePlate The normal pressure plate block. Find this in ModBlocks or a similar block-initializing class.
     * @param texture The TextureMap for the given block type. Uses TEXTURE texture key.
     * @param generator Just type `generator` for this.
     */
    void pressurePlate(Block pressurePlate, TextureMap texture, BlockStateModelGenerator generator) {
        Identifier identifier = Models.PRESSURE_PLATE_UP.upload(pressurePlate, texture, generator.modelCollector);
        Identifier identifier2 = Models.PRESSURE_PLATE_DOWN.upload(pressurePlate, texture, generator.modelCollector);
        generator.blockStateCollector.accept(BlockStateModelGenerator.createPressurePlateBlockState(pressurePlate, identifier, identifier2));
    }
}