package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.AbyssPortalBlock;
import net.iskyla.abyss.block.VentSmokeSourceBlock;
import net.iskyla.abyss.block.YellowKelpBlock;
import net.iskyla.abyss.block.YellowKelpPlantBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Abyss.MODID);

	public static final DeferredBlock<Block> AQUASLATE = register("aquaslate", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4.0f, 12.0f)));
	public static final DeferredBlock<SlabBlock> AQUASLATE_SLAB = register("aquaslate_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4.0f, 12.0f)));
	public static final DeferredBlock<StairBlock> AQUASLATE_STAIRS = register("aquaslate_stairs", () -> new StairBlock(AQUASLATE.get().defaultBlockState(), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4.0f, 12.0f)));
	public static final DeferredBlock<WallBlock> AQUASLATE_WALL = register("aquaslate_wall", () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(4.0f, 12.0f)));

	public static final DeferredBlock<Block> PRISMATIC_ROCK = register("prismatic_rock", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6f, 12f)));
	public static final DeferredBlock<SlabBlock> PRISMATIC_ROCK_SLAB = register("prismatic_rock_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6f, 12f)));
	public static final DeferredBlock<StairBlock> PRISMATIC_ROCK_STAIRS = register("prismatic_rock_stairs", () -> new StairBlock(PRISMATIC_ROCK.get().defaultBlockState(), BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6f, 12f)));
	public static final DeferredBlock<WallBlock> PRISMATIC_ROCK_WALL = register("prismatic_rock_wall", () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(6f, 12f)));

	public static final DeferredBlock<Block> AQUASLATE_IRON = register("aquaslate_iron", () -> new Block(BlockBehaviour.Properties.of().destroyTime(1.2f)));
	public static final DeferredBlock<Block> AQUASLATE_GOLD = register("aquaslate_gold", () -> new Block(BlockBehaviour.Properties.of().destroyTime(1.2f)));
	public static final DeferredBlock<Block> AQUASLATE_REDSTONE = register("aquaslate_redstone", () -> new Block(BlockBehaviour.Properties.of().destroyTime(1.2f)));
	public static final DeferredBlock<Block> AQUASLATE_LAPIS = register("aquaslate_lapis", () -> new Block(BlockBehaviour.Properties.of().destroyTime(1.2f)));
	public static final DeferredBlock<Block> AQUASLATE_DIAMOND = register("aquaslate_diamond", () -> new Block(BlockBehaviour.Properties.of().destroyTime(1.2f)));

	public static final DeferredBlock<YellowKelpBlock> YELLOW_KELP = register("yellow_kelp", () -> new YellowKelpBlock(
			BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().randomTicks().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)
	));

	public static final DeferredBlock<YellowKelpPlantBlock> YELLOW_KELP_PLANT = register("yellow_kelp_plant", () -> new YellowKelpPlantBlock(
		BlockBehaviour.Properties.of().mapColor(MapColor.WATER).noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY)
	));

	private static final BlockBehaviour.Properties DEAD_CORAL_PROPERTIES = BlockBehaviour.Properties
			.of()
			.mapColor(MapColor.COLOR_GRAY)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASEDRUM)
			.requiresCorrectToolForDrops()
			.strength(1.5f, 6.0f);

	private static final BlockBehaviour.Properties DEAD_CORAL_PLANT_PROPERTIES = BlockBehaviour.Properties
			.of()
			.mapColor(MapColor.COLOR_GRAY)
			.forceSolidOn()
			.instrument(NoteBlockInstrument.BASEDRUM)
			.requiresCorrectToolForDrops()
			.noCollission()
			.instabreak();

	private static BlockBehaviour.Properties coralProperties() {
		return BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.5f, 6.0f).sound(SoundType.CORAL_BLOCK);
	}

	private static BlockBehaviour.Properties coralPlantProperties() {
		return BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.WET_GRASS).pushReaction(PushReaction.DESTROY);
	}

