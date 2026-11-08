package net.iskyla.abyss.worldgen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import org.checkerframework.checker.units.qual.A;

public class AquaslateColumsFeatureConfiguration implements FeatureConfiguration {
	public static final Codec<AquaslateColumsFeatureConfiguration> CODEC =
			RecordCodecBuilder.create((b) ->
					b.group(
							IntProvider.codec(0, 3).fieldOf("reach").forGetter(AquaslateColumsFeatureConfiguration::height),
							IntProvider.codec(1, 10).fieldOf("height").forGetter(AquaslateColumsFeatureConfiguration::height)
					).apply(b, AquaslateColumsFeatureConfiguration::new));

	private final IntProvider reach;
	private final IntProvider height;

	public AquaslateColumsFeatureConfiguration(IntProvider reach, IntProvider height) {
		this.reach = reach;
		this.height = height;
	}

	public IntProvider reach() {
		return reach;
	}

	public IntProvider height() {
		return height;
	}
}
