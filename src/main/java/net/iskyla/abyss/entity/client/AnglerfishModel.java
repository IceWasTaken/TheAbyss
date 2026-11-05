package net.iskyla.abyss.entity.client;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.AnglerfishEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class AnglerfishModel extends GeoModel<AnglerfishEntity> {
	@Override
	public ResourceLocation getModelResource(AnglerfishEntity animatable) {
		return Abyss.resourceLocation("geo/anglerfish.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnglerfishEntity animatable) {
		return Abyss.resourceLocation("textures/entity/anglerfish.png");
	}

	@Override
	public ResourceLocation getAnimationResource(AnglerfishEntity animatable) {
		return null;
	}
}
