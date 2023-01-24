package net.linkle.valleycraft.datagen;

import static net.linkle.valleycraft.init.ModBlocks.*;
import static net.linkle.valleycraft.init.ModBlocks.GRANITE_BRICK_SLAB;
import static net.linkle.valleycraft.init.ModNaturalBlocks.*;
import static net.minecraft.block.Blocks.PACKED_MUD;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.util.BlockEnum;
import net.linkle.valleycraft.util.IdProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.client.BlockStateModelGenerator.TintType;
import net.minecraft.item.Item;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

class ValleyModelGenerator extends FabricModelProvider {
    
    ValleyModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        TextureMap map;
        
        // Others
        generator.registerTrapdoor(PRIMSTEEL_TRAPDOOR.block);
        map = textureAll(PRIMSTEEL_PLATE_BLOCK);
        pressurePlate(PRIMSTEEL_PRESSURE_PLATE.block, map, generator);
        map = textureAll("shale_top");
        pressurePlate(SHALE_PRESSURE_PLATE.block, map, generator);
        map = textureAll(IdProvider.of(new Identifier("deepslate_top")));
        pressurePlate(DEEPSLATE_PRESSURE_PLATE.block, map, generator);

        // CANVAS
        map = textureAll("canvas_block");
        slab(CANVAS_SLAB.block, CANVAS_BLOCK.block, map, generator);
        stairs(CANVAS_STAIRS.block, map, generator);

        // THATCH
        map = TextureMap.sideEnd(Main.makeId("block/thatch_side"), Main.makeId("block/thatch_top"));
        slab(THATCH_SLAB.block, THATCH_BLOCK.block, map, generator);
        stairs(THATCH_STAIRS.block, map, generator);

        // WEAVED_THATCH
        map = textureAll("patterned_thatch");
        slab(WEAVED_THATCH_SLAB.block, WEAVED_THATCH_BLOCK.block, map, generator);
        stairs(WEAVED_THATCH_STAIRS.block, map, generator);

        // TIGHTLY_WEAVED_THATCH
        map = textureAll("patterned_thatch_small");
        slab(TIGHTLY_WEAVED_THATCH_SLAB.block, TIGHTLY_WEAVED_THATCH_BLOCK.block, map, generator);
        stairs(TIGHTLY_WEAVED_THATCH_STAIRS.block, map, generator);

        //Daub
        map = textureAll(BLOCK_DAUB);
        slab(DAUB_SLAB.block, BLOCK_DAUB.block, map, generator);
        stairs(DAUB_STAIRS.block, map, generator);
        wall(DAUB_WALL.block, map, generator);

        // PRIMSTEEL_PLATE
        map = textureAll(PRIMSTEEL_PLATE_BLOCK);
        slab(PRIMSTEEL_PLATE_SLAB.block, PRIMSTEEL_PLATE_BLOCK.block, map, generator);
        stairs(PRIMSTEEL_PLATE_STAIRS.block, map, generator);

        // PRIMSTEEL_TILED
        map = textureAll(PRIMSTEEL_TILED_PLATE);
        slab(PRIMSTEEL_TILED_SLAB.block, PRIMSTEEL_TILED_PLATE.block, map, generator);
        stairs(PRIMSTEEL_TILED_STAIRS.block, map, generator);

        // IRON_PLATE
        map = textureAll(IRON_PLATE_BLOCK);
        slab(IRON_PLATE_SLAB.block, IRON_PLATE_BLOCK.block, map, generator);
        stairs(IRON_PLATE_STAIRS.block, map, generator);

        // IRON_CUT
        map = textureAll(IRON_CUT_BLOCK);
        slab(IRON_CUT_SLAB.block, IRON_CUT_BLOCK.block, map, generator);
        stairs(IRON_CUT_STAIRS.block, map, generator);

        // ERDSTONE
        map = textureAll(ERDSTONE);
        slab(ERDSTONE_SLAB.block, ERDSTONE.block, map, generator);
        stairs(ERDSTONE_STAIRS.block, map, generator);
        wall(ERDSTONE_WALL.block, map, generator);

        // ERDCOBBLESTONE
        map = textureAll(ERDCOBBLESTONE);
        slab(ERDCOBBLESTONE_SLAB.block, ERDCOBBLESTONE.block, map, generator);
        stairs(ERDCOBBLESTONE_STAIRS.block, map, generator);
        wall(ERDCOBBLESTONE_WALL.block, map, generator);

        // POLISHED_ERDSTONE_BRICKS
        map = textureAll(POLISHED_ERDSTONE);
        slab(POLISHED_ERDSTONE_SLAB.block, POLISHED_ERDSTONE.block, map, generator);
        stairs(POLISHED_ERDSTONE_STAIRS.block, map, generator);
        wall(POLISHED_ERDSTONE_WALL.block, map, generator);

