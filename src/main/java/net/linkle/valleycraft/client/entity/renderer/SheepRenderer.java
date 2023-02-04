package net.linkle.valleycraft.client.entity.renderer;

import net.linkle.valleycraft.Main;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.SheepEntityRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.Identifier;

public class SheepRenderer extends SheepEntityRenderer {

    private final Identifier texture;
    
    public SheepRenderer(Context context, Identifier texture) {
        super(context);
        this.texture = texture;
    }

    @Override
    public Identifier getTexture(SheepEntity entity) {
        return texture;
    }
    
    /** @param texture file name of the sheep texture. */
    public static EntityRendererFactory<SheepEntity> create(String texture) {
        var id = Main.makeId("textures/entity/sheep/" + texture + ".png");
        return context -> new SheepRenderer(context, id);
    }
}
