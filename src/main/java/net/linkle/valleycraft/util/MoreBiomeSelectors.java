package net.linkle.valleycraft.util;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tag.TagKey;
import net.minecraft.world.biome.Biome;

/** Like {@link BiomeSelectors} with more stuff. */
public class MoreBiomeSelectors {
	
	/** {@link BiomeSelectors#tag(TagKey)} */
	public static Predicate<BiomeSelectionContext> tag(TagKey<Biome> tag) {
		return BiomeSelectors.tag(tag);
	}
    
    @SafeVarargs
    public static Predicate<BiomeSelectionContext> allMatchByTag(TagKey<Biome>... keys) {
        return allMatchByTag(Set.of(keys));
    }
    
    public static Predicate<BiomeSelectionContext> allMatchByTag(Collection<TagKey<Biome>> keys) {
        return context -> keys.stream().allMatch(context::hasTag);
    }
	
	/** {@link BiomeSelectors#tag(TagKey)} */
	public static Predicate<BiomeSelectionContext> includeByTag(TagKey<Biome> tag) {
		return BiomeSelectors.tag(tag);
	}
	
	@SafeVarargs
	public static Predicate<BiomeSelectionContext> includeByTag(TagKey<Biome>... keys) {
		return includeByTag(Set.of(keys));
	}

	public static Predicate<BiomeSelectionContext> includeByTag(Collection<TagKey<Biome>> keys) {
		return context -> keys.stream().anyMatch(context::hasTag);
	}
	
    @SafeVarargs
    public static Predicate<BiomeSelectionContext> excludeByTag(TagKey<Biome>... keys) {
        return excludeByTag(Set.of(keys));
    }
    
    public static Predicate<BiomeSelectionContext> excludeByTag(Collection<TagKey<Biome>> keys) {
        return context -> keys.stream().noneMatch(context::hasTag);
    }
}
