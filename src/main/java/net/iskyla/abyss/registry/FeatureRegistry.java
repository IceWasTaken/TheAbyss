package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.feature.HydrothermalVentFeature;
import net.iskyla.abyss.worldgen.feature.config.HydrothermalVentFeatureConfiguration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FeatureRegistry {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Abyss.MODID);

	public static final Supplier<Feature<HydrothermalVentFeatureConfiguration>> TEST_FEATURE =
			FEATURES.register("test_feature", () -> new HydrothermalVentFeature(HydrothermalVentFeatureConfiguration.CODEC));

}
