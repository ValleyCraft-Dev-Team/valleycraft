// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class tropicalfish_a<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "tropicalfish_a"), "main");
	private final ModelPart body;

	public tropicalfish_a(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -3.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(10, -6).addBox(0.5F, -5.0F, -5.9992F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 24.0F, 0.0F));

		PartDefinition tailfin = body.addOrReplaceChild("tailfin", CubeListBuilder.create().texOffs(24, -4).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 3.0F));

		PartDefinition leftFin = body.addOrReplaceChild("leftFin", CubeListBuilder.create().texOffs(2, 12).addBox(-0.164F, -2.0F, -1.1059F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition rightFin = body.addOrReplaceChild("rightFin", CubeListBuilder.create().texOffs(2, 16).addBox(-1.836F, -2.0F, -1.1059F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}