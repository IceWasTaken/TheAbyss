package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.block.entity.VentSmokeSourceBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {

	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Abyss.MODID);

	public static final Supplier<BlockEntityType<VentSmokeSourceBlockEntity>> HYDROTHERMAL_VENT = BLOCK_ENTITIES.register(
			"hydrothermal_vent",
			() -> BlockEntityType.Builder.of(
					VentSmokeSourceBlockEntity::new,
					BlockRegistry.HYDROTHERMAL_VENT.get()
			).build(null)
	);
}
