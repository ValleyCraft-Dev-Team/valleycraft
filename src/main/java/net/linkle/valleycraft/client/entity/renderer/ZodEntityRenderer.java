package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.SnailEntityModel;
import net.linkle.valleycraft.client.entity.model.ZodEntityModel;
import net.minecraft.client.render.entity.CodEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class ZodEntityRenderer extends MobEntityRenderer<MobEntity, ZodEntityModel<MobEntity>> {

    private final Identifier texture;

    private ZodEntityRenderer(EntityRendererFactory.Context context, Identifier texture) {
        super(context, new ZodEntityModel<MobEntity>(context.getPart(ZodEntityModel.LAYER)), 0.3f);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(MobEntity entity) {
        return texture;
    }

    /** @param texture file name of the snail texture. */
    public static EntityRendererFactory<MobEntity> create(String texture) {
        var id = Main.makeId("textures/entity/fish" + texture + ".png");
        return context -> new ZodEntityRenderer(context, id);
    }
}
