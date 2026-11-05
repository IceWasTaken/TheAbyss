package net.iskyla.abyss.registry;

import net.iskyla.abyss.Abyss;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ParticleTypeRegistry {

	public static final DeferredRegister<ParticleType<?>> PARTICLES =
			DeferredRegister.create(Registries.PARTICLE_TYPE, Abyss.MODID);

	//something's alive in the ocean
	//oh cool like a plant or an animal?
	//no, a microscopic speck
	//it lives at the bottom of the ocean and eats chemical soup which is being served hot and fresh
	//from gnarly space ingredients leftover from when it was raining rocks or whatever
	//and it can do that
	public static final Supplier<SimpleParticleType> CHEMICAL_SOUP = register("chemical_soup", true);

	private static Supplier<SimpleParticleType> register(String key, boolean overrideLimiter) {
		return PARTICLES.register(key, () -> new SimpleParticleType(overrideLimiter));
	}

//	private static Supplier<ParticleType<?>> register(String key, boolean overrideLimiter) {
//		return PARTICLES.register(key, () -> new SimpleParticleType(overrideLimiter));
//	}
}
