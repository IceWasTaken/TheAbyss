package net.iskyla.abyss.worldgen.noise;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
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
						DensityFunctions.add(
								DensityFunctions.constant(-0.7d),
								DensityFunctions.min(
										DensityFunctions.rangeChoice(
												DensityFunctions.noise(
														noiseParameters.getOrThrow(Noises.CAVE_CHEESE),
														6d,
														4d
												).abs(),
												0d,
												0.06d,
												DensityFunctions.constant(1.2d),
												DensityFunctions.constant(-1d)
										),
										DensityFunctions.rangeChoice(
												DensityFunctions.noise(
														noiseParameters.getOrThrow(Noises.NOODLE),
														5d,
														5d
												).abs(),
												0d,
												0.06d,
												DensityFunctions.constant(1.2d),
												DensityFunctions.constant(-1d)
										)
								)
						),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0),
						DensityFunctions.constant(0)
				),
				SurfaceRules.sequence(
						SurfaceRules.ifTrue(
								SurfaceRules.yStartCheck(VerticalAnchor.bottom(), 0),
								SurfaceRules.sequence(
										SurfaceRules.ifTrue(
												SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.aboveBottom(2), 0)),
												SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
										),
										SurfaceRules.ifTrue(
												SurfaceRules.yStartCheck(VerticalAnchor.aboveBottom(126), 0),
												SurfaceRules.state(Blocks.BEDROCK.defaultBlockState())
										)
								)

						)
				),
				List.of(),
				256,
				false,
				false,
				false,
				true
		)
		);
	}
}
