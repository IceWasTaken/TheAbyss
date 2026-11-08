package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.item.ChasmLocator;
import net.iskyla.abyss.item.GenericTrident;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
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

	public static final DeferredItem<BlockItem> AQUASLATE = register("aquaslate", BlockRegistry.AQUASLATE);
	public static final DeferredItem<BlockItem> AQUASLATE_SLAB = register("aquaslate_slab", BlockRegistry.AQUASLATE_SLAB);
	public static final DeferredItem<BlockItem> AQUASLATE_STAIRS = register("aquaslate_stairs", BlockRegistry.AQUASLATE_STAIRS);
	public static final DeferredItem<BlockItem> AQUASLATE_WALL = register("aquaslate_wall", BlockRegistry.AQUASLATE_WALL);

	public static final DeferredItem<BlockItem> PRISMATIC_ROCK = register("prismatic_rock", BlockRegistry.PRISMATIC_ROCK);
	public static final DeferredItem<BlockItem> PRISMATIC_ROCK_SLAB = register("prismatic_rock_slab", BlockRegistry.PRISMATIC_ROCK_SLAB);
	public static final DeferredItem<BlockItem> PRISMATIC_ROCK_STAIRS = register("prismatic_rock_stairs", BlockRegistry.PRISMATIC_ROCK_STAIRS);
	public static final DeferredItem<BlockItem> PRISMATIC_ROCK_WALL = register("prismatic_rock_wall", BlockRegistry.PRISMATIC_ROCK_WALL);


	public static final DeferredItem<BlockItem> YELLOW_KELP = register("yellow_kelp", BlockRegistry.YELLOW_KELP);

	public static final DeferredItem<BlockItem> AQUASLATE_DIAMOND = register("aquaslate_diamond", BlockRegistry.AQUASLATE_DIAMOND);
	public static final DeferredItem<BlockItem> AQUASLATE_GOLD = register("aquaslate_gold", BlockRegistry.AQUASLATE_GOLD);
	public static final DeferredItem<BlockItem> AQUASLATE_IRON = register("aquaslate_iron", BlockRegistry.AQUASLATE_IRON);
	public static final DeferredItem<BlockItem> AQUASLATE_REDSTONE = register("aquaslate_redstone", BlockRegistry.AQUASLATE_REDSTONE);
	public static final DeferredItem<BlockItem> AQUASLATE_LAPIS = register("aquaslate_lapis", BlockRegistry.AQUASLATE_LAPIS);

	public static final DeferredItem<BlockItem> HYDROTHERMAL_VENT = register("hydrothermal_vent", BlockRegistry.HYDROTHERMAL_VENT);

