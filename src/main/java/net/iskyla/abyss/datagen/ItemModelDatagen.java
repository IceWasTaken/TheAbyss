package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ItemModelDatagen extends ItemModelProvider {



	public ItemModelDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		BlockStateDatagen.CUBE_ALL_BLOCK_LIST.forEach(blockState -> simpleBlockItem(blockState.get()));
		BlockStateDatagen.CROSS_BLOCK_LIST.forEach(this::flatBlockItem);
	}

	private void flatBlockItem(DeferredBlock<?> block) {
		withExistingParent(block.getId().getPath(), ResourceLocation.parse("item/generated"))
				.texture("layer0", ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "block/" + block.getId().getPath()));
	}
}
