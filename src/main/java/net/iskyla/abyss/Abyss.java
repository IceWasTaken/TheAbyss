package net.iskyla.abyss;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import net.iskyla.abyss.block.BlockRegistry;
import net.iskyla.abyss.command.AbyssDevTeleportCommand;
import net.iskyla.abyss.item.ItemRegistry;
import net.minecraft.commands.CommandSourceStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import org.slf4j.Logger;

@Mod(Abyss.MODID)
public class Abyss {

	public static final String MODID = "abyss";
	private static final Logger LOGGER = LogUtils.getLogger();

	public Abyss(IEventBus modEventBus, ModContainer modContainer) {
		//modEventBus.register(this);
		NeoForge.EVENT_BUS.addListener(Abyss::onRegisterCommands);

		BlockRegistry.BLOCKS.register(modEventBus);
		ItemRegistry.ITEMS.register(modEventBus);
		ItemRegistry.CREATIVE_MODE_TABS.register(modEventBus);
	}

	public static void onRegisterCommands(RegisterCommandsEvent e) {
		CommandDispatcher<CommandSourceStack> dispatcher = e.getDispatcher();

		AbyssDevTeleportCommand.register(dispatcher);
	}
}
