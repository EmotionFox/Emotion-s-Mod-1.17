package fr.emotion.emomod.client.renderer.entity;

import java.util.Map;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.entity.EntityBoat;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RendererBoat extends BoatRenderer
{
	private final Map<EntityBoat.EmoType, Pair<ResourceLocation, BoatModel>> boatResources;

	public RendererBoat(EntityRendererProvider.Context renderer)
	{
		super(renderer);
		this.shadowRadius = 0.8F;
		this.boatResources = Stream.of(EntityBoat.EmoType.values()).collect(ImmutableMap.toImmutableMap((key) ->
		{
			return key;
		}, (value) ->
		{
			return Pair.of(new ResourceLocation(MainRegistry.MOD_ID, "textures/entity/boat/" + value.getName() + ".png"),
					new BoatModel(renderer.bakeLayer(new ModelLayerLocation(new ResourceLocation(MainRegistry.MOD_ID, "boat/" + value.getName()), "main"))));
		}));
	}

	@Override
	public Pair<ResourceLocation, BoatModel> getModelWithLocation(Boat boat)
	{
		return this.boatResources.get(((EntityBoat) boat).getEmoType());
	}
}
