package net.iskyla.abyss.block;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.datagen.BlockStateDatagen;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Abyss.MODID);

	public static final DeferredBlock<Block> AQUASLATE = cubeAllWithItem("aquaslate", () -> new Block(BlockBehaviour.Properties.of()));
	public static final DeferredBlock<Block> PRISMATIC_ROCK = cubeAllWithItem("prismatic_rock", () -> new Block(BlockBehaviour.Properties.of()));

	private static <T extends Block> DeferredBlock<T> cubeAllWithItem(String name, Supplier<T> supplier) {
		DeferredBlock<T> dummy = BLOCKS.register(name, supplier);
		BlockStateDatagen.BLOCK_LIST.add(dummy);
		return dummy;
	}

}
