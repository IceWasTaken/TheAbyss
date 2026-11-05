package net.iskyla.abyss.worldgen.structure;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class StructureSetDatagen {

	public static final ResourceKey<StructureSet> ABYSS_PORTAL_OVERWORLD =
			ResourceKey.create(Registries.STRUCTURE_SET, Abyss.resourceLocation("abyss_portal_overworld"));

	public static final ResourceKey<StructureSet> ABYSS_PORTAL_ABYSS =
			ResourceKey.create(Registries.STRUCTURE_SET, Abyss.resourceLocation("abyss_portal_abyss"));

	public static void bootstrap(BootstrapContext<StructureSet> context) {
		HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

		context.register(
				ABYSS_PORTAL_OVERWORLD,
				new StructureSet(
						structures.getOrThrow(StructureDatagen.ABYSS_PORTAL_OVERWORLD),
						new RandomSpreadStructurePlacement(
								33,
								4,
								RandomSpreadType.TRIANGULAR,
								8673414
						)
				)
		);

		context.register(
				ABYSS_PORTAL_ABYSS,
				new StructureSet(
						structures.getOrThrow(StructureDatagen.ABYSS_PORTAL_ABYSS),
						new RandomSpreadStructurePlacement(
								33,
								4,
								RandomSpreadType.TRIANGULAR,
								8673414
						)
				)
		);
	}
}
