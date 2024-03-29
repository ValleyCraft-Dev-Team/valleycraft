package net.linkle.valleycraft.client.entity.model.snails;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.linkle.valleycraft.Main;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.MobEntity;

//Made with Blockbench 4.2.2
@Environment(EnvType.CLIENT)
public class SnailEntityModel<T extends MobEntity> extends SinglePartEntityModel<T> {
    
    public static final EntityModelLayer LAYER = new EntityModelLayer(Main.makeId("snail"), "main");
    
	private final ModelPart main;

	public SnailEntityModel(ModelPart root) {
		this.main = root.getChild("main");
	}

	public static TexturedModelData getTexturedModelData() {
	    var modelData = new ModelData();
        var modelPartData = modelData.getRoot();

        var main = modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, 23.0F, -1.5F, 2.0F, 1.0F, 6.0F, Dilation.NONE)
		.uv(0, 7).cuboid(-1.5F, 19.5F, -1.5F, 3.0F, 4.0F, 4.0F, Dilation.NONE)
		.uv(10, 0).cuboid(-1.0F, 22.0F, -3.5F, 2.0F, 2.0F, 2.0F, Dilation.NONE), ModelTransform.NONE);

        main.addChild("cube", ModelPartBuilder.create().uv(0, 0).cuboid(0.5F, 18.5F, -8.75F, 1.0F, 2.0F, 0.0F, Dilation.NONE)
		.uv(0, 2).cuboid(-1.5F, 18.5F, -8.75F, 1.0F, 2.0F, 0.0F, Dilation.NONE), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}
	
	@Override
    public ModelPart getPart() {
        return main;
    }

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
	    main.render(matrices, vertices, light, overlay);
	}
}