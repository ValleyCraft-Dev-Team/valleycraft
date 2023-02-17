package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.minecraft.client.render.entity.CowEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CowRenderer extends CowEntityRenderer {

    private final Identifier texture;
    
    public CowRenderer(Context context, Identifier texture) {
        super(context);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(CowEntity entity) {
        return texture;
    }
    
    /** @param texture file name of the cow texture. */
    public static EntityRendererFactory<CowEntity> create(String texture) {
        var id = Main.makeId("textures/entity/cows/" + texture + ".png");
        return context -> new CowRenderer(context, id);
    }
}
