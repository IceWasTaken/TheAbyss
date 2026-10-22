package net.iskyla.abyss.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.BiomeRegistry;
import net.iskyla.abyss.worldgen.noise.NoiseGeneratorRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;

import java.util.List;
import java.util.OptionalLong;

public class DimensionRegistry {

	public static final ResourceKey<LevelStem> OCEAN_DIM_KEY =
			ResourceKey.create(Registries.LEVEL_STEM, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));

	public static final ResourceKey<Level> OCEAN_LEVEL_KEY =
			ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));

	public static final ResourceKey<DimensionType> OCEAN_DIMENSION_TYPE_KEY =
			ResourceKey.create(Registries.DIMENSION_TYPE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));

	public static void bootstrapType(BootstrapContext<DimensionType> context) {
		context.register(OCEAN_DIMENSION_TYPE_KEY, new DimensionType(
				OptionalLong.of(18000L),
				false,
				true,
				false,
				true,
				1.0f,
				false,
				false,
				0,
				256,
				256,
				BlockTags.INFINIBURN_OVERWORLD,
				ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"),
				0.1f,
				new DimensionType.MonsterSettings(
						false,
						false,
						ConstantInt.of(0),
						0
				)
		));
	}

	public static void bootstrapStem(BootstrapContext<LevelStem> context) {
		var biomes = context.lookup(Registries.BIOME);
		var dimensionTypes = context.lookup(Registries.DIMENSION_TYPE);
		var noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

		NoiseBasedChunkGenerator multiBiomeGenerator = new NoiseBasedChunkGenerator(
				MultiNoiseBiomeSource.createFromList(
						new Climate.ParameterList<>(List.of(
								Pair.of(Climate.parameters(0.1f, 0.3f, -0.05f, 0f, 0f, 0f, 0f), biomes.getOrThrow(BiomeRegistry.ABYSSAL_ARCHES))
						))),
				noiseGenSettings.getOrThrow(NoiseGeneratorRegistry.ABYSS_NOISE_SETTINGS));

		context.register(OCEAN_DIM_KEY, new LevelStem(dimensionTypes.getOrThrow(OCEAN_DIMENSION_TYPE_KEY), multiBiomeGenerator));
	}
}
