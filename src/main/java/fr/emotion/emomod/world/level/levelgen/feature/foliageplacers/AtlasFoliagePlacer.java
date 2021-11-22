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

public class AtlasFoliagePlacer extends FoliagePlacer
{
	public static final Codec<AtlasFoliagePlacer> CODEC = RecordCodecBuilder.create((foliagePlacer) ->
	{
		return foliagePlacerParts(foliagePlacer).apply(foliagePlacer, AtlasFoliagePlacer::new);
	});

	public AtlasFoliagePlacer(IntProvider radius, IntProvider offset)
	{
		super(radius, offset);
	}

	@Override
	protected FoliagePlacerType<?> type()
	{
		return FoliagePlacerTypeRegistry.ATLAS_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, TreeConfiguration config, int p_161426_, FoliageAttachment attachment, int foliageHeight, int radius, int offset)
	{
		MutableBlockPos pos = attachment.pos().mutable();

		for (int i = -3; i <= 3; i++)
		{
			for (int g = -1; g <= 1; g++)
			{
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -3, g));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(g, -3, i));

				if (i != -3 && i != 3)
				{
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -3, i));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(+i, -3, -i));
				}

				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -2, 0));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -1, 0));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, -2, i));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, -2, i));
			}
		}

		for (int i = -2; i <= 2; i++)
		{
			for (int y = 0; y <= 2; y++)
			{
				for (int g = -1; g <= 1; g++)
				{
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -2 + y, g));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(g, -2 + y, i));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(g, +1, g));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(-g, +1, +g));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, +1, g));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(g, +1, 0));
				}
			}
		}
	}

	@Override
	public int foliageHeight(Random p_68568_, int p_68569_, TreeConfiguration p_68570_)
	{
		return 5;
	}

	@Override
	protected boolean shouldSkipLocation(Random p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_)
	{
		return false;
	}
}
