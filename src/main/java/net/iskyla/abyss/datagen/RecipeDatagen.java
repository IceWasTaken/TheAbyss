package net.iskyla.abyss.datagen;

import net.iskyla.abyss.registry.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.concurrent.CompletableFuture;

public class RecipeDatagen extends RecipeProvider {

	private static RecipeOutput output;

	public RecipeDatagen(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> p_323846_) {
		super(p_248933_, p_323846_);
	}

	public void buildRecipes(RecipeOutput recipeOutput) {
		output = recipeOutput;

		wall(BlockRegistry.AQUASLATE_WALL, BlockRegistry.AQUASLATE);
		wall(BlockRegistry.PRISMATIC_ROCK_WALL, BlockRegistry.PRISMATIC_ROCK);

		stairs(BlockRegistry.AQUASLATE_STAIRS, BlockRegistry.AQUASLATE);
		stairs(BlockRegistry.PRISMATIC_ROCK_STAIRS, BlockRegistry.PRISMATIC_ROCK);

		slab(BlockRegistry.AQUASLATE_SLAB, BlockRegistry.AQUASLATE);
		slab(BlockRegistry.PRISMATIC_ROCK_SLAB, BlockRegistry.PRISMATIC_ROCK);

		output = null;
	}

	private void wall(ItemLike wall, ItemLike block) {
		wall(output, RecipeCategory.DECORATIONS, wall, block);
	}

	private void stairs(DeferredBlock<?> stairs, DeferredBlock<?> block) {
		stairBuilder(stairs, Ingredient.of(block))
				.unlockedBy("has_" + block.getId(), has(block))
				.save(output);
	}

	private void slab(DeferredBlock<?> slab, DeferredBlock<?> block) {
		slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, Ingredient.of(block))
				.unlockedBy("has_" + block.getId(), has(block))
				.save(output);
	}
}
