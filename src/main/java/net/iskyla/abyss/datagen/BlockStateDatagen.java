package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockStateDatagen extends BlockStateProvider {

	public static final List<DeferredBlock<?>> CUBE_ALL_BLOCK_LIST = new ArrayList<>();
	public static final List<DeferredBlock<?>> CROSS_BLOCK_LIST = new ArrayList<>();

	public BlockStateDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for(DeferredBlock<?> block : CUBE_ALL_BLOCK_LIST) {
			simpleBlockWithItem(block.get(), cubeAll(block.get()));
		}

		for(DeferredBlock<?> block : CROSS_BLOCK_LIST) {
			cross(block);
		}
	}

	private void cross(DeferredBlock<?> block) {
		simpleBlock(block.get(),
				models().cross(
						BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
						blockTexture(block.get())
				).renderType("cutout")
		);
	}
}