        // ERDSTONE_BRICKS
        map = textureAll(ERDSTONE_BRICKS);
        slab(ERDSTONE_BRICK_SLAB.block, ERDSTONE_BRICKS.block, map, generator);
        stairs(ERDSTONE_BRICK_STAIRS.block, map, generator);
        wall(ERDSTONE_BRICK_WALL.block, map, generator);

        // MOSSY_ERDSTONE_BRICK_BRICKS
        map = textureAll(MOSSY_ERDSTONE_BRICKS);
        slab(MOSSY_ERDSTONE_BRICK_SLAB.block, MOSSY_ERDSTONE_BRICKS.block, map, generator);
        stairs(MOSSY_ERDSTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_ERDSTONE_BRICK_WALL.block, map, generator);

        // ERDSTONE_TILES
        map = textureAll(ERDSTONE_TILES);
        slab(ERDSTONE_TILE_SLAB.block, ERDSTONE_TILES.block, map, generator);
        stairs(ERDSTONE_TILE_STAIRS.block, map, generator);

        // ERDSTONE_MOSAIC
        map = textureAll(ERDSTONE_MOSAIC);
        slab(ERDSTONE_MOSAIC_SLAB.block, ERDSTONE_MOSAIC.block, map, generator);
        stairs(ERDSTONE_MOSAIC_STAIRS.block, map, generator);

        // POLISHED_ADVENTURINE
        map = textureAll(POLISHED_ADVENTURINE);
        slab(POLISHED_ADVENTURINE_SLAB.block, POLISHED_ADVENTURINE.block, map, generator);
        stairs(POLISHED_ADVENTURINE_STAIRS.block, map, generator);
        wall(POLISHED_ADVENTURINE_WALL.block, map, generator);

        // ADVENTURINE
        map = textureAll(ADVENTURINE);
        slab(ADVENTURINE_SLAB.block, ADVENTURINE.block, map, generator);
        stairs(ADVENTURINE_STAIRS.block, map, generator);
        wall(ADVENTURINE_WALL.block, map, generator);

        // ADVENTURINE_BRICKS
        map = textureAll(ADVENTURINE_BRICKS);
        slab(ADVENTURINE_BRICK_SLAB.block, ADVENTURINE_BRICKS.block, map, generator);
        stairs(ADVENTURINE_BRICK_STAIRS.block, map, generator);
        wall(ADVENTURINE_BRICK_WALL.block, map, generator);

        // SHALE
        map = TextureMap.sideEnd(Main.makeId("block/shale_side"), Main.makeId("block/shale_top")).put(TextureKey.WALL, Main.makeId("block/stratified_sandstone_top"));
        slab(SHALE_SLAB.block, SHALE.block, map, generator);
        stairs(SHALE_STAIRS.block, map, generator);
        wall(SHALE_WALL.block, map, generator);

        // COBBLED_SHALE
        map = textureAll("shale_top");
        slab(COBBLED_SHALE_SLAB.block, COBBLED_SHALE.block, map, generator);
        stairs(COBBLED_SHALE_STAIRS.block, map, generator);
        wall(COBBLED_SHALE_WALL.block, map, generator);

        // POLISHED_SHALES
        map = textureAll(POLISHED_SHALE);
        slab(POLISHED_SHALE_SLAB.block, POLISHED_SHALE.block, map, generator);
        stairs(POLISHED_SHALE_STAIRS.block, map, generator);
        wall(POLISHED_SHALE_WALL.block, map, generator);

        // SHALE_BRICKS
        map = textureAll(SHALE_BRICKS);
        slab(SHALE_BRICK_SLAB.block, SHALE_BRICKS.block, map, generator);
        stairs(SHALE_BRICK_STAIRS.block, map, generator);
        wall(SHALE_BRICK_WALL.block, map, generator);

        // MARBLE
        map = textureAll(MARBLE);
        slab(MARBLE_SLAB.block, MARBLE.block, map, generator);
        stairs(MARBLE_STAIRS.block, map, generator);
        wall(MARBLE_WALL.block, map, generator);

        // POLISHED_MARBLE
        map = textureAll(POLISHED_MARBLE);
        slab(POLISHED_MARBLE_SLAB.block, POLISHED_MARBLE.block, map, generator);
        stairs(POLISHED_MARBLE_STAIRS.block, map, generator);
        wall(POLISHED_MARBLE_WALL.block, map, generator);

        // MARBLE_BRICKS
        map = textureAll(MARBLE_BRICKS);
        slab(MARBLE_BRICK_SLAB.block, MARBLE_BRICKS.block, map, generator);
        stairs(MARBLE_BRICK_STAIRS.block, map, generator);
        wall(MARBLE_BRICK_WALL.block, map, generator);

