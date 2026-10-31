package net.iskyla.abyss.item;

import net.iskyla.abyss.entity.trident.AbstractThrownTrident;
import net.iskyla.abyss.entity.trident.FancyThrownTrident;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;
import java.util.function.Consumer;

public class GenericTrident extends Item implements ProjectileItem {

	public GenericTrident(Item.Properties properties) {
		super(properties);
	}

	@Override
	public int getUseDuration(ItemStack p_43419_, LivingEntity p_345001_) {
		return 70000;
	}

	public static ItemAttributeModifiers createAttributes() {
		return ItemAttributeModifiers.builder()
				.add(
						Attributes.ATTACK_DAMAGE,
						new AttributeModifier(
								BASE_ATTACK_DAMAGE_ID,
								8.0f,
								AttributeModifier.Operation.ADD_VALUE
						),
						EquipmentSlotGroup.MAINHAND
				)
				.add(
						Attributes.ATTACK_SPEED,
						new AttributeModifier(
								BASE_ATTACK_SPEED_ID,
								-2.9f,
								AttributeModifier.Operation.ADD_VALUE
						),
						EquipmentSlotGroup.MAINHAND
				)
				.build();
	}

	public static Tool createToolProperties() {
		return new Tool(List.of(), 1.0F, 2);
	}

	public boolean canAttackBlock(BlockState p_43409_, Level p_43410_, BlockPos p_43411_, Player p_43412_) {
		return !p_43412_.isCreative();
	}

	public UseAnim getUseAnimation(ItemStack p_43417_) {
		return UseAnim.SPEAR;
	}

	public void releaseUsing(ItemStack p_43394_, Level p_43395_, LivingEntity p_43396_, int p_43397_) {
		if (p_43396_ instanceof Player player) {
			int i = this.getUseDuration(p_43394_, p_43396_) - p_43397_;
			if (i >= 10) {
				float f = EnchantmentHelper.getTridentSpinAttackStrength(p_43394_, player);
				if ((!(f > 0.0F) || player.isInWaterOrRain()) && !isTooDamagedToUse(p_43394_)) {
					Holder<SoundEvent> holder = (Holder)EnchantmentHelper.pickHighestLevel(p_43394_, EnchantmentEffectComponents.TRIDENT_SOUND).orElse(SoundEvents.TRIDENT_THROW);
					if (!p_43395_.isClientSide) {
						p_43394_.hurtAndBreak(1, player, LivingEntity.getSlotForHand(p_43396_.getUsedItemHand()));
						if (f == 0.0F) {
							FancyThrownTrident throwntrident = new FancyThrownTrident(p_43395_, player, p_43394_);
							throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
							if (player.hasInfiniteMaterials()) {
								throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
							}

							p_43395_.addFreshEntity(throwntrident);
							p_43395_.playSound((Player)null, throwntrident, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
							if (!player.hasInfiniteMaterials()) {
								player.getInventory().removeItem(p_43394_);
							}
						}
					}

					player.awardStat(Stats.ITEM_USED.get(this));
					if (f > 0.0F) {
						float f7 = player.getYRot();
						float f1 = player.getXRot();
						float f2 = -Mth.sin(f7 * ((float)Math.PI / 180F)) * Mth.cos(f1 * ((float)Math.PI / 180F));
						float f3 = -Mth.sin(f1 * ((float)Math.PI / 180F));
						float f4 = Mth.cos(f7 * ((float)Math.PI / 180F)) * Mth.cos(f1 * ((float)Math.PI / 180F));
						float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
						f2 *= f / f5;
						f3 *= f / f5;
						f4 *= f / f5;
						player.push((double)f2, (double)f3, (double)f4);
						player.startAutoSpinAttack(20, 8.0F, p_43394_);
						if (player.onGround()) {
							float f6 = 1.1999999F;
							player.move(MoverType.SELF, new Vec3((double)0.0F, (double)1.1999999F, (double)0.0F));
						}

						p_43395_.playSound((Player)null, player, (SoundEvent)holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
					}
				}
			}
		}

	}

	@Override
	public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
		AbstractThrownTrident throwntrident = new FancyThrownTrident(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
		throwntrident.pickup = AbstractArrow.Pickup.ALLOWED;
		return throwntrident;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemstack = player.getItemInHand(interactionHand);
		if (isTooDamagedToUse(itemstack)) {
			return InteractionResultHolder.fail(itemstack);
		} else if (EnchantmentHelper.getTridentSpinAttackStrength(itemstack, player) > 0.0F && !player.isInWaterOrRain()) {
			return InteractionResultHolder.fail(itemstack);
		} else {
			player.startUsingItem(interactionHand);
			return InteractionResultHolder.consume(itemstack);
		}
	}

	private static boolean isTooDamagedToUse(ItemStack p_353073_) {
		return p_353073_.getDamageValue() >= p_353073_.getMaxDamage() - 1;
	}

	public boolean hurtEnemy(ItemStack p_43390_, LivingEntity p_43391_, LivingEntity p_43392_) {
		return true;
	}

	public void postHurtEnemy(ItemStack p_345950_, LivingEntity p_345617_, LivingEntity p_345537_) {
		p_345950_.hurtAndBreak(1, p_345537_, EquipmentSlot.MAINHAND);
	}

	public int getEnchantmentValue() {
		return 1;
	}

	public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
		return ItemAbilities.DEFAULT_TRIDENT_ACTIONS.contains(itemAbility);
	}
}
