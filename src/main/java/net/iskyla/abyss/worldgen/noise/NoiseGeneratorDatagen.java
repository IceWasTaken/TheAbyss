package net.iskyla.abyss.worldgen.noise;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.BlockRegistry;
import net.iskyla.abyss.worldgen.density.DensityFunctionDatagen;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;
import java.util.function.Function;

public class NoiseGeneratorDatagen {

	public static final ResourceKey<NoiseGeneratorSettings> ABYSS_NOISE_SETTINGS =
			ResourceKey.create(Registries.NOISE_SETTINGS, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss"));


	public static void bootstrapNoiseGenerator(BootstrapContext<NoiseGeneratorSettings> context) {
		HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);
		HolderGetter<DensityFunction> functions = context.lookup(Registries.DENSITY_FUNCTION);

		Function<ResourceKey<DensityFunction>, DensityFunctions.HolderHolder> getFunction = (funcKey) ->
				new DensityFunctions.HolderHolder(functions.getOrThrow(funcKey));

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
						new DensityFunctions.HolderHolder(functions.getOrThrow(DensityFunctionDatagen.ABYSS_TEMPERATURE)),
						DensityFunctions.constant(0), //vegetation
						DensityFunctions.constant(0), //continents
						DensityFunctions.constant(0), //erosion
						DensityFunctions.constant(0), //depth
						DensityFunctions.constant(0), //ridges
						DensityFunctions.constant(0), //initial density w/out jaggedness
						DensityFunctions.add(
								DensityFunctions.add(
										getFunction.apply(DensityFunctionDatagen.ABYSSAL_CEILING_FLOOR_FUNCTION),
										getFunction.apply(DensityFunctionDatagen.ABYSSAL_CEILING_FLOOR_TERRAIN_FUNCTION)
								),
								new DensityFunctions.HolderHolder(functions.getOrThrow(DensityFunctionDatagen.ABYSSAL_ARCHES_FUNCTION))
						),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0)
				),
				SurfaceRules.sequence(
						Functions.dimensionFloor(Blocks.BEDROCK),
						Functions.dimensionRoof(Blocks.BEDROCK),
						SurfaceRules.ifTrue(
								SurfaceRules.yBlockCheck(
										VerticalAnchor.belowTop(5),
										0
								),
								SurfaceRules.state(BlockRegistry.PRISMATIC_ROCK.get().defaultBlockState())
						),
						SurfaceRules.ifTrue(
								SurfaceRules.not(SurfaceRules.yBlockCheck(
										VerticalAnchor.aboveBottom(10),
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
