package net.iskyla.abyss.worldgen;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BiomeModifierRegistry {

	public static final ResourceKey<BiomeModifier> TESTING_MODIFIER =
			ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "testing"));


	public static void bootstrapModifiers(BootstrapContext<BiomeModifier> context) {
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

//		context.register(TESTING_MODIFIER,
//				new BiomeModifiers.AddFeaturesBiomeModifier(
//						HolderSet.direct(biomes.getOrThrow(BiomeRegistry.ABYSSAL_ARCHES)),
//						HolderSet.direct(
//								PlacementUtils.inlinePlaced(
//										Feature.POINTED_DRIPSTONE,
//										new PointedDripstoneConfiguration(0.2F, 0.7F, 0.5F, 0.5F),
//										EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
//										RandomOffsetPlacement.vertical(ConstantInt.of(1))
//								)
//						),
//						GenerationStep.Decoration.LOCAL_MODIFICATIONS
//				));
	}
}
