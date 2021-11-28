package fr.emotion.emomod.world.level.levelgen.feature.foliageplacers;

import java.util.Random;
import java.util.function.BiConsumer;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import fr.emotion.emomod.init.FoliagePlacerTypeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PineFoliagePlacer extends FoliagePlacer
{
	public static final Codec<PineFoliagePlacer> CODEC = RecordCodecBuilder.create((foliagePlacer) ->
	{
		return foliagePlacerParts(foliagePlacer).apply(foliagePlacer, PineFoliagePlacer::new);
	});

	public PineFoliagePlacer(IntProvider radius, IntProvider offset)
	{
		super(radius, offset);
	}

	@Override
	protected FoliagePlacerType<?> type()
	{
		return FoliagePlacerTypeRegistry.PINE_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, TreeConfiguration config, int p_161426_, FoliageAttachment attachment, int foliageHeight, int radius, int offset)
	{
		MutableBlockPos pos = attachment.pos().mutable();

		int height = attachment.radiusOffset();
		int heightLayer = ((int) Math.ceil(height / 4)) - 1;

		tryPlaceLeaf(reader, consumer, rand, config, pos.above());

		for (int y = 0; y <= 2; y++)
		{
			for (int i = -1; i <= 1; i++)
			{
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -2 + y, 0));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, -2 + y, i));
			}
		}

		for (int a = 0; a <= heightLayer; a++)
		{
			int heightPoint = -3;
			heightPoint -= 3 * a;

			for (int y = 0; y <= 2; y++)
			{
				for (int i = -2 - a; i <= 2 + a; i++)
				{
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, y + heightPoint, 0));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, y + heightPoint, i));
				}
			}

			for (int y = 0; y <= 3; y++)
			{
				for (int x = -1 - a; x <= 1 + a; x++)
				{
					for (int z = -1 - a; z <= 1 + a; z++)
					{
						if ((x == -1 - a || x == 1 + a) && (z == -1 - a || z == 1 + a))
						{
						} else
						{
							tryPlaceLeaf(reader, consumer, rand, config, pos.offset(x, y + heightPoint, z));
						}
					}
				}
			}
		}
	}

	@Override
	public int foliageHeight(Random rand, int p_68569_, TreeConfiguration config)
	{
		return 11;
	}

	@Override
	protected boolean shouldSkipLocation(Random p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_)
	{
		return false;
	}
}
