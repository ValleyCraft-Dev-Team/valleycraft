package net.linkle.valleycraft.client.block.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.block.entity.WispLanternBlockEntity;
import net.linkle.valleycraft.client.Sprites;
import net.minecraft.block.LanternBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory.Context;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class WispLanternRenderer implements BlockEntityRenderer<WispLanternBlockEntity> {
    public static final SpriteIdentifier VEX_TEXTURE = Sprites.create("entity/sprites/vex_jar");

    public WispLanternRenderer(Context context) {
        
    }
    
    @Override
    @SuppressWarnings("resource")
    public void render(WispLanternBlockEntity entity, float delta, MatrixStack matrix, VertexConsumerProvider provider, int light, int overlay) {
        float val = entity.ticks + delta;
        
        // Parameters
        double bobblingSpeed = 0.095;
        float bobblingStrength = 0.025f;
        float shakeStrength = 8.5f;
        float shakeLength = 0.34f;
        float shakeSpeed = 1.65f;
        
        var camera = MinecraftClient.getInstance().gameRenderer.getCamera();
        var consumer = VEX_TEXTURE.getVertexConsumer(provider, RenderLayer::getEntityCutout);
        
        float offset = entity.getCachedState().get(LanternBlock.HANGING) ? 4.3f/16f : 3.3f/16f;
        matrix.push();
        matrix.translate(0.5, offset+(Math.sin((entity.sine + (double)delta) * bobblingSpeed) * bobblingStrength), 0.5);
        
        // shake animation
        float roll = 0;
        float sin = val * shakeLength;
        roll = MathHelper.sin(val*shakeSpeed) * shakeStrength;
        roll = sin > MathHelper.PI ? 0 : roll*MathHelper.sin(sin);
        
        Sprites.renderBillboard(consumer, camera, matrix.peek(), 0.18f, roll, light, overlay);
        matrix.pop();
    }
}