        // SHIVERSTONE
        map = textureAll(SHIVERSTONE);
        slab(SHIVERSTONE_SLAB.block, SHIVERSTONE.block, map, generator);
        stairs(SHIVERSTONE_STAIRS.block, map, generator);
        wall(SHIVERSTONE_WALL.block, map, generator);

        // SHIVERSTONE_SMOOTH
        map = textureAll(SHIVERSTONE_SMOOTH);
        slab(SHIVERSTONE_SMOOTH_SLAB.block, SHIVERSTONE_SMOOTH.block, map, generator);
        stairs(SHIVERSTONE_SMOOTH_STAIRS.block, map, generator);
        wall(SHIVERSTONE_SMOOTH_WALL.block, map, generator);

        // SERPENTINITE
        map = textureAll(SERPENTINITE);
        slab(SERPENTINITE_SLAB.block, SERPENTINITE.block, map, generator);
        stairs(SERPENTINITE_STAIRS.block, map, generator);
        wall(SERPENTINITE_WALL.block, map, generator);

        // SHIVERSTONE_TILES
        map = textureAll(SHIVERSTONE_TILES);
        slab(SHIVERSTONE_TILE_SLAB.block, SHIVERSTONE_TILES.block, map, generator);
        stairs(SHIVERSTONE_TILE_STAIRS.block, map, generator);
        wall(SHIVERSTONE_TILE_WALL.block, map, generator);

        // SERPENTINITE_SMOOTH
        map = textureAll(SERPENTINITE_SMOOTH);
        slab(SERPENTINITE_SMOOTH_SLAB.block, SERPENTINITE_SMOOTH.block, map, generator);
        stairs(SERPENTINITE_SMOOTH_STAIRS.block, map, generator);
        wall(SERPENTINITE_SMOOTH_WALL.block, map, generator);

        // SERPENTINITE_BRICKS
        map = textureAll(SERPENTINITE_BRICKS);
        slab(SERPENTINITE_BRICK_SLAB.block, SERPENTINITE_BRICKS.block, map, generator);
        stairs(SERPENTINITE_BRICK_STAIRS.block, map, generator);
        wall(SERPENTINITE_BRICK_WALL.block, map, generator);

        // CARMINE
        map = textureAll(CARMINE);
        slab(CARMINE_SLAB.block, CARMINE.block, map, generator);
        stairs(CARMINE_STAIRS.block, map, generator);
        wall(CARMINE_WALL.block, map, generator);

        // CARMINE_COBBLESTONE
        map = textureAll(CARMINE_COBBLESTONE);
        slab(CARMINE_COBBLESTONE_SLAB.block, CARMINE_COBBLESTONE.block, map, generator);
        stairs(CARMINE_COBBLESTONE_STAIRS.block, map, generator);
        wall(CARMINE_COBBLESTONE_WALL.block, map, generator);

        // CARMINE_SMOOTH
        map = textureAll(CARMINE_SMOOTH);
        slab(CARMINE_SMOOTH_SLAB.block, CARMINE_SMOOTH.block, map, generator);
        stairs(CARMINE_SMOOTH_STAIRS.block, map, generator);
        wall(CARMINE_SMOOTH_WALL.block, map, generator);

        // CARMINE_BRICKS
        map = textureAll(CARMINE_BRICKS);
        slab(CARMINE_BRICK_SLAB.block, CARMINE_BRICKS.block, map, generator);
        stairs(CARMINE_BRICK_STAIRS.block, map, generator);
        wall(CARMINE_BRICK_WALL.block, map, generator);

        // PACKED_MUD
        map = textureAllMC(Blocks.PACKED_MUD);
        slab(PACKED_MUD_SLAB.block, PACKED_MUD, map, generator);
        stairs(PACKED_MUD_STAIRS.block, map, generator);
        wall(PACKED_MUD_WALL.block, map, generator);
        
        // PACKED_SNOW
        map = textureAll(PACKED_SNOW);
        slab(PACKED_SNOW_SLAB.block, PACKED_SNOW.block, map, generator);
        stairs(PACKED_SNOW_STAIRS.block, map, generator);
        wall(PACKED_SNOW_WALL.block, map, generator);

        // PACKED_SNOW_POLISHED
        map = textureAll(PACKED_SNOW_POLISHED);
        slab(PACKED_SNOW_POLISHED_SLAB.block, PACKED_SNOW_POLISHED.block, map, generator);
        stairs(PACKED_SNOW_POLISHED_STAIRS.block, map, generator);
        wall(PACKED_SNOW_POLISHED_WALL.block, map, generator);

