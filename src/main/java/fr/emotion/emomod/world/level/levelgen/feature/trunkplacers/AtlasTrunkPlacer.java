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

public class AtlasTrunkPlacer extends ExoticTrunkPlacer
{
	public static final Codec<AtlasTrunkPlacer> CODEC = RecordCodecBuilder.create((trunkPlacer) ->
	{
		return trunkPlacerParts(trunkPlacer).apply(trunkPlacer, AtlasTrunkPlacer::new);
	});
	
	public AtlasTrunkPlacer(int p_70268_, int p_70269_, int p_70270_)
	{
		super(p_70268_, p_70269_, p_70270_);
	}

	@Override
	protected TrunkPlacerType<?> type()
	{
		return TrunkPlacerTypeRegistry.ATALS_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, int height, BlockPos pos, TreeConfiguration config)
	{
		BlockPos.MutableBlockPos mutablePos = pos.mutable();

		setDirtAt(reader, consumer, rand, mutablePos.below(), config);
		
		// Trunk
		for(int y = 2; y <= height; y++)
		{
			placeLog(reader, consumer, rand, mutablePos.offset(0, y, 0), config);
		}
		
		for (int i = -2; i <= 2; i++)
		{
			for (int y = 0; y <= 2; y++)
			{
				if ((i == -2 || i == 2) && y != 2)
				{
					//Foot And Top
					placeLog(reader, consumer, rand, mutablePos.offset(i, y, 0), config);
					placeLog(reader, consumer, rand, mutablePos.offset(0, y, i), config);
					placeLog(reader, consumer, rand, mutablePos.offset(i, 6, 0), config);
					placeLog(reader, consumer, rand, mutablePos.offset(0, 6, i), config);
				}
				else if (i != -2 && i != 2)
				{
					// Crossy Shape
					placeLogOnAxis(reader, consumer, rand, mutablePos.offset(i, 2, 0), config, Direction.Axis.X);
					placeLogOnAxis(reader, consumer, rand, mutablePos.offset(0, 2, i), config, Direction.Axis.Z);
					placeLogOnAxis(reader, consumer, rand, mutablePos.offset(i, 5, 0), config, Direction.Axis.X);
					placeLogOnAxis(reader, consumer, rand, mutablePos.offset(0, 5, i), config, Direction.Axis.Z);
				}
			}
		}
		
		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height), 0, false));
	}
}
