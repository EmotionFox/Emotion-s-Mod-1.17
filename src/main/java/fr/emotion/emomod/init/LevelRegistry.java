package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class LevelRegistry
{
	public static final ResourceKey<Level> DREAM = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "dream"));
	public static final ResourceKey<Level> NIGHTMARE = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "nightmare"));
}
