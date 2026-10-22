package net.iskyla.abyss.worldgen;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class BiomeRegistry {

	public static final ResourceKey<Biome> ABYSSAL_ARCHES =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_arches"));

	public static final ResourceKey<Biome> ABYSSAL_CAVES =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_caves"));

	public static final ResourceKey<Biome> ABYSSAL_OASIS =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_oasis"));

	public static final ResourceKey<Biome> ABYSSAL_VENTS =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_vents"));

	public static void bootstrapBiome(BootstrapContext<Biome> context) {
		context.register(ABYSSAL_ARCHES, new Biome.BiomeBuilder()
				.temperature(0.2f)
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

		context.register(ABYSSAL_CAVES, new Biome.BiomeBuilder()
				.temperature(0.2f)
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
				.temperature(0.2f)
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

		context.register(ABYSSAL_VENTS, new Biome.BiomeBuilder()
				.temperature(0.2f)
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
	}
}
