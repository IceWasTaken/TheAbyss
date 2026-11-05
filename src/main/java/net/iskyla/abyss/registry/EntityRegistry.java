package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.AnglerfishEntity;
import net.iskyla.abyss.entity.BonefishEntity;
import net.iskyla.abyss.entity.trident.AbstractThrownTrident;
import net.iskyla.abyss.entity.trident.FancyThrownTrident;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class EntityRegistry {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, Abyss.MODID);


	public static final Supplier<EntityType<FancyThrownTrident>> FANCY_TRIDENT =
			register(
					"fancy_trident",
					FancyThrownTrident::new,
					MobCategory.MISC,
					(builder) -> builder
							.sized(0.5F, 0.5F)
							.eyeHeight(0.13F)
							.clientTrackingRange(4)
							.updateInterval(20)
			);

	public static final Supplier<EntityType<BonefishEntity>> BONEFISH =
			register(
					"bonefish",
					BonefishEntity::new,
					MobCategory.CREATURE,
					(b) -> b.sized(0.5f, 0.5f)
			);

	public static final Supplier<EntityType<AnglerfishEntity>> ANGLERFISH =
			register(
					"anglerfish",
					AnglerfishEntity::new,
					MobCategory.CREATURE,
					(b) -> b.sized(2f, 2f)
			);


	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String name, EntityType.EntityFactory<T> factory, MobCategory category, UnaryOperator<EntityType.Builder<T>> builder) {
		return ENTITIES.register(
				name,
				(key) ->
						((EntityType.Builder) builder.apply(
								EntityType.Builder.of(factory, category)
						)
						).build(ResourceKey.create(Registries.ENTITY_TYPE, key).registry().toString())
		);
	}
}
