package net.linkle.valleycraft.client.entity.model;

import static net.minecraft.client.render.entity.model.EntityModelPartNames.*;

import net.linkle.valleycraft.Main;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.2.2
public class PupkinEntityModel extends SinglePartEntityModel<MobEntity> {

    public static final EntityModelLayer LAYER = new EntityModelLayer(Main.makeId("pupkin"), "main");

    private static final String STEM = "stem";
    private static final String TONGUE = "tongue";

    private final ModelPart root, body, tongue;
    private final ModelPart leftHindLeg;
    private final ModelPart rightHindLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightFrontLeg;

    public PupkinEntityModel(ModelPart root) {
        this.root = root;
        this.body = root.getChild(BODY);

        this.rightHindLeg = root.getChild(RIGHT_HIND_LEG);
        this.leftHindLeg = root.getChild(LEFT_HIND_LEG);
        this.rightFrontLeg = root.getChild(RIGHT_FRONT_LEG);
        this.leftFrontLeg = root.getChild(LEFT_FRONT_LEG);
        this.tongue = body.getChild(TONGUE);
    }

    public static TexturedModelData getTexturedModelData() {
        var modelData = new ModelData();
        var modelPartData = modelData.getRoot();

        var main = modelPartData.addChild(BODY, ModelPartBuilder.create().uv(0, 0).cuboid(-5, -14, -5, 10, 10, 10, new Dilation(0)), ModelTransform.pivot(0, 24, 0));
        modelPartData.addChild(RIGHT_HIND_LEG, ModelPartBuilder.create().uv(16, 28).cuboid(-2, 0, -2, 4, 4, 4, new Dilation(0)), ModelTransform.pivot(-3, 20, 3));
        modelPartData.addChild(LEFT_HIND_LEG, ModelPartBuilder.create().uv(0, 28).cuboid(-2, 0, -2, 4, 4, 4, new Dilation(0)), ModelTransform.pivot(3, 20, 3));
        modelPartData.addChild(RIGHT_FRONT_LEG, ModelPartBuilder.create().uv(16, 20).cuboid(-2, 0, -2, 4, 4, 4, new Dilation(0)), ModelTransform.pivot(-3, 20, -3));
        modelPartData.addChild(LEFT_FRONT_LEG, ModelPartBuilder.create().uv(0, 20).cuboid(-2, 0, -2, 4, 4, 4, new Dilation(0)), ModelTransform.pivot(3, 20, -3));

        main.addChild(STEM, ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -17.0F, -5.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));
        main.addChild(TONGUE, ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -5.45F, -8.0F, 2.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(MobEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch) {
        final float swingSpeed = 1.2f; // 0.6662f
        final float swingStrength = 1.3f; // 1.4f
        leftHindLeg.pitch = MathHelper.cos(limbSwing * swingSpeed) * swingStrength * limbSwingAmount;
        rightHindLeg.pitch = MathHelper.cos(limbSwing * swingSpeed + MathHelper.PI) * swingStrength * limbSwingAmount;
        leftFrontLeg.pitch = MathHelper.cos(limbSwing * swingSpeed + MathHelper.PI) * swingStrength * limbSwingAmount;
        rightFrontLeg.pitch = MathHelper.cos(limbSwing * swingSpeed) * swingStrength * limbSwingAmount;

        // tongue animation
        float sin = MathHelper.sin(ageInTicks) * 0.3f;
        sin -= 0.2f;
        tongue.pivotY = sin;
        tongue.pivotZ = -sin * 0.465f;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}