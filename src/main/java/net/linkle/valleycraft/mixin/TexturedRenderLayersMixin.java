package net.linkle.valleycraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.linkle.valleycraft.block.entity.DeepslateChestBlockEntity;
import net.linkle.valleycraft.client.Sprites;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;

@Mixin(TexturedRenderLayers.class)
abstract class TexturedRenderLayersMixin {
    
    private static SpriteIdentifier getChestTexture(ChestType type, SpriteIdentifier single, SpriteIdentifier left, SpriteIdentifier right) {
        return switch (type) {
            case LEFT -> left;
            case RIGHT -> right;
            default -> single;
        };
    }
    
    @Inject(method = "getChestTexture", at = @At("HEAD"), cancellable = true)
    static void getChestTexture(BlockEntity entity, ChestType type, boolean christmas, CallbackInfoReturnable<SpriteIdentifier> info) {
        if (entity instanceof DeepslateChestBlockEntity) {
            info.setReturnValue(getChestTexture(type, Sprites.DEEPSLATE_CHEST, Sprites.DEEPSLATE_LEFT_CHEST, Sprites.DEEPSLATE_RIGHT_CHEST));
        }
    }
}
