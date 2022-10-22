package net.linkle.valleycraft.client.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class PerchEntityModel<T extends Entity> extends CodEntityModel<T> {

    /** Doesn't need to resister (It uses Cod's layer) */
    public static final EntityModelLayer LAYER = EntityModelLayers.COD;

    public PerchEntityModel(ModelPart root) {
        super(root);
    }
}
