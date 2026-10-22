package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelDatagen extends ItemModelProvider {

	public ItemModelDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		BlockStateDatagen.BLOCK_LIST.forEach(blockState -> simpleBlockItem(blockState.get()));
	}
}
