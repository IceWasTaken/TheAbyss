package net.iskyla.abyss.block;

import net.iskyla.abyss.registry.BlockRegistry;
import net.iskyla.abyss.worldgen.dimension.DimensionDatagen;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;

public class AbyssPortalBlock extends TransparentBlock implements Portal {

	public AbyssPortalBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any());
	}

	@Override
	protected void entityInside(BlockState p_60495_, Level p_60496_, BlockPos blockPos, Entity entity) {
		if(entity.canUsePortal(true)) {
			entity.setAsInsidePortal(this, blockPos);
		}
	}

	@Override
	public int getPortalTransitionTime(ServerLevel level, Entity entity) {
		return 1;
	}

	@Override
	public DimensionTransition getPortalDestination(ServerLevel serverLevel, Entity entity, BlockPos blockPos) {
		ResourceKey<Level> dimension = serverLevel.dimension() == DimensionDatagen.OCEAN_LEVEL_KEY ? Level.OVERWORLD : DimensionDatagen.OCEAN_LEVEL_KEY;
		ServerLevel otherLevel = serverLevel.getServer().getLevel(dimension);

		if(otherLevel == null) {
			return null;
		} else {
			return new DimensionTransition(
					otherLevel,
					getSpawnPos(otherLevel, blockPos),
					entity.getDeltaMovement(),
					entity.getYRot(),
					entity.getXRot(),
					DimensionTransition.DO_NOTHING
			);
		}
	}

	private Vec3 getSpawnPos(ServerLevel level, BlockPos pos) {
		ResourceKey<Level> dimension = level.dimension() == DimensionDatagen.OCEAN_LEVEL_KEY ? Level.OVERWORLD : DimensionDatagen.OCEAN_LEVEL_KEY;

		BlockPos resultPos = pos.atY(level.getLogicalHeight());
		while(level.getBlockState(resultPos).getBlock() != BlockRegistry.ABYSS_PORTAL.get()) {
			resultPos = resultPos.below();

			if(resultPos.getY() < level.getMinBuildHeight()) {
				return new Vec3(pos.getX(), pos.getY(), pos.getZ());
			}
		}

		int yMod = dimension == Level.OVERWORLD ? -4 : 4;

		return new Vec3(resultPos.getX(), resultPos.getY() + yMod, resultPos.getZ());
	}






}
