package net.linkle.valleycraft.init;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public enum ModBlockSoundGroup {
    POT(ModSounds.POT_BREAK.sound, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL),
    MOSS_STONE(SoundEvents.BLOCK_STONE_BREAK, SoundEvents.BLOCK_MOSS_STEP, SoundEvents.BLOCK_STONE_PLACE, SoundEvents.BLOCK_STONE_HIT, SoundEvents.BLOCK_MOSS_FALL),
    MOSS_SHALE(SoundEvents.BLOCK_BASALT_BREAK, SoundEvents.BLOCK_MOSS_STEP, SoundEvents.BLOCK_BASALT_PLACE, SoundEvents.BLOCK_BASALT_HIT, SoundEvents.BLOCK_MOSS_FALL),
    MOSS_DEEPSLATE(SoundEvents.BLOCK_DEEPSLATE_BREAK, SoundEvents.BLOCK_MOSS_STEP, SoundEvents.BLOCK_DEEPSLATE_PLACE, SoundEvents.BLOCK_DEEPSLATE_HIT, SoundEvents.BLOCK_MOSS_FALL);
    
    // ### The Enum Class Itself ###
    
    public final BlockSoundGroup sound;
    
    ModBlockSoundGroup(SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        this(1, 1, breakSound, stepSound, placeSound, hitSound, fallSound);
    }
    
    ModBlockSoundGroup(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        sound = new BlockSoundGroup(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
    }
}
