package fr.emotion.emomod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererBasic<T extends LivingEntity, M extends EntityModel<T>> extends LivingEntityRenderer<T, M>
{
	private ResourceLocation texture;
	private Vec3 scaleDim;

	public RendererBasic(EntityRendererProvider.Context rendererProvider, M entityModelIn, float shadowSizeIn, ResourceLocation texture)
	{
		this(rendererProvider, entityModelIn, shadowSizeIn, texture, new Vec3(1.0D, 1.0D, 1.0D));
		this.texture = texture;
	}

	public RendererBasic(EntityRendererProvider.Context rendererProvider, M entityModelIn, float shadowSizeIn, ResourceLocation texture, Vec3 scaleDim)
	{
		super(rendererProvider, entityModelIn, shadowSizeIn);
		this.texture = texture;
		this.scaleDim = scaleDim;
	}

	@Override
	protected void scale(T entity, PoseStack pose, float partialTickTime)
	{
		pose.scale((float) scaleDim.x, (float) scaleDim.y, (float) scaleDim.z);
	}

	@Override
	public ResourceLocation getTextureLocation(T entity)
	{
		return texture;
	}
}
