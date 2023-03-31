package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.renderer.feature.DogCollarFeatureRenderer;
import net.linkle.valleycraft.entity.DogEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.WolfEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DogRenderer extends MobEntityRenderer<DogEntity, WolfEntityModel<DogEntity>> {

	private final Textures textures;
	
    public DogRenderer(Context context, Textures textures) {
        super(context, new WolfEntityModel<>(context.getPart(EntityModelLayers.WOLF)), 0.5f);
        this.textures = textures;
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
        if (entity.isTamed()) {
            return textures.tamed;
        }
        if (entity.hasAngerTime()) {
            return textures.angry;
        }
        return textures.wild;
    }
    
    /** @param texture file name of the dog texture. */
    public static EntityRendererFactory<DogEntity> create(String texture) {
        return context -> new DogRenderer(context, new Textures(texture));
    }
    
    private static class Textures {
        final Identifier tamed, angry, wild;
        
        public Textures(String type) {
            tamed = id(type.concat("_tame"));
            angry = id(type.concat("_angry"));
            wild = id(type);
        }
        
        static Identifier id(String path) {
            return Main.makeId("textures/entity/dogs/" + path + ".png");
        }
    }
}
