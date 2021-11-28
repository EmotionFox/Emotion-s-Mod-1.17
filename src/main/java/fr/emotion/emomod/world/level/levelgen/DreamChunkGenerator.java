package fr.emotion.emomod.world.level.levelgen;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import com.mojang.serialization.Codec;

import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.StructureSettings;

public class DreamChunkGenerator extends ChunkGenerator
{
	public DreamChunkGenerator(BiomeSource p_62144_, BiomeSource p_62145_, StructureSettings p_62146_, long p_62147_)
	{
		super(p_62144_, p_62145_, p_62146_, p_62147_);
	}

	@Override
	protected Codec<? extends ChunkGenerator> codec()
	{
		return null;
	}

	@Override
	public ChunkGenerator withSeed(long p_62156_)
	{
		return null;
	}

	@Override
	public void buildSurfaceAndBedrock(WorldGenRegion p_62170_, ChunkAccess p_62171_)
	{
	}

	@Override
	public CompletableFuture<ChunkAccess> fillFromNoise(Executor p_156171_, StructureFeatureManager p_156172_, ChunkAccess p_156173_)
	{
		return null;
	}

	@Override
	public int getBaseHeight(int p_156153_, int p_156154_, Types p_156155_, LevelHeightAccessor p_156156_)
	{
		return 0;
	}

	@Override
	public NoiseColumn getBaseColumn(int p_156150_, int p_156151_, LevelHeightAccessor p_156152_)
	{
		return null;
	}
}
