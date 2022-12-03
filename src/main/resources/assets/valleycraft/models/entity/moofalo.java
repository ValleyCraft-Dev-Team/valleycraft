// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

/*
public class custom_model extends EntityModel<Entity> {
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leg3;
	private final ModelPart leg2;
	private final ModelPart leg1;
	private final ModelPart leg0;
	public custom_model(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.leg3 = root.getChild("leg3");
		this.leg2 = root.getChild("leg2");
		this.leg1 = root.getChild("leg1");
		this.leg0 = root.getChild("leg0");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -6.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F))
		.uv(52, 7).cuboid(4.0F, -7.0F, -5.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F))
		.uv(52, 7).cuboid(-6.0F, -7.0F, -5.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 4.0F, -8.0F));

		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(0, 55).cuboid(-7.0F, -11.0F, -10.0F, 14.0F, 13.0F, 14.0F, new Dilation(0.0F))
		.uv(0, 32).cuboid(-7.0F, 2.0F, -9.0F, 14.0F, 7.0F, 12.0F, new Dilation(0.0F))
		.uv(18, 4).cuboid(-6.0F, -10.0F, -7.0F, 12.0F, 18.0F, 10.0F, new Dilation(0.0F))
		.uv(52, 0).cuboid(-2.0F, 2.0F, -8.0F, 4.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 2.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData leg3 = modelPartData.addChild("leg3", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, 12.0F, -6.0F));

		ModelPartData leg2 = modelPartData.addChild("leg2", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 12.0F, -6.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(4.0F, 12.0F, 7.0F));

		ModelPartData leg0 = modelPartData.addChild("leg0", ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 12.0F, 7.0F));
		return TexturedModelData.of(modelData, 64, 128);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg1.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		leg0.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
} */