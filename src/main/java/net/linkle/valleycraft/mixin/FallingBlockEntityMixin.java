package net.linkle.valleycraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.linkle.valleycraft.extension.FallingBlockEntityExt;
import net.minecraft.entity.FallingBlockEntity;

@Mixin(FallingBlockEntity.class)
abstract class FallingBlockEntityMixin implements FallingBlockEntityExt {
    
    @Shadow
    private boolean destroyedOnLanding;
    
    @Override
    public void setDestroyedOnLanding() {
        destroyedOnLanding = true;
    }
}
