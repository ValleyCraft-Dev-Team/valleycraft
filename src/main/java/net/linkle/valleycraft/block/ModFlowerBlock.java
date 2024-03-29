package net.linkle.valleycraft.block;

import static net.linkle.valleycraft.block.ModFlowerBlock.StewEffect.*;

import java.util.Optional;
import java.util.OptionalInt;

import org.jetbrains.annotations.Nullable;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

/** Extension of the vanilla {@link FlowerBlock} class with randomized effect in stew. 
 *  @author AndEditor7 */
public class ModFlowerBlock extends FlowerBlock {
    
    //  If you want weights, tell me so I can rewrite it - AndEditor7
    /** List of unique effects. Most effects are copied from vanilla flowers */
    private static final ImmutableList<StewEffect> EFFECTS = Util.make(() -> {
        var builder = new ImmutableList.Builder<StewEffect>();
        builder.add(copy(Blocks.DANDELION)); // saturation
        builder.add(copy(Blocks.POPPY)); // night vision
        builder.add(copy(Blocks.ALLIUM)); // fire resistance
        builder.add(copy(Blocks.AZURE_BLUET)); // blindness
        builder.add(copy(Blocks.RED_TULIP)); // weakness
        builder.add(copy(Blocks.OXEYE_DAISY)); // regeneration
        builder.add(copy(Blocks.CORNFLOWER)); // jump boost
        builder.add(copy(Blocks.LILY_OF_THE_VALLEY)); // poison
        //builder.add(create(StatusEffects.ABSORPTION, 5)); // custom effect!
        return builder.build();
    });
    
    private Optional<StatusEffect> effectInStew;
    private OptionalInt effectDuration;
    
    /** Create the block with random effect in stew. */
    public ModFlowerBlock(Settings settings) {
        this(null, -1, settings);
    }
    
    /** @param flower copy the effect from that flower block. */
    public ModFlowerBlock(Block flower, Settings settings) {
        this(settings);
        setEffect((FlowerBlock)flower);
    }

    /** Create the block with a custom effect in stew. */
    public ModFlowerBlock(@Nullable StatusEffect effectInStew, int effectDuration, Settings settings) {
        super(effectInStew==null?StatusEffects.LUCK:effectInStew, effectDuration, settings);
        this.effectInStew = Optional.ofNullable(effectInStew);
        this.effectDuration = effectDuration < 0 ? OptionalInt.empty() : OptionalInt.of(effectDuration);
    }
    
    @Override
    public StatusEffect getEffectInStew() {
        if (effectInStew.isPresent()) {
            return effectInStew.get();
        }
        init();
        return effectInStew.get();
    }

    @Override
    public int getEffectInStewDuration() {
        if (effectDuration.isPresent()) {
            return effectDuration.getAsInt();
        }
        init();
        return effectDuration.getAsInt();
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
        
        // Use the random effect from the effects list.
        var index = Math.abs(id.hashCode() % EFFECTS.size());
        setEffect(EFFECTS.get(index));
    }
    
    private void setEffect(StewEffect effect) {
        effectInStew = Optional.of(effect.getEffect());
        effectDuration = OptionalInt.of(effect.getDuration());
    }
    
    private void setEffect(FlowerBlock flower) {
        effectInStew = Optional.of(flower.getEffectInStew());
        effectDuration = OptionalInt.of(flower.getEffectInStewDuration());
    }
    
    public static interface StewEffect {
        StatusEffect getEffect();
        int getDuration();
        static StewEffect copy(Block flowerBlock) {
            var flower = (FlowerBlock)flowerBlock;
            return create(flower.getEffectInStew(), flower.getEffectInStewDuration());
        }
        static StewEffect create(StatusEffect effectInStew, int effectDuration) {
            return new StewEffect() {
                @Override
                public StatusEffect getEffect() {
                    return effectInStew;
                }
                @Override
                public int getDuration() {
                    return effectDuration;
                }
            };
        }
    }
}
