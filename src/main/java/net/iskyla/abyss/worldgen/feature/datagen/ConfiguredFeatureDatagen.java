package net.iskyla.abyss.worldgen.feature.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.FeatureRegistry;
import net.iskyla.abyss.worldgen.feature.config.HydrothermalVentFeatureConfiguration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ConfiguredFeatureDatagen {

	public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_ABYSSAL_VENT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "small_abyssal_vent")
	);

	public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_ABYSSAL_VENT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "medium_abyssal_vent")
	);

	public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ABYSSAL_VENT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "large_abyssal_vent")
	);

	public static void bootstrapFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		context.register(
				SMALL_ABYSSAL_VENT,
				new ConfiguredFeature<>(
						FeatureRegistry.HYDROTHERMAL_VENT.get(),
						new HydrothermalVentFeatureConfiguration(
								3,
								8,
								2
						)
				)
		);

		context.register(
				MEDIUM_ABYSSAL_VENT,
				new ConfiguredFeature<>(
						FeatureRegistry.HYDROTHERMAL_VENT.get(),
						new HydrothermalVentFeatureConfiguration(
								4,
								12,
								3
						)
				)
		);


		context.register(
				LARGE_ABYSSAL_VENT,
				new ConfiguredFeature<>(
						FeatureRegistry.HYDROTHERMAL_VENT.get(),
						new HydrothermalVentFeatureConfiguration(
								5,
								16,
								4
						)
				)
		);
	}
}
