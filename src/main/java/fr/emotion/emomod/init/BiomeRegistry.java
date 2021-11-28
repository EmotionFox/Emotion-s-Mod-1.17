package fr.emotion.emomod.init;

import java.util.Objects;

import fr.emotion.emomod.MainRegistry;
import fr.emotion.emomod.data.worldgen.biome.EmotionBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.eventbus.api.IEventBus;
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

	public static void init(IEventBus eventBus)
	{
		BIOMES.register(eventBus);

		addInBiome(BIOME_ORCHARD.get(), BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.LUSH);
		addInBiome(BIOME_NIGHTMARE.get(), BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.NETHER, BiomeDictionary.Type.SWAMP);

		addInSpawnBiome(BiomeType.WARM, 10, BIOME_ORCHARD.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.WET);
		addInSpawnBiome(BiomeType.COOL, 9, BIOME_ANCIENT.get(), BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MUSHROOM);
		addInSpawnBiome(BiomeType.WARM, 12, BIOME_STONY.get(), BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.WET);
	}

	public static void addInBiome(Biome biome, Type... types)
	{
		ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
		BiomeDictionary.addTypes(key, types);
	}

	public static void addInSpawnBiome(BiomeType type, int weight, Biome biome, Type... types)
	{
		ResourceKey<Biome> key = ResourceKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));
		BiomeDictionary.addTypes(key, types);
		BiomeManager.addBiome(type, new BiomeEntry(key, weight));
	}
}