//	public static final DeferredBlock<Block> DEAD_ORANGE_CORAL_BLOCK = register("dead_orange_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_LIME_CORAL_BLOCK = register("dead_lime_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_GREEN_CORAL_BLOCK = register("dead_green_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_CYAN_CORAL_BLOCK = register("dead_cyan_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_LIGHT_BLUE_CORAL_BLOCK = register("dead_light_blue_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_CUBIC_CORAL_BLOCK = register("dead_cubic_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_WHITE_CORAL_BLOCK = register("dead_white_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//	public static final DeferredBlock<Block> DEAD_BLACK_CORAL_BLOCK = register("dead_black_coral_block", () -> new Block(DEAD_CORAL_PROPERTIES));
//
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_ORANGE_CORAL_PLANT = register("dead_orange_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_LIME_CORAL_PLANT = register("dead_lime_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_GREEN_CORAL_PLANT = register("dead_green_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_CYAN_CORAL_PLANT = register("dead_cyan_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_LIGHT_BLUE_CORAL_PLANT = register("dead_light_blue_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_CUBIC_CORAL_PLANT = register("dead_cubic_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_WHITE_CORAL_PLANT = register("dead_white_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralPlantBlock> DEAD_BLACK_CORAL_PLANT = register("dead_black_coral_plant", () -> new BaseCoralPlantBlock(DEAD_CORAL_PLANT_PROPERTIES));
//
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_ORANGE_CORAL_FAN = register("dead_orange_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_LIME_CORAL_FAN = register("dead_lime_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_GREEN_CORAL_FAN = register("dead_green_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_CYAN_CORAL_FAN = register("dead_cyan_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_LIGHT_BLUE_CORAL_FAN = register("dead_light_blue_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_CUBIC_CORAL_FAN = register("dead_cubic_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_WHITE_CORAL_FAN = register("dead_white_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralFanBlock> DEAD_BLACK_CORAL_FAN = register("dead_black_coral_fan", () -> new BaseCoralFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_ORANGE_CORAL_WALL_FAN = register("dead_orange_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_LIME_CORAL_WALL_FAN = register("dead_lime_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_GREEN_CORAL_WALL_FAN = register("dead_green_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_CYAN_CORAL_WALL_FAN = register("dead_cyan_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_LIGHT_BLUE_CORAL_WALL_FAN = register("dead_light_blue_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_CUBIC_CORAL_WALL_FAN = register("dead_cubic_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_WHITE_CORAL_WALL_FAN = register("dead_white_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//	public static final DeferredBlock<BaseCoralWallFanBlock> DEAD_BLACK_CORAL_WALL_FAN = register("dead_black_coral_wall_fan", () -> new BaseCoralWallFanBlock(DEAD_CORAL_PLANT_PROPERTIES));
//
//	public static final DeferredBlock<CoralBlock> GINGER_CORAL_BLOCK = register("ginger_coral_block", () -> new CoralBlock(DEAD_ORANGE_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_ORANGE)));
//	public static final DeferredBlock<CoralBlock> SPOTTED_CORAL_BLOCK = register("spotted_coral_block", () -> new CoralBlock(DEAD_LIME_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_LIGHT_GREEN)));
//	public static final DeferredBlock<CoralBlock> GREEN_CORAL_BLOCK = register("green_coral_block", () -> new CoralBlock(DEAD_GREEN_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_GREEN)));
//	public static final DeferredBlock<CoralBlock> CYAN_CORAL_BLOCK = register("cyan_coral_block", () -> new CoralBlock(DEAD_CYAN_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_CYAN)));
//	public static final DeferredBlock<CoralBlock> SQUID_CORAL_BLOCK = register("squid_coral_block", () -> new CoralBlock(DEAD_LIGHT_BLUE_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_LIGHT_BLUE)));
//	public static final DeferredBlock<CoralBlock> CUBIC_CORAL_BLOCK = register("cubic_coral_block", () -> new CoralBlock(DEAD_CUBIC_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_PURPLE)));
//	public static final DeferredBlock<CoralBlock> GHOST_CORAL_BLOCK = register("ghost_coral_block", () -> new CoralBlock(DEAD_WHITE_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.TERRACOTTA_WHITE)));
//	public static final DeferredBlock<CoralBlock> WIRE_CORAL_BLOCK = register("wire_coral_block", () -> new CoralBlock(DEAD_BLACK_CORAL_BLOCK.get(), coralProperties().mapColor(MapColor.COLOR_BLACK)));
//
//	public static final DeferredBlock<CoralPlantBlock> ORANGE_CORAL_PLANT = register("orange_coral_plant", () -> new CoralPlantBlock(DEAD_ORANGE_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_ORANGE)));
//	public static final DeferredBlock<CoralPlantBlock> LIME_CORAL_PLANT = register("lime_coral_plant", () -> new CoralPlantBlock(DEAD_LIME_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_GREEN)));
//	public static final DeferredBlock<CoralPlantBlock> GREEN_CORAL_PLANT = register("green_coral_plant", () -> new CoralPlantBlock(DEAD_GREEN_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_GREEN)));
//	public static final DeferredBlock<CoralPlantBlock> CYAN_CORAL_PLANT = register("cyan_coral_plant", () -> new CoralPlantBlock(DEAD_CYAN_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_CYAN)));
//	public static final DeferredBlock<CoralPlantBlock> LIGHT_BLUE_CORAL_PLANT = register("light_blue_coral_plant", () -> new CoralPlantBlock(DEAD_LIGHT_BLUE_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_BLUE)));
//	public static final DeferredBlock<CoralPlantBlock> CUBIC_CORAL_PLANT = register("cubic_coral_plant", () -> new CoralPlantBlock(DEAD_CUBIC_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_PURPLE)));
//	public static final DeferredBlock<CoralPlantBlock> WHITE_CORAL_PLANT = register("white_coral_plant", () -> new CoralPlantBlock(DEAD_WHITE_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.TERRACOTTA_WHITE)));
//	public static final DeferredBlock<CoralPlantBlock> BLACK_CORAL_PLANT = register("black_coral_plant", () -> new CoralPlantBlock(DEAD_BLACK_CORAL_PLANT.get(), coralPlantProperties().mapColor(MapColor.COLOR_BLACK)));
//
//	public static final DeferredBlock<CoralFanBlock> ORANGE_CORAL_FAN = register("orange_coral_fan", () -> new CoralFanBlock(DEAD_ORANGE_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_ORANGE)));
//	public static final DeferredBlock<CoralFanBlock> LIME_CORAL_FAN = register("lime_coral_fan", () -> new CoralFanBlock(DEAD_LIME_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_GREEN)));
//	public static final DeferredBlock<CoralFanBlock> GREEN_CORAL_FAN = register("green_coral_fan", () -> new CoralFanBlock(DEAD_GREEN_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_GREEN)));
//	public static final DeferredBlock<CoralFanBlock> CYAN_CORAL_FAN = register("cyan_coral_fan", () -> new CoralFanBlock(DEAD_CYAN_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_CYAN)));
//	public static final DeferredBlock<CoralFanBlock> LIGHT_BLUE_CORAL_FAN = register("light_blue_coral_fan", () -> new CoralFanBlock(DEAD_LIGHT_BLUE_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_BLUE)));
//	public static final DeferredBlock<CoralFanBlock> CUBIC_CORAL_FAN = register("cubic_coral_fan", () -> new CoralFanBlock(DEAD_CUBIC_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_PURPLE)));
//	public static final DeferredBlock<CoralFanBlock> WHITE_CORAL_FAN = register("white_coral_fan", () -> new CoralFanBlock(DEAD_WHITE_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.TERRACOTTA_WHITE)));
//	public static final DeferredBlock<CoralFanBlock> BLACK_CORAL_FAN = register("black_coral_fan", () -> new CoralFanBlock(DEAD_BLACK_CORAL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_BLACK)));
//
//	public static final DeferredBlock<CoralWallFanBlock> ORANGE_CORAL_WALL_FAN = register("orange_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_ORANGE_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_ORANGE)));
//	public static final DeferredBlock<CoralWallFanBlock> LIME_CORAL_WALL_FAN = register("lime_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_LIME_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_GREEN)));
//	public static final DeferredBlock<CoralWallFanBlock> GREEN_CORAL_WALL_FAN = register("green_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_GREEN_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_GREEN)));
//	public static final DeferredBlock<CoralWallFanBlock> CYAN_CORAL_WALL_FAN = register("cyan_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_CYAN_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_CYAN)));
//	public static final DeferredBlock<CoralWallFanBlock> LIGHT_BLUE_CORAL_WALL_FAN = register("light_blue_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_LIGHT_BLUE_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_LIGHT_BLUE)));
//	public static final DeferredBlock<CoralWallFanBlock> CUBIC_CORAL_WALL_FAN = register("cubic_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_CUBIC_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_PURPLE)));
//	public static final DeferredBlock<CoralWallFanBlock> WHITE_CORAL_WALL_FAN = register("white_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_WHITE_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.TERRACOTTA_WHITE)));
//	public static final DeferredBlock<CoralWallFanBlock> BLACK_CORAL_WALL_FAN = register("black_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_BLACK_CORAL_WALL_FAN.get(), coralPlantProperties().mapColor(MapColor.COLOR_BLACK)));

	public static final DeferredBlock<VentSmokeSourceBlock> HYDROTHERMAL_VENT = register("hydrothermal_vent", () -> new VentSmokeSourceBlock(BlockBehaviour.Properties.of()));
	public static final DeferredBlock<AbyssPortalBlock> ABYSS_PORTAL = register("abyss_portal", () -> new AbyssPortalBlock(BlockBehaviour.Properties.of().noCollission().forceSolidOn().strength(-1f, 3600000f).pushReaction(PushReaction.BLOCK).noLootTable().randomTicks().noOcclusion()));

	private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> supplier) {
		return BLOCKS.register(name, supplier);
	}
}

