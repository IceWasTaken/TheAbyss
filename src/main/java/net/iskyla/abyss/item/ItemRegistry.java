package net.iskyla.abyss.item;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemRegistry {

	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Abyss.MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Abyss.MODID);

	public static final List<DeferredItem<?>> ITEM_LIST = new ArrayList<>();

	public static final DeferredItem<BlockItem> AQUASLATE = register("aquaslate", BlockRegistry.AQUASLATE);
	public static final DeferredItem<BlockItem> PRISMATIC_ROCK = register("prismatic_rock", BlockRegistry.PRISMATIC_ROCK);
	public static final DeferredItem<BlockItem> YELLOW_KELP = register("yellow_kelp", BlockRegistry.YELLOW_KELP);

	private static <T extends Item> DeferredItem<T> register(String id, Supplier<T> supplier) {
		DeferredItem<T> dummy = ITEMS.register(id, supplier);
		ITEM_LIST.add(dummy);
		return dummy;
	}

	private static DeferredItem<BlockItem> register(String id, DeferredBlock<?> block) {
		DeferredItem<BlockItem> dummy = ITEMS.registerSimpleBlockItem(id, block);
		ITEM_LIST.add(dummy);
		return dummy;
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("abyss_tab", () ->
			CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.abyss"))
					.icon(() -> AQUASLATE.get().getDefaultInstance()).displayItems(
							(itemDisplayParameters, output) -> {
								for(DeferredItem<?> item : ITEM_LIST) {
									output.accept(item);
								}
							}
					).build()
	);
}
