package net.linkle.valleycraft.datagen;

import static net.linkle.valleycraft.init.BlocksNatural.*;
import static net.linkle.valleycraft.init.BlocksModded.*;

import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;

public class ValleyRecipeGenerator extends FabricRecipeProvider {

    public ValleyRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        offerStairsSlabWall_stone(exporter, ANTHRACITE_BLOCK, ADVENTURINE_STAIRS, ADVENTURINE_SLAB, ADVENTURINE_WALL);
        offerStairsSlabWall_stone(exporter, ADVENTURINE_BRICKS, ADVENTURINE_BRICK_STAIRS, ADVENTURINE_BRICK_SLAB, ADVENTURINE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, ANDESITE_BRICKS, ANDESITE_BRICK_STAIRS, ANDESITE_BRICK_SLAB, ANDESITE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, CARMINE_BRICKS, CARMINE_BRICK_STAIRS, CARMINE_BRICK_SLAB, CARMINE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, CARMINE_COBBLESTONE, CARMINE_COBBLESTONE_STAIRS, CARMINE_COBBLESTONE_SLAB, CARMINE_COBBLESTONE_WALL);
        offerStairsSlabWall_stone(exporter, CARMINE_SMOOTH, CARMINE_SMOOTH_STAIRS, CARMINE_SMOOTH_SLAB, CARMINE_SMOOTH_WALL);
        offerStairsSlabWall_stone(exporter, CARMINE, CARMINE_STAIRS, CARMINE_SLAB, CARMINE_WALL);
        offerStairsSlabWall_stone(exporter, COBBLED_SHALE, COBBLED_SHALE_STAIRS, COBBLED_SHALE_SLAB, COBBLED_SHALE_WALL);
        offerStairsSlabWall_stone(exporter, COBBLESTONE_BRICKS, COBBLESTONE_BRICK_STAIRS, COBBLESTONE_BRICK_SLAB, COBBLESTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, CRACKED_RED_SANDSTONE_BRICKS, CRACKED_RED_SANDSTONE_BRICK_STAIRS, CRACKED_RED_SANDSTONE_BRICK_SLAB, CRACKED_RED_SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, CRACKED_SANDSTONE_BRICKS, CRACKED_SANDSTONE_BRICK_STAIRS, CRACKED_SANDSTONE_BRICK_SLAB, CRACKED_SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, BLOCK_DAUB, DAUB_STAIRS, DAUB_SLAB, DAUB_WALL);
        offerStairsSlabWall_stone(exporter, DIORITE_BRICKS, DIORITE_BRICK_STAIRS, DIORITE_BRICK_SLAB, DIORITE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, DRIPSTONE_BRICKS, DRIPSTONE_BRICK_STAIRS, DRIPSTONE_BRICK_SLAB, DRIPSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, DRIPSTONE_TILES, DRIPSTONE_TILE_STAIRS, DRIPSTONE_TILE_SLAB, DRIPSTONE_TILE_WALL);
        offerStairsSlabWall_stone(exporter, ERDCOBBLESTONE, ERDCOBBLESTONE_STAIRS, ERDCOBBLESTONE_SLAB, ERDCOBBLESTONE_WALL);
        offerStairsSlabWall_stone(exporter, ERDSTONE_BRICKS, ERDSTONE_BRICK_STAIRS, ERDSTONE_BRICK_SLAB, ERDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, ERDSTONE, ERDSTONE_STAIRS, ERDSTONE_SLAB, ERDSTONE_WALL);
        offerStairsSlabWall_stone(exporter, GRANITE_BRICKS, GRANITE_BRICK_STAIRS, GRANITE_BRICK_SLAB, GRANITE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MARBLE_BRICKS, MARBLE_BRICK_STAIRS, MARBLE_BRICK_SLAB, MARBLE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MARBLE, MARBLE_STAIRS, MARBLE_SLAB, MARBLE_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_COBBLESTONE_BRICKS, MOSSY_COBBLESTONE_BRICK_STAIRS, MOSSY_COBBLESTONE_BRICK_SLAB, MOSSY_COBBLESTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_DRIPSTONE_BRICKS, MOSSY_DRIPSTONE_BRICK_STAIRS, MOSSY_DRIPSTONE_BRICK_SLAB, MOSSY_DRIPSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_ERDSTONE_BRICKS, MOSSY_ERDSTONE_BRICK_STAIRS, MOSSY_ERDSTONE_BRICK_SLAB, MOSSY_ERDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_RED_SANDSTONE_BRICKS, MOSSY_RED_SANDSTONE_BRICK_STAIRS, MOSSY_RED_SANDSTONE_BRICK_SLAB, MOSSY_RED_SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_SANDSTONE_BRICKS, MOSSY_SANDSTONE_BRICK_STAIRS, MOSSY_SANDSTONE_BRICK_SLAB, MOSSY_SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_SCORCHSTONE_BRICKS, MOSSY_SCORCHSTONE_BRICK_STAIRS, MOSSY_SCORCHSTONE_BRICK_SLAB, MOSSY_SCORCHSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, MOSSY_STONE, MOSSY_STONE_STAIRS, MOSSY_STONE_SLAB, MOSSY_STONE_WALL);
        offerStairsSlabWall_stone(exporter, Blocks.PACKED_MUD, PACKED_MUD_STAIRS, PACKED_MUD_SLAB, PACKED_MUD_WALL);
        offerStairsSlabWall(exporter, PACKED_SNOW_BRICKS_LARGE, PACKED_SNOW_BRICKS_LARGE_STAIRS, PACKED_SNOW_BRICKS_LARGE_SLAB, PACKED_SNOW_BRICKS_LARGE_WALL);
        offerStairsSlabWall(exporter, PACKED_SNOW_BRICKS_SMALL, PACKED_SNOW_BRICKS_SMALL_STAIRS, PACKED_SNOW_BRICKS_SMALL_SLAB, PACKED_SNOW_BRICKS_SMALL_WALL);
        offerStairsSlabWall(exporter, PACKED_SNOW_POLISHED, PACKED_SNOW_POLISHED_STAIRS, PACKED_SNOW_POLISHED_SLAB, PACKED_SNOW_POLISHED_WALL);
        offerStairsSlabWall(exporter, PACKED_SNOW, PACKED_SNOW_STAIRS, PACKED_SNOW_SLAB, PACKED_SNOW_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_ADVENTURINE, POLISHED_ADVENTURINE_STAIRS, POLISHED_ADVENTURINE_SLAB, POLISHED_ADVENTURINE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_BASALT_BRICKS, POLISHED_BASALT_BRICK_STAIRS, POLISHED_BASALT_BRICK_SLAB, POLISHED_BASALT_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_BASALT, POLISHED_BASALT_STAIRS, POLISHED_BASALT_SLAB, POLISHED_BASALT_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_DRIPSTONE, POLISHED_DRIPSTONE_STAIRS, POLISHED_DRIPSTONE_SLAB, POLISHED_DRIPSTONE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_ERDSTONE, POLISHED_ERDSTONE_STAIRS, POLISHED_ERDSTONE_SLAB, POLISHED_ERDSTONE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_MARBLE, POLISHED_MARBLE_STAIRS, POLISHED_MARBLE_SLAB, POLISHED_MARBLE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_PACKED_MUD, POLISHED_PACKED_MUD_STAIRS, POLISHED_PACKED_MUD_SLAB, POLISHED_PACKED_MUD_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_PRISMARINE, POLISHED_PRISMARINE_STAIRS, POLISHED_PRISMARINE_SLAB, POLISHED_PRISMARINE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_SALT_BLOCK, POLISHED_SALT_BLOCK_STAIRS, POLISHED_SALT_BLOCK_SLAB, POLISHED_SALT_BLOCK_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_SHALE, POLISHED_SHALE_STAIRS, POLISHED_SHALE_SLAB, POLISHED_SHALE_WALL);
        offerStairsSlabWall_stone(exporter, POLISHED_STONE, POLISHED_STONE_STAIRS, POLISHED_STONE_SLAB, POLISHED_STONE_WALL);
        offerStairsSlabWall_stone(exporter, RED_SANDSTONE_BRICKS, RED_SANDSTONE_BRICK_STAIRS, RED_SANDSTONE_BRICK_SLAB, RED_SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, ROUGH_RED_SANDSTONE, ROUGH_RED_SANDSTONE_STAIRS, ROUGH_RED_SANDSTONE_SLAB, ROUGH_RED_SANDSTONE_WALL);
        offerStairsSlabWall_stone(exporter, ROUGH_SANDSTONE, ROUGH_SANDSTONE_STAIRS, ROUGH_SANDSTONE_SLAB, ROUGH_SANDSTONE_WALL);
        offerStairsSlabWall_stone(exporter, SALT_BRICKS, SALT_BRICK_STAIRS, SALT_BRICK_SLAB, SALT_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, SANDSTONE_BRICKS, SANDSTONE_BRICK_STAIRS, SANDSTONE_BRICK_SLAB, SANDSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, SCORCHSTONE_BRICKS, SCORCHSTONE_BRICK_STAIRS, SCORCHSTONE_BRICK_SLAB, SCORCHSTONE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, SCORCHSTONE_POLISHED, SCORCHSTONE_POLISHED_STAIRS, SCORCHSTONE_POLISHED_SLAB, SCORCHSTONE_POLISHED_WALL);
        offerStairsSlabWall_stone(exporter, SCORCHSTONE_TILES, SCORCHSTONE_TILE_STAIRS, SCORCHSTONE_TILE_SLAB, SCORCHSTONE_TILE_WALL);
        offerStairsSlabWall_stone(exporter, SCORCHSTONE, SCORCHSTONE_STAIRS, SCORCHSTONE_SLAB, SCORCHSTONE_WALL);
        offerStairsSlabWall_stone(exporter, SERPENTINITE_BRICKS, SERPENTINITE_BRICK_STAIRS, SERPENTINITE_BRICK_SLAB, SERPENTINITE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, SERPENTINITE_SMOOTH, SERPENTINITE_SMOOTH_STAIRS, SERPENTINITE_SMOOTH_SLAB, SERPENTINITE_SMOOTH_WALL);
        offerStairsSlabWall_stone(exporter, SERPENTINITE, SERPENTINITE_STAIRS, SERPENTINITE_SLAB, SERPENTINITE_WALL);
        offerStairsSlabWall_stone(exporter, SHALE_BRICKS, SHALE_BRICK_STAIRS, SHALE_BRICK_SLAB, SHALE_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, SHALE, SHALE_STAIRS, SHALE_SLAB, SHALE_WALL);
        offerStairsSlabWall_stone(exporter, SHIVERSTONE_SMOOTH, SHIVERSTONE_SMOOTH_STAIRS, SHIVERSTONE_SMOOTH_SLAB, SHIVERSTONE_SMOOTH_WALL);
        offerStairsSlabWall_stone(exporter, SHIVERSTONE_TILES, SHIVERSTONE_TILE_STAIRS, SHIVERSTONE_TILE_SLAB, SHIVERSTONE_TILE_WALL);
        offerStairsSlabWall_stone(exporter, SHIVERSTONE, SHIVERSTONE_STAIRS, SHIVERSTONE_SLAB, SHIVERSTONE_WALL);
        offerStairsSlabWall_stone(exporter, SMOOTH_BRICK, SMOOTH_BRICK_STAIRS, SMOOTH_BRICK_SLAB, SMOOTH_BRICK_WALL);
        offerStairsSlabWall_stone(exporter, STRATIFIED_RED_SANDSTONE, STRATIFIED_RED_SANDSTONE_STAIRS, STRATIFIED_RED_SANDSTONE_SLAB, STRATIFIED_RED_SANDSTONE_WALL);
        offerStairsSlabWall_stone(exporter, STRATIFIED_SANDSTONE, STRATIFIED_SANDSTONE_STAIRS, STRATIFIED_SANDSTONE_SLAB, STRATIFIED_SANDSTONE_WALL);
        //offerStairsSlabWall_stone(exporter, VOLCANIC_STONE, VOLCANIC_STONE_STAIRS, VOLCANIC_STONE_SLAB, VOLCANIC_STONE_WALL);
        offerStairsSlab_stone(exporter, SMOOTH_STONE_TILES, SMOOTH_STONE_TILE_STAIRS, SMOOTH_STONE_TILE_SLAB);
        offerStairsSlab_stone(exporter, STONE_TILES, STONE_TILE_STAIRS, STONE_TILE_SLAB);
        offerStairsSlab_stone(exporter, MOSAIC_BRICK, MOSAIC_BRICK_STAIRS, MOSAIC_BRICK_SLAB);
        offerStairsSlab_stone(exporter, SCORCHSTONE_MOSAIC, SCORCHSTONE_MOSAIC_STAIRS, SCORCHSTONE_MOSAIC_SLAB);
        offerStairsSlab_stone(exporter, POLISHED_BASALT_PATTERNED, POLISHED_BASALT_PATTERNED_STAIRS, POLISHED_BASALT_PATTERNED_SLAB);
        offerStairsSlab_stone(exporter, DRIPSTONE_MOSAIC, DRIPSTONE_MOSAIC_STAIRS, DRIPSTONE_MOSAIC_SLAB);
        offerStairsSlab_stone(exporter, PATTERNED_DRIPSTONE, PATTERNED_DRIPSTONE_STAIRS, PATTERNED_DRIPSTONE_SLAB);
        offerStairsSlab_stone(exporter, ERDSTONE_MOSAIC, ERDSTONE_MOSAIC_STAIRS, ERDSTONE_MOSAIC_SLAB);
        offerStairsSlab_stone(exporter, ERDSTONE_TILES, ERDSTONE_TILE_STAIRS, ERDSTONE_TILE_SLAB);
    }
    
    private static void offerStairs(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
        createStairsRecipe(output, Ingredient.ofItems(input)).criterion(RecipeProvider.hasItem(input), RecipeProvider.conditionsFromItem(input)).offerTo(exporter);
    }
    
    private static void offerStairsSlab(Consumer<RecipeJsonProvider> exporter, ItemConvertible block, ItemConvertible stairs, ItemConvertible slab) {
        offerStairs(exporter, block, stairs);
        offerSlabRecipe(exporter, slab, block);
    }
    
    private static void offerStairsSlabWall(Consumer<RecipeJsonProvider> exporter, ItemConvertible block, ItemConvertible stairs, ItemConvertible slab, ItemConvertible wall) {
        offerStairsSlab(exporter, block, stairs, slab);
        offerWallRecipe(exporter, wall, block);
    }
    
    private static void offerStairsSlab_stone(Consumer<RecipeJsonProvider> exporter, ItemConvertible block, ItemConvertible stairs, ItemConvertible slab) {
        offerStairsSlab(exporter, block, stairs, slab);
        offerStonecuttingRecipe(exporter, block, slab, 2);
        offerStonecuttingRecipe(exporter, block, stairs, 1);
    }
    
    private static void offerStairsSlabWall_stone(Consumer<RecipeJsonProvider> exporter, ItemConvertible block, ItemConvertible stairs, ItemConvertible slab, ItemConvertible wall) {
        offerStairsSlab_stone(exporter, block, stairs, slab);
        offerStonecuttingRecipe(exporter, block, wall, 1);
        offerWallRecipe(exporter, wall, block);
    }
}
