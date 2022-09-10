package net.linkle.valleycraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemConvertible;

@Environment(EnvType.CLIENT)
@SuppressWarnings("unused")
public class ColorProvider {

    public static void intialize() {
        BlockColorProvider blockProvider;
        ItemColorProvider itemProvider;
        
        blockColor((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColors.getColor(0.5, 1.0);
            } return BiomeColors.getGrassColor(world, pos);
        }, ModBlocks.BIG_FERN, ModBlocks.SHORT_GRASS);
        
        itemColor((stack, tintIndex) -> {
            return GrassColors.getColor(0.5, 1.0);
        }, ModBlocks.BIG_FERN, ModBlocks.SHORT_GRASS);
    }
    
    private static void blockColor(BlockColorProvider provider, Block... block) {
        ColorProviderRegistry.BLOCK.register(provider, block);
    }
    
    private static void itemColor(ItemColorProvider provider, ItemConvertible... item) {
        ColorProviderRegistry.ITEM.register(provider, item);
    }
    
    private static BlockColorProvider newBlockColor(int color) {
        return (state, view, pos, index) -> color;
    }
    
    private static ItemColorProvider newItemColor(int color) {
        return (stack, index) -> color;
    }
    
    private static ItemColorProvider newItemColor(int index, int color) {
        return (stack, idx) -> index == idx ? color : 0xFFFFFFFF;
    }
}
