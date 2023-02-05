package net.linkle.valleycraft.client.entity.renderer;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.entity.DuckEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class DuckRenderer extends MobEntityRenderer<DuckEntity, ChickenEntityModel<DuckEntity>> {
    private static final Identifier TEXTURE = Main.makeId("textures/entity/duck/duck.png");

    public DuckRenderer(EntityRendererFactory.Context context) {
        super(context, new ChickenEntityModel<>(context.getPart(EntityModelLayers.CHICKEN)), 0.3f);
    }

    @Override
    public Identifier getTexture(DuckEntity entity) {
        return TEXTURE;
    }

    @Override
    protected float getAnimationProgress(DuckEntity entity, float f) {
        float g = MathHelper.lerp(f, entity.prevFlapProgress, entity.flapProgress);
        float h = MathHelper.lerp(f, entity.prevMaxWingDeviation, entity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0f) * h;
    }
}
