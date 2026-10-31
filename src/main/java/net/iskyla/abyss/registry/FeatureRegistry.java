package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.feature.vent.HydrothermalVentFeature;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FeatureRegistry {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Abyss.MODID);

	public static final Supplier<Feature<NoneFeatureConfiguration>> TEST_FEATURE =
			FEATURES.register("test_feature", () -> new HydrothermalVentFeature(NoneFeatureConfiguration.CODEC));

}
