package net.linkle.valleycraft.client.entity.renderer;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.entity.ChickenVariant;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ChickenEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ChickenVariantRenderer extends MobEntityRenderer<ChickenVariant, ChickenEntityModel<ChickenVariant>> {

    private static final Identifier BROWN_TEXTURE = Main.makeId("textures/entity/chickens/brown.png");
    private static final Identifier BLACK_TEXTURE = Main.makeId("textures/entity/chickens/black.png");
    private static final Identifier TAN_TEXTURE = Main.makeId("textures/entity/chickens/tan.png");
    
    public ChickenVariantRenderer(Context context) {
        super(context, new ChickenEntityModel<>(context.getPart(EntityModelLayers.CHICKEN)), 0.3f);
    }

    @Override
    public Identifier getTexture(ChickenVariant entity) {
        return switch (entity.getChickenType()) {
        case 1 -> BLACK_TEXTURE;
        case 2 -> TAN_TEXTURE;
        default -> BROWN_TEXTURE;
        };
    }
    
    @Override
    protected float getAnimationProgress(ChickenVariant entity, float f) {
        float g = MathHelper.lerp(f, entity.prevFlapProgress, entity.flapProgress);
        float h = MathHelper.lerp(f, entity.prevMaxWingDeviation, entity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0f) * h;
    }
}
