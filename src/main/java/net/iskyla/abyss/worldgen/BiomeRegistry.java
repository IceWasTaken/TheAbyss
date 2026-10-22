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

	public static final ResourceKey<Biome> ABYSS =
			ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));

	public static void bootstrapBiome(BootstrapContext<Biome> context) {
		context.register(ABYSS, new Biome.BiomeBuilder()
				.temperature(0.2f)
				.temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
				.downfall(0.0f)
				.generationSettings(BiomeGenerationSettings.EMPTY)
				.hasPrecipitation(false)
				.mobSpawnSettings(new MobSpawnSettings.Builder().addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 2, 20, 20)).build())
				.specialEffects(new BiomeSpecialEffects.Builder().fogColor(1).waterColor(1).waterFogColor(1).skyColor(1).build())
				.build()
		);
	}
}
