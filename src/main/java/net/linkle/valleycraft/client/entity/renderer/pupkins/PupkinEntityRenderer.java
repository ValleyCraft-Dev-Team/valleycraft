package net.linkle.valleycraft.client.entity.renderer.pupkins;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.pupkins.PupkinEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PupkinEntityRenderer extends MobEntityRenderer<MobEntity, PupkinEntityModel> {
    private static final Identifier TEXTURE = Main.makeId("textures/entity/pupkin/living_pumpkin.png");

    public PupkinEntityRenderer(Context context) {
        super(context, new PupkinEntityModel(context.getPart(PupkinEntityModel.LAYER)), 0.5f);
    }
    
    @Override
    protected void scale(MobEntity entity, MatrixStack matrices, float amount) {
        if (entity.isBaby()) {
            float size = 0.5f;
            matrices.scale(size, size, size);
        }
    }

    @Override
    public Identifier getTexture(MobEntity entity) {
        return TEXTURE;
    }
}
