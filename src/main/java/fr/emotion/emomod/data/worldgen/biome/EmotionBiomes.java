package fr.emotion.emomod.data.worldgen.biome;

import fr.emotion.emomod.data.worldgen.EmotionBiomeFeatures;
import fr.emotion.emomod.init.EntityTypeRegistry;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.SurfaceBuilders;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class EmotionBiomes
{
	private static int calculateSkyColor(float color)
	{
		float f = color / 3.0F;
		f = Mth.clamp(f, -1.0F, 1.0F);
		return Mth.hsvToRgb(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
	}

	// This shit is insane, take us hours with EmotionBest
	// (just bcs float doesn't like int)..
	// Still worth do.
	private static int getColorByHeight(float[] color1, float[] color2, float percent, float dif, float min)
	{
		int r = (int) color1[0];
		int g = (int) color1[1];
		int b = (int) color1[2];

		if (color1[0] < color2[0])
			r = Math.round(color1[0] + ((color2[0] - color1[0]) / dif * (percent - min)));
		else if (color1[0] > color2[0])
			r = Math.round(color1[0] - ((color1[0] - color2[0]) / dif * (percent - min)));

		if (color1[1] < color2[1])
			g = Math.round(color1[1] + ((color2[1] - color1[1]) / dif * (percent - min)));
		else if (color1[1] > color2[1])
			g = Math.round(color1[1] - ((color1[1] - color2[1]) / dif * (percent - min)));

		if (color1[2] < color2[2])
			b = Math.round(color1[2] + ((color2[2] - color1[2]) / dif * (percent - min)));
		else if (color1[2] > color2[2])
			b = Math.round(color1[2] - ((color1[2] - color2[2]) / dif * (percent - min)));

		r = r < 0 ? 0 : r > 255 ? 255 : r;
		g = g < 0 ? 0 : g > 255 ? 255 : g;
		b = b < 0 ? 0 : b > 255 ? 255 : b;

		return r * 65536 + g * 256 + b;
	}

	public static Biome orchardBiome(float depth, float scale, MobSpawnSettings.Builder spawnSettings)
	{
		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRASS);

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
		BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
		BiomeDefaultFeatures.addDefaultLakes(generationSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
		BiomeDefaultFeatures.addDefaultOres(generationSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
		BiomeDefaultFeatures.addDefaultSprings(generationSettings);
		BiomeDefaultFeatures.addDefaultGrass(generationSettings);
		BiomeDefaultFeatures.addOtherBirchTrees(generationSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
		EmotionBiomeFeatures.addEmotionVegetation(generationSettings);

//		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.ORCHARD_TREE);

		return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).depth(depth).scale(scale).temperature(0.8F).downfall(0.7f)
				.specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x2f59d3).waterFogColor(0x2f59d3).skyColor(calculateSkyColor(0xFFbcf2ff)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	public static Biome acientBiome(float depth, float scale, MobSpawnSettings.Builder spawnSettings)
	{
		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRAVELLY_MOUNTAIN);

		BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
		BiomeDefaultFeatures.addDefaultLakes(generationSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
		BiomeDefaultFeatures.addDefaultOres(generationSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
		BiomeDefaultFeatures.addDefaultSprings(generationSettings);
		BiomeDefaultFeatures.addForestGrass(generationSettings);
		EmotionBiomeFeatures.addEmotionVegetation(generationSettings);

//		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.ANCIENT_TREE);

		return (new Biome.BiomeBuilder())
				.precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.FOREST).depth(depth).scale(scale).temperature(0.8F).downfall(0.0f).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x4456c4)
						.waterFogColor(0x4456c4).fogColor(0x7244c4).grassColorOverride(0x6e6048).foliageColorOverride(0x6e6048).skyColor(calculateSkyColor(0x7244c4)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	public static Biome stonyBiome(float depth, float scale, MobSpawnSettings.Builder spawnSettings)
	{
		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRAVELLY_MOUNTAIN);

		BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
		BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
		BiomeDefaultFeatures.addDefaultLakes(generationSettings);
		BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
		BiomeDefaultFeatures.addDefaultOres(generationSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
		BiomeDefaultFeatures.addDefaultSprings(generationSettings);
		BiomeDefaultFeatures.addJungleGrass(generationSettings);
		BiomeDefaultFeatures.addOtherBirchTrees(generationSettings);
		BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
		EmotionBiomeFeatures.addEmotionVegetation(generationSettings);

//		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.PINE_TREE);
//		generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, FeatureRegistry.LAYING_TREE);

		// SHOULD USE COLOR BY HEIGHT

		return (new Biome.BiomeBuilder())
				.precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.FOREST).depth(depth).scale(scale).temperature(0.8F).downfall(0.3f).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x48696e)
						.waterFogColor(0x48696e).grassColorOverride(0x4496c4).foliageColorOverride(0x4496c4).skyColor(calculateSkyColor(0x7244c4)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	public static Biome dreamBiome(float depth, float scale, MobSpawnSettings.Builder spawnSettings)
	{
//		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilderRegistry.DREAM.get());
		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRAVELLY_MOUNTAIN);

		BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
		BiomeDefaultFeatures.addDefaultOres(generationSettings);
		BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
		BiomeDefaultFeatures.addDefaultSprings(generationSettings);
		BiomeDefaultFeatures.addJungleGrass(generationSettings);
		BiomeDefaultFeatures.addOtherBirchTrees(generationSettings);
		BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
		EmotionBiomeFeatures.addEmotionVegetation(generationSettings);

		return (new Biome.BiomeBuilder())
				.precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.EXTREME_HILLS).depth(depth).scale(scale).temperature(1.0F).downfall(0.0f).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x38ccc4)
						.waterFogColor(0x38ccc4).grassColorOverride(0x38cc7a).foliageColorOverride(0x38cc7a).skyColor(calculateSkyColor(0x7244c4)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	public static Biome nightmareBiome(float depth, float scale, MobSpawnSettings.Builder spawnSettings)
	{
		BiomeGenerationSettings.Builder generationSettings = (new BiomeGenerationSettings.Builder()).surfaceBuilder(SurfaceBuilders.GRASS);

		BiomeDefaultFeatures.addDefaultGrass(generationSettings);

		return (new Biome.BiomeBuilder())
				.precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).depth(depth).scale(scale).temperature(1.0F).downfall(0.0f).specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x191919)
						.waterFogColor(0x191919).grassColorOverride(0x321d02).foliageColorOverride(0x173202).skyColor(calculateSkyColor(0x7244c4)).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
				.mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
	}

	private static MobSpawnSettings.Builder defaultSpawns()
	{
		MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
		BiomeDefaultFeatures.farmAnimals(mobspawnsettings$builder);
		BiomeDefaultFeatures.commonSpawns(mobspawnsettings$builder);
		return mobspawnsettings$builder;
	}

	public static Biome orchardBiome()
	{
		MobSpawnSettings.Builder spawnSettings = defaultSpawns();
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.BUTTERFLY.get(), 50, 1, 3));
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.MOUSE.get(), 25, 2, 4));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.ORCHARD_SPIDER.get(), 4, 1, 2));
		return orchardBiome(0.0f, 0.25f, spawnSettings);
	}

	public static Biome acientBiome()
	{
		MobSpawnSettings.Builder spawnSettings = defaultSpawns();
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.BEETLE.get(), 50, 1, 3));
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.LIGHTNING_BUG.get(), 20, 1, 3));
		return acientBiome(0.8f, 0.4f, spawnSettings);
	}

	public static Biome stonyBiome()
	{
		MobSpawnSettings.Builder spawnSettings = defaultSpawns();
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.MOUSE.get(), 25, 2, 4));
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.BEETLE.get(), 25, 3, 6));
		spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.BOAR.get(), 12, 2, 3));
		return stonyBiome(1.0f, 0.5f, spawnSettings);
	}

	public static Biome dreamBiome()
	{
		MobSpawnSettings.Builder spawnSettings = defaultSpawns();
		spawnSettings.addSpawn(MobCategory.AMBIENT, new MobSpawnSettings.SpawnerData(EntityTypeRegistry.MOUSE.get(), 50, 1, 3));
		return dreamBiome(5.0f, 1.0f, spawnSettings);
	}

	public static Biome nightmareBiome()
	{
		MobSpawnSettings.Builder spawnSettings = defaultSpawns();
		return nightmareBiome(5.0f, 1.0f, spawnSettings);
	}
}
