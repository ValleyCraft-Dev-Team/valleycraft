package net.linkle.valleycraft.client.entity.renderer.snails;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.client.entity.model.snails.SculkSnailEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class SculkSnailEntityRenderer extends MobEntityRenderer<MobEntity, SculkSnailEntityModel<MobEntity>> {

    private final Identifier texture;

    private SculkSnailEntityRenderer(Context context, Identifier texture) {
        super(context, new SculkSnailEntityModel<MobEntity>(context.getPart(SculkSnailEntityModel.LAYER)), 0.3f);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(MobEntity entity) {
        return texture;
    }

    /** @param texture file name of the snail texture. */
    public static EntityRendererFactory<MobEntity> create(String texture) {
        var id = Main.makeId("textures/entity/bugs/snail/" + texture + ".png");
        return context -> new SculkSnailEntityRenderer(context, id);
    }
}
