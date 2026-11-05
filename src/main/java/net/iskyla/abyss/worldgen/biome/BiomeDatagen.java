package net.iskyla.abyss.worldgen.biome;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.feature.datagen.PlacedFeatureDatagen;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class BiomeDatagen {

	public static final ResourceKey<Biome> ABYSSAL_ARCHES =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_arches"));

	public static final ResourceKey<Biome> ABYSSAL_CAVES =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_caves"));

	public static final ResourceKey<Biome> ABYSSAL_OASIS =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_oasis"));

	public static final ResourceKey<Biome> ABYSSAL_VENTS =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_vents"));

	public static void bootstrapBiome(BootstrapContext<Biome> context) {
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

		context.register(ABYSSAL_ARCHES, new Biome.BiomeBuilder()
				.temperature(0.0f)
				.temperatureAdjustment(Biome.TemperatureModifier.NONE)
				.downfall(0.0f)
				.generationSettings(
						BiomeGenerationSettings.EMPTY
				)
				.hasPrecipitation(false)
				.mobSpawnSettings(new MobSpawnSettings.Builder()
						//.addSpawn()
				.build())
				.specialEffects(new BiomeSpecialEffects.Builder().fogColor(1).waterColor(1).waterFogColor(1).skyColor(1).build())
				.build()
		);

		context.register(ABYSSAL_CAVES, new Biome.BiomeBuilder()
				.temperature(0.5f)
				.temperatureAdjustment(Biome.TemperatureModifier.NONE)
				.downfall(0.0f)
				.generationSettings(BiomeGenerationSettings.EMPTY)
				.hasPrecipitation(false)
				.mobSpawnSettings(new MobSpawnSettings.Builder()
						//.addSpawn()
						.build())
				.specialEffects(new BiomeSpecialEffects.Builder().fogColor(1).waterColor(1).waterFogColor(1).skyColor(1).build())
				.build()
		);

		context.register(ABYSSAL_OASIS, new Biome.BiomeBuilder()
				.temperature(0.8f)
				.temperatureAdjustment(Biome.TemperatureModifier.NONE)
				.downfall(0.0f)
				.generationSettings(BiomeGenerationSettings.EMPTY)
				.hasPrecipitation(false)
				.mobSpawnSettings(new MobSpawnSettings.Builder()
						//.addSpawn()
						.build())
				.specialEffects(new BiomeSpecialEffects.Builder().fogColor(0xFF0000).waterColor(1).waterFogColor(1).skyColor(1).build())
				.build()
		);

		context.register(ABYSSAL_VENTS, new Biome.BiomeBuilder()
				.temperature(1.6f)
				.temperatureAdjustment(Biome.TemperatureModifier.NONE)
				.downfall(0.0f)
				.generationSettings(new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)
						.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlacedFeatureDatagen.SMALL_ABYSSAL_VENT)
						.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlacedFeatureDatagen.MEDIUM_ABYSSAL_VENT)
						.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, PlacedFeatureDatagen.LARGE_ABYSSAL_VENT)
						.build()
				)
				.hasPrecipitation(false)
				.mobSpawnSettings(new MobSpawnSettings.Builder()
						//.addSpawn()
						.build())
				.specialEffects(new BiomeSpecialEffects.Builder().fogColor(1).waterColor(1).waterFogColor(1).skyColor(1).build())
				.build()
		);
	}
}
