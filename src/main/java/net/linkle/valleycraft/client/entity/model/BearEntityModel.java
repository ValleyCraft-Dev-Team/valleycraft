package net.linkle.valleycraft.client.entity.model;

import net.linkle.valleycraft.Main;
import net.linkle.valleycraft.entity.BearEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.math.MathHelper;

public class BearEntityModel<T extends BearEntity> extends QuadrupedEntityModel<T> {
    
    public static final EntityModelLayer LAYER = new EntityModelLayer(Main.makeId("bear"), "main");

    public BearEntityModel(ModelPart root) {
        super(root, true, 23.0f, 4.8f, 2.7f, 3.0f, 49);
    }

    public static TexturedModelData getTexturedModelData() {
        var model = new ModelData();
        var part = model.getRoot();

        var body = part.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(0, 25).cuboid(-9.5F, -13.0F, -6.5F, 19.0F, 26.0F, 13.0F, Dilation.NONE), ModelTransform.of(0.0F, 10.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        var head = part.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 6).cuboid(-6.5F, -5.0F, -4.0F, 13.0F, 10.0F, 9.0F, Dilation.NONE)
        .uv(42, 16).cuboid(-3.5F, 0.0F, -8.0F, 7.0F, 5.0F, 4.0F, Dilation.NONE)
        .uv(52, 25).cuboid(-8.5F, -8.0F, -1.0F, 5.0F, 4.0F, 1.0F, Dilation.NONE)
        .uv(52, 25).cuboid(3.5F, -8.0F, -1.0F, 5.0F, 4.0F, 1.0F, Dilation.NONE), ModelTransform.pivot(0.0F, 11.5F, -17.0F));

        var leg0 = part.addChild(EntityModelPartNames.RIGHT_HIND_LEG, ModelPartBuilder.create().uv(40, 0).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, Dilation.NONE), ModelTransform.pivot(-5.5F, 15.0F, 9.0F));

        var leg1 = part.addChild(EntityModelPartNames.LEFT_HIND_LEG, ModelPartBuilder.create().uv(40, 0).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, Dilation.NONE), ModelTransform.pivot(5.5F, 15.0F, 9.0F));

        var leg2 = part.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(40, 0).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, Dilation.NONE), ModelTransform.pivot(-5.5F, 15.0F, -9.0F));

        var leg3 = part.addChild(EntityModelPartNames.LEFT_FRONT_LEG, ModelPartBuilder.create().uv(40, 0).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 9.0F, 6.0F, Dilation.NONE), ModelTransform.pivot(5.5F, 15.0F, -9.0F));

        return TexturedModelData.of(model, 64, 64);
    }
    
    @Override
    public void setAngles(T entity, float f, float g, float h, float i, float j) {
        super.setAngles(entity, f, g, h, i, j);
        float k = h - (float)entity.age;
        float l = entity.getWarningAnimationProgress(k);
        l *= l;
        float m = 1.0f - l;
        body.pitch = 1.5707964f - l * MathHelper.PI * 0.4f;
        body.pivotY = 9.0f * m + 2.0f * l;
        body.pivotZ = 0.0f * m + 5.0f * l;
        rightFrontLeg.pivotY = 14.0f * m - 6.0f * l;
        rightFrontLeg.pivotZ = -8.0f * m - 4.0f * l;
        rightFrontLeg.pitch -= l * MathHelper.PI * 0.5f;
        leftFrontLeg.pivotY = this.rightFrontLeg.pivotY;
        leftFrontLeg.pivotZ = this.rightFrontLeg.pivotZ;
        leftFrontLeg.pitch -= l * MathHelper.PI * 0.5f;
        if (child) {
            head.pivotY = 10.0f * m - 9.0f * l;
            head.pivotZ = -16.0f * m - 7.0f * l;
        } else {
            head.pivotY = 10.0f * m - 12.0f * l;
            head.pivotZ = -16.0f * m - 2.0f * l;
        }
        head.pitch += l * MathHelper.PI * 0.15f;
    }
}
