package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagDatagen extends BlockTagsProvider {


	public BlockTagDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(BlockRegistry.AQUASLATE_DIAMOND.get())
				.add(BlockRegistry.AQUASLATE.get());
	}
}