        // PACKED_SNOW_BRICKS_LARGE
        map = textureAll(PACKED_SNOW_BRICKS_LARGE);
        slab(PACKED_SNOW_BRICKS_LARGE_SLAB.block, PACKED_SNOW_BRICKS_LARGE.block, map, generator);
        stairs(PACKED_SNOW_BRICKS_LARGE_STAIRS.block, map, generator);
        wall(PACKED_SNOW_BRICKS_LARGE_WALL.block, map, generator);

        // PACKED_SNOW_BRICKS_SMALL
        map = textureAll(PACKED_SNOW_BRICKS_SMALL);
        slab(PACKED_SNOW_BRICKS_SMALL_SLAB.block, PACKED_SNOW_BRICKS_SMALL.block, map, generator);
        stairs(PACKED_SNOW_BRICKS_SMALL_STAIRS.block, map, generator);
        wall(PACKED_SNOW_BRICKS_SMALL_WALL.block, map, generator);

        // ANDESITE_BRICKS
        map = textureAll(ANDESITE_BRICKS);
        slab(ANDESITE_BRICK_SLAB.block, ANDESITE_BRICKS.block, map, generator);
        stairs(ANDESITE_BRICK_STAIRS.block, map, generator);
        wall(ANDESITE_BRICK_WALL.block, map, generator);

        // DIORITE_BRICKS
        map = textureAll(DIORITE_BRICKS);
        slab(DIORITE_BRICK_SLAB.block, DIORITE_BRICKS.block, map, generator);
        stairs(DIORITE_BRICK_STAIRS.block, map, generator);
        wall(DIORITE_BRICK_WALL.block, map, generator);

        // GRANITE_BRICKS
        map = textureAll(GRANITE_BRICKS);
        slab(GRANITE_BRICK_SLAB.block, GRANITE_BRICKS.block, map, generator);
        stairs(GRANITE_BRICK_STAIRS.block, map, generator);
        wall(GRANITE_BRICK_WALL.block, map, generator);

        // POLISHED_PRISMARINE
        map = textureAll(POLISHED_PRISMARINE);
        slab(POLISHED_PRISMARINE_SLAB.block, POLISHED_PRISMARINE.block, map, generator);
        stairs(POLISHED_PRISMARINE_STAIRS.block, map, generator);
        wall(POLISHED_PRISMARINE_WALL.block, map, generator);

        // POLISHED_DRIPSTONE
        map = textureAll(POLISHED_DRIPSTONE);
        slab(POLISHED_DRIPSTONE_SLAB.block, POLISHED_DRIPSTONE.block, map, generator);
        stairs(POLISHED_DRIPSTONE_STAIRS.block, map, generator);
        wall(POLISHED_DRIPSTONE_WALL.block, map, generator);
        
        // PATTERNED_DRIPSTONE
        map = textureAll(PATTERNED_DRIPSTONE);
        slab(PATTERNED_DRIPSTONE_SLAB.block, PATTERNED_DRIPSTONE.block, map, generator);
        stairs(PATTERNED_DRIPSTONE_STAIRS.block, map, generator);

        // DRIPSTONE_BRICKS
        map = textureAll(DRIPSTONE_BRICKS);
        slab(DRIPSTONE_BRICK_SLAB.block, DRIPSTONE_BRICKS.block, map, generator);
        stairs(DRIPSTONE_BRICK_STAIRS.block, map, generator);
        wall(DRIPSTONE_BRICK_WALL.block, map, generator);

        // MOSSY_DRIPSTONE_BRICKS
        map = textureAll(MOSSY_DRIPSTONE_BRICKS);
        slab(MOSSY_DRIPSTONE_BRICK_SLAB.block, MOSSY_DRIPSTONE_BRICKS.block, map, generator);
        stairs(MOSSY_DRIPSTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_DRIPSTONE_BRICK_WALL.block, map, generator);

        // DRIPSTONE_TILES
        map = textureAll(DRIPSTONE_TILES);
        slab(DRIPSTONE_TILE_SLAB.block, DRIPSTONE_TILES.block, map, generator);
        stairs(DRIPSTONE_TILE_STAIRS.block, map, generator);
        wall(DRIPSTONE_TILE_WALL.block, map, generator);

        // DRIPSTONE_MOSAICS
        map = textureAll(DRIPSTONE_MOSAIC);
        slab(DRIPSTONE_MOSAIC_SLAB.block, DRIPSTONE_MOSAIC.block, map, generator);
        stairs(DRIPSTONE_MOSAIC_STAIRS.block, map, generator);