//	public static final DeferredItem<BlockItem> DEAD_ORANGE_CORAL_BLOCK = register("dead_orange_coral_block", BlockRegistry.DEAD_ORANGE_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_LIME_CORAL_BLOCK = register("dead_lime_coral_block", BlockRegistry.DEAD_LIME_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_GREEN_CORAL_BLOCK = register("dead_green_coral_block", BlockRegistry.DEAD_GREEN_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_CYAN_CORAL_BLOCK = register("dead_cyan_coral_block", BlockRegistry.DEAD_CYAN_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_LIGHT_BLUE_CORAL_BLOCK = register("dead_light_blue_coral_block", BlockRegistry.DEAD_LIGHT_BLUE_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_CUBIC_CORAL_BLOCK = register("dead_cubic_coral_block", BlockRegistry.DEAD_CUBIC_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_WHITE_CORAL_BLOCK = register("dead_white_coral_block", BlockRegistry.DEAD_WHITE_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> DEAD_BLACK_CORAL_BLOCK = register("dead_black_coral_block", BlockRegistry.DEAD_BLACK_CORAL_BLOCK);
//
//	public static final DeferredItem<BlockItem> DEAD_ORANGE_CORAL_PLANT = register("dead_orange_coral_plant", BlockRegistry.DEAD_ORANGE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_LIME_CORAL_PLANT = register("dead_lime_coral_plant", BlockRegistry.DEAD_LIME_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_GREEN_CORAL_PLANT = register("dead_green_coral_plant", BlockRegistry.DEAD_GREEN_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_CYAN_CORAL_PLANT = register("dead_cyan_coral_plant", BlockRegistry.DEAD_CYAN_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_LIGHT_BLUE_CORAL_PLANT = register("dead_light_blue_coral_plant", BlockRegistry.DEAD_LIGHT_BLUE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_CUBIC_CORAL_PLANT = register("dead_cubic_coral_plant", BlockRegistry.DEAD_CUBIC_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_WHITE_CORAL_PLANT = register("dead_white_coral_plant", BlockRegistry.DEAD_WHITE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> DEAD_BLACK_CORAL_PLANT = register("dead_black_coral_plant", BlockRegistry.DEAD_BLACK_CORAL_PLANT);
//
//	public static final DeferredItem<BlockItem> DEAD_ORANGE_CORAL_FAN = register("dead_orange_coral_fan", BlockRegistry.DEAD_ORANGE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_LIME_CORAL_FAN = register("dead_lime_coral_fan", BlockRegistry.DEAD_LIME_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_GREEN_CORAL_FAN = register("dead_green_coral_fan", BlockRegistry.DEAD_GREEN_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_CYAN_CORAL_FAN = register("dead_cyan_coral_fan", BlockRegistry.DEAD_CYAN_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_LIGHT_BLUE_CORAL_FAN = register("dead_light_blue_coral_fan", BlockRegistry.DEAD_LIGHT_BLUE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_CUBIC_CORAL_FAN = register("dead_cubic_coral_fan", BlockRegistry.DEAD_CUBIC_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_WHITE_CORAL_FAN = register("dead_white_coral_fan", BlockRegistry.DEAD_WHITE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_BLACK_CORAL_FAN = register("dead_black_coral_fan", BlockRegistry.DEAD_BLACK_CORAL_FAN);
//
//	public static final DeferredItem<BlockItem> DEAD_ORANGE_CORAL_WALL_FAN = register("dead_orange_coral_wall_fan", BlockRegistry.DEAD_ORANGE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_LIME_CORAL_WALL_FAN = register("dead_lime_coral_wall_fan", BlockRegistry.DEAD_LIME_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_GREEN_CORAL_WALL_FAN = register("dead_green_coral_wall_fan", BlockRegistry.DEAD_GREEN_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_CYAN_CORAL_WALL_FAN = register("dead_cyan_coral_wall_fan", BlockRegistry.DEAD_CYAN_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_LIGHT_BLUE_CORAL_WALL_FAN = register("dead_light_blue_coral_wall_fan", BlockRegistry.DEAD_LIGHT_BLUE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_CUBIC_CORAL_WALL_FAN = register("dead_cubic_coral_wall_fan", BlockRegistry.DEAD_CUBIC_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_WHITE_CORAL_WALL_FAN = register("dead_white_coral_wall_fan", BlockRegistry.DEAD_WHITE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> DEAD_BLACK_CORAL_WALL_FAN = register("dead_black_coral_wall_fan", BlockRegistry.DEAD_BLACK_CORAL_WALL_FAN);
//
//	public static final DeferredItem<BlockItem> GINGER_CORAL_BLOCK = register("ginger_coral_block", BlockRegistry.GINGER_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> SPOTTED_CORAL_BLOCK = register("spotted_coral_block", BlockRegistry.SPOTTED_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> GREEN_CORAL_BLOCK = register("green_coral_block", BlockRegistry.GREEN_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> CYAN_CORAL_BLOCK = register("cyan_coral_block", BlockRegistry.CYAN_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> SQUID_CORAL_BLOCK = register("light_blue_coral_block", BlockRegistry.SQUID_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> CUBIC_CORAL_BLOCK = register("cubic_coral_block", BlockRegistry.CUBIC_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> GHOST_CORAL_BLOCK = register("white_coral_block", BlockRegistry.GHOST_CORAL_BLOCK);
//	public static final DeferredItem<BlockItem> WIRE_CORAL_BLOCK = register("black_coral_block", BlockRegistry.WIRE_CORAL_BLOCK);
//
//	public static final DeferredItem<BlockItem> ORANGE_CORAL_PLANT = register("orange_coral_plant", BlockRegistry.ORANGE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> LIME_CORAL_PLANT = register("lime_coral_plant", BlockRegistry.LIME_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> GREEN_CORAL_PLANT = register("green_coral_plant", BlockRegistry.GREEN_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> CYAN_CORAL_PLANT = register("cyan_coral_plant", BlockRegistry.CYAN_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> LIGHT_BLUE_CORAL_PLANT = register("light_blue_coral_plant", BlockRegistry.LIGHT_BLUE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> CUBIC_CORAL_PLANT = register("cubic_coral_plant", BlockRegistry.CUBIC_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> WHITE_CORAL_PLANT = register("white_coral_plant", BlockRegistry.WHITE_CORAL_PLANT);
//	public static final DeferredItem<BlockItem> BLACK_CORAL_PLANT = register("black_coral_plant", BlockRegistry.BLACK_CORAL_PLANT);
//
//	public static final DeferredItem<BlockItem> ORANGE_CORAL_FAN = register("orange_coral_fan", BlockRegistry.ORANGE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> LIME_CORAL_FAN = register("lime_coral_fan", BlockRegistry.LIME_CORAL_FAN);
//	public static final DeferredItem<BlockItem> GREEN_CORAL_FAN = register("green_coral_fan", BlockRegistry.GREEN_CORAL_FAN);
//	public static final DeferredItem<BlockItem> CYAN_CORAL_FAN = register("cyan_coral_fan", BlockRegistry.CYAN_CORAL_FAN);
//	public static final DeferredItem<BlockItem> LIGHT_BLUE_CORAL_FAN = register("light_blue_coral_fan", BlockRegistry.LIGHT_BLUE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> CUBIC_CORAL_FAN = register("cubic_coral_fan", BlockRegistry.CUBIC_CORAL_FAN);
//	public static final DeferredItem<BlockItem> WHITE_CORAL_FAN = register("white_coral_fan", BlockRegistry.WHITE_CORAL_FAN);
//	public static final DeferredItem<BlockItem> BLACK_CORAL_FAN = register("black_coral_fan", BlockRegistry.BLACK_CORAL_FAN);
//
//	public static final DeferredItem<BlockItem> ORANGE_CORAL_WALL_FAN = register("orange_coral_wall_fan", BlockRegistry.ORANGE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> LIME_CORAL_WALL_FAN = register("lime_coral_wall_fan", BlockRegistry.LIME_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> GREEN_CORAL_WALL_FAN = register("green_coral_wall_fan", BlockRegistry.GREEN_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> CYAN_CORAL_WALL_FAN = register("cyan_coral_wall_fan", BlockRegistry.CYAN_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> LIGHT_BLUE_CORAL_WALL_FAN = register("light_blue_coral_wall_fan", BlockRegistry.LIGHT_BLUE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> CUBIC_CORAL_WALL_FAN = register("cubic_coral_wall_fan", BlockRegistry.CUBIC_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> WHITE_CORAL_WALL_FAN = register("white_coral_wall_fan", BlockRegistry.WHITE_CORAL_WALL_FAN);
//	public static final DeferredItem<BlockItem> BLACK_CORAL_WALL_FAN = register("black_coral_wall_fan", BlockRegistry.BLACK_CORAL_WALL_FAN);

	public static final DeferredItem<BlockItem> ABYSS_PORTAL = register("abyss_portal", BlockRegistry.ABYSS_PORTAL);
	public static final DeferredItem<ChasmLocator> CHASM_LOCATOR = register("chasm_locator", () -> new ChasmLocator(new Item.Properties()));

	public static final DeferredItem<GenericTrident> FANCY_TRIDENT = register("fancy_trident", () -> new GenericTrident(
			new Item.Properties()
					.rarity(Rarity.RARE)
					.durability(250)
					.attributes(GenericTrident.createAttributes())
					.component(DataComponents.TOOL, GenericTrident.createToolProperties())
	));

	private static <T extends Item> DeferredItem<T> register(String id, Supplier<T> supplier) {
		DeferredItem<T> dummy = ITEMS.register(id, supplier);
		return dummy;
	}

	private static DeferredItem<BlockItem> register(String id, DeferredBlock<?> block) {
		DeferredItem<BlockItem> dummy = ITEMS.registerSimpleBlockItem(id, block);
		return dummy;
	}

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("abyss_tab", () ->
			CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.abyss"))
					.icon(() -> AQUASLATE.get().getDefaultInstance()).displayItems(
							(itemDisplayParameters, output) -> {
								//...
								//...
								//since when has there been just casually an iterator built into deferred registers
								ITEMS.getEntries().forEach(entry -> {
									output.accept(entry.get());
								});
							}
					).build()
	);
}
