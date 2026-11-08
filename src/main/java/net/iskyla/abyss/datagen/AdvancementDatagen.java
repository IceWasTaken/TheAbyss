package net.iskyla.abyss.datagen;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.registry.BlockRegistry;
import net.iskyla.abyss.worldgen.dimension.DimensionDatagen;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.ChangeDimensionTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

//CALL THEM ACHIEVEMENTS LIKE EVER OTHER FUCKING GAME, MOJANG
public class AdvancementDatagen implements AdvancementSubProvider {

	public static AdvancementProvider create(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		return new AdvancementProvider(
				output,
				registries,
				List.of(
						new AdvancementDatagen()
				)
		);
	}

	@Override
	public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> writer) {
		AdvancementHolder ABYSS_ROOT = Advancement.Builder.advancement()
				.display(
						BlockRegistry.PRISMATIC_ROCK,
						Component.translatable("advancements.abyss.root.title"), //name
						Component.translatable("advancements.abyss.root.description"), //description
						backgroundLoc(),
						AdvancementType.TASK,
						false,
						false,
						false
				)
				.addCriterion("enter_abyss", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionDatagen.OCEAN_LEVEL_KEY))
				.save(writer, id("root"));

		AdvancementHolder ENTER_ABYSS = Advancement.Builder.advancement()
				.parent(ABYSS_ROOT)
				.display(
						BlockRegistry.AQUASLATE,
						Component.translatable("advancements.abyss.enter_abyss.title"), //name
						Component.translatable("advancements.abyss.enter_abyss.description"), //description
						backgroundLoc(),
						AdvancementType.TASK,
						true,
						true,
						false
				)
				.addCriterion("enter_abyss", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(DimensionDatagen.OCEAN_LEVEL_KEY))
				.save(writer, id("enter_abyss"));
	}

	private String id(String name) {
		return "abyss:abyss/" + name;
	}

	private ResourceLocation backgroundLoc() {
		return Abyss.resourceLocation("textures/gui/advancements.png");
	}
}
