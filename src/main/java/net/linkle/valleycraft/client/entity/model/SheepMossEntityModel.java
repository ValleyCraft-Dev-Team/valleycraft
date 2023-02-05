package net.linkle.valleycraft.client.entity.model;

import net.linkle.valleycraft.entity.MossySheepEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;

public class SheepMossEntityModel<T extends MossySheepEntity> extends QuadrupedEntityModel<T> {
    private float headAngle;

    public SheepMossEntityModel(ModelPart root) {
        super(root, false, 8.0f, 4.0f, 2.0f, 2.0f, 24);
    }

    @Override
    public void animateModel(T entity, float f, float g, float h) {
        super.animateModel(entity, f, g, h);
        this.head.pivotY = 6.0f + entity.getNeckAngle(h) * 9.0f;
        this.headAngle = entity.getHeadAngle(h);
    }

    @Override
    public void setAngles(T sheepEntity, float f, float g, float h, float i, float j) {
        super.setAngles(sheepEntity, f, g, h, i, j);
        this.head.pitch = this.headAngle;
    }
}
