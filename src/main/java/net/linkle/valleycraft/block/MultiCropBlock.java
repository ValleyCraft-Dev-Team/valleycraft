package net.linkle.valleycraft.block;

import java.util.Random;
import java.util.function.Function;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;

public class MultiCropBlock extends ModCropBlock {
    
    private Function<Random, ItemStack> pickFunction;

    public MultiCropBlock(Settings settings) {
        this(settings, null);
    }
    
    public MultiCropBlock(Settings settings, Function<Random, ItemStack> pickFunction) {
        super(settings);
        setPickable(pickFunction);
    }
    
    public MultiCropBlock setPickable(Function<Random, ItemStack> pickFunction) {
        this.pickFunction = pickFunction;
        return this;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return this;
    }

    @Override
    protected ItemStack getPickItem(Random random) {
        return pickFunction == null ? null : pickFunction.apply(random);
    }
    
    public static Settings settings() {
        return Settings.copy(Blocks.WHEAT);
    }
}
