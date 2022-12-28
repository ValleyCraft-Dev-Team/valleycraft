// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

/*
public class custom_model extends EntityModel<Entity> {
	private final ModelPart head;
	private final ModelPart tentacles;
	private final ModelPart cube_r1;
	private final ModelPart shell;
	public custom_model(ModelPart root) {
		this.head = root.getChild("head");
		this.shell = root.getChild("shell");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(17, 22).cuboid(-1.5F, -12.0F, -8.5F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 35).cuboid(-0.5F, -12.5F, -9.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 25.0F, 3.5F));

		ModelPartData tentacles = head.addChild("tentacles", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.2F, -9.95F, -1.4399F, 0.0F, 0.0F));

		ModelPartData cube_r1 = tentacles.addChild("cube_r1", ModelPartBuilder.create().uv(15, 18).cuboid(2.25F, -7.0166F, -1.5219F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 18).cuboid(1.5F, -6.0166F, -3.5219F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 27).cuboid(-0.5F, -6.0166F, -3.5219F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 27).cuboid(-1.25F, -7.0166F, -1.5219F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		ModelPartData shell = modelPartData.addChild("shell", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -16.0F, -6.0F, 4.0F, 7.0F, 11.0F, new Dilation(0.0F))
		.uv(19, 0).cuboid(-1.0F, -9.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 18).cuboid(-1.0F, -18.0F, -4.0F, 4.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 3.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		shell.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
} */