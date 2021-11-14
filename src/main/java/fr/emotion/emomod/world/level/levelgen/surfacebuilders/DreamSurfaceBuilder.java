package fr.emotion.emomod.world.level.levelgen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class DreamSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration>
{
	public DreamSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public void apply(Random rand, ChunkAccess chunck, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, int i, long seed, SurfaceBuilderBaseConfiguration config)
	{
		if (startHeight >= 55)
		{
			SurfaceBuilder.DEFAULT.apply(rand, chunck, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed, SurfaceBuilder.CONFIG_GRASS);
		} else
		{
			SurfaceBuilder.DEFAULT.apply(rand, chunck, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, i, seed,
					new SurfaceBuilderBaseConfiguration(Blocks.GREEN_WOOL.defaultBlockState(), Blocks.STONE.defaultBlockState(), Blocks.STONE.defaultBlockState()));
		}

	}
}
