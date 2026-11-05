package net.iskyla.abyss.worldgen.structure.portal;

import com.mojang.serialization.MapCodec;
import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.StructureRegistry;
import net.iskyla.abyss.worldgen.structure.StructureTemplatePoolDatagen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.material.FluidState;

import java.util.Optional;

public class AbyssPortalAbyssStructure extends Structure {

	public static final MapCodec<AbyssPortalAbyssStructure> CODEC = simpleCodec(AbyssPortalAbyssStructure::new);

	public AbyssPortalAbyssStructure(
			StructureSettings settings
	) {
		super(settings);
	}

	@Override
	protected Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
		int i = context.chunkPos().getBlockX(0);
		int j = context.chunkPos().getBlockZ(0);

//		for(Holder<Biome> holder : context.biomeSource().getBiomesWithin(i, context.chunkGenerator().getSeaLevel(), j, 29, context.randomState().sampler())) {
//			//same requirements for ocean monuments
//			if(!holder.is(BiomeTags.REQUIRED_OCEAN_MONUMENT_SURROUNDING)) {
//				return Optional.empty();
//			}
//		}


		int startY = ConstantHeight.of(VerticalAnchor.absolute(-8)).sample(context.random(), new WorldGenerationContext(context.chunkGenerator(), context.heightAccessor()));

		return JigsawPlacement.addPieces(
						context,
						context.registryAccess().registryOrThrow(Registries.TEMPLATE_POOL).getHolderOrThrow(StructureTemplatePoolDatagen.ABYSS_PORTAL_ABYSS),
						Optional.of(ResourceLocation.withDefaultNamespace("center")),
						1,
						new BlockPos(i, startY, j),
						false,
						Optional.of(Heightmap.Types.OCEAN_FLOOR_WG),
						128,
						PoolAliasLookup.EMPTY,
						DimensionPadding.ZERO,
						LiquidSettings.APPLY_WATERLOGGING
				);

//		return onTopOfChunkCenter(
//				context,
//				Heightmap.Types.OCEAN_FLOOR_WG,
//				(b) -> b.addPiece(
//						new AbyssalPortalAbyssPiece(context.structureTemplateManager(), new BlockPos(i, context.chunkGenerator().getSeaLevel() - 7, j))
//				)
//		);
	}


	@Override
	public StructureType<?> type() {
		return StructureRegistry.ABYSS_PORTAL_ABYSS.get();
	}
}
