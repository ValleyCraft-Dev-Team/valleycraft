// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class custom_model extends EntityModel<Entity> {
	private final ModelPart body;
	private final ModelPart bottomFin;
	private final ModelPart cube_r1;
	private final ModelPart topFin;
	private final ModelPart cube_r2;
	private final ModelPart tailFin;
	private final ModelPart head;
	public custom_model(ModelPart root) {
		this.body = root.getChild("body");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(9, 12).cuboid(4.0F, -1.0F, -4.0F, 1.0F, 0.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 10.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, -1.0F, -4.0F, 1.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, -1.0F));

		ModelPartData bottomFin = body.addChild("bottomFin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = bottomFin.addChild("cube_r1", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, -0.75F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData topFin = body.addChild("topFin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 1.0F));

		ModelPartData cube_r2 = topFin.addChild("cube_r2", ModelPartBuilder.create().uv(15, 15).cuboid(1.0F, -1.5F, -3.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData tailFin = body.addChild("tailFin", ModelPartBuilder.create().uv(0, 18).cuboid(-3.0F, -1.0F, 5.0F, 6.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 15).cuboid(-3.0F, -1.5F, -6.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}