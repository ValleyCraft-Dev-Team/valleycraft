package net.linkle.valleycraft.client.entity.renderer;

import net.linkle.valleycraft.Main;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SalmonEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

public class SalmonEntityRenderer extends MobEntityRenderer<FishEntity, SalmonEntityModel<FishEntity>> {
    
    private final Identifier texture;

    public SalmonEntityRenderer(EntityRendererFactory.Context context, Identifier texture) {
        super(context, new SalmonEntityModel<>(context.getPart(EntityModelLayers.SALMON)), 0.3f);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(FishEntity codEntity) {
        return texture;
    }

    @Override
    protected void setupTransforms(FishEntity entity, MatrixStack matrixStack, float f, float g, float h) {
        super.setupTransforms(entity, matrixStack, f, g, h);
        float i = 4.3f * MathHelper.sin(0.6f * f);
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(i));
        if (!entity.isTouchingWater()) {
            matrixStack.translate(0.1f, 0.1f, -0.1f);
            matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90.0f));
        }
    }
    
    /** @param texture file name of the snail texture. */
    public static EntityRendererFactory<FishEntity> create(String texture) {
        var id = Main.makeId("textures/entity/fish/" + texture + ".png");
        return context -> new SalmonEntityRenderer(context, id);
    }
}
