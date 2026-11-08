package net.iskyla.abyss.block.entity;

import net.iskyla.abyss.block.VentSmokeSourceBlock;
import net.iskyla.abyss.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class VentSmokeSourceBlockEntity extends BlockEntity {

	public VentSmokeSourceBlockEntity(BlockPos pos, BlockState blockState) {
		super(BlockEntityRegistry.HYDROTHERMAL_VENT.get(), pos, blockState);
	}

	public static void particleTick(Level level, BlockPos pos, BlockState state, VentSmokeSourceBlockEntity smokeSource) {
		RandomSource random = level.getRandom();

		if(random.nextFloat() < 0.11f) {
			for(int i = 0; i < random.nextInt(2) + 2; i++) {
				VentSmokeSourceBlock.makeParticles(level, pos);
			}
		}
	}

	public static void tick(Level level, BlockPos pos, BlockState state, VentSmokeSourceBlockEntity smokeSource) {
		final int range = 3;
		BlockPos topCorner = pos.above(2).offset(range, range + 1, range);
		BlockPos bottomCorner = pos.above(2).offset(-range, -range - 1, -range);

		AABB box = new AABB(bottomCorner.getCenter(), topCorner.getCenter());

		for(Entity entity : level.getEntities(null, box)) {
			if(entity instanceof LivingEntity livingEntity) {
				livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 20, 1));
				livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 20, 0));
				livingEntity.hurt(level.damageSources().magic(), 1f);
			}
		}
	}

}