        // POLISHED_SALT_BLOCKS
        map = textureAll(POLISHED_SALT_BLOCK);
        slab(POLISHED_SALT_BLOCK_SLAB.block, POLISHED_SALT_BLOCK.block, map, generator);
        stairs(POLISHED_SALT_BLOCK_STAIRS.block, map, generator);
        wall(POLISHED_SALT_BLOCK_WALL.block, map, generator);

        // SALT_BRICKS
        map = textureAll(SALT_BRICKS);
        slab(SALT_BRICK_SLAB.block, SALT_BRICKS.block, map, generator);
        stairs(SALT_BRICK_STAIRS.block, map, generator);
        wall(SALT_BRICK_WALL.block, map, generator);

        // POLISHED_BASALTS
        map = textureAll(POLISHED_BASALT);
        slab(POLISHED_BASALT_SLAB.block, POLISHED_BASALT.block, map, generator);
        stairs(POLISHED_BASALT_STAIRS.block, map, generator);
        wall(POLISHED_BASALT_WALL.block, map, generator);

        // POLISHED_BASALT_BRICKS
        map = textureAll(POLISHED_BASALT_BRICKS);
        slab(POLISHED_BASALT_BRICK_SLAB.block, POLISHED_BASALT_BRICKS.block, map, generator);
        stairs(POLISHED_BASALT_BRICK_STAIRS.block, map, generator);
        wall(POLISHED_BASALT_BRICK_WALL.block, map, generator);
        
        // POLISHED_BASALT_BRICKS
        map = textureAll(POLISHED_BASALT_PATTERNED);
        slab(POLISHED_BASALT_PATTERNED_SLAB.block, POLISHED_BASALT_PATTERNED.block, map, generator);
        stairs(POLISHED_BASALT_PATTERNED_STAIRS.block, map, generator);

        // ROUGH_SANDSTONE
        map = textureAll(ROUGH_SANDSTONE);
        slab(ROUGH_SANDSTONE_SLAB.block, ROUGH_SANDSTONE.block, map, generator);
        stairs(ROUGH_SANDSTONE_STAIRS.block, map, generator);
        wall(ROUGH_SANDSTONE_WALL.block, map, generator);

        // ROUGH_RED_SANDSTONE
        map = textureAll(ROUGH_RED_SANDSTONE);
        slab(ROUGH_RED_SANDSTONE_SLAB.block, ROUGH_RED_SANDSTONE.block, map, generator);
        stairs(ROUGH_RED_SANDSTONE_STAIRS.block, map, generator);
        wall(ROUGH_RED_SANDSTONE_WALL.block, map, generator);

        // STRATIFIED_SANDSTONE
        map = TextureMap.sideEnd(Main.makeId("block/stratified_sandstone_side"), Main.makeId("block/stratified_sandstone_top")).put(TextureKey.WALL, Main.makeId("block/stratified_sandstone_top"));
        slab(STRATIFIED_SANDSTONE_SLAB.block, STRATIFIED_SANDSTONE.block, map, generator);
        stairs(STRATIFIED_SANDSTONE_STAIRS.block, map, generator);
        wall(STRATIFIED_SANDSTONE_WALL.block, map, generator);

        // STRATIFIED_RED_SANDSTONE
        map = TextureMap.sideEnd(Main.makeId("block/stratified_red_sandstone_side"), Main.makeId("block/stratified_red_sandstone_top")).put(TextureKey.WALL, Main.makeId("block/stratified_sandstone_top"));
        slab(STRATIFIED_RED_SANDSTONE_SLAB.block, STRATIFIED_RED_SANDSTONE.block, map, generator);
        stairs(STRATIFIED_RED_SANDSTONE_STAIRS.block, map, generator);
        wall(STRATIFIED_RED_SANDSTONE_WALL.block, map, generator);

