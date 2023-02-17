package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.BearEntityModel;
import net.linkle.valleycraft.entity.BearEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BrownBearRenderer extends MobEntityRenderer<BearEntity, BearEntityModel<BearEntity>> {
    private static final Identifier TEXTURE = Main.makeId("textures/entity/bear/brown_bear.png");

    public BrownBearRenderer(EntityRendererFactory.Context context) {
        super(context, new BearEntityModel<>(context.getPart(BearEntityModel.LAYER)), 0.9f);
    }

    @Override
    public Identifier getTexture(BearEntity entity) {
        return TEXTURE;
    }
}
