package fr.emotion.emomod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.emotion.emomod.client.model.geom.EmoModelLayers;
import fr.emotion.emomod.entity.EntityMouse;
import fr.emotion.emomod.entity.model.ModelMouse;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererMouse extends MobRenderer<EntityMouse, ModelMouse<EntityMouse>>
{
	public RendererMouse(EntityRendererProvider.Context rendererProvider)
	{
		super(rendererProvider, new ModelMouse<>(rendererProvider.bakeLayer(EmoModelLayers.MOUSE)), 0.1F);
	}

	@Override
	protected void scale(EntityMouse entitylivingbaseIn, PoseStack pose, float partialTickTime)
	{
		pose.scale(0.75F, 0.75F, 0.75F);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMouse entity)
	{
		return entity.getResourceLocation();
	}
}
