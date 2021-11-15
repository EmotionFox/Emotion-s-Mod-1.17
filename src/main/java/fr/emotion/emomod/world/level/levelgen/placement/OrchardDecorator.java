package fr.emotion.emomod.world.level.levelgen.placement;

import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.configurations.NoneDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

public class OrchardDecorator extends FeatureDecorator<NoneDecoratorConfiguration>
{
	public OrchardDecorator(Codec<NoneDecoratorConfiguration> codec)
	{
		super(codec);
	}

	@Override
	public Stream<BlockPos> getPositions(DecorationContext context, Random rand, NoneDecoratorConfiguration config, BlockPos pos)
	{
		// Should Always Return 0, 0, 0 Of The Chunk;
		return Stream.of(pos);
	}
}
