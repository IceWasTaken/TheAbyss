package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.feature.AquaslateColumnsFeature;
import net.iskyla.abyss.worldgen.feature.HydrothermalVentFeature;
import net.iskyla.abyss.worldgen.feature.config.AquaslateColumsFeatureConfiguration;
import net.iskyla.abyss.worldgen.feature.config.HydrothermalVentFeatureConfiguration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FeatureRegistry {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(BuiltInRegistries.FEATURE, Abyss.MODID);

	public static final Supplier<Feature<HydrothermalVentFeatureConfiguration>> HYDROTHERMAL_VENT =
			FEATURES.register("hydrothermal_vent", () -> new HydrothermalVentFeature(HydrothermalVentFeatureConfiguration.CODEC));

	public static final Supplier<Feature<AquaslateColumsFeatureConfiguration>> AQUASLATE_COLUMNS =
			FEATURES.register("aquaslate_columns", () -> new AquaslateColumnsFeature(AquaslateColumsFeatureConfiguration.CODEC));

}
