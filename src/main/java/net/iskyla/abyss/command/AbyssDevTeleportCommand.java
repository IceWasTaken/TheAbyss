package net.iskyla.abyss.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.iskyla.abyss.Abyss;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class AbyssDevTeleportCommand {

	public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(
				Commands.literal("abyssteleport")
						.then(Commands.argument("x", IntegerArgumentType.integer())
						.then(Commands.argument("y", IntegerArgumentType.integer())
						.then(Commands.argument("z", IntegerArgumentType.integer())
						.executes((stack) -> {
							teleport(stack.getSource(),
									IntegerArgumentType.getInteger(stack, "x"),
									IntegerArgumentType.getInteger(stack, "y"),
									IntegerArgumentType.getInteger(stack, "z")
							);
							return Command.SINGLE_SUCCESS;
						}))))
		);
	}

	public static void teleport(CommandSourceStack source, int x, int y, int z) {
		ResourceKey<Level> resourcekey = ResourceKey.create(
				Registries.DIMENSION,
				ResourceLocation.fromNamespaceAndPath(Abyss.MODID, "abyss")
		);

		source.getPlayer().teleportTo(source.getServer().getLevel(resourcekey), x, y, z, 0, 0);
	}
}
