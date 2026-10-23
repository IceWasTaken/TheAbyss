package net.iskyla.abyss.datagen;

import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class DropTableDatagen  extends BlockLootSubProvider {
    public DropTableDatagen(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.AQUASLATE.get());
        dropSelf(BlockRegistry.PRISMATIC_ROCK.get());
        
        add(BlockRegistry.AQUASLATE_DIAMOND.get(),
                block -> createOreDrop(block, Items.DIAMOND));
        add(BlockRegistry.AQUASLATE_IRON.get(),
                block -> createOreDrop(block, Items.RAW_IRON));
        add(BlockRegistry.AQUASLATE_GOLD.get(),
                block -> createOreDrop(block, Items.RAW_GOLD));
        
        add(BlockRegistry.AQUASLATE_LAPIS.get(), this::createLapisOreDrops);
        add(BlockRegistry.AQUASLATE_REDSTONE.get(), this::createRedstoneOreDrops);

        dropSelf(BlockRegistry.YELLOW_KELP.get());
        dropOther(BlockRegistry.YELLOW_KELP_PLANT.get(), BlockRegistry.YELLOW_KELP.get());
        
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
