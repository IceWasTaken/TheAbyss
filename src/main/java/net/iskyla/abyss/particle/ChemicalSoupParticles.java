package net.iskyla.abyss.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChemicalSoupParticles extends TextureSheetParticle {

	protected ChemicalSoupParticles(
			ClientLevel level,
			double x,
			double y,
			double z,
			double xd,
			double yd,
			double zd
	) {
		super(level, x, y, z);
		this.scale(3.0F);
		this.setSize(0.25F, 0.25F);
		this.lifetime = this.random.nextInt(50) + 280;


		this.gravity = 3.0E-6F;
		this.xd = xd;
		this.yd = yd + (double)(this.random.nextFloat() / 500.0F);
		this.zd = zd;
	}

	@Override
	public void tick() {
		this.xo = this.x;
		this.yo = this.y;
		this.zo = this.z;
		if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
			this.xd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
			this.zd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
			this.yd -= (double)this.gravity;
			this.move(this.xd, this.yd, this.zd);
			if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
				this.alpha -= 0.015F;
			}
		} else {
			this.remove();
		}
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@OnlyIn(Dist.CLIENT)
	public static class Provider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet sprites;

		public Provider(SpriteSet sprites) {
			this.sprites = sprites;
		}

		public Particle createParticle(
				SimpleParticleType type,
				ClientLevel level,
				double x,
				double y,
				double z,
				double xd,
				double yd,
				double zd
		) {
			ChemicalSoupParticles particle = new ChemicalSoupParticles(
					level,
					x,
					y,
					z,
					xd,
					yd,
					zd
			);
			particle.setAlpha(0.95F);
			particle.pickSprite(this.sprites);
			return particle;
		}
	}
}
