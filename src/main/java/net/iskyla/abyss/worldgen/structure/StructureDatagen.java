package net.iskyla.abyss.worldgen.structure;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.EntityRegistry;
import net.iskyla.abyss.worldgen.biome.BiomeDatagen;
import net.iskyla.abyss.worldgen.biome.BiomeTagDatagen;
import net.iskyla.abyss.worldgen.structure.portal.AbyssPortalAbyssStructure;
import net.iskyla.abyss.worldgen.structure.portal.AbyssPortalOverworldStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.neoforged.neoforge.common.Tags;

import java.util.Map;

public class StructureDatagen {

	public static final ResourceKey<Structure> ABYSS_PORTAL_OVERWORLD =
			ResourceKey.create(Registries.STRUCTURE, Abyss.resourceLocation("abyss_portal_overworld"));

	public static final ResourceKey<Structure> ABYSS_PORTAL_ABYSS =
			ResourceKey.create(Registries.STRUCTURE, Abyss.resourceLocation("abyss_portal_abyss"));

	public static void bootstrap(BootstrapContext<Structure> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

		context.register(
				ABYSS_PORTAL_OVERWORLD,
				new AbyssPortalOverworldStructure(
						new Structure.StructureSettings.Builder(
								biomes.getOrThrow(Tags.Biomes.IS_DEEP_OCEAN)
						).spawnOverrides(
								Map.of(
										MobCategory.UNDERGROUND_WATER_CREATURE,
										new StructureSpawnOverride(
												StructureSpawnOverride.BoundingBoxType.STRUCTURE,
												WeightedRandomList.create(
														new MobSpawnSettings.SpawnerData(
																EntityRegistry.BONEFISH.get(), 1, 1, 6
														)
												)
										)
								)
								)
								.generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
								.build()
				)
		);

		context.register(
				ABYSS_PORTAL_ABYSS,
				new AbyssPortalAbyssStructure(
						new Structure.StructureSettings.Builder(HolderSet.direct(
								biomes.getOrThrow(BiomeDatagen.ABYSSAL_ARCHES),
								biomes.getOrThrow(BiomeDatagen.ABYSSAL_CAVES),
								biomes.getOrThrow(BiomeDatagen.ABYSSAL_OASIS),
								biomes.getOrThrow(BiomeDatagen.ABYSSAL_VENTS)
						)).spawnOverrides(
								Map.of(
										MobCategory.UNDERGROUND_WATER_CREATURE,
										new StructureSpawnOverride(
												StructureSpawnOverride.BoundingBoxType.STRUCTURE,
												WeightedRandomList.create(
														new MobSpawnSettings.SpawnerData(
																EntityRegistry.BONEFISH.get(), 1, 1, 6
														)
												)
										)
								)
								)
								.generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
								.build()
				)
		);
	}
}
