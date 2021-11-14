package fr.emotion.emomod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.entity.EntityOrchardSpider;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererOrchardSpider extends SpiderRenderer<EntityOrchardSpider>
{
	private static final ResourceLocation ORCHARD_SPIDER_TEXTURES = new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/orchard_spider.png");

	public RendererOrchardSpider(EntityRendererProvider.Context renderer)
	{
		super(renderer, new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "orchard_spider"), "main"));
		this.shadowRadius = 0.5F;
	}

	@Override
	protected void scale(EntityOrchardSpider entitylivingbaseIn, PoseStack poseStack, float partialTickTime)
	{
		poseStack.scale(0.5F, 0.5F, 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityOrchardSpider entity)
	{
		return ORCHARD_SPIDER_TEXTURES;
	}
}
