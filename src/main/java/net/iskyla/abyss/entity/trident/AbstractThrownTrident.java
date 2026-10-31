package net.iskyla.abyss.entity.trident;

import net.iskyla.abyss.registry.EntityRegistry;
import net.iskyla.abyss.registry.ItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

///@see net.minecraft.world.entity.projectile.ThrownTrident
public abstract class AbstractThrownTrident extends AbstractArrow {

	private static final EntityDataAccessor<Byte> LOYALTY = SynchedEntityData.defineId(AbstractThrownTrident.class, EntityDataSerializers.BYTE);
	private static final EntityDataAccessor<Boolean> ENCHANTMENT_GLINT = SynchedEntityData.defineId(AbstractThrownTrident.class, EntityDataSerializers.BOOLEAN);

	private boolean dealtDamage = false;
	public int clientSideReturnTridentTickCount;

	public AbstractThrownTrident(EntityType<? extends AbstractThrownTrident> entityType, Level level) {
		super(entityType, level);
	}

	public AbstractThrownTrident(EntityType<? extends AbstractThrownTrident> entityType, Level p_37569_, LivingEntity p_37570_, ItemStack p_37571_) {
		super(entityType, p_37570_, p_37569_, p_37571_, null);
	}

	public AbstractThrownTrident(EntityType<? extends AbstractThrownTrident> entityType, Level level, double x, double y, double z, ItemStack pickupItemStack) {
		super(entityType, x, y, z, level, pickupItemStack, pickupItemStack);
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(LOYALTY, (byte) 0);
		builder.define(ENCHANTMENT_GLINT, false);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compoundTag) {
		super.readAdditionalSaveData(compoundTag);
		this.dealtDamage = compoundTag.getBoolean("DealtDamage");

		Level level = this.level();

		byte loyalty;
		if(level instanceof ServerLevel serverLevel) {
			loyalty = (byte) Mth.clamp(EnchantmentHelper.getTridentReturnToOwnerAcceleration(serverLevel, this.getPickupItemStackOrigin(), this), 0, 127);
		} else {
			loyalty = 0;
		}

		this.entityData.set(LOYALTY, loyalty);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		tag.putBoolean("DealtDamage", this.dealtDamage);
	}

	public boolean isFoil() {
		return this.entityData.get(ENCHANTMENT_GLINT);
	}


	@Override
	public ItemStack getWeaponItem() {
		return this.getPickupItemStackOrigin();
	}

	@Override
	protected boolean tryPickup(Player player) {
		return super.tryPickup(player) || this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem());
	}

	@Override
	protected void onHitEntity(EntityHitResult result) {
		float damageAmount = 8.0f;
		Entity hit = result.getEntity();
		Entity owner = this.getOwner();

		DamageSource damageSource = this.damageSources().trident(this, owner == null ? this : owner);

		Level level = this.level();
		if(level instanceof ServerLevel serverLevel) {
			damageAmount = EnchantmentHelper.modifyDamage(serverLevel, this.getWeaponItem(), hit, damageSource, damageAmount);
		}

		this.dealtDamage = true;
		if(hit.hurt(damageSource, damageAmount)) {
			if(hit.getType() == EntityType.ENDERMAN) {
				return;
			}

			//not sure why mojang does this but whatever
			level = this.level();
			if(level instanceof ServerLevel serverLevel) {
				EnchantmentHelper.doPostAttackEffectsWithItemSource(serverLevel, hit, damageSource, this.getWeaponItem());
			}

			if(hit instanceof LivingEntity) {
				LivingEntity livingEntity = (LivingEntity) hit;
				this.doKnockback(livingEntity, damageSource);
				this.doPostHurtEffects(livingEntity);
			}

			this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01, -0.1, -0.01));
			this.playSound(SoundEvents.TRIDENT_HIT, 1.0f, 1.0f);
		}
	}


	@Override
	protected SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.TRIDENT_HIT_GROUND;
	}

	@Override
	protected float getWaterInertia() {
		return 1.1f;
	}

	@Override
	public boolean shouldRender(double x, double y, double z) {
		return true;
	}
}