        // SANDSTONE_BRICKS
        map = textureAll(SANDSTONE_BRICKS);
        slab(SANDSTONE_BRICK_SLAB.block, SANDSTONE_BRICKS.block, map, generator);
        stairs(SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(SANDSTONE_BRICK_WALL.block, map, generator);

        // CRACKED_SANDSTONE_BRICKS
        map = textureAll(CRACKED_SANDSTONE_BRICKS);
        slab(CRACKED_SANDSTONE_BRICK_SLAB.block, CRACKED_SANDSTONE_BRICKS.block, map, generator);
        stairs(CRACKED_SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(CRACKED_SANDSTONE_BRICK_WALL.block, map, generator);

        // MOSSY_SANDSTONE_BRICKS
        map = textureAll(MOSSY_SANDSTONE_BRICKS);
        slab(MOSSY_SANDSTONE_BRICK_SLAB.block, MOSSY_SANDSTONE_BRICKS.block, map, generator);
        stairs(MOSSY_SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_SANDSTONE_BRICK_WALL.block, map, generator);

        // RED_SANDSTONE_BRICKS
        map = textureAll(RED_SANDSTONE_BRICKS);
        slab(RED_SANDSTONE_BRICK_SLAB.block, RED_SANDSTONE_BRICKS.block, map, generator);
        stairs(RED_SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(RED_SANDSTONE_BRICK_WALL.block, map, generator);

        // CRACKED_RED_SANDSTONE_BRICKS
        map = textureAll(CRACKED_RED_SANDSTONE_BRICKS);
        slab(CRACKED_RED_SANDSTONE_BRICK_SLAB.block, CRACKED_RED_SANDSTONE_BRICKS.block, map, generator);
        stairs(CRACKED_RED_SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(CRACKED_RED_SANDSTONE_BRICK_WALL.block, map, generator);

        // MOSSY_RED_SANDSTONE_BRICKS
        map = textureAll(MOSSY_RED_SANDSTONE_BRICKS);
        slab(MOSSY_RED_SANDSTONE_BRICK_SLAB.block, MOSSY_RED_SANDSTONE_BRICKS.block, map, generator);
        stairs(MOSSY_RED_SANDSTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_RED_SANDSTONE_BRICK_WALL.block, map, generator);

        // SCORCHSTONE_POLISHED
        map = textureAll(SCORCHSTONE_POLISHED);
        slab(SCORCHSTONE_POLISHED_SLAB.block, SCORCHSTONE_POLISHED.block, map, generator);
        stairs(SCORCHSTONE_POLISHED_STAIRS.block, map, generator);
        wall(SCORCHSTONE_POLISHED_WALL.block, map, generator);

        // SCORCHSTONE
        map = textureAll(SCORCHSTONE);
        slab(SCORCHSTONE_SLAB.block, SCORCHSTONE.block, map, generator);
        stairs(SCORCHSTONE_STAIRS.block, map, generator);
        wall(SCORCHSTONE_WALL.block, map, generator);

        // SCORCHSTONE_BRICKS
        map = textureAll(SCORCHSTONE_TILES);
        slab(SCORCHSTONE_TILE_SLAB.block, SCORCHSTONE_TILES.block, map, generator);
        stairs(SCORCHSTONE_TILE_STAIRS.block, map, generator);
        wall(SCORCHSTONE_TILE_WALL.block, map, generator);
        
        // SCORCHSTONE_BRICKS
        map = textureAll(SCORCHSTONE_BRICKS);
        slab(SCORCHSTONE_BRICK_SLAB.block, SCORCHSTONE_BRICKS.block, map, generator);
        stairs(SCORCHSTONE_BRICK_STAIRS.block, map, generator);
        wall(SCORCHSTONE_BRICK_WALL.block, map, generator);

        // MOSSY_SCORCHSTONE_BRICKS
        map = textureAll(MOSSY_SCORCHSTONE_BRICKS);
        slab(MOSSY_SCORCHSTONE_BRICK_SLAB.block, MOSSY_SCORCHSTONE_BRICKS.block, map, generator);
        stairs(MOSSY_SCORCHSTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_SCORCHSTONE_BRICK_WALL.block, map, generator);

        // SCORCHSTONE_MOSAICS
        map = textureAll(SCORCHSTONE_MOSAIC);
        slab(SCORCHSTONE_MOSAIC_SLAB.block, SCORCHSTONE_MOSAIC.block, map, generator);
        stairs(SCORCHSTONE_MOSAIC_STAIRS.block, map, generator);

        // VOLCANIC_STONE
        map = textureAll(VOLCANIC_STONE);
        slab(VOLCANIC_STONE_SLAB.block, VOLCANIC_STONE.block, map, generator);
        stairs(VOLCANIC_STONE_STAIRS.block, map, generator);
        wall(VOLCANIC_STONE_WALL.block, map, generator);

        // POLISHED_PACKED_MUD
        map = textureAll(POLISHED_PACKED_MUD);
        slab(POLISHED_PACKED_MUD_SLAB.block, POLISHED_PACKED_MUD.block, map, generator);
        stairs(POLISHED_PACKED_MUD_STAIRS.block, map, generator);
        wall(POLISHED_PACKED_MUD_WALL.block, map, generator);

        // SMOOTH_BRICK
        map = textureAll(SMOOTH_BRICK);
        slab(SMOOTH_BRICK_SLAB.block, SMOOTH_BRICK.block, map, generator);
        stairs(SMOOTH_BRICK_STAIRS.block, map, generator);
        wall(SMOOTH_BRICK_WALL.block, map, generator);

        // MOSAIC_BRICKS
        map = textureAll(MOSAIC_BRICK);
        slab(MOSAIC_BRICK_SLAB.block, MOSAIC_BRICK.block, map, generator);
        stairs(MOSAIC_BRICK_STAIRS.block, map, generator);

        // MOSSY_STONE
        map = textureAll(MOSSY_STONE);
        slab(MOSSY_STONE_SLAB.block, MOSSY_STONE.block, map, generator);
        stairs(MOSSY_STONE_STAIRS.block, map, generator);
        wall(MOSSY_STONE_WALL.block, map, generator);

        // COBBLESTONE_BRICKS
        map = textureAll(COBBLESTONE_BRICKS);
        slab(COBBLESTONE_BRICK_SLAB.block, COBBLESTONE_BRICKS.block, map, generator);
        stairs(COBBLESTONE_BRICK_STAIRS.block, map, generator);
        wall(COBBLESTONE_BRICK_WALL.block, map, generator);

        // MOSSY_COBBLESTONE_BRICKS
        map = textureAll(MOSSY_COBBLESTONE_BRICKS);
        slab(MOSSY_COBBLESTONE_BRICK_SLAB.block, MOSSY_COBBLESTONE_BRICKS.block, map, generator);
        stairs(MOSSY_COBBLESTONE_BRICK_STAIRS.block, map, generator);
        wall(MOSSY_COBBLESTONE_BRICK_WALL.block, map, generator);

        // STONE_TILES
        map = textureAll(STONE_TILES);
        slab(STONE_TILE_SLAB.block, STONE_TILES.block, map, generator);
        stairs(STONE_TILE_STAIRS.block, map, generator);

        // POLISHED_STONE
        map = textureAll(POLISHED_STONE);
        slab(POLISHED_STONE_SLAB.block, POLISHED_STONE.block, map, generator);
        stairs(POLISHED_STONE_STAIRS.block, map, generator);
        wall(POLISHED_STONE_WALL.block, map, generator);

        // SMOOTH_STONE_TILES
        map = textureAll(SMOOTH_STONE_TILES);
        slab(SMOOTH_STONE_TILE_SLAB.block, SMOOTH_STONE_TILES.block, map, generator);
        stairs(SMOOTH_STONE_TILE_STAIRS.block, map, generator);

        //Mamon
        map = textureAll(MAMON_PLANKS);
        generator.registerLog(MAMON_WOOD.block);
        generator.registerLog(STRIPPED_MAMON_WOOD.block);
        generator.registerLog(STRIPPED_MAMON_LOG.block);
        generator.registerLog(MAMON_LOG.block);
        generator.registerSimpleCubeAll(MAMON_PLANKS.block);
        generator.registerDoor(MAMON_DOOR.block);
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
        generator.registerDoor(APPLE_DOOR.block);
        generator.registerOrientableTrapdoor(APPLE_TRAPDOOR.block);
        slab(APPLE_SLAB.block, APPLE_PLANKS.block, map, generator);
        stairs(APPLE_STAIRS.block, map, generator);
        button(APPLE_BUTTON.block, map, generator);
        fence(APPLE_FENCE.block, textureAll("apple_fence_planks"), generator);
        fenceGate(APPLE_FENCE_GATE.block, textureAll("apple_fence_planks"), generator);
        pressurePlate(APPLE_PRESSURE_PLATE.block, map, generator);

        // Doors
        map = textureAll("wattle_door");
        generator.registerDoor(WATTLE_DOOR.block);

        // Lattices
        lattice(OAK_LATTICE, generator);
        lattice(APPLE_LATTICE, generator);
        lattice(ACACIA_LATTICE, generator);
        lattice(BIRCH_LATTICE, generator);
        lattice(DARK_OAK_LATTICE, generator);
        lattice(CRIMSON_LATTICE, generator);
        lattice(JUNGLE_LATTICE, generator);
        lattice(MANGROVE_LATTICE, generator);
        lattice(SPRUCE_LATTICE, generator);
        lattice(WARPED_LATTICE, generator);
        lattice(WATTLE_LATTICE, generator);
        lattice(AMBERBLOSSOM_LATTICE, generator);
        
        // Tall plants
        generator.registerDoubleBlock(CATTAILS.block, TintType.NOT_TINTED);
        
        // Glass pane
        registerGlassPane(new Identifier("block/tinted_glass"), TINTED_GLASS_PANE.block, generator);
        generator.registerGlassPane(TERRARIUM_GLASS.block, TERRARIUM_GLASS_PANE.block);
        generator.registerGlassPane(BRIMSTONE_GLASS.block, BRIMSTONE_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_GLASS.block, BEVELED_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_BRIMSTONE_GLASS.block, BEVELED_BRIMSTONE_GLASS_PANE.block);
        generator.registerGlassPane(BEVELED_TINTED_GLASS.block, BEVELED_TINTED_GLASS_PANE.block);
        //generator.registerGlassPane(BLOCK_WATTLE_AND_GLASS.block, BLOCK_WATTLE_AND_GLASS_PANE.block);
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
        generator.registerFlowerPotPlant(MOREL.block, POTTED_MOREL.block, TintType.NOT_TINTED);
        //generator.registerFlowerPotPlant(GOOP_CAP.block, POTTED_GOOP_CAP.block, TintType.NOT_TINTED);

        // Potted saplings
        generator.registerFlowerPotPlant(MAMON_SAPLING.block, POTTED_MAMON_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(APPLE_SAPLING.block, POTTED_APPLE_SAPLING.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(WARM_BIRCH_SAPLING.block, POTTED_WARM_BIRCH_SAPLING.block, TintType.NOT_TINTED);

        // Other potted plants (that don't use custom models; see ModBlocks for which ones do)
        generator.registerFlowerPotPlant(FOXTAIL_FERN.block, POTTED_FOXTAIL_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LEATHERLEAF_FERN.block, POTTED_LEATHERLEAF_FERN.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(MOSS_SPROUTLET.block, POTTED_MOSS_SPROUTLET.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(SPROUT.block, POTTED_SPROUT.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(DESERT_SHRUB.block, POTTED_DESERT_SHRUB.block, TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(LUSH_BUSH.block, POTTED_LUSH_BUSH.block, TintType.NOT_TINTED);
        
        // doors
        generator.registerDoor(GLASS_DOOR.block);
        generator.registerDoor(PRIMSTEEL_DOOR.block);
        generator.registerDoor(TINTED_GLASS_DOOR.block);
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
    
    TextureMap textureAllMC(Block block) {
        var id =  TextureMap.getId(block);
        return TextureMap.sideEnd(id, id).put(TextureKey.WALL, id).put(TextureKey.ALL, id).put(TextureKey.TEXTURE, id);
    }
    
    TextureMap textureAll(String texture) {
        return textureAll(IdProvider.of(Main.makeId(texture)));
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
    
    /** 
     * Datagens the blockstate, block model and item model .jsons needed for a pane block. But without generating the glass block
     * @param //pressurePlate The normal pressure plate block. Find this in ModBlocks or a similar block-initializing class.
     * @param //texture The TextureMap for the given block type. Uses TEXTURE texture key.
     * @param generator Just type `generator` for this.
     */
    void registerGlassPane(Identifier id, Block glassPane, BlockStateModelGenerator generator) {
        TextureMap textureMap = new TextureMap().put(TextureKey.PANE, id).put(TextureKey.EDGE, new Identifier(id.getNamespace(), "block/" + id.getPath() + "_top"));;
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(glassPane, textureMap, generator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(glassPane, textureMap, generator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(glassPane, textureMap, generator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(glassPane, textureMap, generator.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(glassPane, textureMap, generator.modelCollector);
        Item item = glassPane.asItem();
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(id), generator.modelCollector);
        generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(glassPane).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with((When)When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with((When)When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with((When)When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with((When)When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with((When)When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
    
    void lattice(BlockEnum lattice, BlockStateModelGenerator generator) {
        Identifier id = texture(lattice.getId().getPath());
        TextureMap textureMap = new TextureMap().put(TextureKey.PANE, id).put(TextureKey.EDGE, TextureMap.getSubId(lattice.asBlock(), "_top"));
        Identifier identifier = Models.TEMPLATE_GLASS_PANE_POST.upload(lattice.asBlock(), textureMap, generator.modelCollector);
        Identifier identifier2 = Models.TEMPLATE_GLASS_PANE_SIDE.upload(lattice.asBlock(), textureMap, generator.modelCollector);
        Identifier identifier3 = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(lattice.asBlock(), textureMap, generator.modelCollector);
        Identifier identifier4 = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(lattice.asBlock(), textureMap, generator.modelCollector);
        Identifier identifier5 = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(lattice.asBlock(), textureMap, generator.modelCollector);
        Item item = lattice.asBlock().asItem();
        Models.GENERATED.upload(ModelIds.getItemModelId(item), TextureMap.layer0(id), generator.modelCollector);
        generator.blockStateCollector.accept(MultipartBlockStateSupplier.create(lattice.asBlock()).with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier)).with((When)When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)).with((When)When.create().set(Properties.EAST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier2).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)).with((When)When.create().set(Properties.WEST, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.NORTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)).with((When)When.create().set(Properties.EAST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5)).with((When)When.create().set(Properties.SOUTH, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)).with((When)When.create().set(Properties.WEST, false), BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R270)));
    }
}