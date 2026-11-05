package net.iskyla.abyss.worldgen.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.iskyla.abyss.registry.BlockRegistry;
import net.iskyla.abyss.worldgen.feature.config.HydrothermalVentFeatureConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class HydrothermalVentFeature extends Feature<HydrothermalVentFeatureConfiguration> {

	public HydrothermalVentFeature(Codec<HydrothermalVentFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<HydrothermalVentFeatureConfiguration> featurePlaceContext) {
		WorldGenLevel worldGenLevel = featurePlaceContext.level();
		ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
		RandomSource rand = featurePlaceContext.random();
		BlockPos center = featurePlaceContext.origin();
		HydrothermalVentFeatureConfiguration config = featurePlaceContext.config();

		int baseRadius = config.baseRadius();
		int height = config.height();
		int splitCount = config.splitCount();

		int centerX = center.getX();
		int centerZ = center.getZ();
		for (int y = height; y > 0; y--) {
			int currentRadius = calcCurrentRadius(height, baseRadius, splitCount, y);
			for(int x = centerX - currentRadius; x <= centerX + currentRadius; x++) {
				for(int z = centerZ - currentRadius; z <= centerZ + currentRadius; z++) {
					int dx = x - centerX;
					int dz = z - centerZ;
					int distanceSquared = dx * dx + dz * dz;

					if(distanceSquared <= currentRadius * currentRadius) {
						if(rand.nextDouble() < 0.05f) {
							continue;
						}

						if(CANNOT_REPLACE.contains(worldGenLevel.getBlockState(new BlockPos(x, center.getY() + y - 3, z)).getBlock())) {
							continue;
						}

						this.setBlock(worldGenLevel, new BlockPos(x, center.getY() + y - 3, z), BlockRegistry.AQUASLATE.get().defaultBlockState());
					}
				}
			}
		}

		this.setBlock(worldGenLevel, center.atY(center.getY() + height - 3), Blocks.WATER.defaultBlockState());
		this.setBlock(worldGenLevel, center.atY(center.getY() + height - 4), Blocks.WATER.defaultBlockState());
		this.setBlock(worldGenLevel, center.atY(center.getY() + height - 5), BlockRegistry.HYDROTHERMAL_VENT.get().defaultBlockState());

		return true;
	}

	private int calcCurrentRadius(int height, int baseRadius, int splitCount, int currentLayer) {
		int layersPerSplit = height / splitCount;

		int f = roundToNearest(currentLayer, layersPerSplit) / layersPerSplit;

		return baseRadius - f;
	}

	private int roundToNearest(int val, int nearest) {
		return Math.round((float) val / nearest) * nearest;
	}

	private static final ImmutableList<Block> CANNOT_REPLACE =
			ImmutableList.of(
					Blocks.BEDROCK,
					BlockRegistry.PRISMATIC_ROCK.get()
			);
}
