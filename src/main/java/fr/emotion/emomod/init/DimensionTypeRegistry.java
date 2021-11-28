package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;

public class DimensionTypeRegistry
{
	public static final ResourceKey<DimensionType> DREAM = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "dream"));
	public static final ResourceKey<DimensionType> NIGHTMARE = ResourceKey.create(Registry.DIMENSION_TYPE_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "nightmare"));
}
