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

public class SmallTreeFoliagePlacer extends FoliagePlacer
{
	public static final Codec<SmallTreeFoliagePlacer> CODEC = RecordCodecBuilder.create((foliagePlacer) ->
	{
		return foliagePlacerParts(foliagePlacer).apply(foliagePlacer, SmallTreeFoliagePlacer::new);
	});

	public SmallTreeFoliagePlacer(IntProvider radius, IntProvider offset)
	{
		super(radius, offset);
	}

	@Override
	protected FoliagePlacerType<?> type()
	{
		return FoliagePlacerTypeRegistry.SMALL_TREE_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, TreeConfiguration config, int p_161426_, FoliageAttachment attachment, int foliageHeight, int radius, int offset)
	{
		MutableBlockPos pos = attachment.pos().mutable();

		for (int x = -1; x <= 1; x++)
		{
			for (int z = -1; z <= 1; z++)
			{
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(x, foliageHeight > 2 ? -2 : -1, z));
			}
		}

		if (foliageHeight > 2)
		{
			for (int i = -1; i <= 1; i++)
			{
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, -1, 0));
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, -1, i));
			}

			for (int y = 0; y <= 1; y++)
			{
				tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, y, 0));
			}
		} else
		{
			tryPlaceLeaf(reader, consumer, rand, config, pos.above());
		}
	}

	@Override
	public int foliageHeight(Random rand, int p_68569_, TreeConfiguration p_68570_)
	{
		return 2 + (rand.nextInt(2) == 0 ? 2 : 0);
	}

	@Override
	protected boolean shouldSkipLocation(Random p_68562_, int p_68563_, int p_68564_, int p_68565_, int p_68566_, boolean p_68567_)
	{
		return false;
	}
}
