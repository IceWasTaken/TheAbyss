package net.iskyla.abyss.worldgen.noise;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class Functions {

	public static SurfaceRules.RuleSource dimensionFloor(Block block, int startY, int endY) {
		return SurfaceRules.ifTrue(
				SurfaceRules.verticalGradient(
						"floor",
						VerticalAnchor.aboveBottom(startY),
						VerticalAnchor.aboveBottom(endY)
				),
				SurfaceRules.state(block.defaultBlockState())
		);
	}

	public static SurfaceRules.RuleSource dimensionFloor(Block block) {
		return dimensionFloor(block, 0, 5);
	}

	public static SurfaceRules.RuleSource dimensionRoof(Block block, int startY, int endY) {
		return SurfaceRules.ifTrue(
				SurfaceRules.not(
						SurfaceRules.verticalGradient(
								"roof",
								VerticalAnchor.belowTop(startY),
								VerticalAnchor.belowTop(endY)
						)
				),
				SurfaceRules.state(block.defaultBlockState())
		);
	}

	public static SurfaceRules.RuleSource dimensionRoof(Block block) {
		return dimensionRoof(block, 5, 0);
	}





}
