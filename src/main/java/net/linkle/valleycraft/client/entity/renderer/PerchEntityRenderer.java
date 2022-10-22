package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.PerchEntityModel;
import net.linkle.valleycraft.client.entity.model.RedPorgyEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(value=EnvType.CLIENT)
public class PerchEntityRenderer extends MobEntityRenderer<FishEntity, PerchEntityModel<FishEntity>> {

    private final Identifier texture;

    private PerchEntityRenderer(EntityRendererFactory.Context context, Identifier texture) {
        super(context, new PerchEntityModel<FishEntity>(context.getPart(PerchEntityModel.LAYER)), 0.3f);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(FishEntity entity) {
        return texture;
    }
    
    @Override
    protected void setupTransforms(FishEntity entity, MatrixStack matrices, float animationProgress, float bodyYaw, float tickDeltah) {
        super.setupTransforms(entity, matrices, animationProgress, bodyYaw, tickDeltah);
        float angle = 4.3f * MathHelper.sin(0.6f * animationProgress);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(angle));
        if (!entity.isTouchingWater()) {
            matrices.translate(0.1f, 0.1f, -0.1f);
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(90.0f));
        }
    }

    /** @param texture file name of the snail texture. */
    public static EntityRendererFactory<FishEntity> create(String texture) {
        var id = Main.makeId("textures/entity/fish/" + texture + ".png");
        return context -> new PerchEntityRenderer(context, id);
    }
}
