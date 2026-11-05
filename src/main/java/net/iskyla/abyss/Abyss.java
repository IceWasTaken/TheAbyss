package net.iskyla.abyss;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.iskyla.abyss.registry.*;
import net.iskyla.abyss.command.AbyssDevTeleportCommand;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;

@Mod(Abyss.MODID)
public class Abyss {

	public static final String MODID = "abyss";
	public static final Logger LOGGER = LogUtils.getLogger();

	public Abyss(IEventBus modEventBus, ModContainer modContainer) {
		//modEventBus.register(this);
		NeoForge.EVENT_BUS.addListener(Abyss::onRegisterCommands);

		StructureRegistry.STRUCTURE_TYPES.register(modEventBus);
		FeatureRegistry.FEATURES.register(modEventBus);
		EntityRegistry.ENTITIES.register(modEventBus);
		BlockRegistry.BLOCKS.register(modEventBus);
		ItemRegistry.ITEMS.register(modEventBus);
		ItemRegistry.CREATIVE_MODE_TABS.register(modEventBus);
		BlockEntityRegistry.BLOCK_ENTITIES.register(modEventBus);
		ParticleTypeRegistry.PARTICLES.register(modEventBus);
	}

	public static void onRegisterCommands(RegisterCommandsEvent e) {
		CommandDispatcher<CommandSourceStack> dispatcher = e.getDispatcher();

		AbyssDevTeleportCommand.register(dispatcher);
	}

	public static ResourceLocation resourceLocation(String path) {
		return ResourceLocation.fromNamespaceAndPath(Abyss.MODID, path);
	}
}
