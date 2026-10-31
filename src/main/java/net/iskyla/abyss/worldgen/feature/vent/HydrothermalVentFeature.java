package net.iskyla.abyss.worldgen.feature.vent;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HydrothermalVentFeature extends Feature<NoneFeatureConfiguration> {

	public HydrothermalVentFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
		WorldGenLevel worldGenLevel = featurePlaceContext.level();
		ChunkGenerator chunkGenerator = featurePlaceContext.chunkGenerator();
		RandomSource rand = featurePlaceContext.random();
		BlockPos pos = featurePlaceContext.origin();
		NoneFeatureConfiguration config = featurePlaceContext.config();

		for(int x = 0; x < 16; x++) {
			for(int y = 0; y < 16; y++) {
				for(int z = 0; z < 16; z++) {
					BlockPos blockPos = new BlockPos(x, y, z);

					worldGenLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 2);
					//TODO: actually placing shit (lmao)
				}
			}
		}

		return true;
	}
}
