// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class custom_model extends EntityModel<Entity> {
	private final ModelPart canoe;
	private final ModelPart bb_main;
	public custom_model(ModelPart root) {
		this.canoe = root.getChild("canoe");
		this.bb_main = root.getChild("bb_main");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData canoe = modelPartData.addChild("canoe", ModelPartBuilder.create().uv(69, 71).cuboid(-4.0F, -3.0F, 21.0F, 8.0F, 3.0F, 7.0F, new Dilation(0.0F))
		.uv(60, 13).cuboid(-8.0F, -9.0F, -21.0F, 16.0F, 6.0F, 7.0F, new Dilation(0.0F))
		.uv(64, 44).cuboid(-6.0F, -9.0F, -28.0F, 12.0F, 6.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 8).cuboid(-4.0F, -9.0F, -30.0F, 8.0F, 6.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-4.0F, -9.0F, 28.0F, 8.0F, 6.0F, 2.0F, new Dilation(0.0F))
		.uv(64, 31).cuboid(-6.0F, -9.0F, 21.0F, 12.0F, 6.0F, 7.0F, new Dilation(0.0F))
		.uv(60, 0).cuboid(-8.0F, -9.0F, 14.0F, 16.0F, 6.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 65).cuboid(-6.0F, -3.0F, 14.0F, 12.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -3.0F, -14.0F, 16.0F, 3.0F, 28.0F, new Dilation(0.0F))
		.uv(32, 37).cuboid(8.0F, -9.0F, -14.0F, 2.0F, 6.0F, 28.0F, new Dilation(0.0F))
		.uv(0, 31).cuboid(-10.0F, -9.0F, -14.0F, 2.0F, 6.0F, 28.0F, new Dilation(0.0F))
		.uv(31, 71).cuboid(-6.0F, -3.0F, -21.0F, 12.0F, 3.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 75).cuboid(-4.0F, -3.0F, -28.0F, 8.0F, 3.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		canoe.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}