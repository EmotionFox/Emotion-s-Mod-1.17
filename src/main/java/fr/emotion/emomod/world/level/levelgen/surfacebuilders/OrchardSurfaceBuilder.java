package fr.emotion.emomod.world.level.levelgen.surfacebuilders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

public class OrchardSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration>
{
	public OrchardSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public void apply(Random p_164213_, ChunkAccess p_164214_, Biome p_164215_, int p_164216_, int p_164217_, int p_164218_, double p_164219_, BlockState p_164220_, BlockState p_164221_, int p_164222_, int p_164223_, long p_164224_,
			SurfaceBuilderBaseConfiguration p_164225_)
	{
	}
}
