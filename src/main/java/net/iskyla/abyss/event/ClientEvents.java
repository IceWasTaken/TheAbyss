package net.iskyla.abyss.event;

import net.iskyla.abyss.Abyss;
import net.iskyla.abyss.entity.BonefishEntity;
import net.iskyla.abyss.entity.client.BonefishRenderer;
import net.iskyla.abyss.entity.trident.FancyTridentModel;
import net.iskyla.abyss.entity.trident.TridentEntityRenderer;
import net.iskyla.abyss.particle.ChemicalSoupParticles;
import net.iskyla.abyss.registry.EntityRegistry;
import net.iskyla.abyss.registry.ParticleTypeRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = Abyss.MODID)
public class ClientEvents {

	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EntityRegistry.FANCY_TRIDENT.get(), TridentEntityRenderer::new);
		event.registerEntityRenderer(EntityRegistry.BONEFISH.get(), BonefishRenderer::new);
	}

	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(FancyTridentModel.LAYER_LOCATION, FancyTridentModel::createBodyLayer);
	}

	@SubscribeEvent
	public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ParticleTypeRegistry.CHEMICAL_SOUP.get(), ChemicalSoupParticles.Provider::new);
	}

	@SubscribeEvent
	public static void registerEntityAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityRegistry.BONEFISH.get(), BonefishEntity.setAttributes());
	}
}
