package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.BlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BlockStateDatagen extends BlockStateProvider {

	public BlockStateDatagen(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		cubeAllWithItem(BlockRegistry.AQUASLATE);
		slabBlock(BlockRegistry.AQUASLATE_SLAB.get(), blockTexture(BlockRegistry.AQUASLATE), blockTexture(BlockRegistry.AQUASLATE));
		stairsBlock(BlockRegistry.AQUASLATE_STAIRS.get(), blockTexture(BlockRegistry.AQUASLATE));
		wallBlock(BlockRegistry.AQUASLATE_WALL.get(), blockTexture(BlockRegistry.AQUASLATE));

		cubeAllWithItem(BlockRegistry.PRISMATIC_ROCK);
		slabBlock(BlockRegistry.PRISMATIC_ROCK_SLAB.get(), blockTexture(BlockRegistry.PRISMATIC_ROCK), blockTexture(BlockRegistry.PRISMATIC_ROCK));
		stairsBlock(BlockRegistry.PRISMATIC_ROCK_STAIRS.get(), blockTexture(BlockRegistry.PRISMATIC_ROCK));
		wallBlock(BlockRegistry.PRISMATIC_ROCK_WALL.get(), blockTexture(BlockRegistry.PRISMATIC_ROCK));

		cubeAllWithItem(BlockRegistry.AQUASLATE_IRON);
		cubeAllWithItem(BlockRegistry.AQUASLATE_GOLD);
		cubeAllWithItem(BlockRegistry.AQUASLATE_REDSTONE);
		cubeAllWithItem(BlockRegistry.AQUASLATE_LAPIS);
		cubeAllWithItem(BlockRegistry.AQUASLATE_DIAMOND);

		cross(BlockRegistry.YELLOW_KELP);
		cross(BlockRegistry.YELLOW_KELP_PLANT);

		//DEAD CORAL ================================================
//		cubeAllWithItem(BlockRegistry.DEAD_ORANGE_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_LIME_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_GREEN_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_CYAN_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_CUBIC_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_WHITE_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.DEAD_BLACK_CORAL_BLOCK);

//		cross(BlockRegistry.DEAD_ORANGE_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_LIME_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_GREEN_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_CYAN_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_CUBIC_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_WHITE_CORAL_PLANT);
//		cross(BlockRegistry.DEAD_BLACK_CORAL_PLANT);
//
//		coralFan(BlockRegistry.DEAD_ORANGE_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_LIME_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_GREEN_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_CYAN_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_CUBIC_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_WHITE_CORAL_FAN);
//		coralFan(BlockRegistry.DEAD_BLACK_CORAL_FAN);
//
//		coralFan(BlockRegistry.DEAD_ORANGE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_LIME_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_GREEN_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_CYAN_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_CUBIC_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_WHITE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.DEAD_BLACK_CORAL_WALL_FAN);

		//LIVING CORAL ================================================
//		cubeAllWithItem(BlockRegistry.ORANGE_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.LIME_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.GREEN_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.CYAN_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.LIGHT_BLUE_CORAL_BLOCK);
		cubeAllWithItem(BlockRegistry.CUBIC_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.WHITE_CORAL_BLOCK);
//		cubeAllWithItem(BlockRegistry.BLACK_CORAL_BLOCK);

//		cross(BlockRegistry.ORANGE_CORAL_PLANT);
//		cross(BlockRegistry.LIME_CORAL_PLANT);
//		cross(BlockRegistry.GREEN_CORAL_PLANT);
//		cross(BlockRegistry.CYAN_CORAL_PLANT);
//		cross(BlockRegistry.LIGHT_BLUE_CORAL_PLANT);
//		cross(BlockRegistry.CUBIC_CORAL_PLANT);
//		cross(BlockRegistry.WHITE_CORAL_PLANT);
//		cross(BlockRegistry.BLACK_CORAL_PLANT);
//
//		coralFan(BlockRegistry.ORANGE_CORAL_FAN);
//		coralFan(BlockRegistry.LIME_CORAL_FAN);
//		coralFan(BlockRegistry.GREEN_CORAL_FAN);
//		coralFan(BlockRegistry.CYAN_CORAL_FAN);
//		coralFan(BlockRegistry.LIGHT_BLUE_CORAL_FAN);
//		coralFan(BlockRegistry.CUBIC_CORAL_FAN);
//		coralFan(BlockRegistry.WHITE_CORAL_FAN);
//		coralFan(BlockRegistry.BLACK_CORAL_FAN);
//
//		coralFan(BlockRegistry.ORANGE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.LIME_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.GREEN_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.CYAN_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.LIGHT_BLUE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.CUBIC_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.WHITE_CORAL_WALL_FAN);
//		coralFan(BlockRegistry.BLACK_CORAL_WALL_FAN);

		cubeAllWithItem(BlockRegistry.ABYSS_PORTAL, "translucent");
	}

	private ResourceLocation blockTexture(DeferredBlock<?> block) {
		return blockTexture(block.get());
	}

	private void cubeAllWithItem(DeferredBlock<?> block) {
		simpleBlockWithItem(block.get(), cubeAll(block.get()));
	}
	private void cubeAllWithItem(DeferredBlock<?> block, String renderType) {
		simpleBlockWithItem(block.get(), models().cubeAll(
						BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
						blockTexture(block.get())
				)
				.renderType(renderType)
		);
	}

	private void cross(DeferredBlock<?> block) {
		simpleBlock(block.get(),
				models().cross(
						BuiltInRegistries.BLOCK.getKey(block.get()).getPath(),
						blockTexture(block.get())
				).renderType("cutout")
		);
	}

	private void coralFan(DeferredBlock<?> block) {
		simpleBlock(block.get(), models()
				.withExistingParent(
						block.getId().getPath(), mcLoc("block/coral_fan")
				)
				.texture("fan", modLoc("block/" + block.getId().getPath()))
		);
	}
}
