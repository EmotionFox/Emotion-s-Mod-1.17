package fr.emotion.emomod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.entity.EntityBeetle;
import fr.emotion.emomod.entity.model.ModelBeetle;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererBeetle extends MobRenderer<EntityBeetle, ModelBeetle<EntityBeetle>>
{
	public RendererBeetle(EntityRendererProvider.Context rendererProvider)
	{
		super(rendererProvider, new ModelBeetle<>(rendererProvider.bakeLayer(EmoModelLayers.BETTLE)), 0.125F);
	}

	@Override
	protected void scale(EntityBeetle entity, PoseStack pose, float partialTickTime)
	{
		pose.scale(0.75F, 0.75F, 0.75F);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityBeetle entity)
	{
		return entity.getResourceLocation();
	}
}
