package fr.emotion.emomod.world.level.levelgen.feature.trunkplacers;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.TrunkPlacerTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer.FoliageAttachment;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

public class PineTrunkPlacer extends ExoticTrunkPlacer
{
	public static final Codec<PineTrunkPlacer> CODEC = RecordCodecBuilder.create((trunkPlacer) ->
	{
		return trunkPlacerParts(trunkPlacer).apply(trunkPlacer, PineTrunkPlacer::new);
	});

	public PineTrunkPlacer(int height, int heightRandA, int heightRandB)
	{
		super(height, heightRandA, heightRandB);
	}

	@Override
	protected TrunkPlacerType<?> type()
	{
		return TrunkPlacerTypeRegistry.PINE_TRUNK_PLACER.get();
	}

	@Override
	public List<FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, int height, BlockPos pos, TreeConfiguration config)
	{
		float heightPourcentage = ((pos.getY() - 65) * 100) / (256 - 65);
		int heightLayer = ((int) Math.ceil(height / 4)) - 1;

		if (heightPourcentage <= 10.0F)
		{
			height += 6 + rand.nextInt(this.heightRandA + 1);
		} else if (heightPourcentage <= 20.0F)
		{
			height += 3 + rand.nextInt(this.heightRandB + 1);
		} else if (heightPourcentage <= 30.0F)
		{
			height += 3;
		}

		for (int y = 0; y < height; y++)
		{
			placeLog(reader, consumer, rand, pos.offset(0, y, 0), config);
		}

		for (int a = 0; a <= heightLayer; a++)
		{
			int heightPoint = height - 3;
			heightPoint -= 3 * a;

			if (a > 0)
			{
				for (int i = -a; i <= a; i++)
				{
					placeLogOnAxis(reader, consumer, rand, pos.offset(i, heightPoint, 0), config, net.minecraft.core.Direction.Axis.X);
					placeLogOnAxis(reader, consumer, rand, pos.offset(0, heightPoint, i), config, net.minecraft.core.Direction.Axis.Z);
				}
			}
		}

		return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pos.above(height), height, false));
	}
}
