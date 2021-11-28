package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.LevelStem;

public class LevelStemRegistry
{
	public static final ResourceKey<LevelStem> DREAM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "dream"));
	public static final ResourceKey<LevelStem> NiGHTMARE = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, new ResourceLocation(MainRegistry.MOD_ID, "nightmare"));
}
