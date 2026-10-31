package net.iskyla.abyss.worldgen.feature;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.BlockRegistry;
import net.iskyla.abyss.registry.FeatureRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.DeltaFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockColumnConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DeltaFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ConfiguredFeatureRegistry {

	public static final ResourceKey<ConfiguredFeature<?, ?>> TEST_CONFIGURED_FEATURE = ResourceKey.create(
			Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "testing")
	);

	public static void bootstrapFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {

		context.register(
				TEST_CONFIGURED_FEATURE,
				new ConfiguredFeature<>(
						FeatureRegistry.TEST_FEATURE.get(),
						new NoneFeatureConfiguration()
				)
		);
	}
}
