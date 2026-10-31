package net.iskyla.abyss.entity.trident;
// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.iskyla.abyss.Abyss;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class FancyTridentModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("abyss", "trident_converted"), "main");
	private final ModelPart barthing;
	private final ModelPart horn1;
	private final ModelPart horn2;
	private final ModelPart bone;

	public FancyTridentModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.barthing = root.getChild("barthing");
		this.horn1 = root.getChild("horn1");
		this.horn2 = root.getChild("horn2");
		this.bone = root.getChild("bone");
	}


	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition barthing = partdefinition.addOrReplaceChild("barthing", CubeListBuilder.create().texOffs(1, 3).addBox(0.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 3).addBox(-2.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition horn1 = partdefinition.addOrReplaceChild("horn1", CubeListBuilder.create().texOffs(1, 1).addBox(2.0F, -13.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(1.0F, -15.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 3).addBox(1.0F, -11.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 3).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition horn2 = partdefinition.addOrReplaceChild("horn2", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, -13.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-3.0F, -15.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 3).addBox(-3.0F, -11.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 3).addBox(-2.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 2).addBox(-9.0F, -18.0F, 8.0F, 1.0F, 18.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-10.0F, -20.0F, 8.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(1, 1).addBox(-9.0F, -24.0F, 8.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	//is memory really important enough to require the color to be packed into one integer, mojang?
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		barthing.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		horn1.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		horn2.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}
}