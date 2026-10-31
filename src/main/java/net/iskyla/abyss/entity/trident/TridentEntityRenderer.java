package net.iskyla.abyss.entity.trident;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TridentEntityRenderer extends EntityRenderer<AbstractThrownTrident> {

	private final FancyTridentModel model;

	public TridentEntityRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.model = new FancyTridentModel(context.bakeLayer(FancyTridentModel.LAYER_LOCATION));
	}

	@Override
	public void render(AbstractThrownTrident thrownTrident, float p_116112_, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, thrownTrident.yRotO, thrownTrident.getYRot()) - 90.0F));
		poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTick, thrownTrident.xRotO, thrownTrident.getXRot()) + 90.0F));
		VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
				bufferSource, this.model.renderType(this.getTextureLocation(thrownTrident)), false, thrownTrident.isFoil()
		);
		this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, -1);
		poseStack.popPose();
		super.render(thrownTrident, p_116112_, partialTick, poseStack, bufferSource, packedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(AbstractThrownTrident genericThrownTridentEntity) {
		return ResourceLocation.fromNamespaceAndPath("abyss","textures/entity/fancy_trident.png");
	}
}
