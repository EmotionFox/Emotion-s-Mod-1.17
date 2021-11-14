package fr.emotion.emomod.world.gen.feature;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class EmoDeadTreeFeature extends AbstractTreeFeature<NoFeatureConfig>
{
	public EmoDeadTreeFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config, boolean doBlockNofityOnPlace)
	{
		super(config, doBlockNofityOnPlace);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldReader, Random rand, BlockPos pos, MutableBoundingBox boundsIn)
	{
		boolean soil = worldReader.hasBlockState(pos.down(), (state) ->
		{
			return state.getBlock() == Blocks.SAND ? true : false;
		});

		if (soil)
		{
			for (int y = 0; y < 6; y++)
			{
				if (isAirOrLeaves(worldReader, pos.add(0, y, 0)))
					setLogState(changedBlocks, worldReader, pos.add(0, y, 0), Blocks.DARK_OAK_LOG.getDefaultState(), boundsIn);
			}

			setBlockState(worldReader, pos.down(), Blocks.DIRT.getDefaultState());

			int chance = 0;
			int[] placeX = new int[]
			{ 1, -1, 0, 0 };
			int[] placeZ = new int[]
			{ 0, 0, -1, 1 };

			Axis dir = Direction.Axis.X;

			for (int y = 0; y < 4; y++)
			{
				if (y > 2)
					dir = Direction.Axis.Z;

				if (rand.nextInt(4 - chance) == 0)
				{
					if (isAirOrLeaves(worldReader, pos.add(placeX[y], y + 1, placeZ[y])))
						setLogState(changedBlocks, worldReader, pos.add(placeX[y], y + 1, placeZ[y]), Blocks.DARK_OAK_LOG.getDefaultState().with(RotatedPillarBlock.AXIS, dir), boundsIn);
				} else
				{
					chance++;
				}
			}

			for (int x = -2; x <= 2; x++)
			{
				for (int z = -2; z <= 2; z++)
				{
					if ((x == -2 || x == 2) && (z == -2 || z == 2))
					{
					} else
					{
						int y = getTop(worldReader, pos.add(x, 0, z));

						if (y != 666)
						{
							setBlockState(worldReader, pos.add(x, y, z), Blocks.PODZOL.getDefaultState());

							if (rand.nextInt(10) == 0)
								setBlockState(worldReader, pos.add(x, y, z).up(), Blocks.DEAD_BUSH.getDefaultState());
						}
					}
				}
			}

			return true;
		}

		return false;
	}

	public int getTop(IWorldGenerationReader worldReader, BlockPos pos)
	{
		for (int y = -4; y < 4; y++)
		{
			boolean soil = worldReader.hasBlockState(pos.add(0, y, 0).down(), (state) ->
			{
				return state.getBlock() == Blocks.SAND ? true : false;
			});

			if (soil && isAir(worldReader, pos.add(0, y, 0)))
				return y - 1;
		}

		// EL DIABLO
		return 666;
	}
}
