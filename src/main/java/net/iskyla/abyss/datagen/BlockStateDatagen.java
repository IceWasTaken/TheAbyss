package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.ArrayList;
import java.util.List;

public class BlockStateDatagen extends BlockStateProvider {

	public static final List<DeferredBlock<?>> BLOCK_LIST = new ArrayList<>();

	public BlockStateDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		for(DeferredBlock<?> block : BLOCK_LIST) {
			simpleBlockWithItem(BlockRegistry.AQUASLATE.get(), cubeAll(BlockRegistry.AQUASLATE.get()));
		}
	}
}
