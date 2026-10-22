package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.BiomeRegistry;
import net.iskyla.abyss.worldgen.dimension.DimensionRegistry;
import net.iskyla.abyss.worldgen.noise.NoiseGeneratorRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackDatagen extends DatapackBuiltinEntriesProvider {

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.DIMENSION_TYPE, DimensionRegistry::bootstrapType)
			.add(Registries.LEVEL_STEM, DimensionRegistry::bootstrapStem)
			.add(Registries.BIOME, BiomeRegistry::bootstrapBiome)
			.add(Registries.NOISE_SETTINGS, NoiseGeneratorRegistry::bootstrapNoiseGenerator);


	public DatapackDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries, BUILDER, Set.of(Abyss.MODID));
	}
}
