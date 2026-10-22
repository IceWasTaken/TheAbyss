package net.iskyla.abyss.block;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.datagen.BlockStateDatagen;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.KelpBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Abyss.MODID);

	public static final DeferredBlock<Block> AQUASLATE = cubeAllWithItem("aquaslate", () -> new Block(BlockBehaviour.Properties.of()));
	public static final DeferredBlock<Block> PRISMATIC_ROCK = cubeAllWithItem("prismatic_rock", () -> new Block(BlockBehaviour.Properties.of()));

	public static final DeferredBlock<YellowKelpBlock> YELLOW_KELP = cross("yellow_kelp", () -> new YellowKelpBlock(
			BlockBehaviour.Properties.of()
					.mapColor(MapColor.WATER)
					.noCollission()
					.randomTicks()
					.instabreak()
					.sound(SoundType.WET_GRASS)
					.pushReaction(PushReaction.DESTROY)
	));

	public static final DeferredBlock<YellowKelpPlantBlock> YELLOW_KELP_PLANT = cross("yellow_kelp_plant", () -> new YellowKelpPlantBlock(
		BlockBehaviour.Properties.of()
				.mapColor(MapColor.WATER)
				.noCollission()
				.instabreak()
				.sound(SoundType.WET_GRASS)
				.pushReaction(PushReaction.DESTROY)
	));

	private static <T extends Block> DeferredBlock<T> cubeAllWithItem(String name, Supplier<T> supplier) {
		DeferredBlock<T> dummy = BLOCKS.register(name, supplier);
		BlockStateDatagen.CUBE_ALL_BLOCK_LIST.add(dummy);
		return dummy;
	}

	private static <T extends Block> DeferredBlock<T> cross(String name, Supplier<T> supplier) {
		DeferredBlock<T> dummy = BLOCKS.register(name, supplier);
		BlockStateDatagen.CROSS_BLOCK_LIST.add(dummy);
		return dummy;
	}

}
