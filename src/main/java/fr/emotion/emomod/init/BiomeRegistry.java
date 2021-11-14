package fr.emotion.emomod.init;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.data.worldgen.biome.EmotionBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistry
{
	private static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, MainRegistry.MOD_ID);

	public static final RegistryObject<Biome> BIOME_ORCHARD = BIOMES.register("biome_orchard", () -> EmotionBiomes.orchardBiome());
	public static final RegistryObject<Biome> BIOME_ANCIENT = BIOMES.register("biome_ancient", () -> EmotionBiomes.acientBiome());
	public static final RegistryObject<Biome> BIOME_STONY = BIOMES.register("biome_stony", () -> EmotionBiomes.stonyBiome());
	public static final RegistryObject<Biome> BIOME_DREAM = BIOMES.register("biome_dream", () -> EmotionBiomes.dreamBiome());
	public static final RegistryObject<Biome> BIOME_NIGHTMARE = BIOMES.register("biome_nightmare", () -> EmotionBiomes.nightmareBiome());

	public static final ResourceKey<Biome> ORCHARD = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BIOME_ORCHARD.get().getRegistryName());
	public static final ResourceKey<Biome> ANCIENT = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BIOME_ORCHARD.get().getRegistryName());
	public static final ResourceKey<Biome> STONY = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BIOME_ORCHARD.get().getRegistryName());
	public static final ResourceKey<Biome> DREAM = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BIOME_ORCHARD.get().getRegistryName());
	public static final ResourceKey<Biome> NIGHTMARE = ResourceKey.create(ForgeRegistries.Keys.BIOMES, BIOME_ORCHARD.get().getRegistryName());

	public static void init()
	{
		BIOMES.register(MainRegistry.eventBus);

		addInBiome(DREAM, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.LUSH);
		addInBiome(NIGHTMARE, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.NETHER, BiomeDictionary.Type.SWAMP);

		addInSpawnBiome(BiomeType.WARM, 10, ORCHARD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET);
		addInSpawnBiome(BiomeType.COOL, 9, ANCIENT, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MUSHROOM);
		addInSpawnBiome(BiomeType.WARM, 12, STONY, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
	}

	public static void addInBiome(ResourceKey<Biome> biome, Type... types)
	{
		BiomeDictionary.addTypes(biome, types);
	}

	public static void addInSpawnBiome(BiomeType type, int weight, ResourceKey<Biome> biome, Type... types)
	{
		BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
		BiomeDictionary.addTypes(biome, types);
	}
}
