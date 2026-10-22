package net.iskyla.abyss.worldgen.density;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DensityFunctionRegistry {

	public static final ResourceKey<DensityFunction> ARCHES_FUNCTION =
			ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "arches"));

	public static void bootstrap(BootstrapContext<DensityFunction> context) {
		HolderGetter<NormalNoise.NoiseParameters> noiseParameters = context.lookup(Registries.NOISE);

		context.register(ARCHES_FUNCTION,
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
	}
}
