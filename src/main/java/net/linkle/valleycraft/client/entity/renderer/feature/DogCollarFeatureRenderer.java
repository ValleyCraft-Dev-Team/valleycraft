package net.linkle.valleycraft.client.entity.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.entity.DogEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DogCollarFeatureRenderer
extends FeatureRenderer<DogEntity, WolfEntityModel<DogEntity>> {
    private static final Identifier SKIN = new Identifier("textures/entity/wolf/wolf_collar.png");

    public DogCollarFeatureRenderer(FeatureRendererContext<DogEntity, WolfEntityModel<DogEntity>> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, DogEntity entity, float f, float g, float h, float j, float k, float l) {
        if (!entity.isTamed() || entity.isInvisible()) {
            return;
        }
        float[] fs = entity.getCollarColor().getColorComponents();
        DogCollarFeatureRenderer.renderModel(this.getContextModel(), SKIN, matrixStack, vertexConsumerProvider, i, entity, fs[0], fs[1], fs[2]);
    }
}