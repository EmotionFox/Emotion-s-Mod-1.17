package fr.emotion.emomod.entity.renderer;

import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.entity.EntityButterfly;
import fr.emotion.emomod.entity.model.ModelButterfly;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererButterfly extends MobRenderer<EntityButterfly, ModelButterfly<EntityButterfly>>
{
	public RendererButterfly(EntityRendererProvider.Context rendererProvider)
	{
		super(rendererProvider, new ModelButterfly<>(rendererProvider.bakeLayer(EmoModelLayers.BUTTERFLY)), 0.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityButterfly entity)
	{
		return entity.getResourceLocation();
	}
}
