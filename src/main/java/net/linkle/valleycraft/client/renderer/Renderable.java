package net.linkle.valleycraft.client.renderer;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;

/**
 * The Renderable interface for our renderers
 * 
 * @author AndEditor7
 */
@FunctionalInterface
public interface Renderable {
    void render(VertexConsumer consumer, MatrixStack.Entry matrix, int light, int overlay);
    
    default void render(VertexConsumer consumer, MatrixStack.Entry matrix, int light) {
        render(consumer, matrix, light, OverlayTexture.DEFAULT_UV);
    }
}
