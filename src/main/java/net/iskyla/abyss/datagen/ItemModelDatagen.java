package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.BlockRegistry;
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
		simpleBlockItem(BlockRegistry.AQUASLATE);
		simpleBlockItem(BlockRegistry.AQUASLATE_SLAB);
		simpleBlockItem(BlockRegistry.AQUASLATE_STAIRS);
		wallBlockItem(BlockRegistry.AQUASLATE_WALL, BlockRegistry.AQUASLATE);

		simpleBlockItem(BlockRegistry.PRISMATIC_ROCK);
		simpleBlockItem(BlockRegistry.PRISMATIC_ROCK_SLAB);
		simpleBlockItem(BlockRegistry.PRISMATIC_ROCK_STAIRS);
		wallBlockItem(BlockRegistry.PRISMATIC_ROCK_WALL, BlockRegistry.PRISMATIC_ROCK);

		simpleBlockItem(BlockRegistry.AQUASLATE_IRON);
		simpleBlockItem(BlockRegistry.AQUASLATE_GOLD);
		simpleBlockItem(BlockRegistry.AQUASLATE_REDSTONE);
		simpleBlockItem(BlockRegistry.AQUASLATE_LAPIS);
		simpleBlockItem(BlockRegistry.AQUASLATE_DIAMOND);

		flatBlockItem(BlockRegistry.YELLOW_KELP);
		flatBlockItem(BlockRegistry.YELLOW_KELP_PLANT);
		
		//DEAD CORAL ================================================
//		simpleBlockItem(BlockRegistry.DEAD_ORANGE_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_LIME_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_GREEN_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_CYAN_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_CUBIC_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_WHITE_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.DEAD_BLACK_CORAL_BLOCK);
//
//		flatBlockItem(BlockRegistry.DEAD_ORANGE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_LIME_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_GREEN_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_CYAN_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_CUBIC_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_WHITE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.DEAD_BLACK_CORAL_PLANT);
//
//		flatBlockItem(BlockRegistry.DEAD_ORANGE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_LIME_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_GREEN_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_CYAN_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_CUBIC_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_WHITE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_BLACK_CORAL_FAN);
//
//		flatBlockItem(BlockRegistry.DEAD_ORANGE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_LIME_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_GREEN_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_CYAN_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_CUBIC_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_WHITE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.DEAD_BLACK_CORAL_WALL_FAN);

		//LIVING CORAL ================================================
//		simpleBlockItem(BlockRegistry.ORANGE_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.LIME_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.GREEN_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.CYAN_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.LIGHT_BLUE_CORAL_BLOCK);
		simpleBlockItem(BlockRegistry.CUBIC_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.WHITE_CORAL_BLOCK);
//		simpleBlockItem(BlockRegistry.BLACK_CORAL_BLOCK);

//		flatBlockItem(BlockRegistry.ORANGE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.LIME_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.GREEN_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.CYAN_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.LIGHT_BLUE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.CUBIC_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.WHITE_CORAL_PLANT);
//		flatBlockItem(BlockRegistry.BLACK_CORAL_PLANT);
//
//		flatBlockItem(BlockRegistry.ORANGE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.LIME_CORAL_FAN);
//		flatBlockItem(BlockRegistry.GREEN_CORAL_FAN);
//		flatBlockItem(BlockRegistry.CYAN_CORAL_FAN);
//		flatBlockItem(BlockRegistry.LIGHT_BLUE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.CUBIC_CORAL_FAN);
//		flatBlockItem(BlockRegistry.WHITE_CORAL_FAN);
//		flatBlockItem(BlockRegistry.BLACK_CORAL_FAN);
//
//		flatBlockItem(BlockRegistry.ORANGE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.LIME_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.GREEN_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.CYAN_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.LIGHT_BLUE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.CUBIC_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.WHITE_CORAL_WALL_FAN);
//		flatBlockItem(BlockRegistry.BLACK_CORAL_WALL_FAN);
	}
	
	private void simpleBlockItem(DeferredBlock<?> block) {
		simpleBlockItem(block.get());
	}

	private void wallBlockItem(DeferredBlock<?> block, DeferredBlock<?> texBlock) {
		withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
				.texture("wall", modLoc("block/" + texBlock.getId().getPath()));
	}

	private void flatBlockItem(DeferredBlock<?> block) {
		withExistingParent(block.getId().getPath(), ResourceLocation.parse("item/generated"))
				.texture("layer0", ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "block/" + block.getId().getPath()));
	}
}

