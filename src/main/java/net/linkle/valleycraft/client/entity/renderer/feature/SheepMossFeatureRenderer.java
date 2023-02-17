package net.linkle.valleycraft.client.entity.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.MossySheepEntityModel;
import net.linkle.valleycraft.client.entity.model.SheepMossEntityModel;
import net.linkle.valleycraft.entity.MossySheepEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SheepMossFeatureRenderer extends FeatureRenderer<MossySheepEntity, MossySheepEntityModel<MossySheepEntity>> {
    private static final Identifier SKIN = Main.makeId("textures/entity/sheep/mossy_sheep_fur.png");
    private final SheepMossEntityModel<MossySheepEntity> model;
    
    public SheepMossFeatureRenderer(FeatureRendererContext<MossySheepEntity, MossySheepEntityModel<MossySheepEntity>> context, EntityModelLoader loader) {
        super(context);
        model = new SheepMossEntityModel<>(loader.getModelPart(EntityModelLayers.SHEEP_FUR));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, MossySheepEntity entity, float f, float g, float h, float j, float k, float l) {
        if (entity.isSheared()) return;
        if (entity.isInvisible()) {
            var client = MinecraftClient.getInstance();
            if (client.hasOutline(entity)) {
                getContextModel().copyStateTo(this.model);
                model.animateModel(entity, f, g, h);
                model.setAngles(entity, f, g, j, k, l);
                VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(RenderLayer.getOutline(SKIN));
                model.render(matrixStack, vertexConsumer, i, LivingEntityRenderer.getOverlay(entity, 0.0f), 0.0f, 0.0f, 0.0f, 1.0f);
            }
            return;
        }
        FeatureRenderer.render(this.getContextModel(), model, SKIN, matrixStack, vertexConsumerProvider, i, entity, f, g, j, k, l, h, 1, 1, 1);
    }
}
