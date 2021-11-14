package fr.emotion.emomod.world.level.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.BiomeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;

public class ParcelBiomeSource extends BiomeSource
{
	public static final Codec<ParcelBiomeSource> CODEC = RecordCodecBuilder.create((p_48644_) ->
	{
		return p_48644_.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((p_151890_) ->
		{
			return p_151890_.biomes;
		}), Codec.LONG.fieldOf("seed").stable().forGetter((p_151888_) ->
		{
			return p_151888_.seed;
		})).apply(p_48644_, p_48644_.stable(ParcelBiomeSource::new));
	});

	private final Registry<Biome> biomes;
	private final long seed;
	private final static Biome ancient = BiomeRegistry.BIOME_ANCIENT.get();
	private final static Biome orchard = BiomeRegistry.BIOME_ORCHARD.get();
	private final static Biome stony = BiomeRegistry.BIOME_STONY.get();
	private final static Biome void_biome = net.minecraft.data.worldgen.biome.Biomes.THE_VOID;

	public ParcelBiomeSource(Registry<Biome> registry, long seed)
	{
		super(ImmutableList.of(ancient, orchard, stony, void_biome));
		this.seed = seed;
		this.biomes = registry;
		WorldgenRandom worldgenrandom = new WorldgenRandom(seed);
		worldgenrandom.consumeCount(17292);
	}

	protected Codec<? extends BiomeSource> codec()
	{
		return CODEC;
	}

	@Override
	public BiomeSource withSeed(long seed)
	{
		return new ParcelBiomeSource(this.biomes, seed);
	}

	public Biome getNoiseBiome(int x, int p_48651_, int y)
	{
//		int x = p_48650_ >> 2;
//		int y = p_48652_ >> 2;

		if (x >= 0 && y >= 0)
			return ancient;
		else if (x < 0 && y < 0)
			return orchard;
		else if (x >= 0 && y < 0)
			return stony;
		else
			return void_biome;
	}

	public boolean stable(long seed)
	{
		return this.seed == seed;
	}
}
