package net.iskyla.abyss.block;

import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.KelpPlantBlock;

public class YellowKelpPlantBlock extends KelpPlantBlock {
	public YellowKelpPlantBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected GrowingPlantHeadBlock getHeadBlock() {
		return BlockRegistry.YELLOW_KELP.get();
	}
}
