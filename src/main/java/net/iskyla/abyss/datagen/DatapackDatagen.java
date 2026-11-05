package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.biome.BiomeModifierRegistry;
import net.iskyla.abyss.worldgen.biome.BiomeDatagen;
import net.iskyla.abyss.worldgen.density.DensityFunctionDatagen;
import net.iskyla.abyss.worldgen.dimension.DimensionDatagen;
import net.iskyla.abyss.worldgen.feature.datagen.ConfiguredFeatureDatagen;
import net.iskyla.abyss.worldgen.feature.datagen.PlacedFeatureDatagen;
import net.iskyla.abyss.worldgen.noise.NoiseGeneratorDatagen;
import net.iskyla.abyss.worldgen.structure.StructureDatagen;
import net.iskyla.abyss.worldgen.structure.StructureSetDatagen;
import net.iskyla.abyss.worldgen.structure.StructureTemplatePoolDatagen;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackDatagen extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.DENSITY_FUNCTION, DensityFunctionDatagen::bootstrap)
			.add(Registries.NOISE_SETTINGS, NoiseGeneratorDatagen::bootstrapNoiseGenerator)

			.add(Registries.BIOME, BiomeDatagen::bootstrapBiome)
			.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifierRegistry::bootstrapModifiers)

			.add(Registries.DIMENSION_TYPE, DimensionDatagen::bootstrapType)
			.add(Registries.LEVEL_STEM, DimensionDatagen::bootstrapStem)

			.add(Registries.PLACED_FEATURE, PlacedFeatureDatagen::bootstrapFeatures)
			.add(Registries.CONFIGURED_FEATURE, ConfiguredFeatureDatagen::bootstrapFeatures)

			.add(Registries.STRUCTURE, StructureDatagen::bootstrap)
			.add(Registries.STRUCTURE_SET, StructureSetDatagen::bootstrap)
			.add(Registries.TEMPLATE_POOL, StructureTemplatePoolDatagen::bootstrap);



	public DatapackDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(Abyss.MODID));
	}

}
