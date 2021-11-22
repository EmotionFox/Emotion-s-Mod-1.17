package fr.emotion.emomod.world.level.levelgen.feature.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.TrunkPlacerTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class OrchardTrunkPlacer extends ExoticTrunkPlacer
{
	public static final Codec<OrchardTrunkPlacer> CODEC = RecordCodecBuilder.create((trunkPlacer) ->
	{
		return trunkPlacerParts(trunkPlacer).apply(trunkPlacer, OrchardTrunkPlacer::new);
	});

	public OrchardTrunkPlacer(int height, int heightRandA, int heightRandB)
	{
		super(height, heightRandA, heightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type()
	{
		return TrunkPlacerTypeRegistry.ORCHARD_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, int height, BlockPos pos, TreeConfiguration config)
	{
		BlockPos.MutableBlockPos mutablePos = pos.mutable();

		setDirtAt(reader, consumer, rand, mutablePos.below(), config);

		for (int i = 0; i <= height; i++)
		{
			// Trunk
			placeLog(reader, consumer, rand, mutablePos.above(i), config);
		}

		// Cross Trunk
		for (int g = -2; g <= 2; g++)
		{
			placeLogOnAxis(reader, consumer, rand, mutablePos.offset(g, height - 2, 0), config, Direction.Axis.X);
			placeLogOnAxis(reader, consumer, rand, mutablePos.offset(0, height - 2, g), config, Direction.Axis.Z);
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));
	}
}
