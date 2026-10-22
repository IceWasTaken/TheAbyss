package net.iskyla.abyss.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.*;

public class YellowKelpBlock extends KelpBlock {

	public static final MapCodec<YellowKelpBlock> CODEC = simpleCodec(YellowKelpBlock::new);

	public YellowKelpBlock(Properties p_54300_) {
		super(p_54300_);
	}

	@Override
	protected Block getBodyBlock() {
		return BlockRegistry.YELLOW_KELP_PLANT.get();
	}

}
