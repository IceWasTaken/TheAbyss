package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.ParticleTypeRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

public class ParticleDatagen extends ParticleDescriptionProvider {

	public ParticleDatagen(PackOutput output, ExistingFileHelper fileHelper) {
		super(output, fileHelper);
	}

	@Override
	protected void addDescriptions() {
		spriteSet(ParticleTypeRegistry.CHEMICAL_SOUP.get(), Abyss.resourceLocation("big_smoke"), 12, false);
	}
}
