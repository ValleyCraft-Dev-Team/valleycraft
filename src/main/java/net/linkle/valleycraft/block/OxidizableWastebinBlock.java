package net.linkle.valleycraft.block;

import net.minecraft.block.Oxidizable;

public class OxidizableWastebinBlock extends WastebinBlock implements Oxidizable {

    private final OxidationLevel level;
    
    public OxidizableWastebinBlock(OxidationLevel level) {
        this.level = level;
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return level;
    }
}
