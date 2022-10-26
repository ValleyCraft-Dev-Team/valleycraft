// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

/*
public class custom_model extends EntityModel<Entity> {
	private final ModelPart base;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart full_stem;
	private final ModelPart stem_upper;
	private final ModelPart cube_r6;
	private final ModelPart stem_lower;
	private final ModelPart cube_r7;
	private final ModelPart cube_r8;
	private final ModelPart head;
	private final ModelPart tongue;
	private final ModelPart cube_r9;
	private final ModelPart skull;
	private final ModelPart cube_r10;
	private final ModelPart cube_r11;
	private final ModelPart cube_r12;
	public custom_model(ModelPart root) {
		this.base = root.getChild("base");
		this.full_stem = root.getChild("full_stem");
		this.head = root.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData base = modelPartData.addChild("base", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData cube_r1 = base.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -0.25F, -6.0F, 12.0F, 0.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.1416F, -0.7854F, 3.1416F));

		ModelPartData cube_r2 = base.addChild("cube_r2", ModelPartBuilder.create().uv(0, 23).cuboid(-2.0F, 0.25F, -7.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(19, 25).cuboid(-2.0F, 0.25F, -7.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r3 = base.addChild("cube_r3", ModelPartBuilder.create().uv(19, 13).cuboid(-2.0F, 0.25F, 1.0F, 4.0F, 0.0F, 6.0F, new Dilation(0.0F))
		.uv(0, 19).cuboid(-2.0F, 0.25F, 7.0F, 4.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r4 = base.addChild("cube_r4", ModelPartBuilder.create().uv(0, 13).cuboid(-7.0F, 0.25F, -2.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F))
		.uv(38, 36).cuboid(-7.0F, 0.25F, -2.0F, 6.0F, 0.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData cube_r5 = base.addChild("cube_r5", ModelPartBuilder.create().uv(32, 0).cuboid(1.0F, 0.25F, -2.0F, 6.0F, 0.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(7.0F, 0.25F, -2.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData full_stem = modelPartData.addChild("full_stem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData stem_upper = full_stem.addChild("stem_upper", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r6 = stem_upper.addChild("cube_r6", ModelPartBuilder.create().uv(8, 2).cuboid(0.0F, -15.0F, 3.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 7).cuboid(1.0F, -16.0F, 6.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 6).cuboid(-3.0F, -19.0F, 6.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 8).cuboid(-3.0F, -14.0F, 6.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -24.0F, 5.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F))
		.uv(8, 1).cuboid(0.0F, -17.0F, 7.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData stem_lower = full_stem.addChild("stem_lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r7 = stem_lower.addChild("cube_r7", ModelPartBuilder.create().uv(8, 11).cuboid(-3.0F, -8.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(6, 0).cuboid(1.0F, -5.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 25).cuboid(1.0F, -12.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(0, 42).cuboid(-1.0F, -13.0F, -1.0F, 2.0F, 13.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		ModelPartData cube_r8 = stem_lower.addChild("cube_r8", ModelPartBuilder.create().uv(8, 10).cuboid(1.0F, -9.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 9).cuboid(-3.0F, -5.0F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, -1.309F, 1.5708F));

		ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 6.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData tongue = head.addChild("tongue", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, -5.0F));

		ModelPartData cube_r9 = tongue.addChild("cube_r9", ModelPartBuilder.create().uv(25, 44).cuboid(-1.0F, -21.25F, -3.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(18, 37).cuboid(-1.0F, -22.25F, -3.5F, 2.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData skull = head.addChild("skull", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r10 = skull.addChild("cube_r10", ModelPartBuilder.create().uv(29, 5).cuboid(-3.0F, -21.0F, -1.0F, 6.0F, 1.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(-4.0F, -25.0F, -2.0F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(25, 14).cuboid(-4.0F, -23.0F, -2.0F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		ModelPartData cube_r11 = skull.addChild("cube_r11", ModelPartBuilder.create().uv(0, 34).cuboid(-3.0F, -27.25F, -15.75F, 6.0F, 1.0F, 7.0F, new Dilation(0.0F))
		.uv(0, 23).cuboid(-4.0F, -24.25F, -16.75F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F))
		.uv(25, 25).cuboid(-4.0F, -26.25F, -16.75F, 8.0F, 2.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData cube_r12 = skull.addChild("cube_r12", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -27.5F, 8.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(6, 1).cuboid(2.0F, -23.5F, 7.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 5).cuboid(-4.0F, -24.5F, 7.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
		.uv(8, 0).cuboid(0.0F, -23.5F, 9.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(30, 36).cuboid(-2.0F, -25.5F, 5.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -5.0F, 0.2182F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		base.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		full_stem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
} */