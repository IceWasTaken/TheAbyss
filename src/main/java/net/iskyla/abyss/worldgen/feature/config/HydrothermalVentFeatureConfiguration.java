package net.iskyla.abyss.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record HydrothermalVentFeatureConfiguration(int baseRadius, int height, int splitCount) implements FeatureConfiguration {
	public static final Codec<HydrothermalVentFeatureConfiguration> CODEC =
			RecordCodecBuilder.create(
					(instance) -> instance.group(
							Codec.INT.fieldOf("baseRadius").forGetter(HydrothermalVentFeatureConfiguration::baseRadius),
							Codec.INT.fieldOf("height").forGetter(HydrothermalVentFeatureConfiguration::height),
							Codec.INT.fieldOf("splitCount").forGetter(HydrothermalVentFeatureConfiguration::splitCount)
					).apply(instance, HydrothermalVentFeatureConfiguration::new)
			);


}
