package net.linkle.valleycraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.linkle.valleycraft.block.SprinklerBlock;
import net.linkle.valleycraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

@Mixin(FarmlandBlock.class)
class FarmlandBlockMixin extends Block {

    FarmlandBlockMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "isWaterNearby", at = @At("HEAD"), cancellable = true)
    private static void isSprinklerNearby(WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> info) {
        for (var p : BlockPos.iterate(pos.add(-8, -1, -8), pos.add(8, 1, 8))) {
            var state = world.getBlockState(p);
            if (state.isOf(ModBlocks.SPRINKLER) && state.get(SprinklerBlock.SPRINKLING)) {
                info.setReturnValue(true);
            }
        }
    }
}
