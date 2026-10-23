package net.iskyla.abyss.worldgen.density;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.BlendedNoise;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DensityFunctionRegistry {

	public static final ResourceKey<DensityFunction> ABYSSAL_CEILING_FLOOR_FUNCTION =
			ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_ceiling_floor"));

	public static final ResourceKey<DensityFunction> ABYSSAL_ARCHES_FUNCTION =
			ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_arches_func"));

	public static final ResourceKey<DensityFunction> ABYSSAL_CAVES_FUNCTION =
			ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyssal_caves_func"));

	public static final ResourceKey<DensityFunction> ABYSS_TEMPERATURE =
			ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss_temperature"));


	public static void bootstrap(BootstrapContext<DensityFunction> context) {
		HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);

		context.register(ABYSSAL_CEILING_FLOOR_FUNCTION,
				DensityFunctions.add(
						DensityFunctions.yClampedGradient(
								256,
								248,
								5,
								0
						),
						DensityFunctions.yClampedGradient(
								0,
								8,
								5,
								0
						)
				)
		);

		context.register(ABYSSAL_ARCHES_FUNCTION,
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
				)
		);

		context.register(ABYSSAL_CAVES_FUNCTION,
					DensityFunctions.mul(
							DensityFunctions.constant(0.64d),
							DensityFunctions.interpolated(
									DensityFunctions.blendDensity(
											DensityFunctions.add(
													DensityFunctions.constant(2.5d),
													DensityFunctions.mul(
															DensityFunctions.yClampedGradient(
																	-8,
																	24,
																	0,
																	1
															),
															DensityFunctions.add(
																	DensityFunctions.constant(-2.5),
																	DensityFunctions.add(
																			DensityFunctions.constant(0.9375),
																			DensityFunctions.mul(
																					DensityFunctions.yClampedGradient(
																							104,
																							128,
																							1,
																							0
																					),
																					DensityFunctions.add(
																							DensityFunctions.constant(-0.9375d),
																							BlendedNoise.createUnseeded(0.25, 0.375, 80.0, 60.0, 8.0)
																					)
																			)
																	)
															)
													)
											)
									)
							)
					).squeeze()
		);

		context.register(ABYSS_TEMPERATURE,
				DensityFunctions.noise(
						noiseParameters.getOrThrow(Noises.SURFACE),
						5d,
						5d
				)
		);


	}
}
