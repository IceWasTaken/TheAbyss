package net.iskyla.abyss.worldgen.feature;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatureRegistry {

	public static final ResourceKey<PlacedFeature> TEST_PLACED_FEATURE = ResourceKey.create(
			Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "testing")
	);

	public static void bootstrapFeatures(BootstrapContext<PlacedFeature> context) {
		context.register(
				TEST_PLACED_FEATURE,
				new PlacedFeature(
						context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ConfiguredFeatureRegistry.TEST_CONFIGURED_FEATURE),
						List.of(
								CountPlacement.of(16),
								InSquarePlacement.spread(),
								HeightRangePlacement.uniform(
										VerticalAnchor.aboveBottom(0),
										VerticalAnchor.belowTop(0)
								),
								BiomeFilter.biome()
						)
				)
		);
	}
}
