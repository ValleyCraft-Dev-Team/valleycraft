// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

/* I commented the whole thing because I'm getting an error.

public class custom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart left_wings;
	private final ModelPart right_wings;
	private final ModelPart body;

	public custom_model(ModelPart root) {
		this.left_wings = root.getChild("left_wings");
		this.right_wings = root.getChild("right_wings");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_wings = partdefinition.addOrReplaceChild("left_wings", CubeListBuilder.create().texOffs(11, 0).addBox(1.0F, -2.0F, -1.25F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(9, 12).addBox(1.0F, -2.0F, -5.25F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition right_wings = partdefinition.addOrReplaceChild("right_wings", CubeListBuilder.create().texOffs(11, 3).addBox(-10.0F, -2.0F, -1.25F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(11, 6).addBox(-10.0F, -2.0F, -5.25F, 9.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, 11.75F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-0.5F, -2.0F, 3.75F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -2.5F, -6.25F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 15).addBox(-1.5F, -3.0F, -9.25F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(0.5F, -1.5F, 11.75F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.25F, 0.75F, -7.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(0.25F, 0.75F, -7.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 0.0F, -0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_wings.render(poseStack, buffer, packedLight, packedOverlay);
		right_wings.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}
} */