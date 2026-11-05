package net.iskyla.abyss.worldgen.feature.datagen;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class PlacedFeatureDatagen {

	public static final ResourceKey<PlacedFeature> SMALL_ABYSSAL_VENT = ResourceKey.create(
			Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "small_abyssal_vent")
	);

	public static final ResourceKey<PlacedFeature> MEDIUM_ABYSSAL_VENT = ResourceKey.create(
			Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "medium_abyssal_vent")
	);

	public static final ResourceKey<PlacedFeature> LARGE_ABYSSAL_VENT = ResourceKey.create(
			Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "large_abyssal_vent")
	);

	public static void bootstrapFeatures(BootstrapContext<PlacedFeature> context) {
		context.register(SMALL_ABYSSAL_VENT, new PlacedFeature(
						context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ConfiguredFeatureDatagen.SMALL_ABYSSAL_VENT),
						List.of(
								InSquarePlacement.spread(),
								HeightRangePlacement.uniform(
										VerticalAnchor.aboveBottom(0),
										VerticalAnchor.belowTop(245)
								),
								SurfaceRelativeThresholdFilter.of(
										Heightmap.Types.OCEAN_FLOOR_WG,
										Integer.MIN_VALUE,
										-2
								),
								BiomeFilter.biome()
						)
				)
		);

		context.register(MEDIUM_ABYSSAL_VENT, new PlacedFeature(
						context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ConfiguredFeatureDatagen.MEDIUM_ABYSSAL_VENT),
						List.of(
								InSquarePlacement.spread(),
								HeightRangePlacement.uniform(
										VerticalAnchor.aboveBottom(0),
										VerticalAnchor.belowTop(245)
								),
								SurfaceRelativeThresholdFilter.of(
										Heightmap.Types.OCEAN_FLOOR_WG,
										Integer.MIN_VALUE,
										-2
								),
								BiomeFilter.biome()
						)
				)
		);

		context.register(LARGE_ABYSSAL_VENT, new PlacedFeature(
						context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ConfiguredFeatureDatagen.LARGE_ABYSSAL_VENT),
						List.of(
								InSquarePlacement.spread(),
								HeightRangePlacement.uniform(
										VerticalAnchor.aboveBottom(0),
										VerticalAnchor.belowTop(245)
								),
								SurfaceRelativeThresholdFilter.of(
										Heightmap.Types.OCEAN_FLOOR_WG,
										Integer.MIN_VALUE,
										-2
								),
								BiomeFilter.biome()
						)
				)
		);

	}
}
