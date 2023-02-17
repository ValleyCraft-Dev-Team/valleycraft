package net.linkle.valleycraft.client.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.minecraft.client.render.entity.DrownedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DrownedRenderer extends DrownedEntityRenderer {

    private final Identifier texture;
    
    public DrownedRenderer(Context context, Identifier texture) {
        super(context);
        this.texture = texture;
    }
    
    @Override
    public Identifier getTexture(DrownedEntity entity) {
        return texture;
    }
    
    @Override
    public Identifier getTexture(ZombieEntity entity) {
        return texture;
    }
    
    /** @param texture file name of the zombie texture. */
    public static EntityRendererFactory<DrownedEntity> create(String texture) {
        var id = Main.makeId("textures/entity/zombies/" + texture + ".png");
        return context -> new DrownedRenderer(context, id);
    }
}
