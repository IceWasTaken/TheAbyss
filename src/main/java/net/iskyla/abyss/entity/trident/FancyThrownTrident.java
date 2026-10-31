package net.iskyla.abyss.entity.trident;

import net.iskyla.abyss.registry.EntityRegistry;
import net.iskyla.abyss.registry.ItemRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FancyThrownTrident extends AbstractThrownTrident {

	public FancyThrownTrident(Level level, double x, double y, double z, ItemStack pickupItemStack) {
		super(EntityRegistry.FANCY_TRIDENT.get(), level, x, y, z, pickupItemStack);
	}

	public FancyThrownTrident(Level level, LivingEntity livingEntity, ItemStack p_37571_) {
		super(EntityRegistry.FANCY_TRIDENT.get(), level, livingEntity, p_37571_);
	}

	public FancyThrownTrident(EntityType<? extends AbstractThrownTrident> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	protected ItemStack getDefaultPickupItem() {
		return ItemRegistry.FANCY_TRIDENT.get().getDefaultInstance();
	}
}
