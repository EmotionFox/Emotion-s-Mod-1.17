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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class OrchardFoliagePlacer extends FoliagePlacer
{
	public static final Codec<OrchardFoliagePlacer> CODEC = RecordCodecBuilder.create((builder) ->
	{
		return foliagePlacerParts(builder).and(IntProvider.codec(0, 16).fieldOf("trunk_height").forGetter((getter) ->
		{
			return getter.height;
		})).apply(builder, OrchardFoliagePlacer::new);
	});

	private final IntProvider height;

	public OrchardFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider height)
	{
		super(radius, offset);
		this.height = height;
	}

	@Override
	protected FoliagePlacerType<?> type()
	{
		return FoliagePlacerTypeRegistry.ORCHARD_FOLIAGE_PLACER.get();
	}

	@Override
	protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, Random rand, TreeConfiguration config, int p_161426_, FoliageAttachment attachment, int p_161428_, int p_161429_, int p_161430_)
	{
		MutableBlockPos pos = new MutableBlockPos();
		pos.set(attachment.pos());

		for (int a = 1; a <= 3; a++)
		{
			for (int b = 0; b <= 2; b++)
			{
				for (int y = -3; y <= -1; y++)
				{
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(a, y, b));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(-a, y, -b));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(-b, y, a));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(b, y, -a));
				}
			}
		}

		pos.setWithOffset(attachment.pos(), 1, -2, 3);
		tryPlaceLeaf(reader, consumer, rand, config, pos);
		tryPlaceLeaf(reader, consumer, rand, config, pos.east());
		tryPlaceLeaf(reader, consumer, rand, config, pos.above());

		pos.setWithOffset(attachment.pos(), -1, -2, -3);
		tryPlaceLeaf(reader, consumer, rand, config, pos);
		tryPlaceLeaf(reader, consumer, rand, config, pos.west());
		tryPlaceLeaf(reader, consumer, rand, config, pos.above());

		pos.setWithOffset(attachment.pos(), 3, -2, -1);
		tryPlaceLeaf(reader, consumer, rand, config, pos);
		tryPlaceLeaf(reader, consumer, rand, config, pos.north());
		tryPlaceLeaf(reader, consumer, rand, config, pos.above());

		pos.setWithOffset(attachment.pos(), -3, -2, 1);
		tryPlaceLeaf(reader, consumer, rand, config, pos);
		tryPlaceLeaf(reader, consumer, rand, config, pos.south());
		tryPlaceLeaf(reader, consumer, rand, config, pos.above());

		pos.set(attachment.pos());

		for (int a = -2; a <= 2; a++)
		{
			for (int y = 0; y <= 1; y++)
			{
				for (int b = -1; b <= 1; b++)
				{
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(a, y, b));
					tryPlaceLeaf(reader, consumer, rand, config, pos.offset(b, y, a));
				}
			}
		}

		for (int x = -1; x <= 1; x++)
		{
			for (int z = -1; z <= 1; z++)
			{
				if (TreeFeature.validTreePos(reader, pos.offset(x, -3, z)))
					consumer.accept(pos.offset(x, -3, z), Blocks.AIR.defaultBlockState());
			}
		}

		for (int i = -3; i <= 3; i++)
		{
			tryPlaceLeaf(reader, consumer, rand, config, pos.offset(i, 0, 0));
			tryPlaceLeaf(reader, consumer, rand, config, pos.offset(0, 0, i));

			if (i != -3 && i != 3)
			{
				if (TreeFeature.validTreePos(reader, pos.offset(i, -2, 0)))
					consumer.accept(pos, config.trunkProvider.getState(rand, pos.offset(i, -2, 0)).setValue(net.minecraft.world.level.block.RotatedPillarBlock.AXIS, net.minecraft.core.Direction.Axis.X));
				if (TreeFeature.validTreePos(reader, pos.offset(0, -2, i)))
					consumer.accept(pos, config.trunkProvider.getState(rand, pos.offset(0, -2, i)).setValue(net.minecraft.world.level.block.RotatedPillarBlock.AXIS, net.minecraft.core.Direction.Axis.X));
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
