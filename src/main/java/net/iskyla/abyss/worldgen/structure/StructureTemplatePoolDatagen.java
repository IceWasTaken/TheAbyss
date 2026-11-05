package net.iskyla.abyss.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.iskyla.abyss.Abyss;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class StructureTemplatePoolDatagen {

	public static final ResourceKey<StructureTemplatePool> ABYSS_PORTAL_OVERWORLD =
			ResourceKey.create(Registries.TEMPLATE_POOL, Abyss.resourceLocation("abyss_portal_overworld"));

	public static final ResourceKey<StructureTemplatePool> ABYSS_PORTAL_ABYSS =
			ResourceKey.create(Registries.TEMPLATE_POOL, Abyss.resourceLocation("abyss_portal_abyss"));

	public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
		HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
		HolderGetter<StructureProcessorList> processorList = context.lookup(Registries.PROCESSOR_LIST);


		context.register(
				ABYSS_PORTAL_OVERWORLD,
				new StructureTemplatePool(
						templatePools.getOrThrow(Pools.EMPTY),
						ImmutableList.of(
								Pair.of(
										StructurePoolElement.single(
												Abyss.resourceLocation("abyss_portal/overworld").toString()
										),
										1
								)
						),
						StructureTemplatePool.Projection.RIGID


				)
		);

		context.register(
				ABYSS_PORTAL_ABYSS,
				new StructureTemplatePool(
						templatePools.getOrThrow(Pools.EMPTY),
						ImmutableList.of(
								Pair.of(
										StructurePoolElement.single(
												Abyss.resourceLocation("abyss_portal/abyss").toString()
										),
										1
								)
						),
						StructureTemplatePool.Projection.RIGID


				)
		);
	}
}
