// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer bipedHead;

	public Modelcustom_model() {
		textureWidth = 32;
		textureHeight = 32;

		bipedHead = new ModelRenderer(this);
		bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		bipedHead.setTextureOffset(0, 13).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 9.0F, 10.0F, 0.0F, false);
		bipedHead.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bipedHead.setTextureOffset(0, 0).addBox(5.0F, -5.0F, 0.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bipedHead.setTextureOffset(0, 0).addBox(-9.0F, -5.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bipedHead.setTextureOffset(0, 0).addBox(8.0F, -5.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bipedHead.setTextureOffset(28, 0).addBox(8.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedHead.setTextureOffset(28, 0).addBox(-9.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bipedHead.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}