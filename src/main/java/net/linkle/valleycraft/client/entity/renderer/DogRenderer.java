package net.linkle.valleycraft.client.entity.renderer;

import java.util.List;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.renderer.feature.DogCollarFeatureRenderer;
import net.linkle.valleycraft.entity.DogEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DogRenderer extends MobEntityRenderer<DogEntity, WolfEntityModel<DogEntity>> {

    private static final List<Textures> TEXTURES = List.of(new Textures("border_collie/collie"), new Textures("golden_retriever/retriever"));
    
    public DogRenderer(Context context) {
        super(context, new WolfEntityModel<>(context.getPart(EntityModelLayers.WOLF)), 0.5f);
        addFeature(new DogCollarFeatureRenderer(this));
    }

    @Override
    protected float getAnimationProgress(DogEntity wolfEntity, float f) {
        return wolfEntity.getTailAngle();
    }

    @Override
    public void render(DogEntity wolfEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (wolfEntity.isFurWet()) {
            float brightness = wolfEntity.getFurWetBrightnessMultiplier(g);
            model.setColorMultiplier(brightness, brightness, brightness);
        }
        super.render(wolfEntity, f, g, matrixStack, vertexConsumerProvider, i);
        if (wolfEntity.isFurWet()) {
            model.setColorMultiplier(1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    public Identifier getTexture(DogEntity entity) {
        var texture = TEXTURES.get(entity.getDogType());
        if (entity.isTamed()) {
            return texture.tamed;
        }
        if (entity.hasAngerTime()) {
            return texture.angry;
        }
        return texture.wild;
    }
    
    private static class Textures {
        final Identifier tamed, angry, wild, collar;
        
        public Textures(String type) {
            tamed = id(type.concat("_tame"));
            angry = id(type.concat("_angry"));
            wild = id(type.concat(""));
            collar = id(type.concat("_collar"));
        }
        
        static Identifier id(String path) {
            return Main.makeId("textures/entity/dogs/" + path + ".png");
        }
    }
}
