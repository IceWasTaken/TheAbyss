package net.iskyla.abyss.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.AnglerfishEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class AnglerfishRenderer extends GeoEntityRenderer<AnglerfishEntity> {

	public AnglerfishRenderer(EntityRendererProvider.Context context) {
		super(context, new AnglerfishModel());
	}

	@Override
	public ResourceLocation getTextureLocation(AnglerfishEntity animatable) {
		return Abyss.resourceLocation("textures/entity/anglerfish.png");
	}

	@Override
	public void render(AnglerfishEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
	}
}
