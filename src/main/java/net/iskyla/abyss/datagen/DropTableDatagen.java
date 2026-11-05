package net.iskyla.abyss.datagen;

import net.iskyla.abyss.registry.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Set;
import java.util.function.Function;

public class DropTableDatagen extends BlockLootSubProvider {
    public DropTableDatagen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.AQUASLATE.get());
        dropSelf(BlockRegistry.AQUASLATE_SLAB.get());
        dropSelf(BlockRegistry.AQUASLATE_STAIRS.get());
        dropSelf(BlockRegistry.AQUASLATE_WALL.get());

		dropSelf(BlockRegistry.PRISMATIC_ROCK.get());
		dropSelf(BlockRegistry.PRISMATIC_ROCK_SLAB.get());
		dropSelf(BlockRegistry.PRISMATIC_ROCK_STAIRS.get());
		dropSelf(BlockRegistry.PRISMATIC_ROCK_WALL.get());

        dropSelf(BlockRegistry.PRISMATIC_ROCK.get());
        
        add(BlockRegistry.AQUASLATE_DIAMOND.get(), block -> createOreDrop(block, Items.DIAMOND));
        add(BlockRegistry.AQUASLATE_IRON.get(), block -> createOreDrop(block, Items.RAW_IRON));
        add(BlockRegistry.AQUASLATE_GOLD.get(), block -> createOreDrop(block, Items.RAW_GOLD));
        
        add(BlockRegistry.AQUASLATE_LAPIS.get(), this::createLapisOreDrops);
        add(BlockRegistry.AQUASLATE_REDSTONE.get(), this::createRedstoneOreDrops);


        dropSelf(BlockRegistry.YELLOW_KELP.get());
        dropOther(BlockRegistry.YELLOW_KELP_PLANT.get(), BlockRegistry.YELLOW_KELP.get());

        dropWhenSilkTouch(BlockRegistry.DEAD_ORANGE_CORAL_BLOCK);
        dropWhenSilkTouch(BlockRegistry.DEAD_LIME_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_GREEN_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_CYAN_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_CUBIC_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_WHITE_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.DEAD_BLACK_CORAL_BLOCK);

		dropWhenSilkTouch(BlockRegistry.DEAD_ORANGE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIME_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_GREEN_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_CYAN_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_CUBIC_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_WHITE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.DEAD_BLACK_CORAL_PLANT);

		dropWhenSilkTouch(BlockRegistry.DEAD_ORANGE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIME_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_GREEN_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_CYAN_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_CUBIC_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_WHITE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_BLACK_CORAL_FAN);

		dropWhenSilkTouch(BlockRegistry.DEAD_ORANGE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIME_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_GREEN_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_CYAN_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_LIGHT_BLUE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_CUBIC_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_WHITE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.DEAD_BLACK_CORAL_WALL_FAN);

		dropWhenSilkTouch(BlockRegistry.GINGER_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.SPOTTED_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.GREEN_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.CYAN_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.SQUID_CORAL_BLOCK);
        dropWhenSilkTouch(BlockRegistry.CUBIC_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.GHOST_CORAL_BLOCK);
		dropWhenSilkTouch(BlockRegistry.WIRE_CORAL_BLOCK);

		dropWhenSilkTouch(BlockRegistry.ORANGE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.LIME_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.GREEN_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.CYAN_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.LIGHT_BLUE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.CUBIC_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.WHITE_CORAL_PLANT);
		dropWhenSilkTouch(BlockRegistry.BLACK_CORAL_PLANT);

		dropWhenSilkTouch(BlockRegistry.ORANGE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.LIME_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.GREEN_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.CYAN_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.LIGHT_BLUE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.CUBIC_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.WHITE_CORAL_FAN);
		dropWhenSilkTouch(BlockRegistry.BLACK_CORAL_FAN);

		dropWhenSilkTouch(BlockRegistry.ORANGE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.LIME_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.GREEN_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.CYAN_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.LIGHT_BLUE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.CUBIC_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.WHITE_CORAL_WALL_FAN);
		dropWhenSilkTouch(BlockRegistry.BLACK_CORAL_WALL_FAN);

		add(BlockRegistry.HYDROTHERMAL_VENT, (b) -> noDrop());

    }

    private void dropWhenSilkTouch(DeferredBlock<?> block) {
        dropWhenSilkTouch(block.get());
    }

	//can't be bothered to add .get() to every single block
	//-iskyla
	private void add(DeferredBlock<?> block, Function<Block, LootTable.Builder> drop) {
		add(block.get(), drop);
	}

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
