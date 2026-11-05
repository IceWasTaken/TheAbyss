package net.iskyla.abyss.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.BonefishEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BonefishRenderer extends GeoEntityRenderer<BonefishEntity> {

	public BonefishRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BonefishModel());
	}

	@Override
	public ResourceLocation getTextureLocation(BonefishEntity animatable) {
		return Abyss.resourceLocation("textures/entity/bonefish.png");
	}

	@Override
	public void render(BonefishEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
	}
}
