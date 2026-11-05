package net.iskyla.abyss.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.iskyla.abyss.block.entity.VentSmokeSourceBlockEntity;
import net.iskyla.abyss.registry.BlockEntityRegistry;
import net.iskyla.abyss.registry.ParticleTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class VentSmokeSourceBlock extends BaseEntityBlock {

	public static final MapCodec<VentSmokeSourceBlock> CODEC = RecordCodecBuilder.mapCodec(
			(instance) -> instance.group(
					propertiesCodec()
			).apply(instance, VentSmokeSourceBlock::new)
	);


	public VentSmokeSourceBlock(Properties properties) {
		super(properties);
	}

	public static void makeParticles(Level level, BlockPos pos) {
		RandomSource random = level.getRandom();

		SimpleParticleType simpleParticleType = ParticleTypeRegistry.CHEMICAL_SOUP.get();
		level.addAlwaysVisibleParticle(
				simpleParticleType,
				true,
				pos.getX() + 0.5f + random.nextDouble() / 3.0f * (random.nextBoolean() ? 1 : -1),
				pos.getY() + random.nextDouble() + random.nextDouble(),
				pos.getZ() + 0.5F + random.nextDouble() / 3.0f * (random.nextBoolean() ? 1 : -1),
				0.0f,
				0.07f,
				0.0f
		);
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		if(level.isClientSide) {
			return createTickerHelper(blockEntityType, BlockEntityRegistry.HYDROTHERMAL_VENT.get(), VentSmokeSourceBlockEntity::particleTick);
		}
		return createTickerHelper(blockEntityType, BlockEntityRegistry.HYDROTHERMAL_VENT.get(), VentSmokeSourceBlockEntity::tick);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
		return new VentSmokeSourceBlockEntity(blockPos, blockState);
	}

	@Override
	protected MapCodec<? extends BaseEntityBlock> codec() {
		return CODEC;
	}
}
