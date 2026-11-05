package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.worldgen.structure.portal.AbyssPortalAbyssStructure;
import net.iskyla.abyss.worldgen.structure.portal.AbyssPortalOverworldStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class StructureRegistry {

	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Abyss.MODID);

	public static final Supplier<StructureType<AbyssPortalOverworldStructure>> ABYSS_PORTAL_OVERWORLD = register("abyss_portal_overworld", () -> AbyssPortalOverworldStructure.CODEC);
	public static final Supplier<StructureType<AbyssPortalAbyssStructure>> ABYSS_PORTAL_ABYSS = register("abyss_portal_abyss", () -> AbyssPortalAbyssStructure.CODEC);

	private static <T extends Structure> DeferredHolder<StructureType<?>, StructureType<T>> register(String name, StructureType<T> type) {
		return STRUCTURE_TYPES.register(
				name,
				() -> type
		);
	}

}
