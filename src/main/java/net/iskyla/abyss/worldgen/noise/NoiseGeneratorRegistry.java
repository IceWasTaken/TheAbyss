package net.iskyla.abyss.worldgen.noise;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
import net.iskyla.abyss.worldgen.density.DensityFunctionRegistry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class NoiseGeneratorRegistry {

	public static final ResourceKey<NoiseGeneratorSettings> ABYSS_NOISE_SETTINGS =
			ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));


	public static void bootstrapNoiseGenerator(BootstrapContext<NoiseGeneratorSettings> context) {
		HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);
		HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);

		context.register(ABYSS_NOISE_SETTINGS, new NoiseGeneratorSettings(
				new NoiseSettings(
						0,
						256,
						1,
						2
				),
				BlockRegistry.AQUASLATE.get().defaultBlockState(),
				Blocks.WATER.defaultBlockState(),
				new NoiseRouter(
						DensityFunctions.constant(0), //barrier
						DensityFunctions.constant(0), //fluid level floodedness
						DensityFunctions.constant(0), //fluid level spread
						DensityFunctions.constant(0), //lava
						DensityFunctions.constant(0), //temperature
						DensityFunctions.constant(0), //vegetation
						DensityFunctions.constant(0), //continents
						DensityFunctions.constant(0), //erosion
						DensityFunctions.constant(0), //depth
						DensityFunctions.constant(0), //ridges
						DensityFunctions.constant(0), //initial density w/out jaggedness
						new DensityFunctions.HolderHolder(functions.getOrThrow(DensityFunctionRegistry.ARCHES_FUNCTION)),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0)
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(
								SurfaceRules.verticalGradient(
										"bedrock_floor",
										VerticalAnchor.aboveBottom(0),
										VerticalAnchor.aboveBottom(5)
								),
								SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
						),
						SurfaceRules.ifTrue(
								SurfaceRules.not(
										SurfaceRules.verticalGradient(
												"bedrock_roof",
												VerticalAnchor.belowTop(5),
												VerticalAnchor.belowTop(0)
										)
								),
								SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
						),
						SurfaceRules.ifTrue(
								SurfaceRules.yBlockCheck(
										VerticalAnchor.belowTop(5),
										0
								),
								SurfaceRules.state(BlockRegistry.PRISMATIC_ROCK.get().defaultBlockState())
						),
						SurfaceRules.ifTrue(
								SurfaceRules.not(SurfaceRules.yBlockCheck(
										VerticalAnchor.belowTop(251),
										0
								)),
								SurfaceRules.state(BlockRegistry.PRISMATIC_ROCK.get().defaultBlockState())
						),
						SurfaceRules.state(BlockRegistry.AQUASLATE.get().defaultBlockState())
				),
				List.of(),
				256,
				false,
				false,
				false,
				true
		));
	}
}
