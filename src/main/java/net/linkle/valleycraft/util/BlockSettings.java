package net.linkle.valleycraft.util;

import net.linkle.valleycraft.init.BlockMats;
import net.linkle.valleycraft.init.BlockSounds;
import net.minecraft.block.AbstractBlock.Settings;

public class BlockSettings {
    public static Settings pot() {
        return Settings.of(BlockMats.POT).sounds(BlockSounds.POT.sound).nonOpaque().breakInstantly();
    }
    
    public static Settings urn() {
        return Settings.of(BlockMats.POT).sounds(BlockSounds.POT.sound).nonOpaque().strength(0.2f);
    }
}
