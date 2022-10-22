package net.linkle.valleycraft.client.entity.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.SalmonEntityModel;
import net.minecraft.entity.Entity;

@Environment(EnvType.CLIENT)
public class BonefinEntityModel<T extends Entity> extends SalmonEntityModel<T> {

    /** Doesn't need to resister (It uses Cod's layer) */
    public static final EntityModelLayer LAYER = EntityModelLayers.SALMON;

    public BonefinEntityModel(ModelPart root) {
        super(root);
    }
}
