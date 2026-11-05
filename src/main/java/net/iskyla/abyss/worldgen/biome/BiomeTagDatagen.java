package net.iskyla.abyss.worldgen.biome;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class BiomeTagDatagen extends BiomeTagsProvider {

	public static final TagKey<Biome> HAS_STRUCTURE_ABYSS_PORTAL_OVERWORLD = TagKey.create(Registries.BIOME, Abyss.resourceLocation("has_structure/abyss_portal_overworld"));
	public static final TagKey<Biome> HAS_STRUCTURE_ABYSS_PORTAL_ABYSS = TagKey.create(Registries.BIOME, Abyss.resourceLocation("has_structure/abyss_portal_abyss"));

	public BiomeTagDatagen(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper existingFileHelper) {
		super(output, provider, Abyss.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		tag(HAS_STRUCTURE_ABYSS_PORTAL_OVERWORLD).addTag(BiomeTags.IS_DEEP_OCEAN);
		tag(HAS_STRUCTURE_ABYSS_PORTAL_ABYSS)
				.addOptional(BiomeDatagen.ABYSSAL_ARCHES.location())
				.addOptional(BiomeDatagen.ABYSSAL_CAVES.location())
				.addOptional(BiomeDatagen.ABYSSAL_OASIS.location())
				.addOptional(BiomeDatagen.ABYSSAL_VENTS.location());
	}
}
