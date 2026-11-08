package net.iskyla.abyss.item;

import com.google.common.base.Stopwatch;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.ints.IntList;
import net.iskyla.abyss.worldgen.structure.StructureDatagen;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.Fireworks;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ChasmLocator extends Item {

	public ChasmLocator(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		if(level.isClientSide) {
			return InteractionResultHolder.pass(player.getItemInHand(hand));
		}
		ServerLevel serverLevel = (ServerLevel) level;

		Registry<Structure> registry = serverLevel.registryAccess().registryOrThrow(Registries.STRUCTURE);

		Stopwatch stopwatch = Stopwatch.createStarted(Util.TICKER);
		Pair<BlockPos, Holder<Structure>> location =
				serverLevel.getChunkSource().getGenerator().findNearestMapStructure(
						serverLevel,
						HolderSet.direct(registry.getHolderOrThrow(StructureDatagen.ABYSS_PORTAL_OVERWORLD)),
						new BlockPos(0, 0, 0),
						100,
						false
				);
		stopwatch.stop();
		if(location == null) {
			return InteractionResultHolder.pass(player.getItemInHand(hand));
		} else {
			BlockPos structureLocation = location.getFirst();
			BlockPos playerLoc = player.blockPosition();
			Vec3 direction = playerLoc.getCenter().vectorTo(structureLocation.getCenter()).normalize();

			double xScale = direction.x * 30;
			double zScale = direction.z * 30;

			ItemStack itemStack = new ItemStack(Items.FIREWORK_ROCKET);
			itemStack.set(
					DataComponents.FIREWORKS,
					new Fireworks(
							2,
							List.of(
									new FireworkExplosion(
											FireworkExplosion.Shape.SMALL_BALL,
											IntList.of(color(255, 140, 170, 194)),
											IntList.of(color(255, 187, 195, 201)),
											true,
											false
									)
							)
					)
			);

			FireworkRocketEntity fireworkRocketEntity = new FireworkRocketEntity(
					level, player, playerLoc.getX() + xScale, playerLoc.getY(), playerLoc.getZ() + zScale, itemStack
			);

			level.addFreshEntity(fireworkRocketEntity);


			return InteractionResultHolder.consume(player.getItemInHand(hand));
		}
	}


	private int color(int a, int r, int g, int b) {
		return (a << 24) | (r << 16) | (g << 8) | (b << 0);
	}
}