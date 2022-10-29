package net.linkle.valleycraft.block;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

public class ModFlowerBlock extends FlowerBlock {
    
    // List of flowers with unique effects.
    private static final ImmutableList<FlowerBlock> FLOWERS = Util.make(() -> {
        var builder = new ImmutableList.Builder<FlowerBlock>();
        builder.add((FlowerBlock)Blocks.DANDELION); // saturation
        builder.add((FlowerBlock)Blocks.POPPY); // night vision
        builder.add((FlowerBlock)Blocks.ALLIUM); // fire resistance
        builder.add((FlowerBlock)Blocks.AZURE_BLUET); // blindness
        builder.add((FlowerBlock)Blocks.RED_TULIP); // weakness
        builder.add((FlowerBlock)Blocks.OXEYE_DAISY); // regeneration
        builder.add((FlowerBlock)Blocks.CORNFLOWER); // jump boost
        builder.add((FlowerBlock)Blocks.LILY_OF_THE_VALLEY); // poison
        return builder.build();
    });
    
    private StatusEffect effectInStew;
    private int effectDuration;
    
    /** Create the block with random effect in stew. */
    public ModFlowerBlock(Settings settings) {
        this(StatusEffects.LUCK, -1, settings);
    }
    
    /** @param flower copy the effect from that flower block. */
    public ModFlowerBlock(Block flower, Settings settings) {
        this(settings);
        setEffect((FlowerBlock)flower);
    }

    public ModFlowerBlock(StatusEffect effectInStew, int effectDuration, Settings settings) {
        super(effectInStew, effectDuration, settings);
        this.effectInStew = effectInStew;
        this.effectDuration = effectDuration;
    }
    
    @Override
    public StatusEffect getEffectInStew() {
        if (effectInStew != StatusEffects.LUCK) {
            return effectInStew;
        }
        init();
        return effectInStew;
    }

    @Override
    public int getEffectInStewDuration() {
        if (effectDuration != -1) {
            return effectDuration;
        }
        init();
        return effectDuration;
    }
    
    private void init() {
        // Get the block id without the namespace "valleycraft"
        var id = Registry.BLOCK.getId(this).getPath();
        
        // Use default effect for the variant flower.
        
        if (id.contains("tulip")) {
            setEffect((FlowerBlock)Blocks.RED_TULIP);
            return;
        }
        
        if (id.contains("poppy")) {
            setEffect((FlowerBlock)Blocks.POPPY);
            return;
        }
        
        // Use the random effect listed from flowers.
        var index = Math.abs(id.hashCode() % FLOWERS.size());
        setEffect(FLOWERS.get(index));
    }
    
    private void setEffect(FlowerBlock flower) {
        effectInStew = flower.getEffectInStew();
        effectDuration = flower.getEffectInStewDuration();
    }
}
