package net.iskyla.abyss.entity.client;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.BonefishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BonefishModel extends GeoModel<BonefishEntity> {
	@Override
	public ResourceLocation getModelResource(BonefishEntity animatable) {
		return Abyss.resourceLocation("geo/bonefish.json");
	}

	@Override
	public ResourceLocation getTextureResource(BonefishEntity animatable) {
		return Abyss.resourceLocation("textures/entity/bonefish.png");
	}

	@Override
	public ResourceLocation getAnimationResource(BonefishEntity animatable) {
		return null;
	}
}
