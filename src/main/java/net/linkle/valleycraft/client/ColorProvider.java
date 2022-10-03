package net.linkle.valleycraft.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.linkle.valleycraft.init.ModNaturalBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.ItemConvertible;

@Environment(EnvType.CLIENT)
@SuppressWarnings("unused")
public class ColorProvider {

    public static void intialize() {
        BlockColorProvider blockProvider;
        ItemColorProvider itemProvider;
        
        blockColor((state, world, pos, tintIndex) -> {
            return BiomeColors.getGrassColor(world, pos);
        }, ModNaturalBlocks.BIG_FERN, ModNaturalBlocks.SHORT_GRASS);
        
        itemColor((stack, tintIndex) -> {
            return GrassColors.getColor(0.5, 1.0);
        }, ModNaturalBlocks.BIG_FERN, ModNaturalBlocks.SHORT_GRASS);
        
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, ModNaturalBlocks.APPLE_LEAVES);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, ModNaturalBlocks.APPLE_LEAVES);
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, ModNaturalBlocks.APPLE_LEAVES_EMPTY);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, ModNaturalBlocks.APPLE_LEAVES_EMPTY);
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
