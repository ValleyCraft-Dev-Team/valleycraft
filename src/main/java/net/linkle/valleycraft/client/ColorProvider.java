package net.linkle.valleycraft.client;

import java.util.stream.Stream;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.linkle.valleycraft.init.NaturalBlocks;
import net.linkle.valleycraft.util.BlockConvertible;
import net.minecraft.block.Block;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.item.ItemConvertible;

@Environment(EnvType.CLIENT)
@SuppressWarnings("unused")
class ColorProvider {

    static void intialize() {
        BlockColorProvider blockProvider;
        ItemColorProvider itemProvider;
        
        blockColor((state, world, pos, tintIndex) -> {
            return BiomeColors.getGrassColor(world, pos);
        }, NaturalBlocks.BIG_FERN, NaturalBlocks.SHORT_GRASS);
        
        itemColor((stack, tintIndex) -> {
            return GrassColors.getColor(0.5, 1.0);
        }, NaturalBlocks.BIG_FERN, NaturalBlocks.SHORT_GRASS);
        
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, NaturalBlocks.APPLE_LEAVES);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, NaturalBlocks.APPLE_LEAVES);
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, NaturalBlocks.APPLE_LEAVES_EMPTY);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, NaturalBlocks.APPLE_LEAVES_EMPTY);
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, NaturalBlocks.BUSH);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, NaturalBlocks.BUSH);
        blockColor((state, view, pos, tintIndex) -> tintIndex == 0 ? BiomeColors.getFoliageColor(view, pos) : -1, NaturalBlocks.LARGE_BUSH);
        itemColor((stack, tintIndex) -> tintIndex == 0 ? 4764952 : -1, NaturalBlocks.LARGE_BUSH);
    }
    
    private static void blockColor(BlockColorProvider provider, BlockConvertible... blocks) {
        blockColor(provider, Stream.of(blocks).map(BlockConvertible::asBlock).toArray(Block[]::new));
    }
    
    private static void blockColor(BlockColorProvider provider, Block... blocks) {
        ColorProviderRegistry.BLOCK.register(provider, blocks);
    }
    
    private static void itemColor(ItemColorProvider provider, ItemConvertible... items) {
        ColorProviderRegistry.ITEM.register(provider, items);
    }
}
