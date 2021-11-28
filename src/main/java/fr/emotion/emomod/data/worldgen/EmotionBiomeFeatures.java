package fr.emotion.emomod.data.worldgen;

import fr.emotion.emomod.init.FeatureRegistry;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EmotionBiomeFeatures
{
	public static void addOrchardVegetation(BiomeGenerationSettings.Builder generationSettings)
	{
		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.CF_EMO_FLOWER.get());
		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.CF_ORCHARD_BERRY_BUSH.get());
	}
}
